package org.codexlatinus.ast.sentencias.declaraciones;

import org.antlr.v4.runtime.tree.ParseTree;
import org.codexlatinus.CodexLatinusParser;
import org.codexlatinus.ast.NodoAst;
import org.codexlatinus.ast.expresiones.Expresion;
import org.codexlatinus.utils.Type;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;

public class VisitanteDeclaraciones {

    private final Function<ParseTree, NodoAst> visitor;

    public VisitanteDeclaraciones(Function<ParseTree    , NodoAst> visitor) {
        this.visitor = visitor;
    }

    public Declaracion visitVarDecl(CodexLatinusParser.VarDeclContext ctx) {
        if (ctx == null) return null;
        String id = ctx.Identifier().getText();
        Type tipo = new Type(ctx.primitiveType().getText());
        Expresion expr = ctx.expr() != null ? (Expresion) visitor.apply(ctx.expr()) : null;
        return new Declaracion(id, tipo, expr);
    }

    public DeclaracionArreglo visitArrayDecl(CodexLatinusParser.ArrayDeclContext ctx) {
        if (ctx == null) return null;
        String id = ctx.Identifier().getText();
        Expresion tamano = ctx.expr() != null ? (Expresion) visitor.apply(ctx.expr()) : null;
        Type tipo = ctx.primitiveType() != null ? new Type(ctx.primitiveType().getText()) : null;
        Expresion init = ctx.arrayInit() != null ? (Expresion) visitor.apply(ctx.arrayInit()) : null;
        return new DeclaracionArreglo(id, tamano, tipo, init);
    }

    public DeclaracionEstructura visitStructDecl(CodexLatinusParser.StructDeclContext ctx) {
        if (ctx == null) return null;
        String nombre = ctx.Identifier().getText();
        Map<String, String> miembros = new LinkedHashMap<>();
        for (CodexLatinusParser.StructMemberContext m : ctx.structMember()) {
            String mNombre = m.Identifier().getText();
            String mTipo = m.primitiveType() != null ? m.primitiveType().getText() : "bool";
            if (m.getText().contains("series") || m.expr() != null) {
                mTipo = mTipo + "[]";
            }
            miembros.put(mNombre, mTipo);
        }
        return new DeclaracionEstructura(nombre, miembros);
    }

    public DeclaracionInstanciaEstructura visitStructVarDecl(CodexLatinusParser.StructVarDeclContext ctx) {
        if (ctx == null) return null;
        String nombre = ctx.Identifier(0).getText();
        String tipo = ctx.Identifier(1).getText();
        Expresion init = ctx.structInit() != null ? (Expresion) visitor.apply(ctx.structInit()) : null;
        return new DeclaracionInstanciaEstructura(nombre, tipo, init);
    }
}
