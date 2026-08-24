package org.codexlatinus.ast.expresiones.inicializadores;

import org.antlr.v4.runtime.tree.ParseTree;
import org.codexlatinus.CodexLatinusParser;
import org.codexlatinus.ast.NodoAst;
import org.codexlatinus.ast.expresiones.Expresion;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class VisitanteInicializadores {

    private final Function<ParseTree, NodoAst> visitor;

    public VisitanteInicializadores(Function<ParseTree, NodoAst> visitor) {
        this.visitor = visitor;
    }

    public InicializadorArreglo visitArrayInit(CodexLatinusParser.ArrayInitContext ctx) {
        if (ctx == null) return null;

        List<Expresion> items = new ArrayList<>();
        if (ctx.exprList() != null) {
            for (CodexLatinusParser.ExprContext e : ctx.exprList().expr()) {
                items.add((Expresion) visitor.apply(e));
            }
        }
        return new InicializadorArreglo(items);
    }

    public InicializadorEstructura visitStructInit(CodexLatinusParser.StructInitContext ctx) {
        if (ctx == null) return null;

        Map<String, Expresion> attrs = new LinkedHashMap<>();
        if (ctx.structAttrAssignList() != null) {
            for (CodexLatinusParser.StructAttrAssignContext attr : ctx.structAttrAssignList().structAttrAssign()) {
                String aName = attr.Identifier(0).getText();
                Expresion aVal;
                if (attr.Identifier().size() > 1) {
                    String subTipo = attr.Identifier(1).getText();
                    Expresion dimExpr = attr.expr() != null ? (Expresion) visitor.apply(attr.expr()) : null;
                    aVal = new InicializadorArregloEstructura(subTipo, dimExpr);
                } else if (attr.expr() != null) {
                    aVal = (Expresion) visitor.apply(attr.expr());
                } else if (attr.structInit() != null) {
                    aVal = (Expresion) visitor.apply(attr.structInit());
                } else if (attr.arrayInit() != null) {
                    aVal = (Expresion) visitor.apply(attr.arrayInit());
                } else {
                    aVal = null;
                }
                attrs.put(aName, aVal);
            }
        }
        return new InicializadorEstructura(attrs);
    }
}
