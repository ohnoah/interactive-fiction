// Generated from /Users/noahohrner/OneDrive - University of Cambridge/Dissertation/Code/interactive-fiction/Boolean.g4 by ANTLR 4.9.1
package com.intfic.game.enhanced.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link BooleanParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface BooleanVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link BooleanParser#parse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParse(BooleanParser.ParseContext ctx);
	/**
	 * Visit a parse tree produced by {@link BooleanParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList(BooleanParser.ListContext ctx);
	/**
	 * Visit a parse tree produced by {@link BooleanParser#stringlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringlist(BooleanParser.StringlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link BooleanParser#numberlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberlist(BooleanParser.NumberlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link BooleanParser#stringelems}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringelems(BooleanParser.StringelemsContext ctx);
	/**
	 * Visit a parse tree produced by {@link BooleanParser#numberelems}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberelems(BooleanParser.NumberelemsContext ctx);
	/**
	 * Visit a parse tree produced by {@link BooleanParser#numbertype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumbertype(BooleanParser.NumbertypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link BooleanParser#stringtype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringtype(BooleanParser.StringtypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringInBooleantype}
	 * labeled alternative in {@link BooleanParser#booleantype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringInBooleantype(BooleanParser.StringInBooleantypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenBooleanType}
	 * labeled alternative in {@link BooleanParser#booleantype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenBooleanType(BooleanParser.ParenBooleanTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryBooleantype}
	 * labeled alternative in {@link BooleanParser#booleantype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryBooleantype(BooleanParser.BinaryBooleantypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numberInBooleantype}
	 * labeled alternative in {@link BooleanParser#booleantype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberInBooleantype(BooleanParser.NumberInBooleantypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inheritBooleantype}
	 * labeled alternative in {@link BooleanParser#booleantype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInheritBooleantype(BooleanParser.InheritBooleantypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notBooleanType}
	 * labeled alternative in {@link BooleanParser#booleantype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotBooleanType(BooleanParser.NotBooleanTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code identifierBooleantype}
	 * labeled alternative in {@link BooleanParser#booleantype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierBooleantype(BooleanParser.IdentifierBooleantypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolBooleantype}
	 * labeled alternative in {@link BooleanParser#booleantype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolBooleantype(BooleanParser.BoolBooleantypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code identifierComparatorBooleantype}
	 * labeled alternative in {@link BooleanParser#booleantype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierComparatorBooleantype(BooleanParser.IdentifierComparatorBooleantypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code listComparatorBooleantype}
	 * labeled alternative in {@link BooleanParser#booleantype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListComparatorBooleantype(BooleanParser.ListComparatorBooleantypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringComparatorBooleantype}
	 * labeled alternative in {@link BooleanParser#booleantype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringComparatorBooleantype(BooleanParser.StringComparatorBooleantypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numberComparatorBooleantype}
	 * labeled alternative in {@link BooleanParser#booleantype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberComparatorBooleantype(BooleanParser.NumberComparatorBooleantypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code booleantypeExpression}
	 * labeled alternative in {@link BooleanParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleantypeExpression(BooleanParser.BooleantypeExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link BooleanParser#nonboolcomparator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonboolcomparator(BooleanParser.NonboolcomparatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link BooleanParser#binary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinary(BooleanParser.BinaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link BooleanParser#bool}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool(BooleanParser.BoolContext ctx);
}