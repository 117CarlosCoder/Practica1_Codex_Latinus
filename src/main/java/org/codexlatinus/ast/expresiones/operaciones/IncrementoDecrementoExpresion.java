package org.codexlatinus.ast.expresiones.operaciones;

import org.codexlatinus.ast.expresiones.Expresion;
import org.codexlatinus.ast.expresiones.acceso.AccesoVariable;
import org.codexlatinus.model.ContextoEjecucion;
import org.codexlatinus.model.Entorno;
import org.codexlatinus.model.TiposHelper;

public class IncrementoDecrementoExpresion extends Expresion {
    private final AccesoVariable lvalue;
    private final boolean esIncremento;

    public IncrementoDecrementoExpresion(AccesoVariable lvalue, boolean esIncremento) {
        this.lvalue = lvalue;
        this.esIncremento = esIncremento;
    }

    public AccesoVariable getLvalue() {
        return lvalue;
    }

    public boolean isEsIncremento() {
        return esIncremento;
    }

    @Override
    public Object evaluar(Entorno entorno, ContextoEjecucion ctx) {
        if (lvalue == null) return 0;
        Object actual = lvalue.evaluar(entorno, ctx);
        int viejo = TiposHelper.aEntero(actual);
        int nuevo = viejo + (esIncremento ? 1 : -1);
        lvalue.asignar(entorno, ctx, nuevo);
        return viejo;
    }

    @Override
    public void aPigLatin(StringBuffer sb) {
        if (lvalue != null) {
            lvalue.aPigLatin(sb);
        }
        sb.append(esIncremento ? "++" : "--");
    }
}
