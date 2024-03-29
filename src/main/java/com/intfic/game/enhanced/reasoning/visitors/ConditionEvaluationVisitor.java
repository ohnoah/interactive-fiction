package com.intfic.game.enhanced.reasoning.visitors;

import com.intfic.game.enhanced.reasoning.KnowledgeBase;
import com.intfic.game.enhanced.reasoning.KnowledgeRegex;
import com.intfic.game.enhanced.reasoning.error.*;
import com.intfic.game.enhanced.reasoning.frames.GenericFrame;
import com.intfic.game.enhanced.reasoning.frames.SpecificFrame;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.intfic.game.enhanced.parser.BooleanParser;
import com.intfic.game.enhanced.parser.BooleanBaseVisitor;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.jetbrains.annotations.NotNull;


public class ConditionEvaluationVisitor extends BooleanBaseVisitor<Object> implements Serializable {

   private static final long serialVersionUID = -4122568509603815191L;
   private KnowledgeBase knowledgeBase;

   public ConditionEvaluationVisitor(@NotNull KnowledgeBase knowledgeBase) {
      this.knowledgeBase = knowledgeBase;
   }

   @Override
   public Boolean visitParse(BooleanParser.ParseContext ctx) {
      return (Boolean) super.visit(ctx.expression());
   }

