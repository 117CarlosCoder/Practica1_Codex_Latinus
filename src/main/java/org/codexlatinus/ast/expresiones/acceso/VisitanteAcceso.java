package org.codexlatinus.ast.expresiones.acceso;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.codexlatinus.CodexLatinusParser;
import org.codexlatinus.ast.NodoAst;
import org.codexlatinus.ast.expresiones.Expresion;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class VisitanteAcceso {

    private final Function<ParseTree, NodoAst> visitor;

    public VisitanteAcceso(Function<ParseTree, NodoAst> visitor) {
        this.visitor = visitor;
    }

    public AccesoVariable visitLvalue(CodexLatinusParser.LvalueContext ctx) {
        if (ctx == null) return null;

        String baseId = ctx.Identifier(0).getText();
        AccesoVariable acceso = new AccesoVariable(baseId);

        for (int i = 0; i < ctx.getChildCount(); i++) {
            ParseTree child = ctx.getChild(i);
            if (child instanceof TerminalNode tn) {
                if (i > 0 && ctx.getChild(i - 1).getText().equals(".")) {
                    acceso.agregarCampo(tn.getText());
                }
            } else if (child instanceof CodexLatinusParser.ExprContext exprCtx) {
                acceso.agregarIndice((Expresion) visitor.apply(exprCtx));
            }
        }
        return acceso;
    }

    public LlamadaFuncion visitFunctionCallExpr(CodexLatinusParser.FunctionCallExprContext ctx) {
        if (ctx == null) return null;

        String nombre = ctx.Identifier().getText();
        List<Expresion> args = new ArrayList<>();
        if (ctx.arguments() != null) {
            for (CodexLatinusParser.ExprContext e : ctx.arguments().expr()) {
                args.add((Expresion) visitor.apply(e));
            }
        }
        return new LlamadaFuncion(nombre, args);
    }
}
