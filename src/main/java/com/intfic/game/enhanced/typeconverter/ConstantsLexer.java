// Generated from /Users/noahohrner/OneDrive - University of Cambridge/Dissertation/Code/interactive-fiction/Constants.g4 by ANTLR 4.9.1
package com.intfic.game.enhanced.typeconverter;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ConstantsLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TRUE=1, FALSE=2, QUOTE=3, STRING=4, DECIMAL=5, BEGL=6, ENDL=7, SEP=8, 
		WS=9;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"TRUE", "FALSE", "QUOTE", "STRING", "DECIMAL", "BEGL", "ENDL", "SEP", 
			"WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'\"'", null, null, "'['", "']'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "TRUE", "FALSE", "QUOTE", "STRING", "DECIMAL", "BEGL", "ENDL", 
			"SEP", "WS"
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


	public ConstantsLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Constants.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\13S\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\5\2\36\n\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\5\3*\n\3\3\4\3\4\3\5\3\5\7\5\60\n\5\f\5\16\5\63\13\5\3\5\3\5\3"+
		"\6\5\68\n\6\3\6\6\6;\n\6\r\6\16\6<\3\6\3\6\6\6A\n\6\r\6\16\6B\5\6E\n\6"+
		"\3\7\3\7\3\b\3\b\3\t\3\t\3\n\6\nN\n\n\r\n\16\nO\3\n\3\n\2\2\13\3\3\5\4"+
		"\7\5\t\6\13\7\r\b\17\t\21\n\23\13\3\2\6\3\2$$\7\2\13\f\16\17\"#%]_\u0080"+
		"\3\2\62;\5\2\13\f\16\17\"\"\2Z\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t"+
		"\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2"+
		"\2\3\35\3\2\2\2\5)\3\2\2\2\7+\3\2\2\2\t-\3\2\2\2\13\67\3\2\2\2\rF\3\2"+
		"\2\2\17H\3\2\2\2\21J\3\2\2\2\23M\3\2\2\2\25\26\7V\2\2\26\27\7T\2\2\27"+
		"\30\7W\2\2\30\36\7G\2\2\31\32\7v\2\2\32\33\7t\2\2\33\34\7w\2\2\34\36\7"+
		"g\2\2\35\25\3\2\2\2\35\31\3\2\2\2\36\4\3\2\2\2\37 \7H\2\2 !\7C\2\2!\""+
		"\7N\2\2\"#\7U\2\2#*\7G\2\2$%\7h\2\2%&\7c\2\2&\'\7n\2\2\'(\7u\2\2(*\7g"+
		"\2\2)\37\3\2\2\2)$\3\2\2\2*\6\3\2\2\2+,\7$\2\2,\b\3\2\2\2-\61\t\2\2\2"+
		".\60\t\3\2\2/.\3\2\2\2\60\63\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\64\3"+
		"\2\2\2\63\61\3\2\2\2\64\65\t\2\2\2\65\n\3\2\2\2\668\7/\2\2\67\66\3\2\2"+
		"\2\678\3\2\2\28:\3\2\2\29;\t\4\2\2:9\3\2\2\2;<\3\2\2\2<:\3\2\2\2<=\3\2"+
		"\2\2=D\3\2\2\2>@\7\60\2\2?A\t\4\2\2@?\3\2\2\2AB\3\2\2\2B@\3\2\2\2BC\3"+
		"\2\2\2CE\3\2\2\2D>\3\2\2\2DE\3\2\2\2E\f\3\2\2\2FG\7]\2\2G\16\3\2\2\2H"+
		"I\7_\2\2I\20\3\2\2\2JK\7.\2\2K\22\3\2\2\2LN\t\5\2\2ML\3\2\2\2NO\3\2\2"+
		"\2OM\3\2\2\2OP\3\2\2\2PQ\3\2\2\2QR\b\n\2\2R\24\3\2\2\2\13\2\35)\61\67"+
		"<BDO\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}