import com.enhanced.parser.SimpleBooleanLexer;
import com.enhanced.parser.SimpleBooleanParser;
import com.enhanced.typeconverter.ConstantsBaseVisitor;
import com.enhanced.typeconverter.ConstantsLexer;
import com.enhanced.typeconverter.ConstantsParser;
import java.util.ArrayList;
import java.util.List;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.TerminalNode;

public class TypeConvertVisitor extends ConstantsBaseVisitor<Object> {
   @Override
   public Object visitTypeconvert(ConstantsParser.TypeconvertContext ctx) {
      return super.visit(ctx.expression());
   }

   @Override
   public List<String> visitStringelemsExpression(ConstantsParser.StringelemsExpressionContext ctx) {
      return ctx.stringelems() == null ? new ArrayList<>() : this.visitStringelems(ctx.stringelems());
   }

   @Override
   public List<Double> visitNumberelemsExpression(ConstantsParser.NumberelemsExpressionContext ctx) {
      return ctx.numberelems() == null ? new ArrayList<>() : this.visitNumberelems(ctx.numberelems());
   }

   @Override
   public String visitStringExpression(ConstantsParser.StringExpressionContext ctx) {
      return ctx.STRING().getText().replace("\"", "");
   }

   @Override
   public Double visitDecimalExpression(ConstantsParser.DecimalExpressionContext ctx) {
      return Double.valueOf(ctx.DECIMAL().getText());
   }

   @Override
   public List<String> visitStringelems(ConstantsParser.StringelemsContext ctx) {
      List<String> stringList = new ArrayList<>();
      for (TerminalNode t : ctx.STRING()) {
         stringList.add(t.getText());
      }
      return stringList;
   }

   @Override
   public List<Double> visitNumberelems(ConstantsParser.NumberelemsContext ctx) {
      List<Double> doubleList = new ArrayList<>();
      for (TerminalNode t : ctx.DECIMAL()) {
         doubleList.add(Double.valueOf(t.getText()));
      }
      return doubleList;
   }


   public static void main(String[] args) {
      String expression = "[1,2,3.1]";
      String expression2 = "\"I like pizza.\"";
      ConstantsLexer lexer = new ConstantsLexer(CharStreams.fromString(expression));
      ConstantsParser parser = new ConstantsParser(new CommonTokenStream(lexer));
      ConstantsLexer lexer2 = new ConstantsLexer(CharStreams.fromString(expression2));
      ConstantsParser parser2 = new ConstantsParser(new CommonTokenStream(lexer2));
      TypeConvertVisitor typeConvertVisitor = new TypeConvertVisitor();
      Object result = typeConvertVisitor.visit(parser.typeconvert());
      Object result2 = typeConvertVisitor.visit(parser2.typeconvert());
      System.out.printf("%-70s -> %s\n", expression, result);
      System.out.printf("%-70s -> %s\n", expression2, result2);
   }
}
