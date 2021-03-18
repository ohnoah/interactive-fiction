// Generated from /Users/noahohrner/OneDrive - University of Cambridge/Dissertation/Code/interactive-fiction/SimpleBoolean.g4 by ANTLR 4.9.1
package com.intfic.game.enhanced.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SimpleBooleanParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SimpleBooleanVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SimpleBooleanParser#parse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParse(SimpleBooleanParser.ParseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleBooleanParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList(SimpleBooleanParser.ListContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleBooleanParser#stringlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringlist(SimpleBooleanParser.StringlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleBooleanParser#numberlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberlist(SimpleBooleanParser.NumberlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleBooleanParser#stringelems}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringelems(SimpleBooleanParser.StringelemsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleBooleanParser#numberelems}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberelems(SimpleBooleanParser.NumberelemsContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleBooleanParser#numbertype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumbertype(SimpleBooleanParser.NumbertypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleBooleanParser#stringtype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringtype(SimpleBooleanParser.StringtypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringInBooleantype}
	 * labeled alternative in {@link SimpleBooleanParser#booleantype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringInBooleantype(SimpleBooleanParser.StringInBooleantypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenBooleanType}
	 * labeled alternative in {@link SimpleBooleanParser#booleantype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenBooleanType(SimpleBooleanParser.ParenBooleanTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryBooleantype}
	 * labeled alternative in {@link SimpleBooleanParser#booleantype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryBooleantype(SimpleBooleanParser.BinaryBooleantypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numberInBooleantype}
	 * labeled alternative in {@link SimpleBooleanParser#booleantype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberInBooleantype(SimpleBooleanParser.NumberInBooleantypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notBooleanType}
	 * labeled alternative in {@link SimpleBooleanParser#booleantype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotBooleanType(SimpleBooleanParser.NotBooleanTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code identifierBooleantype}
	 * labeled alternative in {@link SimpleBooleanParser#booleantype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierBooleantype(SimpleBooleanParser.IdentifierBooleantypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolBooleantype}
	 * labeled alternative in {@link SimpleBooleanParser#booleantype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolBooleantype(SimpleBooleanParser.BoolBooleantypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code identifierComparatorBooleantype}
	 * labeled alternative in {@link SimpleBooleanParser#booleantype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierComparatorBooleantype(SimpleBooleanParser.IdentifierComparatorBooleantypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code listComparatorBooleantype}
	 * labeled alternative in {@link SimpleBooleanParser#booleantype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListComparatorBooleantype(SimpleBooleanParser.ListComparatorBooleantypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringComparatorBooleantype}
	 * labeled alternative in {@link SimpleBooleanParser#booleantype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringComparatorBooleantype(SimpleBooleanParser.StringComparatorBooleantypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numberComparatorBooleantype}
	 * labeled alternative in {@link SimpleBooleanParser#booleantype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberComparatorBooleantype(SimpleBooleanParser.NumberComparatorBooleantypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code booleantypeExpression}
	 * labeled alternative in {@link SimpleBooleanParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleantypeExpression(SimpleBooleanParser.BooleantypeExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleBooleanParser#nonboolcomparator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonboolcomparator(SimpleBooleanParser.NonboolcomparatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleBooleanParser#binary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinary(SimpleBooleanParser.BinaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleBooleanParser#bool}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool(SimpleBooleanParser.BoolContext ctx);
}