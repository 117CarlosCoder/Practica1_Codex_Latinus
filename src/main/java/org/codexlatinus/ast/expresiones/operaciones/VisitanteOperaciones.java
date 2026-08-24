package org.codexlatinus.ast.expresiones.operaciones;

import org.antlr.v4.runtime.tree.ParseTree;
import org.codexlatinus.CodexLatinusParser;
import org.codexlatinus.ast.NodoAst;
import org.codexlatinus.ast.expresiones.Expresion;

import java.util.function.Function;

public class VisitanteOperaciones {

    private final Function<ParseTree, NodoAst> visitor;

    public VisitanteOperaciones(Function<ParseTree, NodoAst> visitor) {
        this.visitor = visitor;
    }

    public OperacionUnaria visitUnaryExpr(CodexLatinusParser.UnaryExprContext ctx) {
        if (ctx == null) return null;
        Expresion expr = (Expresion) visitor.apply(ctx.expr());
        return new OperacionUnaria(expr, ctx.op.getText());
    }

    public Operacion visitAdditiveExpr(CodexLatinusParser.AdditiveExprContext ctx) {
        if (ctx == null) return null;
        Expresion left = (Expresion) visitor.apply(ctx.expr(0));
        Expresion right = (Expresion) visitor.apply(ctx.expr(1));
        return new Operacion(left, right, ctx.op.getText());
    }

    public Operacion visitMultiplicativeExpr(CodexLatinusParser.MultiplicativeExprContext ctx) {
        if (ctx == null) return null;
        Expresion left = (Expresion) visitor.apply(ctx.expr(0));
        Expresion right = (Expresion) visitor.apply(ctx.expr(1));
        return new Operacion(left, right, ctx.op.getText());
    }

    public Operacion visitRelationalExpr(CodexLatinusParser.RelationalExprContext ctx) {
        if (ctx == null) return null;
        Expresion left = (Expresion) visitor.apply(ctx.expr(0));
        Expresion right = (Expresion) visitor.apply(ctx.expr(1));
        return new Operacion(left, right, ctx.op.getText());
    }

    public Operacion visitEqualityExpr(CodexLatinusParser.EqualityExprContext ctx) {
        if (ctx == null) return null;
        Expresion left = (Expresion) visitor.apply(ctx.expr(0));
        Expresion right = (Expresion) visitor.apply(ctx.expr(1));
        return new Operacion(left, right, ctx.op.getText());
    }

    public Operacion visitLogicalAndExpr(CodexLatinusParser.LogicalAndExprContext ctx) {
        if (ctx == null) return null;
        Expresion left = (Expresion) visitor.apply(ctx.expr(0));
        Expresion right = (Expresion) visitor.apply(ctx.expr(1));
        return new Operacion(left, right, "&&");
    }

    public Operacion visitLogicalOrExpr(CodexLatinusParser.LogicalOrExprContext ctx) {
        if (ctx == null) return null;
        Expresion left = (Expresion) visitor.apply(ctx.expr(0));
        Expresion right = (Expresion) visitor.apply(ctx.expr(1));
        return new Operacion(left, right, "||");
    }
}
