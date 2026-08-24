package org.codexlatinus.ast;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.codexlatinus.CodexLatinusBaseVisitor;
import org.codexlatinus.CodexLatinusParser;
import org.codexlatinus.ast.expresiones.Expresion;
import org.codexlatinus.ast.expresiones.VisitanteExpresiones;
import org.codexlatinus.ast.expresiones.acceso.AccesoVariable;
import org.codexlatinus.ast.expresiones.acceso.LlamadaFuncion;
import org.codexlatinus.ast.expresiones.inicializadores.InicializadorArreglo;
import org.codexlatinus.ast.expresiones.inicializadores.InicializadorEstructura;
import org.codexlatinus.ast.expresiones.literales.Literal;
import org.codexlatinus.ast.expresiones.operaciones.Operacion;
import org.codexlatinus.ast.expresiones.operaciones.OperacionUnaria;
import org.codexlatinus.ast.sentencias.Asignacion;
import org.codexlatinus.ast.sentencias.BloqueSentencias;
import org.codexlatinus.ast.sentencias.Sentencia;
import org.codexlatinus.ast.sentencias.VisitanteSentencias;
import org.codexlatinus.ast.sentencias.ciclos.*;
import org.codexlatinus.ast.sentencias.condicionales.SentenciaSi;
import org.codexlatinus.ast.sentencias.declaraciones.Declaracion;
import org.codexlatinus.ast.sentencias.declaraciones.DeclaracionArreglo;
import org.codexlatinus.ast.sentencias.declaraciones.DeclaracionEstructura;
import org.codexlatinus.ast.sentencias.declaraciones.DeclaracionInstanciaEstructura;
import org.codexlatinus.ast.sentencias.funciones.DeclaracionFuncion;
import org.codexlatinus.ast.sentencias.funciones.SentenciaRetorno;
import org.codexlatinus.ast.sentencias.io.SentenciaImprimir;
import org.codexlatinus.ast.sentencias.io.SentenciaLectura;

public class VisitanteCodexLatinusAst extends CodexLatinusBaseVisitor<NodoAst> {

    private final VisitanteSentencias visitanteSentencias;
    private final VisitanteExpresiones visitanteExpresiones;

    public VisitanteCodexLatinusAst() {
        this.visitanteSentencias = new VisitanteSentencias(this::visit);
        this.visitanteExpresiones = new VisitanteExpresiones(this::visit);
    }

    @Override
    public NodoAst visit(ParseTree tree) {
        if (tree == null) return null;
        NodoAst nodo = super.visit(tree);
        if (nodo != null && tree instanceof ParserRuleContext ctx && ctx.getStart() != null) {
            int l = ctx.getStart().getLine();
            int c = ctx.getStart().getCharPositionInLine() + 1;
            if (nodo instanceof Sentencia s) {
                s.setPosicion(l, c);
            } else if (nodo instanceof Expresion e) {
                e.setPosicion(l, c);
            }
        }
        return nodo;
    }

    @Override
    public ArbolAst visitProgram(CodexLatinusParser.ProgramContext ctx) {
        ArbolAst ast = new ArbolAst();

        if (ctx.globalVarsSection() != null) {
            for (ParseTree child : ctx.globalVarsSection().children) {
                if (child instanceof CodexLatinusParser.VarDeclContext
                        || child instanceof CodexLatinusParser.ArrayDeclContext
                        || child instanceof CodexLatinusParser.StructDeclContext
                        || child instanceof CodexLatinusParser.StructVarDeclContext) {
                    Sentencia st = (Sentencia) visit(child);
                    if (st != null) ast.agregarDeclaracionGlobal(st);
                }
            }
        }

        if (ctx.functionsSection() != null) {
            for (CodexLatinusParser.FunctionDeclContext fCtx : ctx.functionsSection().functionDecl()) {
                DeclaracionFuncion fn = (DeclaracionFuncion) visit(fCtx);
                if (fn != null) ast.agregarFuncion(fn);
            }
        }

        if (ctx.mainSection() != null) {
            for (CodexLatinusParser.StatementContext stCtx : ctx.mainSection().statement()) {
                Sentencia st = (Sentencia) visit(stCtx);
                if (st != null) ast.agregarSentenciaPrincipal(st);
            }
        }

        return ast;
    }

