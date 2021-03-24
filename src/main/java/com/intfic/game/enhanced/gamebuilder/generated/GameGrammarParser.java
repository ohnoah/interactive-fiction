// Generated from /Users/noahohrner/OneDrive - University of Cambridge/Dissertation/Code/interactive-fiction/GameGrammar.g4 by ANTLR 4.9.1
package com.intfic.game.enhanced.gamebuilder.generated;
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
		CUSTOM_TRIGGER=16, INITIAL=17, POSTCONDS=18, PRECONDS=19, ITEM_ADJECTIVES=20, 
		ITEM_SYNONYMS=21, COMMA=22, ACTIONS_SYNTAX=23, ITEMS=24, NAME=25, SUCCESSMESSAGE=26, 
		TRIGGERS_SYNTAX=27, ARGUMENTS=28, PARENTS=29, INHERITS=30, ROOM_NAME=31, 
		ITEM_NAME=32, ITEM_KNOWLEDGE=33, GENERIC_INHERITANCE=34, ADD_TRIGGER=35, 
		TRIGGER_SELECTOR=36, PREFIX_ROOM=37, SINGLE_STRING=38, STRING=39, ALPHANUMERIC=40, 
		INTEGER=41, DECIMAL=42, LPAREN=43, RPAREN=44, SEMICOLON=45, DOT=46, EQUALS=47, 
		WS=48;
	public static final int
		RULE_new_message = 0, RULE_message_id = 1, RULE_message_text = 2, RULE_message_ref = 3, 
		RULE_message = 4, RULE_trigger_selector = 5, RULE_trigger = 6, RULE_precond_id = 7, 
		RULE_precond_ref = 8, RULE_new_precond = 9, RULE_precond_body = 10, RULE_precond = 11, 
		RULE_postcond_id = 12, RULE_postcond_ref = 13, RULE_postcond_body = 14, 
		RULE_new_postcond = 15, RULE_postcond = 16, RULE_preconds = 17, RULE_triggers = 18, 
		RULE_postconds = 19, RULE_argument = 20, RULE_arguments = 21, RULE_new_action = 22, 
		RULE_add_trigger = 23, RULE_actionformat = 24, RULE_action_id = 25, RULE_action_ref = 26, 
		RULE_action = 27, RULE_actions = 28, RULE_item_id = 29, RULE_item_ref = 30, 
		RULE_item_name = 31, RULE_item = 32, RULE_items = 33, RULE_item_adjective = 34, 
		RULE_item_adjectives = 35, RULE_item_synonym = 36, RULE_item_synonyms = 37, 
		RULE_new_item = 38, RULE_room_name = 39, RULE_new_room = 40, RULE_genericframe_name = 41, 
		RULE_map_entry = 42, RULE_map_entries = 43, RULE_new_genericframe = 44, 
		RULE_knowledge_update = 45, RULE_knowledge_updates = 46, RULE_global_item = 47, 
		RULE_global_items = 48, RULE_inheritance = 49, RULE_inheritances = 50, 
		RULE_knowledge = 51, RULE_start = 52, RULE_game = 53;
	private static String[] makeRuleNames() {
		return new String[] {
			"new_message", "message_id", "message_text", "message_ref", "message", 
			"trigger_selector", "trigger", "precond_id", "precond_ref", "new_precond", 
			"precond_body", "precond", "postcond_id", "postcond_ref", "postcond_body", 
			"new_postcond", "postcond", "preconds", "triggers", "postconds", "argument", 
			"arguments", "new_action", "add_trigger", "actionformat", "action_id", 
			"action_ref", "action", "actions", "item_id", "item_ref", "item_name", 
			"item", "items", "item_adjective", "item_adjectives", "item_synonym", 
			"item_synonyms", "new_item", "room_name", "new_room", "genericframe_name", 
			"map_entry", "map_entries", "new_genericframe", "knowledge_update", "knowledge_updates", 
			"global_item", "global_items", "inheritance", "inheritances", "knowledge", 
			"start", "game"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'{'", "'}'", "'['", "']'", "'#'", "'start'", "'message'", 
			"'action'", "'room'", "'item'", "'knowledge'", "'precond'", "'postcond'", 
			"'generic_frame'", "'custom_trigger'", "'initial'", "'postconds'", "'preconds'", 
			"'adjectives'", "'synonyms'", "','", "'actions'", "'items'", "'name'", 
			"'success_msg'", "'action_triggers'", "'args'", "'parents'", "'inherits'", 
			"'room_name'", "'item_name'", "'item_knowledge'", "'generic_inheritance'", 
			"'add_trigger'", null, "'prefix_room'", null, null, null, null, null, 
			"'('", "')'", "';'", "'.'", "'<-'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ID", "LCURLY", "RCURLY", "LSQUARE", "RSQUARE", "HASH", "START", 
			"MESSAGE", "ACTION", "ROOM", "ITEM", "KNOWLEDGE", "PRECOND", "POSTCOND", 
			"GENERICFRAME", "CUSTOM_TRIGGER", "INITIAL", "POSTCONDS", "PRECONDS", 
			"ITEM_ADJECTIVES", "ITEM_SYNONYMS", "COMMA", "ACTIONS_SYNTAX", "ITEMS", 
			"NAME", "SUCCESSMESSAGE", "TRIGGERS_SYNTAX", "ARGUMENTS", "PARENTS", 
			"INHERITS", "ROOM_NAME", "ITEM_NAME", "ITEM_KNOWLEDGE", "GENERIC_INHERITANCE", 
			"ADD_TRIGGER", "TRIGGER_SELECTOR", "PREFIX_ROOM", "SINGLE_STRING", "STRING", 
			"ALPHANUMERIC", "INTEGER", "DECIMAL", "LPAREN", "RPAREN", "SEMICOLON", 
			"DOT", "EQUALS", "WS"
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
			setState(108);
			match(MESSAGE);
			setState(109);
			match(LCURLY);
			setState(110);
			message_id();
			setState(111);
			match(SEMICOLON);
			setState(112);
			match(STRING);
			setState(113);
			match(SEMICOLON);
			setState(114);
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
			setState(116);
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
			setState(118);
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
			setState(120);
			match(HASH);
			setState(121);
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
			setState(125);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HASH:
				enterOuterAlt(_localctx, 1);
				{
				setState(123);
				message_ref();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(124);
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

	public static class Trigger_selectorContext extends ParserRuleContext {
		public TerminalNode TRIGGER_SELECTOR() { return getToken(GameGrammarParser.TRIGGER_SELECTOR, 0); }
		public Trigger_selectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trigger_selector; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).enterTrigger_selector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).exitTrigger_selector(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GameGrammarVisitor ) return ((GameGrammarVisitor<? extends T>)visitor).visitTrigger_selector(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Trigger_selectorContext trigger_selector() throws RecognitionException {
		Trigger_selectorContext _localctx = new Trigger_selectorContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_trigger_selector);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			match(TRIGGER_SELECTOR);
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
		public Trigger_selectorContext trigger_selector() {
			return getRuleContext(Trigger_selectorContext.class,0);
		}
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
		enterRule(_localctx, 12, RULE_trigger);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			match(ALPHANUMERIC);
			setState(131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TRIGGER_SELECTOR) {
				{
				setState(130);
				trigger_selector();
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
		enterRule(_localctx, 14, RULE_precond_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
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
		enterRule(_localctx, 16, RULE_precond_ref);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			match(HASH);
			setState(136);
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
		enterRule(_localctx, 18, RULE_new_precond);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(PRECOND);
			setState(139);
			match(LCURLY);
			setState(140);
			precond_id();
			setState(141);
			match(SEMICOLON);
			setState(142);
			precond_body();
			setState(143);
			match(SEMICOLON);
			setState(144);
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
		enterRule(_localctx, 20, RULE_precond_body);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			match(SINGLE_STRING);
			setState(147);
			match(LPAREN);
			setState(148);
			match(STRING);
			setState(149);
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
		enterRule(_localctx, 22, RULE_precond);
		try {
			setState(153);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SINGLE_STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(151);
				precond_body();
				}
				break;
			case HASH:
				enterOuterAlt(_localctx, 2);
				{
				setState(152);
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
		enterRule(_localctx, 24, RULE_postcond_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
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
		enterRule(_localctx, 26, RULE_postcond_ref);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			match(HASH);
			setState(158);
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
		enterRule(_localctx, 28, RULE_postcond_body);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
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
		enterRule(_localctx, 30, RULE_new_postcond);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			match(POSTCOND);
			setState(163);
			match(LCURLY);
			setState(164);
			postcond_id();
			setState(165);
			match(SEMICOLON);
			setState(166);
			postcond_body();
			setState(167);
			match(SEMICOLON);
			setState(168);
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
		enterRule(_localctx, 32, RULE_postcond);
		try {
			setState(172);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SINGLE_STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(170);
				postcond_body();
				}
				break;
			case HASH:
				enterOuterAlt(_localctx, 2);
				{
				setState(171);
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
		enterRule(_localctx, 34, RULE_preconds);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			match(LSQUARE);
			setState(183);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==HASH || _la==SINGLE_STRING) {
				{
				setState(175);
				precond();
				setState(180);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(176);
					match(COMMA);
					setState(177);
					precond();
					}
					}
					setState(182);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(185);
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
		enterRule(_localctx, 36, RULE_triggers);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			match(LSQUARE);
			setState(188);
			trigger();
			setState(193);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(189);
				match(COMMA);
				setState(190);
				trigger();
				}
				}
				setState(195);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(196);
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
		enterRule(_localctx, 38, RULE_postconds);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			match(LSQUARE);
			setState(207);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==HASH || _la==SINGLE_STRING) {
				{
				setState(199);
				postcond();
				setState(204);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(200);
					match(COMMA);
					setState(201);
					postcond();
					}
					}
					setState(206);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(209);
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
		enterRule(_localctx, 40, RULE_argument);
		try {
			setState(213);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HASH:
				enterOuterAlt(_localctx, 1);
				{
				setState(211);
				item_ref();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(212);
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
		enterRule(_localctx, 42, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			match(LSQUARE);
			setState(224);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==HASH || _la==STRING) {
				{
				setState(216);
				argument();
				setState(221);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(217);
					match(COMMA);
					setState(218);
					argument();
					}
					}
					setState(223);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(226);
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
		public TerminalNode PREFIX_ROOM() { return getToken(GameGrammarParser.PREFIX_ROOM, 0); }
		public Room_nameContext room_name() {
			return getRuleContext(Room_nameContext.class,0);
		}
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
		enterRule(_localctx, 44, RULE_new_action);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			match(ACTION);
			setState(229);
			match(LCURLY);
			setState(230);
			action_id();
			setState(231);
			match(SEMICOLON);
			setState(232);
			match(DOT);
			setState(233);
			match(TRIGGERS_SYNTAX);
			setState(234);
			triggers();
			setState(235);
			match(SEMICOLON);
			setState(241);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(236);
				match(DOT);
				setState(237);
				match(PREFIX_ROOM);
				setState(238);
				room_name();
				setState(239);
				match(SEMICOLON);
				}
				break;
			}
			setState(243);
			match(DOT);
			setState(244);
			match(ARGUMENTS);
			setState(245);
			arguments();
			setState(246);
			match(SEMICOLON);
			setState(247);
			match(DOT);
			setState(248);
			match(PRECONDS);
			setState(249);
			preconds();
			setState(250);
			match(SEMICOLON);
			setState(251);
			match(DOT);
			setState(252);
			match(POSTCONDS);
			setState(253);
			postconds();
			setState(254);
			match(SEMICOLON);
			setState(255);
			match(DOT);
			setState(256);
			match(SUCCESSMESSAGE);
			setState(257);
			message();
			setState(258);
			match(SEMICOLON);
			setState(259);
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

	public static class Add_triggerContext extends ParserRuleContext {
		public TerminalNode ADD_TRIGGER() { return getToken(GameGrammarParser.ADD_TRIGGER, 0); }
		public TerminalNode LCURLY() { return getToken(GameGrammarParser.LCURLY, 0); }
		public Action_refContext action_ref() {
			return getRuleContext(Action_refContext.class,0);
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
		public TerminalNode RCURLY() { return getToken(GameGrammarParser.RCURLY, 0); }
		public Add_triggerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_add_trigger; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).enterAdd_trigger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).exitAdd_trigger(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GameGrammarVisitor ) return ((GameGrammarVisitor<? extends T>)visitor).visitAdd_trigger(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Add_triggerContext add_trigger() throws RecognitionException {
		Add_triggerContext _localctx = new Add_triggerContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_add_trigger);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			match(ADD_TRIGGER);
			setState(262);
			match(LCURLY);
			setState(263);
			action_ref();
			setState(264);
			match(SEMICOLON);
			setState(265);
			match(DOT);
			setState(266);
			match(ROOM);
			setState(267);
			room_name();
			setState(268);
			match(SEMICOLON);
			setState(269);
			match(DOT);
			setState(270);
			match(TRIGGERS_SYNTAX);
			setState(271);
			triggers();
			setState(272);
			match(SEMICOLON);
			setState(273);
			match(DOT);
			setState(274);
			match(ARGUMENTS);
			setState(275);
			arguments();
			setState(276);
			match(SEMICOLON);
			setState(277);
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
		enterRule(_localctx, 48, RULE_actionformat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(279);
			match(CUSTOM_TRIGGER);
			setState(280);
			match(LCURLY);
			setState(281);
			match(ALPHANUMERIC);
			setState(282);
			match(SEMICOLON);
			setState(285);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRING) {
				{
				setState(283);
				match(STRING);
				setState(284);
				match(SEMICOLON);
				}
			}

			setState(287);
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
		enterRule(_localctx, 50, RULE_action_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(289);
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
		enterRule(_localctx, 52, RULE_action_ref);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291);
			match(HASH);
			setState(292);
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
		enterRule(_localctx, 54, RULE_action);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
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
		enterRule(_localctx, 56, RULE_actions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(304);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==HASH) {
				{
				setState(296);
				action();
				setState(301);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(297);
					match(COMMA);
					setState(298);
					action();
					}
					}
					setState(303);
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
		enterRule(_localctx, 58, RULE_item_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(306);
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
		enterRule(_localctx, 60, RULE_item_ref);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(308);
			match(HASH);
			setState(309);
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
		enterRule(_localctx, 62, RULE_item_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(311);
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
		enterRule(_localctx, 64, RULE_item);
		try {
			setState(315);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(313);
				item_name();
				}
				break;
			case HASH:
				enterOuterAlt(_localctx, 2);
				{
				setState(314);
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
		enterRule(_localctx, 66, RULE_items);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(325);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==HASH || _la==STRING) {
				{
				setState(317);
				item();
				setState(322);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(318);
					match(COMMA);
					setState(319);
					item();
					}
					}
					setState(324);
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

	public static class Item_adjectiveContext extends ParserRuleContext {
		public TerminalNode ALPHANUMERIC() { return getToken(GameGrammarParser.ALPHANUMERIC, 0); }
		public Item_adjectiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_item_adjective; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).enterItem_adjective(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).exitItem_adjective(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GameGrammarVisitor ) return ((GameGrammarVisitor<? extends T>)visitor).visitItem_adjective(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Item_adjectiveContext item_adjective() throws RecognitionException {
		Item_adjectiveContext _localctx = new Item_adjectiveContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_item_adjective);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(327);
			match(ALPHANUMERIC);
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

	public static class Item_adjectivesContext extends ParserRuleContext {
		public List<Item_adjectiveContext> item_adjective() {
			return getRuleContexts(Item_adjectiveContext.class);
		}
		public Item_adjectiveContext item_adjective(int i) {
			return getRuleContext(Item_adjectiveContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(GameGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GameGrammarParser.COMMA, i);
		}
		public Item_adjectivesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_item_adjectives; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).enterItem_adjectives(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).exitItem_adjectives(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GameGrammarVisitor ) return ((GameGrammarVisitor<? extends T>)visitor).visitItem_adjectives(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Item_adjectivesContext item_adjectives() throws RecognitionException {
		Item_adjectivesContext _localctx = new Item_adjectivesContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_item_adjectives);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(329);
			item_adjective();
			setState(334);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(330);
				match(COMMA);
				setState(331);
				item_adjective();
				}
				}
				setState(336);
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

	public static class Item_synonymContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(GameGrammarParser.STRING, 0); }
		public Item_synonymContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_item_synonym; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).enterItem_synonym(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).exitItem_synonym(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GameGrammarVisitor ) return ((GameGrammarVisitor<? extends T>)visitor).visitItem_synonym(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Item_synonymContext item_synonym() throws RecognitionException {
		Item_synonymContext _localctx = new Item_synonymContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_item_synonym);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(337);
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

	public static class Item_synonymsContext extends ParserRuleContext {
		public List<Item_synonymContext> item_synonym() {
			return getRuleContexts(Item_synonymContext.class);
		}
		public Item_synonymContext item_synonym(int i) {
			return getRuleContext(Item_synonymContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(GameGrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GameGrammarParser.COMMA, i);
		}
		public Item_synonymsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_item_synonyms; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).enterItem_synonyms(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).exitItem_synonyms(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GameGrammarVisitor ) return ((GameGrammarVisitor<? extends T>)visitor).visitItem_synonyms(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Item_synonymsContext item_synonyms() throws RecognitionException {
		Item_synonymsContext _localctx = new Item_synonymsContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_item_synonyms);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(339);
			item_synonym();
			setState(344);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(340);
				match(COMMA);
				setState(341);
				item_synonym();
				}
				}
				setState(346);
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
		public TerminalNode ITEM_ADJECTIVES() { return getToken(GameGrammarParser.ITEM_ADJECTIVES, 0); }
		public List<TerminalNode> LSQUARE() { return getTokens(GameGrammarParser.LSQUARE); }
		public TerminalNode LSQUARE(int i) {
			return getToken(GameGrammarParser.LSQUARE, i);
		}
		public List<TerminalNode> RSQUARE() { return getTokens(GameGrammarParser.RSQUARE); }
		public TerminalNode RSQUARE(int i) {
			return getToken(GameGrammarParser.RSQUARE, i);
		}
		public TerminalNode ITEM_SYNONYMS() { return getToken(GameGrammarParser.ITEM_SYNONYMS, 0); }
		public TerminalNode ITEM_KNOWLEDGE() { return getToken(GameGrammarParser.ITEM_KNOWLEDGE, 0); }
		public Knowledge_updatesContext knowledge_updates() {
			return getRuleContext(Knowledge_updatesContext.class,0);
		}
		public TerminalNode RCURLY() { return getToken(GameGrammarParser.RCURLY, 0); }
		public Item_adjectivesContext item_adjectives() {
			return getRuleContext(Item_adjectivesContext.class,0);
		}
		public Item_synonymsContext item_synonyms() {
			return getRuleContext(Item_synonymsContext.class,0);
		}
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
		enterRule(_localctx, 76, RULE_new_item);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(347);
			match(ITEM);
			setState(348);
			match(LCURLY);
			setState(349);
			item_id();
			setState(350);
			match(SEMICOLON);
			setState(351);
			match(DOT);
			setState(352);
			match(ROOM);
			setState(353);
			room_name();
			setState(354);
			match(SEMICOLON);
			setState(355);
			match(DOT);
			setState(356);
			match(ITEM_NAME);
			setState(357);
			item_name();
			setState(358);
			match(SEMICOLON);
			setState(359);
			match(DOT);
			setState(360);
			match(ITEM_ADJECTIVES);
			setState(361);
			match(LSQUARE);
			setState(363);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ALPHANUMERIC) {
				{
				setState(362);
				item_adjectives();
				}
			}

			setState(365);
			match(RSQUARE);
			setState(366);
			match(SEMICOLON);
			setState(367);
			match(DOT);
			setState(368);
			match(ITEM_SYNONYMS);
			setState(369);
			match(LSQUARE);
			setState(371);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRING) {
				{
				setState(370);
				item_synonyms();
				}
			}

			setState(373);
			match(RSQUARE);
			setState(374);
			match(SEMICOLON);
			setState(375);
			match(DOT);
			setState(376);
			match(ITEM_KNOWLEDGE);
			setState(377);
			knowledge_updates();
			setState(378);
			match(SEMICOLON);
			setState(379);
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
		enterRule(_localctx, 78, RULE_room_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(381);
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
		enterRule(_localctx, 80, RULE_new_room);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(383);
			match(ROOM);
			setState(384);
			match(LCURLY);
			setState(385);
			match(DOT);
			setState(386);
			match(ROOM_NAME);
			setState(387);
			room_name();
			setState(388);
			match(SEMICOLON);
			setState(389);
			match(DOT);
			setState(390);
			match(ACTIONS_SYNTAX);
			setState(391);
			actions();
			setState(392);
			match(SEMICOLON);
			setState(393);
			match(DOT);
			setState(394);
			match(ITEMS);
			setState(395);
			items();
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
		enterRule(_localctx, 82, RULE_genericframe_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(399);
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
		public TerminalNode STRING() { return getToken(GameGrammarParser.STRING, 0); }
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
		enterRule(_localctx, 84, RULE_map_entry);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(401);
			match(ALPHANUMERIC);
			setState(402);
			match(EQUALS);
			setState(403);
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

	public static class Map_entriesContext extends ParserRuleContext {
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
		public Map_entriesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_map_entries; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).enterMap_entries(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).exitMap_entries(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GameGrammarVisitor ) return ((GameGrammarVisitor<? extends T>)visitor).visitMap_entries(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Map_entriesContext map_entries() throws RecognitionException {
		Map_entriesContext _localctx = new Map_entriesContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_map_entries);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(405);
			map_entry();
			setState(410);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(406);
				match(COMMA);
				setState(407);
				map_entry();
				}
				}
				setState(412);
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
		public Map_entriesContext map_entries() {
			return getRuleContext(Map_entriesContext.class,0);
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
		enterRule(_localctx, 88, RULE_new_genericframe);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(413);
			match(GENERICFRAME);
			setState(414);
			match(LCURLY);
			setState(415);
			genericframe_name();
			setState(416);
			match(SEMICOLON);
			setState(417);
			match(LSQUARE);
			setState(419);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ALPHANUMERIC) {
				{
				setState(418);
				map_entries();
				}
			}

			setState(421);
			match(RSQUARE);
			setState(422);
			match(SEMICOLON);
			setState(423);
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
		enterRule(_localctx, 90, RULE_knowledge_update);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(425);
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
		enterRule(_localctx, 92, RULE_knowledge_updates);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(427);
			match(LSQUARE);
			setState(436);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SINGLE_STRING) {
				{
				setState(428);
				knowledge_update();
				setState(433);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(429);
					match(COMMA);
					setState(430);
					knowledge_update();
					}
					}
					setState(435);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(438);
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
		public Item_refContext item_ref() {
			return getRuleContext(Item_refContext.class,0);
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
		enterRule(_localctx, 94, RULE_global_item);
		try {
			setState(442);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HASH:
				enterOuterAlt(_localctx, 1);
				{
				setState(440);
				item_ref();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(441);
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
		enterRule(_localctx, 96, RULE_global_items);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(444);
			global_item();
			setState(449);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(445);
					match(COMMA);
					setState(446);
					global_item();
					}
					} 
				}
				setState(451);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
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
		enterRule(_localctx, 98, RULE_inheritance);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(452);
			match(LSQUARE);
			setState(453);
			global_items();
			setState(454);
			match(RSQUARE);
			setState(455);
			match(INHERITS);
			setState(456);
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

	public static class InheritancesContext extends ParserRuleContext {
		public List<InheritanceContext> inheritance() {
			return getRuleContexts(InheritanceContext.class);
		}
		public InheritanceContext inheritance(int i) {
			return getRuleContext(InheritanceContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(GameGrammarParser.COMMA, 0); }
		public InheritancesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inheritances; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).enterInheritances(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).exitInheritances(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GameGrammarVisitor ) return ((GameGrammarVisitor<? extends T>)visitor).visitInheritances(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InheritancesContext inheritances() throws RecognitionException {
		InheritancesContext _localctx = new InheritancesContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_inheritances);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(458);
			inheritance();
			{
			setState(459);
			match(COMMA);
			setState(460);
			inheritance();
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

	public static class KnowledgeContext extends ParserRuleContext {
		public TerminalNode KNOWLEDGE() { return getToken(GameGrammarParser.KNOWLEDGE, 0); }
		public TerminalNode LCURLY() { return getToken(GameGrammarParser.LCURLY, 0); }
		public List<TerminalNode> DOT() { return getTokens(GameGrammarParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(GameGrammarParser.DOT, i);
		}
		public TerminalNode GENERIC_INHERITANCE() { return getToken(GameGrammarParser.GENERIC_INHERITANCE, 0); }
		public InheritancesContext inheritances() {
			return getRuleContext(InheritancesContext.class,0);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(GameGrammarParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(GameGrammarParser.SEMICOLON, i);
		}
		public TerminalNode INITIAL() { return getToken(GameGrammarParser.INITIAL, 0); }
		public TerminalNode RCURLY() { return getToken(GameGrammarParser.RCURLY, 0); }
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
		enterRule(_localctx, 102, RULE_knowledge);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(462);
			match(KNOWLEDGE);
			setState(463);
			match(LCURLY);
			setState(464);
			match(DOT);
			setState(465);
			match(GENERIC_INHERITANCE);
			setState(466);
			inheritances();
			setState(467);
			match(SEMICOLON);
			setState(468);
			match(DOT);
			setState(469);
			match(INITIAL);
			setState(471);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LSQUARE) {
				{
				setState(470);
				knowledge_updates();
				}
			}

			setState(473);
			match(SEMICOLON);
			setState(474);
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
		enterRule(_localctx, 104, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(476);
			match(START);
			setState(477);
			match(LCURLY);
			setState(478);
			room_name();
			setState(479);
			match(SEMICOLON);
			setState(480);
			match(STRING);
			setState(481);
			match(SEMICOLON);
			setState(482);
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
		public List<Add_triggerContext> add_trigger() {
			return getRuleContexts(Add_triggerContext.class);
		}
		public Add_triggerContext add_trigger(int i) {
			return getRuleContext(Add_triggerContext.class,i);
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
		enterRule(_localctx, 106, RULE_game);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(484);
			start();
			setState(495);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MESSAGE) | (1L << ACTION) | (1L << ROOM) | (1L << ITEM) | (1L << PRECOND) | (1L << POSTCOND) | (1L << CUSTOM_TRIGGER) | (1L << ADD_TRIGGER))) != 0)) {
				{
				setState(493);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case MESSAGE:
					{
					setState(485);
					new_message();
					}
					break;
				case ACTION:
					{
					setState(486);
					new_action();
					}
					break;
				case ITEM:
					{
					setState(487);
					new_item();
					}
					break;
				case ROOM:
					{
					setState(488);
					new_room();
					}
					break;
				case CUSTOM_TRIGGER:
					{
					setState(489);
					actionformat();
					}
					break;
				case POSTCOND:
					{
					setState(490);
					new_postcond();
					}
					break;
				case PRECOND:
					{
					setState(491);
					new_precond();
					}
					break;
				case ADD_TRIGGER:
					{
					setState(492);
					add_trigger();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(497);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(501);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==GENERICFRAME) {
				{
				{
				setState(498);
				new_genericframe();
				}
				}
				setState(503);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(505);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KNOWLEDGE) {
				{
				setState(504);
				knowledge();
				}
			}

			setState(507);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\62\u0200\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3"+
		"\3\3\3\4\3\4\3\5\3\5\3\5\3\6\3\6\5\6\u0080\n\6\3\7\3\7\3\b\3\b\5\b\u0086"+
		"\n\b\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3"+
		"\f\3\f\3\f\3\f\3\r\3\r\5\r\u009c\n\r\3\16\3\16\3\17\3\17\3\17\3\20\3\20"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\5\22\u00af\n\22\3\23"+
		"\3\23\3\23\3\23\7\23\u00b5\n\23\f\23\16\23\u00b8\13\23\5\23\u00ba\n\23"+
		"\3\23\3\23\3\24\3\24\3\24\3\24\7\24\u00c2\n\24\f\24\16\24\u00c5\13\24"+
		"\3\24\3\24\3\25\3\25\3\25\3\25\7\25\u00cd\n\25\f\25\16\25\u00d0\13\25"+
		"\5\25\u00d2\n\25\3\25\3\25\3\26\3\26\5\26\u00d8\n\26\3\27\3\27\3\27\3"+
		"\27\7\27\u00de\n\27\f\27\16\27\u00e1\13\27\5\27\u00e3\n\27\3\27\3\27\3"+
		"\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u00f4"+
		"\n\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\5\32\u0120\n\32\3\32\3\32\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\36"+
		"\3\36\3\36\7\36\u012e\n\36\f\36\16\36\u0131\13\36\5\36\u0133\n\36\3\37"+
		"\3\37\3 \3 \3 \3!\3!\3\"\3\"\5\"\u013e\n\"\3#\3#\3#\7#\u0143\n#\f#\16"+
		"#\u0146\13#\5#\u0148\n#\3$\3$\3%\3%\3%\7%\u014f\n%\f%\16%\u0152\13%\3"+
		"&\3&\3\'\3\'\3\'\7\'\u0159\n\'\f\'\16\'\u015c\13\'\3(\3(\3(\3(\3(\3(\3"+
		"(\3(\3(\3(\3(\3(\3(\3(\3(\3(\5(\u016e\n(\3(\3(\3(\3(\3(\3(\5(\u0176\n"+
		"(\3(\3(\3(\3(\3(\3(\3(\3(\3)\3)\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3"+
		"*\3*\3*\3*\3+\3+\3,\3,\3,\3,\3-\3-\3-\7-\u019b\n-\f-\16-\u019e\13-\3."+
		"\3.\3.\3.\3.\3.\5.\u01a6\n.\3.\3.\3.\3.\3/\3/\3\60\3\60\3\60\3\60\7\60"+
		"\u01b2\n\60\f\60\16\60\u01b5\13\60\5\60\u01b7\n\60\3\60\3\60\3\61\3\61"+
		"\5\61\u01bd\n\61\3\62\3\62\3\62\7\62\u01c2\n\62\f\62\16\62\u01c5\13\62"+
		"\3\63\3\63\3\63\3\63\3\63\3\63\3\64\3\64\3\64\3\64\3\65\3\65\3\65\3\65"+
		"\3\65\3\65\3\65\3\65\3\65\5\65\u01da\n\65\3\65\3\65\3\65\3\66\3\66\3\66"+
		"\3\66\3\66\3\66\3\66\3\66\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67"+
		"\7\67\u01f0\n\67\f\67\16\67\u01f3\13\67\3\67\7\67\u01f6\n\67\f\67\16\67"+
		"\u01f9\13\67\3\67\5\67\u01fc\n\67\3\67\3\67\3\67\3\u01c3\28\2\4\6\b\n"+
		"\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\"+
		"^`bdfhjl\2\2\2\u01f1\2n\3\2\2\2\4v\3\2\2\2\6x\3\2\2\2\bz\3\2\2\2\n\177"+
		"\3\2\2\2\f\u0081\3\2\2\2\16\u0083\3\2\2\2\20\u0087\3\2\2\2\22\u0089\3"+
		"\2\2\2\24\u008c\3\2\2\2\26\u0094\3\2\2\2\30\u009b\3\2\2\2\32\u009d\3\2"+
		"\2\2\34\u009f\3\2\2\2\36\u00a2\3\2\2\2 \u00a4\3\2\2\2\"\u00ae\3\2\2\2"+
		"$\u00b0\3\2\2\2&\u00bd\3\2\2\2(\u00c8\3\2\2\2*\u00d7\3\2\2\2,\u00d9\3"+
		"\2\2\2.\u00e6\3\2\2\2\60\u0107\3\2\2\2\62\u0119\3\2\2\2\64\u0123\3\2\2"+
		"\2\66\u0125\3\2\2\28\u0128\3\2\2\2:\u0132\3\2\2\2<\u0134\3\2\2\2>\u0136"+
		"\3\2\2\2@\u0139\3\2\2\2B\u013d\3\2\2\2D\u0147\3\2\2\2F\u0149\3\2\2\2H"+
		"\u014b\3\2\2\2J\u0153\3\2\2\2L\u0155\3\2\2\2N\u015d\3\2\2\2P\u017f\3\2"+
		"\2\2R\u0181\3\2\2\2T\u0191\3\2\2\2V\u0193\3\2\2\2X\u0197\3\2\2\2Z\u019f"+
		"\3\2\2\2\\\u01ab\3\2\2\2^\u01ad\3\2\2\2`\u01bc\3\2\2\2b\u01be\3\2\2\2"+
		"d\u01c6\3\2\2\2f\u01cc\3\2\2\2h\u01d0\3\2\2\2j\u01de\3\2\2\2l\u01e6\3"+
		"\2\2\2no\7\n\2\2op\7\4\2\2pq\5\4\3\2qr\7/\2\2rs\7)\2\2st\7/\2\2tu\7\5"+
		"\2\2u\3\3\2\2\2vw\7\3\2\2w\5\3\2\2\2xy\7)\2\2y\7\3\2\2\2z{\7\b\2\2{|\5"+
		"\4\3\2|\t\3\2\2\2}\u0080\5\b\5\2~\u0080\5\6\4\2\177}\3\2\2\2\177~\3\2"+
		"\2\2\u0080\13\3\2\2\2\u0081\u0082\7&\2\2\u0082\r\3\2\2\2\u0083\u0085\7"+
		"*\2\2\u0084\u0086\5\f\7\2\u0085\u0084\3\2\2\2\u0085\u0086\3\2\2\2\u0086"+
		"\17\3\2\2\2\u0087\u0088\7\3\2\2\u0088\21\3\2\2\2\u0089\u008a\7\b\2\2\u008a"+
		"\u008b\5\20\t\2\u008b\23\3\2\2\2\u008c\u008d\7\17\2\2\u008d\u008e\7\4"+
		"\2\2\u008e\u008f\5\20\t\2\u008f\u0090\7/\2\2\u0090\u0091\5\26\f\2\u0091"+
		"\u0092\7/\2\2\u0092\u0093\7\5\2\2\u0093\25\3\2\2\2\u0094\u0095\7(\2\2"+
		"\u0095\u0096\7-\2\2\u0096\u0097\7)\2\2\u0097\u0098\7.\2\2\u0098\27\3\2"+
		"\2\2\u0099\u009c\5\26\f\2\u009a\u009c\5\22\n\2\u009b\u0099\3\2\2\2\u009b"+
		"\u009a\3\2\2\2\u009c\31\3\2\2\2\u009d\u009e\7\3\2\2\u009e\33\3\2\2\2\u009f"+
		"\u00a0\7\b\2\2\u00a0\u00a1\5\32\16\2\u00a1\35\3\2\2\2\u00a2\u00a3\7(\2"+
		"\2\u00a3\37\3\2\2\2\u00a4\u00a5\7\20\2\2\u00a5\u00a6\7\4\2\2\u00a6\u00a7"+
		"\5\32\16\2\u00a7\u00a8\7/\2\2\u00a8\u00a9\5\36\20\2\u00a9\u00aa\7/\2\2"+
		"\u00aa\u00ab\7\5\2\2\u00ab!\3\2\2\2\u00ac\u00af\5\36\20\2\u00ad\u00af"+
		"\5\34\17\2\u00ae\u00ac\3\2\2\2\u00ae\u00ad\3\2\2\2\u00af#\3\2\2\2\u00b0"+
		"\u00b9\7\6\2\2\u00b1\u00b6\5\30\r\2\u00b2\u00b3\7\30\2\2\u00b3\u00b5\5"+
		"\30\r\2\u00b4\u00b2\3\2\2\2\u00b5\u00b8\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6"+
		"\u00b7\3\2\2\2\u00b7\u00ba\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b9\u00b1\3\2"+
		"\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00bc\7\7\2\2\u00bc"+
		"%\3\2\2\2\u00bd\u00be\7\6\2\2\u00be\u00c3\5\16\b\2\u00bf\u00c0\7\30\2"+
		"\2\u00c0\u00c2\5\16\b\2\u00c1\u00bf\3\2\2\2\u00c2\u00c5\3\2\2\2\u00c3"+
		"\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c6\3\2\2\2\u00c5\u00c3\3\2"+
		"\2\2\u00c6\u00c7\7\7\2\2\u00c7\'\3\2\2\2\u00c8\u00d1\7\6\2\2\u00c9\u00ce"+
		"\5\"\22\2\u00ca\u00cb\7\30\2\2\u00cb\u00cd\5\"\22\2\u00cc\u00ca\3\2\2"+
		"\2\u00cd\u00d0\3\2\2\2\u00ce\u00cc\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d2"+
		"\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d1\u00c9\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2"+
		"\u00d3\3\2\2\2\u00d3\u00d4\7\7\2\2\u00d4)\3\2\2\2\u00d5\u00d8\5> \2\u00d6"+
		"\u00d8\7)\2\2\u00d7\u00d5\3\2\2\2\u00d7\u00d6\3\2\2\2\u00d8+\3\2\2\2\u00d9"+
		"\u00e2\7\6\2\2\u00da\u00df\5*\26\2\u00db\u00dc\7\30\2\2\u00dc\u00de\5"+
		"*\26\2\u00dd\u00db\3\2\2\2\u00de\u00e1\3\2\2\2\u00df\u00dd\3\2\2\2\u00df"+
		"\u00e0\3\2\2\2\u00e0\u00e3\3\2\2\2\u00e1\u00df\3\2\2\2\u00e2\u00da\3\2"+
		"\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e5\7\7\2\2\u00e5"+
		"-\3\2\2\2\u00e6\u00e7\7\13\2\2\u00e7\u00e8\7\4\2\2\u00e8\u00e9\5\64\33"+
		"\2\u00e9\u00ea\7/\2\2\u00ea\u00eb\7\60\2\2\u00eb\u00ec\7\35\2\2\u00ec"+
		"\u00ed\5&\24\2\u00ed\u00f3\7/\2\2\u00ee\u00ef\7\60\2\2\u00ef\u00f0\7\'"+
		"\2\2\u00f0\u00f1\5P)\2\u00f1\u00f2\7/\2\2\u00f2\u00f4\3\2\2\2\u00f3\u00ee"+
		"\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00f6\7\60\2\2"+
		"\u00f6\u00f7\7\36\2\2\u00f7\u00f8\5,\27\2\u00f8\u00f9\7/\2\2\u00f9\u00fa"+
		"\7\60\2\2\u00fa\u00fb\7\25\2\2\u00fb\u00fc\5$\23\2\u00fc\u00fd\7/\2\2"+
		"\u00fd\u00fe\7\60\2\2\u00fe\u00ff\7\24\2\2\u00ff\u0100\5(\25\2\u0100\u0101"+
		"\7/\2\2\u0101\u0102\7\60\2\2\u0102\u0103\7\34\2\2\u0103\u0104\5\n\6\2"+
		"\u0104\u0105\7/\2\2\u0105\u0106\7\5\2\2\u0106/\3\2\2\2\u0107\u0108\7%"+
		"\2\2\u0108\u0109\7\4\2\2\u0109\u010a\5\66\34\2\u010a\u010b\7/\2\2\u010b"+
		"\u010c\7\60\2\2\u010c\u010d\7\f\2\2\u010d\u010e\5P)\2\u010e\u010f\7/\2"+
		"\2\u010f\u0110\7\60\2\2\u0110\u0111\7\35\2\2\u0111\u0112\5&\24\2\u0112"+
		"\u0113\7/\2\2\u0113\u0114\7\60\2\2\u0114\u0115\7\36\2\2\u0115\u0116\5"+
		",\27\2\u0116\u0117\7/\2\2\u0117\u0118\7\5\2\2\u0118\61\3\2\2\2\u0119\u011a"+
		"\7\22\2\2\u011a\u011b\7\4\2\2\u011b\u011c\7*\2\2\u011c\u011f\7/\2\2\u011d"+
		"\u011e\7)\2\2\u011e\u0120\7/\2\2\u011f\u011d\3\2\2\2\u011f\u0120\3\2\2"+
		"\2\u0120\u0121\3\2\2\2\u0121\u0122\7\5\2\2\u0122\63\3\2\2\2\u0123\u0124"+
		"\7\3\2\2\u0124\65\3\2\2\2\u0125\u0126\7\b\2\2\u0126\u0127\5\64\33\2\u0127"+
		"\67\3\2\2\2\u0128\u0129\5\66\34\2\u01299\3\2\2\2\u012a\u012f\58\35\2\u012b"+
		"\u012c\7\30\2\2\u012c\u012e\58\35\2\u012d\u012b\3\2\2\2\u012e\u0131\3"+
		"\2\2\2\u012f\u012d\3\2\2\2\u012f\u0130\3\2\2\2\u0130\u0133\3\2\2\2\u0131"+
		"\u012f\3\2\2\2\u0132\u012a\3\2\2\2\u0132\u0133\3\2\2\2\u0133;\3\2\2\2"+
		"\u0134\u0135\7\3\2\2\u0135=\3\2\2\2\u0136\u0137\7\b\2\2\u0137\u0138\5"+
		"<\37\2\u0138?\3\2\2\2\u0139\u013a\7)\2\2\u013aA\3\2\2\2\u013b\u013e\5"+
		"@!\2\u013c\u013e\5> \2\u013d\u013b\3\2\2\2\u013d\u013c\3\2\2\2\u013eC"+
		"\3\2\2\2\u013f\u0144\5B\"\2\u0140\u0141\7\30\2\2\u0141\u0143\5B\"\2\u0142"+
		"\u0140\3\2\2\2\u0143\u0146\3\2\2\2\u0144\u0142\3\2\2\2\u0144\u0145\3\2"+
		"\2\2\u0145\u0148\3\2\2\2\u0146\u0144\3\2\2\2\u0147\u013f\3\2\2\2\u0147"+
		"\u0148\3\2\2\2\u0148E\3\2\2\2\u0149\u014a\7*\2\2\u014aG\3\2\2\2\u014b"+
		"\u0150\5F$\2\u014c\u014d\7\30\2\2\u014d\u014f\5F$\2\u014e\u014c\3\2\2"+
		"\2\u014f\u0152\3\2\2\2\u0150\u014e\3\2\2\2\u0150\u0151\3\2\2\2\u0151I"+
		"\3\2\2\2\u0152\u0150\3\2\2\2\u0153\u0154\7)\2\2\u0154K\3\2\2\2\u0155\u015a"+
		"\5J&\2\u0156\u0157\7\30\2\2\u0157\u0159\5J&\2\u0158\u0156\3\2\2\2\u0159"+
		"\u015c\3\2\2\2\u015a\u0158\3\2\2\2\u015a\u015b\3\2\2\2\u015bM\3\2\2\2"+
		"\u015c\u015a\3\2\2\2\u015d\u015e\7\r\2\2\u015e\u015f\7\4\2\2\u015f\u0160"+
		"\5<\37\2\u0160\u0161\7/\2\2\u0161\u0162\7\60\2\2\u0162\u0163\7\f\2\2\u0163"+
		"\u0164\5P)\2\u0164\u0165\7/\2\2\u0165\u0166\7\60\2\2\u0166\u0167\7\"\2"+
		"\2\u0167\u0168\5@!\2\u0168\u0169\7/\2\2\u0169\u016a\7\60\2\2\u016a\u016b"+
		"\7\26\2\2\u016b\u016d\7\6\2\2\u016c\u016e\5H%\2\u016d\u016c\3\2\2\2\u016d"+
		"\u016e\3\2\2\2\u016e\u016f\3\2\2\2\u016f\u0170\7\7\2\2\u0170\u0171\7/"+
		"\2\2\u0171\u0172\7\60\2\2\u0172\u0173\7\27\2\2\u0173\u0175\7\6\2\2\u0174"+
		"\u0176\5L\'\2\u0175\u0174\3\2\2\2\u0175\u0176\3\2\2\2\u0176\u0177\3\2"+
		"\2\2\u0177\u0178\7\7\2\2\u0178\u0179\7/\2\2\u0179\u017a\7\60\2\2\u017a"+
		"\u017b\7#\2\2\u017b\u017c\5^\60\2\u017c\u017d\7/\2\2\u017d\u017e\7\5\2"+
		"\2\u017eO\3\2\2\2\u017f\u0180\7)\2\2\u0180Q\3\2\2\2\u0181\u0182\7\f\2"+
		"\2\u0182\u0183\7\4\2\2\u0183\u0184\7\60\2\2\u0184\u0185\7!\2\2\u0185\u0186"+
		"\5P)\2\u0186\u0187\7/\2\2\u0187\u0188\7\60\2\2\u0188\u0189\7\31\2\2\u0189"+
		"\u018a\5:\36\2\u018a\u018b\7/\2\2\u018b\u018c\7\60\2\2\u018c\u018d\7\32"+
		"\2\2\u018d\u018e\5D#\2\u018e\u018f\7/\2\2\u018f\u0190\7\5\2\2\u0190S\3"+
		"\2\2\2\u0191\u0192\7)\2\2\u0192U\3\2\2\2\u0193\u0194\7*\2\2\u0194\u0195"+
		"\7\61\2\2\u0195\u0196\7)\2\2\u0196W\3\2\2\2\u0197\u019c\5V,\2\u0198\u0199"+
		"\7\30\2\2\u0199\u019b\5V,\2\u019a\u0198\3\2\2\2\u019b\u019e\3\2\2\2\u019c"+
		"\u019a\3\2\2\2\u019c\u019d\3\2\2\2\u019dY\3\2\2\2\u019e\u019c\3\2\2\2"+
		"\u019f\u01a0\7\21\2\2\u01a0\u01a1\7\4\2\2\u01a1\u01a2\5T+\2\u01a2\u01a3"+
		"\7/\2\2\u01a3\u01a5\7\6\2\2\u01a4\u01a6\5X-\2\u01a5\u01a4\3\2\2\2\u01a5"+
		"\u01a6\3\2\2\2\u01a6\u01a7\3\2\2\2\u01a7\u01a8\7\7\2\2\u01a8\u01a9\7/"+
		"\2\2\u01a9\u01aa\7\5\2\2\u01aa[\3\2\2\2\u01ab\u01ac\7(\2\2\u01ac]\3\2"+
		"\2\2\u01ad\u01b6\7\6\2\2\u01ae\u01b3\5\\/\2\u01af\u01b0\7\30\2\2\u01b0"+
		"\u01b2\5\\/\2\u01b1\u01af\3\2\2\2\u01b2\u01b5\3\2\2\2\u01b3\u01b1\3\2"+
		"\2\2\u01b3\u01b4\3\2\2\2\u01b4\u01b7\3\2\2\2\u01b5\u01b3\3\2\2\2\u01b6"+
		"\u01ae\3\2\2\2\u01b6\u01b7\3\2\2\2\u01b7\u01b8\3\2\2\2\u01b8\u01b9\7\7"+
		"\2\2\u01b9_\3\2\2\2\u01ba\u01bd\5> \2\u01bb\u01bd\7)\2\2\u01bc\u01ba\3"+
		"\2\2\2\u01bc\u01bb\3\2\2\2\u01bda\3\2\2\2\u01be\u01c3\5`\61\2\u01bf\u01c0"+
		"\7\30\2\2\u01c0\u01c2\5`\61\2\u01c1\u01bf\3\2\2\2\u01c2\u01c5\3\2\2\2"+
		"\u01c3\u01c4\3\2\2\2\u01c3\u01c1\3\2\2\2\u01c4c\3\2\2\2\u01c5\u01c3\3"+
		"\2\2\2\u01c6\u01c7\7\6\2\2\u01c7\u01c8\5b\62\2\u01c8\u01c9\7\7\2\2\u01c9"+
		"\u01ca\7 \2\2\u01ca\u01cb\7)\2\2\u01cbe\3\2\2\2\u01cc\u01cd\5d\63\2\u01cd"+
		"\u01ce\7\30\2\2\u01ce\u01cf\5d\63\2\u01cfg\3\2\2\2\u01d0\u01d1\7\16\2"+
		"\2\u01d1\u01d2\7\4\2\2\u01d2\u01d3\7\60\2\2\u01d3\u01d4\7$\2\2\u01d4\u01d5"+
		"\5f\64\2\u01d5\u01d6\7/\2\2\u01d6\u01d7\7\60\2\2\u01d7\u01d9\7\23\2\2"+
		"\u01d8\u01da\5^\60\2\u01d9\u01d8\3\2\2\2\u01d9\u01da\3\2\2\2\u01da\u01db"+
		"\3\2\2\2\u01db\u01dc\7/\2\2\u01dc\u01dd\7\5\2\2\u01ddi\3\2\2\2\u01de\u01df"+
		"\7\t\2\2\u01df\u01e0\7\4\2\2\u01e0\u01e1\5P)\2\u01e1\u01e2\7/\2\2\u01e2"+
		"\u01e3\7)\2\2\u01e3\u01e4\7/\2\2\u01e4\u01e5\7\5\2\2\u01e5k\3\2\2\2\u01e6"+
		"\u01f1\5j\66\2\u01e7\u01f0\5\2\2\2\u01e8\u01f0\5.\30\2\u01e9\u01f0\5N"+
		"(\2\u01ea\u01f0\5R*\2\u01eb\u01f0\5\62\32\2\u01ec\u01f0\5 \21\2\u01ed"+
		"\u01f0\5\24\13\2\u01ee\u01f0\5\60\31\2\u01ef\u01e7\3\2\2\2\u01ef\u01e8"+
		"\3\2\2\2\u01ef\u01e9\3\2\2\2\u01ef\u01ea\3\2\2\2\u01ef\u01eb\3\2\2\2\u01ef"+
		"\u01ec\3\2\2\2\u01ef\u01ed\3\2\2\2\u01ef\u01ee\3\2\2\2\u01f0\u01f3\3\2"+
		"\2\2\u01f1\u01ef\3\2\2\2\u01f1\u01f2\3\2\2\2\u01f2\u01f7\3\2\2\2\u01f3"+
		"\u01f1\3\2\2\2\u01f4\u01f6\5Z.\2\u01f5\u01f4\3\2\2\2\u01f6\u01f9\3\2\2"+
		"\2\u01f7\u01f5\3\2\2\2\u01f7\u01f8\3\2\2\2\u01f8\u01fb\3\2\2\2\u01f9\u01f7"+
		"\3\2\2\2\u01fa\u01fc\5h\65\2\u01fb\u01fa\3\2\2\2\u01fb\u01fc\3\2\2\2\u01fc"+
		"\u01fd\3\2\2\2\u01fd\u01fe\7\2\2\3\u01fem\3\2\2\2$\177\u0085\u009b\u00ae"+
		"\u00b6\u00b9\u00c3\u00ce\u00d1\u00d7\u00df\u00e2\u00f3\u011f\u012f\u0132"+
		"\u013d\u0144\u0147\u0150\u015a\u016d\u0175\u019c\u01a5\u01b3\u01b6\u01bc"+
		"\u01c3\u01d9\u01ef\u01f1\u01f7\u01fb";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}