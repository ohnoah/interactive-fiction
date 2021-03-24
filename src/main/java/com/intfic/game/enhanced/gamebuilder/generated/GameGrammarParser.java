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
		RULE_knowledge = 51, RULE_start = 52, RULE_block = 53, RULE_game = 54;
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
			"start", "block", "game"
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
			setState(110);
			match(MESSAGE);
			setState(111);
			match(LCURLY);
			setState(112);
			message_id();
			setState(113);
			match(SEMICOLON);
			setState(114);
			match(STRING);
			setState(115);
			match(SEMICOLON);
			setState(116);
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
			setState(118);
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
			setState(120);
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
			setState(122);
			match(HASH);
			setState(123);
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
			setState(127);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HASH:
				enterOuterAlt(_localctx, 1);
				{
				setState(125);
				message_ref();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(126);
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
			setState(129);
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
			setState(131);
			match(ALPHANUMERIC);
			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TRIGGER_SELECTOR) {
				{
				setState(132);
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
			setState(135);
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
			setState(137);
			match(HASH);
			setState(138);
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
			setState(140);
			match(PRECOND);
			setState(141);
			match(LCURLY);
			setState(142);
			precond_id();
			setState(143);
			match(SEMICOLON);
			setState(144);
			precond_body();
			setState(145);
			match(SEMICOLON);
			setState(146);
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
			setState(148);
			match(SINGLE_STRING);
			setState(149);
			match(LPAREN);
			setState(150);
			match(STRING);
			setState(151);
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
			setState(155);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SINGLE_STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(153);
				precond_body();
				}
				break;
			case HASH:
				enterOuterAlt(_localctx, 2);
				{
				setState(154);
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
			setState(157);
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
			setState(159);
			match(HASH);
			setState(160);
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
			setState(162);
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
			setState(164);
			match(POSTCOND);
			setState(165);
			match(LCURLY);
			setState(166);
			postcond_id();
			setState(167);
			match(SEMICOLON);
			setState(168);
			postcond_body();
			setState(169);
			match(SEMICOLON);
			setState(170);
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
			setState(174);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SINGLE_STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(172);
				postcond_body();
				}
				break;
			case HASH:
				enterOuterAlt(_localctx, 2);
				{
				setState(173);
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
			setState(176);
			match(LSQUARE);
			setState(185);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==HASH || _la==SINGLE_STRING) {
				{
				setState(177);
				precond();
				setState(182);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(178);
					match(COMMA);
					setState(179);
					precond();
					}
					}
					setState(184);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(187);
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
			setState(189);
			match(LSQUARE);
			setState(190);
			trigger();
			setState(195);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(191);
				match(COMMA);
				setState(192);
				trigger();
				}
				}
				setState(197);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(198);
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
			setState(200);
			match(LSQUARE);
			setState(209);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==HASH || _la==SINGLE_STRING) {
				{
				setState(201);
				postcond();
				setState(206);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(202);
					match(COMMA);
					setState(203);
					postcond();
					}
					}
					setState(208);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(211);
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
			setState(215);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HASH:
				enterOuterAlt(_localctx, 1);
				{
				setState(213);
				item_ref();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(214);
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
			setState(217);
			match(LSQUARE);
			setState(226);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==HASH || _la==STRING) {
				{
				setState(218);
				argument();
				setState(223);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(219);
					match(COMMA);
					setState(220);
					argument();
					}
					}
					setState(225);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(228);
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
			setState(230);
			match(ACTION);
			setState(231);
			match(LCURLY);
			setState(232);
			action_id();
			setState(233);
			match(SEMICOLON);
			setState(234);
			match(DOT);
			setState(235);
			match(TRIGGERS_SYNTAX);
			setState(236);
			triggers();
			setState(237);
			match(SEMICOLON);
			setState(243);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(238);
				match(DOT);
				setState(239);
				match(PREFIX_ROOM);
				setState(240);
				room_name();
				setState(241);
				match(SEMICOLON);
				}
				break;
			}
			setState(245);
			match(DOT);
			setState(246);
			match(ARGUMENTS);
			setState(247);
			arguments();
			setState(248);
			match(SEMICOLON);
			setState(249);
			match(DOT);
			setState(250);
			match(PRECONDS);
			setState(251);
			preconds();
			setState(252);
			match(SEMICOLON);
			setState(253);
			match(DOT);
			setState(254);
			match(POSTCONDS);
			setState(255);
			postconds();
			setState(256);
			match(SEMICOLON);
			setState(257);
			match(DOT);
			setState(258);
			match(SUCCESSMESSAGE);
			setState(259);
			message();
			setState(260);
			match(SEMICOLON);
			setState(261);
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
			setState(263);
			match(ADD_TRIGGER);
			setState(264);
			match(LCURLY);
			setState(265);
			action_ref();
			setState(266);
			match(SEMICOLON);
			setState(267);
			match(DOT);
			setState(268);
			match(ROOM);
			setState(269);
			room_name();
			setState(270);
			match(SEMICOLON);
			setState(271);
			match(DOT);
			setState(272);
			match(TRIGGERS_SYNTAX);
			setState(273);
			triggers();
			setState(274);
			match(SEMICOLON);
			setState(275);
			match(DOT);
			setState(276);
			match(ARGUMENTS);
			setState(277);
			arguments();
			setState(278);
			match(SEMICOLON);
			setState(279);
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
			setState(281);
			match(CUSTOM_TRIGGER);
			setState(282);
			match(LCURLY);
			setState(283);
			match(ALPHANUMERIC);
			setState(284);
			match(SEMICOLON);
			setState(287);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRING) {
				{
				setState(285);
				match(STRING);
				setState(286);
				match(SEMICOLON);
				}
			}

			setState(289);
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
			setState(291);
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
			setState(293);
			match(HASH);
			setState(294);
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
			setState(296);
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
			setState(306);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==HASH) {
				{
				setState(298);
				action();
				setState(303);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(299);
					match(COMMA);
					setState(300);
					action();
					}
					}
					setState(305);
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
			setState(308);
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
			setState(310);
			match(HASH);
			setState(311);
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
			setState(313);
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
			setState(317);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(315);
				item_name();
				}
				break;
			case HASH:
				enterOuterAlt(_localctx, 2);
				{
				setState(316);
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
			setState(327);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==HASH || _la==STRING) {
				{
				setState(319);
				item();
				setState(324);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(320);
					match(COMMA);
					setState(321);
					item();
					}
					}
					setState(326);
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
			setState(329);
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
			setState(331);
			item_adjective();
			setState(336);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(332);
				match(COMMA);
				setState(333);
				item_adjective();
				}
				}
				setState(338);
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
			setState(339);
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
			setState(341);
			item_synonym();
			setState(346);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(342);
				match(COMMA);
				setState(343);
				item_synonym();
				}
				}
				setState(348);
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
			setState(349);
			match(ITEM);
			setState(350);
			match(LCURLY);
			setState(351);
			item_id();
			setState(352);
			match(SEMICOLON);
			setState(353);
			match(DOT);
			setState(354);
			match(ROOM);
			setState(355);
			room_name();
			setState(356);
			match(SEMICOLON);
			setState(357);
			match(DOT);
			setState(358);
			match(ITEM_NAME);
			setState(359);
			item_name();
			setState(360);
			match(SEMICOLON);
			setState(361);
			match(DOT);
			setState(362);
			match(ITEM_ADJECTIVES);
			setState(363);
			match(LSQUARE);
			setState(365);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ALPHANUMERIC) {
				{
				setState(364);
				item_adjectives();
				}
			}

			setState(367);
			match(RSQUARE);
			setState(368);
			match(SEMICOLON);
			setState(369);
			match(DOT);
			setState(370);
			match(ITEM_SYNONYMS);
			setState(371);
			match(LSQUARE);
			setState(373);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRING) {
				{
				setState(372);
				item_synonyms();
				}
			}

			setState(375);
			match(RSQUARE);
			setState(376);
			match(SEMICOLON);
			setState(377);
			match(DOT);
			setState(378);
			match(ITEM_KNOWLEDGE);
			setState(379);
			knowledge_updates();
			setState(380);
			match(SEMICOLON);
			setState(381);
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
			setState(383);
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
			setState(385);
			match(ROOM);
			setState(386);
			match(LCURLY);
			setState(387);
			match(DOT);
			setState(388);
			match(ROOM_NAME);
			setState(389);
			room_name();
			setState(390);
			match(SEMICOLON);
			setState(391);
			match(DOT);
			setState(392);
			match(ACTIONS_SYNTAX);
			setState(393);
			actions();
			setState(394);
			match(SEMICOLON);
			setState(395);
			match(DOT);
			setState(396);
			match(ITEMS);
			setState(397);
			items();
			setState(398);
			match(SEMICOLON);
			setState(399);
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
			setState(401);
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
			setState(403);
			match(ALPHANUMERIC);
			setState(404);
			match(EQUALS);
			setState(405);
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
			setState(407);
			map_entry();
			setState(412);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(408);
				match(COMMA);
				setState(409);
				map_entry();
				}
				}
				setState(414);
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
			setState(415);
			match(GENERICFRAME);
			setState(416);
			match(LCURLY);
			setState(417);
			genericframe_name();
			setState(418);
			match(SEMICOLON);
			setState(419);
			match(LSQUARE);
			setState(421);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ALPHANUMERIC) {
				{
				setState(420);
				map_entries();
				}
			}

			setState(423);
			match(RSQUARE);
			setState(424);
			match(SEMICOLON);
			setState(425);
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
			setState(427);
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
			setState(429);
			match(LSQUARE);
			setState(438);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SINGLE_STRING) {
				{
				setState(430);
				knowledge_update();
				setState(435);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(431);
					match(COMMA);
					setState(432);
					knowledge_update();
					}
					}
					setState(437);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(440);
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
			setState(444);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HASH:
				enterOuterAlt(_localctx, 1);
				{
				setState(442);
				item_ref();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(443);
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
			setState(446);
			global_item();
			setState(451);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(447);
					match(COMMA);
					setState(448);
					global_item();
					}
					} 
				}
				setState(453);
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
			setState(454);
			match(LSQUARE);
			setState(455);
			global_items();
			setState(456);
			match(RSQUARE);
			setState(457);
			match(INHERITS);
			setState(458);
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
			setState(460);
			inheritance();
			{
			setState(461);
			match(COMMA);
			setState(462);
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
			setState(464);
			match(KNOWLEDGE);
			setState(465);
			match(LCURLY);
			setState(466);
			match(DOT);
			setState(467);
			match(GENERIC_INHERITANCE);
			setState(468);
			inheritances();
			setState(469);
			match(SEMICOLON);
			setState(470);
			match(DOT);
			setState(471);
			match(INITIAL);
			setState(473);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LSQUARE) {
				{
				setState(472);
				knowledge_updates();
				}
			}

			setState(475);
			match(SEMICOLON);
			setState(476);
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
			setState(478);
			match(START);
			setState(479);
			match(LCURLY);
			setState(480);
			room_name();
			setState(481);
			match(SEMICOLON);
			setState(482);
			match(STRING);
			setState(483);
			match(SEMICOLON);
			setState(484);
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

	public static class BlockContext extends ParserRuleContext {
		public New_messageContext new_message() {
			return getRuleContext(New_messageContext.class,0);
		}
		public New_actionContext new_action() {
			return getRuleContext(New_actionContext.class,0);
		}
		public New_itemContext new_item() {
			return getRuleContext(New_itemContext.class,0);
		}
		public New_roomContext new_room() {
			return getRuleContext(New_roomContext.class,0);
		}
		public ActionformatContext actionformat() {
			return getRuleContext(ActionformatContext.class,0);
		}
		public New_postcondContext new_postcond() {
			return getRuleContext(New_postcondContext.class,0);
		}
		public New_precondContext new_precond() {
			return getRuleContext(New_precondContext.class,0);
		}
		public Add_triggerContext add_trigger() {
			return getRuleContext(Add_triggerContext.class,0);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GameGrammarListener ) ((GameGrammarListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GameGrammarVisitor ) return ((GameGrammarVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_block);
		try {
			setState(494);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MESSAGE:
				enterOuterAlt(_localctx, 1);
				{
				setState(486);
				new_message();
				}
				break;
			case ACTION:
				enterOuterAlt(_localctx, 2);
				{
				setState(487);
				new_action();
				}
				break;
			case ITEM:
				enterOuterAlt(_localctx, 3);
				{
				setState(488);
				new_item();
				}
				break;
			case ROOM:
				enterOuterAlt(_localctx, 4);
				{
				setState(489);
				new_room();
				}
				break;
			case CUSTOM_TRIGGER:
				enterOuterAlt(_localctx, 5);
				{
				setState(490);
				actionformat();
				}
				break;
			case POSTCOND:
				enterOuterAlt(_localctx, 6);
				{
				setState(491);
				new_postcond();
				}
				break;
			case PRECOND:
				enterOuterAlt(_localctx, 7);
				{
				setState(492);
				new_precond();
				}
				break;
			case ADD_TRIGGER:
				enterOuterAlt(_localctx, 8);
				{
				setState(493);
				add_trigger();
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

	public static class GameContext extends ParserRuleContext {
		public StartContext start() {
			return getRuleContext(StartContext.class,0);
		}
		public TerminalNode EOF() { return getToken(GameGrammarParser.EOF, 0); }
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public List<New_genericframeContext> new_genericframe() {
			return getRuleContexts(New_genericframeContext.class);
		}
		public New_genericframeContext new_genericframe(int i) {
			return getRuleContext(New_genericframeContext.class,i);
		}
		public List<KnowledgeContext> knowledge() {
			return getRuleContexts(KnowledgeContext.class);
		}
		public KnowledgeContext knowledge(int i) {
			return getRuleContext(KnowledgeContext.class,i);
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
		enterRule(_localctx, 108, RULE_game);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(496);
			start();
			setState(500);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MESSAGE) | (1L << ACTION) | (1L << ROOM) | (1L << ITEM) | (1L << PRECOND) | (1L << POSTCOND) | (1L << CUSTOM_TRIGGER) | (1L << ADD_TRIGGER))) != 0)) {
				{
				{
				setState(497);
				block();
				}
				}
				setState(502);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(506);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==GENERICFRAME) {
				{
				{
				setState(503);
				new_genericframe();
				}
				}
				setState(508);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(512);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==KNOWLEDGE) {
				{
				{
				setState(509);
				knowledge();
				}
				}
				setState(514);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(515);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\62\u0208\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\6\3\6\5\6\u0082\n\6\3\7\3\7\3\b\3\b\5"+
		"\b\u0088\n\b\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\5\r\u009e\n\r\3\16\3\16\3\17\3\17\3\17"+
		"\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\5\22\u00b1"+
		"\n\22\3\23\3\23\3\23\3\23\7\23\u00b7\n\23\f\23\16\23\u00ba\13\23\5\23"+
		"\u00bc\n\23\3\23\3\23\3\24\3\24\3\24\3\24\7\24\u00c4\n\24\f\24\16\24\u00c7"+
		"\13\24\3\24\3\24\3\25\3\25\3\25\3\25\7\25\u00cf\n\25\f\25\16\25\u00d2"+
		"\13\25\5\25\u00d4\n\25\3\25\3\25\3\26\3\26\5\26\u00da\n\26\3\27\3\27\3"+
		"\27\3\27\7\27\u00e0\n\27\f\27\16\27\u00e3\13\27\5\27\u00e5\n\27\3\27\3"+
		"\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5"+
		"\30\u00f6\n\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\5\32\u0122\n\32\3\32\3\32\3\33\3\33\3\34\3\34\3\34\3\35"+
		"\3\35\3\36\3\36\3\36\7\36\u0130\n\36\f\36\16\36\u0133\13\36\5\36\u0135"+
		"\n\36\3\37\3\37\3 \3 \3 \3!\3!\3\"\3\"\5\"\u0140\n\"\3#\3#\3#\7#\u0145"+
		"\n#\f#\16#\u0148\13#\5#\u014a\n#\3$\3$\3%\3%\3%\7%\u0151\n%\f%\16%\u0154"+
		"\13%\3&\3&\3\'\3\'\3\'\7\'\u015b\n\'\f\'\16\'\u015e\13\'\3(\3(\3(\3(\3"+
		"(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\5(\u0170\n(\3(\3(\3(\3(\3(\3(\5(\u0178"+
		"\n(\3(\3(\3(\3(\3(\3(\3(\3(\3)\3)\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*"+
		"\3*\3*\3*\3*\3+\3+\3,\3,\3,\3,\3-\3-\3-\7-\u019d\n-\f-\16-\u01a0\13-\3"+
		".\3.\3.\3.\3.\3.\5.\u01a8\n.\3.\3.\3.\3.\3/\3/\3\60\3\60\3\60\3\60\7\60"+
		"\u01b4\n\60\f\60\16\60\u01b7\13\60\5\60\u01b9\n\60\3\60\3\60\3\61\3\61"+
		"\5\61\u01bf\n\61\3\62\3\62\3\62\7\62\u01c4\n\62\f\62\16\62\u01c7\13\62"+
		"\3\63\3\63\3\63\3\63\3\63\3\63\3\64\3\64\3\64\3\64\3\65\3\65\3\65\3\65"+
		"\3\65\3\65\3\65\3\65\3\65\5\65\u01dc\n\65\3\65\3\65\3\65\3\66\3\66\3\66"+
		"\3\66\3\66\3\66\3\66\3\66\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\5\67"+
		"\u01f1\n\67\38\38\78\u01f5\n8\f8\168\u01f8\138\38\78\u01fb\n8\f8\168\u01fe"+
		"\138\38\78\u0201\n8\f8\168\u0204\138\38\38\38\3\u01c5\29\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bd"+
		"fhjln\2\2\2\u01f8\2p\3\2\2\2\4x\3\2\2\2\6z\3\2\2\2\b|\3\2\2\2\n\u0081"+
		"\3\2\2\2\f\u0083\3\2\2\2\16\u0085\3\2\2\2\20\u0089\3\2\2\2\22\u008b\3"+
		"\2\2\2\24\u008e\3\2\2\2\26\u0096\3\2\2\2\30\u009d\3\2\2\2\32\u009f\3\2"+
		"\2\2\34\u00a1\3\2\2\2\36\u00a4\3\2\2\2 \u00a6\3\2\2\2\"\u00b0\3\2\2\2"+
		"$\u00b2\3\2\2\2&\u00bf\3\2\2\2(\u00ca\3\2\2\2*\u00d9\3\2\2\2,\u00db\3"+
		"\2\2\2.\u00e8\3\2\2\2\60\u0109\3\2\2\2\62\u011b\3\2\2\2\64\u0125\3\2\2"+
		"\2\66\u0127\3\2\2\28\u012a\3\2\2\2:\u0134\3\2\2\2<\u0136\3\2\2\2>\u0138"+
		"\3\2\2\2@\u013b\3\2\2\2B\u013f\3\2\2\2D\u0149\3\2\2\2F\u014b\3\2\2\2H"+
		"\u014d\3\2\2\2J\u0155\3\2\2\2L\u0157\3\2\2\2N\u015f\3\2\2\2P\u0181\3\2"+
		"\2\2R\u0183\3\2\2\2T\u0193\3\2\2\2V\u0195\3\2\2\2X\u0199\3\2\2\2Z\u01a1"+
		"\3\2\2\2\\\u01ad\3\2\2\2^\u01af\3\2\2\2`\u01be\3\2\2\2b\u01c0\3\2\2\2"+
		"d\u01c8\3\2\2\2f\u01ce\3\2\2\2h\u01d2\3\2\2\2j\u01e0\3\2\2\2l\u01f0\3"+
		"\2\2\2n\u01f2\3\2\2\2pq\7\n\2\2qr\7\4\2\2rs\5\4\3\2st\7/\2\2tu\7)\2\2"+
		"uv\7/\2\2vw\7\5\2\2w\3\3\2\2\2xy\7\3\2\2y\5\3\2\2\2z{\7)\2\2{\7\3\2\2"+
		"\2|}\7\b\2\2}~\5\4\3\2~\t\3\2\2\2\177\u0082\5\b\5\2\u0080\u0082\5\6\4"+
		"\2\u0081\177\3\2\2\2\u0081\u0080\3\2\2\2\u0082\13\3\2\2\2\u0083\u0084"+
		"\7&\2\2\u0084\r\3\2\2\2\u0085\u0087\7*\2\2\u0086\u0088\5\f\7\2\u0087\u0086"+
		"\3\2\2\2\u0087\u0088\3\2\2\2\u0088\17\3\2\2\2\u0089\u008a\7\3\2\2\u008a"+
		"\21\3\2\2\2\u008b\u008c\7\b\2\2\u008c\u008d\5\20\t\2\u008d\23\3\2\2\2"+
		"\u008e\u008f\7\17\2\2\u008f\u0090\7\4\2\2\u0090\u0091\5\20\t\2\u0091\u0092"+
		"\7/\2\2\u0092\u0093\5\26\f\2\u0093\u0094\7/\2\2\u0094\u0095\7\5\2\2\u0095"+
		"\25\3\2\2\2\u0096\u0097\7(\2\2\u0097\u0098\7-\2\2\u0098\u0099\7)\2\2\u0099"+
		"\u009a\7.\2\2\u009a\27\3\2\2\2\u009b\u009e\5\26\f\2\u009c\u009e\5\22\n"+
		"\2\u009d\u009b\3\2\2\2\u009d\u009c\3\2\2\2\u009e\31\3\2\2\2\u009f\u00a0"+
		"\7\3\2\2\u00a0\33\3\2\2\2\u00a1\u00a2\7\b\2\2\u00a2\u00a3\5\32\16\2\u00a3"+
		"\35\3\2\2\2\u00a4\u00a5\7(\2\2\u00a5\37\3\2\2\2\u00a6\u00a7\7\20\2\2\u00a7"+
		"\u00a8\7\4\2\2\u00a8\u00a9\5\32\16\2\u00a9\u00aa\7/\2\2\u00aa\u00ab\5"+
		"\36\20\2\u00ab\u00ac\7/\2\2\u00ac\u00ad\7\5\2\2\u00ad!\3\2\2\2\u00ae\u00b1"+
		"\5\36\20\2\u00af\u00b1\5\34\17\2\u00b0\u00ae\3\2\2\2\u00b0\u00af\3\2\2"+
		"\2\u00b1#\3\2\2\2\u00b2\u00bb\7\6\2\2\u00b3\u00b8\5\30\r\2\u00b4\u00b5"+
		"\7\30\2\2\u00b5\u00b7\5\30\r\2\u00b6\u00b4\3\2\2\2\u00b7\u00ba\3\2\2\2"+
		"\u00b8\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00bc\3\2\2\2\u00ba\u00b8"+
		"\3\2\2\2\u00bb\u00b3\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd"+
		"\u00be\7\7\2\2\u00be%\3\2\2\2\u00bf\u00c0\7\6\2\2\u00c0\u00c5\5\16\b\2"+
		"\u00c1\u00c2\7\30\2\2\u00c2\u00c4\5\16\b\2\u00c3\u00c1\3\2\2\2\u00c4\u00c7"+
		"\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c8\3\2\2\2\u00c7"+
		"\u00c5\3\2\2\2\u00c8\u00c9\7\7\2\2\u00c9\'\3\2\2\2\u00ca\u00d3\7\6\2\2"+
		"\u00cb\u00d0\5\"\22\2\u00cc\u00cd\7\30\2\2\u00cd\u00cf\5\"\22\2\u00ce"+
		"\u00cc\3\2\2\2\u00cf\u00d2\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d0\u00d1\3\2"+
		"\2\2\u00d1\u00d4\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d3\u00cb\3\2\2\2\u00d3"+
		"\u00d4\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d6\7\7\2\2\u00d6)\3\2\2\2"+
		"\u00d7\u00da\5> \2\u00d8\u00da\7)\2\2\u00d9\u00d7\3\2\2\2\u00d9\u00d8"+
		"\3\2\2\2\u00da+\3\2\2\2\u00db\u00e4\7\6\2\2\u00dc\u00e1\5*\26\2\u00dd"+
		"\u00de\7\30\2\2\u00de\u00e0\5*\26\2\u00df\u00dd\3\2\2\2\u00e0\u00e3\3"+
		"\2\2\2\u00e1\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e5\3\2\2\2\u00e3"+
		"\u00e1\3\2\2\2\u00e4\u00dc\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e6\3\2"+
		"\2\2\u00e6\u00e7\7\7\2\2\u00e7-\3\2\2\2\u00e8\u00e9\7\13\2\2\u00e9\u00ea"+
		"\7\4\2\2\u00ea\u00eb\5\64\33\2\u00eb\u00ec\7/\2\2\u00ec\u00ed\7\60\2\2"+
		"\u00ed\u00ee\7\35\2\2\u00ee\u00ef\5&\24\2\u00ef\u00f5\7/\2\2\u00f0\u00f1"+
		"\7\60\2\2\u00f1\u00f2\7\'\2\2\u00f2\u00f3\5P)\2\u00f3\u00f4\7/\2\2\u00f4"+
		"\u00f6\3\2\2\2\u00f5\u00f0\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f7\3\2"+
		"\2\2\u00f7\u00f8\7\60\2\2\u00f8\u00f9\7\36\2\2\u00f9\u00fa\5,\27\2\u00fa"+
		"\u00fb\7/\2\2\u00fb\u00fc\7\60\2\2\u00fc\u00fd\7\25\2\2\u00fd\u00fe\5"+
		"$\23\2\u00fe\u00ff\7/\2\2\u00ff\u0100\7\60\2\2\u0100\u0101\7\24\2\2\u0101"+
		"\u0102\5(\25\2\u0102\u0103\7/\2\2\u0103\u0104\7\60\2\2\u0104\u0105\7\34"+
		"\2\2\u0105\u0106\5\n\6\2\u0106\u0107\7/\2\2\u0107\u0108\7\5\2\2\u0108"+
		"/\3\2\2\2\u0109\u010a\7%\2\2\u010a\u010b\7\4\2\2\u010b\u010c\5\66\34\2"+
		"\u010c\u010d\7/\2\2\u010d\u010e\7\60\2\2\u010e\u010f\7\f\2\2\u010f\u0110"+
		"\5P)\2\u0110\u0111\7/\2\2\u0111\u0112\7\60\2\2\u0112\u0113\7\35\2\2\u0113"+
		"\u0114\5&\24\2\u0114\u0115\7/\2\2\u0115\u0116\7\60\2\2\u0116\u0117\7\36"+
		"\2\2\u0117\u0118\5,\27\2\u0118\u0119\7/\2\2\u0119\u011a\7\5\2\2\u011a"+
		"\61\3\2\2\2\u011b\u011c\7\22\2\2\u011c\u011d\7\4\2\2\u011d\u011e\7*\2"+
		"\2\u011e\u0121\7/\2\2\u011f\u0120\7)\2\2\u0120\u0122\7/\2\2\u0121\u011f"+
		"\3\2\2\2\u0121\u0122\3\2\2\2\u0122\u0123\3\2\2\2\u0123\u0124\7\5\2\2\u0124"+
		"\63\3\2\2\2\u0125\u0126\7\3\2\2\u0126\65\3\2\2\2\u0127\u0128\7\b\2\2\u0128"+
		"\u0129\5\64\33\2\u0129\67\3\2\2\2\u012a\u012b\5\66\34\2\u012b9\3\2\2\2"+
		"\u012c\u0131\58\35\2\u012d\u012e\7\30\2\2\u012e\u0130\58\35\2\u012f\u012d"+
		"\3\2\2\2\u0130\u0133\3\2\2\2\u0131\u012f\3\2\2\2\u0131\u0132\3\2\2\2\u0132"+
		"\u0135\3\2\2\2\u0133\u0131\3\2\2\2\u0134\u012c\3\2\2\2\u0134\u0135\3\2"+
		"\2\2\u0135;\3\2\2\2\u0136\u0137\7\3\2\2\u0137=\3\2\2\2\u0138\u0139\7\b"+
		"\2\2\u0139\u013a\5<\37\2\u013a?\3\2\2\2\u013b\u013c\7)\2\2\u013cA\3\2"+
		"\2\2\u013d\u0140\5@!\2\u013e\u0140\5> \2\u013f\u013d\3\2\2\2\u013f\u013e"+
		"\3\2\2\2\u0140C\3\2\2\2\u0141\u0146\5B\"\2\u0142\u0143\7\30\2\2\u0143"+
		"\u0145\5B\"\2\u0144\u0142\3\2\2\2\u0145\u0148\3\2\2\2\u0146\u0144\3\2"+
		"\2\2\u0146\u0147\3\2\2\2\u0147\u014a\3\2\2\2\u0148\u0146\3\2\2\2\u0149"+
		"\u0141\3\2\2\2\u0149\u014a\3\2\2\2\u014aE\3\2\2\2\u014b\u014c\7*\2\2\u014c"+
		"G\3\2\2\2\u014d\u0152\5F$\2\u014e\u014f\7\30\2\2\u014f\u0151\5F$\2\u0150"+
		"\u014e\3\2\2\2\u0151\u0154\3\2\2\2\u0152\u0150\3\2\2\2\u0152\u0153\3\2"+
		"\2\2\u0153I\3\2\2\2\u0154\u0152\3\2\2\2\u0155\u0156\7)\2\2\u0156K\3\2"+
		"\2\2\u0157\u015c\5J&\2\u0158\u0159\7\30\2\2\u0159\u015b\5J&\2\u015a\u0158"+
		"\3\2\2\2\u015b\u015e\3\2\2\2\u015c\u015a\3\2\2\2\u015c\u015d\3\2\2\2\u015d"+
		"M\3\2\2\2\u015e\u015c\3\2\2\2\u015f\u0160\7\r\2\2\u0160\u0161\7\4\2\2"+
		"\u0161\u0162\5<\37\2\u0162\u0163\7/\2\2\u0163\u0164\7\60\2\2\u0164\u0165"+
		"\7\f\2\2\u0165\u0166\5P)\2\u0166\u0167\7/\2\2\u0167\u0168\7\60\2\2\u0168"+
		"\u0169\7\"\2\2\u0169\u016a\5@!\2\u016a\u016b\7/\2\2\u016b\u016c\7\60\2"+
		"\2\u016c\u016d\7\26\2\2\u016d\u016f\7\6\2\2\u016e\u0170\5H%\2\u016f\u016e"+
		"\3\2\2\2\u016f\u0170\3\2\2\2\u0170\u0171\3\2\2\2\u0171\u0172\7\7\2\2\u0172"+
		"\u0173\7/\2\2\u0173\u0174\7\60\2\2\u0174\u0175\7\27\2\2\u0175\u0177\7"+
		"\6\2\2\u0176\u0178\5L\'\2\u0177\u0176\3\2\2\2\u0177\u0178\3\2\2\2\u0178"+
		"\u0179\3\2\2\2\u0179\u017a\7\7\2\2\u017a\u017b\7/\2\2\u017b\u017c\7\60"+
		"\2\2\u017c\u017d\7#\2\2\u017d\u017e\5^\60\2\u017e\u017f\7/\2\2\u017f\u0180"+
		"\7\5\2\2\u0180O\3\2\2\2\u0181\u0182\7)\2\2\u0182Q\3\2\2\2\u0183\u0184"+
		"\7\f\2\2\u0184\u0185\7\4\2\2\u0185\u0186\7\60\2\2\u0186\u0187\7!\2\2\u0187"+
		"\u0188\5P)\2\u0188\u0189\7/\2\2\u0189\u018a\7\60\2\2\u018a\u018b\7\31"+
		"\2\2\u018b\u018c\5:\36\2\u018c\u018d\7/\2\2\u018d\u018e\7\60\2\2\u018e"+
		"\u018f\7\32\2\2\u018f\u0190\5D#\2\u0190\u0191\7/\2\2\u0191\u0192\7\5\2"+
		"\2\u0192S\3\2\2\2\u0193\u0194\7)\2\2\u0194U\3\2\2\2\u0195\u0196\7*\2\2"+
		"\u0196\u0197\7\61\2\2\u0197\u0198\7)\2\2\u0198W\3\2\2\2\u0199\u019e\5"+
		"V,\2\u019a\u019b\7\30\2\2\u019b\u019d\5V,\2\u019c\u019a\3\2\2\2\u019d"+
		"\u01a0\3\2\2\2\u019e\u019c\3\2\2\2\u019e\u019f\3\2\2\2\u019fY\3\2\2\2"+
		"\u01a0\u019e\3\2\2\2\u01a1\u01a2\7\21\2\2\u01a2\u01a3\7\4\2\2\u01a3\u01a4"+
		"\5T+\2\u01a4\u01a5\7/\2\2\u01a5\u01a7\7\6\2\2\u01a6\u01a8\5X-\2\u01a7"+
		"\u01a6\3\2\2\2\u01a7\u01a8\3\2\2\2\u01a8\u01a9\3\2\2\2\u01a9\u01aa\7\7"+
		"\2\2\u01aa\u01ab\7/\2\2\u01ab\u01ac\7\5\2\2\u01ac[\3\2\2\2\u01ad\u01ae"+
		"\7(\2\2\u01ae]\3\2\2\2\u01af\u01b8\7\6\2\2\u01b0\u01b5\5\\/\2\u01b1\u01b2"+
		"\7\30\2\2\u01b2\u01b4\5\\/\2\u01b3\u01b1\3\2\2\2\u01b4\u01b7\3\2\2\2\u01b5"+
		"\u01b3\3\2\2\2\u01b5\u01b6\3\2\2\2\u01b6\u01b9\3\2\2\2\u01b7\u01b5\3\2"+
		"\2\2\u01b8\u01b0\3\2\2\2\u01b8\u01b9\3\2\2\2\u01b9\u01ba\3\2\2\2\u01ba"+
		"\u01bb\7\7\2\2\u01bb_\3\2\2\2\u01bc\u01bf\5> \2\u01bd\u01bf\7)\2\2\u01be"+
		"\u01bc\3\2\2\2\u01be\u01bd\3\2\2\2\u01bfa\3\2\2\2\u01c0\u01c5\5`\61\2"+
		"\u01c1\u01c2\7\30\2\2\u01c2\u01c4\5`\61\2\u01c3\u01c1\3\2\2\2\u01c4\u01c7"+
		"\3\2\2\2\u01c5\u01c6\3\2\2\2\u01c5\u01c3\3\2\2\2\u01c6c\3\2\2\2\u01c7"+
		"\u01c5\3\2\2\2\u01c8\u01c9\7\6\2\2\u01c9\u01ca\5b\62\2\u01ca\u01cb\7\7"+
		"\2\2\u01cb\u01cc\7 \2\2\u01cc\u01cd\7)\2\2\u01cde\3\2\2\2\u01ce\u01cf"+
		"\5d\63\2\u01cf\u01d0\7\30\2\2\u01d0\u01d1\5d\63\2\u01d1g\3\2\2\2\u01d2"+
		"\u01d3\7\16\2\2\u01d3\u01d4\7\4\2\2\u01d4\u01d5\7\60\2\2\u01d5\u01d6\7"+
		"$\2\2\u01d6\u01d7\5f\64\2\u01d7\u01d8\7/\2\2\u01d8\u01d9\7\60\2\2\u01d9"+
		"\u01db\7\23\2\2\u01da\u01dc\5^\60\2\u01db\u01da\3\2\2\2\u01db\u01dc\3"+
		"\2\2\2\u01dc\u01dd\3\2\2\2\u01dd\u01de\7/\2\2\u01de\u01df\7\5\2\2\u01df"+
		"i\3\2\2\2\u01e0\u01e1\7\t\2\2\u01e1\u01e2\7\4\2\2\u01e2\u01e3\5P)\2\u01e3"+
		"\u01e4\7/\2\2\u01e4\u01e5\7)\2\2\u01e5\u01e6\7/\2\2\u01e6\u01e7\7\5\2"+
		"\2\u01e7k\3\2\2\2\u01e8\u01f1\5\2\2\2\u01e9\u01f1\5.\30\2\u01ea\u01f1"+
		"\5N(\2\u01eb\u01f1\5R*\2\u01ec\u01f1\5\62\32\2\u01ed\u01f1\5 \21\2\u01ee"+
		"\u01f1\5\24\13\2\u01ef\u01f1\5\60\31\2\u01f0\u01e8\3\2\2\2\u01f0\u01e9"+
		"\3\2\2\2\u01f0\u01ea\3\2\2\2\u01f0\u01eb\3\2\2\2\u01f0\u01ec\3\2\2\2\u01f0"+
		"\u01ed\3\2\2\2\u01f0\u01ee\3\2\2\2\u01f0\u01ef\3\2\2\2\u01f1m\3\2\2\2"+
		"\u01f2\u01f6\5j\66\2\u01f3\u01f5\5l\67\2\u01f4\u01f3\3\2\2\2\u01f5\u01f8"+
		"\3\2\2\2\u01f6\u01f4\3\2\2\2\u01f6\u01f7\3\2\2\2\u01f7\u01fc\3\2\2\2\u01f8"+
		"\u01f6\3\2\2\2\u01f9\u01fb\5Z.\2\u01fa\u01f9\3\2\2\2\u01fb\u01fe\3\2\2"+
		"\2\u01fc\u01fa\3\2\2\2\u01fc\u01fd\3\2\2\2\u01fd\u0202\3\2\2\2\u01fe\u01fc"+
		"\3\2\2\2\u01ff\u0201\5h\65\2\u0200\u01ff\3\2\2\2\u0201\u0204\3\2\2\2\u0202"+
		"\u0200\3\2\2\2\u0202\u0203\3\2\2\2\u0203\u0205\3\2\2\2\u0204\u0202\3\2"+
		"\2\2\u0205\u0206\7\2\2\3\u0206o\3\2\2\2$\u0081\u0087\u009d\u00b0\u00b8"+
		"\u00bb\u00c5\u00d0\u00d3\u00d9\u00e1\u00e4\u00f5\u0121\u0131\u0134\u013f"+
		"\u0146\u0149\u0152\u015c\u016f\u0177\u019e\u01a7\u01b5\u01b8\u01be\u01c5"+
		"\u01db\u01f0\u01f6\u01fc\u0202";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}