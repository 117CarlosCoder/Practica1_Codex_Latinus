package org.codexlatinus.ast.sentencias.ciclos;

import org.antlr.v4.runtime.tree.ParseTree;
import org.codexlatinus.CodexLatinusParser;
import org.codexlatinus.ast.NodoAst;
import org.codexlatinus.ast.expresiones.Expresion;
import org.codexlatinus.ast.expresiones.acceso.AccesoVariable;
import org.codexlatinus.ast.sentencias.Asignacion;
import org.codexlatinus.ast.sentencias.Sentencia;
import org.codexlatinus.ast.sentencias.declaraciones.Declaracion;
import org.codexlatinus.utils.Type;

import java.util.function.Function;

public class VisitanteCiclos {

    private final Function<ParseTree, NodoAst> visitor;

    public VisitanteCiclos(Function<ParseTree, NodoAst> visitor) {
        this.visitor = visitor;
    }

    public BucleMientras visitWhileStmt(CodexLatinusParser.WhileStmtContext ctx) {
        if (ctx == null) return null;
        Expresion cond = (Expresion) visitor.apply(ctx.expr());
        BucleMientras whileStmt = new BucleMientras(cond);
        for (CodexLatinusParser.StatementContext st : ctx.statement()) {
            whileStmt.agregarSentencia((Sentencia) visitor.apply(st));
        }
        return whileStmt;
    }

    public BucleHacerMientras visitDoWhileStmt(CodexLatinusParser.DoWhileStmtContext ctx) {
        if (ctx == null) return null;
        Expresion cond = (Expresion) visitor.apply(ctx.expr());
        BucleHacerMientras doWhile = new BucleHacerMientras(cond);
        for (CodexLatinusParser.StatementContext st : ctx.statement()) {
            doWhile.agregarSentencia((Sentencia) visitor.apply(st));
        }
        return doWhile;
    }

    public BuclePara visitForStmt(CodexLatinusParser.ForStmtContext ctx) {
        if (ctx == null) return null;
        Sentencia init = ctx.forInit() != null ? (Sentencia) visitor.apply(ctx.forInit()) : null;
        Expresion cond = ctx.expr() != null ? (Expresion) visitor.apply(ctx.expr()) : null;
        Sentencia update = ctx.forUpdate() != null ? (Sentencia) visitor.apply(ctx.forUpdate()) : null;

        BuclePara forStmt = new BuclePara(init, cond, update);
        for (CodexLatinusParser.StatementContext st : ctx.statement()) {
            forStmt.agregarSentencia((Sentencia) visitor.apply(st));
        }
        return forStmt;
    }

    public Sentencia visitForInit(CodexLatinusParser.ForInitContext ctx) {
        if (ctx == null) return null;
        if (ctx.Identifier() != null && ctx.primitiveType() != null) {
            String id = ctx.Identifier().getText();
            Type tipo = new Type(ctx.primitiveType().getText());
            Expresion expr = ctx.expr() != null ? (Expresion) visitor.apply(ctx.expr()) : null;
            return new Declaracion(id, tipo, expr);
        }
        if (ctx.lvalue() != null && ctx.expr() != null) {
            AccesoVariable lval = (AccesoVariable) visitor.apply(ctx.lvalue());
            Expresion expr = (Expresion) visitor.apply(ctx.expr());
            return new Asignacion(lval, expr);
        }
        return null;
    }

    public Sentencia visitForUpdate(CodexLatinusParser.ForUpdateContext ctx) {
        if (ctx == null) return null;
        if (ctx.lvalue() != null) {
            AccesoVariable lval = (AccesoVariable) visitor.apply(ctx.lvalue());
            if (ctx.getText().contains("++") || ctx.getText().contains("--")) {
                String op = ctx.getText().contains("++") ? "++" : "--";
                return new Asignacion(lval, null, op);
            }
            if (ctx.expr() != null) {
                Expresion expr = (Expresion) visitor.apply(ctx.expr());
                return new Asignacion(lval, expr);
            }
        }
        return null;
    }

    public SentenciaRomper visitBreakStmt(CodexLatinusParser.BreakStmtContext ctx) {
        return new SentenciaRomper();
    }

    public SentenciaContinuar visitContinueStmt(CodexLatinusParser.ContinueStmtContext ctx) {
        return new SentenciaContinuar();
    }
}
