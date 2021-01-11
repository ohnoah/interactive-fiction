import com.enhanced.parser.SimpleBooleanLexer;
import java.util.ArrayList;
import java.util.List;
import com.enhanced.parser.SimpleBooleanParser;
import com.enhanced.parser.SimpleBooleanBaseVisitor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.jetbrains.annotations.NotNull;


public class ConditionEvaluationVisitor extends SimpleBooleanBaseVisitor<Object> {

   private KnowledgeBase knowledgeBase;

   public ConditionEvaluationVisitor(@NotNull KnowledgeBase knowledgeBase) {
      this.knowledgeBase = knowledgeBase;
   }

   @Override
   public Boolean visitParse(SimpleBooleanParser.ParseContext ctx) {
      return (Boolean) super.visit(ctx.expression());
   }

   private List<String> frameAndSlot(String text) throws RuntimeKnowledgeException {
      String knowledgeRegex = KnowledgeRegex.knowledgeExpr;
      Pattern p = Pattern.compile(knowledgeRegex);
      Matcher m = p.matcher(text);
      if (m.matches()) {
         String frame = m.group(1);
         String slot = m.group(2);
         return List.of(frame, slot);
      }
      else {
         throw new RuntimeKnowledgeException("Invalid syntax for query: " + text);
      }
   }


   // AUTO INSERT


   @Override
   public List<?> visitList(SimpleBooleanParser.ListContext ctx) {
      if (ctx.IDENTIFIER() != null) {
         List<String> frameAndSlot = frameAndSlot(ctx.IDENTIFIER().getText());
         try {
            return knowledgeBase.queryList(frameAndSlot.get(0), frameAndSlot.get(1));
         } catch (KnowledgeException e) {
            throw new RuntimeKnowledgeException(e.getMessage(), e);
         } catch (MissingKnowledgeException e) {
            throw new RuntimeMissingException(e.getMessage(), e, e.getMissingString());
         }
      }
      else if (ctx.numberlist() != null) {
         return visitNumberlist(ctx.numberlist());
      }
      else {
         return visitStringlist(ctx.stringlist());
      }

   }

   @Override
   public List<String> visitStringlist(SimpleBooleanParser.StringlistContext ctx) {
      return ctx.stringelems() == null ? new ArrayList<>() : this.visitStringelems(ctx.stringelems());
   }

   @Override
   public List<Double> visitNumberlist(SimpleBooleanParser.NumberlistContext ctx) {
      return ctx.numberelems() == null ? new ArrayList<>() : this.visitNumberelems(ctx.numberelems());
   }

   @Override
   public List<String> visitStringelems(SimpleBooleanParser.StringelemsContext ctx) {
      List<String> stringList = new ArrayList<>();
      for (SimpleBooleanParser.StringtypeContext elemContext : ctx.stringtype()) {
         stringList.add(this.visitStringtype(elemContext));
      }
      return stringList;
   }

   @Override
   public List<Double> visitNumberelems(SimpleBooleanParser.NumberelemsContext ctx) {
      List<Double> doubleList = new ArrayList<>();
      for (SimpleBooleanParser.NumbertypeContext elemContext : ctx.numbertype()) {
         doubleList.add(this.visitNumbertype(elemContext));
      }
      return doubleList;
   }

   @Override
   public Double visitNumbertype(SimpleBooleanParser.NumbertypeContext ctx) {
      TerminalNode decimal = ctx.DECIMAL();
      TerminalNode identifier = ctx.IDENTIFIER();
      if (decimal != null) {
         return Double.valueOf(decimal.getText());
      }
      else {
         try {
            List<String> frameAndSlot = frameAndSlot(identifier.getText());
            return knowledgeBase.queryDouble(frameAndSlot.get(0), frameAndSlot.get(1));
         } catch (KnowledgeException e) {
            throw new RuntimeKnowledgeException(e.getMessage(), e);
         } catch (MissingKnowledgeException e) {
            throw new RuntimeMissingException(e.getMessage(), e, e.getMissingString());
         }
      }
   }

