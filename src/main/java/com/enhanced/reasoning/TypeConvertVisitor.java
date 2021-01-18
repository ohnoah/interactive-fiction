package com.enhanced.reasoning;

import com.enhanced.typeconverter.ConstantsBaseVisitor;
import com.enhanced.typeconverter.ConstantsParser;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.antlr.v4.runtime.tree.TerminalNode;

public class TypeConvertVisitor extends ConstantsBaseVisitor<Object> implements Serializable {
   @Override
   public Object visitBoolExpression(ConstantsParser.BoolExpressionContext ctx) {
      return this.visitBool(ctx.bool());
   }

   @Override
   public String visitStringExpression(ConstantsParser.StringExpressionContext ctx) {
      return ctx.getText().substring(1, ctx.getText().length() - 1);
   }

   @Override
   public Double visitDecimalExpression(ConstantsParser.DecimalExpressionContext ctx) {
      return Double.valueOf(ctx.getText());
   }

   @Override
   public Boolean visitBool(ConstantsParser.BoolContext ctx) {
      return ctx.TRUE() != null;
   }

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
   public List<String> visitStringelems(ConstantsParser.StringelemsContext ctx) {
      List<String> stringList = new ArrayList<>();
      for (TerminalNode t : ctx.STRING()) {
         stringList.add(t.getText().substring(1, t.getText().length() - 1));
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
      TypeConvertVisitor typeConvertVisitor = new TypeConvertVisitor();
      Object result = VisitorHelper.typeConvert(typeConvertVisitor, expression);
      Object result2 = VisitorHelper.typeConvert(typeConvertVisitor, expression2);
      System.out.printf("%-70s -> %s\n", expression, result);
      System.out.printf("%-70s -> %s\n", expression2, result2);
   }
}
