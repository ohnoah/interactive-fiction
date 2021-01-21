// Generated from /Users/noahohrner/OneDrive - University of Cambridge/Dissertation/Code/interactive-fiction/SimpleBoolean.g4 by ANTLR 4.9
package com.intfic.game.enhanced.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SimpleBooleanLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		IS=1, IN=2, AND=3, OR=4, NOT=5, TRUE=6, FALSE=7, GT=8, GE=9, LT=10, LE=11, 
		EQ=12, LPAREN=13, RPAREN=14, QUOTE=15, STRING=16, DECIMAL=17, IDENTIFIER=18, 
		BEGL=19, ENDL=20, SEP=21, WS=22;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"IS", "IN", "AND", "OR", "NOT", "TRUE", "FALSE", "GT", "GE", "LT", "LE", 
			"EQ", "LPAREN", "RPAREN", "QUOTE", "STRING", "DECIMAL", "IDENTIFIER", 
			"BEGL", "ENDL", "SEP", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'IS'", "'IN'", "'AND'", "'OR'", "'NOT'", "'TRUE'", "'FALSE'", 
			"'>'", "'>='", "'<'", "'<='", "'='", "'('", "')'", "'\"'", null, null, 
			null, "'['", "']'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "IS", "IN", "AND", "OR", "NOT", "TRUE", "FALSE", "GT", "GE", "LT", 
			"LE", "EQ", "LPAREN", "RPAREN", "QUOTE", "STRING", "DECIMAL", "IDENTIFIER", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\30\u0092\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\2\3"+
		"\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7"+
		"\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\f"+
		"\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\7\21`\n\21\f\21\16\21"+
		"c\13\21\3\21\3\21\3\22\5\22h\n\22\3\22\6\22k\n\22\r\22\16\22l\3\22\3\22"+
		"\6\22q\n\22\r\22\16\22r\5\22u\n\22\3\23\5\23x\n\23\3\23\6\23{\n\23\r\23"+
		"\16\23|\3\23\3\23\3\23\6\23\u0082\n\23\r\23\16\23\u0083\3\24\3\24\3\25"+
		"\3\25\3\26\3\26\3\27\6\27\u008d\n\27\r\27\16\27\u008e\3\27\3\27\2\2\30"+
		"\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20"+
		"\37\21!\22#\23%\24\'\25)\26+\27-\30\3\2\n\3\2$$\7\2\13\f\16\17\"#%]_\u0080"+
		"\3\2\62;\3\2aa\6\2//\62;C\\c|\3\2<<\5\2\62;C\\c|\5\2\13\f\16\17\"\"\2"+
		"\u009a\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2"+
		"\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\3"+
		"/\3\2\2\2\5\62\3\2\2\2\7\65\3\2\2\2\t9\3\2\2\2\13<\3\2\2\2\r@\3\2\2\2"+
		"\17E\3\2\2\2\21K\3\2\2\2\23M\3\2\2\2\25P\3\2\2\2\27R\3\2\2\2\31U\3\2\2"+
		"\2\33W\3\2\2\2\35Y\3\2\2\2\37[\3\2\2\2!]\3\2\2\2#g\3\2\2\2%w\3\2\2\2\'"+
		"\u0085\3\2\2\2)\u0087\3\2\2\2+\u0089\3\2\2\2-\u008c\3\2\2\2/\60\7K\2\2"+
		"\60\61\7U\2\2\61\4\3\2\2\2\62\63\7K\2\2\63\64\7P\2\2\64\6\3\2\2\2\65\66"+
		"\7C\2\2\66\67\7P\2\2\678\7F\2\28\b\3\2\2\29:\7Q\2\2:;\7T\2\2;\n\3\2\2"+
		"\2<=\7P\2\2=>\7Q\2\2>?\7V\2\2?\f\3\2\2\2@A\7V\2\2AB\7T\2\2BC\7W\2\2CD"+
		"\7G\2\2D\16\3\2\2\2EF\7H\2\2FG\7C\2\2GH\7N\2\2HI\7U\2\2IJ\7G\2\2J\20\3"+
		"\2\2\2KL\7@\2\2L\22\3\2\2\2MN\7@\2\2NO\7?\2\2O\24\3\2\2\2PQ\7>\2\2Q\26"+
		"\3\2\2\2RS\7>\2\2ST\7?\2\2T\30\3\2\2\2UV\7?\2\2V\32\3\2\2\2WX\7*\2\2X"+
		"\34\3\2\2\2YZ\7+\2\2Z\36\3\2\2\2[\\\7$\2\2\\ \3\2\2\2]a\t\2\2\2^`\t\3"+
		"\2\2_^\3\2\2\2`c\3\2\2\2a_\3\2\2\2ab\3\2\2\2bd\3\2\2\2ca\3\2\2\2de\t\2"+
		"\2\2e\"\3\2\2\2fh\7/\2\2gf\3\2\2\2gh\3\2\2\2hj\3\2\2\2ik\t\4\2\2ji\3\2"+
		"\2\2kl\3\2\2\2lj\3\2\2\2lm\3\2\2\2mt\3\2\2\2np\7\60\2\2oq\t\4\2\2po\3"+
		"\2\2\2qr\3\2\2\2rp\3\2\2\2rs\3\2\2\2su\3\2\2\2tn\3\2\2\2tu\3\2\2\2u$\3"+
		"\2\2\2vx\t\5\2\2wv\3\2\2\2wx\3\2\2\2xz\3\2\2\2y{\t\6\2\2zy\3\2\2\2{|\3"+
		"\2\2\2|z\3\2\2\2|}\3\2\2\2}~\3\2\2\2~\177\t\7\2\2\177\u0081\t\7\2\2\u0080"+
		"\u0082\t\b\2\2\u0081\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0081\3\2"+
		"\2\2\u0083\u0084\3\2\2\2\u0084&\3\2\2\2\u0085\u0086\7]\2\2\u0086(\3\2"+
		"\2\2\u0087\u0088\7_\2\2\u0088*\3\2\2\2\u0089\u008a\7.\2\2\u008a,\3\2\2"+
		"\2\u008b\u008d\t\t\2\2\u008c\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u008c"+
		"\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0091\b\27\2\2"+
		"\u0091.\3\2\2\2\f\2aglrtw|\u0083\u008e\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}