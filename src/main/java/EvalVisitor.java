import java.util.Map;
import com.enhanced.parser.SimpleBooleanParser;
import com.enhanced.parser.SimpleBooleanBaseVisitor;
import org.jetbrains.annotations.NotNull;


public class EvalVisitor extends SimpleBooleanBaseVisitor<Object> {

   private KnowledgeBase knowledgeBase;

   public EvalVisitor(@NotNull KnowledgeBase knowledgeBase) {
      this.knowledgeBase = knowledgeBase;
   }

   @Override
      public Object visitParse(SimpleBooleanParser.ParseContext ctx) {
         return super.visit(ctx.expression());
      }

      @Override
      public Object visitDecimalExpression(SimpleBooleanParser.DecimalExpressionContext ctx) {
         return Double.valueOf(ctx.DECIMAL().getText());
      }

      @Override
      public Object visitIdentifierExpression(SimpleBooleanParser.IdentifierExpressionContext ctx) {
         return knowledgeBase.query((ctx.IDENTIFIER().getText()));
      }

      @Override
      public Object visitNotExpression(SimpleBooleanParser.NotExpressionContext ctx) {
         return !((Boolean)this.visit(ctx.expression()));
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
      }

      private boolean asBoolean(SimpleBooleanParser.ExpressionContext ctx) {
         return (boolean)visit(ctx);
      }

      private double asDouble(SimpleBooleanParser.ExpressionContext ctx) {
         return (double)visit(ctx);
      }


}
