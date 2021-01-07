// Generated from /Users/noahohrner/OneDrive - University of Cambridge/Dissertation/Code/interactive-fiction/Constants.g4 by ANTLR 4.9
package com.enhanced.typeconverter;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ConstantsParser}.
 */
public interface ConstantsListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ConstantsParser#typeconvert}.
	 * @param ctx the parse tree
	 */
	void enterTypeconvert(ConstantsParser.TypeconvertContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConstantsParser#typeconvert}.
	 * @param ctx the parse tree
	 */
	void exitTypeconvert(ConstantsParser.TypeconvertContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringelemsExpression}
	 * labeled alternative in {@link ConstantsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterStringelemsExpression(ConstantsParser.StringelemsExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringelemsExpression}
	 * labeled alternative in {@link ConstantsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitStringelemsExpression(ConstantsParser.StringelemsExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberelemsExpression}
	 * labeled alternative in {@link ConstantsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNumberelemsExpression(ConstantsParser.NumberelemsExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberelemsExpression}
	 * labeled alternative in {@link ConstantsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNumberelemsExpression(ConstantsParser.NumberelemsExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringExpression}
	 * labeled alternative in {@link ConstantsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterStringExpression(ConstantsParser.StringExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringExpression}
	 * labeled alternative in {@link ConstantsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitStringExpression(ConstantsParser.StringExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code decimalExpression}
	 * labeled alternative in {@link ConstantsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDecimalExpression(ConstantsParser.DecimalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code decimalExpression}
	 * labeled alternative in {@link ConstantsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDecimalExpression(ConstantsParser.DecimalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolExpression}
	 * labeled alternative in {@link ConstantsParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBoolExpression(ConstantsParser.BoolExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolExpression}
	 * labeled alternative in {@link ConstantsParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBoolExpression(ConstantsParser.BoolExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConstantsParser#stringelems}.
	 * @param ctx the parse tree
	 */
	void enterStringelems(ConstantsParser.StringelemsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConstantsParser#stringelems}.
	 * @param ctx the parse tree
	 */
	void exitStringelems(ConstantsParser.StringelemsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConstantsParser#numberelems}.
	 * @param ctx the parse tree
	 */
	void enterNumberelems(ConstantsParser.NumberelemsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConstantsParser#numberelems}.
	 * @param ctx the parse tree
	 */
	void exitNumberelems(ConstantsParser.NumberelemsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConstantsParser#bool}.
	 * @param ctx the parse tree
	 */
	void enterBool(ConstantsParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConstantsParser#bool}.
	 * @param ctx the parse tree
	 */
	void exitBool(ConstantsParser.BoolContext ctx);
}