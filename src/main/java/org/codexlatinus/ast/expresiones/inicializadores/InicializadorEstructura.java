package org.codexlatinus.ast.expresiones.inicializadores;

import org.codexlatinus.ast.expresiones.Expresion;
import org.codexlatinus.model.ContextoEjecucion;
import org.codexlatinus.model.Entorno;
import org.codexlatinus.utils.PigLatinTranslater;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class InicializadorEstructura extends Expresion {
    private final Map<String, Expresion> atributos;

    public InicializadorEstructura(Map<String, Expresion> atributos) {
        this.atributos = atributos != null ? atributos : new LinkedHashMap<>();
    }

    public Map<String, Expresion> getAtributos() {
        return Collections.unmodifiableMap(atributos);
    }

    @Override
    public Object evaluar(Entorno entorno, ContextoEjecucion ctx) {
        Map<String, Object> instancia = new LinkedHashMap<>();
        for (Map.Entry<String, Expresion> entry : atributos.entrySet()) {
            String attrNombre = entry.getKey();
            Expresion attrExpr = entry.getValue();
            Object attrValor = attrExpr != null ? attrExpr.evaluar(entorno, ctx) : null;
            instancia.put(attrNombre, attrValor);
        }
        return instancia;
    }

    @Override
    public void aPigLatin(StringBuffer sb) {
        sb.append("{\n");
        int count = 0;
        for (Map.Entry<String, Expresion> entry : atributos.entrySet()) {
            if (count > 0) sb.append(",\n");
            sb.append("    ").append(PigLatinTranslater.traducir(entry.getKey())).append(": ");
            if (entry.getValue() != null) {
                entry.getValue().aPigLatin(sb);
            }
            count++;
        }
        sb.append("\n}");
    }
}