    @Override
    public Declaracion visitVarDecl(CodexLatinusParser.VarDeclContext ctx) {
        return visitanteSentencias.getVisitanteDeclaraciones().visitVarDecl(ctx);
    }

    @Override
    public DeclaracionArreglo visitArrayDecl(CodexLatinusParser.ArrayDeclContext ctx) {
        return visitanteSentencias.getVisitanteDeclaraciones().visitArrayDecl(ctx);
    }

    @Override
    public DeclaracionEstructura visitStructDecl(CodexLatinusParser.StructDeclContext ctx) {
        return visitanteSentencias.getVisitanteDeclaraciones().visitStructDecl(ctx);
    }

    @Override
    public DeclaracionInstanciaEstructura visitStructVarDecl(CodexLatinusParser.StructVarDeclContext ctx) {
        return visitanteSentencias.getVisitanteDeclaraciones().visitStructVarDecl(ctx);
    }

    @Override
    public SentenciaSi visitIfStmt(CodexLatinusParser.IfStmtContext ctx) {
        return visitanteSentencias.getVisitanteCondicionales().visitIfStmt(ctx);
    }

    @Override
    public BucleMientras visitWhileStmt(CodexLatinusParser.WhileStmtContext ctx) {
        return visitanteSentencias.getVisitanteCiclos().visitWhileStmt(ctx);
    }

    @Override
    public BucleHacerMientras visitDoWhileStmt(CodexLatinusParser.DoWhileStmtContext ctx) {
        return visitanteSentencias.getVisitanteCiclos().visitDoWhileStmt(ctx);
    }

    @Override
    public BuclePara visitForStmt(CodexLatinusParser.ForStmtContext ctx) {
        return visitanteSentencias.getVisitanteCiclos().visitForStmt(ctx);
    }

    @Override
    public Sentencia visitForInit(CodexLatinusParser.ForInitContext ctx) {
        return visitanteSentencias.getVisitanteCiclos().visitForInit(ctx);
    }

    @Override
    public Sentencia visitForUpdate(CodexLatinusParser.ForUpdateContext ctx) {
        return visitanteSentencias.getVisitanteCiclos().visitForUpdate(ctx);
    }

    @Override
    public SentenciaRomper visitBreakStmt(CodexLatinusParser.BreakStmtContext ctx) {
        return visitanteSentencias.getVisitanteCiclos().visitBreakStmt(ctx);
    }

    @Override
    public SentenciaContinuar visitContinueStmt(CodexLatinusParser.ContinueStmtContext ctx) {
        return visitanteSentencias.getVisitanteCiclos().visitContinueStmt(ctx);
    }

    @Override
    public DeclaracionFuncion visitFunctionDecl(CodexLatinusParser.FunctionDeclContext ctx) {
        return visitanteSentencias.getVisitanteFunciones().visitFunctionDecl(ctx);
    }

    @Override
    public SentenciaRetorno visitReturnStmt(CodexLatinusParser.ReturnStmtContext ctx) {
        return visitanteSentencias.getVisitanteFunciones().visitReturnStmt(ctx);
    }

    @Override
    public SentenciaImprimir visitPrintStmt(CodexLatinusParser.PrintStmtContext ctx) {
        return visitanteSentencias.getVisitanteIO().visitPrintStmt(ctx);
    }

    @Override
    public SentenciaLectura visitReadStmt(CodexLatinusParser.ReadStmtContext ctx) {
        return visitanteSentencias.getVisitanteIO().visitReadStmt(ctx);
    }

    @Override
    public Asignacion visitAssignStmt(CodexLatinusParser.AssignStmtContext ctx) {
        return visitanteSentencias.visitAssignStmt(ctx);
    }

    @Override
    public BloqueSentencias visitBlockStmt(CodexLatinusParser.BlockStmtContext ctx) {
        return visitanteSentencias.visitBlockStmt(ctx);
    }

