// Generated from /Users/noahohrner/OneDrive - University of Cambridge/Dissertation/Code/interactive-fiction/SimpleBoolean.g4 by ANTLR 4.9
package com.enhanced.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SimpleBooleanLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		IN=1, AND=2, OR=3, NOT=4, TRUE=5, FALSE=6, GT=7, GE=8, LT=9, LE=10, EQ=11, 
		LPAREN=12, RPAREN=13, QUOTE=14, STRING=15, DECIMAL=16, IDENTIFIER=17, 
		BEGL=18, ENDL=19, SEP=20, WS=21;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"IN", "AND", "OR", "NOT", "TRUE", "FALSE", "GT", "GE", "LT", "LE", "EQ", 
			"LPAREN", "RPAREN", "QUOTE", "STRING", "DECIMAL", "IDENTIFIER", "BEGL", 
			"ENDL", "SEP", "WS"
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


	public SimpleBooleanLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SimpleBoolean.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\27\u008d\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\2\3\3\3\3\3\3"+
		"\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16"+
		"\3\16\3\17\3\17\3\20\3\20\7\20[\n\20\f\20\16\20^\13\20\3\20\3\20\3\21"+
		"\5\21c\n\21\3\21\6\21f\n\21\r\21\16\21g\3\21\3\21\6\21l\n\21\r\21\16\21"+
		"m\5\21p\n\21\3\22\5\22s\n\22\3\22\6\22v\n\22\r\22\16\22w\3\22\3\22\3\22"+
		"\6\22}\n\22\r\22\16\22~\3\23\3\23\3\24\3\24\3\25\3\25\3\26\6\26\u0088"+
		"\n\26\r\26\16\26\u0089\3\26\3\26\2\2\27\3\3\5\4\7\5\t\6\13\7\r\b\17\t"+
		"\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27"+
		"\3\2\n\3\2$$\7\2\13\f\16\17\"#%]_\u0080\3\2\62;\3\2aa\6\2//\62;C\\c|\3"+
		"\2<<\5\2\62;C\\c|\5\2\13\f\16\17\"\"\2\u0095\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2"+
		"\2\2)\3\2\2\2\2+\3\2\2\2\3-\3\2\2\2\5\60\3\2\2\2\7\64\3\2\2\2\t\67\3\2"+
		"\2\2\13;\3\2\2\2\r@\3\2\2\2\17F\3\2\2\2\21H\3\2\2\2\23K\3\2\2\2\25M\3"+
		"\2\2\2\27P\3\2\2\2\31R\3\2\2\2\33T\3\2\2\2\35V\3\2\2\2\37X\3\2\2\2!b\3"+
		"\2\2\2#r\3\2\2\2%\u0080\3\2\2\2\'\u0082\3\2\2\2)\u0084\3\2\2\2+\u0087"+
		"\3\2\2\2-.\7K\2\2./\7P\2\2/\4\3\2\2\2\60\61\7C\2\2\61\62\7P\2\2\62\63"+
		"\7F\2\2\63\6\3\2\2\2\64\65\7Q\2\2\65\66\7T\2\2\66\b\3\2\2\2\678\7P\2\2"+
		"89\7Q\2\29:\7V\2\2:\n\3\2\2\2;<\7V\2\2<=\7T\2\2=>\7W\2\2>?\7G\2\2?\f\3"+
		"\2\2\2@A\7H\2\2AB\7C\2\2BC\7N\2\2CD\7U\2\2DE\7G\2\2E\16\3\2\2\2FG\7@\2"+
		"\2G\20\3\2\2\2HI\7@\2\2IJ\7?\2\2J\22\3\2\2\2KL\7>\2\2L\24\3\2\2\2MN\7"+
		">\2\2NO\7?\2\2O\26\3\2\2\2PQ\7?\2\2Q\30\3\2\2\2RS\7*\2\2S\32\3\2\2\2T"+
		"U\7+\2\2U\34\3\2\2\2VW\7$\2\2W\36\3\2\2\2X\\\t\2\2\2Y[\t\3\2\2ZY\3\2\2"+
		"\2[^\3\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]_\3\2\2\2^\\\3\2\2\2_`\t\2\2\2` \3"+
		"\2\2\2ac\7/\2\2ba\3\2\2\2bc\3\2\2\2ce\3\2\2\2df\t\4\2\2ed\3\2\2\2fg\3"+
		"\2\2\2ge\3\2\2\2gh\3\2\2\2ho\3\2\2\2ik\7\60\2\2jl\t\4\2\2kj\3\2\2\2lm"+
		"\3\2\2\2mk\3\2\2\2mn\3\2\2\2np\3\2\2\2oi\3\2\2\2op\3\2\2\2p\"\3\2\2\2"+
		"qs\t\5\2\2rq\3\2\2\2rs\3\2\2\2su\3\2\2\2tv\t\6\2\2ut\3\2\2\2vw\3\2\2\2"+
		"wu\3\2\2\2wx\3\2\2\2xy\3\2\2\2yz\t\7\2\2z|\t\7\2\2{}\t\b\2\2|{\3\2\2\2"+
		"}~\3\2\2\2~|\3\2\2\2~\177\3\2\2\2\177$\3\2\2\2\u0080\u0081\7]\2\2\u0081"+
		"&\3\2\2\2\u0082\u0083\7_\2\2\u0083(\3\2\2\2\u0084\u0085\7.\2\2\u0085*"+
		"\3\2\2\2\u0086\u0088\t\t\2\2\u0087\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089"+
		"\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008c\b\26"+
		"\2\2\u008c,\3\2\2\2\f\2\\bgmorw~\u0089\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}