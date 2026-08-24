package org.codexlatinus.ast.expresiones.operaciones;

import org.codexlatinus.ast.expresiones.Expresion;
import org.codexlatinus.model.ContextoEjecucion;
import org.codexlatinus.model.Entorno;
import org.codexlatinus.model.TiposHelper;
import org.codexlatinus.utils.PigLatinTranslater;

public class OperacionUnaria extends Expresion {
    private final String operador;
    private final Expresion expresion;

    public OperacionUnaria(String operador, Expresion expresion) {
        this.operador = operador;
        this.expresion = expresion;
    }

    public OperacionUnaria(Expresion expresion, String operador) {
        this.expresion = expresion;
        this.operador = operador;
    }

    public String getOperador() {
        return operador;
    }

    public Expresion getExpresion() {
        return expresion;
    }

    @Override
    public Object evaluar(Entorno entorno, ContextoEjecucion ctx) {
        Object val = expresion != null ? expresion.evaluar(entorno, ctx) : null;
        if (operador.equals("non") || operador.equals("!")) {
            if (!(val instanceof Boolean)) {
                ctx.agregarError("Operador inválido: 'non'/'!' requiere un operando booleano.", getLinea(), getColumna());
            }
            return !TiposHelper.esVerdadero(val);
        }
        if (operador.equals("-")) {
            if (val instanceof String || val instanceof Boolean) {
                ctx.agregarError("Operación inválida: No se puede aplicar el operador '-' a tipo " + TiposHelper.inferirTipoNombre(val) + ".", getLinea(), getColumna());
                return 0;
            }
            if (val instanceof Double d) return -d;
            return -TiposHelper.aEntero(val);
        }
        return val;
    }

    @Override
    public void aPigLatin(StringBuffer sb) {
        if ("non".equalsIgnoreCase(operador)) {
            sb.append(PigLatinTranslater.traducir("non")).append(" ");
        } else {
            sb.append(operador);
        }
        if (expresion != null) {
            expresion.aPigLatin(sb);
        }
    }
}
