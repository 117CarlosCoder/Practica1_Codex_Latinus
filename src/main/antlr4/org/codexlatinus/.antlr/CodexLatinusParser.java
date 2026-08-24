// Generated from c:\Users\calin\Documents\Compi 2\CodexLatinus\src\main\antlr4\org\codexlatinus\CodexLatinus.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CodexLatinusParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, T__50=51, T__51=52, 
		T__52=53, T__53=54, T__54=55, T__55=56, T__56=57, BOOL_LITERAL=58, INT_LITERAL=59, 
		DOUBLE_LITERAL=60, STRING_LITERAL=61, CHAR_LITERAL=62, Identifier=63, 
		WS=64, LINE_COMMENT=65, BLOCK_COMMENT=66;
	public static final int
		RULE_program = 0, RULE_globalVarsSection = 1, RULE_functionsSection = 2, 
		RULE_mainSection = 3, RULE_varDecl = 4, RULE_arrayDecl = 5, RULE_arrayInit = 6, 
		RULE_structDecl = 7, RULE_structMember = 8, RULE_structInit = 9, RULE_structVarDecl = 10, 
		RULE_structAttrAssignList = 11, RULE_structAttrAssign = 12, RULE_primitiveType = 13, 
		RULE_functionDecl = 14, RULE_funcVarSection = 15, RULE_formalParameters = 16, 
		RULE_formalParameter = 17, RULE_statement = 18, RULE_blockStmt = 19, RULE_ifStmt = 20, 
		RULE_whileStmt = 21, RULE_doWhileStmt = 22, RULE_forStmt = 23, RULE_forInit = 24, 
		RULE_forUpdate = 25, RULE_returnStmt = 26, RULE_breakStmt = 27, RULE_continueStmt = 28, 
		RULE_printStmt = 29, RULE_readStmt = 30, RULE_assignStmt = 31, RULE_lvalue = 32, 
		RULE_exprStmt = 33, RULE_expr = 34, RULE_exprList = 35, RULE_arguments = 36, 
		RULE_primary = 37, RULE_literal = 38;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "globalVarsSection", "functionsSection", "mainSection", "varDecl", 
			"arrayDecl", "arrayInit", "structDecl", "structMember", "structInit", 
			"structVarDecl", "structAttrAssignList", "structAttrAssign", "primitiveType", 
			"functionDecl", "funcVarSection", "formalParameters", "formalParameter", 
			"statement", "blockStmt", "ifStmt", "whileStmt", "doWhileStmt", "forStmt", 
			"forInit", "forUpdate", "returnStmt", "breakStmt", "continueStmt", "printStmt", 
			"readStmt", "assignStmt", "lvalue", "exprStmt", "expr", "exprList", "arguments", 
			"primary", "literal"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'VARIABILES>'", "'MUNERA>'", "'MAIOR>'", "'FINIS'", "';'", "'finis'", 
			"'esto'", "':'", "'='", "'series'", "'['", "']'", "'{'", "'}'", "'('", 
			"')'", "'structura'", "','", "'numerus'", "'decimalis'", "'textum'", 
			"'littera'", "'bool'", "'boolean'", "'actio'", "'ratio'", "'void'", "'VARIABILES['", 
			"'si'", "'aliter'", "'dum'", "'facere'", "'per'", "'++'", "'--'", "'reddere'", 
			"'interrumpe'", "'perge'", "'>>'", "'<<'", "'.'", "'non'", "'!'", "'+'", 
			"'-'", "'*'", "'/'", "'%'", "'<'", "'>'", "'<='", "'>='", "'==='", "'=='", 
			"'!='", "'&&'", "'||'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, "BOOL_LITERAL", 
			"INT_LITERAL", "DOUBLE_LITERAL", "STRING_LITERAL", "CHAR_LITERAL", "Identifier", 
			"WS", "LINE_COMMENT", "BLOCK_COMMENT"
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

	@Override
	public String getGrammarFileName() { return "CodexLatinus.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CodexLatinusParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public MainSectionContext mainSection() {
			return getRuleContext(MainSectionContext.class,0);
		}
		public TerminalNode EOF() { return getToken(CodexLatinusParser.EOF, 0); }
		public GlobalVarsSectionContext globalVarsSection() {
			return getRuleContext(GlobalVarsSectionContext.class,0);
		}
		public FunctionsSectionContext functionsSection() {
			return getRuleContext(FunctionsSectionContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(78);
				globalVarsSection();
				}
			}

			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(81);
				functionsSection();
				}
			}

			setState(84);
			mainSection();
			setState(85);
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

	public static class GlobalVarsSectionContext extends ParserRuleContext {
		public List<VarDeclContext> varDecl() {
			return getRuleContexts(VarDeclContext.class);
		}
		public VarDeclContext varDecl(int i) {
			return getRuleContext(VarDeclContext.class,i);
		}
		public List<ArrayDeclContext> arrayDecl() {
			return getRuleContexts(ArrayDeclContext.class);
		}
		public ArrayDeclContext arrayDecl(int i) {
			return getRuleContext(ArrayDeclContext.class,i);
		}
		public List<StructDeclContext> structDecl() {
			return getRuleContexts(StructDeclContext.class);
		}
		public StructDeclContext structDecl(int i) {
			return getRuleContext(StructDeclContext.class,i);
		}
		public List<StructVarDeclContext> structVarDecl() {
			return getRuleContexts(StructVarDeclContext.class);
		}
		public StructVarDeclContext structVarDecl(int i) {
			return getRuleContext(StructVarDeclContext.class,i);
		}
		public GlobalVarsSectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_globalVarsSection; }
	}

	public final GlobalVarsSectionContext globalVarsSection() throws RecognitionException {
		GlobalVarsSectionContext _localctx = new GlobalVarsSectionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_globalVarsSection);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(T__0);
			setState(94);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__9) | (1L << T__16))) != 0)) {
				{
				setState(92);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(88);
					varDecl();
					}
					break;
				case 2:
					{
					setState(89);
					arrayDecl();
					}
					break;
				case 3:
					{
					setState(90);
					structDecl();
					}
					break;
				case 4:
					{
					setState(91);
					structVarDecl();
					}
					break;
				}
				}
				setState(96);
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

	public static class FunctionsSectionContext extends ParserRuleContext {
		public List<FunctionDeclContext> functionDecl() {
			return getRuleContexts(FunctionDeclContext.class);
		}
		public FunctionDeclContext functionDecl(int i) {
			return getRuleContext(FunctionDeclContext.class,i);
		}
		public FunctionsSectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionsSection; }
	}

	public final FunctionsSectionContext functionsSection() throws RecognitionException {
		FunctionsSectionContext _localctx = new FunctionsSectionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_functionsSection);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			match(T__1);
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__24 || _la==T__25) {
				{
				{
				setState(98);
				functionDecl();
				}
				}
				setState(103);
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

	public static class MainSectionContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public MainSectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mainSection; }
	}

	public final MainSectionContext mainSection() throws RecognitionException {
		MainSectionContext _localctx = new MainSectionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_mainSection);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			match(T__2);
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__9) | (1L << T__12) | (1L << T__14) | (1L << T__16) | (1L << T__28) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << BOOL_LITERAL) | (1L << INT_LITERAL) | (1L << DOUBLE_LITERAL) | (1L << STRING_LITERAL) | (1L << CHAR_LITERAL) | (1L << Identifier))) != 0)) {
				{
				{
				setState(105);
				statement();
				}
				}
				setState(110);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(117);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				{
				setState(111);
				match(T__3);
				setState(113);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__4) {
					{
					setState(112);
					match(T__4);
					}
				}

				}
				break;
			case T__5:
				{
				setState(115);
				match(T__5);
				setState(116);
				match(T__4);
				}
				break;
			case EOF:
				break;
			default:
				break;
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

	public static class VarDeclContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(CodexLatinusParser.Identifier, 0); }
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public VarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecl; }
	}

	public final VarDeclContext varDecl() throws RecognitionException {
		VarDeclContext _localctx = new VarDeclContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_varDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(T__6);
			setState(120);
			match(Identifier);
			setState(121);
			match(T__7);
			setState(122);
			primitiveType();
			setState(127);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(124);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__8) {
					{
					setState(123);
					match(T__8);
					}
				}

				setState(126);
				expr(0);
				}
				break;
			}
			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(129);
				match(T__4);
				}
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

	public static class ArrayDeclContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(CodexLatinusParser.Identifier, 0); }
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public ArrayInitContext arrayInit() {
			return getRuleContext(ArrayInitContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ArrayDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayDecl; }
	}

	public final ArrayDeclContext arrayDecl() throws RecognitionException {
		ArrayDeclContext _localctx = new ArrayDeclContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_arrayDecl);
		int _la;
		try {
			setState(168);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(132);
				match(T__9);
				setState(133);
				match(Identifier);
				setState(139);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__10) {
					{
					setState(134);
					match(T__10);
					setState(136);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << T__14) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << BOOL_LITERAL) | (1L << INT_LITERAL) | (1L << DOUBLE_LITERAL) | (1L << STRING_LITERAL) | (1L << CHAR_LITERAL) | (1L << Identifier))) != 0)) {
						{
						setState(135);
						expr(0);
						}
					}

					setState(138);
					match(T__11);
					}
				}

				setState(143);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__7) {
					{
					setState(141);
					match(T__7);
					setState(142);
					primitiveType();
					}
				}

				setState(149);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(146);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__8) {
						{
						setState(145);
						match(T__8);
						}
					}

					setState(148);
					arrayInit();
					}
					break;
				}
				setState(152);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__4) {
					{
					setState(151);
					match(T__4);
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(154);
				match(T__9);
				setState(155);
				match(Identifier);
				setState(161);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__10) {
					{
					setState(156);
					match(T__10);
					setState(158);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << T__14) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << BOOL_LITERAL) | (1L << INT_LITERAL) | (1L << DOUBLE_LITERAL) | (1L << STRING_LITERAL) | (1L << CHAR_LITERAL) | (1L << Identifier))) != 0)) {
						{
						setState(157);
						expr(0);
						}
					}

					setState(160);
					match(T__11);
					}
				}

				setState(163);
				match(T__7);
				setState(164);
				arrayInit();
				setState(166);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__4) {
					{
					setState(165);
					match(T__4);
					}
				}

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

	public static class ArrayInitContext extends ParserRuleContext {
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public ArrayInitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayInit; }
	}

	public final ArrayInitContext arrayInit() throws RecognitionException {
		ArrayInitContext _localctx = new ArrayInitContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_arrayInit);
		int _la;
		try {
			setState(180);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__12:
				enterOuterAlt(_localctx, 1);
				{
				setState(170);
				match(T__12);
				setState(172);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << T__14) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << BOOL_LITERAL) | (1L << INT_LITERAL) | (1L << DOUBLE_LITERAL) | (1L << STRING_LITERAL) | (1L << CHAR_LITERAL) | (1L << Identifier))) != 0)) {
					{
					setState(171);
					exprList();
					}
				}

				setState(174);
				match(T__13);
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 2);
				{
				setState(175);
				match(T__14);
				setState(177);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << T__14) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << BOOL_LITERAL) | (1L << INT_LITERAL) | (1L << DOUBLE_LITERAL) | (1L << STRING_LITERAL) | (1L << CHAR_LITERAL) | (1L << Identifier))) != 0)) {
					{
					setState(176);
					exprList();
					}
				}

				setState(179);
				match(T__15);
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

	public static class StructDeclContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(CodexLatinusParser.Identifier, 0); }
		public List<StructMemberContext> structMember() {
			return getRuleContexts(StructMemberContext.class);
		}
		public StructMemberContext structMember(int i) {
			return getRuleContext(StructMemberContext.class,i);
		}
		public StructDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structDecl; }
	}

	public final StructDeclContext structDecl() throws RecognitionException {
		StructDeclContext _localctx = new StructDeclContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_structDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			match(T__16);
			setState(183);
			match(Identifier);
			setState(184);
			match(T__12);
			setState(188);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__9) | (1L << Identifier))) != 0)) {
				{
				{
				setState(185);
				structMember();
				}
				}
				setState(190);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(191);
			match(T__13);
			setState(197);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				{
				setState(192);
				match(T__5);
				setState(194);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__4) {
					{
					setState(193);
					match(T__4);
					}
				}

				}
				break;
			case 2:
				{
				setState(196);
				match(T__4);
				}
				break;
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

	public static class StructMemberContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(CodexLatinusParser.Identifier, 0); }
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StructMemberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structMember; }
	}

	public final StructMemberContext structMember() throws RecognitionException {
		StructMemberContext _localctx = new StructMemberContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_structMember);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6 || _la==T__9) {
				{
				setState(199);
				_la = _input.LA(1);
				if ( !(_la==T__6 || _la==T__9) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(202);
			match(Identifier);
			setState(208);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(203);
				match(T__10);
				setState(205);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << T__14) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << BOOL_LITERAL) | (1L << INT_LITERAL) | (1L << DOUBLE_LITERAL) | (1L << STRING_LITERAL) | (1L << CHAR_LITERAL) | (1L << Identifier))) != 0)) {
					{
					setState(204);
					expr(0);
					}
				}

				setState(207);
				match(T__11);
				}
			}

			setState(210);
			match(T__7);
			setState(211);
			primitiveType();
			setState(213);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4 || _la==T__17) {
				{
				setState(212);
				_la = _input.LA(1);
				if ( !(_la==T__4 || _la==T__17) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
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

	public static class StructInitContext extends ParserRuleContext {
		public StructAttrAssignListContext structAttrAssignList() {
			return getRuleContext(StructAttrAssignListContext.class,0);
		}
		public StructInitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structInit; }
	}

	public final StructInitContext structInit() throws RecognitionException {
		StructInitContext _localctx = new StructInitContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_structInit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			match(T__12);
			setState(217);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(216);
				structAttrAssignList();
				}
			}

			setState(219);
			match(T__13);
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

	public static class StructVarDeclContext extends ParserRuleContext {
		public List<TerminalNode> Identifier() { return getTokens(CodexLatinusParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(CodexLatinusParser.Identifier, i);
		}
		public StructInitContext structInit() {
			return getRuleContext(StructInitContext.class,0);
		}
		public StructVarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structVarDecl; }
	}

	public final StructVarDeclContext structVarDecl() throws RecognitionException {
		StructVarDeclContext _localctx = new StructVarDeclContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_structVarDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			match(T__6);
			setState(222);
			match(Identifier);
			setState(223);
			match(T__7);
			setState(224);
			match(Identifier);
			setState(229);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				{
				setState(226);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__8) {
					{
					setState(225);
					match(T__8);
					}
				}

				setState(228);
				structInit();
				}
				break;
			}
			setState(232);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(231);
				match(T__4);
				}
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

	public static class StructAttrAssignListContext extends ParserRuleContext {
		public List<StructAttrAssignContext> structAttrAssign() {
			return getRuleContexts(StructAttrAssignContext.class);
		}
		public StructAttrAssignContext structAttrAssign(int i) {
			return getRuleContext(StructAttrAssignContext.class,i);
		}
		public StructAttrAssignListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structAttrAssignList; }
	}

	public final StructAttrAssignListContext structAttrAssignList() throws RecognitionException {
		StructAttrAssignListContext _localctx = new StructAttrAssignListContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_structAttrAssignList);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			structAttrAssign();
			setState(239);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(235);
					_la = _input.LA(1);
					if ( !(_la==T__4 || _la==T__17) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(236);
					structAttrAssign();
					}
					} 
				}
				setState(241);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			}
			setState(243);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4 || _la==T__17) {
				{
				setState(242);
				_la = _input.LA(1);
				if ( !(_la==T__4 || _la==T__17) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
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

	public static class StructAttrAssignContext extends ParserRuleContext {
		public List<TerminalNode> Identifier() { return getTokens(CodexLatinusParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(CodexLatinusParser.Identifier, i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StructInitContext structInit() {
			return getRuleContext(StructInitContext.class,0);
		}
		public ArrayInitContext arrayInit() {
			return getRuleContext(ArrayInitContext.class,0);
		}
		public StructAttrAssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structAttrAssign; }
	}

	public final StructAttrAssignContext structAttrAssign() throws RecognitionException {
		StructAttrAssignContext _localctx = new StructAttrAssignContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_structAttrAssign);
		int _la;
		try {
			setState(266);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(245);
				match(Identifier);
				setState(246);
				match(T__7);
				setState(261);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
				case 1:
					{
					setState(247);
					match(Identifier);
					setState(248);
					match(T__10);
					setState(249);
					expr(0);
					setState(250);
					match(T__11);
					setState(258);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__12) | (1L << T__14))) != 0)) {
						{
						setState(252);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==T__8) {
							{
							setState(251);
							match(T__8);
							}
						}

						setState(256);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
						case 1:
							{
							setState(254);
							structInit();
							}
							break;
						case 2:
							{
							setState(255);
							arrayInit();
							}
							break;
						}
						}
					}

					}
					break;
				case 2:
					{
					setState(260);
					expr(0);
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(263);
				match(Identifier);
				setState(264);
				match(T__8);
				setState(265);
				expr(0);
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

	public static class PrimitiveTypeContext extends ParserRuleContext {
		public TerminalNode BOOL_LITERAL() { return getToken(CodexLatinusParser.BOOL_LITERAL, 0); }
		public TerminalNode Identifier() { return getToken(CodexLatinusParser.Identifier, 0); }
		public PrimitiveTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitiveType; }
	}

	public final PrimitiveTypeContext primitiveType() throws RecognitionException {
		PrimitiveTypeContext _localctx = new PrimitiveTypeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_primitiveType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << BOOL_LITERAL) | (1L << Identifier))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class FunctionDeclContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(CodexLatinusParser.Identifier, 0); }
		public FormalParametersContext formalParameters() {
			return getRuleContext(FormalParametersContext.class,0);
		}
		public FuncVarSectionContext funcVarSection() {
			return getRuleContext(FuncVarSectionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public FunctionDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDecl; }
	}

	public final FunctionDeclContext functionDecl() throws RecognitionException {
		FunctionDeclContext _localctx = new FunctionDeclContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_functionDecl);
		int _la;
		try {
			setState(322);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__24:
				enterOuterAlt(_localctx, 1);
				{
				setState(270);
				match(T__24);
				setState(271);
				match(Identifier);
				setState(272);
				match(T__14);
				setState(274);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__6) {
					{
					setState(273);
					formalParameters();
					}
				}

				setState(276);
				match(T__15);
				setState(277);
				match(T__12);
				setState(279);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__27) {
					{
					setState(278);
					funcVarSection();
					}
				}

				setState(284);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__9) | (1L << T__12) | (1L << T__14) | (1L << T__16) | (1L << T__28) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << BOOL_LITERAL) | (1L << INT_LITERAL) | (1L << DOUBLE_LITERAL) | (1L << STRING_LITERAL) | (1L << CHAR_LITERAL) | (1L << Identifier))) != 0)) {
					{
					{
					setState(281);
					statement();
					}
					}
					setState(286);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(287);
				match(T__13);
				setState(292);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__5) {
					{
					setState(288);
					match(T__5);
					setState(290);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__4) {
						{
						setState(289);
						match(T__4);
						}
					}

					}
				}

				}
				break;
			case T__25:
				enterOuterAlt(_localctx, 2);
				{
				setState(294);
				match(T__25);
				setState(297);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__18:
				case T__19:
				case T__20:
				case T__21:
				case T__22:
				case T__23:
				case BOOL_LITERAL:
				case Identifier:
					{
					setState(295);
					primitiveType();
					}
					break;
				case T__26:
					{
					setState(296);
					match(T__26);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(299);
				match(Identifier);
				setState(300);
				match(T__14);
				setState(302);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__6) {
					{
					setState(301);
					formalParameters();
					}
				}

				setState(304);
				match(T__15);
				setState(305);
				match(T__12);
				setState(307);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__27) {
					{
					setState(306);
					funcVarSection();
					}
				}

				setState(312);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__9) | (1L << T__12) | (1L << T__14) | (1L << T__16) | (1L << T__28) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << BOOL_LITERAL) | (1L << INT_LITERAL) | (1L << DOUBLE_LITERAL) | (1L << STRING_LITERAL) | (1L << CHAR_LITERAL) | (1L << Identifier))) != 0)) {
					{
					{
					setState(309);
					statement();
					}
					}
					setState(314);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(315);
				match(T__13);
				setState(320);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__5) {
					{
					setState(316);
					match(T__5);
					setState(318);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__4) {
						{
						setState(317);
						match(T__4);
						}
					}

					}
				}

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

	public static class FuncVarSectionContext extends ParserRuleContext {
		public List<VarDeclContext> varDecl() {
			return getRuleContexts(VarDeclContext.class);
		}
		public VarDeclContext varDecl(int i) {
			return getRuleContext(VarDeclContext.class,i);
		}
		public List<ArrayDeclContext> arrayDecl() {
			return getRuleContexts(ArrayDeclContext.class);
		}
		public ArrayDeclContext arrayDecl(int i) {
			return getRuleContext(ArrayDeclContext.class,i);
		}
		public List<StructDeclContext> structDecl() {
			return getRuleContexts(StructDeclContext.class);
		}
		public StructDeclContext structDecl(int i) {
			return getRuleContext(StructDeclContext.class,i);
		}
		public List<StructVarDeclContext> structVarDecl() {
			return getRuleContexts(StructVarDeclContext.class);
		}
		public StructVarDeclContext structVarDecl(int i) {
			return getRuleContext(StructVarDeclContext.class,i);
		}
		public FuncVarSectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcVarSection; }
	}

	public final FuncVarSectionContext funcVarSection() throws RecognitionException {
		FuncVarSectionContext _localctx = new FuncVarSectionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_funcVarSection);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(324);
			match(T__27);
			setState(331);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__9) | (1L << T__16))) != 0)) {
				{
				setState(329);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
				case 1:
					{
					setState(325);
					varDecl();
					}
					break;
				case 2:
					{
					setState(326);
					arrayDecl();
					}
					break;
				case 3:
					{
					setState(327);
					structDecl();
					}
					break;
				case 4:
					{
					setState(328);
					structVarDecl();
					}
					break;
				}
				}
				setState(333);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(334);
			match(T__11);
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

	public static class FormalParametersContext extends ParserRuleContext {
		public List<FormalParameterContext> formalParameter() {
			return getRuleContexts(FormalParameterContext.class);
		}
		public FormalParameterContext formalParameter(int i) {
			return getRuleContext(FormalParameterContext.class,i);
		}
		public FormalParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameters; }
	}

	public final FormalParametersContext formalParameters() throws RecognitionException {
		FormalParametersContext _localctx = new FormalParametersContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_formalParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(336);
			formalParameter();
			setState(341);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__17) {
				{
				{
				setState(337);
				match(T__17);
				setState(338);
				formalParameter();
				}
				}
				setState(343);
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

	public static class FormalParameterContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(CodexLatinusParser.Identifier, 0); }
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public FormalParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameter; }
	}

	public final FormalParameterContext formalParameter() throws RecognitionException {
		FormalParameterContext _localctx = new FormalParameterContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_formalParameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(344);
			match(T__6);
			setState(345);
			match(Identifier);
			setState(346);
			match(T__7);
			setState(347);
			primitiveType();
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
		public BlockStmtContext blockStmt() {
			return getRuleContext(BlockStmtContext.class,0);
		}
		public VarDeclContext varDecl() {
			return getRuleContext(VarDeclContext.class,0);
		}
		public ArrayDeclContext arrayDecl() {
			return getRuleContext(ArrayDeclContext.class,0);
		}
		public StructDeclContext structDecl() {
			return getRuleContext(StructDeclContext.class,0);
		}
		public StructVarDeclContext structVarDecl() {
			return getRuleContext(StructVarDeclContext.class,0);
		}
		public IfStmtContext ifStmt() {
			return getRuleContext(IfStmtContext.class,0);
		}
		public WhileStmtContext whileStmt() {
			return getRuleContext(WhileStmtContext.class,0);
		}
		public DoWhileStmtContext doWhileStmt() {
			return getRuleContext(DoWhileStmtContext.class,0);
		}
		public ForStmtContext forStmt() {
			return getRuleContext(ForStmtContext.class,0);
		}
		public ReturnStmtContext returnStmt() {
			return getRuleContext(ReturnStmtContext.class,0);
		}
		public BreakStmtContext breakStmt() {
			return getRuleContext(BreakStmtContext.class,0);
		}
		public ContinueStmtContext continueStmt() {
			return getRuleContext(ContinueStmtContext.class,0);
		}
		public PrintStmtContext printStmt() {
			return getRuleContext(PrintStmtContext.class,0);
		}
		public ReadStmtContext readStmt() {
			return getRuleContext(ReadStmtContext.class,0);
		}
		public AssignStmtContext assignStmt() {
			return getRuleContext(AssignStmtContext.class,0);
		}
		public ExprStmtContext exprStmt() {
			return getRuleContext(ExprStmtContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_statement);
		try {
			setState(365);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(349);
				blockStmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(350);
				varDecl();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(351);
				arrayDecl();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(352);
				structDecl();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(353);
				structVarDecl();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(354);
				ifStmt();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(355);
				whileStmt();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(356);
				doWhileStmt();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(357);
				forStmt();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(358);
				returnStmt();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(359);
				breakStmt();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(360);
				continueStmt();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(361);
				printStmt();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(362);
				readStmt();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(363);
				assignStmt();
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(364);
				exprStmt();
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

	public static class BlockStmtContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockStmt; }
	}

	public final BlockStmtContext blockStmt() throws RecognitionException {
		BlockStmtContext _localctx = new BlockStmtContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_blockStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(367);
			match(T__12);
			setState(371);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__9) | (1L << T__12) | (1L << T__14) | (1L << T__16) | (1L << T__28) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << BOOL_LITERAL) | (1L << INT_LITERAL) | (1L << DOUBLE_LITERAL) | (1L << STRING_LITERAL) | (1L << CHAR_LITERAL) | (1L << Identifier))) != 0)) {
				{
				{
				setState(368);
				statement();
				}
				}
				setState(373);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(374);
			match(T__13);
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

	public static class IfStmtContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public IfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStmt; }
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_ifStmt);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(376);
			match(T__28);
			setState(377);
			match(T__14);
			setState(378);
			expr(0);
			setState(379);
			match(T__15);
			setState(380);
			match(T__12);
			setState(384);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__9) | (1L << T__12) | (1L << T__14) | (1L << T__16) | (1L << T__28) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << BOOL_LITERAL) | (1L << INT_LITERAL) | (1L << DOUBLE_LITERAL) | (1L << STRING_LITERAL) | (1L << CHAR_LITERAL) | (1L << Identifier))) != 0)) {
				{
				{
				setState(381);
				statement();
				}
				}
				setState(386);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(387);
			match(T__13);
			setState(406);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,62,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(388);
					match(T__29);
					setState(390);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__28) {
						{
						setState(389);
						match(T__28);
						}
					}

					setState(392);
					match(T__14);
					setState(393);
					expr(0);
					setState(394);
					match(T__15);
					setState(395);
					match(T__12);
					setState(399);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__9) | (1L << T__12) | (1L << T__14) | (1L << T__16) | (1L << T__28) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << BOOL_LITERAL) | (1L << INT_LITERAL) | (1L << DOUBLE_LITERAL) | (1L << STRING_LITERAL) | (1L << CHAR_LITERAL) | (1L << Identifier))) != 0)) {
						{
						{
						setState(396);
						statement();
						}
						}
						setState(401);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(402);
					match(T__13);
					}
					} 
				}
				setState(408);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,62,_ctx);
			}
			setState(418);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__29) {
				{
				setState(409);
				match(T__29);
				setState(410);
				match(T__12);
				setState(414);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__9) | (1L << T__12) | (1L << T__14) | (1L << T__16) | (1L << T__28) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << BOOL_LITERAL) | (1L << INT_LITERAL) | (1L << DOUBLE_LITERAL) | (1L << STRING_LITERAL) | (1L << CHAR_LITERAL) | (1L << Identifier))) != 0)) {
					{
					{
					setState(411);
					statement();
					}
					}
					setState(416);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(417);
				match(T__13);
				}
			}

			setState(424);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,66,_ctx) ) {
			case 1:
				{
				setState(420);
				match(T__5);
				setState(422);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__4) {
					{
					setState(421);
					match(T__4);
					}
				}

				}
				break;
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

	public static class WhileStmtContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public WhileStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStmt; }
	}

	public final WhileStmtContext whileStmt() throws RecognitionException {
		WhileStmtContext _localctx = new WhileStmtContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_whileStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(426);
			match(T__30);
			setState(427);
			match(T__14);
			setState(428);
			expr(0);
			setState(429);
			match(T__15);
			setState(430);
			match(T__12);
			setState(434);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__9) | (1L << T__12) | (1L << T__14) | (1L << T__16) | (1L << T__28) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << BOOL_LITERAL) | (1L << INT_LITERAL) | (1L << DOUBLE_LITERAL) | (1L << STRING_LITERAL) | (1L << CHAR_LITERAL) | (1L << Identifier))) != 0)) {
				{
				{
				setState(431);
				statement();
				}
				}
				setState(436);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(437);
			match(T__13);
			setState(442);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,69,_ctx) ) {
			case 1:
				{
				setState(438);
				match(T__5);
				setState(440);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__4) {
					{
					setState(439);
					match(T__4);
					}
				}

				}
				break;
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

	public static class DoWhileStmtContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public DoWhileStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doWhileStmt; }
	}

	public final DoWhileStmtContext doWhileStmt() throws RecognitionException {
		DoWhileStmtContext _localctx = new DoWhileStmtContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_doWhileStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(444);
			match(T__31);
			setState(445);
			match(T__12);
			setState(449);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__9) | (1L << T__12) | (1L << T__14) | (1L << T__16) | (1L << T__28) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << BOOL_LITERAL) | (1L << INT_LITERAL) | (1L << DOUBLE_LITERAL) | (1L << STRING_LITERAL) | (1L << CHAR_LITERAL) | (1L << Identifier))) != 0)) {
				{
				{
				setState(446);
				statement();
				}
				}
				setState(451);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(452);
			match(T__13);
			setState(453);
			match(T__30);
			setState(454);
			match(T__14);
			setState(455);
			expr(0);
			setState(456);
			match(T__15);
			setState(458);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(457);
				match(T__4);
				}
			}

			setState(464);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,73,_ctx) ) {
			case 1:
				{
				setState(460);
				match(T__5);
				setState(462);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__4) {
					{
					setState(461);
					match(T__4);
					}
				}

				}
				break;
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

	public static class ForStmtContext extends ParserRuleContext {
		public ForInitContext forInit() {
			return getRuleContext(ForInitContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ForUpdateContext forUpdate() {
			return getRuleContext(ForUpdateContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ForStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStmt; }
	}

	public final ForStmtContext forStmt() throws RecognitionException {
		ForStmtContext _localctx = new ForStmtContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_forStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(466);
			match(T__32);
			setState(467);
			match(T__14);
			setState(469);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__12) | (1L << T__14) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << BOOL_LITERAL) | (1L << INT_LITERAL) | (1L << DOUBLE_LITERAL) | (1L << STRING_LITERAL) | (1L << CHAR_LITERAL) | (1L << Identifier))) != 0)) {
				{
				setState(468);
				forInit();
				}
			}

			setState(471);
			match(T__4);
			setState(473);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << T__14) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << BOOL_LITERAL) | (1L << INT_LITERAL) | (1L << DOUBLE_LITERAL) | (1L << STRING_LITERAL) | (1L << CHAR_LITERAL) | (1L << Identifier))) != 0)) {
				{
				setState(472);
				expr(0);
				}
			}

			setState(475);
			match(T__4);
			setState(477);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << T__14) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << BOOL_LITERAL) | (1L << INT_LITERAL) | (1L << DOUBLE_LITERAL) | (1L << STRING_LITERAL) | (1L << CHAR_LITERAL) | (1L << Identifier))) != 0)) {
				{
				setState(476);
				forUpdate();
				}
			}

			setState(479);
			match(T__15);
			setState(480);
			match(T__12);
			setState(484);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__9) | (1L << T__12) | (1L << T__14) | (1L << T__16) | (1L << T__28) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << BOOL_LITERAL) | (1L << INT_LITERAL) | (1L << DOUBLE_LITERAL) | (1L << STRING_LITERAL) | (1L << CHAR_LITERAL) | (1L << Identifier))) != 0)) {
				{
				{
				setState(481);
				statement();
				}
				}
				setState(486);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(487);
			match(T__13);
			setState(492);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,79,_ctx) ) {
			case 1:
				{
				setState(488);
				match(T__5);
				setState(490);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__4) {
					{
					setState(489);
					match(T__4);
					}
				}

				}
				break;
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

	public static class ForInitContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(CodexLatinusParser.Identifier, 0); }
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public ForInitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forInit; }
	}

	public final ForInitContext forInit() throws RecognitionException {
		ForInitContext _localctx = new ForInitContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_forInit);
		int _la;
		try {
			setState(509);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,82,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(494);
				match(T__6);
				setState(495);
				match(Identifier);
				setState(496);
				match(T__7);
				setState(497);
				primitiveType();
				setState(502);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__12) | (1L << T__14) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << BOOL_LITERAL) | (1L << INT_LITERAL) | (1L << DOUBLE_LITERAL) | (1L << STRING_LITERAL) | (1L << CHAR_LITERAL) | (1L << Identifier))) != 0)) {
					{
					setState(499);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__8) {
						{
						setState(498);
						match(T__8);
						}
					}

					setState(501);
					expr(0);
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(504);
				lvalue();
				setState(505);
				match(T__8);
				setState(506);
				expr(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(508);
				expr(0);
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

	public static class ForUpdateContext extends ParserRuleContext {
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ForUpdateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forUpdate; }
	}

	public final ForUpdateContext forUpdate() throws RecognitionException {
		ForUpdateContext _localctx = new ForUpdateContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_forUpdate);
		int _la;
		try {
			setState(519);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,83,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(511);
				lvalue();
				setState(512);
				_la = _input.LA(1);
				if ( !(_la==T__33 || _la==T__34) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(514);
				lvalue();
				setState(515);
				match(T__8);
				setState(516);
				expr(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(518);
				expr(0);
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

	public static class ReturnStmtContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStmt; }
	}

	public final ReturnStmtContext returnStmt() throws RecognitionException {
		ReturnStmtContext _localctx = new ReturnStmtContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_returnStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(521);
			match(T__35);
			setState(523);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,84,_ctx) ) {
			case 1:
				{
				setState(522);
				expr(0);
				}
				break;
			}
			setState(526);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(525);
				match(T__4);
				}
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

	public static class BreakStmtContext extends ParserRuleContext {
		public BreakStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_breakStmt; }
	}

	public final BreakStmtContext breakStmt() throws RecognitionException {
		BreakStmtContext _localctx = new BreakStmtContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_breakStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(528);
			match(T__36);
			setState(530);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(529);
				match(T__4);
				}
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

	public static class ContinueStmtContext extends ParserRuleContext {
		public ContinueStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_continueStmt; }
	}

	public final ContinueStmtContext continueStmt() throws RecognitionException {
		ContinueStmtContext _localctx = new ContinueStmtContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_continueStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(532);
			match(T__37);
			setState(534);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(533);
				match(T__4);
				}
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

	public static class PrintStmtContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public PrintStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printStmt; }
	}

	public final PrintStmtContext printStmt() throws RecognitionException {
		PrintStmtContext _localctx = new PrintStmtContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_printStmt);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(536);
			match(T__38);
			setState(537);
			expr(0);
			setState(542);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,88,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(538);
					_la = _input.LA(1);
					if ( !(_la==T__17 || _la==T__38) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(539);
					expr(0);
					}
					} 
				}
				setState(544);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,88,_ctx);
			}
			setState(546);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(545);
				match(T__4);
				}
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

	public static class ReadStmtContext extends ParserRuleContext {
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(CodexLatinusParser.Identifier, 0); }
		public ReadStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_readStmt; }
	}

	public final ReadStmtContext readStmt() throws RecognitionException {
		ReadStmtContext _localctx = new ReadStmtContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_readStmt);
		int _la;
		try {
			setState(572);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,95,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(548);
				match(T__39);
				setState(550);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__4) {
					{
					setState(549);
					match(T__4);
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(552);
				lvalue();
				setState(553);
				match(T__39);
				setState(555);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__4) {
					{
					setState(554);
					match(T__4);
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(557);
				match(T__39);
				setState(558);
				lvalue();
				setState(560);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__4) {
					{
					setState(559);
					match(T__4);
					}
				}

				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(562);
				match(Identifier);
				setState(563);
				match(T__39);
				setState(565);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__4) {
					{
					setState(564);
					match(T__4);
					}
				}

				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(567);
				match(T__39);
				setState(568);
				match(Identifier);
				setState(570);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__4) {
					{
					setState(569);
					match(T__4);
					}
				}

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

	public static class AssignStmtContext extends ParserRuleContext {
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignStmt; }
	}

	public final AssignStmtContext assignStmt() throws RecognitionException {
		AssignStmtContext _localctx = new AssignStmtContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_assignStmt);
		int _la;
		try {
			setState(585);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,98,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(574);
				lvalue();
				setState(575);
				match(T__8);
				setState(576);
				expr(0);
				setState(578);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__4) {
					{
					setState(577);
					match(T__4);
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(580);
				lvalue();
				setState(581);
				_la = _input.LA(1);
				if ( !(_la==T__33 || _la==T__34) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(583);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__4) {
					{
					setState(582);
					match(T__4);
					}
				}

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

	public static class LvalueContext extends ParserRuleContext {
		public List<TerminalNode> Identifier() { return getTokens(CodexLatinusParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(CodexLatinusParser.Identifier, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public LvalueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lvalue; }
	}

	public final LvalueContext lvalue() throws RecognitionException {
		LvalueContext _localctx = new LvalueContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_lvalue);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(587);
			match(Identifier);
			setState(592);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,99,_ctx) ) {
			case 1:
				{
				setState(588);
				match(T__10);
				setState(589);
				expr(0);
				setState(590);
				match(T__11);
				}
				break;
			}
			setState(604);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,101,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(594);
					match(T__40);
					setState(595);
					match(Identifier);
					setState(600);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,100,_ctx) ) {
					case 1:
						{
						setState(596);
						match(T__10);
						setState(597);
						expr(0);
						setState(598);
						match(T__11);
						}
						break;
					}
					}
					} 
				}
				setState(606);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,101,_ctx);
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

	public static class ExprStmtContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprStmt; }
	}

	public final ExprStmtContext exprStmt() throws RecognitionException {
		ExprStmtContext _localctx = new ExprStmtContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_exprStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(607);
			expr(0);
			setState(609);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(608);
				match(T__4);
				}
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

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RelationalExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public RelationalExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class UnaryExprContext extends ExprContext {
		public Token op;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public UnaryExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class LogicalAndExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public LogicalAndExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class AssignExprContext extends ExprContext {
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class MultiplicativeExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public MultiplicativeExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class LogicalOrExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public LogicalOrExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class FunctionCallExprContext extends ExprContext {
		public TerminalNode Identifier() { return getToken(CodexLatinusParser.Identifier, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public FunctionCallExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class EqualityExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public EqualityExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class AdditiveExprContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public AdditiveExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class PostIncDecExprContext extends ExprContext {
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public PostIncDecExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class LvalueExprContext extends ExprContext {
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public LvalueExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class PrimaryExprContext extends ExprContext {
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public PrimaryExprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class ParenExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParenExprContext(ExprContext ctx) { copyFrom(ctx); }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 68;
		enterRecursionRule(_localctx, 68, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(633);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,104,_ctx) ) {
			case 1:
				{
				_localctx = new ParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(612);
				match(T__14);
				setState(613);
				expr(0);
				setState(614);
				match(T__15);
				}
				break;
			case 2:
				{
				_localctx = new FunctionCallExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(616);
				match(Identifier);
				setState(617);
				match(T__14);
				setState(619);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << T__14) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << BOOL_LITERAL) | (1L << INT_LITERAL) | (1L << DOUBLE_LITERAL) | (1L << STRING_LITERAL) | (1L << CHAR_LITERAL) | (1L << Identifier))) != 0)) {
					{
					setState(618);
					arguments();
					}
				}

				setState(621);
				match(T__15);
				}
				break;
			case 3:
				{
				_localctx = new UnaryExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(622);
				((UnaryExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44))) != 0)) ) {
					((UnaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(623);
				expr(11);
				}
				break;
			case 4:
				{
				_localctx = new AssignExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(624);
				lvalue();
				setState(625);
				match(T__8);
				setState(626);
				expr(4);
				}
				break;
			case 5:
				{
				_localctx = new PostIncDecExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(628);
				lvalue();
				setState(629);
				_la = _input.LA(1);
				if ( !(_la==T__33 || _la==T__34) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 6:
				{
				_localctx = new LvalueExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(631);
				lvalue();
				}
				break;
			case 7:
				{
				_localctx = new PrimaryExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(632);
				primary();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(655);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,106,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(653);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,105,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplicativeExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(635);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(636);
						((MultiplicativeExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__45) | (1L << T__46) | (1L << T__47))) != 0)) ) {
							((MultiplicativeExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(637);
						expr(11);
						}
						break;
					case 2:
						{
						_localctx = new AdditiveExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(638);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(639);
						((AdditiveExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__43 || _la==T__44) ) {
							((AdditiveExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(640);
						expr(10);
						}
						break;
					case 3:
						{
						_localctx = new RelationalExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(641);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(642);
						((RelationalExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51))) != 0)) ) {
							((RelationalExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(643);
						expr(9);
						}
						break;
					case 4:
						{
						_localctx = new EqualityExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(644);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(645);
						((EqualityExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__52) | (1L << T__53) | (1L << T__54))) != 0)) ) {
							((EqualityExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(646);
						expr(8);
						}
						break;
					case 5:
						{
						_localctx = new LogicalAndExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(647);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(648);
						match(T__55);
						setState(649);
						expr(7);
						}
						break;
					case 6:
						{
						_localctx = new LogicalOrExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(650);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(651);
						match(T__56);
						setState(652);
						expr(6);
						}
						break;
					}
					} 
				}
				setState(657);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,106,_ctx);
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

	public static class ExprListContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprList; }
	}

	public final ExprListContext exprList() throws RecognitionException {
		ExprListContext _localctx = new ExprListContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_exprList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(658);
			expr(0);
			setState(663);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__17) {
				{
				{
				setState(659);
				match(T__17);
				setState(660);
				expr(0);
				}
				}
				setState(665);
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

	public static class ArgumentsContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(666);
			expr(0);
			setState(671);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__17) {
				{
				{
				setState(667);
				match(T__17);
				setState(668);
				expr(0);
				}
				}
				setState(673);
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

	public static class PrimaryContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TerminalNode BOOL_LITERAL() { return getToken(CodexLatinusParser.BOOL_LITERAL, 0); }
		public TerminalNode Identifier() { return getToken(CodexLatinusParser.Identifier, 0); }
		public ArrayInitContext arrayInit() {
			return getRuleContext(ArrayInitContext.class,0);
		}
		public StructInitContext structInit() {
			return getRuleContext(StructInitContext.class,0);
		}
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_primary);
		try {
			setState(679);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,109,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(674);
				literal();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(675);
				match(BOOL_LITERAL);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(676);
				match(Identifier);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(677);
				arrayInit();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(678);
				structInit();
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

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode INT_LITERAL() { return getToken(CodexLatinusParser.INT_LITERAL, 0); }
		public TerminalNode DOUBLE_LITERAL() { return getToken(CodexLatinusParser.DOUBLE_LITERAL, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(CodexLatinusParser.STRING_LITERAL, 0); }
		public TerminalNode CHAR_LITERAL() { return getToken(CodexLatinusParser.CHAR_LITERAL, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(681);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT_LITERAL) | (1L << DOUBLE_LITERAL) | (1L << STRING_LITERAL) | (1L << CHAR_LITERAL))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 34:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 10);
		case 1:
			return precpred(_ctx, 9);
		case 2:
			return precpred(_ctx, 8);
		case 3:
			return precpred(_ctx, 7);
		case 4:
			return precpred(_ctx, 6);
		case 5:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3D\u02ae\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\3\2\5\2R\n\2\3\2\5\2"+
		"U\n\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\7\3_\n\3\f\3\16\3b\13\3\3\4\3\4"+
		"\7\4f\n\4\f\4\16\4i\13\4\3\5\3\5\7\5m\n\5\f\5\16\5p\13\5\3\5\3\5\5\5t"+
		"\n\5\3\5\3\5\5\5x\n\5\3\6\3\6\3\6\3\6\3\6\5\6\177\n\6\3\6\5\6\u0082\n"+
		"\6\3\6\5\6\u0085\n\6\3\7\3\7\3\7\3\7\5\7\u008b\n\7\3\7\5\7\u008e\n\7\3"+
		"\7\3\7\5\7\u0092\n\7\3\7\5\7\u0095\n\7\3\7\5\7\u0098\n\7\3\7\5\7\u009b"+
		"\n\7\3\7\3\7\3\7\3\7\5\7\u00a1\n\7\3\7\5\7\u00a4\n\7\3\7\3\7\3\7\5\7\u00a9"+
		"\n\7\5\7\u00ab\n\7\3\b\3\b\5\b\u00af\n\b\3\b\3\b\3\b\5\b\u00b4\n\b\3\b"+
		"\5\b\u00b7\n\b\3\t\3\t\3\t\3\t\7\t\u00bd\n\t\f\t\16\t\u00c0\13\t\3\t\3"+
		"\t\3\t\5\t\u00c5\n\t\3\t\5\t\u00c8\n\t\3\n\5\n\u00cb\n\n\3\n\3\n\3\n\5"+
		"\n\u00d0\n\n\3\n\5\n\u00d3\n\n\3\n\3\n\3\n\5\n\u00d8\n\n\3\13\3\13\5\13"+
		"\u00dc\n\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\5\f\u00e5\n\f\3\f\5\f\u00e8"+
		"\n\f\3\f\5\f\u00eb\n\f\3\r\3\r\3\r\7\r\u00f0\n\r\f\r\16\r\u00f3\13\r\3"+
		"\r\5\r\u00f6\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00ff\n\16\3"+
		"\16\3\16\5\16\u0103\n\16\5\16\u0105\n\16\3\16\5\16\u0108\n\16\3\16\3\16"+
		"\3\16\5\16\u010d\n\16\3\17\3\17\3\20\3\20\3\20\3\20\5\20\u0115\n\20\3"+
		"\20\3\20\3\20\5\20\u011a\n\20\3\20\7\20\u011d\n\20\f\20\16\20\u0120\13"+
		"\20\3\20\3\20\3\20\5\20\u0125\n\20\5\20\u0127\n\20\3\20\3\20\3\20\5\20"+
		"\u012c\n\20\3\20\3\20\3\20\5\20\u0131\n\20\3\20\3\20\3\20\5\20\u0136\n"+
		"\20\3\20\7\20\u0139\n\20\f\20\16\20\u013c\13\20\3\20\3\20\3\20\5\20\u0141"+
		"\n\20\5\20\u0143\n\20\5\20\u0145\n\20\3\21\3\21\3\21\3\21\3\21\7\21\u014c"+
		"\n\21\f\21\16\21\u014f\13\21\3\21\3\21\3\22\3\22\3\22\7\22\u0156\n\22"+
		"\f\22\16\22\u0159\13\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u0170"+
		"\n\24\3\25\3\25\7\25\u0174\n\25\f\25\16\25\u0177\13\25\3\25\3\25\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\7\26\u0181\n\26\f\26\16\26\u0184\13\26\3\26"+
		"\3\26\3\26\5\26\u0189\n\26\3\26\3\26\3\26\3\26\3\26\7\26\u0190\n\26\f"+
		"\26\16\26\u0193\13\26\3\26\3\26\7\26\u0197\n\26\f\26\16\26\u019a\13\26"+
		"\3\26\3\26\3\26\7\26\u019f\n\26\f\26\16\26\u01a2\13\26\3\26\5\26\u01a5"+
		"\n\26\3\26\3\26\5\26\u01a9\n\26\5\26\u01ab\n\26\3\27\3\27\3\27\3\27\3"+
		"\27\3\27\7\27\u01b3\n\27\f\27\16\27\u01b6\13\27\3\27\3\27\3\27\5\27\u01bb"+
		"\n\27\5\27\u01bd\n\27\3\30\3\30\3\30\7\30\u01c2\n\30\f\30\16\30\u01c5"+
		"\13\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u01cd\n\30\3\30\3\30\5\30\u01d1"+
		"\n\30\5\30\u01d3\n\30\3\31\3\31\3\31\5\31\u01d8\n\31\3\31\3\31\5\31\u01dc"+
		"\n\31\3\31\3\31\5\31\u01e0\n\31\3\31\3\31\3\31\7\31\u01e5\n\31\f\31\16"+
		"\31\u01e8\13\31\3\31\3\31\3\31\5\31\u01ed\n\31\5\31\u01ef\n\31\3\32\3"+
		"\32\3\32\3\32\3\32\5\32\u01f6\n\32\3\32\5\32\u01f9\n\32\3\32\3\32\3\32"+
		"\3\32\3\32\5\32\u0200\n\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33"+
		"\u020a\n\33\3\34\3\34\5\34\u020e\n\34\3\34\5\34\u0211\n\34\3\35\3\35\5"+
		"\35\u0215\n\35\3\36\3\36\5\36\u0219\n\36\3\37\3\37\3\37\3\37\7\37\u021f"+
		"\n\37\f\37\16\37\u0222\13\37\3\37\5\37\u0225\n\37\3 \3 \5 \u0229\n \3"+
		" \3 \3 \5 \u022e\n \3 \3 \3 \5 \u0233\n \3 \3 \3 \5 \u0238\n \3 \3 \3"+
		" \5 \u023d\n \5 \u023f\n \3!\3!\3!\3!\5!\u0245\n!\3!\3!\3!\5!\u024a\n"+
		"!\5!\u024c\n!\3\"\3\"\3\"\3\"\3\"\5\"\u0253\n\"\3\"\3\"\3\"\3\"\3\"\3"+
		"\"\5\"\u025b\n\"\7\"\u025d\n\"\f\"\16\"\u0260\13\"\3#\3#\5#\u0264\n#\3"+
		"$\3$\3$\3$\3$\3$\3$\3$\5$\u026e\n$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3"+
		"$\5$\u027c\n$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\7"+
		"$\u0290\n$\f$\16$\u0293\13$\3%\3%\3%\7%\u0298\n%\f%\16%\u029b\13%\3&\3"+
		"&\3&\7&\u02a0\n&\f&\16&\u02a3\13&\3\'\3\'\3\'\3\'\3\'\5\'\u02aa\n\'\3"+
		"(\3(\3(\2\3F)\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64"+
		"\668:<>@BDFHJLN\2\r\4\2\t\t\f\f\4\2\7\7\24\24\5\2\25\32<<AA\3\2$%\4\2"+
		"\24\24))\3\2,/\3\2\60\62\3\2./\3\2\63\66\4\2\13\13\679\3\2=@\2\u0319\2"+
		"Q\3\2\2\2\4Y\3\2\2\2\6c\3\2\2\2\bj\3\2\2\2\ny\3\2\2\2\f\u00aa\3\2\2\2"+
		"\16\u00b6\3\2\2\2\20\u00b8\3\2\2\2\22\u00ca\3\2\2\2\24\u00d9\3\2\2\2\26"+
		"\u00df\3\2\2\2\30\u00ec\3\2\2\2\32\u010c\3\2\2\2\34\u010e\3\2\2\2\36\u0144"+
		"\3\2\2\2 \u0146\3\2\2\2\"\u0152\3\2\2\2$\u015a\3\2\2\2&\u016f\3\2\2\2"+
		"(\u0171\3\2\2\2*\u017a\3\2\2\2,\u01ac\3\2\2\2.\u01be\3\2\2\2\60\u01d4"+
		"\3\2\2\2\62\u01ff\3\2\2\2\64\u0209\3\2\2\2\66\u020b\3\2\2\28\u0212\3\2"+
		"\2\2:\u0216\3\2\2\2<\u021a\3\2\2\2>\u023e\3\2\2\2@\u024b\3\2\2\2B\u024d"+
		"\3\2\2\2D\u0261\3\2\2\2F\u027b\3\2\2\2H\u0294\3\2\2\2J\u029c\3\2\2\2L"+
		"\u02a9\3\2\2\2N\u02ab\3\2\2\2PR\5\4\3\2QP\3\2\2\2QR\3\2\2\2RT\3\2\2\2"+
		"SU\5\6\4\2TS\3\2\2\2TU\3\2\2\2UV\3\2\2\2VW\5\b\5\2WX\7\2\2\3X\3\3\2\2"+
		"\2Y`\7\3\2\2Z_\5\n\6\2[_\5\f\7\2\\_\5\20\t\2]_\5\26\f\2^Z\3\2\2\2^[\3"+
		"\2\2\2^\\\3\2\2\2^]\3\2\2\2_b\3\2\2\2`^\3\2\2\2`a\3\2\2\2a\5\3\2\2\2b"+
		"`\3\2\2\2cg\7\4\2\2df\5\36\20\2ed\3\2\2\2fi\3\2\2\2ge\3\2\2\2gh\3\2\2"+
		"\2h\7\3\2\2\2ig\3\2\2\2jn\7\5\2\2km\5&\24\2lk\3\2\2\2mp\3\2\2\2nl\3\2"+
		"\2\2no\3\2\2\2ow\3\2\2\2pn\3\2\2\2qs\7\6\2\2rt\7\7\2\2sr\3\2\2\2st\3\2"+
		"\2\2tx\3\2\2\2uv\7\b\2\2vx\7\7\2\2wq\3\2\2\2wu\3\2\2\2wx\3\2\2\2x\t\3"+
		"\2\2\2yz\7\t\2\2z{\7A\2\2{|\7\n\2\2|\u0081\5\34\17\2}\177\7\13\2\2~}\3"+
		"\2\2\2~\177\3\2\2\2\177\u0080\3\2\2\2\u0080\u0082\5F$\2\u0081~\3\2\2\2"+
		"\u0081\u0082\3\2\2\2\u0082\u0084\3\2\2\2\u0083\u0085\7\7\2\2\u0084\u0083"+
		"\3\2\2\2\u0084\u0085\3\2\2\2\u0085\13\3\2\2\2\u0086\u0087\7\f\2\2\u0087"+
		"\u008d\7A\2\2\u0088\u008a\7\r\2\2\u0089\u008b\5F$\2\u008a\u0089\3\2\2"+
		"\2\u008a\u008b\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008e\7\16\2\2\u008d"+
		"\u0088\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u0091\3\2\2\2\u008f\u0090\7\n"+
		"\2\2\u0090\u0092\5\34\17\2\u0091\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092"+
		"\u0097\3\2\2\2\u0093\u0095\7\13\2\2\u0094\u0093\3\2\2\2\u0094\u0095\3"+
		"\2\2\2\u0095\u0096\3\2\2\2\u0096\u0098\5\16\b\2\u0097\u0094\3\2\2\2\u0097"+
		"\u0098\3\2\2\2\u0098\u009a\3\2\2\2\u0099\u009b\7\7\2\2\u009a\u0099\3\2"+
		"\2\2\u009a\u009b\3\2\2\2\u009b\u00ab\3\2\2\2\u009c\u009d\7\f\2\2\u009d"+
		"\u00a3\7A\2\2\u009e\u00a0\7\r\2\2\u009f\u00a1\5F$\2\u00a0\u009f\3\2\2"+
		"\2\u00a0\u00a1\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a4\7\16\2\2\u00a3"+
		"\u009e\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a6\7\n"+
		"\2\2\u00a6\u00a8\5\16\b\2\u00a7\u00a9\7\7\2\2\u00a8\u00a7\3\2\2\2\u00a8"+
		"\u00a9\3\2\2\2\u00a9\u00ab\3\2\2\2\u00aa\u0086\3\2\2\2\u00aa\u009c\3\2"+
		"\2\2\u00ab\r\3\2\2\2\u00ac\u00ae\7\17\2\2\u00ad\u00af\5H%\2\u00ae\u00ad"+
		"\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b7\7\20\2\2"+
		"\u00b1\u00b3\7\21\2\2\u00b2\u00b4\5H%\2\u00b3\u00b2\3\2\2\2\u00b3\u00b4"+
		"\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b7\7\22\2\2\u00b6\u00ac\3\2\2\2"+
		"\u00b6\u00b1\3\2\2\2\u00b7\17\3\2\2\2\u00b8\u00b9\7\23\2\2\u00b9\u00ba"+
		"\7A\2\2\u00ba\u00be\7\17\2\2\u00bb\u00bd\5\22\n\2\u00bc\u00bb\3\2\2\2"+
		"\u00bd\u00c0\3\2\2\2\u00be\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c1"+
		"\3\2\2\2\u00c0\u00be\3\2\2\2\u00c1\u00c7\7\20\2\2\u00c2\u00c4\7\b\2\2"+
		"\u00c3\u00c5\7\7\2\2\u00c4\u00c3\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c8"+
		"\3\2\2\2\u00c6\u00c8\7\7\2\2\u00c7\u00c2\3\2\2\2\u00c7\u00c6\3\2\2\2\u00c7"+
		"\u00c8\3\2\2\2\u00c8\21\3\2\2\2\u00c9\u00cb\t\2\2\2\u00ca\u00c9\3\2\2"+
		"\2\u00ca\u00cb\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00d2\7A\2\2\u00cd\u00cf"+
		"\7\r\2\2\u00ce\u00d0\5F$\2\u00cf\u00ce\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0"+
		"\u00d1\3\2\2\2\u00d1\u00d3\7\16\2\2\u00d2\u00cd\3\2\2\2\u00d2\u00d3\3"+
		"\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d5\7\n\2\2\u00d5\u00d7\5\34\17\2\u00d6"+
		"\u00d8\t\3\2\2\u00d7\u00d6\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\23\3\2\2"+
		"\2\u00d9\u00db\7\17\2\2\u00da\u00dc\5\30\r\2\u00db\u00da\3\2\2\2\u00db"+
		"\u00dc\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00de\7\20\2\2\u00de\25\3\2\2"+
		"\2\u00df\u00e0\7\t\2\2\u00e0\u00e1\7A\2\2\u00e1\u00e2\7\n\2\2\u00e2\u00e7"+
		"\7A\2\2\u00e3\u00e5\7\13\2\2\u00e4\u00e3\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5"+
		"\u00e6\3\2\2\2\u00e6\u00e8\5\24\13\2\u00e7\u00e4\3\2\2\2\u00e7\u00e8\3"+
		"\2\2\2\u00e8\u00ea\3\2\2\2\u00e9\u00eb\7\7\2\2\u00ea\u00e9\3\2\2\2\u00ea"+
		"\u00eb\3\2\2\2\u00eb\27\3\2\2\2\u00ec\u00f1\5\32\16\2\u00ed\u00ee\t\3"+
		"\2\2\u00ee\u00f0\5\32\16\2\u00ef\u00ed\3\2\2\2\u00f0\u00f3\3\2\2\2\u00f1"+
		"\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f5\3\2\2\2\u00f3\u00f1\3\2"+
		"\2\2\u00f4\u00f6\t\3\2\2\u00f5\u00f4\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6"+
		"\31\3\2\2\2\u00f7\u00f8\7A\2\2\u00f8\u0107\7\n\2\2\u00f9\u00fa\7A\2\2"+
		"\u00fa\u00fb\7\r\2\2\u00fb\u00fc\5F$\2\u00fc\u0104\7\16\2\2\u00fd\u00ff"+
		"\7\13\2\2\u00fe\u00fd\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\u0102\3\2\2\2"+
		"\u0100\u0103\5\24\13\2\u0101\u0103\5\16\b\2\u0102\u0100\3\2\2\2\u0102"+
		"\u0101\3\2\2\2\u0103\u0105\3\2\2\2\u0104\u00fe\3\2\2\2\u0104\u0105\3\2"+
		"\2\2\u0105\u0108\3\2\2\2\u0106\u0108\5F$\2\u0107\u00f9\3\2\2\2\u0107\u0106"+
		"\3\2\2\2\u0108\u010d\3\2\2\2\u0109\u010a\7A\2\2\u010a\u010b\7\13\2\2\u010b"+
		"\u010d\5F$\2\u010c\u00f7\3\2\2\2\u010c\u0109\3\2\2\2\u010d\33\3\2\2\2"+
		"\u010e\u010f\t\4\2\2\u010f\35\3\2\2\2\u0110\u0111\7\33\2\2\u0111\u0112"+
		"\7A\2\2\u0112\u0114\7\21\2\2\u0113\u0115\5\"\22\2\u0114\u0113\3\2\2\2"+
		"\u0114\u0115\3\2\2\2\u0115\u0116\3\2\2\2\u0116\u0117\7\22\2\2\u0117\u0119"+
		"\7\17\2\2\u0118\u011a\5 \21\2\u0119\u0118\3\2\2\2\u0119\u011a\3\2\2\2"+
		"\u011a\u011e\3\2\2\2\u011b\u011d\5&\24\2\u011c\u011b\3\2\2\2\u011d\u0120"+
		"\3\2\2\2\u011e\u011c\3\2\2\2\u011e\u011f\3\2\2\2\u011f\u0121\3\2\2\2\u0120"+
		"\u011e\3\2\2\2\u0121\u0126\7\20\2\2\u0122\u0124\7\b\2\2\u0123\u0125\7"+
		"\7\2\2\u0124\u0123\3\2\2\2\u0124\u0125\3\2\2\2\u0125\u0127\3\2\2\2\u0126"+
		"\u0122\3\2\2\2\u0126\u0127\3\2\2\2\u0127\u0145\3\2\2\2\u0128\u012b\7\34"+
		"\2\2\u0129\u012c\5\34\17\2\u012a\u012c\7\35\2\2\u012b\u0129\3\2\2\2\u012b"+
		"\u012a\3\2\2\2\u012c\u012d\3\2\2\2\u012d\u012e\7A\2\2\u012e\u0130\7\21"+
		"\2\2\u012f\u0131\5\"\22\2\u0130\u012f\3\2\2\2\u0130\u0131\3\2\2\2\u0131"+
		"\u0132\3\2\2\2\u0132\u0133\7\22\2\2\u0133\u0135\7\17\2\2\u0134\u0136\5"+
		" \21\2\u0135\u0134\3\2\2\2\u0135\u0136\3\2\2\2\u0136\u013a\3\2\2\2\u0137"+
		"\u0139\5&\24\2\u0138\u0137\3\2\2\2\u0139\u013c\3\2\2\2\u013a\u0138\3\2"+
		"\2\2\u013a\u013b\3\2\2\2\u013b\u013d\3\2\2\2\u013c\u013a\3\2\2\2\u013d"+
		"\u0142\7\20\2\2\u013e\u0140\7\b\2\2\u013f\u0141\7\7\2\2\u0140\u013f\3"+
		"\2\2\2\u0140\u0141\3\2\2\2\u0141\u0143\3\2\2\2\u0142\u013e\3\2\2\2\u0142"+
		"\u0143\3\2\2\2\u0143\u0145\3\2\2\2\u0144\u0110\3\2\2\2\u0144\u0128\3\2"+
		"\2\2\u0145\37\3\2\2\2\u0146\u014d\7\36\2\2\u0147\u014c\5\n\6\2\u0148\u014c"+
		"\5\f\7\2\u0149\u014c\5\20\t\2\u014a\u014c\5\26\f\2\u014b\u0147\3\2\2\2"+
		"\u014b\u0148\3\2\2\2\u014b\u0149\3\2\2\2\u014b\u014a\3\2\2\2\u014c\u014f"+
		"\3\2\2\2\u014d\u014b\3\2\2\2\u014d\u014e\3\2\2\2\u014e\u0150\3\2\2\2\u014f"+
		"\u014d\3\2\2\2\u0150\u0151\7\16\2\2\u0151!\3\2\2\2\u0152\u0157\5$\23\2"+
		"\u0153\u0154\7\24\2\2\u0154\u0156\5$\23\2\u0155\u0153\3\2\2\2\u0156\u0159"+
		"\3\2\2\2\u0157\u0155\3\2\2\2\u0157\u0158\3\2\2\2\u0158#\3\2\2\2\u0159"+
		"\u0157\3\2\2\2\u015a\u015b\7\t\2\2\u015b\u015c\7A\2\2\u015c\u015d\7\n"+
		"\2\2\u015d\u015e\5\34\17\2\u015e%\3\2\2\2\u015f\u0170\5(\25\2\u0160\u0170"+
		"\5\n\6\2\u0161\u0170\5\f\7\2\u0162\u0170\5\20\t\2\u0163\u0170\5\26\f\2"+
		"\u0164\u0170\5*\26\2\u0165\u0170\5,\27\2\u0166\u0170\5.\30\2\u0167\u0170"+
		"\5\60\31\2\u0168\u0170\5\66\34\2\u0169\u0170\58\35\2\u016a\u0170\5:\36"+
		"\2\u016b\u0170\5<\37\2\u016c\u0170\5> \2\u016d\u0170\5@!\2\u016e\u0170"+
		"\5D#\2\u016f\u015f\3\2\2\2\u016f\u0160\3\2\2\2\u016f\u0161\3\2\2\2\u016f"+
		"\u0162\3\2\2\2\u016f\u0163\3\2\2\2\u016f\u0164\3\2\2\2\u016f\u0165\3\2"+
		"\2\2\u016f\u0166\3\2\2\2\u016f\u0167\3\2\2\2\u016f\u0168\3\2\2\2\u016f"+
		"\u0169\3\2\2\2\u016f\u016a\3\2\2\2\u016f\u016b\3\2\2\2\u016f\u016c\3\2"+
		"\2\2\u016f\u016d\3\2\2\2\u016f\u016e\3\2\2\2\u0170\'\3\2\2\2\u0171\u0175"+
		"\7\17\2\2\u0172\u0174\5&\24\2\u0173\u0172\3\2\2\2\u0174\u0177\3\2\2\2"+
		"\u0175\u0173\3\2\2\2\u0175\u0176\3\2\2\2\u0176\u0178\3\2\2\2\u0177\u0175"+
		"\3\2\2\2\u0178\u0179\7\20\2\2\u0179)\3\2\2\2\u017a\u017b\7\37\2\2\u017b"+
		"\u017c\7\21\2\2\u017c\u017d\5F$\2\u017d\u017e\7\22\2\2\u017e\u0182\7\17"+
		"\2\2\u017f\u0181\5&\24\2\u0180\u017f\3\2\2\2\u0181\u0184\3\2\2\2\u0182"+
		"\u0180\3\2\2\2\u0182\u0183\3\2\2\2\u0183\u0185\3\2\2\2\u0184\u0182\3\2"+
		"\2\2\u0185\u0198\7\20\2\2\u0186\u0188\7 \2\2\u0187\u0189\7\37\2\2\u0188"+
		"\u0187\3\2\2\2\u0188\u0189\3\2\2\2\u0189\u018a\3\2\2\2\u018a\u018b\7\21"+
		"\2\2\u018b\u018c\5F$\2\u018c\u018d\7\22\2\2\u018d\u0191\7\17\2\2\u018e"+
		"\u0190\5&\24\2\u018f\u018e\3\2\2\2\u0190\u0193\3\2\2\2\u0191\u018f\3\2"+
		"\2\2\u0191\u0192\3\2\2\2\u0192\u0194\3\2\2\2\u0193\u0191\3\2\2\2\u0194"+
		"\u0195\7\20\2\2\u0195\u0197\3\2\2\2\u0196\u0186\3\2\2\2\u0197\u019a\3"+
		"\2\2\2\u0198\u0196\3\2\2\2\u0198\u0199\3\2\2\2\u0199\u01a4\3\2\2\2\u019a"+
		"\u0198\3\2\2\2\u019b\u019c\7 \2\2\u019c\u01a0\7\17\2\2\u019d\u019f\5&"+
		"\24\2\u019e\u019d\3\2\2\2\u019f\u01a2\3\2\2\2\u01a0\u019e\3\2\2\2\u01a0"+
		"\u01a1\3\2\2\2\u01a1\u01a3\3\2\2\2\u01a2\u01a0\3\2\2\2\u01a3\u01a5\7\20"+
		"\2\2\u01a4\u019b\3\2\2\2\u01a4\u01a5\3\2\2\2\u01a5\u01aa\3\2\2\2\u01a6"+
		"\u01a8\7\b\2\2\u01a7\u01a9\7\7\2\2\u01a8\u01a7\3\2\2\2\u01a8\u01a9\3\2"+
		"\2\2\u01a9\u01ab\3\2\2\2\u01aa\u01a6\3\2\2\2\u01aa\u01ab\3\2\2\2\u01ab"+
		"+\3\2\2\2\u01ac\u01ad\7!\2\2\u01ad\u01ae\7\21\2\2\u01ae\u01af\5F$\2\u01af"+
		"\u01b0\7\22\2\2\u01b0\u01b4\7\17\2\2\u01b1\u01b3\5&\24\2\u01b2\u01b1\3"+
		"\2\2\2\u01b3\u01b6\3\2\2\2\u01b4\u01b2\3\2\2\2\u01b4\u01b5\3\2\2\2\u01b5"+
		"\u01b7\3\2\2\2\u01b6\u01b4\3\2\2\2\u01b7\u01bc\7\20\2\2\u01b8\u01ba\7"+
		"\b\2\2\u01b9\u01bb\7\7\2\2\u01ba\u01b9\3\2\2\2\u01ba\u01bb\3\2\2\2\u01bb"+
		"\u01bd\3\2\2\2\u01bc\u01b8\3\2\2\2\u01bc\u01bd\3\2\2\2\u01bd-\3\2\2\2"+
		"\u01be\u01bf\7\"\2\2\u01bf\u01c3\7\17\2\2\u01c0\u01c2\5&\24\2\u01c1\u01c0"+
		"\3\2\2\2\u01c2\u01c5\3\2\2\2\u01c3\u01c1\3\2\2\2\u01c3\u01c4\3\2\2\2\u01c4"+
		"\u01c6\3\2\2\2\u01c5\u01c3\3\2\2\2\u01c6\u01c7\7\20\2\2\u01c7\u01c8\7"+
		"!\2\2\u01c8\u01c9\7\21\2\2\u01c9\u01ca\5F$\2\u01ca\u01cc\7\22\2\2\u01cb"+
		"\u01cd\7\7\2\2\u01cc\u01cb\3\2\2\2\u01cc\u01cd\3\2\2\2\u01cd\u01d2\3\2"+
		"\2\2\u01ce\u01d0\7\b\2\2\u01cf\u01d1\7\7\2\2\u01d0\u01cf\3\2\2\2\u01d0"+
		"\u01d1\3\2\2\2\u01d1\u01d3\3\2\2\2\u01d2\u01ce\3\2\2\2\u01d2\u01d3\3\2"+
		"\2\2\u01d3/\3\2\2\2\u01d4\u01d5\7#\2\2\u01d5\u01d7\7\21\2\2\u01d6\u01d8"+
		"\5\62\32\2\u01d7\u01d6\3\2\2\2\u01d7\u01d8\3\2\2\2\u01d8\u01d9\3\2\2\2"+
		"\u01d9\u01db\7\7\2\2\u01da\u01dc\5F$\2\u01db\u01da\3\2\2\2\u01db\u01dc"+
		"\3\2\2\2\u01dc\u01dd\3\2\2\2\u01dd\u01df\7\7\2\2\u01de\u01e0\5\64\33\2"+
		"\u01df\u01de\3\2\2\2\u01df\u01e0\3\2\2\2\u01e0\u01e1\3\2\2\2\u01e1\u01e2"+
		"\7\22\2\2\u01e2\u01e6\7\17\2\2\u01e3\u01e5\5&\24\2\u01e4\u01e3\3\2\2\2"+
		"\u01e5\u01e8\3\2\2\2\u01e6\u01e4\3\2\2\2\u01e6\u01e7\3\2\2\2\u01e7\u01e9"+
		"\3\2\2\2\u01e8\u01e6\3\2\2\2\u01e9\u01ee\7\20\2\2\u01ea\u01ec\7\b\2\2"+
		"\u01eb\u01ed\7\7\2\2\u01ec\u01eb\3\2\2\2\u01ec\u01ed\3\2\2\2\u01ed\u01ef"+
		"\3\2\2\2\u01ee\u01ea\3\2\2\2\u01ee\u01ef\3\2\2\2\u01ef\61\3\2\2\2\u01f0"+
		"\u01f1\7\t\2\2\u01f1\u01f2\7A\2\2\u01f2\u01f3\7\n\2\2\u01f3\u01f8\5\34"+
		"\17\2\u01f4\u01f6\7\13\2\2\u01f5\u01f4\3\2\2\2\u01f5\u01f6\3\2\2\2\u01f6"+
		"\u01f7\3\2\2\2\u01f7\u01f9\5F$\2\u01f8\u01f5\3\2\2\2\u01f8\u01f9\3\2\2"+
		"\2\u01f9\u0200\3\2\2\2\u01fa\u01fb\5B\"\2\u01fb\u01fc\7\13\2\2\u01fc\u01fd"+
		"\5F$\2\u01fd\u0200\3\2\2\2\u01fe\u0200\5F$\2\u01ff\u01f0\3\2\2\2\u01ff"+
		"\u01fa\3\2\2\2\u01ff\u01fe\3\2\2\2\u0200\63\3\2\2\2\u0201\u0202\5B\"\2"+
		"\u0202\u0203\t\5\2\2\u0203\u020a\3\2\2\2\u0204\u0205\5B\"\2\u0205\u0206"+
		"\7\13\2\2\u0206\u0207\5F$\2\u0207\u020a\3\2\2\2\u0208\u020a\5F$\2\u0209"+
		"\u0201\3\2\2\2\u0209\u0204\3\2\2\2\u0209\u0208\3\2\2\2\u020a\65\3\2\2"+
		"\2\u020b\u020d\7&\2\2\u020c\u020e\5F$\2\u020d\u020c\3\2\2\2\u020d\u020e"+
		"\3\2\2\2\u020e\u0210\3\2\2\2\u020f\u0211\7\7\2\2\u0210\u020f\3\2\2\2\u0210"+
		"\u0211\3\2\2\2\u0211\67\3\2\2\2\u0212\u0214\7\'\2\2\u0213\u0215\7\7\2"+
		"\2\u0214\u0213\3\2\2\2\u0214\u0215\3\2\2\2\u02159\3\2\2\2\u0216\u0218"+
		"\7(\2\2\u0217\u0219\7\7\2\2\u0218\u0217\3\2\2\2\u0218\u0219\3\2\2\2\u0219"+
		";\3\2\2\2\u021a\u021b\7)\2\2\u021b\u0220\5F$\2\u021c\u021d\t\6\2\2\u021d"+
		"\u021f\5F$\2\u021e\u021c\3\2\2\2\u021f\u0222\3\2\2\2\u0220\u021e\3\2\2"+
		"\2\u0220\u0221\3\2\2\2\u0221\u0224\3\2\2\2\u0222\u0220\3\2\2\2\u0223\u0225"+
		"\7\7\2\2\u0224\u0223\3\2\2\2\u0224\u0225\3\2\2\2\u0225=\3\2\2\2\u0226"+
		"\u0228\7*\2\2\u0227\u0229\7\7\2\2\u0228\u0227\3\2\2\2\u0228\u0229\3\2"+
		"\2\2\u0229\u023f\3\2\2\2\u022a\u022b\5B\"\2\u022b\u022d\7*\2\2\u022c\u022e"+
		"\7\7\2\2\u022d\u022c\3\2\2\2\u022d\u022e\3\2\2\2\u022e\u023f\3\2\2\2\u022f"+
		"\u0230\7*\2\2\u0230\u0232\5B\"\2\u0231\u0233\7\7\2\2\u0232\u0231\3\2\2"+
		"\2\u0232\u0233\3\2\2\2\u0233\u023f\3\2\2\2\u0234\u0235\7A\2\2\u0235\u0237"+
		"\7*\2\2\u0236\u0238\7\7\2\2\u0237\u0236\3\2\2\2\u0237\u0238\3\2\2\2\u0238"+
		"\u023f\3\2\2\2\u0239\u023a\7*\2\2\u023a\u023c\7A\2\2\u023b\u023d\7\7\2"+
		"\2\u023c\u023b\3\2\2\2\u023c\u023d\3\2\2\2\u023d\u023f\3\2\2\2\u023e\u0226"+
		"\3\2\2\2\u023e\u022a\3\2\2\2\u023e\u022f\3\2\2\2\u023e\u0234\3\2\2\2\u023e"+
		"\u0239\3\2\2\2\u023f?\3\2\2\2\u0240\u0241\5B\"\2\u0241\u0242\7\13\2\2"+
		"\u0242\u0244\5F$\2\u0243\u0245\7\7\2\2\u0244\u0243\3\2\2\2\u0244\u0245"+
		"\3\2\2\2\u0245\u024c\3\2\2\2\u0246\u0247\5B\"\2\u0247\u0249\t\5\2\2\u0248"+
		"\u024a\7\7\2\2\u0249\u0248\3\2\2\2\u0249\u024a\3\2\2\2\u024a\u024c\3\2"+
		"\2\2\u024b\u0240\3\2\2\2\u024b\u0246\3\2\2\2\u024cA\3\2\2\2\u024d\u0252"+
		"\7A\2\2\u024e\u024f\7\r\2\2\u024f\u0250\5F$\2\u0250\u0251\7\16\2\2\u0251"+
		"\u0253\3\2\2\2\u0252\u024e\3\2\2\2\u0252\u0253\3\2\2\2\u0253\u025e\3\2"+
		"\2\2\u0254\u0255\7+\2\2\u0255\u025a\7A\2\2\u0256\u0257\7\r\2\2\u0257\u0258"+
		"\5F$\2\u0258\u0259\7\16\2\2\u0259\u025b\3\2\2\2\u025a\u0256\3\2\2\2\u025a"+
		"\u025b\3\2\2\2\u025b\u025d\3\2\2\2\u025c\u0254\3\2\2\2\u025d\u0260\3\2"+
		"\2\2\u025e\u025c\3\2\2\2\u025e\u025f\3\2\2\2\u025fC\3\2\2\2\u0260\u025e"+
		"\3\2\2\2\u0261\u0263\5F$\2\u0262\u0264\7\7\2\2\u0263\u0262\3\2\2\2\u0263"+
		"\u0264\3\2\2\2\u0264E\3\2\2\2\u0265\u0266\b$\1\2\u0266\u0267\7\21\2\2"+
		"\u0267\u0268\5F$\2\u0268\u0269\7\22\2\2\u0269\u027c\3\2\2\2\u026a\u026b"+
		"\7A\2\2\u026b\u026d\7\21\2\2\u026c\u026e\5J&\2\u026d\u026c\3\2\2\2\u026d"+
		"\u026e\3\2\2\2\u026e\u026f\3\2\2\2\u026f\u027c\7\22\2\2\u0270\u0271\t"+
		"\7\2\2\u0271\u027c\5F$\r\u0272\u0273\5B\"\2\u0273\u0274\7\13\2\2\u0274"+
		"\u0275\5F$\6\u0275\u027c\3\2\2\2\u0276\u0277\5B\"\2\u0277\u0278\t\5\2"+
		"\2\u0278\u027c\3\2\2\2\u0279\u027c\5B\"\2\u027a\u027c\5L\'\2\u027b\u0265"+
		"\3\2\2\2\u027b\u026a\3\2\2\2\u027b\u0270\3\2\2\2\u027b\u0272\3\2\2\2\u027b"+
		"\u0276\3\2\2\2\u027b\u0279\3\2\2\2\u027b\u027a\3\2\2\2\u027c\u0291\3\2"+
		"\2\2\u027d\u027e\f\f\2\2\u027e\u027f\t\b\2\2\u027f\u0290\5F$\r\u0280\u0281"+
		"\f\13\2\2\u0281\u0282\t\t\2\2\u0282\u0290\5F$\f\u0283\u0284\f\n\2\2\u0284"+
		"\u0285\t\n\2\2\u0285\u0290\5F$\13\u0286\u0287\f\t\2\2\u0287\u0288\t\13"+
		"\2\2\u0288\u0290\5F$\n\u0289\u028a\f\b\2\2\u028a\u028b\7:\2\2\u028b\u0290"+
		"\5F$\t\u028c\u028d\f\7\2\2\u028d\u028e\7;\2\2\u028e\u0290\5F$\b\u028f"+
		"\u027d\3\2\2\2\u028f\u0280\3\2\2\2\u028f\u0283\3\2\2\2\u028f\u0286\3\2"+
		"\2\2\u028f\u0289\3\2\2\2\u028f\u028c\3\2\2\2\u0290\u0293\3\2\2\2\u0291"+
		"\u028f\3\2\2\2\u0291\u0292\3\2\2\2\u0292G\3\2\2\2\u0293\u0291\3\2\2\2"+
		"\u0294\u0299\5F$\2\u0295\u0296\7\24\2\2\u0296\u0298\5F$\2\u0297\u0295"+
		"\3\2\2\2\u0298\u029b\3\2\2\2\u0299\u0297\3\2\2\2\u0299\u029a\3\2\2\2\u029a"+
		"I\3\2\2\2\u029b\u0299\3\2\2\2\u029c\u02a1\5F$\2\u029d\u029e\7\24\2\2\u029e"+
		"\u02a0\5F$\2\u029f\u029d\3\2\2\2\u02a0\u02a3\3\2\2\2\u02a1\u029f\3\2\2"+
		"\2\u02a1\u02a2\3\2\2\2\u02a2K\3\2\2\2\u02a3\u02a1\3\2\2\2\u02a4\u02aa"+
		"\5N(\2\u02a5\u02aa\7<\2\2\u02a6\u02aa\7A\2\2\u02a7\u02aa\5\16\b\2\u02a8"+
		"\u02aa\5\24\13\2\u02a9\u02a4\3\2\2\2\u02a9\u02a5\3\2\2\2\u02a9\u02a6\3"+
		"\2\2\2\u02a9\u02a7\3\2\2\2\u02a9\u02a8\3\2\2\2\u02aaM\3\2\2\2\u02ab\u02ac"+
		"\t\f\2\2\u02acO\3\2\2\2pQT^`gnsw~\u0081\u0084\u008a\u008d\u0091\u0094"+
		"\u0097\u009a\u00a0\u00a3\u00a8\u00aa\u00ae\u00b3\u00b6\u00be\u00c4\u00c7"+
		"\u00ca\u00cf\u00d2\u00d7\u00db\u00e4\u00e7\u00ea\u00f1\u00f5\u00fe\u0102"+
		"\u0104\u0107\u010c\u0114\u0119\u011e\u0124\u0126\u012b\u0130\u0135\u013a"+
		"\u0140\u0142\u0144\u014b\u014d\u0157\u016f\u0175\u0182\u0188\u0191\u0198"+
		"\u01a0\u01a4\u01a8\u01aa\u01b4\u01ba\u01bc\u01c3\u01cc\u01d0\u01d2\u01d7"+
		"\u01db\u01df\u01e6\u01ec\u01ee\u01f5\u01f8\u01ff\u0209\u020d\u0210\u0214"+
		"\u0218\u0220\u0224\u0228\u022d\u0232\u0237\u023c\u023e\u0244\u0249\u024b"+
		"\u0252\u025a\u025e\u0263\u026d\u027b\u028f\u0291\u0299\u02a1\u02a9";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}