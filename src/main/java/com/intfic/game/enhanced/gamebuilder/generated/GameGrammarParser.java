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
		TRIGGER_SELECTOR=36, SINGLE_STRING=37, STRING=38, ALPHANUMERIC=39, INTEGER=40, 
		DECIMAL=41, LPAREN=42, RPAREN=43, SEMICOLON=44, DOT=45, EQUALS=46, WS=47, 
		STRINGLIST=48, NUMBERLIST=49, BOOLEAN=50;
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
		RULE_map_entry = 42, RULE_new_genericframe = 43, RULE_knowledge_update = 44, 
		RULE_knowledge_updates = 45, RULE_global_item = 46, RULE_global_items = 47, 
		RULE_inheritance = 48, RULE_knowledge = 49, RULE_start = 50, RULE_game = 51;
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
			"map_entry", "new_genericframe", "knowledge_update", "knowledge_updates", 
			"global_item", "global_items", "inheritance", "knowledge", "start", "game"
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
			"'add_trigger'", null, null, null, null, null, null, "'('", "')'", "';'", 
			"'.'", "'<-'"
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
			"ADD_TRIGGER", "TRIGGER_SELECTOR", "SINGLE_STRING", "STRING", "ALPHANUMERIC", 
			"INTEGER", "DECIMAL", "LPAREN", "RPAREN", "SEMICOLON", "DOT", "EQUALS", 
			"WS", "STRINGLIST", "NUMBERLIST", "BOOLEAN"
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
			setState(104);
			match(MESSAGE);
			setState(105);
			match(LCURLY);
			setState(106);
			message_id();
			setState(107);
			match(SEMICOLON);
			setState(108);
			match(STRING);
			setState(109);
			match(SEMICOLON);
			setState(110);
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
			setState(112);
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
			setState(114);
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
			setState(116);
			match(HASH);
			setState(117);
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
			setState(121);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HASH:
				enterOuterAlt(_localctx, 1);
				{
				setState(119);
				message_ref();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(120);
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
			setState(123);
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
			setState(125);
			match(ALPHANUMERIC);
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TRIGGER_SELECTOR) {
				{
				setState(126);
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
			setState(129);
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
			setState(131);
			match(HASH);
			setState(132);
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
			setState(134);
			match(PRECOND);
			setState(135);
			match(LCURLY);
			setState(136);
			precond_id();
			setState(137);
			match(SEMICOLON);
			setState(138);
			precond_body();
			setState(139);
			match(SEMICOLON);
			setState(140);
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
			setState(142);
			match(SINGLE_STRING);
			setState(143);
			match(LPAREN);
			setState(144);
			match(STRING);
			setState(145);
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
			setState(149);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SINGLE_STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(147);
				precond_body();
				}
				break;
			case HASH:
				enterOuterAlt(_localctx, 2);
				{
				setState(148);
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
			setState(151);
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
			setState(153);
			match(HASH);
			setState(154);
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
			setState(156);
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
			setState(158);
			match(POSTCOND);
			setState(159);
			match(LCURLY);
			setState(160);
			postcond_id();
			setState(161);
			match(SEMICOLON);
			setState(162);
			postcond_body();
			setState(163);
			match(SEMICOLON);
			setState(164);
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
			setState(168);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SINGLE_STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(166);
				postcond_body();
				}
				break;
			case HASH:
				enterOuterAlt(_localctx, 2);
				{
				setState(167);
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
			setState(170);
			match(LSQUARE);
			setState(179);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==HASH || _la==SINGLE_STRING) {
				{
				setState(171);
				precond();
				setState(176);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(172);
					match(COMMA);
					setState(173);
					precond();
					}
					}
					setState(178);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(181);
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
			setState(183);
			match(LSQUARE);
			setState(184);
			trigger();
			setState(189);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(185);
				match(COMMA);
				setState(186);
				trigger();
				}
				}
				setState(191);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(192);
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
			setState(194);
			match(LSQUARE);
			setState(203);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==HASH || _la==SINGLE_STRING) {
				{
				setState(195);
				postcond();
				setState(200);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(196);
					match(COMMA);
					setState(197);
					postcond();
					}
					}
					setState(202);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(205);
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
			setState(209);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HASH:
				enterOuterAlt(_localctx, 1);
				{
				setState(207);
				item_ref();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(208);
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
			setState(211);
			match(LSQUARE);
			setState(220);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==HASH || _la==STRING) {
				{
				setState(212);
				argument();
				setState(217);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(213);
					match(COMMA);
					setState(214);
					argument();
					}
					}
					setState(219);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(222);
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
		enterRule(_localctx, 44, RULE_new_action);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			match(ACTION);
			setState(225);
			match(LCURLY);
			setState(226);
			action_id();
			setState(227);
			match(SEMICOLON);
			setState(228);
			match(DOT);
			setState(229);
			match(ROOM);
			setState(230);
			room_name();
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
			setState(236);
			match(DOT);
			setState(237);
			match(ARGUMENTS);
			setState(238);
			arguments();
			setState(239);
			match(SEMICOLON);
			setState(240);
			match(DOT);
			setState(241);
			match(PRECONDS);
			setState(242);
			preconds();
			setState(243);
			match(SEMICOLON);
			setState(244);
			match(DOT);
			setState(245);
			match(POSTCONDS);
			setState(246);
			postconds();
			setState(247);
			match(SEMICOLON);
			setState(248);
			match(DOT);
			setState(249);
			match(SUCCESSMESSAGE);
			setState(250);
			message();
			setState(251);
			match(SEMICOLON);
			setState(252);
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
			setState(254);
			match(ADD_TRIGGER);
			setState(255);
			match(LCURLY);
			setState(256);
			action_ref();
			setState(257);
			match(SEMICOLON);
			setState(258);
			match(DOT);
			setState(259);
			match(ROOM);
			setState(260);
			room_name();
			setState(261);
			match(SEMICOLON);
			setState(262);
			match(DOT);
			setState(263);
			match(TRIGGERS_SYNTAX);
			setState(264);
			triggers();
			setState(265);
			match(SEMICOLON);
			setState(266);
			match(DOT);
			setState(267);
			match(ARGUMENTS);
			setState(268);
			arguments();
			setState(269);
			match(SEMICOLON);
			setState(270);
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
			setState(272);
			match(CUSTOM_TRIGGER);
			setState(273);
			match(LCURLY);
			setState(274);
			match(ALPHANUMERIC);
			setState(275);
			match(SEMICOLON);
			setState(278);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRING) {
				{
				setState(276);
				match(STRING);
				setState(277);
				match(SEMICOLON);
				}
			}

			setState(280);
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
			setState(282);
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
			setState(284);
			match(HASH);
			setState(285);
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
			setState(287);
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
			setState(297);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==HASH) {
				{
				setState(289);
				action();
				setState(294);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(290);
					match(COMMA);
					setState(291);
					action();
					}
					}
					setState(296);
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
			setState(299);
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
			setState(301);
			match(HASH);
			setState(302);
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
			setState(304);
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
			setState(308);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(306);
				item_name();
				}
				break;
			case HASH:
				enterOuterAlt(_localctx, 2);
				{
				setState(307);
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
			setState(318);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==HASH || _la==STRING) {
				{
				setState(310);
				item();
				setState(315);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(311);
					match(COMMA);
					setState(312);
					item();
					}
					}
					setState(317);
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
			setState(320);
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
			setState(322);
			item_adjective();
			setState(327);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(323);
				match(COMMA);
				setState(324);
				item_adjective();
				}
				}
				setState(329);
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
		public TerminalNode ALPHANUMERIC() { return getToken(GameGrammarParser.ALPHANUMERIC, 0); }
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
			setState(330);
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
			setState(332);
			item_synonym();
			setState(337);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(333);
				match(COMMA);
				setState(334);
				item_synonym();
				}
				}
				setState(339);
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
			setState(340);
			match(ITEM);
			setState(341);
			match(LCURLY);
			setState(342);
			item_id();
			setState(343);
			match(SEMICOLON);
			setState(344);
			match(DOT);
			setState(345);
			match(ROOM);
			setState(346);
			room_name();
			setState(347);
			match(SEMICOLON);
			setState(348);
			match(DOT);
			setState(349);
			match(ITEM_NAME);
			setState(350);
			item_name();
			setState(351);
			match(SEMICOLON);
			setState(352);
			match(DOT);
			setState(353);
			match(ITEM_ADJECTIVES);
			setState(354);
			match(LSQUARE);
			setState(356);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ALPHANUMERIC) {
				{
				setState(355);
				item_adjectives();
				}
			}

			setState(358);
			match(RSQUARE);
			setState(359);
			match(SEMICOLON);
			setState(360);
			match(DOT);
			setState(361);
			match(ITEM_SYNONYMS);
			setState(362);
			match(LSQUARE);
			setState(364);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ALPHANUMERIC) {
				{
				setState(363);
				item_synonyms();
				}
			}

			setState(366);
			match(RSQUARE);
			setState(367);
			match(SEMICOLON);
			setState(368);
			match(DOT);
			setState(369);
			match(ITEM_KNOWLEDGE);
			setState(370);
			knowledge_updates();
			setState(371);
			match(SEMICOLON);
			setState(372);
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
			setState(374);
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
			setState(376);
			match(ROOM);
			setState(377);
			match(LCURLY);
			setState(378);
			match(DOT);
			setState(379);
			match(ROOM_NAME);
			setState(380);
			room_name();
			setState(381);
			match(SEMICOLON);
			setState(382);
			match(DOT);
			setState(383);
			match(ACTIONS_SYNTAX);
			setState(384);
			actions();
			setState(385);
			match(SEMICOLON);
			setState(386);
			match(DOT);
			setState(387);
			match(ITEMS);
			setState(388);
			items();
			setState(389);
			match(SEMICOLON);
			setState(390);
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
			setState(392);
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
		enterRule(_localctx, 84, RULE_map_entry);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(394);
			match(ALPHANUMERIC);
			setState(395);
			match(EQUALS);
			setState(396);
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
		enterRule(_localctx, 86, RULE_new_genericframe);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(398);
			match(GENERICFRAME);
			setState(399);
			match(LCURLY);
			setState(400);
			genericframe_name();
			setState(401);
			match(SEMICOLON);
			setState(402);
			match(LSQUARE);
			setState(411);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ALPHANUMERIC) {
				{
				setState(403);
				map_entry();
				setState(408);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(404);
					match(COMMA);
					setState(405);
					map_entry();
					}
					}
					setState(410);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(413);
			match(RSQUARE);
			setState(414);
			match(SEMICOLON);
			setState(415);
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
		enterRule(_localctx, 88, RULE_knowledge_update);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(417);
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
		enterRule(_localctx, 90, RULE_knowledge_updates);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(419);
			match(LSQUARE);
			setState(428);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SINGLE_STRING) {
				{
				setState(420);
				knowledge_update();
				setState(425);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(421);
					match(COMMA);
					setState(422);
					knowledge_update();
					}
					}
					setState(427);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(430);
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
		enterRule(_localctx, 92, RULE_global_item);
		try {
			setState(434);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(432);
				item_id();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(433);
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
		enterRule(_localctx, 94, RULE_global_items);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(436);
			global_item();
			setState(441);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(437);
					match(COMMA);
					setState(438);
					global_item();
					}
					} 
				}
				setState(443);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
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
		enterRule(_localctx, 96, RULE_inheritance);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(444);
			match(LSQUARE);
			setState(445);
			global_items();
			setState(446);
			match(RSQUARE);
			setState(447);
			match(INHERITS);
			setState(448);
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
		enterRule(_localctx, 98, RULE_knowledge);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(450);
			match(KNOWLEDGE);
			setState(451);
			match(LCURLY);
			setState(452);
			match(DOT);
			setState(453);
			match(GENERIC_INHERITANCE);
			setState(454);
			inheritance();
			{
			setState(455);
			match(COMMA);
			setState(456);
			inheritance();
			}
			setState(458);
			match(SEMICOLON);
			setState(459);
			match(DOT);
			setState(460);
			match(INITIAL);
			setState(462);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LSQUARE) {
				{
				setState(461);
				knowledge_updates();
				}
			}

			setState(464);
			match(SEMICOLON);
			setState(465);
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
		enterRule(_localctx, 100, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(467);
			match(START);
			setState(468);
			match(LCURLY);
			setState(469);
			room_name();
			setState(470);
			match(SEMICOLON);
			setState(471);
			match(STRING);
			setState(472);
			match(SEMICOLON);
			setState(473);
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
		enterRule(_localctx, 102, RULE_game);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(475);
			start();
			setState(486);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MESSAGE) | (1L << ACTION) | (1L << ROOM) | (1L << ITEM) | (1L << PRECOND) | (1L << POSTCOND) | (1L << CUSTOM_TRIGGER) | (1L << ADD_TRIGGER))) != 0)) {
				{
				setState(484);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case MESSAGE:
					{
					setState(476);
					new_message();
					}
					break;
				case ACTION:
					{
					setState(477);
					new_action();
					}
					break;
				case ITEM:
					{
					setState(478);
					new_item();
					}
					break;
				case ROOM:
					{
					setState(479);
					new_room();
					}
					break;
				case CUSTOM_TRIGGER:
					{
					setState(480);
					actionformat();
					}
					break;
				case POSTCOND:
					{
					setState(481);
					new_postcond();
					}
					break;
				case PRECOND:
					{
					setState(482);
					new_precond();
					}
					break;
				case ADD_TRIGGER:
					{
					setState(483);
					add_trigger();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(488);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(492);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==GENERICFRAME) {
				{
				{
				setState(489);
				new_genericframe();
				}
				}
				setState(494);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(496);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KNOWLEDGE) {
				{
				setState(495);
				knowledge();
				}
			}

			setState(498);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\64\u01f7\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5"+
		"\3\5\3\6\3\6\5\6|\n\6\3\7\3\7\3\b\3\b\5\b\u0082\n\b\3\t\3\t\3\n\3\n\3"+
		"\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r"+
		"\5\r\u0098\n\r\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\22\3\22\5\22\u00ab\n\22\3\23\3\23\3\23\3\23\7\23"+
		"\u00b1\n\23\f\23\16\23\u00b4\13\23\5\23\u00b6\n\23\3\23\3\23\3\24\3\24"+
		"\3\24\3\24\7\24\u00be\n\24\f\24\16\24\u00c1\13\24\3\24\3\24\3\25\3\25"+
		"\3\25\3\25\7\25\u00c9\n\25\f\25\16\25\u00cc\13\25\5\25\u00ce\n\25\3\25"+
		"\3\25\3\26\3\26\5\26\u00d4\n\26\3\27\3\27\3\27\3\27\7\27\u00da\n\27\f"+
		"\27\16\27\u00dd\13\27\5\27\u00df\n\27\3\27\3\27\3\30\3\30\3\30\3\30\3"+
		"\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3"+
		"\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3"+
		"\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3"+
		"\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u0119\n\32\3\32\3\32\3\33"+
		"\3\33\3\34\3\34\3\34\3\35\3\35\3\36\3\36\3\36\7\36\u0127\n\36\f\36\16"+
		"\36\u012a\13\36\5\36\u012c\n\36\3\37\3\37\3 \3 \3 \3!\3!\3\"\3\"\5\"\u0137"+
		"\n\"\3#\3#\3#\7#\u013c\n#\f#\16#\u013f\13#\5#\u0141\n#\3$\3$\3%\3%\3%"+
		"\7%\u0148\n%\f%\16%\u014b\13%\3&\3&\3\'\3\'\3\'\7\'\u0152\n\'\f\'\16\'"+
		"\u0155\13\'\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\5(\u0167\n"+
		"(\3(\3(\3(\3(\3(\3(\5(\u016f\n(\3(\3(\3(\3(\3(\3(\3(\3(\3)\3)\3*\3*\3"+
		"*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3+\3+\3,\3,\3,\3,\3-\3-\3-\3"+
		"-\3-\3-\3-\3-\7-\u0199\n-\f-\16-\u019c\13-\5-\u019e\n-\3-\3-\3-\3-\3."+
		"\3.\3/\3/\3/\3/\7/\u01aa\n/\f/\16/\u01ad\13/\5/\u01af\n/\3/\3/\3\60\3"+
		"\60\5\60\u01b5\n\60\3\61\3\61\3\61\7\61\u01ba\n\61\f\61\16\61\u01bd\13"+
		"\61\3\62\3\62\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3"+
		"\63\3\63\3\63\3\63\3\63\5\63\u01d1\n\63\3\63\3\63\3\63\3\64\3\64\3\64"+
		"\3\64\3\64\3\64\3\64\3\64\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65"+
		"\7\65\u01e7\n\65\f\65\16\65\u01ea\13\65\3\65\7\65\u01ed\n\65\f\65\16\65"+
		"\u01f0\13\65\3\65\5\65\u01f3\n\65\3\65\3\65\3\65\3\u01bb\2\66\2\4\6\b"+
		"\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVX"+
		"Z\\^`bdfh\2\3\5\2((++\62\64\2\u01e9\2j\3\2\2\2\4r\3\2\2\2\6t\3\2\2\2\b"+
		"v\3\2\2\2\n{\3\2\2\2\f}\3\2\2\2\16\177\3\2\2\2\20\u0083\3\2\2\2\22\u0085"+
		"\3\2\2\2\24\u0088\3\2\2\2\26\u0090\3\2\2\2\30\u0097\3\2\2\2\32\u0099\3"+
		"\2\2\2\34\u009b\3\2\2\2\36\u009e\3\2\2\2 \u00a0\3\2\2\2\"\u00aa\3\2\2"+
		"\2$\u00ac\3\2\2\2&\u00b9\3\2\2\2(\u00c4\3\2\2\2*\u00d3\3\2\2\2,\u00d5"+
		"\3\2\2\2.\u00e2\3\2\2\2\60\u0100\3\2\2\2\62\u0112\3\2\2\2\64\u011c\3\2"+
		"\2\2\66\u011e\3\2\2\28\u0121\3\2\2\2:\u012b\3\2\2\2<\u012d\3\2\2\2>\u012f"+
		"\3\2\2\2@\u0132\3\2\2\2B\u0136\3\2\2\2D\u0140\3\2\2\2F\u0142\3\2\2\2H"+
		"\u0144\3\2\2\2J\u014c\3\2\2\2L\u014e\3\2\2\2N\u0156\3\2\2\2P\u0178\3\2"+
		"\2\2R\u017a\3\2\2\2T\u018a\3\2\2\2V\u018c\3\2\2\2X\u0190\3\2\2\2Z\u01a3"+
		"\3\2\2\2\\\u01a5\3\2\2\2^\u01b4\3\2\2\2`\u01b6\3\2\2\2b\u01be\3\2\2\2"+
		"d\u01c4\3\2\2\2f\u01d5\3\2\2\2h\u01dd\3\2\2\2jk\7\n\2\2kl\7\4\2\2lm\5"+
		"\4\3\2mn\7.\2\2no\7(\2\2op\7.\2\2pq\7\5\2\2q\3\3\2\2\2rs\7\3\2\2s\5\3"+
		"\2\2\2tu\7(\2\2u\7\3\2\2\2vw\7\b\2\2wx\5\4\3\2x\t\3\2\2\2y|\5\b\5\2z|"+
		"\5\6\4\2{y\3\2\2\2{z\3\2\2\2|\13\3\2\2\2}~\7&\2\2~\r\3\2\2\2\177\u0081"+
		"\7)\2\2\u0080\u0082\5\f\7\2\u0081\u0080\3\2\2\2\u0081\u0082\3\2\2\2\u0082"+
		"\17\3\2\2\2\u0083\u0084\7\3\2\2\u0084\21\3\2\2\2\u0085\u0086\7\b\2\2\u0086"+
		"\u0087\5\20\t\2\u0087\23\3\2\2\2\u0088\u0089\7\17\2\2\u0089\u008a\7\4"+
		"\2\2\u008a\u008b\5\20\t\2\u008b\u008c\7.\2\2\u008c\u008d\5\26\f\2\u008d"+
		"\u008e\7.\2\2\u008e\u008f\7\5\2\2\u008f\25\3\2\2\2\u0090\u0091\7\'\2\2"+
		"\u0091\u0092\7,\2\2\u0092\u0093\7(\2\2\u0093\u0094\7-\2\2\u0094\27\3\2"+
		"\2\2\u0095\u0098\5\26\f\2\u0096\u0098\5\22\n\2\u0097\u0095\3\2\2\2\u0097"+
		"\u0096\3\2\2\2\u0098\31\3\2\2\2\u0099\u009a\7\3\2\2\u009a\33\3\2\2\2\u009b"+
		"\u009c\7\b\2\2\u009c\u009d\5\32\16\2\u009d\35\3\2\2\2\u009e\u009f\7\'"+
		"\2\2\u009f\37\3\2\2\2\u00a0\u00a1\7\20\2\2\u00a1\u00a2\7\4\2\2\u00a2\u00a3"+
		"\5\32\16\2\u00a3\u00a4\7.\2\2\u00a4\u00a5\5\36\20\2\u00a5\u00a6\7.\2\2"+
		"\u00a6\u00a7\7\5\2\2\u00a7!\3\2\2\2\u00a8\u00ab\5\36\20\2\u00a9\u00ab"+
		"\5\34\17\2\u00aa\u00a8\3\2\2\2\u00aa\u00a9\3\2\2\2\u00ab#\3\2\2\2\u00ac"+
		"\u00b5\7\6\2\2\u00ad\u00b2\5\30\r\2\u00ae\u00af\7\30\2\2\u00af\u00b1\5"+
		"\30\r\2\u00b0\u00ae\3\2\2\2\u00b1\u00b4\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2"+
		"\u00b3\3\2\2\2\u00b3\u00b6\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b5\u00ad\3\2"+
		"\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b8\7\7\2\2\u00b8"+
		"%\3\2\2\2\u00b9\u00ba\7\6\2\2\u00ba\u00bf\5\16\b\2\u00bb\u00bc\7\30\2"+
		"\2\u00bc\u00be\5\16\b\2\u00bd\u00bb\3\2\2\2\u00be\u00c1\3\2\2\2\u00bf"+
		"\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c2\3\2\2\2\u00c1\u00bf\3\2"+
		"\2\2\u00c2\u00c3\7\7\2\2\u00c3\'\3\2\2\2\u00c4\u00cd\7\6\2\2\u00c5\u00ca"+
		"\5\"\22\2\u00c6\u00c7\7\30\2\2\u00c7\u00c9\5\"\22\2\u00c8\u00c6\3\2\2"+
		"\2\u00c9\u00cc\3\2\2\2\u00ca\u00c8\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00ce"+
		"\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cd\u00c5\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce"+
		"\u00cf\3\2\2\2\u00cf\u00d0\7\7\2\2\u00d0)\3\2\2\2\u00d1\u00d4\5> \2\u00d2"+
		"\u00d4\7(\2\2\u00d3\u00d1\3\2\2\2\u00d3\u00d2\3\2\2\2\u00d4+\3\2\2\2\u00d5"+
		"\u00de\7\6\2\2\u00d6\u00db\5*\26\2\u00d7\u00d8\7\30\2\2\u00d8\u00da\5"+
		"*\26\2\u00d9\u00d7\3\2\2\2\u00da\u00dd\3\2\2\2\u00db\u00d9\3\2\2\2\u00db"+
		"\u00dc\3\2\2\2\u00dc\u00df\3\2\2\2\u00dd\u00db\3\2\2\2\u00de\u00d6\3\2"+
		"\2\2\u00de\u00df\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0\u00e1\7\7\2\2\u00e1"+
		"-\3\2\2\2\u00e2\u00e3\7\13\2\2\u00e3\u00e4\7\4\2\2\u00e4\u00e5\5\64\33"+
		"\2\u00e5\u00e6\7.\2\2\u00e6\u00e7\7/\2\2\u00e7\u00e8\7\f\2\2\u00e8\u00e9"+
		"\5P)\2\u00e9\u00ea\7.\2\2\u00ea\u00eb\7/\2\2\u00eb\u00ec\7\35\2\2\u00ec"+
		"\u00ed\5&\24\2\u00ed\u00ee\7.\2\2\u00ee\u00ef\7/\2\2\u00ef\u00f0\7\36"+
		"\2\2\u00f0\u00f1\5,\27\2\u00f1\u00f2\7.\2\2\u00f2\u00f3\7/\2\2\u00f3\u00f4"+
		"\7\25\2\2\u00f4\u00f5\5$\23\2\u00f5\u00f6\7.\2\2\u00f6\u00f7\7/\2\2\u00f7"+
		"\u00f8\7\24\2\2\u00f8\u00f9\5(\25\2\u00f9\u00fa\7.\2\2\u00fa\u00fb\7/"+
		"\2\2\u00fb\u00fc\7\34\2\2\u00fc\u00fd\5\n\6\2\u00fd\u00fe\7.\2\2\u00fe"+
		"\u00ff\7\5\2\2\u00ff/\3\2\2\2\u0100\u0101\7%\2\2\u0101\u0102\7\4\2\2\u0102"+
		"\u0103\5\66\34\2\u0103\u0104\7.\2\2\u0104\u0105\7/\2\2\u0105\u0106\7\f"+
		"\2\2\u0106\u0107\5P)\2\u0107\u0108\7.\2\2\u0108\u0109\7/\2\2\u0109\u010a"+
		"\7\35\2\2\u010a\u010b\5&\24\2\u010b\u010c\7.\2\2\u010c\u010d\7/\2\2\u010d"+
		"\u010e\7\36\2\2\u010e\u010f\5,\27\2\u010f\u0110\7.\2\2\u0110\u0111\7\5"+
		"\2\2\u0111\61\3\2\2\2\u0112\u0113\7\22\2\2\u0113\u0114\7\4\2\2\u0114\u0115"+
		"\7)\2\2\u0115\u0118\7.\2\2\u0116\u0117\7(\2\2\u0117\u0119\7.\2\2\u0118"+
		"\u0116\3\2\2\2\u0118\u0119\3\2\2\2\u0119\u011a\3\2\2\2\u011a\u011b\7\5"+
		"\2\2\u011b\63\3\2\2\2\u011c\u011d\7\3\2\2\u011d\65\3\2\2\2\u011e\u011f"+
		"\7\b\2\2\u011f\u0120\5\64\33\2\u0120\67\3\2\2\2\u0121\u0122\5\66\34\2"+
		"\u01229\3\2\2\2\u0123\u0128\58\35\2\u0124\u0125\7\30\2\2\u0125\u0127\5"+
		"8\35\2\u0126\u0124\3\2\2\2\u0127\u012a\3\2\2\2\u0128\u0126\3\2\2\2\u0128"+
		"\u0129\3\2\2\2\u0129\u012c\3\2\2\2\u012a\u0128\3\2\2\2\u012b\u0123\3\2"+
		"\2\2\u012b\u012c\3\2\2\2\u012c;\3\2\2\2\u012d\u012e\7\3\2\2\u012e=\3\2"+
		"\2\2\u012f\u0130\7\b\2\2\u0130\u0131\5<\37\2\u0131?\3\2\2\2\u0132\u0133"+
		"\7(\2\2\u0133A\3\2\2\2\u0134\u0137\5@!\2\u0135\u0137\5> \2\u0136\u0134"+
		"\3\2\2\2\u0136\u0135\3\2\2\2\u0137C\3\2\2\2\u0138\u013d\5B\"\2\u0139\u013a"+
		"\7\30\2\2\u013a\u013c\5B\"\2\u013b\u0139\3\2\2\2\u013c\u013f\3\2\2\2\u013d"+
		"\u013b\3\2\2\2\u013d\u013e\3\2\2\2\u013e\u0141\3\2\2\2\u013f\u013d\3\2"+
		"\2\2\u0140\u0138\3\2\2\2\u0140\u0141\3\2\2\2\u0141E\3\2\2\2\u0142\u0143"+
		"\7)\2\2\u0143G\3\2\2\2\u0144\u0149\5F$\2\u0145\u0146\7\30\2\2\u0146\u0148"+
		"\5F$\2\u0147\u0145\3\2\2\2\u0148\u014b\3\2\2\2\u0149\u0147\3\2\2\2\u0149"+
		"\u014a\3\2\2\2\u014aI\3\2\2\2\u014b\u0149\3\2\2\2\u014c\u014d\7)\2\2\u014d"+
		"K\3\2\2\2\u014e\u0153\5J&\2\u014f\u0150\7\30\2\2\u0150\u0152\5J&\2\u0151"+
		"\u014f\3\2\2\2\u0152\u0155\3\2\2\2\u0153\u0151\3\2\2\2\u0153\u0154\3\2"+
		"\2\2\u0154M\3\2\2\2\u0155\u0153\3\2\2\2\u0156\u0157\7\r\2\2\u0157\u0158"+
		"\7\4\2\2\u0158\u0159\5<\37\2\u0159\u015a\7.\2\2\u015a\u015b\7/\2\2\u015b"+
		"\u015c\7\f\2\2\u015c\u015d\5P)\2\u015d\u015e\7.\2\2\u015e\u015f\7/\2\2"+
		"\u015f\u0160\7\"\2\2\u0160\u0161\5@!\2\u0161\u0162\7.\2\2\u0162\u0163"+
		"\7/\2\2\u0163\u0164\7\26\2\2\u0164\u0166\7\6\2\2\u0165\u0167\5H%\2\u0166"+
		"\u0165\3\2\2\2\u0166\u0167\3\2\2\2\u0167\u0168\3\2\2\2\u0168\u0169\7\7"+
		"\2\2\u0169\u016a\7.\2\2\u016a\u016b\7/\2\2\u016b\u016c\7\27\2\2\u016c"+
		"\u016e\7\6\2\2\u016d\u016f\5L\'\2\u016e\u016d\3\2\2\2\u016e\u016f\3\2"+
		"\2\2\u016f\u0170\3\2\2\2\u0170\u0171\7\7\2\2\u0171\u0172\7.\2\2\u0172"+
		"\u0173\7/\2\2\u0173\u0174\7#\2\2\u0174\u0175\5\\/\2\u0175\u0176\7.\2\2"+
		"\u0176\u0177\7\5\2\2\u0177O\3\2\2\2\u0178\u0179\7(\2\2\u0179Q\3\2\2\2"+
		"\u017a\u017b\7\f\2\2\u017b\u017c\7\4\2\2\u017c\u017d\7/\2\2\u017d\u017e"+
		"\7!\2\2\u017e\u017f\5P)\2\u017f\u0180\7.\2\2\u0180\u0181\7/\2\2\u0181"+
		"\u0182\7\31\2\2\u0182\u0183\5:\36\2\u0183\u0184\7.\2\2\u0184\u0185\7/"+
		"\2\2\u0185\u0186\7\32\2\2\u0186\u0187\5D#\2\u0187\u0188\7.\2\2\u0188\u0189"+
		"\7\5\2\2\u0189S\3\2\2\2\u018a\u018b\7(\2\2\u018bU\3\2\2\2\u018c\u018d"+
		"\7)\2\2\u018d\u018e\7\60\2\2\u018e\u018f\t\2\2\2\u018fW\3\2\2\2\u0190"+
		"\u0191\7\21\2\2\u0191\u0192\7\4\2\2\u0192\u0193\5T+\2\u0193\u0194\7.\2"+
		"\2\u0194\u019d\7\6\2\2\u0195\u019a\5V,\2\u0196\u0197\7\30\2\2\u0197\u0199"+
		"\5V,\2\u0198\u0196\3\2\2\2\u0199\u019c\3\2\2\2\u019a\u0198\3\2\2\2\u019a"+
		"\u019b\3\2\2\2\u019b\u019e\3\2\2\2\u019c\u019a\3\2\2\2\u019d\u0195\3\2"+
		"\2\2\u019d\u019e\3\2\2\2\u019e\u019f\3\2\2\2\u019f\u01a0\7\7\2\2\u01a0"+
		"\u01a1\7.\2\2\u01a1\u01a2\7\5\2\2\u01a2Y\3\2\2\2\u01a3\u01a4\7\'\2\2\u01a4"+
		"[\3\2\2\2\u01a5\u01ae\7\6\2\2\u01a6\u01ab\5Z.\2\u01a7\u01a8\7\30\2\2\u01a8"+
		"\u01aa\5Z.\2\u01a9\u01a7\3\2\2\2\u01aa\u01ad\3\2\2\2\u01ab\u01a9\3\2\2"+
		"\2\u01ab\u01ac\3\2\2\2\u01ac\u01af\3\2\2\2\u01ad\u01ab\3\2\2\2\u01ae\u01a6"+
		"\3\2\2\2\u01ae\u01af\3\2\2\2\u01af\u01b0\3\2\2\2\u01b0\u01b1\7\7\2\2\u01b1"+
		"]\3\2\2\2\u01b2\u01b5\5<\37\2\u01b3\u01b5\7(\2\2\u01b4\u01b2\3\2\2\2\u01b4"+
		"\u01b3\3\2\2\2\u01b5_\3\2\2\2\u01b6\u01bb\5^\60\2\u01b7\u01b8\7\30\2\2"+
		"\u01b8\u01ba\5^\60\2\u01b9\u01b7\3\2\2\2\u01ba\u01bd\3\2\2\2\u01bb\u01bc"+
		"\3\2\2\2\u01bb\u01b9\3\2\2\2\u01bca\3\2\2\2\u01bd\u01bb\3\2\2\2\u01be"+
		"\u01bf\7\6\2\2\u01bf\u01c0\5`\61\2\u01c0\u01c1\7\7\2\2\u01c1\u01c2\7 "+
		"\2\2\u01c2\u01c3\7(\2\2\u01c3c\3\2\2\2\u01c4\u01c5\7\16\2\2\u01c5\u01c6"+
		"\7\4\2\2\u01c6\u01c7\7/\2\2\u01c7\u01c8\7$\2\2\u01c8\u01c9\5b\62\2\u01c9"+
		"\u01ca\7\30\2\2\u01ca\u01cb\5b\62\2\u01cb\u01cc\3\2\2\2\u01cc\u01cd\7"+
		".\2\2\u01cd\u01ce\7/\2\2\u01ce\u01d0\7\23\2\2\u01cf\u01d1\5\\/\2\u01d0"+
		"\u01cf\3\2\2\2\u01d0\u01d1\3\2\2\2\u01d1\u01d2\3\2\2\2\u01d2\u01d3\7."+
		"\2\2\u01d3\u01d4\7\5\2\2\u01d4e\3\2\2\2\u01d5\u01d6\7\t\2\2\u01d6\u01d7"+
		"\7\4\2\2\u01d7\u01d8\5P)\2\u01d8\u01d9\7.\2\2\u01d9\u01da\7(\2\2\u01da"+
		"\u01db\7.\2\2\u01db\u01dc\7\5\2\2\u01dcg\3\2\2\2\u01dd\u01e8\5f\64\2\u01de"+
		"\u01e7\5\2\2\2\u01df\u01e7\5.\30\2\u01e0\u01e7\5N(\2\u01e1\u01e7\5R*\2"+
		"\u01e2\u01e7\5\62\32\2\u01e3\u01e7\5 \21\2\u01e4\u01e7\5\24\13\2\u01e5"+
		"\u01e7\5\60\31\2\u01e6\u01de\3\2\2\2\u01e6\u01df\3\2\2\2\u01e6\u01e0\3"+
		"\2\2\2\u01e6\u01e1\3\2\2\2\u01e6\u01e2\3\2\2\2\u01e6\u01e3\3\2\2\2\u01e6"+
		"\u01e4\3\2\2\2\u01e6\u01e5\3\2\2\2\u01e7\u01ea\3\2\2\2\u01e8\u01e6\3\2"+
		"\2\2\u01e8\u01e9\3\2\2\2\u01e9\u01ee\3\2\2\2\u01ea\u01e8\3\2\2\2\u01eb"+
		"\u01ed\5X-\2\u01ec\u01eb\3\2\2\2\u01ed\u01f0\3\2\2\2\u01ee\u01ec\3\2\2"+
		"\2\u01ee\u01ef\3\2\2\2\u01ef\u01f2\3\2\2\2\u01f0\u01ee\3\2\2\2\u01f1\u01f3"+
		"\5d\63\2\u01f2\u01f1\3\2\2\2\u01f2\u01f3\3\2\2\2\u01f3\u01f4\3\2\2\2\u01f4"+
		"\u01f5\7\2\2\3\u01f5i\3\2\2\2#{\u0081\u0097\u00aa\u00b2\u00b5\u00bf\u00ca"+
		"\u00cd\u00d3\u00db\u00de\u0118\u0128\u012b\u0136\u013d\u0140\u0149\u0153"+
		"\u0166\u016e\u019a\u019d\u01ab\u01ae\u01b4\u01bb\u01d0\u01e6\u01e8\u01ee"+
		"\u01f2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}