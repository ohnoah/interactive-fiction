// Generated from /Users/noahohrner/OneDrive - University of Cambridge/Dissertation/Code/interactive-fiction/Boolean.g4 by ANTLR 4.9.1
package com.intfic.game.enhanced.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BooleanLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		IS=1, IN=2, AND=3, OR=4, NOT=5, TRUE=6, FALSE=7, LT=8, LE=9, EQ=10, GT=11, 
		GE=12, LPAREN=13, RPAREN=14, QUOTE=15, SLASH=16, STRING=17, DECIMAL=18, 
		IDENTIFIER=19, BEGL=20, ENDL=21, SEP=22, WS=23;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"IS", "IN", "AND", "OR", "NOT", "TRUE", "FALSE", "LT", "LE", "EQ", "GT", 
			"GE", "LPAREN", "RPAREN", "QUOTE", "SLASH", "STRING", "DECIMAL", "IDENTIFIER", 
			"BEGL", "ENDL", "SEP", "WS"
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


	public BooleanLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Boolean.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\31\u0096\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2"+
		"\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3"+
		"\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3"+
		"\f\3\f\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\7"+
		"\22d\n\22\f\22\16\22g\13\22\3\22\3\22\3\23\5\23l\n\23\3\23\6\23o\n\23"+
		"\r\23\16\23p\3\23\3\23\6\23u\n\23\r\23\16\23v\5\23y\n\23\3\24\5\24|\n"+
		"\24\3\24\6\24\177\n\24\r\24\16\24\u0080\3\24\3\24\3\24\6\24\u0086\n\24"+
		"\r\24\16\24\u0087\3\25\3\25\3\26\3\26\3\27\3\27\3\30\6\30\u0091\n\30\r"+
		"\30\16\30\u0092\3\30\3\30\2\2\31\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
		"\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31"+
		"\3\2\n\3\2$$\7\2\13\f\16\17\"#%]_\u0080\3\2\62;\3\2##\7\2\60\60\62;C\\"+
		"aac|\3\2<<\5\2\62;C\\c|\5\2\13\f\16\17\"\"\2\u009e\2\3\3\2\2\2\2\5\3\2"+
		"\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\3\61\3\2\2\2\5\64\3"+
		"\2\2\2\7\67\3\2\2\2\t;\3\2\2\2\13>\3\2\2\2\rB\3\2\2\2\17G\3\2\2\2\21M"+
		"\3\2\2\2\23O\3\2\2\2\25R\3\2\2\2\27T\3\2\2\2\31V\3\2\2\2\33Y\3\2\2\2\35"+
		"[\3\2\2\2\37]\3\2\2\2!_\3\2\2\2#a\3\2\2\2%k\3\2\2\2\'{\3\2\2\2)\u0089"+
		"\3\2\2\2+\u008b\3\2\2\2-\u008d\3\2\2\2/\u0090\3\2\2\2\61\62\7K\2\2\62"+
		"\63\7U\2\2\63\4\3\2\2\2\64\65\7K\2\2\65\66\7P\2\2\66\6\3\2\2\2\678\7C"+
		"\2\289\7P\2\29:\7F\2\2:\b\3\2\2\2;<\7Q\2\2<=\7T\2\2=\n\3\2\2\2>?\7P\2"+
		"\2?@\7Q\2\2@A\7V\2\2A\f\3\2\2\2BC\7V\2\2CD\7T\2\2DE\7W\2\2EF\7G\2\2F\16"+
		"\3\2\2\2GH\7H\2\2HI\7C\2\2IJ\7N\2\2JK\7U\2\2KL\7G\2\2L\20\3\2\2\2MN\7"+
		">\2\2N\22\3\2\2\2OP\7>\2\2PQ\7?\2\2Q\24\3\2\2\2RS\7?\2\2S\26\3\2\2\2T"+
		"U\7@\2\2U\30\3\2\2\2VW\7@\2\2WX\7?\2\2X\32\3\2\2\2YZ\7*\2\2Z\34\3\2\2"+
		"\2[\\\7+\2\2\\\36\3\2\2\2]^\7$\2\2^ \3\2\2\2_`\7\61\2\2`\"\3\2\2\2ae\t"+
		"\2\2\2bd\t\3\2\2cb\3\2\2\2dg\3\2\2\2ec\3\2\2\2ef\3\2\2\2fh\3\2\2\2ge\3"+
		"\2\2\2hi\t\2\2\2i$\3\2\2\2jl\7/\2\2kj\3\2\2\2kl\3\2\2\2ln\3\2\2\2mo\t"+
		"\4\2\2nm\3\2\2\2op\3\2\2\2pn\3\2\2\2pq\3\2\2\2qx\3\2\2\2rt\7\60\2\2su"+
		"\t\4\2\2ts\3\2\2\2uv\3\2\2\2vt\3\2\2\2vw\3\2\2\2wy\3\2\2\2xr\3\2\2\2x"+
		"y\3\2\2\2y&\3\2\2\2z|\t\5\2\2{z\3\2\2\2{|\3\2\2\2|~\3\2\2\2}\177\t\6\2"+
		"\2~}\3\2\2\2\177\u0080\3\2\2\2\u0080~\3\2\2\2\u0080\u0081\3\2\2\2\u0081"+
		"\u0082\3\2\2\2\u0082\u0083\t\7\2\2\u0083\u0085\t\7\2\2\u0084\u0086\t\b"+
		"\2\2\u0085\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0085\3\2\2\2\u0087"+
		"\u0088\3\2\2\2\u0088(\3\2\2\2\u0089\u008a\7]\2\2\u008a*\3\2\2\2\u008b"+
		"\u008c\7_\2\2\u008c,\3\2\2\2\u008d\u008e\7.\2\2\u008e.\3\2\2\2\u008f\u0091"+
		"\t\t\2\2\u0090\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0090\3\2\2\2\u0092"+
		"\u0093\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0095\b\30\2\2\u0095\60\3\2\2"+
		"\2\f\2ekpvx{\u0080\u0087\u0092\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}