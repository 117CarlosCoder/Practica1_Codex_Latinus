package org.codexlatinus.ast.expresiones.operaciones;

import org.codexlatinus.ast.expresiones.Expresion;
import org.codexlatinus.ast.expresiones.acceso.AccesoVariable;
import org.codexlatinus.model.ContextoEjecucion;
import org.codexlatinus.model.Entorno;

public class AsignacionExpresion extends Expresion {
    private final AccesoVariable lvalue;
    private final Expresion expresion;

    public AsignacionExpresion(AccesoVariable lvalue, Expresion expresion) {
        this.lvalue = lvalue;
        this.expresion = expresion;
    }

    public AccesoVariable getLvalue() {
        return lvalue;
    }

    public Expresion getExpresion() {
        return expresion;
    }

    @Override
    public Object evaluar(Entorno entorno, ContextoEjecucion ctx) {
        Object val = expresion != null ? expresion.evaluar(entorno, ctx) : null;
        if (lvalue != null) {
            lvalue.asignar(entorno, ctx, val);
        }
        return val;
    }

    @Override
    public void aPigLatin(StringBuffer sb) {
        if (lvalue != null) {
            lvalue.aPigLatin(sb);
        }
        sb.append(" = ");
        if (expresion != null) {
            expresion.aPigLatin(sb);
        }
    }
}
