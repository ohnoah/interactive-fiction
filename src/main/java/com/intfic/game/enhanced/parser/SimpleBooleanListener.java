// Generated from /Users/noahohrner/OneDrive - University of Cambridge/Dissertation/Code/interactive-fiction/SimpleBoolean.g4 by ANTLR 4.9
package com.intfic.game.enhanced.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SimpleBooleanParser}.
 */
public interface SimpleBooleanListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SimpleBooleanParser#parse}.
	 * @param ctx the parse tree
	 */
	void enterParse(SimpleBooleanParser.ParseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleBooleanParser#parse}.
	 * @param ctx the parse tree
	 */
	void exitParse(SimpleBooleanParser.ParseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleBooleanParser#list}.
	 * @param ctx the parse tree
	 */
	void enterList(SimpleBooleanParser.ListContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleBooleanParser#list}.
	 * @param ctx the parse tree
	 */
	void exitList(SimpleBooleanParser.ListContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleBooleanParser#stringlist}.
	 * @param ctx the parse tree
	 */
	void enterStringlist(SimpleBooleanParser.StringlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleBooleanParser#stringlist}.
	 * @param ctx the parse tree
	 */
	void exitStringlist(SimpleBooleanParser.StringlistContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleBooleanParser#numberlist}.
	 * @param ctx the parse tree
	 */
	void enterNumberlist(SimpleBooleanParser.NumberlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleBooleanParser#numberlist}.
	 * @param ctx the parse tree
	 */
	void exitNumberlist(SimpleBooleanParser.NumberlistContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleBooleanParser#stringelems}.
	 * @param ctx the parse tree
	 */
	void enterStringelems(SimpleBooleanParser.StringelemsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleBooleanParser#stringelems}.
	 * @param ctx the parse tree
	 */
	void exitStringelems(SimpleBooleanParser.StringelemsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleBooleanParser#numberelems}.
	 * @param ctx the parse tree
	 */
	void enterNumberelems(SimpleBooleanParser.NumberelemsContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleBooleanParser#numberelems}.
	 * @param ctx the parse tree
	 */
	void exitNumberelems(SimpleBooleanParser.NumberelemsContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleBooleanParser#numbertype}.
	 * @param ctx the parse tree
	 */
	void enterNumbertype(SimpleBooleanParser.NumbertypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleBooleanParser#numbertype}.
	 * @param ctx the parse tree
	 */
	void exitNumbertype(SimpleBooleanParser.NumbertypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleBooleanParser#stringtype}.
	 * @param ctx the parse tree
	 */
	void enterStringtype(SimpleBooleanParser.StringtypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleBooleanParser#stringtype}.
	 * @param ctx the parse tree
	 */
	void exitStringtype(SimpleBooleanParser.StringtypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringInBooleantype}
	 * labeled alternative in {@link SimpleBooleanParser#booleantype}.
	 * @param ctx the parse tree
	 */
	void enterStringInBooleantype(SimpleBooleanParser.StringInBooleantypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringInBooleantype}
	 * labeled alternative in {@link SimpleBooleanParser#booleantype}.
	 * @param ctx the parse tree
	 */
	void exitStringInBooleantype(SimpleBooleanParser.StringInBooleantypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenBooleanType}
	 * labeled alternative in {@link SimpleBooleanParser#booleantype}.
	 * @param ctx the parse tree
	 */
	void enterParenBooleanType(SimpleBooleanParser.ParenBooleanTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenBooleanType}
	 * labeled alternative in {@link SimpleBooleanParser#booleantype}.
	 * @param ctx the parse tree
	 */
	void exitParenBooleanType(SimpleBooleanParser.ParenBooleanTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryBooleantype}
	 * labeled alternative in {@link SimpleBooleanParser#booleantype}.
	 * @param ctx the parse tree
	 */
	void enterBinaryBooleantype(SimpleBooleanParser.BinaryBooleantypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryBooleantype}
	 * labeled alternative in {@link SimpleBooleanParser#booleantype}.
	 * @param ctx the parse tree
	 */
	void exitBinaryBooleantype(SimpleBooleanParser.BinaryBooleantypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberInBooleantype}
	 * labeled alternative in {@link SimpleBooleanParser#booleantype}.
	 * @param ctx the parse tree
	 */
	void enterNumberInBooleantype(SimpleBooleanParser.NumberInBooleantypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberInBooleantype}
	 * labeled alternative in {@link SimpleBooleanParser#booleantype}.
	 * @param ctx the parse tree
	 */
	void exitNumberInBooleantype(SimpleBooleanParser.NumberInBooleantypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notBooleanType}
	 * labeled alternative in {@link SimpleBooleanParser#booleantype}.
	 * @param ctx the parse tree
	 */
	void enterNotBooleanType(SimpleBooleanParser.NotBooleanTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notBooleanType}
	 * labeled alternative in {@link SimpleBooleanParser#booleantype}.
	 * @param ctx the parse tree
	 */
	void exitNotBooleanType(SimpleBooleanParser.NotBooleanTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code identifierBooleantype}
	 * labeled alternative in {@link SimpleBooleanParser#booleantype}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierBooleantype(SimpleBooleanParser.IdentifierBooleantypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code identifierBooleantype}
	 * labeled alternative in {@link SimpleBooleanParser#booleantype}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierBooleantype(SimpleBooleanParser.IdentifierBooleantypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolBooleantype}
	 * labeled alternative in {@link SimpleBooleanParser#booleantype}.
	 * @param ctx the parse tree
	 */
	void enterBoolBooleantype(SimpleBooleanParser.BoolBooleantypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolBooleantype}
	 * labeled alternative in {@link SimpleBooleanParser#booleantype}.
	 * @param ctx the parse tree
	 */
	void exitBoolBooleantype(SimpleBooleanParser.BoolBooleantypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code identifierComparatorBooleantype}
	 * labeled alternative in {@link SimpleBooleanParser#booleantype}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierComparatorBooleantype(SimpleBooleanParser.IdentifierComparatorBooleantypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code identifierComparatorBooleantype}
	 * labeled alternative in {@link SimpleBooleanParser#booleantype}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierComparatorBooleantype(SimpleBooleanParser.IdentifierComparatorBooleantypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code listComparatorBooleantype}
	 * labeled alternative in {@link SimpleBooleanParser#booleantype}.
	 * @param ctx the parse tree
	 */
	void enterListComparatorBooleantype(SimpleBooleanParser.ListComparatorBooleantypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code listComparatorBooleantype}
	 * labeled alternative in {@link SimpleBooleanParser#booleantype}.
	 * @param ctx the parse tree
	 */
	void exitListComparatorBooleantype(SimpleBooleanParser.ListComparatorBooleantypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringComparatorBooleantype}
	 * labeled alternative in {@link SimpleBooleanParser#booleantype}.
	 * @param ctx the parse tree
	 */
	void enterStringComparatorBooleantype(SimpleBooleanParser.StringComparatorBooleantypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringComparatorBooleantype}
	 * labeled alternative in {@link SimpleBooleanParser#booleantype}.
	 * @param ctx the parse tree
	 */
	void exitStringComparatorBooleantype(SimpleBooleanParser.StringComparatorBooleantypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberComparatorBooleantype}
	 * labeled alternative in {@link SimpleBooleanParser#booleantype}.
	 * @param ctx the parse tree
	 */
	void enterNumberComparatorBooleantype(SimpleBooleanParser.NumberComparatorBooleantypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberComparatorBooleantype}
	 * labeled alternative in {@link SimpleBooleanParser#booleantype}.
	 * @param ctx the parse tree
	 */
	void exitNumberComparatorBooleantype(SimpleBooleanParser.NumberComparatorBooleantypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code booleantypeExpression}
	 * labeled alternative in {@link SimpleBooleanParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBooleantypeExpression(SimpleBooleanParser.BooleantypeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code booleantypeExpression}
	 * labeled alternative in {@link SimpleBooleanParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBooleantypeExpression(SimpleBooleanParser.BooleantypeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleBooleanParser#nonboolcomparator}.
	 * @param ctx the parse tree
	 */
	void enterNonboolcomparator(SimpleBooleanParser.NonboolcomparatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleBooleanParser#nonboolcomparator}.
	 * @param ctx the parse tree
	 */
	void exitNonboolcomparator(SimpleBooleanParser.NonboolcomparatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleBooleanParser#binary}.
	 * @param ctx the parse tree
	 */
	void enterBinary(SimpleBooleanParser.BinaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleBooleanParser#binary}.
	 * @param ctx the parse tree
	 */
	void exitBinary(SimpleBooleanParser.BinaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleBooleanParser#bool}.
	 * @param ctx the parse tree
	 */
	void enterBool(SimpleBooleanParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleBooleanParser#bool}.
	 * @param ctx the parse tree
	 */
	void exitBool(SimpleBooleanParser.BoolContext ctx);
}