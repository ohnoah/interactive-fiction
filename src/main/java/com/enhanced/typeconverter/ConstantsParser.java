// Generated from /Users/noahohrner/OneDrive - University of Cambridge/Dissertation/Code/interactive-fiction/Constants.g4 by ANTLR 4.9
package com.enhanced.typeconverter;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ConstantsParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		QUOTE=1, STRING=2, DECIMAL=3, BEGL=4, ENDL=5, SEP=6, WS=7;
	public static final int
		RULE_typeconvert = 0, RULE_expression = 1, RULE_stringelems = 2, RULE_numberelems = 3;
	private static String[] makeRuleNames() {
		return new String[] {
			"typeconvert", "expression", "stringelems", "numberelems"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'\"'", null, null, "'['", "']'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "QUOTE", "STRING", "DECIMAL", "BEGL", "ENDL", "SEP", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Constants.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ConstantsParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class TypeconvertContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode EOF() { return getToken(ConstantsParser.EOF, 0); }
		public TypeconvertContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeconvert; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstantsListener ) ((ConstantsListener)listener).enterTypeconvert(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstantsListener ) ((ConstantsListener)listener).exitTypeconvert(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConstantsVisitor ) return ((ConstantsVisitor<? extends T>)visitor).visitTypeconvert(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeconvertContext typeconvert() throws RecognitionException {
		TypeconvertContext _localctx = new TypeconvertContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_typeconvert);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(8);
			expression();
			setState(9);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DecimalExpressionContext extends ExpressionContext {
		public TerminalNode DECIMAL() { return getToken(ConstantsParser.DECIMAL, 0); }
		public DecimalExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstantsListener ) ((ConstantsListener)listener).enterDecimalExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstantsListener ) ((ConstantsListener)listener).exitDecimalExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConstantsVisitor ) return ((ConstantsVisitor<? extends T>)visitor).visitDecimalExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringExpressionContext extends ExpressionContext {
		public TerminalNode STRING() { return getToken(ConstantsParser.STRING, 0); }
		public StringExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstantsListener ) ((ConstantsListener)listener).enterStringExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstantsListener ) ((ConstantsListener)listener).exitStringExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConstantsVisitor ) return ((ConstantsVisitor<? extends T>)visitor).visitStringExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringelemsExpressionContext extends ExpressionContext {
		public TerminalNode BEGL() { return getToken(ConstantsParser.BEGL, 0); }
		public TerminalNode ENDL() { return getToken(ConstantsParser.ENDL, 0); }
		public StringelemsContext stringelems() {
			return getRuleContext(StringelemsContext.class,0);
		}
		public StringelemsExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstantsListener ) ((ConstantsListener)listener).enterStringelemsExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstantsListener ) ((ConstantsListener)listener).exitStringelemsExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConstantsVisitor ) return ((ConstantsVisitor<? extends T>)visitor).visitStringelemsExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumberelemsExpressionContext extends ExpressionContext {
		public TerminalNode BEGL() { return getToken(ConstantsParser.BEGL, 0); }
		public TerminalNode ENDL() { return getToken(ConstantsParser.ENDL, 0); }
		public NumberelemsContext numberelems() {
			return getRuleContext(NumberelemsContext.class,0);
		}
		public NumberelemsExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstantsListener ) ((ConstantsListener)listener).enterNumberelemsExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstantsListener ) ((ConstantsListener)listener).exitNumberelemsExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConstantsVisitor ) return ((ConstantsVisitor<? extends T>)visitor).visitNumberelemsExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_expression);
		int _la;
		try {
			setState(23);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new StringelemsExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(11);
				match(BEGL);
				setState(13);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STRING) {
					{
					setState(12);
					stringelems();
					}
				}

				setState(15);
				match(ENDL);
				}
				break;
			case 2:
				_localctx = new NumberelemsExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(16);
				match(BEGL);
				setState(18);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DECIMAL) {
					{
					setState(17);
					numberelems();
					}
				}

				setState(20);
				match(ENDL);
				}
				break;
			case 3:
				_localctx = new StringExpressionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(21);
				match(STRING);
				}
				break;
			case 4:
				_localctx = new DecimalExpressionContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(22);
				match(DECIMAL);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringelemsContext extends ParserRuleContext {
		public List<TerminalNode> STRING() { return getTokens(ConstantsParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(ConstantsParser.STRING, i);
		}
		public List<TerminalNode> SEP() { return getTokens(ConstantsParser.SEP); }
		public TerminalNode SEP(int i) {
			return getToken(ConstantsParser.SEP, i);
		}
		public StringelemsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringelems; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstantsListener ) ((ConstantsListener)listener).enterStringelems(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstantsListener ) ((ConstantsListener)listener).exitStringelems(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConstantsVisitor ) return ((ConstantsVisitor<? extends T>)visitor).visitStringelems(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringelemsContext stringelems() throws RecognitionException {
		StringelemsContext _localctx = new StringelemsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_stringelems);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(25);
			match(STRING);
			setState(30);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP) {
				{
				{
				setState(26);
				match(SEP);
				setState(27);
				match(STRING);
				}
				}
				setState(32);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumberelemsContext extends ParserRuleContext {
		public List<TerminalNode> DECIMAL() { return getTokens(ConstantsParser.DECIMAL); }
		public TerminalNode DECIMAL(int i) {
			return getToken(ConstantsParser.DECIMAL, i);
		}
		public List<TerminalNode> SEP() { return getTokens(ConstantsParser.SEP); }
		public TerminalNode SEP(int i) {
			return getToken(ConstantsParser.SEP, i);
		}
		public NumberelemsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numberelems; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstantsListener ) ((ConstantsListener)listener).enterNumberelems(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstantsListener ) ((ConstantsListener)listener).exitNumberelems(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConstantsVisitor ) return ((ConstantsVisitor<? extends T>)visitor).visitNumberelems(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberelemsContext numberelems() throws RecognitionException {
		NumberelemsContext _localctx = new NumberelemsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_numberelems);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			match(DECIMAL);
			setState(38);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP) {
				{
				{
				setState(34);
				match(SEP);
				setState(35);
				match(DECIMAL);
				}
				}
				setState(40);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\t,\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\3\2\3\2\3\2\3\3\3\3\5\3\20\n\3\3\3\3\3\3\3\5\3\25\n"+
		"\3\3\3\3\3\3\3\5\3\32\n\3\3\4\3\4\3\4\7\4\37\n\4\f\4\16\4\"\13\4\3\5\3"+
		"\5\3\5\7\5\'\n\5\f\5\16\5*\13\5\3\5\2\2\6\2\4\6\b\2\2\2.\2\n\3\2\2\2\4"+
		"\31\3\2\2\2\6\33\3\2\2\2\b#\3\2\2\2\n\13\5\4\3\2\13\f\7\2\2\3\f\3\3\2"+
		"\2\2\r\17\7\6\2\2\16\20\5\6\4\2\17\16\3\2\2\2\17\20\3\2\2\2\20\21\3\2"+
		"\2\2\21\32\7\7\2\2\22\24\7\6\2\2\23\25\5\b\5\2\24\23\3\2\2\2\24\25\3\2"+
		"\2\2\25\26\3\2\2\2\26\32\7\7\2\2\27\32\7\4\2\2\30\32\7\5\2\2\31\r\3\2"+
		"\2\2\31\22\3\2\2\2\31\27\3\2\2\2\31\30\3\2\2\2\32\5\3\2\2\2\33 \7\4\2"+
		"\2\34\35\7\b\2\2\35\37\7\4\2\2\36\34\3\2\2\2\37\"\3\2\2\2 \36\3\2\2\2"+
		" !\3\2\2\2!\7\3\2\2\2\" \3\2\2\2#(\7\5\2\2$%\7\b\2\2%\'\7\5\2\2&$\3\2"+
		"\2\2\'*\3\2\2\2(&\3\2\2\2()\3\2\2\2)\t\3\2\2\2*(\3\2\2\2\7\17\24\31 (";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}