   private List<String> frameAndSlot(String text) throws RuntimeKnowledgeException {
      String knowledgeRegex = KnowledgeRegex.KNOWLEDGE_EXPR;
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
   public List<?> visitList(BooleanParser.ListContext ctx) {
      if (ctx.IDENTIFIER() != null) {
         List<String> frameAndSlot = frameAndSlot(ctx.IDENTIFIER().getText());
         try {
            return knowledgeBase.queryList(frameAndSlot.get(0), frameAndSlot.get(1));
         }
         catch (KnowledgeException e) {
            throw new RuntimeKnowledgeException(e.getMessage(), e);
         }
         catch (MissingKnowledgeException e) {
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
   public List<String> visitStringlist(BooleanParser.StringlistContext ctx) {
      return ctx.stringelems() == null ? new ArrayList<>() : this.visitStringelems(ctx.stringelems());
   }

   @Override
   public List<Double> visitNumberlist(BooleanParser.NumberlistContext ctx) {
      return ctx.numberelems() == null ? new ArrayList<>() : this.visitNumberelems(ctx.numberelems());
   }

   @Override
   public List<String> visitStringelems(BooleanParser.StringelemsContext ctx) {
      List<String> stringList = new ArrayList<>();
      for (BooleanParser.StringtypeContext elemContext : ctx.stringtype()) {
         stringList.add(this.visitStringtype(elemContext));
      }
      return stringList;
   }

   @Override
   public List<Double> visitNumberelems(BooleanParser.NumberelemsContext ctx) {
      List<Double> doubleList = new ArrayList<>();
      for (BooleanParser.NumbertypeContext elemContext : ctx.numbertype()) {
         doubleList.add(this.visitNumbertype(elemContext));
      }
      return doubleList;
   }

   @Override
   public Double visitNumbertype(BooleanParser.NumbertypeContext ctx) {
      TerminalNode decimal = ctx.DECIMAL();
      TerminalNode identifier = ctx.IDENTIFIER();
      if (decimal != null) {
         return Double.valueOf(decimal.getText());
      }
      else {
         try {
            List<String> frameAndSlot = frameAndSlot(identifier.getText());
            return knowledgeBase.queryDouble(frameAndSlot.get(0), frameAndSlot.get(1));
         }
         catch (KnowledgeException e) {
            throw new RuntimeKnowledgeException(e.getMessage(), e);
         }
         catch (MissingKnowledgeException e) {
            throw new RuntimeMissingException(e.getMessage(), e, e.getMissingString());
         }
      }
   }

   @Override
   public String visitStringtype(BooleanParser.StringtypeContext ctx) {
      TerminalNode string = ctx.STRING();
      TerminalNode identifier = ctx.IDENTIFIER();
      if (string != null) {
         return ctx.getText().substring(1, ctx.getText().length() - 1);
      }
      else {
         try {
            List<String> frameAndSlot = frameAndSlot(identifier.getText());
            return knowledgeBase.queryString(frameAndSlot.get(0), frameAndSlot.get(1));
         }
         catch (KnowledgeException e) {
            throw new RuntimeKnowledgeException(e.getMessage(), e);
         }
         catch (MissingKnowledgeException e) {
            throw new RuntimeMissingException(e.getMessage(), e, e.getMissingString());
         }
      }
   }

   @Override
   public Boolean visitStringInBooleantype(BooleanParser.StringInBooleantypeContext ctx) {
      List<?> list = this.visitList(ctx.list());
      String s = this.visitStringtype(ctx.stringtype());
      return list.contains(s);
   }

   @Override
   public Boolean visitNumberInBooleantype(BooleanParser.NumberInBooleantypeContext ctx) {
      List<?> list = this.visitList(ctx.list());
      Double s = this.visitNumbertype(ctx.numbertype());
      return list.contains(s);
   }


   @Override
   public Boolean visitBinaryBooleantype(BooleanParser.BinaryBooleantypeContext ctx) {
      if (ctx.op.AND() != null) {
         return asBoolean(ctx.left) && asBoolean(ctx.right);
      }
      else if (ctx.op.OR() != null) {
         return asBoolean(ctx.left) || asBoolean(ctx.right);
      }
      throw new RuntimeKnowledgeException("not implemented: binary operator " + ctx.op.getText());
   }


   @Override
   public Boolean visitIdentifierBooleantype(BooleanParser.IdentifierBooleantypeContext ctx) {
      try {
         List<String> frameAndSlot = frameAndSlot(ctx.IDENTIFIER().getText());
         return knowledgeBase.queryBoolean(frameAndSlot.get(0), frameAndSlot.get(1));
      }
      catch (KnowledgeException e) {
         throw new RuntimeKnowledgeException(e.getMessage(), e);
      }
      catch (MissingKnowledgeException e) {
         throw new RuntimeMissingException(e.getMessage(), e, e.getMissingString());
      }
   }

   @Override
   public Boolean visitBoolBooleantype(BooleanParser.BoolBooleantypeContext ctx) {
      return Boolean.valueOf(ctx.getText());
   }

   @Override
   public Boolean visitIdentifierComparatorBooleantype(BooleanParser.IdentifierComparatorBooleantypeContext ctx) {
      // TODO: Change this to a helper function that does query and slot in one go
      List<String> leftFrameAndSlot = frameAndSlot(ctx.left.getText());
      List<String> rightFrameAndSlot = frameAndSlot(ctx.right.getText());
      Object left;
      try {
         left = knowledgeBase.query(leftFrameAndSlot.get(0), leftFrameAndSlot.get(1));
         if (left instanceof String) {
            String right = knowledgeBase.queryString(rightFrameAndSlot.get(0), rightFrameAndSlot.get(1));
            return stringComparatorBooleanType(ctx.op, (String) left, right);
         }
         else if (left instanceof Double) {
            Double right = knowledgeBase.queryDouble(rightFrameAndSlot.get(0), rightFrameAndSlot.get(1));
            return numberComparatorBooleanType(ctx.op, (double) left, right);
         }
         else {
            throw new RuntimeKnowledgeException("The left argument " + ctx.left.getText() + "was neither String or Number " +
                "but the comparator " + ctx.op.getText() + " is only for String and Number types.");
         }
      }
      catch (KnowledgeException e) {
         throw new RuntimeKnowledgeException(e.getMessage(), e);
      }
      catch (MissingKnowledgeException e) {
         throw new RuntimeMissingException(e.getMessage(), e, e.getMissingString());
      }
   }

   @Override
   public Boolean visitListComparatorBooleantype(BooleanParser.ListComparatorBooleantypeContext ctx) {
      return this.visitList(ctx.left).equals(this.visitList(ctx.right));
   }

   private Boolean stringComparatorBooleanType(BooleanParser.NonboolcomparatorContext op, String left, String right) {
      if (op.EQ() != null) {
         return left.equals(right);
      }
      else if (op.LE() != null) {
         return left.compareTo(right) <= 0;
      }
      else if (op.GE() != null) {
         return left.compareTo(right) >= 0;
      }
      else if (op.LT() != null) {
         return left.compareTo(right) < 0;
      }
      else if (op.GT() != null) {
         return left.compareTo(right) > 0;
      }
      throw new RuntimeKnowledgeException("not implemented: comparator operator " + op.getText());
   }

   @Override
   public Boolean visitStringComparatorBooleantype(BooleanParser.StringComparatorBooleantypeContext ctx) {
      return stringComparatorBooleanType(ctx.op, asString(ctx.left), asString(ctx.right));
/*      if (ctx.op.EQ() != null) {
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
      throw new RuntimeException("not implemented: comparator operator " + ctx.op.getText());*/
   }

   private Boolean numberComparatorBooleanType(BooleanParser.NonboolcomparatorContext op, double left, double right) {
      if (op.EQ() != null) {
         return left == (right);
      }
      else if (op.LE() != null) {
         return left <= right;
      }
      else if (op.GE() != null) {
         return left >= right;
      }
      else if (op.LT() != null) {
         return left < right;
      }
      else if (op.GT() != null) {
         return left > right;
      }
      throw new RuntimeKnowledgeException("not implemented: number binary comparator " + op.getText());
   }

   @Override
   public Boolean visitNumberComparatorBooleantype(BooleanParser.NumberComparatorBooleantypeContext ctx) {
      return numberComparatorBooleanType(ctx.op, asDouble(ctx.left), asDouble(ctx.right));
/*      if (ctx.op.EQ() != null) {
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
      throw new com.interactivefiction.game.enhanced.reasoning.exceptions.RuntimeKnowledgeException("not implemented: binary operator " + ctx.op.getText());*/
   }

   @Override
   public Boolean visitBooleantypeExpression(BooleanParser.BooleantypeExpressionContext ctx) {
      return (Boolean) this.visit(ctx.booleantype());
   }


   @Override
   public Object visitParenBooleanType(BooleanParser.ParenBooleanTypeContext ctx) {
      return this.visit(ctx.booleantype());
   }

   @Override
   public Boolean visitNotBooleanType(BooleanParser.NotBooleanTypeContext ctx) {
      return !((Boolean) this.visit(ctx.booleantype()));
   }

   @Override
   public Boolean visitInheritBooleantype(BooleanParser.InheritBooleantypeContext ctx) {
      List<String> frameNames = ctx.stringtype().stream().map(this::visitStringtype).collect(Collectors.toList());
      Map<String, SpecificFrame> specificFrameMap = knowledgeBase.getSpecificFrames();
      Map<String, GenericFrame> genericFrameMap = knowledgeBase.getGenericFrames();
      if (specificFrameMap.containsKey(frameNames.get(0)) && genericFrameMap.containsKey(frameNames.get(1))) {
         SpecificFrame s1 = specificFrameMap.get(frameNames.get(0));
         GenericFrame s2 = genericFrameMap.get(frameNames.get(1));
         return s1.getSlots().keySet().containsAll(s2.getSlots().keySet());
      }
      else {
         throw new RuntimeKnowledgeException(String.format("Couldn't check for inheritance for specific" +
             " frame: %s and generic frame %s when running query %s because one of those frames" +
             " is not in the KB", frameNames.get(0), frameNames.get(1), ctx.getText()));
      }

   }
   /// SDSDSDS


/*      @Override
      public Object visitDecimalExpression(BooleanParser.DecimalExpressionContext ctx) {
         return Double.valueOf(ctx.DECIMAL().getText());
      }


      @Override
      public Object visitStringExpression(BooleanParser.StringExpressionContext ctx){
         return ctx.STRING().getText();
      }


      @Override
      public Object visitIdentifierExpression(BooleanParser.IdentifierExpressionContext ctx) {
         return replaceIdentifier(ctx.IDENTIFIER().getText());
      }


      @Override
      public Object visitParenExpression(BooleanParser.ParenExpressionContext ctx) {
         return super.visit(ctx.expression());
      }

      @Override
      public Object visitComparatorExpression(BooleanParser.ComparatorExpressionContext ctx) {
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
      public Object visitBinaryExpression(BooleanParser.BinaryExpressionContext ctx) {
         if (ctx.op.AND() != null) {
            return asBoolean(ctx.left) && asBoolean(ctx.right);
         }
         else if (ctx.op.OR() != null) {
            return asBoolean(ctx.left) || asBoolean(ctx.right);
         }
         throw new RuntimeException("not implemented: binary operator " + ctx.op.getText());
      }
      @Override
      public Object visitBoolExpression(BooleanParser.BoolExpressionContext ctx) {
         return Boolean.valueOf(ctx.getText());
      }*/

   private boolean asBoolean(BooleanParser.BooleantypeContext ctx) {
      return (boolean) visit(ctx);
   }

   private double asDouble(BooleanParser.NumbertypeContext ctx) {
      return (double) visit(ctx);
   }

   private String asString(BooleanParser.StringtypeContext ctx) {
      return (String) visit(ctx);
   }


   private List<?> asList(BooleanParser.ListContext ctx) {
      return (List<?>) visit(ctx);
   }


}
