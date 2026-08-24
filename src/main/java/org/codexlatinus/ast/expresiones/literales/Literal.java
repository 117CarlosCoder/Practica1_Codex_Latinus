package org.codexlatinus.ast.expresiones.literales;

import org.codexlatinus.ast.expresiones.Expresion;
import org.codexlatinus.model.ContextoEjecucion;
import org.codexlatinus.model.Entorno;
import org.codexlatinus.utils.PigLatinTranslater;

public class Literal extends Expresion {
    private final String tipo;
    private final Object valor;

    public Literal(String tipo, Object valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    public Literal(Object valor) {
        this.tipo = null;
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public Object getValor() {
        return valor;
    }

    @Override
    public Object evaluar(Entorno entorno, ContextoEjecucion ctx) {
        return valor;
    }

    @Override
    public void aPigLatin(StringBuffer sb) {
        if (valor instanceof String) {
            sb.append("\"").append(valor).append("\"");
        } else if (valor instanceof Character) {
            sb.append("'").append(valor).append("'");
        } else if (valor instanceof Boolean) {
            boolean b = (Boolean) valor;
            sb.append(PigLatinTranslater.traducir(b ? "verum" : "falsus"));
        } else if (valor != null) {
            sb.append(valor.toString());
        } else {
            sb.append("null");
        }
    }
}
