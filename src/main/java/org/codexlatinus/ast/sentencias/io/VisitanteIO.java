package org.codexlatinus.ast.sentencias.io;

import org.antlr.v4.runtime.tree.ParseTree;
import org.codexlatinus.CodexLatinusParser;
import org.codexlatinus.ast.NodoAst;
import org.codexlatinus.ast.expresiones.Expresion;
import org.codexlatinus.ast.expresiones.acceso.AccesoVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class VisitanteIO {

    private final Function<ParseTree, NodoAst> visitor;

    public VisitanteIO(Function<ParseTree, NodoAst> visitor) {
        this.visitor = visitor;
    }

    public SentenciaImprimir visitPrintStmt(CodexLatinusParser.PrintStmtContext ctx) {
        if (ctx == null) return null;
        List<Expresion> exprs = new ArrayList<>();
        for (CodexLatinusParser.ExprContext eCtx : ctx.expr()) {
            exprs.add((Expresion) visitor.apply(eCtx));
        }
        return new SentenciaImprimir(exprs);
    }

    public SentenciaLectura visitReadStmt(CodexLatinusParser.ReadStmtContext ctx) {
        if (ctx == null) return null;
        AccesoVariable target = null;
        if (ctx.lvalue() != null) {
            target = (AccesoVariable) visitor.apply(ctx.lvalue());
        } else if (ctx.Identifier() != null) {
            target = new AccesoVariable(ctx.Identifier().getText());
        }
        return new SentenciaLectura(target);
    }
}