   @Override
   public String visitStringtype(SimpleBooleanParser.StringtypeContext ctx) {
      TerminalNode string = ctx.STRING();
      TerminalNode identifier = ctx.IDENTIFIER();
      if (string != null) {
         return ctx.getText().substring(1, ctx.getText().length() - 1);
      }
      else {
         try {
            List<String> frameAndSlot = frameAndSlot(identifier.getText());
            return knowledgeBase.queryString(frameAndSlot.get(0), frameAndSlot.get(1));
         } catch (KnowledgeException e) {
            throw new RuntimeKnowledgeException(e.getMessage(), e);
         } catch (MissingKnowledgeException e) {
            throw new RuntimeMissingException(e.getMessage(), e, e.getMissingString());
         }
      }
   }

   @Override
   public Boolean visitStringInBooleantype(SimpleBooleanParser.StringInBooleantypeContext ctx) {
      return this.visitList(ctx.list()).contains(this.visitStringtype(ctx.stringtype()));
   }

   @Override
   public Boolean visitNumberInBooleantype(SimpleBooleanParser.NumberInBooleantypeContext ctx) {
      return this.visitList(ctx.list()).contains(this.visitNumbertype(ctx.numbertype()));
   }

   @Override
   public Boolean visitBoolcomparatorBooleantype(SimpleBooleanParser.BoolcomparatorBooleantypeContext ctx) {
      if (ctx.op.EQ() != null) {
         Boolean left = (Boolean) this.visit(ctx.left);
         Boolean right = (Boolean) this.visit(ctx.right);
         return left.equals(right);
      }
      throw new RuntimeKnowledgeException("not implemented: comparator operator " + ctx.op.getText());
   }

   @Override
   public Boolean visitBinaryBooleantype(SimpleBooleanParser.BinaryBooleantypeContext ctx) {
      if (ctx.op.AND() != null) {
         return asBoolean(ctx.left) && asBoolean(ctx.right);
      }
      else if (ctx.op.OR() != null) {
         return asBoolean(ctx.left) || asBoolean(ctx.right);
      }
      throw new RuntimeKnowledgeException("not implemented: binary operator " + ctx.op.getText());
   }


   @Override
   public Boolean visitIdentifierBooleantype(SimpleBooleanParser.IdentifierBooleantypeContext ctx) {
      try {
         List<String> frameAndSlot = frameAndSlot(ctx.IDENTIFIER().getText());
         return knowledgeBase.queryBoolean(frameAndSlot.get(0), frameAndSlot.get(1));
      } catch (KnowledgeException e) {
         throw new RuntimeKnowledgeException(e.getMessage(), e);
      } catch (MissingKnowledgeException e) {
         throw new RuntimeMissingException(e.getMessage(), e, e.getMissingString());
      }
   }

   @Override
   public Boolean visitBoolBooleantype(SimpleBooleanParser.BoolBooleantypeContext ctx) {
      return Boolean.valueOf(ctx.getText());
   }

   @Override
   public Boolean visitListComparatorBooleantype(SimpleBooleanParser.ListComparatorBooleantypeContext ctx) {
      return this.visitList(ctx.left).equals(this.visitList(ctx.right));
   }

   @Override
   public Boolean visitStringComparatorBooleantype(SimpleBooleanParser.StringComparatorBooleantypeContext ctx) {
      if (ctx.op.EQ() != null) {
         String left = asString(ctx.left);
         String right = asString(ctx.right);
         return left.equals(right);
      }
      else if (ctx.op.LE() != null) {
         return asString(ctx.left).compareTo(asString(ctx.right)) <= 0;
      }
      else if (ctx.op.GE() != null) {
         return asString(ctx.left).compareTo(asString(ctx.right)) >= 0;
      }
      else if (ctx.op.LT() != null) {
         return asString(ctx.left).compareTo(asString(ctx.right)) < 0;
      }
      else if (ctx.op.GT() != null) {
         return asString(ctx.left).compareTo(asString(ctx.right)) > 0;
      }
      throw new RuntimeException("not implemented: comparator operator " + ctx.op.getText());
   }

