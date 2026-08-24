package org.codexlatinus.ast.sentencias.declaraciones;

import org.codexlatinus.ast.sentencias.Sentencia;
import org.codexlatinus.model.ContextoEjecucion;
import org.codexlatinus.model.Entorno;
import org.codexlatinus.model.Simbolo;
import org.codexlatinus.utils.PigLatinTranslater;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class DeclaracionEstructura extends Sentencia {
    private final String nombre;
    private final Map<String, String> miembros;

    public DeclaracionEstructura(String nombre, Map<String, String> miembros) {
        this.nombre = nombre;
        this.miembros = miembros != null ? miembros : new LinkedHashMap<>();
    }

    public String getNombre() {
        return nombre;
    }

    public Map<String, String> getMiembros() {
        return Collections.unmodifiableMap(miembros);
    }

    @Override
    public void ejecutar(Entorno entorno, ContextoEjecucion ctx) {
        ctx.registrarEstructura(nombre, miembros);
        Simbolo sim = new Simbolo(nombre, "structura", "Definición Estructura", "Global", "[Estructura]", getLinea(), getColumna());
        ctx.registrarSimbolo(entorno, sim);
    }

    @Override
    public void aPigLatin(StringBuffer sb) {
        sb.append(PigLatinTranslater.traducir("structura")).append(" ").append(nombre).append(" {\n");
        for (Map.Entry<String, String> entry : miembros.entrySet()) {
            sb.append("    ").append(PigLatinTranslater.traducir("esto")).append(" ");
            sb.append(PigLatinTranslater.traducir(entry.getKey())).append(" : ");
            sb.append(PigLatinTranslater.traducir(entry.getValue())).append(";\n");
        }
        sb.append("} ").append(PigLatinTranslater.traducir("finis")).append(";");
    }
}
