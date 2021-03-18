// Generated from /Users/noahohrner/OneDrive - University of Cambridge/Dissertation/Code/interactive-fiction/GameGrammar.g4 by ANTLR 4.9.1
package com.intfic.game.enhanced.gamebuilder;
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
		CUSTOM_TRIGGER=16, INITIAL=17, POSTCONDS=18, PRECONDS=19, COMMA=20, ACTIONS_SYNTAX=21, 
		ITEMS=22, NAME=23, SUCCESSMESSAGE=24, TRIGGERS_SYNTAX=25, ARGUMENTS=26, 
		PARENTS=27, INHERITS=28, ROOM_NAME=29, ITEM_NAME=30, ITEM_KNOWLEDGE=31, 
		GENERIC_INHERITANCE=32, TRIGGER_SELECTOR=33, SINGLE_STRING=34, STRING=35, 
		ALPHANUMERIC=36, INTEGER=37, DECIMAL=38, LPAREN=39, RPAREN=40, SEMICOLON=41, 
		DOT=42, EQUALS=43, DASH=44, WS=45;
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
			"CUSTOM_TRIGGER", "INITIAL", "POSTCONDS", "PRECONDS", "COMMA", "ACTIONS_SYNTAX", 
			"ITEMS", "NAME", "SUCCESSMESSAGE", "TRIGGERS_SYNTAX", "ARGUMENTS", "PARENTS", 
			"INHERITS", "ROOM_NAME", "ITEM_NAME", "ITEM_KNOWLEDGE", "GENERIC_INHERITANCE", 
			"TRIGGER_SELECTOR", "SINGLE_STRING", "STRING", "ALPHANUMERIC", "INTEGER", 
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
			"DOT", "EQUALS", "DASH", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2/\u01a6\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3"+
		"\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f"+
		"\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3"+
		"\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3"+
		"\27\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3"+
		"\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3"+
		"\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3"+
		"\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3"+
		"\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3"+
		"\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3"+
		" \3 \3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3\"\3"+
		"\"\3\"\3#\3#\7#\u0165\n#\f#\16#\u0168\13#\3#\3#\3$\3$\7$\u016e\n$\f$\16"+
		"$\u0171\13$\3$\3$\3%\6%\u0176\n%\r%\16%\u0177\3&\6&\u017b\n&\r&\16&\u017c"+
		"\3\'\5\'\u0180\n\'\3\'\6\'\u0183\n\'\r\'\16\'\u0184\3\'\3\'\6\'\u0189"+
		"\n\'\r\'\16\'\u018a\5\'\u018d\n\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3,\3-"+
		"\3-\3.\3.\3/\3/\3\60\6\60\u01a1\n\60\r\60\16\60\u01a2\3\60\3\60\2\2\61"+
		"\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20"+
		"\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37"+
		"= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[\2]\2_/\3\2\b\3\2//\b\2\13\f\16\17\""+
		"(*.\60]_\u0080\b\2\13\f\16\17\"#%.\60]_\u0080\5\2\62;C\\c|\3\2\62;\5\2"+
		"\13\f\16\17\"\"\2\u01ac\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2"+
		"\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3"+
		"\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2"+
		"\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2"+
		"Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2_\3\2\2\2\3a\3"+
		"\2\2\2\5e\3\2\2\2\7g\3\2\2\2\ti\3\2\2\2\13k\3\2\2\2\rm\3\2\2\2\17o\3\2"+
		"\2\2\21u\3\2\2\2\23}\3\2\2\2\25\u0084\3\2\2\2\27\u0089\3\2\2\2\31\u008e"+
		"\3\2\2\2\33\u0098\3\2\2\2\35\u00a0\3\2\2\2\37\u00a9\3\2\2\2!\u00b7\3\2"+
		"\2\2#\u00c6\3\2\2\2%\u00ce\3\2\2\2\'\u00d8\3\2\2\2)\u00e1\3\2\2\2+\u00e3"+
		"\3\2\2\2-\u00eb\3\2\2\2/\u00f1\3\2\2\2\61\u00f6\3\2\2\2\63\u0102\3\2\2"+
		"\2\65\u0112\3\2\2\2\67\u0117\3\2\2\29\u011f\3\2\2\2;\u0128\3\2\2\2=\u0132"+
		"\3\2\2\2?\u013c\3\2\2\2A\u014b\3\2\2\2C\u015f\3\2\2\2E\u0162\3\2\2\2G"+
		"\u016b\3\2\2\2I\u0175\3\2\2\2K\u017a\3\2\2\2M\u017f\3\2\2\2O\u018e\3\2"+
		"\2\2Q\u0190\3\2\2\2S\u0192\3\2\2\2U\u0194\3\2\2\2W\u0196\3\2\2\2Y\u0199"+
		"\3\2\2\2[\u019b\3\2\2\2]\u019d\3\2\2\2_\u01a0\3\2\2\2ab\5O(\2bc\5I%\2"+
		"cd\5Q)\2d\4\3\2\2\2ef\7}\2\2f\6\3\2\2\2gh\7\177\2\2h\b\3\2\2\2ij\7]\2"+
		"\2j\n\3\2\2\2kl\7_\2\2l\f\3\2\2\2mn\7%\2\2n\16\3\2\2\2op\7u\2\2pq\7v\2"+
		"\2qr\7c\2\2rs\7t\2\2st\7v\2\2t\20\3\2\2\2uv\7o\2\2vw\7g\2\2wx\7u\2\2x"+
		"y\7u\2\2yz\7c\2\2z{\7i\2\2{|\7g\2\2|\22\3\2\2\2}~\7c\2\2~\177\7e\2\2\177"+
		"\u0080\7v\2\2\u0080\u0081\7k\2\2\u0081\u0082\7q\2\2\u0082\u0083\7p\2\2"+
		"\u0083\24\3\2\2\2\u0084\u0085\7t\2\2\u0085\u0086\7q\2\2\u0086\u0087\7"+
		"q\2\2\u0087\u0088\7o\2\2\u0088\26\3\2\2\2\u0089\u008a\7k\2\2\u008a\u008b"+
		"\7v\2\2\u008b\u008c\7g\2\2\u008c\u008d\7o\2\2\u008d\30\3\2\2\2\u008e\u008f"+
		"\7m\2\2\u008f\u0090\7p\2\2\u0090\u0091\7q\2\2\u0091\u0092\7y\2\2\u0092"+
		"\u0093\7n\2\2\u0093\u0094\7g\2\2\u0094\u0095\7f\2\2\u0095\u0096\7i\2\2"+
		"\u0096\u0097\7g\2\2\u0097\32\3\2\2\2\u0098\u0099\7r\2\2\u0099\u009a\7"+
		"t\2\2\u009a\u009b\7g\2\2\u009b\u009c\7e\2\2\u009c\u009d\7q\2\2\u009d\u009e"+
		"\7p\2\2\u009e\u009f\7f\2\2\u009f\34\3\2\2\2\u00a0\u00a1\7r\2\2\u00a1\u00a2"+
		"\7q\2\2\u00a2\u00a3\7u\2\2\u00a3\u00a4\7v\2\2\u00a4\u00a5\7e\2\2\u00a5"+
		"\u00a6\7q\2\2\u00a6\u00a7\7p\2\2\u00a7\u00a8\7f\2\2\u00a8\36\3\2\2\2\u00a9"+
		"\u00aa\7i\2\2\u00aa\u00ab\7g\2\2\u00ab\u00ac\7p\2\2\u00ac\u00ad\7g\2\2"+
		"\u00ad\u00ae\7t\2\2\u00ae\u00af\7k\2\2\u00af\u00b0\7e\2\2\u00b0\u00b1"+
		"\7a\2\2\u00b1\u00b2\7h\2\2\u00b2\u00b3\7t\2\2\u00b3\u00b4\7c\2\2\u00b4"+
		"\u00b5\7o\2\2\u00b5\u00b6\7g\2\2\u00b6 \3\2\2\2\u00b7\u00b8\7e\2\2\u00b8"+
		"\u00b9\7w\2\2\u00b9\u00ba\7u\2\2\u00ba\u00bb\7v\2\2\u00bb\u00bc\7q\2\2"+
		"\u00bc\u00bd\7o\2\2\u00bd\u00be\7a\2\2\u00be\u00bf\7v\2\2\u00bf\u00c0"+
		"\7t\2\2\u00c0\u00c1\7k\2\2\u00c1\u00c2\7i\2\2\u00c2\u00c3\7i\2\2\u00c3"+
		"\u00c4\7g\2\2\u00c4\u00c5\7t\2\2\u00c5\"\3\2\2\2\u00c6\u00c7\7k\2\2\u00c7"+
		"\u00c8\7p\2\2\u00c8\u00c9\7k\2\2\u00c9\u00ca\7v\2\2\u00ca\u00cb\7k\2\2"+
		"\u00cb\u00cc\7c\2\2\u00cc\u00cd\7n\2\2\u00cd$\3\2\2\2\u00ce\u00cf\7r\2"+
		"\2\u00cf\u00d0\7q\2\2\u00d0\u00d1\7u\2\2\u00d1\u00d2\7v\2\2\u00d2\u00d3"+
		"\7e\2\2\u00d3\u00d4\7q\2\2\u00d4\u00d5\7p\2\2\u00d5\u00d6\7f\2\2\u00d6"+
		"\u00d7\7u\2\2\u00d7&\3\2\2\2\u00d8\u00d9\7r\2\2\u00d9\u00da\7t\2\2\u00da"+
		"\u00db\7g\2\2\u00db\u00dc\7e\2\2\u00dc\u00dd\7q\2\2\u00dd\u00de\7p\2\2"+
		"\u00de\u00df\7f\2\2\u00df\u00e0\7u\2\2\u00e0(\3\2\2\2\u00e1\u00e2\7.\2"+
		"\2\u00e2*\3\2\2\2\u00e3\u00e4\7c\2\2\u00e4\u00e5\7e\2\2\u00e5\u00e6\7"+
		"v\2\2\u00e6\u00e7\7k\2\2\u00e7\u00e8\7q\2\2\u00e8\u00e9\7p\2\2\u00e9\u00ea"+
		"\7u\2\2\u00ea,\3\2\2\2\u00eb\u00ec\7k\2\2\u00ec\u00ed\7v\2\2\u00ed\u00ee"+
		"\7g\2\2\u00ee\u00ef\7o\2\2\u00ef\u00f0\7u\2\2\u00f0.\3\2\2\2\u00f1\u00f2"+
		"\7p\2\2\u00f2\u00f3\7c\2\2\u00f3\u00f4\7o\2\2\u00f4\u00f5\7g\2\2\u00f5"+
		"\60\3\2\2\2\u00f6\u00f7\7u\2\2\u00f7\u00f8\7w\2\2\u00f8\u00f9\7e\2\2\u00f9"+
		"\u00fa\7e\2\2\u00fa\u00fb\7g\2\2\u00fb\u00fc\7u\2\2\u00fc\u00fd\7u\2\2"+
		"\u00fd\u00fe\7a\2\2\u00fe\u00ff\7o\2\2\u00ff\u0100\7u\2\2\u0100\u0101"+
		"\7i\2\2\u0101\62\3\2\2\2\u0102\u0103\7c\2\2\u0103\u0104\7e\2\2\u0104\u0105"+
		"\7v\2\2\u0105\u0106\7k\2\2\u0106\u0107\7q\2\2\u0107\u0108\7p\2\2\u0108"+
		"\u0109\7a\2\2\u0109\u010a\7v\2\2\u010a\u010b\7t\2\2\u010b\u010c\7k\2\2"+
		"\u010c\u010d\7i\2\2\u010d\u010e\7i\2\2\u010e\u010f\7g\2\2\u010f\u0110"+
		"\7t\2\2\u0110\u0111\7u\2\2\u0111\64\3\2\2\2\u0112\u0113\7c\2\2\u0113\u0114"+
		"\7t\2\2\u0114\u0115\7i\2\2\u0115\u0116\7u\2\2\u0116\66\3\2\2\2\u0117\u0118"+
		"\7r\2\2\u0118\u0119\7c\2\2\u0119\u011a\7t\2\2\u011a\u011b\7g\2\2\u011b"+
		"\u011c\7p\2\2\u011c\u011d\7v\2\2\u011d\u011e\7u\2\2\u011e8\3\2\2\2\u011f"+
		"\u0120\7k\2\2\u0120\u0121\7p\2\2\u0121\u0122\7j\2\2\u0122\u0123\7g\2\2"+
		"\u0123\u0124\7t\2\2\u0124\u0125\7k\2\2\u0125\u0126\7v\2\2\u0126\u0127"+
		"\7u\2\2\u0127:\3\2\2\2\u0128\u0129\7t\2\2\u0129\u012a\7q\2\2\u012a\u012b"+
		"\7q\2\2\u012b\u012c\7o\2\2\u012c\u012d\7a\2\2\u012d\u012e\7p\2\2\u012e"+
		"\u012f\7c\2\2\u012f\u0130\7o\2\2\u0130\u0131\7g\2\2\u0131<\3\2\2\2\u0132"+
		"\u0133\7k\2\2\u0133\u0134\7v\2\2\u0134\u0135\7g\2\2\u0135\u0136\7o\2\2"+
		"\u0136\u0137\7a\2\2\u0137\u0138\7p\2\2\u0138\u0139\7c\2\2\u0139\u013a"+
		"\7o\2\2\u013a\u013b\7g\2\2\u013b>\3\2\2\2\u013c\u013d\7k\2\2\u013d\u013e"+
		"\7v\2\2\u013e\u013f\7g\2\2\u013f\u0140\7o\2\2\u0140\u0141\7a\2\2\u0141"+
		"\u0142\7m\2\2\u0142\u0143\7p\2\2\u0143\u0144\7q\2\2\u0144\u0145\7y\2\2"+
		"\u0145\u0146\7n\2\2\u0146\u0147\7g\2\2\u0147\u0148\7f\2\2\u0148\u0149"+
		"\7i\2\2\u0149\u014a\7g\2\2\u014a@\3\2\2\2\u014b\u014c\7i\2\2\u014c\u014d"+
		"\7g\2\2\u014d\u014e\7p\2\2\u014e\u014f\7g\2\2\u014f\u0150\7t\2\2\u0150"+
		"\u0151\7k\2\2\u0151\u0152\7e\2\2\u0152\u0153\7a\2\2\u0153\u0154\7k\2\2"+
		"\u0154\u0155\7p\2\2\u0155\u0156\7j\2\2\u0156\u0157\7g\2\2\u0157\u0158"+
		"\7t\2\2\u0158\u0159\7k\2\2\u0159\u015a\7v\2\2\u015a\u015b\7c\2\2\u015b"+
		"\u015c\7p\2\2\u015c\u015d\7e\2\2\u015d\u015e\7g\2\2\u015eB\3\2\2\2\u015f"+
		"\u0160\t\2\2\2\u0160\u0161\5K&\2\u0161D\3\2\2\2\u0162\u0166\5]/\2\u0163"+
		"\u0165\t\3\2\2\u0164\u0163\3\2\2\2\u0165\u0168\3\2\2\2\u0166\u0164\3\2"+
		"\2\2\u0166\u0167\3\2\2\2\u0167\u0169\3\2\2\2\u0168\u0166\3\2\2\2\u0169"+
		"\u016a\5]/\2\u016aF\3\2\2\2\u016b\u016f\5[.\2\u016c\u016e\t\4\2\2\u016d"+
		"\u016c\3\2\2\2\u016e\u0171\3\2\2\2\u016f\u016d\3\2\2\2\u016f\u0170\3\2"+
		"\2\2\u0170\u0172\3\2\2\2\u0171\u016f\3\2\2\2\u0172\u0173\5[.\2\u0173H"+
		"\3\2\2\2\u0174\u0176\t\5\2\2\u0175\u0174\3\2\2\2\u0176\u0177\3\2\2\2\u0177"+
		"\u0175\3\2\2\2\u0177\u0178\3\2\2\2\u0178J\3\2\2\2\u0179\u017b\t\6\2\2"+
		"\u017a\u0179\3\2\2\2\u017b\u017c\3\2\2\2\u017c\u017a\3\2\2\2\u017c\u017d"+
		"\3\2\2\2\u017dL\3\2\2\2\u017e\u0180\7/\2\2\u017f\u017e\3\2\2\2\u017f\u0180"+
		"\3\2\2\2\u0180\u0182\3\2\2\2\u0181\u0183\t\6\2\2\u0182\u0181\3\2\2\2\u0183"+
		"\u0184\3\2\2\2\u0184\u0182\3\2\2\2\u0184\u0185\3\2\2\2\u0185\u018c\3\2"+
		"\2\2\u0186\u0188\7\60\2\2\u0187\u0189\t\6\2\2\u0188\u0187\3\2\2\2\u0189"+
		"\u018a\3\2\2\2\u018a\u0188\3\2\2\2\u018a\u018b\3\2\2\2\u018b\u018d\3\2"+
		"\2\2\u018c\u0186\3\2\2\2\u018c\u018d\3\2\2\2\u018dN\3\2\2\2\u018e\u018f"+
		"\7*\2\2\u018fP\3\2\2\2\u0190\u0191\7+\2\2\u0191R\3\2\2\2\u0192\u0193\7"+
		"=\2\2\u0193T\3\2\2\2\u0194\u0195\7\60\2\2\u0195V\3\2\2\2\u0196\u0197\7"+
		">\2\2\u0197\u0198\7/\2\2\u0198X\3\2\2\2\u0199\u019a\7/\2\2\u019aZ\3\2"+
		"\2\2\u019b\u019c\7$\2\2\u019c\\\3\2\2\2\u019d\u019e\7)\2\2\u019e^\3\2"+
		"\2\2\u019f\u01a1\t\7\2\2\u01a0\u019f\3\2\2\2\u01a1\u01a2\3\2\2\2\u01a2"+
		"\u01a0\3\2\2\2\u01a2\u01a3\3\2\2\2\u01a3\u01a4\3\2\2\2\u01a4\u01a5\b\60"+
		"\2\2\u01a5`\3\2\2\2\f\2\u0166\u016f\u0177\u017c\u017f\u0184\u018a\u018c"+
		"\u01a2\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}