   @Override
   public Boolean visitNumberComparatorBooleantype(SimpleBooleanParser.NumberComparatorBooleantypeContext ctx) {
      if (ctx.op.EQ() != null) {
         return asDouble(ctx.left) == (asDouble(ctx.right));
      }
      else if (ctx.op.LE() != null) {
         return asDouble(ctx.left) <= asDouble(ctx.right);
      }
      else if (ctx.op.GE() != null) {
         return asDouble(ctx.left) >= asDouble(ctx.right);
      }
      else if (ctx.op.LT() != null) {
         return asDouble(ctx.left) < asDouble(ctx.right);
      }
      else if (ctx.op.GT() != null) {
         return asDouble(ctx.left) > asDouble(ctx.right);
      }
      throw new RuntimeException("not implemented: binary operator " + ctx.op.getText());
   }

   @Override
   public Boolean visitBooleantypeExpression(SimpleBooleanParser.BooleantypeExpressionContext ctx) {
      return (Boolean) this.visit(ctx.booleantype());
   }


   @Override
   public Object visitParenBooleanType(SimpleBooleanParser.ParenBooleanTypeContext ctx) {
      return this.visit(ctx.booleantype());
   }

   @Override
   public Object visitNotBooleanType(SimpleBooleanParser.NotBooleanTypeContext ctx) {
      return !((Boolean) this.visit(ctx.booleantype()));
   }


   /// SDSDSDS


/*      @Override
      public Object visitDecimalExpression(SimpleBooleanParser.DecimalExpressionContext ctx) {
         return Double.valueOf(ctx.DECIMAL().getText());
      }


      @Override
      public Object visitStringExpression(SimpleBooleanParser.StringExpressionContext ctx){
         return ctx.STRING().getText();
      }


      @Override
      public Object visitIdentifierExpression(SimpleBooleanParser.IdentifierExpressionContext ctx) {
         return replaceIdentifier(ctx.IDENTIFIER().getText());
      }


      @Override
      public Object visitParenExpression(SimpleBooleanParser.ParenExpressionContext ctx) {
         return super.visit(ctx.expression());
      }

      @Override
      public Object visitComparatorExpression(SimpleBooleanParser.ComparatorExpressionContext ctx) {
         if (ctx.op.EQ() != null) {
            return this.visit(ctx.left).equals(this.visit(ctx.right));
         }
         else if (ctx.op.LE() != null) {
            return asDouble(ctx.left) <= asDouble(ctx.right);
         }
         else if (ctx.op.GE() != null) {
            return asDouble(ctx.left) >= asDouble(ctx.right);
         }
         else if (ctx.op.LT() != null) {
            return asDouble(ctx.left) < asDouble(ctx.right);
         }
         else if (ctx.op.GT() != null) {
            return asDouble(ctx.left) > asDouble(ctx.right);
         }
         throw new RuntimeException("not implemented: comparator operator " + ctx.op.getText());
      }

      @Override
      public Object visitBinaryExpression(SimpleBooleanParser.BinaryExpressionContext ctx) {
         if (ctx.op.AND() != null) {
            return asBoolean(ctx.left) && asBoolean(ctx.right);
         }
         else if (ctx.op.OR() != null) {
            return asBoolean(ctx.left) || asBoolean(ctx.right);
         }
         throw new RuntimeException("not implemented: binary operator " + ctx.op.getText());
      }
      @Override
      public Object visitBoolExpression(SimpleBooleanParser.BoolExpressionContext ctx) {
         return Boolean.valueOf(ctx.getText());
      }*/

   private boolean asBoolean(SimpleBooleanParser.BooleantypeContext ctx) {
      return (boolean) visit(ctx);
   }

   private double asDouble(SimpleBooleanParser.NumbertypeContext ctx) {
      return (double) visit(ctx);
   }

   private String asString(SimpleBooleanParser.StringtypeContext ctx) {
      return (String) visit(ctx);
   }

   private List<?> asList(SimpleBooleanParser.ListContext ctx) {
      return (List<?>) visit(ctx);
   }

   public static void main(String[] args) {

   }

}
