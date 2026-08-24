package org.codexlatinus.ast.expresiones.inicializadores;

import org.codexlatinus.ast.expresiones.Expresion;
import org.codexlatinus.model.ContextoEjecucion;
import org.codexlatinus.model.Entorno;
import org.codexlatinus.model.TiposHelper;

public class InicializadorArregloEstructura extends Expresion {
    private final String tipoEstructura;
    private final Expresion dimensionExpr;

    public InicializadorArregloEstructura(String tipoEstructura, Expresion dimensionExpr) {
        this.tipoEstructura = tipoEstructura;
        this.dimensionExpr = dimensionExpr;
    }

    public String getTipoEstructura() {
        return tipoEstructura;
    }

    public Expresion getDimensionExpr() {
        return dimensionExpr;
    }

    @Override
    public Object evaluar(Entorno entorno, ContextoEjecucion ctx) {
        int dim = dimensionExpr != null ? TiposHelper.aEntero(dimensionExpr.evaluar(entorno, ctx)) : 0;
        Object[] arr = new Object[Math.max(0, dim)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ctx.crearInstanciaStructPorDefecto(tipoEstructura);
        }
        return arr;
    }

    @Override
    public void aPigLatin(StringBuffer sb) {
        sb.append(tipoEstructura).append("[");
        if (dimensionExpr != null) {
            dimensionExpr.aPigLatin(sb);
        }
        sb.append("]");
    }
}
