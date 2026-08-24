package org.codexlatinus.ast.sentencias.io;

import org.codexlatinus.ast.expresiones.Expresion;
import org.codexlatinus.ast.sentencias.Sentencia;
import org.codexlatinus.model.ContextoEjecucion;
import org.codexlatinus.model.Entorno;
import org.codexlatinus.model.TiposHelper;
import org.codexlatinus.utils.PigLatinTranslater;

import java.util.Collections;
import java.util.List;

public class SentenciaImprimir extends Sentencia {
    private final List<Expresion> expresiones;

    public SentenciaImprimir(List<Expresion> expresiones) {
        this.expresiones = expresiones;
    }

    public List<Expresion> getExpresiones() {
        return Collections.unmodifiableList(expresiones);
    }

    @Override
    public void ejecutar(Entorno entorno, ContextoEjecucion ctx) {
        if (ctx.esCancelado()) return;
        StringBuilder sb = new StringBuilder();
        if (expresiones != null) {
            for (int i = 0; i < expresiones.size(); i++) {
                Expresion e = expresiones.get(i);
                Object val = e != null ? e.evaluar(entorno, ctx) : null;
                if (i > 0) sb.append(" ");
                sb.append(TiposHelper.formatearSalida(val));
            }
        }
        ctx.imprimirConsola(sb.toString());
    }

    @Override
    public void aPigLatin(StringBuffer sb) {
        sb.append(PigLatinTranslater.traducir(">>"));
        if (expresiones != null) {
            for (Expresion e : expresiones) {
                sb.append(" ").append(PigLatinTranslater.traducir(">>")).append(" ");
                e.aPigLatin(sb);
            }
        }
        sb.append(";");
    }
}
