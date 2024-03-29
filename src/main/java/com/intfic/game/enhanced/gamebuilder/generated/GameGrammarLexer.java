// Generated from /Users/noahohrner/OneDrive - University of Cambridge/Dissertation/Code/interactive-fiction/GameGrammar.g4 by ANTLR 4.9.1
package com.intfic.game.enhanced.gamebuilder.generated;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GameGrammarLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"ID", "LCURLY", "RCURLY", "LSQUARE", "RSQUARE", "HASH", "START", "MESSAGE", 
			"ACTION", "ROOM", "ITEM", "KNOWLEDGE", "PRECOND", "POSTCOND", "GENERICFRAME", 
			"CUSTOM_TRIGGER", "INITIAL", "POSTCONDS", "PRECONDS", "ITEM_ADJECTIVES", 
			"ITEM_SYNONYMS", "COMMA", "ACTIONS_SYNTAX", "ITEMS", "NAME", "SUCCESSMESSAGE", 
			"TRIGGERS_SYNTAX", "ARGUMENTS", "PARENTS", "INHERITS", "ROOM_NAME", "ITEM_NAME", 
			"ITEM_KNOWLEDGE", "GENERIC_INHERITANCE", "ADD_TRIGGER", "TRIGGER_SELECTOR", 
			"PREFIX_ROOM", "SINGLE_STRING", "STRING", "ALPHANUMERIC", "INTEGER", 
			"DECIMAL", "LPAREN", "RPAREN", "SEMICOLON", "DOT", "EQUALS", "DASH", 
			"QUOTE", "SINGLE_QUOTE", "WS"
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


	public GameGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "GameGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\62\u01da\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3"+
		"\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3"+
		"\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3"+
		"\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3"+
		"\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3"+
		"\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3"+
		"\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3\"\3"+
		"\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#"+
		"\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3$\3$"+
		"\3$\3$\3$\3$\3%\3%\3%\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3\'\3\'\7\'"+
		"\u0199\n\'\f\'\16\'\u019c\13\'\3\'\3\'\3(\3(\7(\u01a2\n(\f(\16(\u01a5"+
		"\13(\3(\3(\3)\6)\u01aa\n)\r)\16)\u01ab\3*\6*\u01af\n*\r*\16*\u01b0\3+"+
		"\5+\u01b4\n+\3+\6+\u01b7\n+\r+\16+\u01b8\3+\3+\6+\u01bd\n+\r+\16+\u01be"+
		"\5+\u01c1\n+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\60\3\61\3\61\3\62\3\62"+
		"\3\63\3\63\3\64\6\64\u01d5\n\64\r\64\16\64\u01d6\3\64\3\64\2\2\65\3\3"+
		"\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
		"!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!"+
		"A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\2c\2e\2g\62\3\2\7\b\2\13\f\16"+
		"\17\"(*.\60]_\u0080\7\2\13\f\16\17\"#%.\60\u0080\5\2\62;C\\c|\3\2\62;"+
		"\5\2\13\f\16\17\"\"\2\u01df\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3"+
		"\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2"+
		"\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37"+
		"\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3"+
		"\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2"+
		"\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C"+
		"\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2"+
		"\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2"+
		"\2]\3\2\2\2\2_\3\2\2\2\2g\3\2\2\2\3i\3\2\2\2\5m\3\2\2\2\7o\3\2\2\2\tq"+
		"\3\2\2\2\13s\3\2\2\2\ru\3\2\2\2\17w\3\2\2\2\21}\3\2\2\2\23\u0085\3\2\2"+
		"\2\25\u008c\3\2\2\2\27\u0091\3\2\2\2\31\u0096\3\2\2\2\33\u00a0\3\2\2\2"+
		"\35\u00a8\3\2\2\2\37\u00b1\3\2\2\2!\u00bf\3\2\2\2#\u00ce\3\2\2\2%\u00d6"+
		"\3\2\2\2\'\u00e0\3\2\2\2)\u00e9\3\2\2\2+\u00f4\3\2\2\2-\u00fd\3\2\2\2"+
		"/\u00ff\3\2\2\2\61\u0107\3\2\2\2\63\u010d\3\2\2\2\65\u0112\3\2\2\2\67"+
		"\u011e\3\2\2\29\u012e\3\2\2\2;\u0133\3\2\2\2=\u013b\3\2\2\2?\u0144\3\2"+
		"\2\2A\u014e\3\2\2\2C\u0158\3\2\2\2E\u0167\3\2\2\2G\u017b\3\2\2\2I\u0187"+
		"\3\2\2\2K\u018a\3\2\2\2M\u0196\3\2\2\2O\u019f\3\2\2\2Q\u01a9\3\2\2\2S"+
		"\u01ae\3\2\2\2U\u01b3\3\2\2\2W\u01c2\3\2\2\2Y\u01c4\3\2\2\2[\u01c6\3\2"+
		"\2\2]\u01c8\3\2\2\2_\u01ca\3\2\2\2a\u01cd\3\2\2\2c\u01cf\3\2\2\2e\u01d1"+
		"\3\2\2\2g\u01d4\3\2\2\2ij\5W,\2jk\5Q)\2kl\5Y-\2l\4\3\2\2\2mn\7}\2\2n\6"+
		"\3\2\2\2op\7\177\2\2p\b\3\2\2\2qr\7]\2\2r\n\3\2\2\2st\7_\2\2t\f\3\2\2"+
		"\2uv\7%\2\2v\16\3\2\2\2wx\7u\2\2xy\7v\2\2yz\7c\2\2z{\7t\2\2{|\7v\2\2|"+
		"\20\3\2\2\2}~\7o\2\2~\177\7g\2\2\177\u0080\7u\2\2\u0080\u0081\7u\2\2\u0081"+
		"\u0082\7c\2\2\u0082\u0083\7i\2\2\u0083\u0084\7g\2\2\u0084\22\3\2\2\2\u0085"+
		"\u0086\7c\2\2\u0086\u0087\7e\2\2\u0087\u0088\7v\2\2\u0088\u0089\7k\2\2"+
		"\u0089\u008a\7q\2\2\u008a\u008b\7p\2\2\u008b\24\3\2\2\2\u008c\u008d\7"+
		"t\2\2\u008d\u008e\7q\2\2\u008e\u008f\7q\2\2\u008f\u0090\7o\2\2\u0090\26"+
		"\3\2\2\2\u0091\u0092\7k\2\2\u0092\u0093\7v\2\2\u0093\u0094\7g\2\2\u0094"+
		"\u0095\7o\2\2\u0095\30\3\2\2\2\u0096\u0097\7m\2\2\u0097\u0098\7p\2\2\u0098"+
		"\u0099\7q\2\2\u0099\u009a\7y\2\2\u009a\u009b\7n\2\2\u009b\u009c\7g\2\2"+
		"\u009c\u009d\7f\2\2\u009d\u009e\7i\2\2\u009e\u009f\7g\2\2\u009f\32\3\2"+
		"\2\2\u00a0\u00a1\7r\2\2\u00a1\u00a2\7t\2\2\u00a2\u00a3\7g\2\2\u00a3\u00a4"+
		"\7e\2\2\u00a4\u00a5\7q\2\2\u00a5\u00a6\7p\2\2\u00a6\u00a7\7f\2\2\u00a7"+
		"\34\3\2\2\2\u00a8\u00a9\7r\2\2\u00a9\u00aa\7q\2\2\u00aa\u00ab\7u\2\2\u00ab"+
		"\u00ac\7v\2\2\u00ac\u00ad\7e\2\2\u00ad\u00ae\7q\2\2\u00ae\u00af\7p\2\2"+
		"\u00af\u00b0\7f\2\2\u00b0\36\3\2\2\2\u00b1\u00b2\7i\2\2\u00b2\u00b3\7"+
		"g\2\2\u00b3\u00b4\7p\2\2\u00b4\u00b5\7g\2\2\u00b5\u00b6\7t\2\2\u00b6\u00b7"+
		"\7k\2\2\u00b7\u00b8\7e\2\2\u00b8\u00b9\7a\2\2\u00b9\u00ba\7h\2\2\u00ba"+
		"\u00bb\7t\2\2\u00bb\u00bc\7c\2\2\u00bc\u00bd\7o\2\2\u00bd\u00be\7g\2\2"+
		"\u00be \3\2\2\2\u00bf\u00c0\7e\2\2\u00c0\u00c1\7w\2\2\u00c1\u00c2\7u\2"+
		"\2\u00c2\u00c3\7v\2\2\u00c3\u00c4\7q\2\2\u00c4\u00c5\7o\2\2\u00c5\u00c6"+
		"\7a\2\2\u00c6\u00c7\7v\2\2\u00c7\u00c8\7t\2\2\u00c8\u00c9\7k\2\2\u00c9"+
		"\u00ca\7i\2\2\u00ca\u00cb\7i\2\2\u00cb\u00cc\7g\2\2\u00cc\u00cd\7t\2\2"+
		"\u00cd\"\3\2\2\2\u00ce\u00cf\7k\2\2\u00cf\u00d0\7p\2\2\u00d0\u00d1\7k"+
		"\2\2\u00d1\u00d2\7v\2\2\u00d2\u00d3\7k\2\2\u00d3\u00d4\7c\2\2\u00d4\u00d5"+
		"\7n\2\2\u00d5$\3\2\2\2\u00d6\u00d7\7r\2\2\u00d7\u00d8\7q\2\2\u00d8\u00d9"+
		"\7u\2\2\u00d9\u00da\7v\2\2\u00da\u00db\7e\2\2\u00db\u00dc\7q\2\2\u00dc"+
		"\u00dd\7p\2\2\u00dd\u00de\7f\2\2\u00de\u00df\7u\2\2\u00df&\3\2\2\2\u00e0"+
		"\u00e1\7r\2\2\u00e1\u00e2\7t\2\2\u00e2\u00e3\7g\2\2\u00e3\u00e4\7e\2\2"+
		"\u00e4\u00e5\7q\2\2\u00e5\u00e6\7p\2\2\u00e6\u00e7\7f\2\2\u00e7\u00e8"+
		"\7u\2\2\u00e8(\3\2\2\2\u00e9\u00ea\7c\2\2\u00ea\u00eb\7f\2\2\u00eb\u00ec"+
		"\7l\2\2\u00ec\u00ed\7g\2\2\u00ed\u00ee\7e\2\2\u00ee\u00ef\7v\2\2\u00ef"+
		"\u00f0\7k\2\2\u00f0\u00f1\7x\2\2\u00f1\u00f2\7g\2\2\u00f2\u00f3\7u\2\2"+
		"\u00f3*\3\2\2\2\u00f4\u00f5\7u\2\2\u00f5\u00f6\7{\2\2\u00f6\u00f7\7p\2"+
		"\2\u00f7\u00f8\7q\2\2\u00f8\u00f9\7p\2\2\u00f9\u00fa\7{\2\2\u00fa\u00fb"+
		"\7o\2\2\u00fb\u00fc\7u\2\2\u00fc,\3\2\2\2\u00fd\u00fe\7.\2\2\u00fe.\3"+
		"\2\2\2\u00ff\u0100\7c\2\2\u0100\u0101\7e\2\2\u0101\u0102\7v\2\2\u0102"+
		"\u0103\7k\2\2\u0103\u0104\7q\2\2\u0104\u0105\7p\2\2\u0105\u0106\7u\2\2"+
		"\u0106\60\3\2\2\2\u0107\u0108\7k\2\2\u0108\u0109\7v\2\2\u0109\u010a\7"+
		"g\2\2\u010a\u010b\7o\2\2\u010b\u010c\7u\2\2\u010c\62\3\2\2\2\u010d\u010e"+
		"\7p\2\2\u010e\u010f\7c\2\2\u010f\u0110\7o\2\2\u0110\u0111\7g\2\2\u0111"+
		"\64\3\2\2\2\u0112\u0113\7u\2\2\u0113\u0114\7w\2\2\u0114\u0115\7e\2\2\u0115"+
		"\u0116\7e\2\2\u0116\u0117\7g\2\2\u0117\u0118\7u\2\2\u0118\u0119\7u\2\2"+
		"\u0119\u011a\7a\2\2\u011a\u011b\7o\2\2\u011b\u011c\7u\2\2\u011c\u011d"+
		"\7i\2\2\u011d\66\3\2\2\2\u011e\u011f\7c\2\2\u011f\u0120\7e\2\2\u0120\u0121"+
		"\7v\2\2\u0121\u0122\7k\2\2\u0122\u0123\7q\2\2\u0123\u0124\7p\2\2\u0124"+
		"\u0125\7a\2\2\u0125\u0126\7v\2\2\u0126\u0127\7t\2\2\u0127\u0128\7k\2\2"+
		"\u0128\u0129\7i\2\2\u0129\u012a\7i\2\2\u012a\u012b\7g\2\2\u012b\u012c"+
		"\7t\2\2\u012c\u012d\7u\2\2\u012d8\3\2\2\2\u012e\u012f\7c\2\2\u012f\u0130"+
		"\7t\2\2\u0130\u0131\7i\2\2\u0131\u0132\7u\2\2\u0132:\3\2\2\2\u0133\u0134"+
		"\7r\2\2\u0134\u0135\7c\2\2\u0135\u0136\7t\2\2\u0136\u0137\7g\2\2\u0137"+
		"\u0138\7p\2\2\u0138\u0139\7v\2\2\u0139\u013a\7u\2\2\u013a<\3\2\2\2\u013b"+
		"\u013c\7k\2\2\u013c\u013d\7p\2\2\u013d\u013e\7j\2\2\u013e\u013f\7g\2\2"+
		"\u013f\u0140\7t\2\2\u0140\u0141\7k\2\2\u0141\u0142\7v\2\2\u0142\u0143"+
		"\7u\2\2\u0143>\3\2\2\2\u0144\u0145\7t\2\2\u0145\u0146\7q\2\2\u0146\u0147"+
		"\7q\2\2\u0147\u0148\7o\2\2\u0148\u0149\7a\2\2\u0149\u014a\7p\2\2\u014a"+
		"\u014b\7c\2\2\u014b\u014c\7o\2\2\u014c\u014d\7g\2\2\u014d@\3\2\2\2\u014e"+
		"\u014f\7k\2\2\u014f\u0150\7v\2\2\u0150\u0151\7g\2\2\u0151\u0152\7o\2\2"+
		"\u0152\u0153\7a\2\2\u0153\u0154\7p\2\2\u0154\u0155\7c\2\2\u0155\u0156"+
		"\7o\2\2\u0156\u0157\7g\2\2\u0157B\3\2\2\2\u0158\u0159\7k\2\2\u0159\u015a"+
		"\7v\2\2\u015a\u015b\7g\2\2\u015b\u015c\7o\2\2\u015c\u015d\7a\2\2\u015d"+
		"\u015e\7m\2\2\u015e\u015f\7p\2\2\u015f\u0160\7q\2\2\u0160\u0161\7y\2\2"+
		"\u0161\u0162\7n\2\2\u0162\u0163\7g\2\2\u0163\u0164\7f\2\2\u0164\u0165"+
		"\7i\2\2\u0165\u0166\7g\2\2\u0166D\3\2\2\2\u0167\u0168\7i\2\2\u0168\u0169"+
		"\7g\2\2\u0169\u016a\7p\2\2\u016a\u016b\7g\2\2\u016b\u016c\7t\2\2\u016c"+
		"\u016d\7k\2\2\u016d\u016e\7e\2\2\u016e\u016f\7a\2\2\u016f\u0170\7k\2\2"+
		"\u0170\u0171\7p\2\2\u0171\u0172\7j\2\2\u0172\u0173\7g\2\2\u0173\u0174"+
		"\7t\2\2\u0174\u0175\7k\2\2\u0175\u0176\7v\2\2\u0176\u0177\7c\2\2\u0177"+
		"\u0178\7p\2\2\u0178\u0179\7e\2\2\u0179\u017a\7g\2\2\u017aF\3\2\2\2\u017b"+
		"\u017c\7c\2\2\u017c\u017d\7f\2\2\u017d\u017e\7f\2\2\u017e\u017f\7a\2\2"+
		"\u017f\u0180\7v\2\2\u0180\u0181\7t\2\2\u0181\u0182\7k\2\2\u0182\u0183"+
		"\7i\2\2\u0183\u0184\7i\2\2\u0184\u0185\7g\2\2\u0185\u0186\7t\2\2\u0186"+
		"H\3\2\2\2\u0187\u0188\5a\61\2\u0188\u0189\5S*\2\u0189J\3\2\2\2\u018a\u018b"+
		"\7r\2\2\u018b\u018c\7t\2\2\u018c\u018d\7g\2\2\u018d\u018e\7h\2\2\u018e"+
		"\u018f\7k\2\2\u018f\u0190\7z\2\2\u0190\u0191\7a\2\2\u0191\u0192\7t\2\2"+
		"\u0192\u0193\7q\2\2\u0193\u0194\7q\2\2\u0194\u0195\7o\2\2\u0195L\3\2\2"+
		"\2\u0196\u019a\5e\63\2\u0197\u0199\t\2\2\2\u0198\u0197\3\2\2\2\u0199\u019c"+
		"\3\2\2\2\u019a\u0198\3\2\2\2\u019a\u019b\3\2\2\2\u019b\u019d\3\2\2\2\u019c"+
		"\u019a\3\2\2\2\u019d\u019e\5e\63\2\u019eN\3\2\2\2\u019f\u01a3\5c\62\2"+
		"\u01a0\u01a2\t\3\2\2\u01a1\u01a0\3\2\2\2\u01a2\u01a5\3\2\2\2\u01a3\u01a1"+
		"\3\2\2\2\u01a3\u01a4\3\2\2\2\u01a4\u01a6\3\2\2\2\u01a5\u01a3\3\2\2\2\u01a6"+
		"\u01a7\5c\62\2\u01a7P\3\2\2\2\u01a8\u01aa\t\4\2\2\u01a9\u01a8\3\2\2\2"+
		"\u01aa\u01ab\3\2\2\2\u01ab\u01a9\3\2\2\2\u01ab\u01ac\3\2\2\2\u01acR\3"+
		"\2\2\2\u01ad\u01af\t\5\2\2\u01ae\u01ad\3\2\2\2\u01af\u01b0\3\2\2\2\u01b0"+
		"\u01ae\3\2\2\2\u01b0\u01b1\3\2\2\2\u01b1T\3\2\2\2\u01b2\u01b4\7/\2\2\u01b3"+
		"\u01b2\3\2\2\2\u01b3\u01b4\3\2\2\2\u01b4\u01b6\3\2\2\2\u01b5\u01b7\t\5"+
		"\2\2\u01b6\u01b5\3\2\2\2\u01b7\u01b8\3\2\2\2\u01b8\u01b6\3\2\2\2\u01b8"+
		"\u01b9\3\2\2\2\u01b9\u01c0\3\2\2\2\u01ba\u01bc\7\60\2\2\u01bb\u01bd\t"+
		"\5\2\2\u01bc\u01bb\3\2\2\2\u01bd\u01be\3\2\2\2\u01be\u01bc\3\2\2\2\u01be"+
		"\u01bf\3\2\2\2\u01bf\u01c1\3\2\2\2\u01c0\u01ba\3\2\2\2\u01c0\u01c1\3\2"+
		"\2\2\u01c1V\3\2\2\2\u01c2\u01c3\7*\2\2\u01c3X\3\2\2\2\u01c4\u01c5\7+\2"+
		"\2\u01c5Z\3\2\2\2\u01c6\u01c7\7=\2\2\u01c7\\\3\2\2\2\u01c8\u01c9\7\60"+
		"\2\2\u01c9^\3\2\2\2\u01ca\u01cb\7>\2\2\u01cb\u01cc\7/\2\2\u01cc`\3\2\2"+
		"\2\u01cd\u01ce\7/\2\2\u01ceb\3\2\2\2\u01cf\u01d0\7$\2\2\u01d0d\3\2\2\2"+
		"\u01d1\u01d2\7)\2\2\u01d2f\3\2\2\2\u01d3\u01d5\t\6\2\2\u01d4\u01d3\3\2"+
		"\2\2\u01d5\u01d6\3\2\2\2\u01d6\u01d4\3\2\2\2\u01d6\u01d7\3\2\2\2\u01d7"+
		"\u01d8\3\2\2\2\u01d8\u01d9\b\64\2\2\u01d9h\3\2\2\2\f\2\u019a\u01a3\u01ab"+
		"\u01b0\u01b3\u01b8\u01be\u01c0\u01d6\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}