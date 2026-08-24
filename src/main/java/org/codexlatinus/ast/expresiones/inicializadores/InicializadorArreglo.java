package org.codexlatinus.ast.expresiones.inicializadores;

import org.codexlatinus.ast.expresiones.Expresion;
import org.codexlatinus.model.ContextoEjecucion;
import org.codexlatinus.model.Entorno;

import java.util.List;

public class InicializadorArreglo extends Expresion {
    private final List<Expresion> elementos;

    public InicializadorArreglo(List<Expresion> elementos) {
        this.elementos = elementos;
    }

    public List<Expresion> getElementos() {
        return elementos;
    }

    @Override
    public Object evaluar(Entorno entorno, ContextoEjecucion ctx) {
        if (elementos != null) {
            Object[] arr = new Object[elementos.size()];
            for (int i = 0; i < elementos.size(); i++) {
                Expresion e = elementos.get(i);
                arr[i] = e != null ? e.evaluar(entorno, ctx) : null;
            }
            return arr;
        }
        return new Object[0];
    }

    @Override
    public void aPigLatin(StringBuffer sb) {
        sb.append("{");
        if (elementos != null) {
            for (int i = 0; i < elementos.size(); i++) {
                if (i > 0) sb.append(", ");
                elementos.get(i).aPigLatin(sb);
            }
        }
        sb.append("}");
    }
}
