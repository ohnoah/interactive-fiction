// Generated from /Users/noahohrner/OneDrive - University of Cambridge/Dissertation/Code/interactive-fiction/Boolean.g4 by ANTLR 4.9.1
package com.intfic.game.enhanced.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link BooleanParser}.
 */
public interface BooleanListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link BooleanParser#parse}.
	 * @param ctx the parse tree
	 */
	void enterParse(BooleanParser.ParseContext ctx);
	/**
	 * Exit a parse tree produced by {@link BooleanParser#parse}.
	 * @param ctx the parse tree
	 */
	void exitParse(BooleanParser.ParseContext ctx);
	/**
	 * Enter a parse tree produced by {@link BooleanParser#list}.
	 * @param ctx the parse tree
	 */
	void enterList(BooleanParser.ListContext ctx);
	/**
	 * Exit a parse tree produced by {@link BooleanParser#list}.
	 * @param ctx the parse tree
	 */
	void exitList(BooleanParser.ListContext ctx);
	/**
	 * Enter a parse tree produced by {@link BooleanParser#stringlist}.
	 * @param ctx the parse tree
	 */
	void enterStringlist(BooleanParser.StringlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link BooleanParser#stringlist}.
	 * @param ctx the parse tree
	 */
	void exitStringlist(BooleanParser.StringlistContext ctx);
	/**
	 * Enter a parse tree produced by {@link BooleanParser#numberlist}.
	 * @param ctx the parse tree
	 */
	void enterNumberlist(BooleanParser.NumberlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link BooleanParser#numberlist}.
	 * @param ctx the parse tree
	 */
	void exitNumberlist(BooleanParser.NumberlistContext ctx);
	/**
	 * Enter a parse tree produced by {@link BooleanParser#stringelems}.
	 * @param ctx the parse tree
	 */
	void enterStringelems(BooleanParser.StringelemsContext ctx);
	/**
	 * Exit a parse tree produced by {@link BooleanParser#stringelems}.
	 * @param ctx the parse tree
	 */
	void exitStringelems(BooleanParser.StringelemsContext ctx);
	/**
	 * Enter a parse tree produced by {@link BooleanParser#numberelems}.
	 * @param ctx the parse tree
	 */
	void enterNumberelems(BooleanParser.NumberelemsContext ctx);
	/**
	 * Exit a parse tree produced by {@link BooleanParser#numberelems}.
	 * @param ctx the parse tree
	 */
	void exitNumberelems(BooleanParser.NumberelemsContext ctx);
	/**
	 * Enter a parse tree produced by {@link BooleanParser#numbertype}.
	 * @param ctx the parse tree
	 */
	void enterNumbertype(BooleanParser.NumbertypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link BooleanParser#numbertype}.
	 * @param ctx the parse tree
	 */
	void exitNumbertype(BooleanParser.NumbertypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link BooleanParser#stringtype}.
	 * @param ctx the parse tree
	 */
	void enterStringtype(BooleanParser.StringtypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link BooleanParser#stringtype}.
	 * @param ctx the parse tree
	 */
	void exitStringtype(BooleanParser.StringtypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringInBooleantype}
	 * labeled alternative in {@link BooleanParser#booleantype}.
	 * @param ctx the parse tree
	 */
	void enterStringInBooleantype(BooleanParser.StringInBooleantypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringInBooleantype}
	 * labeled alternative in {@link BooleanParser#booleantype}.
	 * @param ctx the parse tree
	 */
	void exitStringInBooleantype(BooleanParser.StringInBooleantypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenBooleanType}
	 * labeled alternative in {@link BooleanParser#booleantype}.
	 * @param ctx the parse tree
	 */
	void enterParenBooleanType(BooleanParser.ParenBooleanTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenBooleanType}
	 * labeled alternative in {@link BooleanParser#booleantype}.
	 * @param ctx the parse tree
	 */
	void exitParenBooleanType(BooleanParser.ParenBooleanTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryBooleantype}
	 * labeled alternative in {@link BooleanParser#booleantype}.
	 * @param ctx the parse tree
	 */
	void enterBinaryBooleantype(BooleanParser.BinaryBooleantypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryBooleantype}
	 * labeled alternative in {@link BooleanParser#booleantype}.
	 * @param ctx the parse tree
	 */
	void exitBinaryBooleantype(BooleanParser.BinaryBooleantypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberInBooleantype}
	 * labeled alternative in {@link BooleanParser#booleantype}.
	 * @param ctx the parse tree
	 */
	void enterNumberInBooleantype(BooleanParser.NumberInBooleantypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberInBooleantype}
	 * labeled alternative in {@link BooleanParser#booleantype}.
	 * @param ctx the parse tree
	 */
	void exitNumberInBooleantype(BooleanParser.NumberInBooleantypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inheritBooleantype}
	 * labeled alternative in {@link BooleanParser#booleantype}.
	 * @param ctx the parse tree
	 */
	void enterInheritBooleantype(BooleanParser.InheritBooleantypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inheritBooleantype}
	 * labeled alternative in {@link BooleanParser#booleantype}.
	 * @param ctx the parse tree
	 */
	void exitInheritBooleantype(BooleanParser.InheritBooleantypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notBooleanType}
	 * labeled alternative in {@link BooleanParser#booleantype}.
	 * @param ctx the parse tree
	 */
	void enterNotBooleanType(BooleanParser.NotBooleanTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notBooleanType}
	 * labeled alternative in {@link BooleanParser#booleantype}.
	 * @param ctx the parse tree
	 */
	void exitNotBooleanType(BooleanParser.NotBooleanTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code identifierBooleantype}
	 * labeled alternative in {@link BooleanParser#booleantype}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierBooleantype(BooleanParser.IdentifierBooleantypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code identifierBooleantype}
	 * labeled alternative in {@link BooleanParser#booleantype}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierBooleantype(BooleanParser.IdentifierBooleantypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolBooleantype}
	 * labeled alternative in {@link BooleanParser#booleantype}.
	 * @param ctx the parse tree
	 */
	void enterBoolBooleantype(BooleanParser.BoolBooleantypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolBooleantype}
	 * labeled alternative in {@link BooleanParser#booleantype}.
	 * @param ctx the parse tree
	 */
	void exitBoolBooleantype(BooleanParser.BoolBooleantypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code identifierComparatorBooleantype}
	 * labeled alternative in {@link BooleanParser#booleantype}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierComparatorBooleantype(BooleanParser.IdentifierComparatorBooleantypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code identifierComparatorBooleantype}
	 * labeled alternative in {@link BooleanParser#booleantype}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierComparatorBooleantype(BooleanParser.IdentifierComparatorBooleantypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code listComparatorBooleantype}
	 * labeled alternative in {@link BooleanParser#booleantype}.
	 * @param ctx the parse tree
	 */
	void enterListComparatorBooleantype(BooleanParser.ListComparatorBooleantypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code listComparatorBooleantype}
	 * labeled alternative in {@link BooleanParser#booleantype}.
	 * @param ctx the parse tree
	 */
	void exitListComparatorBooleantype(BooleanParser.ListComparatorBooleantypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringComparatorBooleantype}
	 * labeled alternative in {@link BooleanParser#booleantype}.
	 * @param ctx the parse tree
	 */
	void enterStringComparatorBooleantype(BooleanParser.StringComparatorBooleantypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringComparatorBooleantype}
	 * labeled alternative in {@link BooleanParser#booleantype}.
	 * @param ctx the parse tree
	 */
	void exitStringComparatorBooleantype(BooleanParser.StringComparatorBooleantypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberComparatorBooleantype}
	 * labeled alternative in {@link BooleanParser#booleantype}.
	 * @param ctx the parse tree
	 */
	void enterNumberComparatorBooleantype(BooleanParser.NumberComparatorBooleantypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberComparatorBooleantype}
	 * labeled alternative in {@link BooleanParser#booleantype}.
	 * @param ctx the parse tree
	 */
	void exitNumberComparatorBooleantype(BooleanParser.NumberComparatorBooleantypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code booleantypeExpression}
	 * labeled alternative in {@link BooleanParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBooleantypeExpression(BooleanParser.BooleantypeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code booleantypeExpression}
	 * labeled alternative in {@link BooleanParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBooleantypeExpression(BooleanParser.BooleantypeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link BooleanParser#nonboolcomparator}.
	 * @param ctx the parse tree
	 */
	void enterNonboolcomparator(BooleanParser.NonboolcomparatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link BooleanParser#nonboolcomparator}.
	 * @param ctx the parse tree
	 */
	void exitNonboolcomparator(BooleanParser.NonboolcomparatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link BooleanParser#binary}.
	 * @param ctx the parse tree
	 */
	void enterBinary(BooleanParser.BinaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link BooleanParser#binary}.
	 * @param ctx the parse tree
	 */
	void exitBinary(BooleanParser.BinaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link BooleanParser#bool}.
	 * @param ctx the parse tree
	 */
	void enterBool(BooleanParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by {@link BooleanParser#bool}.
	 * @param ctx the parse tree
	 */
	void exitBool(BooleanParser.BoolContext ctx);
}