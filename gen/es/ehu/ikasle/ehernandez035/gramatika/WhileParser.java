// Generated from /home/elena/workspace/Test/src/main/antlr4/While.g4 by ANTLR 4.7
package es.ehu.ikasle.ehernandez035.gramatika;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class WhileParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, ALDAGAIA=15, CAR_X=16, 
		CONS_X=17, WS=18;
	public static final int
		RULE_prog = 0, RULE_statement = 1, RULE_adierazpena = 2;
	public static final String[] ruleNames = {
		"prog", "statement", "adierazpena"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'if'", "'?'", "'('", "')'", "'then'", "'end if'", "';'", "'while'", 
		"'nonem?'", "'loop'", "'end loop'", "':='", "'hutsa'", "'cdr'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, "ALDAGAIA", "CAR_X", "CONS_X", "WS"
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
	public String getGrammarFileName() { return "While.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public WhileParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public StatementContext statement;
		public List<StatementContext> stmts = new ArrayList<StatementContext>();
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileVisitor ) return ((WhileVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(9);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__7) | (1L << ALDAGAIA))) != 0)) {
				{
				{
				setState(6);
				((ProgContext)_localctx).statement = statement();
				((ProgContext)_localctx).stmts.add(((ProgContext)_localctx).statement);
				}
				}
				setState(11);
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

	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class EsleipenContext extends StatementContext {
		public Token ald;
		public AdierazpenaContext ad;
		public TerminalNode ALDAGAIA() { return getToken(WhileParser.ALDAGAIA, 0); }
		public AdierazpenaContext adierazpena() {
			return getRuleContext(AdierazpenaContext.class,0);
		}
		public EsleipenContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileVisitor ) return ((WhileVisitor<? extends T>)visitor).visitEsleipen(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WhileContext extends StatementContext {
		public Token ald;
		public StatementContext statement;
		public List<StatementContext> stmts = new ArrayList<StatementContext>();
		public TerminalNode ALDAGAIA() { return getToken(WhileParser.ALDAGAIA, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public WhileContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileVisitor ) return ((WhileVisitor<? extends T>)visitor).visitWhile(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfContext extends StatementContext {
		public Token bald;
		public Token ald;
		public StatementContext statement;
		public List<StatementContext> stmts = new ArrayList<StatementContext>();
		public TerminalNode CAR_X() { return getToken(WhileParser.CAR_X, 0); }
		public TerminalNode ALDAGAIA() { return getToken(WhileParser.ALDAGAIA, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public IfContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileVisitor ) return ((WhileVisitor<? extends T>)visitor).visitIf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		int _la;
		try {
			setState(46);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				_localctx = new IfContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(12);
				match(T__0);
				setState(13);
				((IfContext)_localctx).bald = match(CAR_X);
				setState(14);
				match(T__1);
				setState(15);
				match(T__2);
				setState(16);
				((IfContext)_localctx).ald = match(ALDAGAIA);
				setState(17);
				match(T__3);
				setState(18);
				match(T__4);
				setState(20); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(19);
					((IfContext)_localctx).statement = statement();
					((IfContext)_localctx).stmts.add(((IfContext)_localctx).statement);
					}
					}
					setState(22); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__7) | (1L << ALDAGAIA))) != 0) );
				setState(24);
				match(T__5);
				setState(25);
				match(T__6);
				}
				break;
			case T__7:
				_localctx = new WhileContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(27);
				match(T__7);
				setState(28);
				match(T__8);
				setState(29);
				match(T__2);
				setState(30);
				((WhileContext)_localctx).ald = match(ALDAGAIA);
				setState(31);
				match(T__3);
				setState(32);
				match(T__9);
				setState(34); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(33);
					((WhileContext)_localctx).statement = statement();
					((WhileContext)_localctx).stmts.add(((WhileContext)_localctx).statement);
					}
					}
					setState(36); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__7) | (1L << ALDAGAIA))) != 0) );
				setState(38);
				match(T__10);
				setState(39);
				match(T__6);
				}
				break;
			case ALDAGAIA:
				_localctx = new EsleipenContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(41);
				((EsleipenContext)_localctx).ald = match(ALDAGAIA);
				setState(42);
				match(T__11);
				setState(43);
				((EsleipenContext)_localctx).ad = adierazpena();
				setState(44);
				match(T__6);
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

	public static class AdierazpenaContext extends ParserRuleContext {
		public AdierazpenaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_adierazpena; }
	 
		public AdierazpenaContext() { }
		public void copyFrom(AdierazpenaContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CdrContext extends AdierazpenaContext {
		public Token ald;
		public TerminalNode ALDAGAIA() { return getToken(WhileParser.ALDAGAIA, 0); }
		public CdrContext(AdierazpenaContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileVisitor ) return ((WhileVisitor<? extends T>)visitor).visitCdr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class HutsaContext extends AdierazpenaContext {
		public HutsaContext(AdierazpenaContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileVisitor ) return ((WhileVisitor<? extends T>)visitor).visitHutsa(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConsContext extends AdierazpenaContext {
		public Token cons;
		public Token ald;
		public TerminalNode CONS_X() { return getToken(WhileParser.CONS_X, 0); }
		public TerminalNode ALDAGAIA() { return getToken(WhileParser.ALDAGAIA, 0); }
		public ConsContext(AdierazpenaContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof WhileVisitor ) return ((WhileVisitor<? extends T>)visitor).visitCons(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AdierazpenaContext adierazpena() throws RecognitionException {
		AdierazpenaContext _localctx = new AdierazpenaContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_adierazpena);
		try {
			setState(57);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__12:
				_localctx = new HutsaContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(48);
				match(T__12);
				}
				break;
			case T__13:
				_localctx = new CdrContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(49);
				match(T__13);
				setState(50);
				match(T__2);
				setState(51);
				((CdrContext)_localctx).ald = match(ALDAGAIA);
				setState(52);
				match(T__3);
				}
				break;
			case CONS_X:
				_localctx = new ConsContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(53);
				((ConsContext)_localctx).cons = match(CONS_X);
				setState(54);
				match(T__2);
				setState(55);
				((ConsContext)_localctx).ald = match(ALDAGAIA);
				setState(56);
				match(T__3);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\24>\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\3\2\7\2\n\n\2\f\2\16\2\r\13\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\6\3\27\n\3\r\3\16\3\30\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\6\3"+
		"%\n\3\r\3\16\3&\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\61\n\3\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\5\4<\n\4\3\4\2\2\5\2\4\6\2\2\2A\2\13\3\2\2\2"+
		"\4\60\3\2\2\2\6;\3\2\2\2\b\n\5\4\3\2\t\b\3\2\2\2\n\r\3\2\2\2\13\t\3\2"+
		"\2\2\13\f\3\2\2\2\f\3\3\2\2\2\r\13\3\2\2\2\16\17\7\3\2\2\17\20\7\22\2"+
		"\2\20\21\7\4\2\2\21\22\7\5\2\2\22\23\7\21\2\2\23\24\7\6\2\2\24\26\7\7"+
		"\2\2\25\27\5\4\3\2\26\25\3\2\2\2\27\30\3\2\2\2\30\26\3\2\2\2\30\31\3\2"+
		"\2\2\31\32\3\2\2\2\32\33\7\b\2\2\33\34\7\t\2\2\34\61\3\2\2\2\35\36\7\n"+
		"\2\2\36\37\7\13\2\2\37 \7\5\2\2 !\7\21\2\2!\"\7\6\2\2\"$\7\f\2\2#%\5\4"+
		"\3\2$#\3\2\2\2%&\3\2\2\2&$\3\2\2\2&\'\3\2\2\2\'(\3\2\2\2()\7\r\2\2)*\7"+
		"\t\2\2*\61\3\2\2\2+,\7\21\2\2,-\7\16\2\2-.\5\6\4\2./\7\t\2\2/\61\3\2\2"+
		"\2\60\16\3\2\2\2\60\35\3\2\2\2\60+\3\2\2\2\61\5\3\2\2\2\62<\7\17\2\2\63"+
		"\64\7\20\2\2\64\65\7\5\2\2\65\66\7\21\2\2\66<\7\6\2\2\678\7\23\2\289\7"+
		"\5\2\29:\7\21\2\2:<\7\6\2\2;\62\3\2\2\2;\63\3\2\2\2;\67\3\2\2\2<\7\3\2"+
		"\2\2\7\13\30&\60;";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}