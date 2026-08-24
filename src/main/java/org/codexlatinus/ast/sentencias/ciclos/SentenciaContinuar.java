package org.codexlatinus.ast.sentencias.ciclos;

import org.codexlatinus.ast.sentencias.Sentencia;
import org.codexlatinus.model.ContextoEjecucion;
import org.codexlatinus.model.Entorno;
import org.codexlatinus.model.SenalesControl;
import org.codexlatinus.utils.PigLatinTranslater;

public class SentenciaContinuar extends Sentencia {
    @Override
    public void ejecutar(Entorno entorno, ContextoEjecucion ctx) {
        throw new SenalesControl.SenalContinue();
    }

    @Override
    public void aPigLatin(StringBuffer sb) {
        sb.append(PigLatinTranslater.traducir("perge")).append(";");
    }
}
