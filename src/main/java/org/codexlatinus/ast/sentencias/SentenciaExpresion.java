package org.codexlatinus.ast.sentencias;

import org.codexlatinus.ast.expresiones.Expresion;
import org.codexlatinus.model.ContextoEjecucion;
import org.codexlatinus.model.Entorno;

public class SentenciaExpresion extends Sentencia {
    private final Expresion expresion;

    public SentenciaExpresion(Expresion expresion) {
        this.expresion = expresion;
    }

    public Expresion getExpresion() {
        return expresion;
    }

    @Override
    public void ejecutar(Entorno entorno, ContextoEjecucion ctx) {
        if (expresion != null) {
            expresion.evaluar(entorno, ctx);
        }
    }

    @Override
    public void aPigLatin(StringBuffer sb) {
        if (expresion != null) {
            expresion.aPigLatin(sb);
            sb.append(";");
        }
    }
}
