// Generated from /Users/noahohrner/OneDrive - University of Cambridge/Dissertation/Code/interactive-fiction/Constants.g4 by ANTLR 4.9
package com.intfic.game.enhanced.typeconverter;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ConstantsParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ConstantsVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ConstantsParser#typeconvert}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeconvert(ConstantsParser.TypeconvertContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringelemsExpression}
	 * labeled alternative in {@link ConstantsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringelemsExpression(ConstantsParser.StringelemsExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numberelemsExpression}
	 * labeled alternative in {@link ConstantsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberelemsExpression(ConstantsParser.NumberelemsExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringExpression}
	 * labeled alternative in {@link ConstantsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringExpression(ConstantsParser.StringExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code decimalExpression}
	 * labeled alternative in {@link ConstantsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecimalExpression(ConstantsParser.DecimalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolExpression}
	 * labeled alternative in {@link ConstantsParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolExpression(ConstantsParser.BoolExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConstantsParser#stringelems}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringelems(ConstantsParser.StringelemsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConstantsParser#numberelems}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberelems(ConstantsParser.NumberelemsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConstantsParser#bool}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool(ConstantsParser.BoolContext ctx);
}