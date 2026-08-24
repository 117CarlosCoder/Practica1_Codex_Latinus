package org.codexlatinus.ast.sentencias.condicionales;

import org.antlr.v4.runtime.tree.ParseTree;
import org.codexlatinus.CodexLatinusParser;
import org.codexlatinus.ast.NodoAst;
import org.codexlatinus.ast.expresiones.Expresion;
import org.codexlatinus.ast.sentencias.Sentencia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class VisitanteCondicionales {

    private final Function<ParseTree, NodoAst> visitor;

    public VisitanteCondicionales(Function<ParseTree, NodoAst> visitor) {
        this.visitor = visitor;
    }

    public SentenciaSi visitIfStmt(CodexLatinusParser.IfStmtContext ctx) {
        if (ctx == null) return null;

        Expresion cond = (Expresion) visitor.apply(ctx.expr(0));
        SentenciaSi ifStmt = new SentenciaSi(cond);

        // Bloque principal si
        List<CodexLatinusParser.StatementContext> stmts0 = obtenerBloqueSentencias(ctx, 0);
        for (CodexLatinusParser.StatementContext st : stmts0) {
            ifStmt.agregarSentencia((Sentencia) visitor.apply(st));
        }

        // Bloques aliter si
        int numCond = ctx.expr().size();
        for (int k = 1; k < numCond; k++) {
            Expresion elifCond = (Expresion) visitor.apply(ctx.expr(k));
            List<CodexLatinusParser.StatementContext> stmtsK = obtenerBloqueSentencias(ctx, k);
            List<Sentencia> stmtsList = new ArrayList<>();
            for (CodexLatinusParser.StatementContext st : stmtsK) {
                stmtsList.add((Sentencia) visitor.apply(st));
            }
            ifStmt.agregarRamaSiNoSi(elifCond, stmtsList);
        }

        // Bloque aliter final
        if (ctx.getText().contains("aliter") && obtenerBloqueSentencias(ctx, numCond).size() > 0) {
            List<CodexLatinusParser.StatementContext> elseStmts = obtenerBloqueSentencias(ctx, numCond);
            for (CodexLatinusParser.StatementContext st : elseStmts) {
                ifStmt.agregarSentenciaSiNo((Sentencia) visitor.apply(st));
            }
        }

        return ifStmt;
    }

    private List<CodexLatinusParser.StatementContext> obtenerBloqueSentencias(CodexLatinusParser.IfStmtContext ctx, int indiceBloque) {
        List<List<CodexLatinusParser.StatementContext>> bloques = new ArrayList<>();
        List<CodexLatinusParser.StatementContext> actual = null;

        for (int i = 0; i < ctx.getChildCount(); i++) {
            ParseTree child = ctx.getChild(i);
            String txt = child.getText();
            if (txt.equals("{")) {
                actual = new ArrayList<>();
            } else if (txt.equals("}")) {
                if (actual != null) {
                    bloques.add(actual);
                    actual = null;
                }
            } else if (actual != null && child instanceof CodexLatinusParser.StatementContext st) {
                actual.add(st);
            }
        }
        return (indiceBloque < bloques.size()) ? bloques.get(indiceBloque) : Collections.emptyList();
    }
}
