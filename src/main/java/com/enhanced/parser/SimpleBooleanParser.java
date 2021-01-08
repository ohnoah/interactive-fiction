// Generated from /Users/noahohrner/OneDrive - University of Cambridge/Dissertation/Code/interactive-fiction/SimpleBoolean.g4 by ANTLR 4.9
package com.enhanced.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SimpleBooleanParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		IN=1, AND=2, OR=3, NOT=4, TRUE=5, FALSE=6, GT=7, GE=8, LT=9, LE=10, EQ=11, 
		LPAREN=12, RPAREN=13, QUOTE=14, STRING=15, DECIMAL=16, IDENTIFIER=17, 
		BEGL=18, ENDL=19, SEP=20, WS=21;
	public static final int
		RULE_parse = 0, RULE_list = 1, RULE_stringlist = 2, RULE_numberlist = 3, 
		RULE_stringelems = 4, RULE_numberelems = 5, RULE_numbertype = 6, RULE_stringtype = 7, 
		RULE_booleantype = 8, RULE_expression = 9, RULE_boolcomparator = 10, RULE_listcomparator = 11, 
		RULE_nonboolcomparator = 12, RULE_binary = 13, RULE_bool = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"parse", "list", "stringlist", "numberlist", "stringelems", "numberelems", 
			"numbertype", "stringtype", "booleantype", "expression", "boolcomparator", 
			"listcomparator", "nonboolcomparator", "binary", "bool"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'IN'", "'AND'", "'OR'", "'NOT'", "'TRUE'", "'FALSE'", "'>'", "'>='", 
			"'<'", "'<='", "'='", "'('", "')'", "'\"'", null, null, null, "'['", 
			"']'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "IN", "AND", "OR", "NOT", "TRUE", "FALSE", "GT", "GE", "LT", "LE", 
			"EQ", "LPAREN", "RPAREN", "QUOTE", "STRING", "DECIMAL", "IDENTIFIER", 
			"BEGL", "ENDL", "SEP", "WS"
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
	public String getGrammarFileName() { return "SimpleBoolean.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SimpleBooleanParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ParseContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode EOF() { return getToken(SimpleBooleanParser.EOF, 0); }
		public ParseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleBooleanListener ) ((SimpleBooleanListener)listener).enterParse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleBooleanListener ) ((SimpleBooleanListener)listener).exitParse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleBooleanVisitor ) return ((SimpleBooleanVisitor<? extends T>)visitor).visitParse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParseContext parse() throws RecognitionException {
		ParseContext _localctx = new ParseContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_parse);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			expression();
			setState(31);
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

	public static class ListContext extends ParserRuleContext {
		public StringlistContext stringlist() {
			return getRuleContext(StringlistContext.class,0);
		}
		public NumberlistContext numberlist() {
			return getRuleContext(NumberlistContext.class,0);
		}
		public ListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleBooleanListener ) ((SimpleBooleanListener)listener).enterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleBooleanListener ) ((SimpleBooleanListener)listener).exitList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleBooleanVisitor ) return ((SimpleBooleanVisitor<? extends T>)visitor).visitList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListContext list() throws RecognitionException {
		ListContext _localctx = new ListContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_list);
		try {
			setState(35);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(33);
				stringlist();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(34);
				numberlist();
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

	public static class StringlistContext extends ParserRuleContext {
		public TerminalNode BEGL() { return getToken(SimpleBooleanParser.BEGL, 0); }
		public TerminalNode ENDL() { return getToken(SimpleBooleanParser.ENDL, 0); }
		public StringelemsContext stringelems() {
			return getRuleContext(StringelemsContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(SimpleBooleanParser.IDENTIFIER, 0); }
		public StringlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringlist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleBooleanListener ) ((SimpleBooleanListener)listener).enterStringlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleBooleanListener ) ((SimpleBooleanListener)listener).exitStringlist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleBooleanVisitor ) return ((SimpleBooleanVisitor<? extends T>)visitor).visitStringlist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringlistContext stringlist() throws RecognitionException {
		StringlistContext _localctx = new StringlistContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_stringlist);
		int _la;
		try {
			setState(43);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BEGL:
				enterOuterAlt(_localctx, 1);
				{
				setState(37);
				match(BEGL);
				setState(39);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STRING || _la==IDENTIFIER) {
					{
					setState(38);
					stringelems();
					}
				}

				setState(41);
				match(ENDL);
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(42);
				match(IDENTIFIER);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class NumberlistContext extends ParserRuleContext {
		public TerminalNode BEGL() { return getToken(SimpleBooleanParser.BEGL, 0); }
		public TerminalNode ENDL() { return getToken(SimpleBooleanParser.ENDL, 0); }
		public NumberelemsContext numberelems() {
			return getRuleContext(NumberelemsContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(SimpleBooleanParser.IDENTIFIER, 0); }
		public NumberlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numberlist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleBooleanListener ) ((SimpleBooleanListener)listener).enterNumberlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleBooleanListener ) ((SimpleBooleanListener)listener).exitNumberlist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleBooleanVisitor ) return ((SimpleBooleanVisitor<? extends T>)visitor).visitNumberlist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberlistContext numberlist() throws RecognitionException {
		NumberlistContext _localctx = new NumberlistContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_numberlist);
		int _la;
		try {
			setState(51);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BEGL:
				enterOuterAlt(_localctx, 1);
				{
				setState(45);
				match(BEGL);
				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DECIMAL || _la==IDENTIFIER) {
					{
					setState(46);
					numberelems();
					}
				}

				setState(49);
				match(ENDL);
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(50);
				match(IDENTIFIER);
				}
				break;
			default:
				throw new NoViableAltException(this);
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
		public List<StringtypeContext> stringtype() {
			return getRuleContexts(StringtypeContext.class);
		}
		public StringtypeContext stringtype(int i) {
			return getRuleContext(StringtypeContext.class,i);
		}
		public List<TerminalNode> SEP() { return getTokens(SimpleBooleanParser.SEP); }
		public TerminalNode SEP(int i) {
			return getToken(SimpleBooleanParser.SEP, i);
		}
		public StringelemsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringelems; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleBooleanListener ) ((SimpleBooleanListener)listener).enterStringelems(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleBooleanListener ) ((SimpleBooleanListener)listener).exitStringelems(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleBooleanVisitor ) return ((SimpleBooleanVisitor<? extends T>)visitor).visitStringelems(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringelemsContext stringelems() throws RecognitionException {
		StringelemsContext _localctx = new StringelemsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_stringelems);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			stringtype();
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP) {
				{
				{
				setState(54);
				match(SEP);
				setState(55);
				stringtype();
				}
				}
				setState(60);
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
		public List<NumbertypeContext> numbertype() {
			return getRuleContexts(NumbertypeContext.class);
		}
		public NumbertypeContext numbertype(int i) {
			return getRuleContext(NumbertypeContext.class,i);
		}
		public List<TerminalNode> SEP() { return getTokens(SimpleBooleanParser.SEP); }
		public TerminalNode SEP(int i) {
			return getToken(SimpleBooleanParser.SEP, i);
		}
		public NumberelemsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numberelems; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleBooleanListener ) ((SimpleBooleanListener)listener).enterNumberelems(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleBooleanListener ) ((SimpleBooleanListener)listener).exitNumberelems(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleBooleanVisitor ) return ((SimpleBooleanVisitor<? extends T>)visitor).visitNumberelems(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberelemsContext numberelems() throws RecognitionException {
		NumberelemsContext _localctx = new NumberelemsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_numberelems);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			numbertype();
			setState(66);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP) {
				{
				{
				setState(62);
				match(SEP);
				setState(63);
				numbertype();
				}
				}
				setState(68);
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

	public static class NumbertypeContext extends ParserRuleContext {
		public TerminalNode DECIMAL() { return getToken(SimpleBooleanParser.DECIMAL, 0); }
		public TerminalNode IDENTIFIER() { return getToken(SimpleBooleanParser.IDENTIFIER, 0); }
		public NumbertypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numbertype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleBooleanListener ) ((SimpleBooleanListener)listener).enterNumbertype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleBooleanListener ) ((SimpleBooleanListener)listener).exitNumbertype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleBooleanVisitor ) return ((SimpleBooleanVisitor<? extends T>)visitor).visitNumbertype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumbertypeContext numbertype() throws RecognitionException {
		NumbertypeContext _localctx = new NumbertypeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_numbertype);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			_la = _input.LA(1);
			if ( !(_la==DECIMAL || _la==IDENTIFIER) ) {
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

	public static class StringtypeContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(SimpleBooleanParser.STRING, 0); }
		public TerminalNode IDENTIFIER() { return getToken(SimpleBooleanParser.IDENTIFIER, 0); }
		public StringtypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringtype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleBooleanListener ) ((SimpleBooleanListener)listener).enterStringtype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleBooleanListener ) ((SimpleBooleanListener)listener).exitStringtype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleBooleanVisitor ) return ((SimpleBooleanVisitor<? extends T>)visitor).visitStringtype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringtypeContext stringtype() throws RecognitionException {
		StringtypeContext _localctx = new StringtypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_stringtype);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			_la = _input.LA(1);
			if ( !(_la==STRING || _la==IDENTIFIER) ) {
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

	public static class BooleantypeContext extends ParserRuleContext {
		public BooleantypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleantype; }
	 
		public BooleantypeContext() { }
		public void copyFrom(BooleantypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StringInBooleantypeContext extends BooleantypeContext {
		public StringtypeContext stringtype() {
			return getRuleContext(StringtypeContext.class,0);
		}
		public TerminalNode IN() { return getToken(SimpleBooleanParser.IN, 0); }
		public StringlistContext stringlist() {
			return getRuleContext(StringlistContext.class,0);
		}
		public StringInBooleantypeContext(BooleantypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleBooleanListener ) ((SimpleBooleanListener)listener).enterStringInBooleantype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleBooleanListener ) ((SimpleBooleanListener)listener).exitStringInBooleantype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleBooleanVisitor ) return ((SimpleBooleanVisitor<? extends T>)visitor).visitStringInBooleantype(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenBooleanTypeContext extends BooleantypeContext {
		public TerminalNode LPAREN() { return getToken(SimpleBooleanParser.LPAREN, 0); }
		public BooleantypeContext booleantype() {
			return getRuleContext(BooleantypeContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(SimpleBooleanParser.RPAREN, 0); }
		public ParenBooleanTypeContext(BooleantypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleBooleanListener ) ((SimpleBooleanListener)listener).enterParenBooleanType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleBooleanListener ) ((SimpleBooleanListener)listener).exitParenBooleanType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleBooleanVisitor ) return ((SimpleBooleanVisitor<? extends T>)visitor).visitParenBooleanType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolcomparatorBooleantypeContext extends BooleantypeContext {
		public BooleantypeContext left;
		public BoolcomparatorContext op;
		public BooleantypeContext right;
		public List<BooleantypeContext> booleantype() {
			return getRuleContexts(BooleantypeContext.class);
		}
		public BooleantypeContext booleantype(int i) {
			return getRuleContext(BooleantypeContext.class,i);
		}
		public BoolcomparatorContext boolcomparator() {
			return getRuleContext(BoolcomparatorContext.class,0);
		}
		public BoolcomparatorBooleantypeContext(BooleantypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleBooleanListener ) ((SimpleBooleanListener)listener).enterBoolcomparatorBooleantype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleBooleanListener ) ((SimpleBooleanListener)listener).exitBoolcomparatorBooleantype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleBooleanVisitor ) return ((SimpleBooleanVisitor<? extends T>)visitor).visitBoolcomparatorBooleantype(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BinaryBooleantypeContext extends BooleantypeContext {
		public BooleantypeContext left;
		public BinaryContext op;
		public BooleantypeContext right;
		public List<BooleantypeContext> booleantype() {
			return getRuleContexts(BooleantypeContext.class);
		}
		public BooleantypeContext booleantype(int i) {
			return getRuleContext(BooleantypeContext.class,i);
		}
		public BinaryContext binary() {
			return getRuleContext(BinaryContext.class,0);
		}
		public BinaryBooleantypeContext(BooleantypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleBooleanListener ) ((SimpleBooleanListener)listener).enterBinaryBooleantype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleBooleanListener ) ((SimpleBooleanListener)listener).exitBinaryBooleantype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleBooleanVisitor ) return ((SimpleBooleanVisitor<? extends T>)visitor).visitBinaryBooleantype(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumberInBooleantypeContext extends BooleantypeContext {
		public NumbertypeContext numbertype() {
			return getRuleContext(NumbertypeContext.class,0);
		}
		public TerminalNode IN() { return getToken(SimpleBooleanParser.IN, 0); }
		public NumberlistContext numberlist() {
			return getRuleContext(NumberlistContext.class,0);
		}
		public NumberInBooleantypeContext(BooleantypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleBooleanListener ) ((SimpleBooleanListener)listener).enterNumberInBooleantype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleBooleanListener ) ((SimpleBooleanListener)listener).exitNumberInBooleantype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleBooleanVisitor ) return ((SimpleBooleanVisitor<? extends T>)visitor).visitNumberInBooleantype(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotBooleanTypeContext extends BooleantypeContext {
		public TerminalNode NOT() { return getToken(SimpleBooleanParser.NOT, 0); }
		public BooleantypeContext booleantype() {
			return getRuleContext(BooleantypeContext.class,0);
		}
		public NotBooleanTypeContext(BooleantypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleBooleanListener ) ((SimpleBooleanListener)listener).enterNotBooleanType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleBooleanListener ) ((SimpleBooleanListener)listener).exitNotBooleanType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleBooleanVisitor ) return ((SimpleBooleanVisitor<? extends T>)visitor).visitNotBooleanType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdentifierBooleantypeContext extends BooleantypeContext {
		public TerminalNode IDENTIFIER() { return getToken(SimpleBooleanParser.IDENTIFIER, 0); }
		public IdentifierBooleantypeContext(BooleantypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleBooleanListener ) ((SimpleBooleanListener)listener).enterIdentifierBooleantype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleBooleanListener ) ((SimpleBooleanListener)listener).exitIdentifierBooleantype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleBooleanVisitor ) return ((SimpleBooleanVisitor<? extends T>)visitor).visitIdentifierBooleantype(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolBooleantypeContext extends BooleantypeContext {
		public BoolContext bool() {
			return getRuleContext(BoolContext.class,0);
		}
		public BoolBooleantypeContext(BooleantypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleBooleanListener ) ((SimpleBooleanListener)listener).enterBoolBooleantype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleBooleanListener ) ((SimpleBooleanListener)listener).exitBoolBooleantype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleBooleanVisitor ) return ((SimpleBooleanVisitor<? extends T>)visitor).visitBoolBooleantype(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ListComparatorBooleantypeContext extends BooleantypeContext {
		public ListContext left;
		public ListcomparatorContext op;
		public ListContext right;
		public List<ListContext> list() {
			return getRuleContexts(ListContext.class);
		}
		public ListContext list(int i) {
			return getRuleContext(ListContext.class,i);
		}
		public ListcomparatorContext listcomparator() {
			return getRuleContext(ListcomparatorContext.class,0);
		}
		public ListComparatorBooleantypeContext(BooleantypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleBooleanListener ) ((SimpleBooleanListener)listener).enterListComparatorBooleantype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleBooleanListener ) ((SimpleBooleanListener)listener).exitListComparatorBooleantype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleBooleanVisitor ) return ((SimpleBooleanVisitor<? extends T>)visitor).visitListComparatorBooleantype(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringComparatorBooleantypeContext extends BooleantypeContext {
		public StringtypeContext left;
		public NonboolcomparatorContext op;
		public StringtypeContext right;
		public List<StringtypeContext> stringtype() {
			return getRuleContexts(StringtypeContext.class);
		}
		public StringtypeContext stringtype(int i) {
			return getRuleContext(StringtypeContext.class,i);
		}
		public NonboolcomparatorContext nonboolcomparator() {
			return getRuleContext(NonboolcomparatorContext.class,0);
		}
		public StringComparatorBooleantypeContext(BooleantypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleBooleanListener ) ((SimpleBooleanListener)listener).enterStringComparatorBooleantype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleBooleanListener ) ((SimpleBooleanListener)listener).exitStringComparatorBooleantype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleBooleanVisitor ) return ((SimpleBooleanVisitor<? extends T>)visitor).visitStringComparatorBooleantype(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumberComparatorBooleantypeContext extends BooleantypeContext {
		public NumbertypeContext left;
		public NonboolcomparatorContext op;
		public NumbertypeContext right;
		public List<NumbertypeContext> numbertype() {
			return getRuleContexts(NumbertypeContext.class);
		}
		public NumbertypeContext numbertype(int i) {
			return getRuleContext(NumbertypeContext.class,i);
		}
		public NonboolcomparatorContext nonboolcomparator() {
			return getRuleContext(NonboolcomparatorContext.class,0);
		}
		public NumberComparatorBooleantypeContext(BooleantypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleBooleanListener ) ((SimpleBooleanListener)listener).enterNumberComparatorBooleantype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleBooleanListener ) ((SimpleBooleanListener)listener).exitNumberComparatorBooleantype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleBooleanVisitor ) return ((SimpleBooleanVisitor<? extends T>)visitor).visitNumberComparatorBooleantype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleantypeContext booleantype() throws RecognitionException {
		return booleantype(0);
	}

	private BooleantypeContext booleantype(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		BooleantypeContext _localctx = new BooleantypeContext(_ctx, _parentState);
		BooleantypeContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_booleantype, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				_localctx = new ParenBooleanTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(74);
				match(LPAREN);
				setState(75);
				booleantype(0);
				setState(76);
				match(RPAREN);
				}
				break;
			case 2:
				{
				_localctx = new NotBooleanTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(78);
				match(NOT);
				setState(79);
				booleantype(10);
				}
				break;
			case 3:
				{
				_localctx = new StringComparatorBooleantypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(80);
				((StringComparatorBooleantypeContext)_localctx).left = stringtype();
				setState(81);
				((StringComparatorBooleantypeContext)_localctx).op = nonboolcomparator();
				setState(82);
				((StringComparatorBooleantypeContext)_localctx).right = stringtype();
				}
				break;
			case 4:
				{
				_localctx = new NumberComparatorBooleantypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(84);
				((NumberComparatorBooleantypeContext)_localctx).left = numbertype();
				setState(85);
				((NumberComparatorBooleantypeContext)_localctx).op = nonboolcomparator();
				setState(86);
				((NumberComparatorBooleantypeContext)_localctx).right = numbertype();
				}
				break;
			case 5:
				{
				_localctx = new ListComparatorBooleantypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(88);
				((ListComparatorBooleantypeContext)_localctx).left = list();
				setState(89);
				((ListComparatorBooleantypeContext)_localctx).op = listcomparator();
				setState(90);
				((ListComparatorBooleantypeContext)_localctx).right = list();
				}
				break;
			case 6:
				{
				_localctx = new StringInBooleantypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(92);
				stringtype();
				setState(93);
				match(IN);
				setState(94);
				stringlist();
				}
				break;
			case 7:
				{
				_localctx = new NumberInBooleantypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(96);
				numbertype();
				setState(97);
				match(IN);
				setState(98);
				numberlist();
				}
				break;
			case 8:
				{
				_localctx = new BoolBooleantypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(100);
				bool();
				}
				break;
			case 9:
				{
				_localctx = new IdentifierBooleantypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(101);
				match(IDENTIFIER);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(114);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(112);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new BoolcomparatorBooleantypeContext(new BooleantypeContext(_parentctx, _parentState));
						((BoolcomparatorBooleantypeContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_booleantype);
						setState(104);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(105);
						((BoolcomparatorBooleantypeContext)_localctx).op = boolcomparator();
						setState(106);
						((BoolcomparatorBooleantypeContext)_localctx).right = booleantype(10);
						}
						break;
					case 2:
						{
						_localctx = new BinaryBooleantypeContext(new BooleantypeContext(_parentctx, _parentState));
						((BinaryBooleantypeContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_booleantype);
						setState(108);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(109);
						((BinaryBooleantypeContext)_localctx).op = binary();
						setState(110);
						((BinaryBooleantypeContext)_localctx).right = booleantype(9);
						}
						break;
					}
					} 
				}
				setState(116);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
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
	public static class BooleantypeExpressionContext extends ExpressionContext {
		public BooleantypeContext booleantype() {
			return getRuleContext(BooleantypeContext.class,0);
		}
		public BooleantypeExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleBooleanListener ) ((SimpleBooleanListener)listener).enterBooleantypeExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleBooleanListener ) ((SimpleBooleanListener)listener).exitBooleantypeExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleBooleanVisitor ) return ((SimpleBooleanVisitor<? extends T>)visitor).visitBooleantypeExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_expression);
		try {
			_localctx = new BooleantypeExpressionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			booleantype(0);
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

	public static class BoolcomparatorContext extends ParserRuleContext {
		public TerminalNode EQ() { return getToken(SimpleBooleanParser.EQ, 0); }
		public BoolcomparatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolcomparator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleBooleanListener ) ((SimpleBooleanListener)listener).enterBoolcomparator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleBooleanListener ) ((SimpleBooleanListener)listener).exitBoolcomparator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleBooleanVisitor ) return ((SimpleBooleanVisitor<? extends T>)visitor).visitBoolcomparator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolcomparatorContext boolcomparator() throws RecognitionException {
		BoolcomparatorContext _localctx = new BoolcomparatorContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_boolcomparator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(EQ);
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

	public static class ListcomparatorContext extends ParserRuleContext {
		public TerminalNode EQ() { return getToken(SimpleBooleanParser.EQ, 0); }
		public ListcomparatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listcomparator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleBooleanListener ) ((SimpleBooleanListener)listener).enterListcomparator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleBooleanListener ) ((SimpleBooleanListener)listener).exitListcomparator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleBooleanVisitor ) return ((SimpleBooleanVisitor<? extends T>)visitor).visitListcomparator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListcomparatorContext listcomparator() throws RecognitionException {
		ListcomparatorContext _localctx = new ListcomparatorContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_listcomparator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			match(EQ);
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

	public static class NonboolcomparatorContext extends ParserRuleContext {
		public TerminalNode GT() { return getToken(SimpleBooleanParser.GT, 0); }
		public TerminalNode GE() { return getToken(SimpleBooleanParser.GE, 0); }
		public TerminalNode LT() { return getToken(SimpleBooleanParser.LT, 0); }
		public TerminalNode LE() { return getToken(SimpleBooleanParser.LE, 0); }
		public TerminalNode EQ() { return getToken(SimpleBooleanParser.EQ, 0); }
		public NonboolcomparatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonboolcomparator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleBooleanListener ) ((SimpleBooleanListener)listener).enterNonboolcomparator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleBooleanListener ) ((SimpleBooleanListener)listener).exitNonboolcomparator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleBooleanVisitor ) return ((SimpleBooleanVisitor<? extends T>)visitor).visitNonboolcomparator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NonboolcomparatorContext nonboolcomparator() throws RecognitionException {
		NonboolcomparatorContext _localctx = new NonboolcomparatorContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_nonboolcomparator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GT) | (1L << GE) | (1L << LT) | (1L << LE) | (1L << EQ))) != 0)) ) {
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

	public static class BinaryContext extends ParserRuleContext {
		public TerminalNode AND() { return getToken(SimpleBooleanParser.AND, 0); }
		public TerminalNode OR() { return getToken(SimpleBooleanParser.OR, 0); }
		public BinaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleBooleanListener ) ((SimpleBooleanListener)listener).enterBinary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleBooleanListener ) ((SimpleBooleanListener)listener).exitBinary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleBooleanVisitor ) return ((SimpleBooleanVisitor<? extends T>)visitor).visitBinary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinaryContext binary() throws RecognitionException {
		BinaryContext _localctx = new BinaryContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_binary);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			_la = _input.LA(1);
			if ( !(_la==AND || _la==OR) ) {
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

	public static class BoolContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(SimpleBooleanParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(SimpleBooleanParser.FALSE, 0); }
		public BoolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleBooleanListener ) ((SimpleBooleanListener)listener).enterBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleBooleanListener ) ((SimpleBooleanListener)listener).exitBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleBooleanVisitor ) return ((SimpleBooleanVisitor<? extends T>)visitor).visitBool(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolContext bool() throws RecognitionException {
		BoolContext _localctx = new BoolContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_bool);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 8:
			return booleantype_sempred((BooleantypeContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean booleantype_sempred(BooleantypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 9);
		case 1:
			return precpred(_ctx, 8);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\27\u0084\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\2\3\3\3"+
		"\3\5\3&\n\3\3\4\3\4\5\4*\n\4\3\4\3\4\5\4.\n\4\3\5\3\5\5\5\62\n\5\3\5\3"+
		"\5\5\5\66\n\5\3\6\3\6\3\6\7\6;\n\6\f\6\16\6>\13\6\3\7\3\7\3\7\7\7C\n\7"+
		"\f\7\16\7F\13\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\5\ni\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\ns\n\n\f\n\16\nv\13"+
		"\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\20\2\3\22"+
		"\21\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36\2\7\3\2\22\23\4\2\21\21\23"+
		"\23\3\2\t\r\3\2\4\5\3\2\7\b\2\u0085\2 \3\2\2\2\4%\3\2\2\2\6-\3\2\2\2\b"+
		"\65\3\2\2\2\n\67\3\2\2\2\f?\3\2\2\2\16G\3\2\2\2\20I\3\2\2\2\22h\3\2\2"+
		"\2\24w\3\2\2\2\26y\3\2\2\2\30{\3\2\2\2\32}\3\2\2\2\34\177\3\2\2\2\36\u0081"+
		"\3\2\2\2 !\5\24\13\2!\"\7\2\2\3\"\3\3\2\2\2#&\5\6\4\2$&\5\b\5\2%#\3\2"+
		"\2\2%$\3\2\2\2&\5\3\2\2\2\')\7\24\2\2(*\5\n\6\2)(\3\2\2\2)*\3\2\2\2*+"+
		"\3\2\2\2+.\7\25\2\2,.\7\23\2\2-\'\3\2\2\2-,\3\2\2\2.\7\3\2\2\2/\61\7\24"+
		"\2\2\60\62\5\f\7\2\61\60\3\2\2\2\61\62\3\2\2\2\62\63\3\2\2\2\63\66\7\25"+
		"\2\2\64\66\7\23\2\2\65/\3\2\2\2\65\64\3\2\2\2\66\t\3\2\2\2\67<\5\20\t"+
		"\289\7\26\2\29;\5\20\t\2:8\3\2\2\2;>\3\2\2\2<:\3\2\2\2<=\3\2\2\2=\13\3"+
		"\2\2\2><\3\2\2\2?D\5\16\b\2@A\7\26\2\2AC\5\16\b\2B@\3\2\2\2CF\3\2\2\2"+
		"DB\3\2\2\2DE\3\2\2\2E\r\3\2\2\2FD\3\2\2\2GH\t\2\2\2H\17\3\2\2\2IJ\t\3"+
		"\2\2J\21\3\2\2\2KL\b\n\1\2LM\7\16\2\2MN\5\22\n\2NO\7\17\2\2Oi\3\2\2\2"+
		"PQ\7\6\2\2Qi\5\22\n\fRS\5\20\t\2ST\5\32\16\2TU\5\20\t\2Ui\3\2\2\2VW\5"+
		"\16\b\2WX\5\32\16\2XY\5\16\b\2Yi\3\2\2\2Z[\5\4\3\2[\\\5\30\r\2\\]\5\4"+
		"\3\2]i\3\2\2\2^_\5\20\t\2_`\7\3\2\2`a\5\6\4\2ai\3\2\2\2bc\5\16\b\2cd\7"+
		"\3\2\2de\5\b\5\2ei\3\2\2\2fi\5\36\20\2gi\7\23\2\2hK\3\2\2\2hP\3\2\2\2"+
		"hR\3\2\2\2hV\3\2\2\2hZ\3\2\2\2h^\3\2\2\2hb\3\2\2\2hf\3\2\2\2hg\3\2\2\2"+
		"it\3\2\2\2jk\f\13\2\2kl\5\26\f\2lm\5\22\n\fms\3\2\2\2no\f\n\2\2op\5\34"+
		"\17\2pq\5\22\n\13qs\3\2\2\2rj\3\2\2\2rn\3\2\2\2sv\3\2\2\2tr\3\2\2\2tu"+
		"\3\2\2\2u\23\3\2\2\2vt\3\2\2\2wx\5\22\n\2x\25\3\2\2\2yz\7\r\2\2z\27\3"+
		"\2\2\2{|\7\r\2\2|\31\3\2\2\2}~\t\4\2\2~\33\3\2\2\2\177\u0080\t\5\2\2\u0080"+
		"\35\3\2\2\2\u0081\u0082\t\6\2\2\u0082\37\3\2\2\2\f%)-\61\65<Dhrt";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}