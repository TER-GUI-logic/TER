// Generated from Analyseur.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AnalyseurParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, Faux=8, Vrai=9, 
		Variable=10, WS=11;
	public static final int
		RULE_formul = 0, RULE_variable = 1, RULE_ou = 2, RULE_et = 3, RULE_implique = 4, 
		RULE_equivalent = 5, RULE_non = 6;
	public static final String[] ruleNames = {
		"formul", "variable", "ou", "et", "implique", "equivalent", "non"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "'\\/'", "')'", "'/\\'", "'=>'", "'<=>'", "'non'", "'False'", 
		"'True'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, "Faux", "Vrai", "Variable", 
		"WS"
	};
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
	public String getGrammarFileName() { return "Analyseur.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public AnalyseurParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class FormulContext extends ParserRuleContext {
		public Formule value;
		public VariableContext va;
		public OuContext o;
		public EtContext e;
		public ImpliqueContext i;
		public EquivalentContext eq;
		public NonContext n;
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public OuContext ou() {
			return getRuleContext(OuContext.class,0);
		}
		public EtContext et() {
			return getRuleContext(EtContext.class,0);
		}
		public ImpliqueContext implique() {
			return getRuleContext(ImpliqueContext.class,0);
		}
		public EquivalentContext equivalent() {
			return getRuleContext(EquivalentContext.class,0);
		}
		public NonContext non() {
			return getRuleContext(NonContext.class,0);
		}
		public FormulContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formul; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnalyseurListener ) ((AnalyseurListener)listener).enterFormul(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnalyseurListener ) ((AnalyseurListener)listener).exitFormul(this);
		}
	}

	public final FormulContext formul() throws RecognitionException {
		FormulContext _localctx = new FormulContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_formul);
		try {
			setState(32);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(14);
				((FormulContext)_localctx).va = variable();
				((FormulContext)_localctx).value = ((FormulContext)_localctx).va.value;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(17);
				((FormulContext)_localctx).o = ou();
				((FormulContext)_localctx).value = ((FormulContext)_localctx).o.value;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(20);
				((FormulContext)_localctx).e = et();
				((FormulContext)_localctx).value = ((FormulContext)_localctx).e.value;
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(23);
				((FormulContext)_localctx).i = implique();
				((FormulContext)_localctx).value = ((FormulContext)_localctx).i.value;
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(26);
				((FormulContext)_localctx).eq = equivalent();
				((FormulContext)_localctx).value = ((FormulContext)_localctx).eq.value;
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(29);
				((FormulContext)_localctx).n = non();
				((FormulContext)_localctx).value = ((FormulContext)_localctx).n.value;
				}
				break;
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

	public static class VariableContext extends ParserRuleContext {
		public Formule value;
		public Token var;
		public TerminalNode Faux() { return getToken(AnalyseurParser.Faux, 0); }
		public TerminalNode Vrai() { return getToken(AnalyseurParser.Vrai, 0); }
		public TerminalNode Variable() { return getToken(AnalyseurParser.Variable, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnalyseurListener ) ((AnalyseurListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnalyseurListener ) ((AnalyseurListener)listener).exitVariable(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_variable);
		try {
			setState(40);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Faux:
				enterOuterAlt(_localctx, 1);
				{
				setState(34);
				match(Faux);
				((VariableContext)_localctx).value = new Faux();
				}
				break;
			case Vrai:
				enterOuterAlt(_localctx, 2);
				{
				setState(36);
				match(Vrai);
				((VariableContext)_localctx).value = new Vrai();
				}
				break;
			case Variable:
				enterOuterAlt(_localctx, 3);
				{
				setState(38);
				((VariableContext)_localctx).var = match(Variable);
				((VariableContext)_localctx).value =  new Variable((((VariableContext)_localctx).var!=null?((VariableContext)_localctx).var.getText():null));
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

	public static class OuContext extends ParserRuleContext {
		public Formule value;
		public FormulContext f1;
		public FormulContext f2;
		public List<FormulContext> formul() {
			return getRuleContexts(FormulContext.class);
		}
		public FormulContext formul(int i) {
			return getRuleContext(FormulContext.class,i);
		}
		public OuContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ou; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnalyseurListener ) ((AnalyseurListener)listener).enterOu(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnalyseurListener ) ((AnalyseurListener)listener).exitOu(this);
		}
	}

	public final OuContext ou() throws RecognitionException {
		OuContext _localctx = new OuContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_ou);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			match(T__0);
			setState(43);
			((OuContext)_localctx).f1 = formul();
			setState(44);
			match(T__1);
			setState(45);
			((OuContext)_localctx).f2 = formul();
			setState(46);
			match(T__2);
			((OuContext)_localctx).value =  new Ou(((OuContext)_localctx).f1.value,((OuContext)_localctx).f2.value);
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

	public static class EtContext extends ParserRuleContext {
		public Formule value;
		public FormulContext f1;
		public FormulContext f2;
		public List<FormulContext> formul() {
			return getRuleContexts(FormulContext.class);
		}
		public FormulContext formul(int i) {
			return getRuleContext(FormulContext.class,i);
		}
		public EtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_et; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnalyseurListener ) ((AnalyseurListener)listener).enterEt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnalyseurListener ) ((AnalyseurListener)listener).exitEt(this);
		}
	}

	public final EtContext et() throws RecognitionException {
		EtContext _localctx = new EtContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_et);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			match(T__0);
			setState(50);
			((EtContext)_localctx).f1 = formul();
			setState(51);
			match(T__3);
			setState(52);
			((EtContext)_localctx).f2 = formul();
			setState(53);
			match(T__2);
			((EtContext)_localctx).value =  new Et(((EtContext)_localctx).f1.value,((EtContext)_localctx).f2.value);
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

	public static class ImpliqueContext extends ParserRuleContext {
		public Formule value;
		public FormulContext f1;
		public FormulContext f2;
		public List<FormulContext> formul() {
			return getRuleContexts(FormulContext.class);
		}
		public FormulContext formul(int i) {
			return getRuleContext(FormulContext.class,i);
		}
		public ImpliqueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_implique; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnalyseurListener ) ((AnalyseurListener)listener).enterImplique(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnalyseurListener ) ((AnalyseurListener)listener).exitImplique(this);
		}
	}

	public final ImpliqueContext implique() throws RecognitionException {
		ImpliqueContext _localctx = new ImpliqueContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_implique);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			match(T__0);
			setState(57);
			((ImpliqueContext)_localctx).f1 = formul();
			setState(58);
			match(T__4);
			setState(59);
			((ImpliqueContext)_localctx).f2 = formul();
			setState(60);
			match(T__2);
			((ImpliqueContext)_localctx).value =  new Implique(((ImpliqueContext)_localctx).f1.value,((ImpliqueContext)_localctx).f2.value);
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

	public static class EquivalentContext extends ParserRuleContext {
		public Formule value;
		public FormulContext f1;
		public FormulContext f2;
		public List<FormulContext> formul() {
			return getRuleContexts(FormulContext.class);
		}
		public FormulContext formul(int i) {
			return getRuleContext(FormulContext.class,i);
		}
		public EquivalentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equivalent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnalyseurListener ) ((AnalyseurListener)listener).enterEquivalent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnalyseurListener ) ((AnalyseurListener)listener).exitEquivalent(this);
		}
	}

	public final EquivalentContext equivalent() throws RecognitionException {
		EquivalentContext _localctx = new EquivalentContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_equivalent);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			match(T__0);
			setState(64);
			((EquivalentContext)_localctx).f1 = formul();
			setState(65);
			match(T__5);
			setState(66);
			((EquivalentContext)_localctx).f2 = formul();
			setState(67);
			match(T__2);
			((EquivalentContext)_localctx).value =  new Equivalent(((EquivalentContext)_localctx).f1.value,((EquivalentContext)_localctx).f2.value);
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

	public static class NonContext extends ParserRuleContext {
		public Formule value;
		public FormulContext f;
		public FormulContext formul() {
			return getRuleContext(FormulContext.class,0);
		}
		public NonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_non; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AnalyseurListener ) ((AnalyseurListener)listener).enterNon(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AnalyseurListener ) ((AnalyseurListener)listener).exitNon(this);
		}
	}

	public final NonContext non() throws RecognitionException {
		NonContext _localctx = new NonContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_non);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			match(T__6);
			setState(71);
			match(T__0);
			setState(72);
			((NonContext)_localctx).f = formul();
			setState(73);
			match(T__2);
			((NonContext)_localctx).value =  new Non(((NonContext)_localctx).f.value);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\rO\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2#\n\2\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\5\3+\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\2\2\t\2\4\6\b\n\f\16\2\2\2N\2\"\3\2\2\2\4*\3\2\2\2"+
		"\6,\3\2\2\2\b\63\3\2\2\2\n:\3\2\2\2\fA\3\2\2\2\16H\3\2\2\2\20\21\5\4\3"+
		"\2\21\22\b\2\1\2\22#\3\2\2\2\23\24\5\6\4\2\24\25\b\2\1\2\25#\3\2\2\2\26"+
		"\27\5\b\5\2\27\30\b\2\1\2\30#\3\2\2\2\31\32\5\n\6\2\32\33\b\2\1\2\33#"+
		"\3\2\2\2\34\35\5\f\7\2\35\36\b\2\1\2\36#\3\2\2\2\37 \5\16\b\2 !\b\2\1"+
		"\2!#\3\2\2\2\"\20\3\2\2\2\"\23\3\2\2\2\"\26\3\2\2\2\"\31\3\2\2\2\"\34"+
		"\3\2\2\2\"\37\3\2\2\2#\3\3\2\2\2$%\7\n\2\2%+\b\3\1\2&\'\7\13\2\2\'+\b"+
		"\3\1\2()\7\f\2\2)+\b\3\1\2*$\3\2\2\2*&\3\2\2\2*(\3\2\2\2+\5\3\2\2\2,-"+
		"\7\3\2\2-.\5\2\2\2./\7\4\2\2/\60\5\2\2\2\60\61\7\5\2\2\61\62\b\4\1\2\62"+
		"\7\3\2\2\2\63\64\7\3\2\2\64\65\5\2\2\2\65\66\7\6\2\2\66\67\5\2\2\2\67"+
		"8\7\5\2\289\b\5\1\29\t\3\2\2\2:;\7\3\2\2;<\5\2\2\2<=\7\7\2\2=>\5\2\2\2"+
		">?\7\5\2\2?@\b\6\1\2@\13\3\2\2\2AB\7\3\2\2BC\5\2\2\2CD\7\b\2\2DE\5\2\2"+
		"\2EF\7\5\2\2FG\b\7\1\2G\r\3\2\2\2HI\7\t\2\2IJ\7\3\2\2JK\5\2\2\2KL\7\5"+
		"\2\2LM\b\b\1\2M\17\3\2\2\2\4\"*";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}