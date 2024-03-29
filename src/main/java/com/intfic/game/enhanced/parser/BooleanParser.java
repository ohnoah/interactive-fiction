// Generated from /Users/noahohrner/OneDrive - University of Cambridge/Dissertation/Code/interactive-fiction/Boolean.g4 by ANTLR 4.9.1
package com.intfic.game.enhanced.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BooleanParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		IS=1, IN=2, AND=3, OR=4, NOT=5, TRUE=6, FALSE=7, LT=8, LE=9, EQ=10, GT=11, 
		GE=12, LPAREN=13, RPAREN=14, QUOTE=15, SLASH=16, STRING=17, DECIMAL=18, 
		IDENTIFIER=19, BEGL=20, ENDL=21, SEP=22, WS=23;
	public static final int
		RULE_parse = 0, RULE_list = 1, RULE_stringlist = 2, RULE_numberlist = 3, 
		RULE_stringelems = 4, RULE_numberelems = 5, RULE_numbertype = 6, RULE_stringtype = 7, 
		RULE_booleantype = 8, RULE_expression = 9, RULE_nonboolcomparator = 10, 
		RULE_binary = 11, RULE_bool = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"parse", "list", "stringlist", "numberlist", "stringelems", "numberelems", 
			"numbertype", "stringtype", "booleantype", "expression", "nonboolcomparator", 
			"binary", "bool"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'IS'", "'IN'", "'AND'", "'OR'", "'NOT'", "'TRUE'", "'FALSE'", 
			"'<'", "'<='", "'='", "'>'", "'>='", "'('", "')'", "'\"'", "'/'", null, 
			null, null, "'['", "']'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "IS", "IN", "AND", "OR", "NOT", "TRUE", "FALSE", "LT", "LE", "EQ", 
			"GT", "GE", "LPAREN", "RPAREN", "QUOTE", "SLASH", "STRING", "DECIMAL", 
			"IDENTIFIER", "BEGL", "ENDL", "SEP", "WS"
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
	public String getGrammarFileName() { return "Boolean.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public BooleanParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ParseContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode EOF() { return getToken(BooleanParser.EOF, 0); }
		public ParseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BooleanListener ) ((BooleanListener)listener).enterParse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BooleanListener ) ((BooleanListener)listener).exitParse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BooleanVisitor ) return ((BooleanVisitor<? extends T>)visitor).visitParse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParseContext parse() throws RecognitionException {
		ParseContext _localctx = new ParseContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_parse);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			expression();
			setState(27);
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
		public TerminalNode IDENTIFIER() { return getToken(BooleanParser.IDENTIFIER, 0); }
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
			if ( listener instanceof BooleanListener ) ((BooleanListener)listener).enterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BooleanListener ) ((BooleanListener)listener).exitList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BooleanVisitor ) return ((BooleanVisitor<? extends T>)visitor).visitList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListContext list() throws RecognitionException {
		ListContext _localctx = new ListContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_list);
		try {
			setState(32);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(29);
				match(IDENTIFIER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(30);
				stringlist();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(31);
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
		public TerminalNode BEGL() { return getToken(BooleanParser.BEGL, 0); }
		public TerminalNode ENDL() { return getToken(BooleanParser.ENDL, 0); }
		public StringelemsContext stringelems() {
			return getRuleContext(StringelemsContext.class,0);
		}
		public StringlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringlist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BooleanListener ) ((BooleanListener)listener).enterStringlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BooleanListener ) ((BooleanListener)listener).exitStringlist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BooleanVisitor ) return ((BooleanVisitor<? extends T>)visitor).visitStringlist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringlistContext stringlist() throws RecognitionException {
		StringlistContext _localctx = new StringlistContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_stringlist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			match(BEGL);
			setState(36);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRING || _la==IDENTIFIER) {
				{
				setState(35);
				stringelems();
				}
			}

			setState(38);
			match(ENDL);
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
		public TerminalNode BEGL() { return getToken(BooleanParser.BEGL, 0); }
		public TerminalNode ENDL() { return getToken(BooleanParser.ENDL, 0); }
		public NumberelemsContext numberelems() {
			return getRuleContext(NumberelemsContext.class,0);
		}
		public NumberlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numberlist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BooleanListener ) ((BooleanListener)listener).enterNumberlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BooleanListener ) ((BooleanListener)listener).exitNumberlist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BooleanVisitor ) return ((BooleanVisitor<? extends T>)visitor).visitNumberlist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberlistContext numberlist() throws RecognitionException {
		NumberlistContext _localctx = new NumberlistContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_numberlist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			match(BEGL);
			setState(42);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DECIMAL || _la==IDENTIFIER) {
				{
				setState(41);
				numberelems();
				}
			}

			setState(44);
			match(ENDL);
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
		public List<TerminalNode> SEP() { return getTokens(BooleanParser.SEP); }
		public TerminalNode SEP(int i) {
			return getToken(BooleanParser.SEP, i);
		}
		public StringelemsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringelems; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BooleanListener ) ((BooleanListener)listener).enterStringelems(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BooleanListener ) ((BooleanListener)listener).exitStringelems(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BooleanVisitor ) return ((BooleanVisitor<? extends T>)visitor).visitStringelems(this);
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
			setState(46);
			stringtype();
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP) {
				{
				{
				setState(47);
				match(SEP);
				setState(48);
				stringtype();
				}
				}
				setState(53);
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
		public List<TerminalNode> SEP() { return getTokens(BooleanParser.SEP); }
		public TerminalNode SEP(int i) {
			return getToken(BooleanParser.SEP, i);
		}
		public NumberelemsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numberelems; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BooleanListener ) ((BooleanListener)listener).enterNumberelems(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BooleanListener ) ((BooleanListener)listener).exitNumberelems(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BooleanVisitor ) return ((BooleanVisitor<? extends T>)visitor).visitNumberelems(this);
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
			setState(54);
			numbertype();
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP) {
				{
				{
				setState(55);
				match(SEP);
				setState(56);
				numbertype();
				}
				}
				setState(61);
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
		public TerminalNode DECIMAL() { return getToken(BooleanParser.DECIMAL, 0); }
		public TerminalNode IDENTIFIER() { return getToken(BooleanParser.IDENTIFIER, 0); }
		public NumbertypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numbertype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BooleanListener ) ((BooleanListener)listener).enterNumbertype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BooleanListener ) ((BooleanListener)listener).exitNumbertype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BooleanVisitor ) return ((BooleanVisitor<? extends T>)visitor).visitNumbertype(this);
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
			setState(62);
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
		public TerminalNode STRING() { return getToken(BooleanParser.STRING, 0); }
		public TerminalNode IDENTIFIER() { return getToken(BooleanParser.IDENTIFIER, 0); }
		public StringtypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringtype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BooleanListener ) ((BooleanListener)listener).enterStringtype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BooleanListener ) ((BooleanListener)listener).exitStringtype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BooleanVisitor ) return ((BooleanVisitor<? extends T>)visitor).visitStringtype(this);
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
			setState(64);
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
		public TerminalNode IN() { return getToken(BooleanParser.IN, 0); }
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public StringInBooleantypeContext(BooleantypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BooleanListener ) ((BooleanListener)listener).enterStringInBooleantype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BooleanListener ) ((BooleanListener)listener).exitStringInBooleantype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BooleanVisitor ) return ((BooleanVisitor<? extends T>)visitor).visitStringInBooleantype(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenBooleanTypeContext extends BooleantypeContext {
		public TerminalNode LPAREN() { return getToken(BooleanParser.LPAREN, 0); }
		public BooleantypeContext booleantype() {
			return getRuleContext(BooleantypeContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(BooleanParser.RPAREN, 0); }
		public ParenBooleanTypeContext(BooleantypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BooleanListener ) ((BooleanListener)listener).enterParenBooleanType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BooleanListener ) ((BooleanListener)listener).exitParenBooleanType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BooleanVisitor ) return ((BooleanVisitor<? extends T>)visitor).visitParenBooleanType(this);
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
			if ( listener instanceof BooleanListener ) ((BooleanListener)listener).enterBinaryBooleantype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BooleanListener ) ((BooleanListener)listener).exitBinaryBooleantype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BooleanVisitor ) return ((BooleanVisitor<? extends T>)visitor).visitBinaryBooleantype(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumberInBooleantypeContext extends BooleantypeContext {
		public NumbertypeContext numbertype() {
			return getRuleContext(NumbertypeContext.class,0);
		}
		public TerminalNode IN() { return getToken(BooleanParser.IN, 0); }
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public NumberInBooleantypeContext(BooleantypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BooleanListener ) ((BooleanListener)listener).enterNumberInBooleantype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BooleanListener ) ((BooleanListener)listener).exitNumberInBooleantype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BooleanVisitor ) return ((BooleanVisitor<? extends T>)visitor).visitNumberInBooleantype(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InheritBooleantypeContext extends BooleantypeContext {
		public List<StringtypeContext> stringtype() {
			return getRuleContexts(StringtypeContext.class);
		}
		public StringtypeContext stringtype(int i) {
			return getRuleContext(StringtypeContext.class,i);
		}
		public TerminalNode SLASH() { return getToken(BooleanParser.SLASH, 0); }
		public InheritBooleantypeContext(BooleantypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BooleanListener ) ((BooleanListener)listener).enterInheritBooleantype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BooleanListener ) ((BooleanListener)listener).exitInheritBooleantype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BooleanVisitor ) return ((BooleanVisitor<? extends T>)visitor).visitInheritBooleantype(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotBooleanTypeContext extends BooleantypeContext {
		public TerminalNode NOT() { return getToken(BooleanParser.NOT, 0); }
		public BooleantypeContext booleantype() {
			return getRuleContext(BooleantypeContext.class,0);
		}
		public NotBooleanTypeContext(BooleantypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BooleanListener ) ((BooleanListener)listener).enterNotBooleanType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BooleanListener ) ((BooleanListener)listener).exitNotBooleanType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BooleanVisitor ) return ((BooleanVisitor<? extends T>)visitor).visitNotBooleanType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdentifierBooleantypeContext extends BooleantypeContext {
		public TerminalNode IDENTIFIER() { return getToken(BooleanParser.IDENTIFIER, 0); }
		public IdentifierBooleantypeContext(BooleantypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BooleanListener ) ((BooleanListener)listener).enterIdentifierBooleantype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BooleanListener ) ((BooleanListener)listener).exitIdentifierBooleantype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BooleanVisitor ) return ((BooleanVisitor<? extends T>)visitor).visitIdentifierBooleantype(this);
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
			if ( listener instanceof BooleanListener ) ((BooleanListener)listener).enterBoolBooleantype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BooleanListener ) ((BooleanListener)listener).exitBoolBooleantype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BooleanVisitor ) return ((BooleanVisitor<? extends T>)visitor).visitBoolBooleantype(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdentifierComparatorBooleantypeContext extends BooleantypeContext {
		public Token left;
		public NonboolcomparatorContext op;
		public Token right;
		public List<TerminalNode> IDENTIFIER() { return getTokens(BooleanParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(BooleanParser.IDENTIFIER, i);
		}
		public NonboolcomparatorContext nonboolcomparator() {
			return getRuleContext(NonboolcomparatorContext.class,0);
		}
		public IdentifierComparatorBooleantypeContext(BooleantypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BooleanListener ) ((BooleanListener)listener).enterIdentifierComparatorBooleantype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BooleanListener ) ((BooleanListener)listener).exitIdentifierComparatorBooleantype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BooleanVisitor ) return ((BooleanVisitor<? extends T>)visitor).visitIdentifierComparatorBooleantype(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ListComparatorBooleantypeContext extends BooleantypeContext {
		public ListContext left;
		public ListContext right;
		public TerminalNode IS() { return getToken(BooleanParser.IS, 0); }
		public List<ListContext> list() {
			return getRuleContexts(ListContext.class);
		}
		public ListContext list(int i) {
			return getRuleContext(ListContext.class,i);
		}
		public ListComparatorBooleantypeContext(BooleantypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BooleanListener ) ((BooleanListener)listener).enterListComparatorBooleantype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BooleanListener ) ((BooleanListener)listener).exitListComparatorBooleantype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BooleanVisitor ) return ((BooleanVisitor<? extends T>)visitor).visitListComparatorBooleantype(this);
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
			if ( listener instanceof BooleanListener ) ((BooleanListener)listener).enterStringComparatorBooleantype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BooleanListener ) ((BooleanListener)listener).exitStringComparatorBooleantype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BooleanVisitor ) return ((BooleanVisitor<? extends T>)visitor).visitStringComparatorBooleantype(this);
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
			if ( listener instanceof BooleanListener ) ((BooleanListener)listener).enterNumberComparatorBooleantype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BooleanListener ) ((BooleanListener)listener).exitNumberComparatorBooleantype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BooleanVisitor ) return ((BooleanVisitor<? extends T>)visitor).visitNumberComparatorBooleantype(this);
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
			setState(103);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				_localctx = new ParenBooleanTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(67);
				match(LPAREN);
				setState(68);
				booleantype(0);
				setState(69);
				match(RPAREN);
				}
				break;
			case 2:
				{
				_localctx = new NotBooleanTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(71);
				match(NOT);
				setState(72);
				booleantype(11);
				}
				break;
			case 3:
				{
				_localctx = new IdentifierComparatorBooleantypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(73);
				((IdentifierComparatorBooleantypeContext)_localctx).left = match(IDENTIFIER);
				setState(74);
				((IdentifierComparatorBooleantypeContext)_localctx).op = nonboolcomparator();
				setState(75);
				((IdentifierComparatorBooleantypeContext)_localctx).right = match(IDENTIFIER);
				}
				break;
			case 4:
				{
				_localctx = new StringComparatorBooleantypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(77);
				((StringComparatorBooleantypeContext)_localctx).left = stringtype();
				setState(78);
				((StringComparatorBooleantypeContext)_localctx).op = nonboolcomparator();
				setState(79);
				((StringComparatorBooleantypeContext)_localctx).right = stringtype();
				}
				break;
			case 5:
				{
				_localctx = new NumberComparatorBooleantypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(81);
				((NumberComparatorBooleantypeContext)_localctx).left = numbertype();
				setState(82);
				((NumberComparatorBooleantypeContext)_localctx).op = nonboolcomparator();
				setState(83);
				((NumberComparatorBooleantypeContext)_localctx).right = numbertype();
				}
				break;
			case 6:
				{
				_localctx = new ListComparatorBooleantypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(85);
				((ListComparatorBooleantypeContext)_localctx).left = list();
				setState(86);
				match(IS);
				setState(87);
				((ListComparatorBooleantypeContext)_localctx).right = list();
				}
				break;
			case 7:
				{
				_localctx = new StringInBooleantypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(89);
				stringtype();
				setState(90);
				match(IN);
				setState(91);
				list();
				}
				break;
			case 8:
				{
				_localctx = new NumberInBooleantypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(93);
				numbertype();
				setState(94);
				match(IN);
				setState(95);
				list();
				}
				break;
			case 9:
				{
				_localctx = new InheritBooleantypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(97);
				stringtype();
				setState(98);
				match(SLASH);
				setState(99);
				stringtype();
				}
				break;
			case 10:
				{
				_localctx = new BoolBooleantypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(101);
				bool();
				}
				break;
			case 11:
				{
				_localctx = new IdentifierBooleantypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(102);
				match(IDENTIFIER);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(111);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new BinaryBooleantypeContext(new BooleantypeContext(_parentctx, _parentState));
					((BinaryBooleantypeContext)_localctx).left = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_booleantype);
					setState(105);
					if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
					setState(106);
					((BinaryBooleantypeContext)_localctx).op = binary();
					setState(107);
					((BinaryBooleantypeContext)_localctx).right = booleantype(10);
					}
					} 
				}
				setState(113);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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
		public TerminalNode EOF() { return getToken(BooleanParser.EOF, 0); }
		public BooleantypeExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BooleanListener ) ((BooleanListener)listener).enterBooleantypeExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BooleanListener ) ((BooleanListener)listener).exitBooleantypeExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BooleanVisitor ) return ((BooleanVisitor<? extends T>)visitor).visitBooleantypeExpression(this);
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
			setState(114);
			booleantype(0);
			setState(115);
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

	public static class NonboolcomparatorContext extends ParserRuleContext {
		public TerminalNode GT() { return getToken(BooleanParser.GT, 0); }
		public TerminalNode GE() { return getToken(BooleanParser.GE, 0); }
		public TerminalNode LT() { return getToken(BooleanParser.LT, 0); }
		public TerminalNode LE() { return getToken(BooleanParser.LE, 0); }
		public TerminalNode EQ() { return getToken(BooleanParser.EQ, 0); }
		public NonboolcomparatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonboolcomparator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BooleanListener ) ((BooleanListener)listener).enterNonboolcomparator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BooleanListener ) ((BooleanListener)listener).exitNonboolcomparator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BooleanVisitor ) return ((BooleanVisitor<? extends T>)visitor).visitNonboolcomparator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NonboolcomparatorContext nonboolcomparator() throws RecognitionException {
		NonboolcomparatorContext _localctx = new NonboolcomparatorContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_nonboolcomparator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LT) | (1L << LE) | (1L << EQ) | (1L << GT) | (1L << GE))) != 0)) ) {
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
		public TerminalNode AND() { return getToken(BooleanParser.AND, 0); }
		public TerminalNode OR() { return getToken(BooleanParser.OR, 0); }
		public BinaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BooleanListener ) ((BooleanListener)listener).enterBinary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BooleanListener ) ((BooleanListener)listener).exitBinary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BooleanVisitor ) return ((BooleanVisitor<? extends T>)visitor).visitBinary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinaryContext binary() throws RecognitionException {
		BinaryContext _localctx = new BinaryContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_binary);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
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
		public TerminalNode TRUE() { return getToken(BooleanParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(BooleanParser.FALSE, 0); }
		public BoolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BooleanListener ) ((BooleanListener)listener).enterBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BooleanListener ) ((BooleanListener)listener).exitBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BooleanVisitor ) return ((BooleanVisitor<? extends T>)visitor).visitBool(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolContext bool() throws RecognitionException {
		BoolContext _localctx = new BoolContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_bool);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
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
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\31~\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\3\3\3\3\3\3\5\3#\n\3\3\4\3\4\5\4"+
		"\'\n\4\3\4\3\4\3\5\3\5\5\5-\n\5\3\5\3\5\3\6\3\6\3\6\7\6\64\n\6\f\6\16"+
		"\6\67\13\6\3\7\3\7\3\7\7\7<\n\7\f\7\16\7?\13\7\3\b\3\b\3\t\3\t\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\5\nj\n\n\3\n\3\n\3\n\3\n\7\np\n\n\f\n\16\ns\13\n\3\13\3\13\3\13\3\f\3"+
		"\f\3\r\3\r\3\16\3\16\3\16\2\3\22\17\2\4\6\b\n\f\16\20\22\24\26\30\32\2"+
		"\7\3\2\24\25\4\2\23\23\25\25\3\2\n\16\3\2\5\6\3\2\b\t\2\u0081\2\34\3\2"+
		"\2\2\4\"\3\2\2\2\6$\3\2\2\2\b*\3\2\2\2\n\60\3\2\2\2\f8\3\2\2\2\16@\3\2"+
		"\2\2\20B\3\2\2\2\22i\3\2\2\2\24t\3\2\2\2\26w\3\2\2\2\30y\3\2\2\2\32{\3"+
		"\2\2\2\34\35\5\24\13\2\35\36\7\2\2\3\36\3\3\2\2\2\37#\7\25\2\2 #\5\6\4"+
		"\2!#\5\b\5\2\"\37\3\2\2\2\" \3\2\2\2\"!\3\2\2\2#\5\3\2\2\2$&\7\26\2\2"+
		"%\'\5\n\6\2&%\3\2\2\2&\'\3\2\2\2\'(\3\2\2\2()\7\27\2\2)\7\3\2\2\2*,\7"+
		"\26\2\2+-\5\f\7\2,+\3\2\2\2,-\3\2\2\2-.\3\2\2\2./\7\27\2\2/\t\3\2\2\2"+
		"\60\65\5\20\t\2\61\62\7\30\2\2\62\64\5\20\t\2\63\61\3\2\2\2\64\67\3\2"+
		"\2\2\65\63\3\2\2\2\65\66\3\2\2\2\66\13\3\2\2\2\67\65\3\2\2\28=\5\16\b"+
		"\29:\7\30\2\2:<\5\16\b\2;9\3\2\2\2<?\3\2\2\2=;\3\2\2\2=>\3\2\2\2>\r\3"+
		"\2\2\2?=\3\2\2\2@A\t\2\2\2A\17\3\2\2\2BC\t\3\2\2C\21\3\2\2\2DE\b\n\1\2"+
		"EF\7\17\2\2FG\5\22\n\2GH\7\20\2\2Hj\3\2\2\2IJ\7\7\2\2Jj\5\22\n\rKL\7\25"+
		"\2\2LM\5\26\f\2MN\7\25\2\2Nj\3\2\2\2OP\5\20\t\2PQ\5\26\f\2QR\5\20\t\2"+
		"Rj\3\2\2\2ST\5\16\b\2TU\5\26\f\2UV\5\16\b\2Vj\3\2\2\2WX\5\4\3\2XY\7\3"+
		"\2\2YZ\5\4\3\2Zj\3\2\2\2[\\\5\20\t\2\\]\7\4\2\2]^\5\4\3\2^j\3\2\2\2_`"+
		"\5\16\b\2`a\7\4\2\2ab\5\4\3\2bj\3\2\2\2cd\5\20\t\2de\7\22\2\2ef\5\20\t"+
		"\2fj\3\2\2\2gj\5\32\16\2hj\7\25\2\2iD\3\2\2\2iI\3\2\2\2iK\3\2\2\2iO\3"+
		"\2\2\2iS\3\2\2\2iW\3\2\2\2i[\3\2\2\2i_\3\2\2\2ic\3\2\2\2ig\3\2\2\2ih\3"+
		"\2\2\2jq\3\2\2\2kl\f\13\2\2lm\5\30\r\2mn\5\22\n\fnp\3\2\2\2ok\3\2\2\2"+
		"ps\3\2\2\2qo\3\2\2\2qr\3\2\2\2r\23\3\2\2\2sq\3\2\2\2tu\5\22\n\2uv\7\2"+
		"\2\3v\25\3\2\2\2wx\t\4\2\2x\27\3\2\2\2yz\t\5\2\2z\31\3\2\2\2{|\t\6\2\2"+
		"|\33\3\2\2\2\t\"&,\65=iq";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}