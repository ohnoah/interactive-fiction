// Generated from /Users/noahohrner/OneDrive - University of Cambridge/Dissertation/Code/interactive-fiction/SimpleBoolean.g4 by ANTLR 4.9
package com.enhanced.parser;
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
	 * Enter a parse tree produced by the {@code binaryExpression}
	 * labeled alternative in {@link SimpleBooleanParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBinaryExpression(SimpleBooleanParser.BinaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryExpression}
	 * labeled alternative in {@link SimpleBooleanParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBinaryExpression(SimpleBooleanParser.BinaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code decimalExpression}
	 * labeled alternative in {@link SimpleBooleanParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDecimalExpression(SimpleBooleanParser.DecimalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code decimalExpression}
	 * labeled alternative in {@link SimpleBooleanParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDecimalExpression(SimpleBooleanParser.DecimalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolExpression}
	 * labeled alternative in {@link SimpleBooleanParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBoolExpression(SimpleBooleanParser.BoolExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolExpression}
	 * labeled alternative in {@link SimpleBooleanParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBoolExpression(SimpleBooleanParser.BoolExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code identifierExpression}
	 * labeled alternative in {@link SimpleBooleanParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierExpression(SimpleBooleanParser.IdentifierExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code identifierExpression}
	 * labeled alternative in {@link SimpleBooleanParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierExpression(SimpleBooleanParser.IdentifierExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link SimpleBooleanParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNotExpression(SimpleBooleanParser.NotExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link SimpleBooleanParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNotExpression(SimpleBooleanParser.NotExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenExpression}
	 * labeled alternative in {@link SimpleBooleanParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParenExpression(SimpleBooleanParser.ParenExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenExpression}
	 * labeled alternative in {@link SimpleBooleanParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParenExpression(SimpleBooleanParser.ParenExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code comparatorExpression}
	 * labeled alternative in {@link SimpleBooleanParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterComparatorExpression(SimpleBooleanParser.ComparatorExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code comparatorExpression}
	 * labeled alternative in {@link SimpleBooleanParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitComparatorExpression(SimpleBooleanParser.ComparatorExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleBooleanParser#comparator}.
	 * @param ctx the parse tree
	 */
	void enterComparator(SimpleBooleanParser.ComparatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleBooleanParser#comparator}.
	 * @param ctx the parse tree
	 */
	void exitComparator(SimpleBooleanParser.ComparatorContext ctx);
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