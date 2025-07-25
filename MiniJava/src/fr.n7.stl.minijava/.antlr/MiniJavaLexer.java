// Generated from /home/gutierrez/projetjava/miniJava/MiniJava/src/fr.n7.stl.minijava/MiniJavaLexer.g4 by ANTLR 4.13.1

package fr.n7.stl.minijava.parser;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class MiniJavaLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Egal=1, AccoladeOuvrante=2, AccoladeFermante=3, ParentheseOuvrante=4, 
		ParentheseFermante=5, CrochetOuvrant=6, CrochetFermant=7, Point=8, PointInterrogation=9, 
		DeuxPoint=10, Virgule=11, PointVirgule=12, Afficher=13, Si=14, Sinon=15, 
		Retour=16, TantQue=17, Nouveau=18, Classe=19, Herite=20, Public=21, Prive=22, 
		DeClasse=23, Definitif=24, Moi=25, Super=26, MethodePrincipale=27, Abstrait=28, 
		Protege=29, Asterisque=30, Oblique=31, PourCent=32, Plus=33, Moins=34, 
		DoubleBarre=35, DoubleEsperluette=36, PointExclamation=37, Inferieur=38, 
		Superieur=39, InferieurEgal=40, SuperieurEgal=41, DoubleEgal=42, ExclamationEgal=43, 
		Esperluette=44, TypeEntier=45, TypeFlottant=46, TypeBooleen=47, TypeCaractere=48, 
		TypeChaine=49, TypeVide=50, Vrai=51, Faux=52, Nul=53, Caractere=54, Chaine=55, 
		Underscore=56, Identificateur=57, Entier=58, Flottant=59, CommentaireLigne=60, 
		CommentaireBloc=61, WS=62;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"Egal", "AccoladeOuvrante", "AccoladeFermante", "ParentheseOuvrante", 
			"ParentheseFermante", "CrochetOuvrant", "CrochetFermant", "Point", "PointInterrogation", 
			"DeuxPoint", "Virgule", "PointVirgule", "Afficher", "Si", "Sinon", "Retour", 
			"TantQue", "Nouveau", "Classe", "Herite", "Public", "Prive", "DeClasse", 
			"Definitif", "Moi", "Super", "MethodePrincipale", "Abstrait", "Protege", 
			"Asterisque", "Oblique", "PourCent", "Plus", "Moins", "DoubleBarre", 
			"DoubleEsperluette", "PointExclamation", "Inferieur", "Superieur", "InferieurEgal", 
			"SuperieurEgal", "DoubleEgal", "ExclamationEgal", "Esperluette", "TypeEntier", 
			"TypeFlottant", "TypeBooleen", "TypeCaractere", "TypeChaine", "TypeVide", 
			"Vrai", "Faux", "Nul", "Caractere", "Chaine", "Underscore", "Identificateur", 
			"Entier", "Flottant", "CommentaireLigne", "CommentaireBloc", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'{'", "'}'", "'('", "')'", "'['", "']'", "'.'", "'?'", 
			"':'", "','", "';'", "'print'", "'if'", "'else'", "'return'", "'while'", 
			"'new'", "'class'", "'extends'", "'public'", "'private'", "'static'", 
			"'final'", "'this'", "'super'", "'main'", "'abstract'", "'protected'", 
			"'*'", "'/'", "'%'", "'+'", "'-'", "'||'", "'&&'", "'!'", "'<'", "'>'", 
			"'<='", "'>='", "'=='", "'!='", "'&'", "'int'", "'float'", "'boolean'", 
			"'char'", "'String'", "'void'", "'true'", "'false'", "'null'", null, 
			null, "'_'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "Egal", "AccoladeOuvrante", "AccoladeFermante", "ParentheseOuvrante", 
			"ParentheseFermante", "CrochetOuvrant", "CrochetFermant", "Point", "PointInterrogation", 
			"DeuxPoint", "Virgule", "PointVirgule", "Afficher", "Si", "Sinon", "Retour", 
			"TantQue", "Nouveau", "Classe", "Herite", "Public", "Prive", "DeClasse", 
			"Definitif", "Moi", "Super", "MethodePrincipale", "Abstrait", "Protege", 
			"Asterisque", "Oblique", "PourCent", "Plus", "Moins", "DoubleBarre", 
			"DoubleEsperluette", "PointExclamation", "Inferieur", "Superieur", "InferieurEgal", 
			"SuperieurEgal", "DoubleEgal", "ExclamationEgal", "Esperluette", "TypeEntier", 
			"TypeFlottant", "TypeBooleen", "TypeCaractere", "TypeChaine", "TypeVide", 
			"Vrai", "Faux", "Nul", "Caractere", "Chaine", "Underscore", "Identificateur", 
			"Entier", "Flottant", "CommentaireLigne", "CommentaireBloc", "WS"
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


	public MiniJavaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MiniJavaLexer.g4"; }

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
		"\u0004\u0000>\u01a0\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002"+
		"\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002"+
		"\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002"+
		"\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007"+
		"!\u0002\"\u0007\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007"+
		"&\u0002\'\u0007\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007"+
		"+\u0002,\u0007,\u0002-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u0007"+
		"0\u00021\u00071\u00022\u00072\u00023\u00073\u00024\u00074\u00025\u0007"+
		"5\u00026\u00076\u00027\u00077\u00028\u00078\u00029\u00079\u0002:\u0007"+
		":\u0002;\u0007;\u0002<\u0007<\u0002=\u0007=\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001d\u0001"+
		"\u001d\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001"+
		"!\u0001!\u0001\"\u0001\"\u0001\"\u0001#\u0001#\u0001#\u0001$\u0001$\u0001"+
		"%\u0001%\u0001&\u0001&\u0001\'\u0001\'\u0001\'\u0001(\u0001(\u0001(\u0001"+
		")\u0001)\u0001)\u0001*\u0001*\u0001*\u0001+\u0001+\u0001,\u0001,\u0001"+
		",\u0001,\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001.\u0001.\u0001"+
		".\u0001.\u0001.\u0001.\u0001.\u0001.\u0001/\u0001/\u0001/\u0001/\u0001"+
		"/\u00010\u00010\u00010\u00010\u00010\u00010\u00010\u00011\u00011\u0001"+
		"1\u00011\u00011\u00012\u00012\u00012\u00012\u00012\u00013\u00013\u0001"+
		"3\u00013\u00013\u00013\u00014\u00014\u00014\u00014\u00014\u00015\u0001"+
		"5\u00015\u00015\u00016\u00016\u00056\u015f\b6\n6\f6\u0162\t6\u00016\u0001"+
		"6\u00017\u00017\u00018\u00018\u00038\u016a\b8\u00018\u00018\u00058\u016e"+
		"\b8\n8\f8\u0171\t8\u00019\u00019\u00019\u00059\u0176\b9\n9\f9\u0179\t"+
		"9\u00039\u017b\b9\u0001:\u0001:\u0001:\u0001:\u0001;\u0001;\u0001;\u0001"+
		";\u0005;\u0185\b;\n;\f;\u0188\t;\u0001;\u0001;\u0001<\u0001<\u0001<\u0001"+
		"<\u0005<\u0190\b<\n<\f<\u0193\t<\u0001<\u0001<\u0001<\u0001<\u0001<\u0001"+
		"=\u0004=\u019b\b=\u000b=\f=\u019c\u0001=\u0001=\u0002\u0160\u0191\u0000"+
		">\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006"+
		"\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e"+
		"\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017"+
		"/\u00181\u00193\u001a5\u001b7\u001c9\u001d;\u001e=\u001f? A!C\"E#G$I%"+
		"K&M\'O(Q)S*U+W,Y-[.]/_0a1c2e3g4i5k6m7o8q9s:u;w<y={>\u0001\u0000\u0006"+
		"\u0002\u0000AZaz\u0004\u000009AZ__az\u0001\u000019\u0001\u000009\u0002"+
		"\u0000\n\n\r\r\u0003\u0000\t\n\r\r  \u01a8\u0000\u0001\u0001\u0000\u0000"+
		"\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000"+
		"\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000"+
		"\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000"+
		"\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000"+
		"\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000"+
		"\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000"+
		"\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000"+
		"\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001"+
		"\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000"+
		"\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000"+
		"\u0000-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u00001"+
		"\u0001\u0000\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u00005\u0001\u0000"+
		"\u0000\u0000\u00007\u0001\u0000\u0000\u0000\u00009\u0001\u0000\u0000\u0000"+
		"\u0000;\u0001\u0000\u0000\u0000\u0000=\u0001\u0000\u0000\u0000\u0000?"+
		"\u0001\u0000\u0000\u0000\u0000A\u0001\u0000\u0000\u0000\u0000C\u0001\u0000"+
		"\u0000\u0000\u0000E\u0001\u0000\u0000\u0000\u0000G\u0001\u0000\u0000\u0000"+
		"\u0000I\u0001\u0000\u0000\u0000\u0000K\u0001\u0000\u0000\u0000\u0000M"+
		"\u0001\u0000\u0000\u0000\u0000O\u0001\u0000\u0000\u0000\u0000Q\u0001\u0000"+
		"\u0000\u0000\u0000S\u0001\u0000\u0000\u0000\u0000U\u0001\u0000\u0000\u0000"+
		"\u0000W\u0001\u0000\u0000\u0000\u0000Y\u0001\u0000\u0000\u0000\u0000["+
		"\u0001\u0000\u0000\u0000\u0000]\u0001\u0000\u0000\u0000\u0000_\u0001\u0000"+
		"\u0000\u0000\u0000a\u0001\u0000\u0000\u0000\u0000c\u0001\u0000\u0000\u0000"+
		"\u0000e\u0001\u0000\u0000\u0000\u0000g\u0001\u0000\u0000\u0000\u0000i"+
		"\u0001\u0000\u0000\u0000\u0000k\u0001\u0000\u0000\u0000\u0000m\u0001\u0000"+
		"\u0000\u0000\u0000o\u0001\u0000\u0000\u0000\u0000q\u0001\u0000\u0000\u0000"+
		"\u0000s\u0001\u0000\u0000\u0000\u0000u\u0001\u0000\u0000\u0000\u0000w"+
		"\u0001\u0000\u0000\u0000\u0000y\u0001\u0000\u0000\u0000\u0000{\u0001\u0000"+
		"\u0000\u0000\u0001}\u0001\u0000\u0000\u0000\u0003\u007f\u0001\u0000\u0000"+
		"\u0000\u0005\u0081\u0001\u0000\u0000\u0000\u0007\u0083\u0001\u0000\u0000"+
		"\u0000\t\u0085\u0001\u0000\u0000\u0000\u000b\u0087\u0001\u0000\u0000\u0000"+
		"\r\u0089\u0001\u0000\u0000\u0000\u000f\u008b\u0001\u0000\u0000\u0000\u0011"+
		"\u008d\u0001\u0000\u0000\u0000\u0013\u008f\u0001\u0000\u0000\u0000\u0015"+
		"\u0091\u0001\u0000\u0000\u0000\u0017\u0093\u0001\u0000\u0000\u0000\u0019"+
		"\u0095\u0001\u0000\u0000\u0000\u001b\u009b\u0001\u0000\u0000\u0000\u001d"+
		"\u009e\u0001\u0000\u0000\u0000\u001f\u00a3\u0001\u0000\u0000\u0000!\u00aa"+
		"\u0001\u0000\u0000\u0000#\u00b0\u0001\u0000\u0000\u0000%\u00b4\u0001\u0000"+
		"\u0000\u0000\'\u00ba\u0001\u0000\u0000\u0000)\u00c2\u0001\u0000\u0000"+
		"\u0000+\u00c9\u0001\u0000\u0000\u0000-\u00d1\u0001\u0000\u0000\u0000/"+
		"\u00d8\u0001\u0000\u0000\u00001\u00de\u0001\u0000\u0000\u00003\u00e3\u0001"+
		"\u0000\u0000\u00005\u00e9\u0001\u0000\u0000\u00007\u00ee\u0001\u0000\u0000"+
		"\u00009\u00f7\u0001\u0000\u0000\u0000;\u0101\u0001\u0000\u0000\u0000="+
		"\u0103\u0001\u0000\u0000\u0000?\u0105\u0001\u0000\u0000\u0000A\u0107\u0001"+
		"\u0000\u0000\u0000C\u0109\u0001\u0000\u0000\u0000E\u010b\u0001\u0000\u0000"+
		"\u0000G\u010e\u0001\u0000\u0000\u0000I\u0111\u0001\u0000\u0000\u0000K"+
		"\u0113\u0001\u0000\u0000\u0000M\u0115\u0001\u0000\u0000\u0000O\u0117\u0001"+
		"\u0000\u0000\u0000Q\u011a\u0001\u0000\u0000\u0000S\u011d\u0001\u0000\u0000"+
		"\u0000U\u0120\u0001\u0000\u0000\u0000W\u0123\u0001\u0000\u0000\u0000Y"+
		"\u0125\u0001\u0000\u0000\u0000[\u0129\u0001\u0000\u0000\u0000]\u012f\u0001"+
		"\u0000\u0000\u0000_\u0137\u0001\u0000\u0000\u0000a\u013c\u0001\u0000\u0000"+
		"\u0000c\u0143\u0001\u0000\u0000\u0000e\u0148\u0001\u0000\u0000\u0000g"+
		"\u014d\u0001\u0000\u0000\u0000i\u0153\u0001\u0000\u0000\u0000k\u0158\u0001"+
		"\u0000\u0000\u0000m\u015c\u0001\u0000\u0000\u0000o\u0165\u0001\u0000\u0000"+
		"\u0000q\u0169\u0001\u0000\u0000\u0000s\u017a\u0001\u0000\u0000\u0000u"+
		"\u017c\u0001\u0000\u0000\u0000w\u0180\u0001\u0000\u0000\u0000y\u018b\u0001"+
		"\u0000\u0000\u0000{\u019a\u0001\u0000\u0000\u0000}~\u0005=\u0000\u0000"+
		"~\u0002\u0001\u0000\u0000\u0000\u007f\u0080\u0005{\u0000\u0000\u0080\u0004"+
		"\u0001\u0000\u0000\u0000\u0081\u0082\u0005}\u0000\u0000\u0082\u0006\u0001"+
		"\u0000\u0000\u0000\u0083\u0084\u0005(\u0000\u0000\u0084\b\u0001\u0000"+
		"\u0000\u0000\u0085\u0086\u0005)\u0000\u0000\u0086\n\u0001\u0000\u0000"+
		"\u0000\u0087\u0088\u0005[\u0000\u0000\u0088\f\u0001\u0000\u0000\u0000"+
		"\u0089\u008a\u0005]\u0000\u0000\u008a\u000e\u0001\u0000\u0000\u0000\u008b"+
		"\u008c\u0005.\u0000\u0000\u008c\u0010\u0001\u0000\u0000\u0000\u008d\u008e"+
		"\u0005?\u0000\u0000\u008e\u0012\u0001\u0000\u0000\u0000\u008f\u0090\u0005"+
		":\u0000\u0000\u0090\u0014\u0001\u0000\u0000\u0000\u0091\u0092\u0005,\u0000"+
		"\u0000\u0092\u0016\u0001\u0000\u0000\u0000\u0093\u0094\u0005;\u0000\u0000"+
		"\u0094\u0018\u0001\u0000\u0000\u0000\u0095\u0096\u0005p\u0000\u0000\u0096"+
		"\u0097\u0005r\u0000\u0000\u0097\u0098\u0005i\u0000\u0000\u0098\u0099\u0005"+
		"n\u0000\u0000\u0099\u009a\u0005t\u0000\u0000\u009a\u001a\u0001\u0000\u0000"+
		"\u0000\u009b\u009c\u0005i\u0000\u0000\u009c\u009d\u0005f\u0000\u0000\u009d"+
		"\u001c\u0001\u0000\u0000\u0000\u009e\u009f\u0005e\u0000\u0000\u009f\u00a0"+
		"\u0005l\u0000\u0000\u00a0\u00a1\u0005s\u0000\u0000\u00a1\u00a2\u0005e"+
		"\u0000\u0000\u00a2\u001e\u0001\u0000\u0000\u0000\u00a3\u00a4\u0005r\u0000"+
		"\u0000\u00a4\u00a5\u0005e\u0000\u0000\u00a5\u00a6\u0005t\u0000\u0000\u00a6"+
		"\u00a7\u0005u\u0000\u0000\u00a7\u00a8\u0005r\u0000\u0000\u00a8\u00a9\u0005"+
		"n\u0000\u0000\u00a9 \u0001\u0000\u0000\u0000\u00aa\u00ab\u0005w\u0000"+
		"\u0000\u00ab\u00ac\u0005h\u0000\u0000\u00ac\u00ad\u0005i\u0000\u0000\u00ad"+
		"\u00ae\u0005l\u0000\u0000\u00ae\u00af\u0005e\u0000\u0000\u00af\"\u0001"+
		"\u0000\u0000\u0000\u00b0\u00b1\u0005n\u0000\u0000\u00b1\u00b2\u0005e\u0000"+
		"\u0000\u00b2\u00b3\u0005w\u0000\u0000\u00b3$\u0001\u0000\u0000\u0000\u00b4"+
		"\u00b5\u0005c\u0000\u0000\u00b5\u00b6\u0005l\u0000\u0000\u00b6\u00b7\u0005"+
		"a\u0000\u0000\u00b7\u00b8\u0005s\u0000\u0000\u00b8\u00b9\u0005s\u0000"+
		"\u0000\u00b9&\u0001\u0000\u0000\u0000\u00ba\u00bb\u0005e\u0000\u0000\u00bb"+
		"\u00bc\u0005x\u0000\u0000\u00bc\u00bd\u0005t\u0000\u0000\u00bd\u00be\u0005"+
		"e\u0000\u0000\u00be\u00bf\u0005n\u0000\u0000\u00bf\u00c0\u0005d\u0000"+
		"\u0000\u00c0\u00c1\u0005s\u0000\u0000\u00c1(\u0001\u0000\u0000\u0000\u00c2"+
		"\u00c3\u0005p\u0000\u0000\u00c3\u00c4\u0005u\u0000\u0000\u00c4\u00c5\u0005"+
		"b\u0000\u0000\u00c5\u00c6\u0005l\u0000\u0000\u00c6\u00c7\u0005i\u0000"+
		"\u0000\u00c7\u00c8\u0005c\u0000\u0000\u00c8*\u0001\u0000\u0000\u0000\u00c9"+
		"\u00ca\u0005p\u0000\u0000\u00ca\u00cb\u0005r\u0000\u0000\u00cb\u00cc\u0005"+
		"i\u0000\u0000\u00cc\u00cd\u0005v\u0000\u0000\u00cd\u00ce\u0005a\u0000"+
		"\u0000\u00ce\u00cf\u0005t\u0000\u0000\u00cf\u00d0\u0005e\u0000\u0000\u00d0"+
		",\u0001\u0000\u0000\u0000\u00d1\u00d2\u0005s\u0000\u0000\u00d2\u00d3\u0005"+
		"t\u0000\u0000\u00d3\u00d4\u0005a\u0000\u0000\u00d4\u00d5\u0005t\u0000"+
		"\u0000\u00d5\u00d6\u0005i\u0000\u0000\u00d6\u00d7\u0005c\u0000\u0000\u00d7"+
		".\u0001\u0000\u0000\u0000\u00d8\u00d9\u0005f\u0000\u0000\u00d9\u00da\u0005"+
		"i\u0000\u0000\u00da\u00db\u0005n\u0000\u0000\u00db\u00dc\u0005a\u0000"+
		"\u0000\u00dc\u00dd\u0005l\u0000\u0000\u00dd0\u0001\u0000\u0000\u0000\u00de"+
		"\u00df\u0005t\u0000\u0000\u00df\u00e0\u0005h\u0000\u0000\u00e0\u00e1\u0005"+
		"i\u0000\u0000\u00e1\u00e2\u0005s\u0000\u0000\u00e22\u0001\u0000\u0000"+
		"\u0000\u00e3\u00e4\u0005s\u0000\u0000\u00e4\u00e5\u0005u\u0000\u0000\u00e5"+
		"\u00e6\u0005p\u0000\u0000\u00e6\u00e7\u0005e\u0000\u0000\u00e7\u00e8\u0005"+
		"r\u0000\u0000\u00e84\u0001\u0000\u0000\u0000\u00e9\u00ea\u0005m\u0000"+
		"\u0000\u00ea\u00eb\u0005a\u0000\u0000\u00eb\u00ec\u0005i\u0000\u0000\u00ec"+
		"\u00ed\u0005n\u0000\u0000\u00ed6\u0001\u0000\u0000\u0000\u00ee\u00ef\u0005"+
		"a\u0000\u0000\u00ef\u00f0\u0005b\u0000\u0000\u00f0\u00f1\u0005s\u0000"+
		"\u0000\u00f1\u00f2\u0005t\u0000\u0000\u00f2\u00f3\u0005r\u0000\u0000\u00f3"+
		"\u00f4\u0005a\u0000\u0000\u00f4\u00f5\u0005c\u0000\u0000\u00f5\u00f6\u0005"+
		"t\u0000\u0000\u00f68\u0001\u0000\u0000\u0000\u00f7\u00f8\u0005p\u0000"+
		"\u0000\u00f8\u00f9\u0005r\u0000\u0000\u00f9\u00fa\u0005o\u0000\u0000\u00fa"+
		"\u00fb\u0005t\u0000\u0000\u00fb\u00fc\u0005e\u0000\u0000\u00fc\u00fd\u0005"+
		"c\u0000\u0000\u00fd\u00fe\u0005t\u0000\u0000\u00fe\u00ff\u0005e\u0000"+
		"\u0000\u00ff\u0100\u0005d\u0000\u0000\u0100:\u0001\u0000\u0000\u0000\u0101"+
		"\u0102\u0005*\u0000\u0000\u0102<\u0001\u0000\u0000\u0000\u0103\u0104\u0005"+
		"/\u0000\u0000\u0104>\u0001\u0000\u0000\u0000\u0105\u0106\u0005%\u0000"+
		"\u0000\u0106@\u0001\u0000\u0000\u0000\u0107\u0108\u0005+\u0000\u0000\u0108"+
		"B\u0001\u0000\u0000\u0000\u0109\u010a\u0005-\u0000\u0000\u010aD\u0001"+
		"\u0000\u0000\u0000\u010b\u010c\u0005|\u0000\u0000\u010c\u010d\u0005|\u0000"+
		"\u0000\u010dF\u0001\u0000\u0000\u0000\u010e\u010f\u0005&\u0000\u0000\u010f"+
		"\u0110\u0005&\u0000\u0000\u0110H\u0001\u0000\u0000\u0000\u0111\u0112\u0005"+
		"!\u0000\u0000\u0112J\u0001\u0000\u0000\u0000\u0113\u0114\u0005<\u0000"+
		"\u0000\u0114L\u0001\u0000\u0000\u0000\u0115\u0116\u0005>\u0000\u0000\u0116"+
		"N\u0001\u0000\u0000\u0000\u0117\u0118\u0005<\u0000\u0000\u0118\u0119\u0005"+
		"=\u0000\u0000\u0119P\u0001\u0000\u0000\u0000\u011a\u011b\u0005>\u0000"+
		"\u0000\u011b\u011c\u0005=\u0000\u0000\u011cR\u0001\u0000\u0000\u0000\u011d"+
		"\u011e\u0005=\u0000\u0000\u011e\u011f\u0005=\u0000\u0000\u011fT\u0001"+
		"\u0000\u0000\u0000\u0120\u0121\u0005!\u0000\u0000\u0121\u0122\u0005=\u0000"+
		"\u0000\u0122V\u0001\u0000\u0000\u0000\u0123\u0124\u0005&\u0000\u0000\u0124"+
		"X\u0001\u0000\u0000\u0000\u0125\u0126\u0005i\u0000\u0000\u0126\u0127\u0005"+
		"n\u0000\u0000\u0127\u0128\u0005t\u0000\u0000\u0128Z\u0001\u0000\u0000"+
		"\u0000\u0129\u012a\u0005f\u0000\u0000\u012a\u012b\u0005l\u0000\u0000\u012b"+
		"\u012c\u0005o\u0000\u0000\u012c\u012d\u0005a\u0000\u0000\u012d\u012e\u0005"+
		"t\u0000\u0000\u012e\\\u0001\u0000\u0000\u0000\u012f\u0130\u0005b\u0000"+
		"\u0000\u0130\u0131\u0005o\u0000\u0000\u0131\u0132\u0005o\u0000\u0000\u0132"+
		"\u0133\u0005l\u0000\u0000\u0133\u0134\u0005e\u0000\u0000\u0134\u0135\u0005"+
		"a\u0000\u0000\u0135\u0136\u0005n\u0000\u0000\u0136^\u0001\u0000\u0000"+
		"\u0000\u0137\u0138\u0005c\u0000\u0000\u0138\u0139\u0005h\u0000\u0000\u0139"+
		"\u013a\u0005a\u0000\u0000\u013a\u013b\u0005r\u0000\u0000\u013b`\u0001"+
		"\u0000\u0000\u0000\u013c\u013d\u0005S\u0000\u0000\u013d\u013e\u0005t\u0000"+
		"\u0000\u013e\u013f\u0005r\u0000\u0000\u013f\u0140\u0005i\u0000\u0000\u0140"+
		"\u0141\u0005n\u0000\u0000\u0141\u0142\u0005g\u0000\u0000\u0142b\u0001"+
		"\u0000\u0000\u0000\u0143\u0144\u0005v\u0000\u0000\u0144\u0145\u0005o\u0000"+
		"\u0000\u0145\u0146\u0005i\u0000\u0000\u0146\u0147\u0005d\u0000\u0000\u0147"+
		"d\u0001\u0000\u0000\u0000\u0148\u0149\u0005t\u0000\u0000\u0149\u014a\u0005"+
		"r\u0000\u0000\u014a\u014b\u0005u\u0000\u0000\u014b\u014c\u0005e\u0000"+
		"\u0000\u014cf\u0001\u0000\u0000\u0000\u014d\u014e\u0005f\u0000\u0000\u014e"+
		"\u014f\u0005a\u0000\u0000\u014f\u0150\u0005l\u0000\u0000\u0150\u0151\u0005"+
		"s\u0000\u0000\u0151\u0152\u0005e\u0000\u0000\u0152h\u0001\u0000\u0000"+
		"\u0000\u0153\u0154\u0005n\u0000\u0000\u0154\u0155\u0005u\u0000\u0000\u0155"+
		"\u0156\u0005l\u0000\u0000\u0156\u0157\u0005l\u0000\u0000\u0157j\u0001"+
		"\u0000\u0000\u0000\u0158\u0159\u0005\'\u0000\u0000\u0159\u015a\t\u0000"+
		"\u0000\u0000\u015a\u015b\u0005\'\u0000\u0000\u015bl\u0001\u0000\u0000"+
		"\u0000\u015c\u0160\u0005\"\u0000\u0000\u015d\u015f\t\u0000\u0000\u0000"+
		"\u015e\u015d\u0001\u0000\u0000\u0000\u015f\u0162\u0001\u0000\u0000\u0000"+
		"\u0160\u0161\u0001\u0000\u0000\u0000\u0160\u015e\u0001\u0000\u0000\u0000"+
		"\u0161\u0163\u0001\u0000\u0000\u0000\u0162\u0160\u0001\u0000\u0000\u0000"+
		"\u0163\u0164\u0005\"\u0000\u0000\u0164n\u0001\u0000\u0000\u0000\u0165"+
		"\u0166\u0005_\u0000\u0000\u0166p\u0001\u0000\u0000\u0000\u0167\u016a\u0007"+
		"\u0000\u0000\u0000\u0168\u016a\u0003o7\u0000\u0169\u0167\u0001\u0000\u0000"+
		"\u0000\u0169\u0168\u0001\u0000\u0000\u0000\u016a\u016f\u0001\u0000\u0000"+
		"\u0000\u016b\u016e\u0007\u0001\u0000\u0000\u016c\u016e\u0003o7\u0000\u016d"+
		"\u016b\u0001\u0000\u0000\u0000\u016d\u016c\u0001\u0000\u0000\u0000\u016e"+
		"\u0171\u0001\u0000\u0000\u0000\u016f\u016d\u0001\u0000\u0000\u0000\u016f"+
		"\u0170\u0001\u0000\u0000\u0000\u0170r\u0001\u0000\u0000\u0000\u0171\u016f"+
		"\u0001\u0000\u0000\u0000\u0172\u017b\u00050\u0000\u0000\u0173\u0177\u0007"+
		"\u0002\u0000\u0000\u0174\u0176\u0007\u0003\u0000\u0000\u0175\u0174\u0001"+
		"\u0000\u0000\u0000\u0176\u0179\u0001\u0000\u0000\u0000\u0177\u0175\u0001"+
		"\u0000\u0000\u0000\u0177\u0178\u0001\u0000\u0000\u0000\u0178\u017b\u0001"+
		"\u0000\u0000\u0000\u0179\u0177\u0001\u0000\u0000\u0000\u017a\u0172\u0001"+
		"\u0000\u0000\u0000\u017a\u0173\u0001\u0000\u0000\u0000\u017bt\u0001\u0000"+
		"\u0000\u0000\u017c\u017d\u0003s9\u0000\u017d\u017e\u0005.\u0000\u0000"+
		"\u017e\u017f\u0003s9\u0000\u017fv\u0001\u0000\u0000\u0000\u0180\u0181"+
		"\u0005/\u0000\u0000\u0181\u0182\u0005/\u0000\u0000\u0182\u0186\u0001\u0000"+
		"\u0000\u0000\u0183\u0185\b\u0004\u0000\u0000\u0184\u0183\u0001\u0000\u0000"+
		"\u0000\u0185\u0188\u0001\u0000\u0000\u0000\u0186\u0184\u0001\u0000\u0000"+
		"\u0000\u0186\u0187\u0001\u0000\u0000\u0000\u0187\u0189\u0001\u0000\u0000"+
		"\u0000\u0188\u0186\u0001\u0000\u0000\u0000\u0189\u018a\u0006;\u0000\u0000"+
		"\u018ax\u0001\u0000\u0000\u0000\u018b\u018c\u0005/\u0000\u0000\u018c\u018d"+
		"\u0005*\u0000\u0000\u018d\u0191\u0001\u0000\u0000\u0000\u018e\u0190\t"+
		"\u0000\u0000\u0000\u018f\u018e\u0001\u0000\u0000\u0000\u0190\u0193\u0001"+
		"\u0000\u0000\u0000\u0191\u0192\u0001\u0000\u0000\u0000\u0191\u018f\u0001"+
		"\u0000\u0000\u0000\u0192\u0194\u0001\u0000\u0000\u0000\u0193\u0191\u0001"+
		"\u0000\u0000\u0000\u0194\u0195\u0005*\u0000\u0000\u0195\u0196\u0005/\u0000"+
		"\u0000\u0196\u0197\u0001\u0000\u0000\u0000\u0197\u0198\u0006<\u0000\u0000"+
		"\u0198z\u0001\u0000\u0000\u0000\u0199\u019b\u0007\u0005\u0000\u0000\u019a"+
		"\u0199\u0001\u0000\u0000\u0000\u019b\u019c\u0001\u0000\u0000\u0000\u019c"+
		"\u019a\u0001\u0000\u0000\u0000\u019c\u019d\u0001\u0000\u0000\u0000\u019d"+
		"\u019e\u0001\u0000\u0000\u0000\u019e\u019f\u0006=\u0000\u0000\u019f|\u0001"+
		"\u0000\u0000\u0000\n\u0000\u0160\u0169\u016d\u016f\u0177\u017a\u0186\u0191"+
		"\u019c\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}