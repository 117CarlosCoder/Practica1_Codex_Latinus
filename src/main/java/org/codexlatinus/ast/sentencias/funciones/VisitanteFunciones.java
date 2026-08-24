package org.codexlatinus.ast.sentencias.funciones;

import org.antlr.v4.runtime.tree.ParseTree;
import org.codexlatinus.CodexLatinusParser;
import org.codexlatinus.ast.NodoAst;
import org.codexlatinus.ast.expresiones.Expresion;
import org.codexlatinus.ast.sentencias.Sentencia;
import org.codexlatinus.utils.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class VisitanteFunciones {

    private final Function<ParseTree, NodoAst> visitor;

    public VisitanteFunciones(Function<ParseTree, NodoAst> visitor) {
        this.visitor = visitor;
    }

    public DeclaracionFuncion visitFunctionDecl(CodexLatinusParser.FunctionDeclContext ctx) {
        if (ctx == null) return null;

        String nombre = ctx.Identifier().getText();
        boolean esAccion = ctx.getText().startsWith("actio");
        Type tipoRetorno = ctx.primitiveType() != null ? new Type(ctx.primitiveType().getText()) : new Type("void");

        List<DeclaracionFuncion.Parametro> params = new ArrayList<>();
        if (ctx.formalParameters() != null) {
            for (CodexLatinusParser.FormalParameterContext p : ctx.formalParameters().formalParameter()) {
                params.add(new DeclaracionFuncion.Parametro(p.Identifier().getText(), new Type(p.primitiveType().getText())));
            }
        }

        DeclaracionFuncion func = new DeclaracionFuncion(nombre, tipoRetorno, params, esAccion);

        if (ctx.funcVarSection() != null) {
            for (ParseTree child : ctx.funcVarSection().children) {
                if (child instanceof CodexLatinusParser.VarDeclContext
                        || child instanceof CodexLatinusParser.ArrayDeclContext
                        || child instanceof CodexLatinusParser.StructDeclContext
                        || child instanceof CodexLatinusParser.StructVarDeclContext) {
                    Sentencia v = (Sentencia) visitor.apply(child);
                    if (v != null) func.agregarVariableLocal(v);
                }
            }
        }

        for (CodexLatinusParser.StatementContext st : ctx.statement()) {
            func.agregarSentencia((Sentencia) visitor.apply(st));
        }

        return func;
    }

    public SentenciaRetorno visitReturnStmt(CodexLatinusParser.ReturnStmtContext ctx) {
        if (ctx == null) return null;
        Expresion expr = ctx.expr() != null ? (Expresion) visitor.apply(ctx.expr()) : null;
        return new SentenciaRetorno(expr);
    }
}