    @Override
    public Sentencia visitExprStmt(CodexLatinusParser.ExprStmtContext ctx) {
        return visitanteSentencias.visitExprStmt(ctx);
    }

    @Override
    public OperacionUnaria visitUnaryExpr(CodexLatinusParser.UnaryExprContext ctx) {
        return visitanteExpresiones.getVisitanteOperaciones().visitUnaryExpr(ctx);
    }

    @Override
    public Operacion visitAdditiveExpr(CodexLatinusParser.AdditiveExprContext ctx) {
        return visitanteExpresiones.getVisitanteOperaciones().visitAdditiveExpr(ctx);
    }

    @Override
    public Operacion visitMultiplicativeExpr(CodexLatinusParser.MultiplicativeExprContext ctx) {
        return visitanteExpresiones.getVisitanteOperaciones().visitMultiplicativeExpr(ctx);
    }

    @Override
    public Operacion visitRelationalExpr(CodexLatinusParser.RelationalExprContext ctx) {
        return visitanteExpresiones.getVisitanteOperaciones().visitRelationalExpr(ctx);
    }

    @Override
    public Operacion visitEqualityExpr(CodexLatinusParser.EqualityExprContext ctx) {
        return visitanteExpresiones.getVisitanteOperaciones().visitEqualityExpr(ctx);
    }

    @Override
    public Operacion visitLogicalAndExpr(CodexLatinusParser.LogicalAndExprContext ctx) {
        return visitanteExpresiones.getVisitanteOperaciones().visitLogicalAndExpr(ctx);
    }

    @Override
    public Operacion visitLogicalOrExpr(CodexLatinusParser.LogicalOrExprContext ctx) {
        return visitanteExpresiones.getVisitanteOperaciones().visitLogicalOrExpr(ctx);
    }

    @Override
    public Literal visitLiteral(CodexLatinusParser.LiteralContext ctx) {
        return visitanteExpresiones.getVisitanteLiterales().visitLiteral(ctx);
    }

    @Override
    public InicializadorArreglo visitArrayInit(CodexLatinusParser.ArrayInitContext ctx) {
        return visitanteExpresiones.getVisitanteInicializadores().visitArrayInit(ctx);
    }

    @Override
    public InicializadorEstructura visitStructInit(CodexLatinusParser.StructInitContext ctx) {
        return visitanteExpresiones.getVisitanteInicializadores().visitStructInit(ctx);
    }

    @Override
    public AccesoVariable visitLvalue(CodexLatinusParser.LvalueContext ctx) {
        return visitanteExpresiones.getVisitanteAcceso().visitLvalue(ctx);
    }

    @Override
    public LlamadaFuncion visitFunctionCallExpr(CodexLatinusParser.FunctionCallExprContext ctx) {
        return visitanteExpresiones.getVisitanteAcceso().visitFunctionCallExpr(ctx);
    }

    @Override
    public Expresion visitPrimaryExpr(CodexLatinusParser.PrimaryExprContext ctx) {
        return visitanteExpresiones.visitPrimaryExpr(ctx);
    }

    @Override
    public Expresion visitPrimary(CodexLatinusParser.PrimaryContext ctx) {
        return visitanteExpresiones.visitPrimary(ctx);
    }

    @Override
    public Expresion visitParenExpr(CodexLatinusParser.ParenExprContext ctx) {
        return (Expresion) visit(ctx.expr());
    }

    @Override
    public Expresion visitLvalueExpr(CodexLatinusParser.LvalueExprContext ctx) {
        return (Expresion) visit(ctx.lvalue());
    }

    @Override
    public Expresion visitAssignExpr(CodexLatinusParser.AssignExprContext ctx) {
        return visitanteExpresiones.visitAssignExpr(ctx);
    }

    @Override
    public Expresion visitPostIncDecExpr(CodexLatinusParser.PostIncDecExprContext ctx) {
        return visitanteExpresiones.visitPostIncDecExpr(ctx);
    }
}
