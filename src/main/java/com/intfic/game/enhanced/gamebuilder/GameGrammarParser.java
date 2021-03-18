// Generated from /Users/noahohrner/OneDrive - University of Cambridge/Dissertation/Code/interactive-fiction/GameGrammar.g4 by ANTLR 4.9.1
package com.intfic.game.enhanced.gamebuilder;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GameGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ID=1, LCURLY=2, RCURLY=3, LSQUARE=4, RSQUARE=5, HASH=6, START=7, MESSAGE=8, 
		ACTION=9, ROOM=10, ITEM=11, KNOWLEDGE=12, PRECOND=13, POSTCOND=14, GENERICFRAME=15, 
		CUSTOM_TRIGGER=16, INITIAL=17, POSTCONDS=18, PRECONDS=19, COMMA=20, ACTIONS_SYNTAX=21, 
		ITEMS=22, NAME=23, SUCCESSMESSAGE=24, TRIGGERS_SYNTAX=25, ARGUMENTS=26, 
		PARENTS=27, INHERITS=28, ROOM_NAME=29, ITEM_NAME=30, ITEM_KNOWLEDGE=31, 
		GENERIC_INHERITANCE=32, TRIGGER_SELECTOR=33, SINGLE_STRING=34, STRING=35, 
		ALPHANUMERIC=36, INTEGER=37, DECIMAL=38, LPAREN=39, RPAREN=40, SEMICOLON=41, 
		DOT=42, EQUALS=43, DASH=44, WS=45, STRINGLIST=46, NUMBERLIST=47, BOOLEAN=48;
	public static final int
		RULE_new_message = 0, RULE_message_id = 1, RULE_message_text = 2, RULE_message_ref = 3, 
		RULE_message = 4, RULE_trigger = 5, RULE_precond_id = 6, RULE_precond_ref = 7, 
		RULE_new_precond = 8, RULE_precond_body = 9, RULE_precond = 10, RULE_postcond_id = 11, 
		RULE_postcond_ref = 12, RULE_postcond_body = 13, RULE_new_postcond = 14, 
		RULE_postcond = 15, RULE_preconds = 16, RULE_triggers = 17, RULE_postconds = 18, 
		RULE_argument = 19, RULE_arguments = 20, RULE_new_action = 21, RULE_actionformat = 22, 
		RULE_action_id = 23, RULE_action_ref = 24, RULE_action = 25, RULE_actions = 26, 
		RULE_item_id = 27, RULE_item_ref = 28, RULE_item_name = 29, RULE_item = 30, 
		RULE_items = 31, RULE_new_item = 32, RULE_room_name = 33, RULE_new_room = 34, 
		RULE_genericframe_name = 35, RULE_map_entry = 36, RULE_new_genericframe = 37, 
		RULE_knowledge_update = 38, RULE_knowledge_updates = 39, RULE_global_item = 40, 
		RULE_global_items = 41, RULE_inheritance = 42, RULE_knowledge = 43, RULE_start = 44, 
		RULE_game = 45;
	private static String[] makeRuleNames() {
		return new String[] {
			"new_message", "message_id", "message_text", "message_ref", "message", 
			"trigger", "precond_id", "precond_ref", "new_precond", "precond_body", 
			"precond", "postcond_id", "postcond_ref", "postcond_body", "new_postcond", 
			"postcond", "preconds", "triggers", "postconds", "argument", "arguments", 
			"new_action", "actionformat", "action_id", "action_ref", "action", "actions", 
			"item_id", "item_ref", "item_name", "item", "items", "new_item", "room_name", 
			"new_room", "genericframe_name", "map_entry", "new_genericframe", "knowledge_update", 
			"knowledge_updates", "global_item", "global_items", "inheritance", "knowledge", 
			"start", "game"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'{'", "'}'", "'['", "']'", "'#'", "'start'", "'message'", 
			"'action'", "'room'", "'item'", "'knowledge'", "'precond'", "'postcond'", 
			"'generic_frame'", "'custom_trigger'", "'initial'", "'postconds'", "'preconds'", 
			"','", "'actions'", "'items'", "'name'", "'success_msg'", "'action_triggers'", 
			"'args'", "'parents'", "'inherits'", "'room_name'", "'item_name'", "'item_knowledge'", 
			"'generic_inheritance'", null, null, null, null, null, null, "'('", "')'", 
			"';'", "'.'", "'<-'", "'-'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ID", "LCURLY", "RCURLY", "LSQUARE", "RSQUARE", "HASH", "START", 
			"MESSAGE", "ACTION", "ROOM", "ITEM", "KNOWLEDGE", "PRECOND", "POSTCOND", 
			"GENERICFRAME", "CUSTOM_TRIGGER", "INITIAL", "POSTCONDS", "PRECONDS", 
			"COMMA", "ACTIONS_SYNTAX", "ITEMS", "NAME", "SUCCESSMESSAGE", "TRIGGERS_SYNTAX", 
			"ARGUMENTS", "PARENTS", "INHERITS", "ROOM_NAME", "ITEM_NAME", "ITEM_KNOWLEDGE", 
			"GENERIC_INHERITANCE", "TRIGGER_SELECTOR", "SINGLE_STRING", "STRING", 
			"ALPHANUMERIC", "INTEGER", "DECIMAL", "LPAREN", "RPAREN", "SEMICOLON", 
			"DOT", "EQUALS", "DASH", "WS", "STRINGLIST", "NUMBERLIST", "BOOLEAN"
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
	public String getGrammarFileName() { return "GameGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GameGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class New_messageContext extends ParserRuleContext {
		public TerminalNode MESSAGE() { return getToken(GameGrammarParser.MESSAGE, 0); }
		public TerminalNode LCURLY() { return getToken(GameGrammarParser.LCURLY, 0); }
		public Message_idContext message_id() {
			return getRuleContext(Message_idContext.class,0);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(GameGrammarParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(GameGrammarParser.SEMICOLON, i);
		}
		public TerminalNode STRING() { return getToken(GameGrammarParser.STRING, 0); }
		public TerminalNode RCURLY() { return getToken(GameGrammarParser.RCURLY, 0); }
		public New_messageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_new_message; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).enterNew_message(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).exitNew_message(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GameGrammarVisitor ) return ((GameGrammarVisitor<? extends T>)visitor).visitNew_message(this);
			else return visitor.visitChildren(this);
		}
	}

	public final New_messageContext new_message() throws RecognitionException {
		New_messageContext _localctx = new New_messageContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_new_message);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(MESSAGE);
			setState(93);
			match(LCURLY);
			setState(94);
			message_id();
			setState(95);
			match(SEMICOLON);
			setState(96);
			match(STRING);
			setState(97);
			match(SEMICOLON);
			setState(98);
			match(RCURLY);
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

	public static class Message_idContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(GameGrammarParser.ID, 0); }
		public Message_idContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_message_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).enterMessage_id(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).exitMessage_id(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GameGrammarVisitor ) return ((GameGrammarVisitor<? extends T>)visitor).visitMessage_id(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Message_idContext message_id() throws RecognitionException {
		Message_idContext _localctx = new Message_idContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_message_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(ID);
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

	public static class Message_textContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(GameGrammarParser.STRING, 0); }
		public Message_textContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_message_text; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).enterMessage_text(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).exitMessage_text(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GameGrammarVisitor ) return ((GameGrammarVisitor<? extends T>)visitor).visitMessage_text(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Message_textContext message_text() throws RecognitionException {
		Message_textContext _localctx = new Message_textContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_message_text);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			match(STRING);
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

	public static class Message_refContext extends ParserRuleContext {
		public TerminalNode HASH() { return getToken(GameGrammarParser.HASH, 0); }
		public Message_idContext message_id() {
			return getRuleContext(Message_idContext.class,0);
		}
		public Message_refContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_message_ref; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).enterMessage_ref(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).exitMessage_ref(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GameGrammarVisitor ) return ((GameGrammarVisitor<? extends T>)visitor).visitMessage_ref(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Message_refContext message_ref() throws RecognitionException {
		Message_refContext _localctx = new Message_refContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_message_ref);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			match(HASH);
			setState(105);
			message_id();
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

	public static class MessageContext extends ParserRuleContext {
		public Message_refContext message_ref() {
			return getRuleContext(Message_refContext.class,0);
		}
		public Message_textContext message_text() {
			return getRuleContext(Message_textContext.class,0);
		}
		public MessageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_message; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).enterMessage(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).exitMessage(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GameGrammarVisitor ) return ((GameGrammarVisitor<? extends T>)visitor).visitMessage(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MessageContext message() throws RecognitionException {
		MessageContext _localctx = new MessageContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_message);
		try {
			setState(109);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HASH:
				enterOuterAlt(_localctx, 1);
				{
				setState(107);
				message_ref();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(108);
				message_text();
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

	public static class TriggerContext extends ParserRuleContext {
		public TerminalNode ALPHANUMERIC() { return getToken(GameGrammarParser.ALPHANUMERIC, 0); }
		public TerminalNode TRIGGER_SELECTOR() { return getToken(GameGrammarParser.TRIGGER_SELECTOR, 0); }
		public TriggerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trigger; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).enterTrigger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).exitTrigger(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GameGrammarVisitor ) return ((GameGrammarVisitor<? extends T>)visitor).visitTrigger(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TriggerContext trigger() throws RecognitionException {
		TriggerContext _localctx = new TriggerContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_trigger);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(ALPHANUMERIC);
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TRIGGER_SELECTOR) {
				{
				setState(112);
				match(TRIGGER_SELECTOR);
				}
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

	public static class Precond_idContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(GameGrammarParser.ID, 0); }
		public Precond_idContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_precond_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).enterPrecond_id(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).exitPrecond_id(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GameGrammarVisitor ) return ((GameGrammarVisitor<? extends T>)visitor).visitPrecond_id(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Precond_idContext precond_id() throws RecognitionException {
		Precond_idContext _localctx = new Precond_idContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_precond_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			match(ID);
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

	public static class Precond_refContext extends ParserRuleContext {
		public TerminalNode HASH() { return getToken(GameGrammarParser.HASH, 0); }
		public Precond_idContext precond_id() {
			return getRuleContext(Precond_idContext.class,0);
		}
		public Precond_refContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_precond_ref; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).enterPrecond_ref(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).exitPrecond_ref(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GameGrammarVisitor ) return ((GameGrammarVisitor<? extends T>)visitor).visitPrecond_ref(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Precond_refContext precond_ref() throws RecognitionException {
		Precond_refContext _localctx = new Precond_refContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_precond_ref);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			match(HASH);
			setState(118);
			precond_id();
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

	public static class New_precondContext extends ParserRuleContext {
		public TerminalNode PRECOND() { return getToken(GameGrammarParser.PRECOND, 0); }
		public TerminalNode LCURLY() { return getToken(GameGrammarParser.LCURLY, 0); }
		public Precond_idContext precond_id() {
			return getRuleContext(Precond_idContext.class,0);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(GameGrammarParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(GameGrammarParser.SEMICOLON, i);
		}
		public Precond_bodyContext precond_body() {
			return getRuleContext(Precond_bodyContext.class,0);
		}
		public TerminalNode RCURLY() { return getToken(GameGrammarParser.RCURLY, 0); }
		public New_precondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_new_precond; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).enterNew_precond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).exitNew_precond(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GameGrammarVisitor ) return ((GameGrammarVisitor<? extends T>)visitor).visitNew_precond(this);
			else return visitor.visitChildren(this);
		}
	}

	public final New_precondContext new_precond() throws RecognitionException {
		New_precondContext _localctx = new New_precondContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_new_precond);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			match(PRECOND);
			setState(121);
			match(LCURLY);
			setState(122);
			precond_id();
			setState(123);
			match(SEMICOLON);
			setState(124);
			precond_body();
			setState(125);
			match(SEMICOLON);
			setState(126);
			match(RCURLY);
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

	public static class Precond_bodyContext extends ParserRuleContext {
		public TerminalNode SINGLE_STRING() { return getToken(GameGrammarParser.SINGLE_STRING, 0); }
		public TerminalNode LPAREN() { return getToken(GameGrammarParser.LPAREN, 0); }
		public TerminalNode STRING() { return getToken(GameGrammarParser.STRING, 0); }
		public TerminalNode RPAREN() { return getToken(GameGrammarParser.RPAREN, 0); }
		public Precond_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_precond_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).enterPrecond_body(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).exitPrecond_body(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GameGrammarVisitor ) return ((GameGrammarVisitor<? extends T>)visitor).visitPrecond_body(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Precond_bodyContext precond_body() throws RecognitionException {
		Precond_bodyContext _localctx = new Precond_bodyContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_precond_body);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			match(SINGLE_STRING);
			setState(129);
			match(LPAREN);
			setState(130);
			match(STRING);
			setState(131);
			match(RPAREN);
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

	public static class PrecondContext extends ParserRuleContext {
		public Precond_bodyContext precond_body() {
			return getRuleContext(Precond_bodyContext.class,0);
		}
		public Precond_refContext precond_ref() {
			return getRuleContext(Precond_refContext.class,0);
		}
		public PrecondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_precond; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).enterPrecond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).exitPrecond(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GameGrammarVisitor ) return ((GameGrammarVisitor<? extends T>)visitor).visitPrecond(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrecondContext precond() throws RecognitionException {
		PrecondContext _localctx = new PrecondContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_precond);
		try {
			setState(135);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SINGLE_STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(133);
				precond_body();
				}
				break;
			case HASH:
				enterOuterAlt(_localctx, 2);
				{
				setState(134);
				precond_ref();
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

	public static class Postcond_idContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(GameGrammarParser.ID, 0); }
		public Postcond_idContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postcond_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).enterPostcond_id(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).exitPostcond_id(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GameGrammarVisitor ) return ((GameGrammarVisitor<? extends T>)visitor).visitPostcond_id(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Postcond_idContext postcond_id() throws RecognitionException {
		Postcond_idContext _localctx = new Postcond_idContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_postcond_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			match(ID);
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

	public static class Postcond_refContext extends ParserRuleContext {
		public TerminalNode HASH() { return getToken(GameGrammarParser.HASH, 0); }
		public Postcond_idContext postcond_id() {
			return getRuleContext(Postcond_idContext.class,0);
		}
		public Postcond_refContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postcond_ref; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).enterPostcond_ref(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).exitPostcond_ref(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GameGrammarVisitor ) return ((GameGrammarVisitor<? extends T>)visitor).visitPostcond_ref(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Postcond_refContext postcond_ref() throws RecognitionException {
		Postcond_refContext _localctx = new Postcond_refContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_postcond_ref);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			match(HASH);
			setState(140);
			postcond_id();
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

	public static class Postcond_bodyContext extends ParserRuleContext {
		public TerminalNode SINGLE_STRING() { return getToken(GameGrammarParser.SINGLE_STRING, 0); }
		public Postcond_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postcond_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).enterPostcond_body(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).exitPostcond_body(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GameGrammarVisitor ) return ((GameGrammarVisitor<? extends T>)visitor).visitPostcond_body(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Postcond_bodyContext postcond_body() throws RecognitionException {
		Postcond_bodyContext _localctx = new Postcond_bodyContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_postcond_body);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			match(SINGLE_STRING);
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

	public static class New_postcondContext extends ParserRuleContext {
		public TerminalNode POSTCOND() { return getToken(GameGrammarParser.POSTCOND, 0); }
		public TerminalNode LCURLY() { return getToken(GameGrammarParser.LCURLY, 0); }
		public Postcond_idContext postcond_id() {
			return getRuleContext(Postcond_idContext.class,0);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(GameGrammarParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(GameGrammarParser.SEMICOLON, i);
		}
		public Postcond_bodyContext postcond_body() {
			return getRuleContext(Postcond_bodyContext.class,0);
		}
		public TerminalNode RCURLY() { return getToken(GameGrammarParser.RCURLY, 0); }
		public New_postcondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_new_postcond; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).enterNew_postcond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).exitNew_postcond(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GameGrammarVisitor ) return ((GameGrammarVisitor<? extends T>)visitor).visitNew_postcond(this);
			else return visitor.visitChildren(this);
		}
	}

	public final New_postcondContext new_postcond() throws RecognitionException {
		New_postcondContext _localctx = new New_postcondContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_new_postcond);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			match(POSTCOND);
			setState(145);
			match(LCURLY);
			setState(146);
			postcond_id();
			setState(147);
			match(SEMICOLON);
			setState(148);
			postcond_body();
			setState(149);
			match(SEMICOLON);
			setState(150);
			match(RCURLY);
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

	public static class PostcondContext extends ParserRuleContext {
		public Postcond_bodyContext postcond_body() {
			return getRuleContext(Postcond_bodyContext.class,0);
		}
		public Postcond_refContext postcond_ref() {
			return getRuleContext(Postcond_refContext.class,0);
		}
		public PostcondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postcond; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).enterPostcond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).exitPostcond(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GameGrammarVisitor ) return ((GameGrammarVisitor<? extends T>)visitor).visitPostcond(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PostcondContext postcond() throws RecognitionException {
		PostcondContext _localctx = new PostcondContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_postcond);
		try {
			setState(154);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SINGLE_STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(152);
				postcond_body();
				}
				break;
			case HASH:
				enterOuterAlt(_localctx, 2);
				{
				setState(153);
				postcond_ref();
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

	public static class PrecondsContext extends ParserRuleContext {
		public TerminalNode LSQUARE() { return getToken(GameGrammarParser.LSQUARE, 0); }
		public TerminalNode RSQUARE() { return getToken(GameGrammarParser.RSQUARE, 0); }
		public List<PrecondContext> precond() {
			return getRuleContexts(PrecondContext.class);
		}
		public PrecondContext precond(int i) {
			return getRuleContext(PrecondContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(GameGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GameGrammarParser.COMMA, i);
		}
		public PrecondsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_preconds; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).enterPreconds(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).exitPreconds(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GameGrammarVisitor ) return ((GameGrammarVisitor<? extends T>)visitor).visitPreconds(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrecondsContext preconds() throws RecognitionException {
		PrecondsContext _localctx = new PrecondsContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_preconds);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			match(LSQUARE);
			setState(165);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==HASH || _la==SINGLE_STRING) {
				{
				setState(157);
				precond();
				setState(162);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(158);
					match(COMMA);
					setState(159);
					precond();
					}
					}
					setState(164);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(167);
			match(RSQUARE);
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

	public static class TriggersContext extends ParserRuleContext {
		public TerminalNode LSQUARE() { return getToken(GameGrammarParser.LSQUARE, 0); }
		public List<TriggerContext> trigger() {
			return getRuleContexts(TriggerContext.class);
		}
		public TriggerContext trigger(int i) {
			return getRuleContext(TriggerContext.class,i);
		}
		public TerminalNode RSQUARE() { return getToken(GameGrammarParser.RSQUARE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(GameGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GameGrammarParser.COMMA, i);
		}
		public TriggersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_triggers; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).enterTriggers(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).exitTriggers(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GameGrammarVisitor ) return ((GameGrammarVisitor<? extends T>)visitor).visitTriggers(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TriggersContext triggers() throws RecognitionException {
		TriggersContext _localctx = new TriggersContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_triggers);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			match(LSQUARE);
			setState(170);
			trigger();
			setState(175);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(171);
				match(COMMA);
				setState(172);
				trigger();
				}
				}
				setState(177);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(178);
			match(RSQUARE);
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

	public static class PostcondsContext extends ParserRuleContext {
		public TerminalNode LSQUARE() { return getToken(GameGrammarParser.LSQUARE, 0); }
		public TerminalNode RSQUARE() { return getToken(GameGrammarParser.RSQUARE, 0); }
		public List<PostcondContext> postcond() {
			return getRuleContexts(PostcondContext.class);
		}
		public PostcondContext postcond(int i) {
			return getRuleContext(PostcondContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(GameGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GameGrammarParser.COMMA, i);
		}
		public PostcondsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postconds; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).enterPostconds(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).exitPostconds(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GameGrammarVisitor ) return ((GameGrammarVisitor<? extends T>)visitor).visitPostconds(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PostcondsContext postconds() throws RecognitionException {
		PostcondsContext _localctx = new PostcondsContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_postconds);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			match(LSQUARE);
			setState(189);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==HASH || _la==SINGLE_STRING) {
				{
				setState(181);
				postcond();
				setState(186);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(182);
					match(COMMA);
					setState(183);
					postcond();
					}
					}
					setState(188);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(191);
			match(RSQUARE);
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

	public static class ArgumentContext extends ParserRuleContext {
		public Item_refContext item_ref() {
			return getRuleContext(Item_refContext.class,0);
		}
		public TerminalNode STRING() { return getToken(GameGrammarParser.STRING, 0); }
		public ArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).enterArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).exitArgument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GameGrammarVisitor ) return ((GameGrammarVisitor<? extends T>)visitor).visitArgument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentContext argument() throws RecognitionException {
		ArgumentContext _localctx = new ArgumentContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_argument);
		try {
			setState(195);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HASH:
				enterOuterAlt(_localctx, 1);
				{
				setState(193);
				item_ref();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(194);
				match(STRING);
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

	public static class ArgumentsContext extends ParserRuleContext {
		public TerminalNode LSQUARE() { return getToken(GameGrammarParser.LSQUARE, 0); }
		public TerminalNode RSQUARE() { return getToken(GameGrammarParser.RSQUARE, 0); }
		public List<ArgumentContext> argument() {
			return getRuleContexts(ArgumentContext.class);
		}
		public ArgumentContext argument(int i) {
			return getRuleContext(ArgumentContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(GameGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GameGrammarParser.COMMA, i);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).enterArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).exitArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GameGrammarVisitor ) return ((GameGrammarVisitor<? extends T>)visitor).visitArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			match(LSQUARE);
			setState(206);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==HASH || _la==STRING) {
				{
				setState(198);
				argument();
				setState(203);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(199);
					match(COMMA);
					setState(200);
					argument();
					}
					}
					setState(205);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(208);
			match(RSQUARE);
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

	public static class New_actionContext extends ParserRuleContext {
		public TerminalNode ACTION() { return getToken(GameGrammarParser.ACTION, 0); }
		public TerminalNode LCURLY() { return getToken(GameGrammarParser.LCURLY, 0); }
		public Action_idContext action_id() {
			return getRuleContext(Action_idContext.class,0);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(GameGrammarParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(GameGrammarParser.SEMICOLON, i);
		}
		public List<TerminalNode> DOT() { return getTokens(GameGrammarParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(GameGrammarParser.DOT, i);
		}
		public TerminalNode ROOM() { return getToken(GameGrammarParser.ROOM, 0); }
		public Room_nameContext room_name() {
			return getRuleContext(Room_nameContext.class,0);
		}
		public TerminalNode TRIGGERS_SYNTAX() { return getToken(GameGrammarParser.TRIGGERS_SYNTAX, 0); }
		public TriggersContext triggers() {
			return getRuleContext(TriggersContext.class,0);
		}
		public TerminalNode ARGUMENTS() { return getToken(GameGrammarParser.ARGUMENTS, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public TerminalNode PRECONDS() { return getToken(GameGrammarParser.PRECONDS, 0); }
		public PrecondsContext preconds() {
			return getRuleContext(PrecondsContext.class,0);
		}
		public TerminalNode POSTCONDS() { return getToken(GameGrammarParser.POSTCONDS, 0); }
		public PostcondsContext postconds() {
			return getRuleContext(PostcondsContext.class,0);
		}
		public TerminalNode SUCCESSMESSAGE() { return getToken(GameGrammarParser.SUCCESSMESSAGE, 0); }
		public MessageContext message() {
			return getRuleContext(MessageContext.class,0);
		}
		public TerminalNode RCURLY() { return getToken(GameGrammarParser.RCURLY, 0); }
		public New_actionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_new_action; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).enterNew_action(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).exitNew_action(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GameGrammarVisitor ) return ((GameGrammarVisitor<? extends T>)visitor).visitNew_action(this);
			else return visitor.visitChildren(this);
		}
	}

	public final New_actionContext new_action() throws RecognitionException {
		New_actionContext _localctx = new New_actionContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_new_action);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			match(ACTION);
			setState(211);
			match(LCURLY);
			setState(212);
			action_id();
			setState(213);
			match(SEMICOLON);
			setState(214);
			match(DOT);
			setState(215);
			match(ROOM);
			setState(216);
			room_name();
			setState(217);
			match(SEMICOLON);
			setState(218);
			match(DOT);
			setState(219);
			match(TRIGGERS_SYNTAX);
			setState(220);
			triggers();
			setState(221);
			match(SEMICOLON);
			setState(222);
			match(DOT);
			setState(223);
			match(ARGUMENTS);
			setState(224);
			arguments();
			setState(225);
			match(SEMICOLON);
			setState(226);
			match(DOT);
			setState(227);
			match(PRECONDS);
			setState(228);
			preconds();
			setState(229);
			match(SEMICOLON);
			setState(230);
			match(DOT);
			setState(231);
			match(POSTCONDS);
			setState(232);
			postconds();
			setState(233);
			match(SEMICOLON);
			setState(234);
			match(DOT);
			setState(235);
			match(SUCCESSMESSAGE);
			setState(236);
			message();
			setState(237);
			match(SEMICOLON);
			setState(238);
			match(RCURLY);
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

	public static class ActionformatContext extends ParserRuleContext {
		public TerminalNode CUSTOM_TRIGGER() { return getToken(GameGrammarParser.CUSTOM_TRIGGER, 0); }
		public TerminalNode LCURLY() { return getToken(GameGrammarParser.LCURLY, 0); }
		public TerminalNode ALPHANUMERIC() { return getToken(GameGrammarParser.ALPHANUMERIC, 0); }
		public List<TerminalNode> SEMICOLON() { return getTokens(GameGrammarParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(GameGrammarParser.SEMICOLON, i);
		}
		public TerminalNode RCURLY() { return getToken(GameGrammarParser.RCURLY, 0); }
		public TerminalNode STRING() { return getToken(GameGrammarParser.STRING, 0); }
		public ActionformatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actionformat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).enterActionformat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).exitActionformat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GameGrammarVisitor ) return ((GameGrammarVisitor<? extends T>)visitor).visitActionformat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ActionformatContext actionformat() throws RecognitionException {
		ActionformatContext _localctx = new ActionformatContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_actionformat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			match(CUSTOM_TRIGGER);
			setState(241);
			match(LCURLY);
			setState(242);
			match(ALPHANUMERIC);
			setState(243);
			match(SEMICOLON);
			setState(246);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRING) {
				{
				setState(244);
				match(STRING);
				setState(245);
				match(SEMICOLON);
				}
			}

			setState(248);
			match(RCURLY);
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

	public static class Action_idContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(GameGrammarParser.ID, 0); }
		public Action_idContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_action_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).enterAction_id(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).exitAction_id(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GameGrammarVisitor ) return ((GameGrammarVisitor<? extends T>)visitor).visitAction_id(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Action_idContext action_id() throws RecognitionException {
		Action_idContext _localctx = new Action_idContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_action_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			match(ID);
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

	public static class Action_refContext extends ParserRuleContext {
		public TerminalNode HASH() { return getToken(GameGrammarParser.HASH, 0); }
		public Action_idContext action_id() {
			return getRuleContext(Action_idContext.class,0);
		}
		public Action_refContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_action_ref; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).enterAction_ref(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).exitAction_ref(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GameGrammarVisitor ) return ((GameGrammarVisitor<? extends T>)visitor).visitAction_ref(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Action_refContext action_ref() throws RecognitionException {
		Action_refContext _localctx = new Action_refContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_action_ref);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			match(HASH);
			setState(253);
			action_id();
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

	public static class ActionContext extends ParserRuleContext {
		public Action_refContext action_ref() {
			return getRuleContext(Action_refContext.class,0);
		}
		public ActionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_action; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).enterAction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).exitAction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GameGrammarVisitor ) return ((GameGrammarVisitor<? extends T>)visitor).visitAction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ActionContext action() throws RecognitionException {
		ActionContext _localctx = new ActionContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_action);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			action_ref();
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

	public static class ActionsContext extends ParserRuleContext {
		public List<ActionContext> action() {
			return getRuleContexts(ActionContext.class);
		}
		public ActionContext action(int i) {
			return getRuleContext(ActionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(GameGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GameGrammarParser.COMMA, i);
		}
		public ActionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).enterActions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).exitActions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GameGrammarVisitor ) return ((GameGrammarVisitor<? extends T>)visitor).visitActions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ActionsContext actions() throws RecognitionException {
		ActionsContext _localctx = new ActionsContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_actions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==HASH) {
				{
				setState(257);
				action();
				setState(262);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(258);
					match(COMMA);
					setState(259);
					action();
					}
					}
					setState(264);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
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

	public static class Item_idContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(GameGrammarParser.ID, 0); }
		public Item_idContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_item_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).enterItem_id(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).exitItem_id(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GameGrammarVisitor ) return ((GameGrammarVisitor<? extends T>)visitor).visitItem_id(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Item_idContext item_id() throws RecognitionException {
		Item_idContext _localctx = new Item_idContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_item_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
			match(ID);
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

	public static class Item_refContext extends ParserRuleContext {
		public TerminalNode HASH() { return getToken(GameGrammarParser.HASH, 0); }
		public Item_idContext item_id() {
			return getRuleContext(Item_idContext.class,0);
		}
		public Item_refContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_item_ref; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).enterItem_ref(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).exitItem_ref(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GameGrammarVisitor ) return ((GameGrammarVisitor<? extends T>)visitor).visitItem_ref(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Item_refContext item_ref() throws RecognitionException {
		Item_refContext _localctx = new Item_refContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_item_ref);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(269);
			match(HASH);
			setState(270);
			item_id();
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

	public static class Item_nameContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(GameGrammarParser.STRING, 0); }
		public Item_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_item_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).enterItem_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).exitItem_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GameGrammarVisitor ) return ((GameGrammarVisitor<? extends T>)visitor).visitItem_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Item_nameContext item_name() throws RecognitionException {
		Item_nameContext _localctx = new Item_nameContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_item_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
			match(STRING);
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

	public static class ItemContext extends ParserRuleContext {
		public Item_nameContext item_name() {
			return getRuleContext(Item_nameContext.class,0);
		}
		public Item_refContext item_ref() {
			return getRuleContext(Item_refContext.class,0);
		}
		public ItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_item; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).enterItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).exitItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GameGrammarVisitor ) return ((GameGrammarVisitor<? extends T>)visitor).visitItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ItemContext item() throws RecognitionException {
		ItemContext _localctx = new ItemContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_item);
		try {
			setState(276);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(274);
				item_name();
				}
				break;
			case HASH:
				enterOuterAlt(_localctx, 2);
				{
				setState(275);
				item_ref();
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

	public static class ItemsContext extends ParserRuleContext {
		public List<ItemContext> item() {
			return getRuleContexts(ItemContext.class);
		}
		public ItemContext item(int i) {
			return getRuleContext(ItemContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(GameGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GameGrammarParser.COMMA, i);
		}
		public ItemsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_items; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).enterItems(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).exitItems(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GameGrammarVisitor ) return ((GameGrammarVisitor<? extends T>)visitor).visitItems(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ItemsContext items() throws RecognitionException {
		ItemsContext _localctx = new ItemsContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_items);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(286);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==HASH || _la==STRING) {
				{
				setState(278);
				item();
				setState(283);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(279);
					match(COMMA);
					setState(280);
					item();
					}
					}
					setState(285);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
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

	public static class New_itemContext extends ParserRuleContext {
		public TerminalNode ITEM() { return getToken(GameGrammarParser.ITEM, 0); }
		public TerminalNode LCURLY() { return getToken(GameGrammarParser.LCURLY, 0); }
		public Item_idContext item_id() {
			return getRuleContext(Item_idContext.class,0);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(GameGrammarParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(GameGrammarParser.SEMICOLON, i);
		}
		public List<TerminalNode> DOT() { return getTokens(GameGrammarParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(GameGrammarParser.DOT, i);
		}
		public TerminalNode ROOM() { return getToken(GameGrammarParser.ROOM, 0); }
		public Room_nameContext room_name() {
			return getRuleContext(Room_nameContext.class,0);
		}
		public TerminalNode ITEM_NAME() { return getToken(GameGrammarParser.ITEM_NAME, 0); }
		public Item_nameContext item_name() {
			return getRuleContext(Item_nameContext.class,0);
		}
		public TerminalNode ITEM_KNOWLEDGE() { return getToken(GameGrammarParser.ITEM_KNOWLEDGE, 0); }
		public Knowledge_updatesContext knowledge_updates() {
			return getRuleContext(Knowledge_updatesContext.class,0);
		}
		public TerminalNode RCURLY() { return getToken(GameGrammarParser.RCURLY, 0); }
		public New_itemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_new_item; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).enterNew_item(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).exitNew_item(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GameGrammarVisitor ) return ((GameGrammarVisitor<? extends T>)visitor).visitNew_item(this);
			else return visitor.visitChildren(this);
		}
	}

	public final New_itemContext new_item() throws RecognitionException {
		New_itemContext _localctx = new New_itemContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_new_item);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(288);
			match(ITEM);
			setState(289);
			match(LCURLY);
			setState(290);
			item_id();
			setState(291);
			match(SEMICOLON);
			setState(292);
			match(DOT);
			setState(293);
			match(ROOM);
			setState(294);
			room_name();
			setState(295);
			match(SEMICOLON);
			setState(296);
			match(DOT);
			setState(297);
			match(ITEM_NAME);
			setState(298);
			item_name();
			setState(299);
			match(SEMICOLON);
			setState(300);
			match(DOT);
			setState(301);
			match(ITEM_KNOWLEDGE);
			setState(302);
			knowledge_updates();
			setState(303);
			match(SEMICOLON);
			setState(304);
			match(RCURLY);
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

	public static class Room_nameContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(GameGrammarParser.STRING, 0); }
		public Room_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_room_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).enterRoom_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).exitRoom_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GameGrammarVisitor ) return ((GameGrammarVisitor<? extends T>)visitor).visitRoom_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Room_nameContext room_name() throws RecognitionException {
		Room_nameContext _localctx = new Room_nameContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_room_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(306);
			match(STRING);
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

	public static class New_roomContext extends ParserRuleContext {
		public TerminalNode ROOM() { return getToken(GameGrammarParser.ROOM, 0); }
		public TerminalNode LCURLY() { return getToken(GameGrammarParser.LCURLY, 0); }
		public List<TerminalNode> DOT() { return getTokens(GameGrammarParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(GameGrammarParser.DOT, i);
		}
		public TerminalNode ROOM_NAME() { return getToken(GameGrammarParser.ROOM_NAME, 0); }
		public Room_nameContext room_name() {
			return getRuleContext(Room_nameContext.class,0);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(GameGrammarParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(GameGrammarParser.SEMICOLON, i);
		}
		public TerminalNode ACTIONS_SYNTAX() { return getToken(GameGrammarParser.ACTIONS_SYNTAX, 0); }
		public ActionsContext actions() {
			return getRuleContext(ActionsContext.class,0);
		}
		public TerminalNode ITEMS() { return getToken(GameGrammarParser.ITEMS, 0); }
		public ItemsContext items() {
			return getRuleContext(ItemsContext.class,0);
		}
		public TerminalNode RCURLY() { return getToken(GameGrammarParser.RCURLY, 0); }
		public New_roomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_new_room; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).enterNew_room(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).exitNew_room(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GameGrammarVisitor ) return ((GameGrammarVisitor<? extends T>)visitor).visitNew_room(this);
			else return visitor.visitChildren(this);
		}
	}

	public final New_roomContext new_room() throws RecognitionException {
		New_roomContext _localctx = new New_roomContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_new_room);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(308);
			match(ROOM);
			setState(309);
			match(LCURLY);
			setState(310);
			match(DOT);
			setState(311);
			match(ROOM_NAME);
			setState(312);
			room_name();
			setState(313);
			match(SEMICOLON);
			setState(314);
			match(DOT);
			setState(315);
			match(ACTIONS_SYNTAX);
			setState(316);
			actions();
			setState(317);
			match(SEMICOLON);
			setState(318);
			match(DOT);
			setState(319);
			match(ITEMS);
			setState(320);
			items();
			setState(321);
			match(SEMICOLON);
			setState(322);
			match(RCURLY);
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

	public static class Genericframe_nameContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(GameGrammarParser.STRING, 0); }
		public Genericframe_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_genericframe_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).enterGenericframe_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).exitGenericframe_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GameGrammarVisitor ) return ((GameGrammarVisitor<? extends T>)visitor).visitGenericframe_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Genericframe_nameContext genericframe_name() throws RecognitionException {
		Genericframe_nameContext _localctx = new Genericframe_nameContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_genericframe_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(324);
			match(STRING);
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

	public static class Map_entryContext extends ParserRuleContext {
		public TerminalNode ALPHANUMERIC() { return getToken(GameGrammarParser.ALPHANUMERIC, 0); }
		public TerminalNode EQUALS() { return getToken(GameGrammarParser.EQUALS, 0); }
		public TerminalNode DECIMAL() { return getToken(GameGrammarParser.DECIMAL, 0); }
		public TerminalNode STRING() { return getToken(GameGrammarParser.STRING, 0); }
		public TerminalNode STRINGLIST() { return getToken(GameGrammarParser.STRINGLIST, 0); }
		public TerminalNode NUMBERLIST() { return getToken(GameGrammarParser.NUMBERLIST, 0); }
		public TerminalNode BOOLEAN() { return getToken(GameGrammarParser.BOOLEAN, 0); }
		public Map_entryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_map_entry; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).enterMap_entry(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).exitMap_entry(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GameGrammarVisitor ) return ((GameGrammarVisitor<? extends T>)visitor).visitMap_entry(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Map_entryContext map_entry() throws RecognitionException {
		Map_entryContext _localctx = new Map_entryContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_map_entry);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(326);
			match(ALPHANUMERIC);
			setState(327);
			match(EQUALS);
			setState(328);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STRING) | (1L << DECIMAL) | (1L << STRINGLIST) | (1L << NUMBERLIST) | (1L << BOOLEAN))) != 0)) ) {
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

	public static class New_genericframeContext extends ParserRuleContext {
		public TerminalNode GENERICFRAME() { return getToken(GameGrammarParser.GENERICFRAME, 0); }
		public TerminalNode LCURLY() { return getToken(GameGrammarParser.LCURLY, 0); }
		public Genericframe_nameContext genericframe_name() {
			return getRuleContext(Genericframe_nameContext.class,0);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(GameGrammarParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(GameGrammarParser.SEMICOLON, i);
		}
		public TerminalNode LSQUARE() { return getToken(GameGrammarParser.LSQUARE, 0); }
		public TerminalNode RSQUARE() { return getToken(GameGrammarParser.RSQUARE, 0); }
		public TerminalNode RCURLY() { return getToken(GameGrammarParser.RCURLY, 0); }
		public List<Map_entryContext> map_entry() {
			return getRuleContexts(Map_entryContext.class);
		}
		public Map_entryContext map_entry(int i) {
			return getRuleContext(Map_entryContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(GameGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GameGrammarParser.COMMA, i);
		}
		public New_genericframeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_new_genericframe; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).enterNew_genericframe(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).exitNew_genericframe(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GameGrammarVisitor ) return ((GameGrammarVisitor<? extends T>)visitor).visitNew_genericframe(this);
			else return visitor.visitChildren(this);
		}
	}

	public final New_genericframeContext new_genericframe() throws RecognitionException {
		New_genericframeContext _localctx = new New_genericframeContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_new_genericframe);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(330);
			match(GENERICFRAME);
			setState(331);
			match(LCURLY);
			setState(332);
			genericframe_name();
			setState(333);
			match(SEMICOLON);
			setState(334);
			match(LSQUARE);
			setState(343);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ALPHANUMERIC) {
				{
				setState(335);
				map_entry();
				setState(340);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(336);
					match(COMMA);
					setState(337);
					map_entry();
					}
					}
					setState(342);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(345);
			match(RSQUARE);
			setState(346);
			match(SEMICOLON);
			setState(347);
			match(RCURLY);
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

	public static class Knowledge_updateContext extends ParserRuleContext {
		public TerminalNode SINGLE_STRING() { return getToken(GameGrammarParser.SINGLE_STRING, 0); }
		public Knowledge_updateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_knowledge_update; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).enterKnowledge_update(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).exitKnowledge_update(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GameGrammarVisitor ) return ((GameGrammarVisitor<? extends T>)visitor).visitKnowledge_update(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Knowledge_updateContext knowledge_update() throws RecognitionException {
		Knowledge_updateContext _localctx = new Knowledge_updateContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_knowledge_update);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(349);
			match(SINGLE_STRING);
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

	public static class Knowledge_updatesContext extends ParserRuleContext {
		public TerminalNode LSQUARE() { return getToken(GameGrammarParser.LSQUARE, 0); }
		public TerminalNode RSQUARE() { return getToken(GameGrammarParser.RSQUARE, 0); }
		public List<Knowledge_updateContext> knowledge_update() {
			return getRuleContexts(Knowledge_updateContext.class);
		}
		public Knowledge_updateContext knowledge_update(int i) {
			return getRuleContext(Knowledge_updateContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(GameGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GameGrammarParser.COMMA, i);
		}
		public Knowledge_updatesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_knowledge_updates; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).enterKnowledge_updates(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).exitKnowledge_updates(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GameGrammarVisitor ) return ((GameGrammarVisitor<? extends T>)visitor).visitKnowledge_updates(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Knowledge_updatesContext knowledge_updates() throws RecognitionException {
		Knowledge_updatesContext _localctx = new Knowledge_updatesContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_knowledge_updates);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(351);
			match(LSQUARE);
			setState(360);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SINGLE_STRING) {
				{
				setState(352);
				knowledge_update();
				setState(357);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(353);
					match(COMMA);
					setState(354);
					knowledge_update();
					}
					}
					setState(359);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(362);
			match(RSQUARE);
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

	public static class Global_itemContext extends ParserRuleContext {
		public Item_idContext item_id() {
			return getRuleContext(Item_idContext.class,0);
		}
		public TerminalNode STRING() { return getToken(GameGrammarParser.STRING, 0); }
		public Global_itemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_global_item; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).enterGlobal_item(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).exitGlobal_item(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GameGrammarVisitor ) return ((GameGrammarVisitor<? extends T>)visitor).visitGlobal_item(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Global_itemContext global_item() throws RecognitionException {
		Global_itemContext _localctx = new Global_itemContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_global_item);
		try {
			setState(366);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(364);
				item_id();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(365);
				match(STRING);
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

	public static class Global_itemsContext extends ParserRuleContext {
		public List<Global_itemContext> global_item() {
			return getRuleContexts(Global_itemContext.class);
		}
		public Global_itemContext global_item(int i) {
			return getRuleContext(Global_itemContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(GameGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GameGrammarParser.COMMA, i);
		}
		public Global_itemsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_global_items; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).enterGlobal_items(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).exitGlobal_items(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GameGrammarVisitor ) return ((GameGrammarVisitor<? extends T>)visitor).visitGlobal_items(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Global_itemsContext global_items() throws RecognitionException {
		Global_itemsContext _localctx = new Global_itemsContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_global_items);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(368);
			global_item();
			setState(373);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(369);
					match(COMMA);
					setState(370);
					global_item();
					}
					} 
				}
				setState(375);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
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

	public static class InheritanceContext extends ParserRuleContext {
		public TerminalNode LSQUARE() { return getToken(GameGrammarParser.LSQUARE, 0); }
		public Global_itemsContext global_items() {
			return getRuleContext(Global_itemsContext.class,0);
		}
		public TerminalNode RSQUARE() { return getToken(GameGrammarParser.RSQUARE, 0); }
		public TerminalNode INHERITS() { return getToken(GameGrammarParser.INHERITS, 0); }
		public TerminalNode STRING() { return getToken(GameGrammarParser.STRING, 0); }
		public InheritanceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inheritance; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).enterInheritance(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).exitInheritance(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GameGrammarVisitor ) return ((GameGrammarVisitor<? extends T>)visitor).visitInheritance(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InheritanceContext inheritance() throws RecognitionException {
		InheritanceContext _localctx = new InheritanceContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_inheritance);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(376);
			match(LSQUARE);
			setState(377);
			global_items();
			setState(378);
			match(RSQUARE);
			setState(379);
			match(INHERITS);
			setState(380);
			match(STRING);
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

	public static class KnowledgeContext extends ParserRuleContext {
		public TerminalNode KNOWLEDGE() { return getToken(GameGrammarParser.KNOWLEDGE, 0); }
		public TerminalNode LCURLY() { return getToken(GameGrammarParser.LCURLY, 0); }
		public List<TerminalNode> DOT() { return getTokens(GameGrammarParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(GameGrammarParser.DOT, i);
		}
		public TerminalNode GENERIC_INHERITANCE() { return getToken(GameGrammarParser.GENERIC_INHERITANCE, 0); }
		public List<InheritanceContext> inheritance() {
			return getRuleContexts(InheritanceContext.class);
		}
		public InheritanceContext inheritance(int i) {
			return getRuleContext(InheritanceContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(GameGrammarParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(GameGrammarParser.SEMICOLON, i);
		}
		public TerminalNode INITIAL() { return getToken(GameGrammarParser.INITIAL, 0); }
		public TerminalNode RCURLY() { return getToken(GameGrammarParser.RCURLY, 0); }
		public TerminalNode COMMA() { return getToken(GameGrammarParser.COMMA, 0); }
		public Knowledge_updatesContext knowledge_updates() {
			return getRuleContext(Knowledge_updatesContext.class,0);
		}
		public KnowledgeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_knowledge; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).enterKnowledge(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).exitKnowledge(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GameGrammarVisitor ) return ((GameGrammarVisitor<? extends T>)visitor).visitKnowledge(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KnowledgeContext knowledge() throws RecognitionException {
		KnowledgeContext _localctx = new KnowledgeContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_knowledge);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(382);
			match(KNOWLEDGE);
			setState(383);
			match(LCURLY);
			setState(384);
			match(DOT);
			setState(385);
			match(GENERIC_INHERITANCE);
			setState(386);
			inheritance();
			{
			setState(387);
			match(COMMA);
			setState(388);
			inheritance();
			}
			setState(390);
			match(SEMICOLON);
			setState(391);
			match(DOT);
			setState(392);
			match(INITIAL);
			setState(394);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LSQUARE) {
				{
				setState(393);
				knowledge_updates();
				}
			}

			setState(396);
			match(SEMICOLON);
			setState(397);
			match(RCURLY);
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

	public static class StartContext extends ParserRuleContext {
		public TerminalNode START() { return getToken(GameGrammarParser.START, 0); }
		public TerminalNode LCURLY() { return getToken(GameGrammarParser.LCURLY, 0); }
		public Room_nameContext room_name() {
			return getRuleContext(Room_nameContext.class,0);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(GameGrammarParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(GameGrammarParser.SEMICOLON, i);
		}
		public TerminalNode STRING() { return getToken(GameGrammarParser.STRING, 0); }
		public TerminalNode RCURLY() { return getToken(GameGrammarParser.RCURLY, 0); }
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GameGrammarVisitor ) return ((GameGrammarVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(399);
			match(START);
			setState(400);
			match(LCURLY);
			setState(401);
			room_name();
			setState(402);
			match(SEMICOLON);
			setState(403);
			match(STRING);
			setState(404);
			match(SEMICOLON);
			setState(405);
			match(RCURLY);
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

	public static class GameContext extends ParserRuleContext {
		public StartContext start() {
			return getRuleContext(StartContext.class,0);
		}
		public TerminalNode EOF() { return getToken(GameGrammarParser.EOF, 0); }
		public List<New_messageContext> new_message() {
			return getRuleContexts(New_messageContext.class);
		}
		public New_messageContext new_message(int i) {
			return getRuleContext(New_messageContext.class,i);
		}
		public List<New_actionContext> new_action() {
			return getRuleContexts(New_actionContext.class);
		}
		public New_actionContext new_action(int i) {
			return getRuleContext(New_actionContext.class,i);
		}
		public List<New_itemContext> new_item() {
			return getRuleContexts(New_itemContext.class);
		}
		public New_itemContext new_item(int i) {
			return getRuleContext(New_itemContext.class,i);
		}
		public List<New_roomContext> new_room() {
			return getRuleContexts(New_roomContext.class);
		}
		public New_roomContext new_room(int i) {
			return getRuleContext(New_roomContext.class,i);
		}
		public List<ActionformatContext> actionformat() {
			return getRuleContexts(ActionformatContext.class);
		}
		public ActionformatContext actionformat(int i) {
			return getRuleContext(ActionformatContext.class,i);
		}
		public List<New_postcondContext> new_postcond() {
			return getRuleContexts(New_postcondContext.class);
		}
		public New_postcondContext new_postcond(int i) {
			return getRuleContext(New_postcondContext.class,i);
		}
		public List<New_precondContext> new_precond() {
			return getRuleContexts(New_precondContext.class);
		}
		public New_precondContext new_precond(int i) {
			return getRuleContext(New_precondContext.class,i);
		}
		public List<New_genericframeContext> new_genericframe() {
			return getRuleContexts(New_genericframeContext.class);
		}
		public New_genericframeContext new_genericframe(int i) {
			return getRuleContext(New_genericframeContext.class,i);
		}
		public KnowledgeContext knowledge() {
			return getRuleContext(KnowledgeContext.class,0);
		}
		public GameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_game; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).enterGame(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).exitGame(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GameGrammarVisitor ) return ((GameGrammarVisitor<? extends T>)visitor).visitGame(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GameContext game() throws RecognitionException {
		GameContext _localctx = new GameContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_game);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(407);
			start();
			setState(417);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MESSAGE) | (1L << ACTION) | (1L << ROOM) | (1L << ITEM) | (1L << PRECOND) | (1L << POSTCOND) | (1L << CUSTOM_TRIGGER))) != 0)) {
				{
				setState(415);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case MESSAGE:
					{
					setState(408);
					new_message();
					}
					break;
				case ACTION:
					{
					setState(409);
					new_action();
					}
					break;
				case ITEM:
					{
					setState(410);
					new_item();
					}
					break;
				case ROOM:
					{
					setState(411);
					new_room();
					}
					break;
				case CUSTOM_TRIGGER:
					{
					setState(412);
					actionformat();
					}
					break;
				case POSTCOND:
					{
					setState(413);
					new_postcond();
					}
					break;
				case PRECOND:
					{
					setState(414);
					new_precond();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(419);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(423);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==GENERICFRAME) {
				{
				{
				setState(420);
				new_genericframe();
				}
				}
				setState(425);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(427);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KNOWLEDGE) {
				{
				setState(426);
				knowledge();
				}
			}

			setState(429);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\62\u01b2\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4"+
		"\3\5\3\5\3\5\3\6\3\6\5\6p\n\6\3\7\3\7\5\7t\n\7\3\b\3\b\3\t\3\t\3\t\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\5\f\u008a"+
		"\n\f\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\21\3\21\5\21\u009d\n\21\3\22\3\22\3\22\3\22\7\22\u00a3\n\22"+
		"\f\22\16\22\u00a6\13\22\5\22\u00a8\n\22\3\22\3\22\3\23\3\23\3\23\3\23"+
		"\7\23\u00b0\n\23\f\23\16\23\u00b3\13\23\3\23\3\23\3\24\3\24\3\24\3\24"+
		"\7\24\u00bb\n\24\f\24\16\24\u00be\13\24\5\24\u00c0\n\24\3\24\3\24\3\25"+
		"\3\25\5\25\u00c6\n\25\3\26\3\26\3\26\3\26\7\26\u00cc\n\26\f\26\16\26\u00cf"+
		"\13\26\5\26\u00d1\n\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3"+
		"\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3"+
		"\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3"+
		"\30\5\30\u00f9\n\30\3\30\3\30\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\34"+
		"\3\34\3\34\7\34\u0107\n\34\f\34\16\34\u010a\13\34\5\34\u010c\n\34\3\35"+
		"\3\35\3\36\3\36\3\36\3\37\3\37\3 \3 \5 \u0117\n \3!\3!\3!\7!\u011c\n!"+
		"\f!\16!\u011f\13!\5!\u0121\n!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\""+
		"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3"+
		"$\3$\3$\3$\3$\3$\3%\3%\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\7\'"+
		"\u0155\n\'\f\'\16\'\u0158\13\'\5\'\u015a\n\'\3\'\3\'\3\'\3\'\3(\3(\3)"+
		"\3)\3)\3)\7)\u0166\n)\f)\16)\u0169\13)\5)\u016b\n)\3)\3)\3*\3*\5*\u0171"+
		"\n*\3+\3+\3+\7+\u0176\n+\f+\16+\u0179\13+\3,\3,\3,\3,\3,\3,\3-\3-\3-\3"+
		"-\3-\3-\3-\3-\3-\3-\3-\3-\5-\u018d\n-\3-\3-\3-\3.\3.\3.\3.\3.\3.\3.\3"+
		".\3/\3/\3/\3/\3/\3/\3/\3/\7/\u01a2\n/\f/\16/\u01a5\13/\3/\7/\u01a8\n/"+
		"\f/\16/\u01ab\13/\3/\5/\u01ae\n/\3/\3/\3/\3\u0177\2\60\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\\2\3"+
		"\5\2%%((\60\62\2\u01a5\2^\3\2\2\2\4f\3\2\2\2\6h\3\2\2\2\bj\3\2\2\2\no"+
		"\3\2\2\2\fq\3\2\2\2\16u\3\2\2\2\20w\3\2\2\2\22z\3\2\2\2\24\u0082\3\2\2"+
		"\2\26\u0089\3\2\2\2\30\u008b\3\2\2\2\32\u008d\3\2\2\2\34\u0090\3\2\2\2"+
		"\36\u0092\3\2\2\2 \u009c\3\2\2\2\"\u009e\3\2\2\2$\u00ab\3\2\2\2&\u00b6"+
		"\3\2\2\2(\u00c5\3\2\2\2*\u00c7\3\2\2\2,\u00d4\3\2\2\2.\u00f2\3\2\2\2\60"+
		"\u00fc\3\2\2\2\62\u00fe\3\2\2\2\64\u0101\3\2\2\2\66\u010b\3\2\2\28\u010d"+
		"\3\2\2\2:\u010f\3\2\2\2<\u0112\3\2\2\2>\u0116\3\2\2\2@\u0120\3\2\2\2B"+
		"\u0122\3\2\2\2D\u0134\3\2\2\2F\u0136\3\2\2\2H\u0146\3\2\2\2J\u0148\3\2"+
		"\2\2L\u014c\3\2\2\2N\u015f\3\2\2\2P\u0161\3\2\2\2R\u0170\3\2\2\2T\u0172"+
		"\3\2\2\2V\u017a\3\2\2\2X\u0180\3\2\2\2Z\u0191\3\2\2\2\\\u0199\3\2\2\2"+
		"^_\7\n\2\2_`\7\4\2\2`a\5\4\3\2ab\7+\2\2bc\7%\2\2cd\7+\2\2de\7\5\2\2e\3"+
		"\3\2\2\2fg\7\3\2\2g\5\3\2\2\2hi\7%\2\2i\7\3\2\2\2jk\7\b\2\2kl\5\4\3\2"+
		"l\t\3\2\2\2mp\5\b\5\2np\5\6\4\2om\3\2\2\2on\3\2\2\2p\13\3\2\2\2qs\7&\2"+
		"\2rt\7#\2\2sr\3\2\2\2st\3\2\2\2t\r\3\2\2\2uv\7\3\2\2v\17\3\2\2\2wx\7\b"+
		"\2\2xy\5\16\b\2y\21\3\2\2\2z{\7\17\2\2{|\7\4\2\2|}\5\16\b\2}~\7+\2\2~"+
		"\177\5\24\13\2\177\u0080\7+\2\2\u0080\u0081\7\5\2\2\u0081\23\3\2\2\2\u0082"+
		"\u0083\7$\2\2\u0083\u0084\7)\2\2\u0084\u0085\7%\2\2\u0085\u0086\7*\2\2"+
		"\u0086\25\3\2\2\2\u0087\u008a\5\24\13\2\u0088\u008a\5\20\t\2\u0089\u0087"+
		"\3\2\2\2\u0089\u0088\3\2\2\2\u008a\27\3\2\2\2\u008b\u008c\7\3\2\2\u008c"+
		"\31\3\2\2\2\u008d\u008e\7\b\2\2\u008e\u008f\5\30\r\2\u008f\33\3\2\2\2"+
		"\u0090\u0091\7$\2\2\u0091\35\3\2\2\2\u0092\u0093\7\20\2\2\u0093\u0094"+
		"\7\4\2\2\u0094\u0095\5\30\r\2\u0095\u0096\7+\2\2\u0096\u0097\5\34\17\2"+
		"\u0097\u0098\7+\2\2\u0098\u0099\7\5\2\2\u0099\37\3\2\2\2\u009a\u009d\5"+
		"\34\17\2\u009b\u009d\5\32\16\2\u009c\u009a\3\2\2\2\u009c\u009b\3\2\2\2"+
		"\u009d!\3\2\2\2\u009e\u00a7\7\6\2\2\u009f\u00a4\5\26\f\2\u00a0\u00a1\7"+
		"\26\2\2\u00a1\u00a3\5\26\f\2\u00a2\u00a0\3\2\2\2\u00a3\u00a6\3\2\2\2\u00a4"+
		"\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a8\3\2\2\2\u00a6\u00a4\3\2"+
		"\2\2\u00a7\u009f\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9"+
		"\u00aa\7\7\2\2\u00aa#\3\2\2\2\u00ab\u00ac\7\6\2\2\u00ac\u00b1\5\f\7\2"+
		"\u00ad\u00ae\7\26\2\2\u00ae\u00b0\5\f\7\2\u00af\u00ad\3\2\2\2\u00b0\u00b3"+
		"\3\2\2\2\u00b1\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b4\3\2\2\2\u00b3"+
		"\u00b1\3\2\2\2\u00b4\u00b5\7\7\2\2\u00b5%\3\2\2\2\u00b6\u00bf\7\6\2\2"+
		"\u00b7\u00bc\5 \21\2\u00b8\u00b9\7\26\2\2\u00b9\u00bb\5 \21\2\u00ba\u00b8"+
		"\3\2\2\2\u00bb\u00be\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd"+
		"\u00c0\3\2\2\2\u00be\u00bc\3\2\2\2\u00bf\u00b7\3\2\2\2\u00bf\u00c0\3\2"+
		"\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c2\7\7\2\2\u00c2\'\3\2\2\2\u00c3\u00c6"+
		"\5:\36\2\u00c4\u00c6\7%\2\2\u00c5\u00c3\3\2\2\2\u00c5\u00c4\3\2\2\2\u00c6"+
		")\3\2\2\2\u00c7\u00d0\7\6\2\2\u00c8\u00cd\5(\25\2\u00c9\u00ca\7\26\2\2"+
		"\u00ca\u00cc\5(\25\2\u00cb\u00c9\3\2\2\2\u00cc\u00cf\3\2\2\2\u00cd\u00cb"+
		"\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00d1\3\2\2\2\u00cf\u00cd\3\2\2\2\u00d0"+
		"\u00c8\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d3\7\7"+
		"\2\2\u00d3+\3\2\2\2\u00d4\u00d5\7\13\2\2\u00d5\u00d6\7\4\2\2\u00d6\u00d7"+
		"\5\60\31\2\u00d7\u00d8\7+\2\2\u00d8\u00d9\7,\2\2\u00d9\u00da\7\f\2\2\u00da"+
		"\u00db\5D#\2\u00db\u00dc\7+\2\2\u00dc\u00dd\7,\2\2\u00dd\u00de\7\33\2"+
		"\2\u00de\u00df\5$\23\2\u00df\u00e0\7+\2\2\u00e0\u00e1\7,\2\2\u00e1\u00e2"+
		"\7\34\2\2\u00e2\u00e3\5*\26\2\u00e3\u00e4\7+\2\2\u00e4\u00e5\7,\2\2\u00e5"+
		"\u00e6\7\25\2\2\u00e6\u00e7\5\"\22\2\u00e7\u00e8\7+\2\2\u00e8\u00e9\7"+
		",\2\2\u00e9\u00ea\7\24\2\2\u00ea\u00eb\5&\24\2\u00eb\u00ec\7+\2\2\u00ec"+
		"\u00ed\7,\2\2\u00ed\u00ee\7\32\2\2\u00ee\u00ef\5\n\6\2\u00ef\u00f0\7+"+
		"\2\2\u00f0\u00f1\7\5\2\2\u00f1-\3\2\2\2\u00f2\u00f3\7\22\2\2\u00f3\u00f4"+
		"\7\4\2\2\u00f4\u00f5\7&\2\2\u00f5\u00f8\7+\2\2\u00f6\u00f7\7%\2\2\u00f7"+
		"\u00f9\7+\2\2\u00f8\u00f6\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00fa\3\2"+
		"\2\2\u00fa\u00fb\7\5\2\2\u00fb/\3\2\2\2\u00fc\u00fd\7\3\2\2\u00fd\61\3"+
		"\2\2\2\u00fe\u00ff\7\b\2\2\u00ff\u0100\5\60\31\2\u0100\63\3\2\2\2\u0101"+
		"\u0102\5\62\32\2\u0102\65\3\2\2\2\u0103\u0108\5\64\33\2\u0104\u0105\7"+
		"\26\2\2\u0105\u0107\5\64\33\2\u0106\u0104\3\2\2\2\u0107\u010a\3\2\2\2"+
		"\u0108\u0106\3\2\2\2\u0108\u0109\3\2\2\2\u0109\u010c\3\2\2\2\u010a\u0108"+
		"\3\2\2\2\u010b\u0103\3\2\2\2\u010b\u010c\3\2\2\2\u010c\67\3\2\2\2\u010d"+
		"\u010e\7\3\2\2\u010e9\3\2\2\2\u010f\u0110\7\b\2\2\u0110\u0111\58\35\2"+
		"\u0111;\3\2\2\2\u0112\u0113\7%\2\2\u0113=\3\2\2\2\u0114\u0117\5<\37\2"+
		"\u0115\u0117\5:\36\2\u0116\u0114\3\2\2\2\u0116\u0115\3\2\2\2\u0117?\3"+
		"\2\2\2\u0118\u011d\5> \2\u0119\u011a\7\26\2\2\u011a\u011c\5> \2\u011b"+
		"\u0119\3\2\2\2\u011c\u011f\3\2\2\2\u011d\u011b\3\2\2\2\u011d\u011e\3\2"+
		"\2\2\u011e\u0121\3\2\2\2\u011f\u011d\3\2\2\2\u0120\u0118\3\2\2\2\u0120"+
		"\u0121\3\2\2\2\u0121A\3\2\2\2\u0122\u0123\7\r\2\2\u0123\u0124\7\4\2\2"+
		"\u0124\u0125\58\35\2\u0125\u0126\7+\2\2\u0126\u0127\7,\2\2\u0127\u0128"+
		"\7\f\2\2\u0128\u0129\5D#\2\u0129\u012a\7+\2\2\u012a\u012b\7,\2\2\u012b"+
		"\u012c\7 \2\2\u012c\u012d\5<\37\2\u012d\u012e\7+\2\2\u012e\u012f\7,\2"+
		"\2\u012f\u0130\7!\2\2\u0130\u0131\5P)\2\u0131\u0132\7+\2\2\u0132\u0133"+
		"\7\5\2\2\u0133C\3\2\2\2\u0134\u0135\7%\2\2\u0135E\3\2\2\2\u0136\u0137"+
		"\7\f\2\2\u0137\u0138\7\4\2\2\u0138\u0139\7,\2\2\u0139\u013a\7\37\2\2\u013a"+
		"\u013b\5D#\2\u013b\u013c\7+\2\2\u013c\u013d\7,\2\2\u013d\u013e\7\27\2"+
		"\2\u013e\u013f\5\66\34\2\u013f\u0140\7+\2\2\u0140\u0141\7,\2\2\u0141\u0142"+
		"\7\30\2\2\u0142\u0143\5@!\2\u0143\u0144\7+\2\2\u0144\u0145\7\5\2\2\u0145"+
		"G\3\2\2\2\u0146\u0147\7%\2\2\u0147I\3\2\2\2\u0148\u0149\7&\2\2\u0149\u014a"+
		"\7-\2\2\u014a\u014b\t\2\2\2\u014bK\3\2\2\2\u014c\u014d\7\21\2\2\u014d"+
		"\u014e\7\4\2\2\u014e\u014f\5H%\2\u014f\u0150\7+\2\2\u0150\u0159\7\6\2"+
		"\2\u0151\u0156\5J&\2\u0152\u0153\7\26\2\2\u0153\u0155\5J&\2\u0154\u0152"+
		"\3\2\2\2\u0155\u0158\3\2\2\2\u0156\u0154\3\2\2\2\u0156\u0157\3\2\2\2\u0157"+
		"\u015a\3\2\2\2\u0158\u0156\3\2\2\2\u0159\u0151\3\2\2\2\u0159\u015a\3\2"+
		"\2\2\u015a\u015b\3\2\2\2\u015b\u015c\7\7\2\2\u015c\u015d\7+\2\2\u015d"+
		"\u015e\7\5\2\2\u015eM\3\2\2\2\u015f\u0160\7$\2\2\u0160O\3\2\2\2\u0161"+
		"\u016a\7\6\2\2\u0162\u0167\5N(\2\u0163\u0164\7\26\2\2\u0164\u0166\5N("+
		"\2\u0165\u0163\3\2\2\2\u0166\u0169\3\2\2\2\u0167\u0165\3\2\2\2\u0167\u0168"+
		"\3\2\2\2\u0168\u016b\3\2\2\2\u0169\u0167\3\2\2\2\u016a\u0162\3\2\2\2\u016a"+
		"\u016b\3\2\2\2\u016b\u016c\3\2\2\2\u016c\u016d\7\7\2\2\u016dQ\3\2\2\2"+
		"\u016e\u0171\58\35\2\u016f\u0171\7%\2\2\u0170\u016e\3\2\2\2\u0170\u016f"+
		"\3\2\2\2\u0171S\3\2\2\2\u0172\u0177\5R*\2\u0173\u0174\7\26\2\2\u0174\u0176"+
		"\5R*\2\u0175\u0173\3\2\2\2\u0176\u0179\3\2\2\2\u0177\u0178\3\2\2\2\u0177"+
		"\u0175\3\2\2\2\u0178U\3\2\2\2\u0179\u0177\3\2\2\2\u017a\u017b\7\6\2\2"+
		"\u017b\u017c\5T+\2\u017c\u017d\7\7\2\2\u017d\u017e\7\36\2\2\u017e\u017f"+
		"\7%\2\2\u017fW\3\2\2\2\u0180\u0181\7\16\2\2\u0181\u0182\7\4\2\2\u0182"+
		"\u0183\7,\2\2\u0183\u0184\7\"\2\2\u0184\u0185\5V,\2\u0185\u0186\7\26\2"+
		"\2\u0186\u0187\5V,\2\u0187\u0188\3\2\2\2\u0188\u0189\7+\2\2\u0189\u018a"+
		"\7,\2\2\u018a\u018c\7\23\2\2\u018b\u018d\5P)\2\u018c\u018b\3\2\2\2\u018c"+
		"\u018d\3\2\2\2\u018d\u018e\3\2\2\2\u018e\u018f\7+\2\2\u018f\u0190\7\5"+
		"\2\2\u0190Y\3\2\2\2\u0191\u0192\7\t\2\2\u0192\u0193\7\4\2\2\u0193\u0194"+
		"\5D#\2\u0194\u0195\7+\2\2\u0195\u0196\7%\2\2\u0196\u0197\7+\2\2\u0197"+
		"\u0198\7\5\2\2\u0198[\3\2\2\2\u0199\u01a3\5Z.\2\u019a\u01a2\5\2\2\2\u019b"+
		"\u01a2\5,\27\2\u019c\u01a2\5B\"\2\u019d\u01a2\5F$\2\u019e\u01a2\5.\30"+
		"\2\u019f\u01a2\5\36\20\2\u01a0\u01a2\5\22\n\2\u01a1\u019a\3\2\2\2\u01a1"+
		"\u019b\3\2\2\2\u01a1\u019c\3\2\2\2\u01a1\u019d\3\2\2\2\u01a1\u019e\3\2"+
		"\2\2\u01a1\u019f\3\2\2\2\u01a1\u01a0\3\2\2\2\u01a2\u01a5\3\2\2\2\u01a3"+
		"\u01a1\3\2\2\2\u01a3\u01a4\3\2\2\2\u01a4\u01a9\3\2\2\2\u01a5\u01a3\3\2"+
		"\2\2\u01a6\u01a8\5L\'\2\u01a7\u01a6\3\2\2\2\u01a8\u01ab\3\2\2\2\u01a9"+
		"\u01a7\3\2\2\2\u01a9\u01aa\3\2\2\2\u01aa\u01ad\3\2\2\2\u01ab\u01a9\3\2"+
		"\2\2\u01ac\u01ae\5X-\2\u01ad\u01ac\3\2\2\2\u01ad\u01ae\3\2\2\2\u01ae\u01af"+
		"\3\2\2\2\u01af\u01b0\7\2\2\3\u01b0]\3\2\2\2\37os\u0089\u009c\u00a4\u00a7"+
		"\u00b1\u00bc\u00bf\u00c5\u00cd\u00d0\u00f8\u0108\u010b\u0116\u011d\u0120"+
		"\u0156\u0159\u0167\u016a\u0170\u0177\u018c\u01a1\u01a3\u01a9\u01ad";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}