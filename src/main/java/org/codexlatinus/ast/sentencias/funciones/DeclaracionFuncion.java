package org.codexlatinus.ast.sentencias.funciones;

import org.codexlatinus.ast.ContenedorSentencias;
import org.codexlatinus.ast.sentencias.Sentencia;
import org.codexlatinus.model.ContextoEjecucion;
import org.codexlatinus.model.Entorno;
import org.codexlatinus.model.Simbolo;
import org.codexlatinus.utils.PigLatinTranslater;
import org.codexlatinus.utils.Type;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeclaracionFuncion extends Sentencia implements ContenedorSentencias {
    private final String nombre;
    private final Type tipo;
    private final List<Parametro> parametros = new ArrayList<>();
    private final List<Sentencia> variablesLocales = new ArrayList<>();
    private final List<Sentencia> cuerpo = new ArrayList<>();
    private final boolean esAccion;
    private boolean enVariablesLocales = false;

    public static class Parametro {
        private final String nombre;
        private final Type tipo;

        public Parametro(String nombre, Type tipo) {
            this.nombre = nombre;
            this.tipo = tipo;
        }

        public String getNombre() {
            return nombre;
        }

        public Type getTipo() {
            return tipo;
        }
    }

    public DeclaracionFuncion(String nombre, Type tipoRetorno, List<Parametro> params, boolean esAccion) {
        this.nombre = nombre;
        this.tipo = tipoRetorno;
        if (params != null) {
            this.parametros.addAll(params);
        }
        this.esAccion = esAccion;
    }

    public DeclaracionFuncion(String nombre, Type tipo) {
        this(nombre, tipo, null, tipo == null || tipo.isVoid());
    }

    public void agregarParametro(String nombre, Type tipo) {
        parametros.add(new Parametro(nombre, tipo));
    }

    public void agregarVariableLocal(Sentencia s) {
        variablesLocales.add(s);
    }

    public void setEnVariablesLocales(boolean enVariablesLocales) {
        this.enVariablesLocales = enVariablesLocales;
    }

    @Override
    public void agregarSentencia(Sentencia sentencia) {
        if (enVariablesLocales) {
            variablesLocales.add(sentencia);
        } else {
            cuerpo.add(sentencia);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public Type getTipo() {
        return tipo;
    }

    public Type getTipoRetorno() {
        return tipo;
    }

    public boolean isEsAccion() {
        return esAccion;
    }

    public List<Parametro> getParametros() {
        return parametros;
    }

    public List<Sentencia> getVariablesLocales() {
        return variablesLocales;
    }

    public List<Sentencia> getCuerpo() {
        return cuerpo;
    }

    @Override
    public void ejecutar(Entorno entorno, ContextoEjecucion ctx) {
        ctx.registrarFuncion(nombre, this);
        String tipoRet = tipo != null ? tipo.getType() : "void";
        Simbolo sim = new Simbolo(nombre, tipoRet, "func", "Global", "[Función]", getLinea(), getColumna());
        sim.setNumParam(parametros.size());
        if (!parametros.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < parametros.size(); i++) {
                if (i > 0) sb.append(", ");
                sb.append(parametros.get(i).getTipo() != null ? parametros.get(i).getTipo().getType() : "void");
            }
            sim.setListParam(sb.toString());
        } else {
            sim.setListParam("-");
        }
        ctx.registrarSimbolo(entorno, sim);
    }

    @Override
    public void aPigLatin(StringBuffer sb) {
        if (tipo == null || tipo.isVoid() || esAccion) {
            sb.append(PigLatinTranslater.traducir("actio")).append(" ");
        } else {
            sb.append(PigLatinTranslater.traducir("ratio")).append(" ");
            tipo.aPigLatin(sb);
            sb.append(" ");
        }
        sb.append(nombre).append("(");
        for (int i = 0; i < parametros.size(); i++) {
            if (i > 0) sb.append(", ");
            Parametro p = parametros.get(i);
            sb.append(PigLatinTranslater.traducir("esto")).append(" ");
            sb.append(p.nombre).append(" : ");
            if (p.tipo != null) {
                p.tipo.aPigLatin(sb);
            }
        }
        sb.append(") {\n");

        if (!variablesLocales.isEmpty()) {
            sb.append("    VARIABILES[\n");
            for (Sentencia v : variablesLocales) {
                sb.append("        ");
                v.aPigLatin(sb);
                sb.append("\n");
            }
            sb.append("    ]\n");
        }

        for (Sentencia s : cuerpo) {
            sb.append("    ");
            s.aPigLatin(sb);
            sb.append("\n");
        }
        sb.append("} ").append(PigLatinTranslater.traducir("finis")).append(";");
    }
}
