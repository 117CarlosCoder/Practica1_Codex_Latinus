package org.codexlatinus.ast.sentencias;

import org.antlr.v4.runtime.tree.ParseTree;
import org.codexlatinus.CodexLatinusParser;
import org.codexlatinus.ast.NodoAst;
import org.codexlatinus.ast.expresiones.Expresion;
import org.codexlatinus.ast.expresiones.acceso.AccesoVariable;
import org.codexlatinus.ast.sentencias.ciclos.VisitanteCiclos;
import org.codexlatinus.ast.sentencias.condicionales.VisitanteCondicionales;
import org.codexlatinus.ast.sentencias.declaraciones.VisitanteDeclaraciones;
import org.codexlatinus.ast.sentencias.funciones.VisitanteFunciones;
import org.codexlatinus.ast.sentencias.io.VisitanteIO;

import java.util.function.Function;

public class VisitanteSentencias {

    private final Function<ParseTree, NodoAst> visitor;
    private final VisitanteDeclaraciones visitanteDeclaraciones;
    private final VisitanteCondicionales visitanteCondicionales;
    private final VisitanteCiclos visitanteCiclos;
    private final VisitanteFunciones visitanteFunciones;
    private final VisitanteIO visitanteIO;

    public VisitanteSentencias(Function<ParseTree, NodoAst> visitor) {
        this.visitor = visitor;
        this.visitanteDeclaraciones = new VisitanteDeclaraciones(visitor);
        this.visitanteCondicionales = new VisitanteCondicionales(visitor);
        this.visitanteCiclos = new VisitanteCiclos(visitor);
        this.visitanteFunciones = new VisitanteFunciones(visitor);
        this.visitanteIO = new VisitanteIO(visitor);
    }

    public VisitanteDeclaraciones getVisitanteDeclaraciones() {
        return visitanteDeclaraciones;
    }

    public VisitanteCondicionales getVisitanteCondicionales() {
        return visitanteCondicionales;
    }

    public VisitanteCiclos getVisitanteCiclos() {
        return visitanteCiclos;
    }

    public VisitanteFunciones getVisitanteFunciones() {
        return visitanteFunciones;
    }

    public VisitanteIO getVisitanteIO() {
        return visitanteIO;
    }

    public Asignacion visitAssignStmt(CodexLatinusParser.AssignStmtContext ctx) {
        if (ctx == null) return null;
        AccesoVariable lval = ctx.lvalue() != null ? (AccesoVariable) visitor.apply(ctx.lvalue()) : null;
        if (ctx.expr() != null) {
            Expresion expr = (Expresion) visitor.apply(ctx.expr());
            return new Asignacion(lval, expr, "=");
        }
        String op = ctx.getText().contains("++") ? "++" : "--";
        return new Asignacion(lval, null, op);
    }

    public BloqueSentencias visitBlockStmt(CodexLatinusParser.BlockStmtContext ctx) {
        if (ctx == null) return null;
        BloqueSentencias blk = new BloqueSentencias();
        for (CodexLatinusParser.StatementContext st : ctx.statement()) {
            blk.agregarSentencia((Sentencia) visitor.apply(st));
        }
        return blk;
    }

    public Sentencia visitExprStmt(CodexLatinusParser.ExprStmtContext ctx) {
        if (ctx == null) return null;
        Expresion expr = (Expresion) visitor.apply(ctx.expr());
        return new SentenciaExpresion(expr);
    }
}
