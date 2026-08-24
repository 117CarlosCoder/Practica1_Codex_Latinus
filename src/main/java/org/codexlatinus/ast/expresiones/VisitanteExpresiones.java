package org.codexlatinus.ast.expresiones;

import org.antlr.v4.runtime.tree.ParseTree;
import org.codexlatinus.CodexLatinusParser;
import org.codexlatinus.ast.NodoAst;
import org.codexlatinus.ast.expresiones.acceso.AccesoVariable;
import org.codexlatinus.ast.expresiones.acceso.VisitanteAcceso;
import org.codexlatinus.ast.expresiones.inicializadores.VisitanteInicializadores;
import org.codexlatinus.ast.expresiones.literales.Literal;
import org.codexlatinus.ast.expresiones.literales.VisitanteLiterales;
import org.codexlatinus.ast.expresiones.operaciones.AsignacionExpresion;
import org.codexlatinus.ast.expresiones.operaciones.IncrementoDecrementoExpresion;
import org.codexlatinus.ast.expresiones.operaciones.VisitanteOperaciones;

import java.util.function.Function;

public class VisitanteExpresiones {

    private final Function<ParseTree, NodoAst> visitor;
    private final VisitanteLiterales visitanteLiterales;
    private final VisitanteInicializadores visitanteInicializadores;
    private final VisitanteOperaciones visitanteOperaciones;
    private final VisitanteAcceso visitanteAcceso;

    public VisitanteExpresiones(Function<ParseTree, NodoAst> visitor) {
        this.visitor = visitor;
        this.visitanteLiterales = new VisitanteLiterales();
        this.visitanteInicializadores = new VisitanteInicializadores(visitor);
        this.visitanteOperaciones = new VisitanteOperaciones(visitor);
        this.visitanteAcceso = new VisitanteAcceso(visitor);
    }

    public VisitanteLiterales getVisitanteLiterales() {
        return visitanteLiterales;
    }

    public VisitanteInicializadores getVisitanteInicializadores() {
        return visitanteInicializadores;
    }

    public VisitanteOperaciones getVisitanteOperaciones() {
        return visitanteOperaciones;
    }

    public VisitanteAcceso getVisitanteAcceso() {
        return visitanteAcceso;
    }

    public Expresion visitPrimaryExpr(CodexLatinusParser.PrimaryExprContext ctx) {
        if (ctx == null) return null;
        return (Expresion) visitor.apply(ctx.primary());
    }

    public Expresion visitPrimary(CodexLatinusParser.PrimaryContext ctx) {
        if (ctx == null) return null;

        if (ctx.BOOL_LITERAL() != null) {
            return new Literal("bool", ctx.BOOL_LITERAL().getText().equals("verum"));
        }
        if (ctx.literal() != null) {
            return (Expresion) visitor.apply(ctx.literal());
        }
        if (ctx.structInit() != null) {
            return (Expresion) visitor.apply(ctx.structInit());
        }
        if (ctx.arrayInit() != null) {
            return (Expresion) visitor.apply(ctx.arrayInit());
        }
        if (ctx.Identifier() != null) {
            return new AccesoVariable(ctx.Identifier().getText());
        }
        return null;
    }

    public Expresion visitAssignExpr(CodexLatinusParser.AssignExprContext ctx) {
        if (ctx == null) return null;
        AccesoVariable lval = (AccesoVariable) visitor.apply(ctx.lvalue());
        Expresion expr = (Expresion) visitor.apply(ctx.expr());
        return new AsignacionExpresion(lval, expr);
    }

    public Expresion visitPostIncDecExpr(CodexLatinusParser.PostIncDecExprContext ctx) {
        if (ctx == null) return null;
        AccesoVariable lval = (AccesoVariable) visitor.apply(ctx.lvalue());
        boolean esInc = ctx.getText().contains("++");
        return new IncrementoDecrementoExpresion(lval, esInc);
    }
}
