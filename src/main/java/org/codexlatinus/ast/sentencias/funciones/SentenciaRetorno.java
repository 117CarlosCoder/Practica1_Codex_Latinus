package org.codexlatinus.ast.sentencias.funciones;

import org.codexlatinus.ast.expresiones.Expresion;
import org.codexlatinus.ast.sentencias.Sentencia;
import org.codexlatinus.model.ContextoEjecucion;
import org.codexlatinus.model.Entorno;
import org.codexlatinus.model.SenalesControl;
import org.codexlatinus.utils.PigLatinTranslater;

public class SentenciaRetorno extends Sentencia {
    private final Expresion expresion;

    public SentenciaRetorno(Expresion expresion) {
        this.expresion = expresion;
    }

    public Expresion getExpresion() {
        return expresion;
    }

    @Override
    public void ejecutar(Entorno entorno, ContextoEjecucion ctx) {
        Object val = expresion != null ? expresion.evaluar(entorno, ctx) : null;
        throw new SenalesControl.SenalReturn(val);
    }

    @Override
    public void aPigLatin(StringBuffer sb) {
        sb.append(PigLatinTranslater.traducir("reddere"));
        if (expresion != null) {
            sb.append(" ");
            expresion.aPigLatin(sb);
        }
        sb.append(";");
    }
}
