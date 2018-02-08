// Generated from /home/elena/workspace/Test/src/main/antlr4/Makroprograma.g4 by ANTLR 4.7
package es.ehu.ikasle.ehernandez035.gramatika.makro;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MakroprogramaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, ERAG=19, HITZA=20, CONSX=21, CARX=22, DESKOD=23, ALDAGAIA=24, 
		COMMENT=25, WS=26;
	public static final int
		RULE_prog = 0, RULE_func = 1, RULE_statement = 2, RULE_adierazpena = 3;
	public static final String[] ruleNames = {
		"prog", "func", "statement", "adierazpena"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'def'", "'?'", "'begin'", "'end def'", "';'", "'if'", "'then'", 
		"'else'", "'end if'", "'while'", "'loop'", "'end loop'", "':='", "'hutsa'", 
		"'('", "')'", "','", "'not'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, "ERAG", "HITZA", "CONSX", "CARX", 
		"DESKOD", "ALDAGAIA", "COMMENT", "WS"
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
	public String getGrammarFileName() { return "Makroprograma.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MakroprogramaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public FuncContext func;
		public List<FuncContext> funtz = new ArrayList<FuncContext>();
		public TerminalNode EOF() { return getToken(MakroprogramaParser.EOF, 0); }
		public List<FuncContext> func() {
			return getRuleContexts(FuncContext.class);
		}
		public FuncContext func(int i) {
			return getRuleContext(FuncContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakroprogramaVisitor ) return ((MakroprogramaVisitor<? extends T>)visitor).visitProg(this);
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
			do {
				{
				{
				setState(8);
				((ProgContext)_localctx).func = func();
				((ProgContext)_localctx).funtz.add(((ProgContext)_localctx).func);
				}
				}
				setState(11); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__0 );
			setState(13);
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

	public static class FuncContext extends ParserRuleContext {
		public Token ald;
		public StatementContext statement;
		public List<StatementContext> stmts = new ArrayList<StatementContext>();
		public TerminalNode ALDAGAIA() { return getToken(MakroprogramaParser.ALDAGAIA, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public FuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakroprogramaVisitor ) return ((MakroprogramaVisitor<? extends T>)visitor).visitFunc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncContext func() throws RecognitionException {
		FuncContext _localctx = new FuncContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_func);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(15);
			match(T__0);
			setState(16);
			((FuncContext)_localctx).ald = match(ALDAGAIA);
			setState(18);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(17);
				match(T__1);
				}
			}

			setState(20);
			match(T__2);
			setState(24);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__9) | (1L << ALDAGAIA))) != 0)) {
				{
				{
				setState(21);
				((FuncContext)_localctx).statement = statement();
				((FuncContext)_localctx).stmts.add(((FuncContext)_localctx).statement);
				}
				}
				setState(26);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(27);
			match(T__3);
			setState(28);
			match(T__4);
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
		public TerminalNode ALDAGAIA() { return getToken(MakroprogramaParser.ALDAGAIA, 0); }
		public AdierazpenaContext adierazpena() {
			return getRuleContext(AdierazpenaContext.class,0);
		}
		public EsleipenContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakroprogramaVisitor ) return ((MakroprogramaVisitor<? extends T>)visitor).visitEsleipen(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WhileContext extends StatementContext {
		public AdierazpenaContext bald;
		public StatementContext statement;
		public List<StatementContext> stmts = new ArrayList<StatementContext>();
		public AdierazpenaContext adierazpena() {
			return getRuleContext(AdierazpenaContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public WhileContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakroprogramaVisitor ) return ((MakroprogramaVisitor<? extends T>)visitor).visitWhile(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfContext extends StatementContext {
		public AdierazpenaContext bald;
		public StatementContext statement;
		public List<StatementContext> stmts = new ArrayList<StatementContext>();
		public List<StatementContext> falseStmts = new ArrayList<StatementContext>();
		public AdierazpenaContext adierazpena() {
			return getRuleContext(AdierazpenaContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public IfContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakroprogramaVisitor ) return ((MakroprogramaVisitor<? extends T>)visitor).visitIf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		int _la;
		try {
			setState(68);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				_localctx = new IfContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(30);
				match(T__5);
				setState(31);
				((IfContext)_localctx).bald = adierazpena(0);
				setState(32);
				match(T__6);
				setState(36);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__9) | (1L << ALDAGAIA))) != 0)) {
					{
					{
					setState(33);
					((IfContext)_localctx).statement = statement();
					((IfContext)_localctx).stmts.add(((IfContext)_localctx).statement);
					}
					}
					setState(38);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(46);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__7) {
					{
					setState(39);
					match(T__7);
					setState(43);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__9) | (1L << ALDAGAIA))) != 0)) {
						{
						{
						setState(40);
						((IfContext)_localctx).statement = statement();
						((IfContext)_localctx).falseStmts.add(((IfContext)_localctx).statement);
						}
						}
						setState(45);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(48);
				match(T__8);
				setState(49);
				match(T__4);
				}
				break;
			case T__9:
				_localctx = new WhileContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(51);
				match(T__9);
				setState(52);
				((WhileContext)_localctx).bald = adierazpena(0);
				setState(53);
				match(T__10);
				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__9) | (1L << ALDAGAIA))) != 0)) {
					{
					{
					setState(54);
					((WhileContext)_localctx).statement = statement();
					((WhileContext)_localctx).stmts.add(((WhileContext)_localctx).statement);
					}
					}
					setState(59);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(60);
				match(T__11);
				setState(61);
				match(T__4);
				}
				break;
			case ALDAGAIA:
				_localctx = new EsleipenContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(63);
				((EsleipenContext)_localctx).ald = match(ALDAGAIA);
				setState(64);
				match(T__12);
				setState(65);
				((EsleipenContext)_localctx).ad = adierazpena(0);
				setState(66);
				match(T__4);
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
	public static class HitzaContext extends AdierazpenaContext {
		public Token hitz;
		public TerminalNode HITZA() { return getToken(MakroprogramaParser.HITZA, 0); }
		public HitzaContext(AdierazpenaContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakroprogramaVisitor ) return ((MakroprogramaVisitor<? extends T>)visitor).visitHitza(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AldagaiaContext extends AdierazpenaContext {
		public Token ald;
		public TerminalNode ALDAGAIA() { return getToken(MakroprogramaParser.ALDAGAIA, 0); }
		public AldagaiaContext(AdierazpenaContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakroprogramaVisitor ) return ((MakroprogramaVisitor<? extends T>)visitor).visitAldagaia(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class HutsaContext extends AdierazpenaContext {
		public HutsaContext(AdierazpenaContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakroprogramaVisitor ) return ((MakroprogramaVisitor<? extends T>)visitor).visitHutsa(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CarContext extends AdierazpenaContext {
		public Token car;
		public AdierazpenaContext ad;
		public TerminalNode CARX() { return getToken(MakroprogramaParser.CARX, 0); }
		public AdierazpenaContext adierazpena() {
			return getRuleContext(AdierazpenaContext.class,0);
		}
		public CarContext(AdierazpenaContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakroprogramaVisitor ) return ((MakroprogramaVisitor<? extends T>)visitor).visitCar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FuntzioDeiaContext extends AdierazpenaContext {
		public Token ald;
		public AdierazpenaContext adierazpena;
		public List<AdierazpenaContext> arg = new ArrayList<AdierazpenaContext>();
		public TerminalNode ALDAGAIA() { return getToken(MakroprogramaParser.ALDAGAIA, 0); }
		public List<AdierazpenaContext> adierazpena() {
			return getRuleContexts(AdierazpenaContext.class);
		}
		public AdierazpenaContext adierazpena(int i) {
			return getRuleContext(AdierazpenaContext.class,i);
		}
		public FuntzioDeiaContext(AdierazpenaContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakroprogramaVisitor ) return ((MakroprogramaVisitor<? extends T>)visitor).visitFuntzioDeia(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DeskodContext extends AdierazpenaContext {
		public Token deskod;
		public AdierazpenaContext ad;
		public TerminalNode DESKOD() { return getToken(MakroprogramaParser.DESKOD, 0); }
		public AdierazpenaContext adierazpena() {
			return getRuleContext(AdierazpenaContext.class,0);
		}
		public DeskodContext(AdierazpenaContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakroprogramaVisitor ) return ((MakroprogramaVisitor<? extends T>)visitor).visitDeskod(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotAdierazpenaContext extends AdierazpenaContext {
		public AdierazpenaContext ad;
		public AdierazpenaContext adierazpena() {
			return getRuleContext(AdierazpenaContext.class,0);
		}
		public NotAdierazpenaContext(AdierazpenaContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakroprogramaVisitor ) return ((MakroprogramaVisitor<? extends T>)visitor).visitNotAdierazpena(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AlderaketakContext extends AdierazpenaContext {
		public AdierazpenaContext ad;
		public Token erag;
		public List<AdierazpenaContext> adierazpena() {
			return getRuleContexts(AdierazpenaContext.class);
		}
		public AdierazpenaContext adierazpena(int i) {
			return getRuleContext(AdierazpenaContext.class,i);
		}
		public TerminalNode ERAG() { return getToken(MakroprogramaParser.ERAG, 0); }
		public AlderaketakContext(AdierazpenaContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakroprogramaVisitor ) return ((MakroprogramaVisitor<? extends T>)visitor).visitAlderaketak(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConsContext extends AdierazpenaContext {
		public Token cons;
		public AdierazpenaContext ad;
		public TerminalNode CONSX() { return getToken(MakroprogramaParser.CONSX, 0); }
		public AdierazpenaContext adierazpena() {
			return getRuleContext(AdierazpenaContext.class,0);
		}
		public ConsContext(AdierazpenaContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MakroprogramaVisitor ) return ((MakroprogramaVisitor<? extends T>)visitor).visitCons(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AdierazpenaContext adierazpena() throws RecognitionException {
		return adierazpena(0);
	}

	private AdierazpenaContext adierazpena(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AdierazpenaContext _localctx = new AdierazpenaContext(_ctx, _parentState);
		AdierazpenaContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_adierazpena, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				_localctx = new HutsaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(71);
				match(T__13);
				}
				break;
			case 2:
				{
				_localctx = new ConsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(72);
				((ConsContext)_localctx).cons = match(CONSX);
				setState(73);
				match(T__14);
				setState(74);
				((ConsContext)_localctx).ad = adierazpena(0);
				setState(75);
				match(T__15);
				}
				break;
			case 3:
				{
				_localctx = new CarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(77);
				((CarContext)_localctx).car = match(CARX);
				setState(78);
				match(T__1);
				setState(79);
				match(T__14);
				setState(80);
				((CarContext)_localctx).ad = adierazpena(0);
				setState(81);
				match(T__15);
				}
				break;
			case 4:
				{
				_localctx = new DeskodContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(83);
				((DeskodContext)_localctx).deskod = match(DESKOD);
				setState(84);
				match(T__14);
				setState(85);
				((DeskodContext)_localctx).ad = adierazpena(0);
				setState(86);
				match(T__15);
				}
				break;
			case 5:
				{
				_localctx = new HitzaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(88);
				((HitzaContext)_localctx).hitz = match(HITZA);
				}
				break;
			case 6:
				{
				_localctx = new AldagaiaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(89);
				((AldagaiaContext)_localctx).ald = match(ALDAGAIA);
				}
				break;
			case 7:
				{
				_localctx = new FuntzioDeiaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(90);
				((FuntzioDeiaContext)_localctx).ald = match(ALDAGAIA);
				setState(92);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(91);
					match(T__1);
					}
				}

				setState(94);
				match(T__14);
				setState(103);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << T__17) | (1L << HITZA) | (1L << CONSX) | (1L << CARX) | (1L << DESKOD) | (1L << ALDAGAIA))) != 0)) {
					{
					setState(95);
					((FuntzioDeiaContext)_localctx).adierazpena = adierazpena(0);
					((FuntzioDeiaContext)_localctx).arg.add(((FuntzioDeiaContext)_localctx).adierazpena);
					setState(100);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__16) {
						{
						{
						setState(96);
						match(T__16);
						setState(97);
						((FuntzioDeiaContext)_localctx).adierazpena = adierazpena(0);
						((FuntzioDeiaContext)_localctx).arg.add(((FuntzioDeiaContext)_localctx).adierazpena);
						}
						}
						setState(102);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(105);
				match(T__15);
				}
				break;
			case 8:
				{
				_localctx = new NotAdierazpenaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(106);
				match(T__17);
				setState(107);
				((NotAdierazpenaContext)_localctx).ad = adierazpena(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(115);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AlderaketakContext(new AdierazpenaContext(_parentctx, _parentState));
					((AlderaketakContext)_localctx).ad = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_adierazpena);
					setState(110);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(111);
					((AlderaketakContext)_localctx).erag = match(ERAG);
					setState(112);
					((AlderaketakContext)_localctx).ad = adierazpena(3);
					}
					} 
				}
				setState(117);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 3:
			return adierazpena_sempred((AdierazpenaContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean adierazpena_sempred(AdierazpenaContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\34y\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\3\2\6\2\f\n\2\r\2\16\2\r\3\2\3\2\3\3\3\3\3\3\5\3\25"+
		"\n\3\3\3\3\3\7\3\31\n\3\f\3\16\3\34\13\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\7"+
		"\4%\n\4\f\4\16\4(\13\4\3\4\3\4\7\4,\n\4\f\4\16\4/\13\4\5\4\61\n\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\7\4:\n\4\f\4\16\4=\13\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\5\4G\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5_\n\5\3\5\3\5\3\5\3\5\7\5e\n"+
		"\5\f\5\16\5h\13\5\5\5j\n\5\3\5\3\5\3\5\5\5o\n\5\3\5\3\5\3\5\7\5t\n\5\f"+
		"\5\16\5w\13\5\3\5\2\3\b\6\2\4\6\b\2\2\2\u0088\2\13\3\2\2\2\4\21\3\2\2"+
		"\2\6F\3\2\2\2\bn\3\2\2\2\n\f\5\4\3\2\13\n\3\2\2\2\f\r\3\2\2\2\r\13\3\2"+
		"\2\2\r\16\3\2\2\2\16\17\3\2\2\2\17\20\7\2\2\3\20\3\3\2\2\2\21\22\7\3\2"+
		"\2\22\24\7\32\2\2\23\25\7\4\2\2\24\23\3\2\2\2\24\25\3\2\2\2\25\26\3\2"+
		"\2\2\26\32\7\5\2\2\27\31\5\6\4\2\30\27\3\2\2\2\31\34\3\2\2\2\32\30\3\2"+
		"\2\2\32\33\3\2\2\2\33\35\3\2\2\2\34\32\3\2\2\2\35\36\7\6\2\2\36\37\7\7"+
		"\2\2\37\5\3\2\2\2 !\7\b\2\2!\"\5\b\5\2\"&\7\t\2\2#%\5\6\4\2$#\3\2\2\2"+
		"%(\3\2\2\2&$\3\2\2\2&\'\3\2\2\2\'\60\3\2\2\2(&\3\2\2\2)-\7\n\2\2*,\5\6"+
		"\4\2+*\3\2\2\2,/\3\2\2\2-+\3\2\2\2-.\3\2\2\2.\61\3\2\2\2/-\3\2\2\2\60"+
		")\3\2\2\2\60\61\3\2\2\2\61\62\3\2\2\2\62\63\7\13\2\2\63\64\7\7\2\2\64"+
		"G\3\2\2\2\65\66\7\f\2\2\66\67\5\b\5\2\67;\7\r\2\28:\5\6\4\298\3\2\2\2"+
		":=\3\2\2\2;9\3\2\2\2;<\3\2\2\2<>\3\2\2\2=;\3\2\2\2>?\7\16\2\2?@\7\7\2"+
		"\2@G\3\2\2\2AB\7\32\2\2BC\7\17\2\2CD\5\b\5\2DE\7\7\2\2EG\3\2\2\2F \3\2"+
		"\2\2F\65\3\2\2\2FA\3\2\2\2G\7\3\2\2\2HI\b\5\1\2Io\7\20\2\2JK\7\27\2\2"+
		"KL\7\21\2\2LM\5\b\5\2MN\7\22\2\2No\3\2\2\2OP\7\30\2\2PQ\7\4\2\2QR\7\21"+
		"\2\2RS\5\b\5\2ST\7\22\2\2To\3\2\2\2UV\7\31\2\2VW\7\21\2\2WX\5\b\5\2XY"+
		"\7\22\2\2Yo\3\2\2\2Zo\7\26\2\2[o\7\32\2\2\\^\7\32\2\2]_\7\4\2\2^]\3\2"+
		"\2\2^_\3\2\2\2_`\3\2\2\2`i\7\21\2\2af\5\b\5\2bc\7\23\2\2ce\5\b\5\2db\3"+
		"\2\2\2eh\3\2\2\2fd\3\2\2\2fg\3\2\2\2gj\3\2\2\2hf\3\2\2\2ia\3\2\2\2ij\3"+
		"\2\2\2jk\3\2\2\2ko\7\22\2\2lm\7\24\2\2mo\5\b\5\3nH\3\2\2\2nJ\3\2\2\2n"+
		"O\3\2\2\2nU\3\2\2\2nZ\3\2\2\2n[\3\2\2\2n\\\3\2\2\2nl\3\2\2\2ou\3\2\2\2"+
		"pq\f\4\2\2qr\7\25\2\2rt\5\b\5\5sp\3\2\2\2tw\3\2\2\2us\3\2\2\2uv\3\2\2"+
		"\2v\t\3\2\2\2wu\3\2\2\2\17\r\24\32&-\60;F^finu";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}