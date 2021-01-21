// Generated from /Users/noahohrner/OneDrive - University of Cambridge/Dissertation/Code/interactive-fiction/Constants.g4 by ANTLR 4.9
package com.intfic.game.enhanced.typeconverter;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ConstantsParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TRUE=1, FALSE=2, QUOTE=3, STRING=4, DECIMAL=5, BEGL=6, ENDL=7, SEP=8, 
		WS=9;
	public static final int
		RULE_typeconvert = 0, RULE_expression = 1, RULE_stringelems = 2, RULE_numberelems = 3, 
		RULE_bool = 4;
	private static String[] makeRuleNames() {
		return new String[] {
			"typeconvert", "expression", "stringelems", "numberelems", "bool"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'TRUE'", "'FALSE'", "'\"'", null, null, "'['", "']'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "TRUE", "FALSE", "QUOTE", "STRING", "DECIMAL", "BEGL", "ENDL", 
			"SEP", "WS"
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
			setState(10);
			expression();
			setState(11);
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
	public static class BoolExpressionContext extends ExpressionContext {
		public BoolContext bool() {
			return getRuleContext(BoolContext.class,0);
		}
		public BoolExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstantsListener ) ((ConstantsListener)listener).enterBoolExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstantsListener ) ((ConstantsListener)listener).exitBoolExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConstantsVisitor ) return ((ConstantsVisitor<? extends T>)visitor).visitBoolExpression(this);
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
			setState(26);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new StringelemsExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(13);
				match(BEGL);
				setState(15);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STRING) {
					{
					setState(14);
					stringelems();
					}
				}

				setState(17);
				match(ENDL);
				}
				break;
			case 2:
				_localctx = new NumberelemsExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(18);
				match(BEGL);
				setState(20);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DECIMAL) {
					{
					setState(19);
					numberelems();
					}
				}

				setState(22);
				match(ENDL);
				}
				break;
			case 3:
				_localctx = new StringExpressionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(23);
				match(STRING);
				}
				break;
			case 4:
				_localctx = new DecimalExpressionContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(24);
				match(DECIMAL);
				}
				break;
			case 5:
				_localctx = new BoolExpressionContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(25);
				bool();
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
			setState(28);
			match(STRING);
			setState(33);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP) {
				{
				{
				setState(29);
				match(SEP);
				setState(30);
				match(STRING);
				}
				}
				setState(35);
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
			setState(36);
			match(DECIMAL);
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP) {
				{
				{
				setState(37);
				match(SEP);
				setState(38);
				match(DECIMAL);
				}
				}
				setState(43);
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

	public static class BoolContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(ConstantsParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(ConstantsParser.FALSE, 0); }
		public BoolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstantsListener ) ((ConstantsListener)listener).enterBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstantsListener ) ((ConstantsListener)listener).exitBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConstantsVisitor ) return ((ConstantsVisitor<? extends T>)visitor).visitBool(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolContext bool() throws RecognitionException {
		BoolContext _localctx = new BoolContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_bool);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			_la = _input.LA(1);
			if ( !(_la==TRUE || _la==FALSE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\13\61\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\2\3\3\3\3\5\3\22\n\3\3\3\3\3\3"+
		"\3\5\3\27\n\3\3\3\3\3\3\3\3\3\5\3\35\n\3\3\4\3\4\3\4\7\4\"\n\4\f\4\16"+
		"\4%\13\4\3\5\3\5\3\5\7\5*\n\5\f\5\16\5-\13\5\3\6\3\6\3\6\2\2\7\2\4\6\b"+
		"\n\2\3\3\2\3\4\2\63\2\f\3\2\2\2\4\34\3\2\2\2\6\36\3\2\2\2\b&\3\2\2\2\n"+
		".\3\2\2\2\f\r\5\4\3\2\r\16\7\2\2\3\16\3\3\2\2\2\17\21\7\b\2\2\20\22\5"+
		"\6\4\2\21\20\3\2\2\2\21\22\3\2\2\2\22\23\3\2\2\2\23\35\7\t\2\2\24\26\7"+
		"\b\2\2\25\27\5\b\5\2\26\25\3\2\2\2\26\27\3\2\2\2\27\30\3\2\2\2\30\35\7"+
		"\t\2\2\31\35\7\6\2\2\32\35\7\7\2\2\33\35\5\n\6\2\34\17\3\2\2\2\34\24\3"+
		"\2\2\2\34\31\3\2\2\2\34\32\3\2\2\2\34\33\3\2\2\2\35\5\3\2\2\2\36#\7\6"+
		"\2\2\37 \7\n\2\2 \"\7\6\2\2!\37\3\2\2\2\"%\3\2\2\2#!\3\2\2\2#$\3\2\2\2"+
		"$\7\3\2\2\2%#\3\2\2\2&+\7\7\2\2\'(\7\n\2\2(*\7\7\2\2)\'\3\2\2\2*-\3\2"+
		"\2\2+)\3\2\2\2+,\3\2\2\2,\t\3\2\2\2-+\3\2\2\2./\t\2\2\2/\13\3\2\2\2\7"+
		"\21\26\34#+";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}