package org.codexlatinus.ast.sentencias;

import org.codexlatinus.ast.expresiones.Expresion;
import org.codexlatinus.ast.expresiones.acceso.AccesoVariable;
import org.codexlatinus.model.ContextoEjecucion;
import org.codexlatinus.model.Entorno;
import org.codexlatinus.model.Simbolo;
import org.codexlatinus.model.TiposHelper;

public class Asignacion extends Sentencia {
    private final AccesoVariable lvalue;
    private final String lvalueTexto;
    private final Expresion expresion;
    private final String operador;

    public Asignacion(AccesoVariable lvalue, Expresion expresion, String operador) {
        this.lvalue = lvalue;
        this.lvalueTexto = lvalue != null ? lvalue.getIdentificador() : "";
        this.expresion = expresion;
        this.operador = operador != null ? operador : "=";
    }

    public Asignacion(AccesoVariable lvalue, Expresion expresion) {
        this(lvalue, expresion, "=");
    }

    public Asignacion(String lvalueTexto, Expresion expresion) {
        this.lvalue = null;
        this.lvalueTexto = lvalueTexto;
        this.expresion = expresion;
        this.operador = "=";
    }

    public Asignacion(String lvalueTexto, String operador) {
        this.lvalue = null;
        this.lvalueTexto = lvalueTexto;
        this.expresion = null;
        this.operador = operador;
    }

    public AccesoVariable getLvalue() {
        return lvalue;
    }

    public String getLvalueTexto() {
        return lvalueTexto;
    }

    public Expresion getExpresion() {
        return expresion;
    }

    public String getOperador() {
        return operador;
    }

    @Override
    public void ejecutar(Entorno entorno, ContextoEjecucion ctx) {
        AccesoVariable lvalor = lvalue;
        if (lvalor == null && lvalueTexto != null && !lvalueTexto.isEmpty()) {
            lvalor = new AccesoVariable(lvalueTexto);
        }
        if (lvalor == null) return;

        if (expresion != null) {
            Object valor = expresion.evaluar(entorno, ctx);
            if (lvalor.getAccesosHijos().isEmpty()) {
                Simbolo sim = entorno.obtenerSimbolo(lvalor.getIdentificador());
                if (sim != null && valor != null && !TiposHelper.esCompatible(sim.getTipo(), valor)) {
                    ctx.agregarError("Tipo incompatible: No se puede asignar valor de tipo '" + TiposHelper.inferirTipoNombre(valor) + "' a la variable '" + sim.getNombre() + "' de tipo '" + sim.getTipo() + "'.", getLinea(), getColumna());
                }
            }
            lvalor.asignar(entorno, ctx, valor);
        } else if (operador != null && (operador.equals("++") || operador.equals("--"))) {
            Object actual = lvalor.evaluar(entorno, ctx);
            if (!(actual instanceof Integer) && !(actual instanceof Long)) {
                ctx.agregarError("Operador inválido: '" + operador + "' solo puede aplicarse a tipos enteros ('numerus').", getLinea(), getColumna());
            }
            int viejo = TiposHelper.aEntero(actual);
            int nuevo = viejo + (operador.equals("++") ? 1 : -1);
            lvalor.asignar(entorno, ctx, nuevo);
        }
    }

    @Override
    public void aPigLatin(StringBuffer sb) {
        if (lvalue != null) {
            lvalue.aPigLatin(sb);
        } else if (lvalueTexto != null) {
            sb.append(lvalueTexto);
        }

        if (operador != null && (operador.equals("++") || operador.equals("--"))) {
            sb.append(operador).append(";");
        } else {
            sb.append(" = ");
            if (expresion != null) {
                expresion.aPigLatin(sb);
            }
            sb.append(";");
        }
    }
}
