package org.codexlatinus.ast.expresiones.acceso;

import org.codexlatinus.ast.expresiones.Expresion;
import org.codexlatinus.ast.sentencias.Sentencia;
import org.codexlatinus.ast.sentencias.funciones.DeclaracionFuncion;
import org.codexlatinus.model.ContextoEjecucion;
import org.codexlatinus.model.Entorno;
import org.codexlatinus.model.SenalesControl;
import org.codexlatinus.model.Simbolo;
import org.codexlatinus.model.TiposHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LlamadaFuncion extends Expresion {
    private final String nombre;
    private final List<Expresion> argumentos = new ArrayList<>();

    public LlamadaFuncion(String nombre) {
        this.nombre = nombre;
    }

    public LlamadaFuncion(String nombre, List<Expresion> argumentos) {
        this.nombre = nombre;
        if (argumentos != null) {
            this.argumentos.addAll(argumentos);
        }
    }

    public void agregarArgumento(Expresion arg) {
        argumentos.add(arg);
    }

    public String getNombre() {
        return nombre;
    }

    public List<Expresion> getArgumentos() {
        return Collections.unmodifiableList(argumentos);
    }

    private Entorno obtenerEntornoGlobal(Entorno e) {
        Entorno actual = e;
        while (actual.getPadre() != null) {
            actual = actual.getPadre();
        }
        return actual;
    }

    @Override
    public Object evaluar(Entorno entorno, ContextoEjecucion ctx) {
        DeclaracionFuncion func = ctx.obtenerFuncion(nombre);
        if (func == null) {
            ctx.agregarError("Función no declarada: '" + nombre + "'", getLinea(), getColumna());
            return null;
        }

        List<Object> argsVals = new ArrayList<>();
        for (Expresion arg : argumentos) {
            argsVals.add(arg != null ? arg.evaluar(entorno, ctx) : null);
        }

        List<DeclaracionFuncion.Parametro> params = func.getParametros();
        if (params.size() != argumentos.size()) {
            ctx.agregarError("Cantidad incorrecta de argumentos: La función '" + nombre + "' espera " + params.size() + " argumentos pero recibió " + argumentos.size() + ".", getLinea(), getColumna());
        }

        Entorno entornoGlobal = obtenerEntornoGlobal(entorno);
        Entorno entornoFunc = new Entorno(entornoGlobal, "Función " + nombre);

        for (int i = 0; i < params.size(); i++) {
            DeclaracionFuncion.Parametro p = params.get(i);
            String pNombre = p.getNombre();
            String pTipo = p.getTipo() != null ? p.getTipo().getType() : "bool";
            Object pVal = i < argsVals.size() ? argsVals.get(i) : ctx.valorPorDefecto(pTipo);
            if (pVal != null && !TiposHelper.esCompatible(pTipo, pVal)) {
                ctx.agregarError("Tipo de argumento incompatible en función '" + nombre + "': El parámetro '" + pNombre + "' de tipo '" + pTipo + "' recibió valor de tipo '" + TiposHelper.inferirTipoNombre(pVal) + "'.", getLinea(), getColumna());
            }
            Simbolo s = new Simbolo(pNombre, pTipo, "Parámetro", "Función " + nombre, pVal, getLinea(), getColumna());
            ctx.registrarSimbolo(entornoFunc, s);
        }

        for (Sentencia v : func.getVariablesLocales()) {
            v.ejecutar(entornoFunc, ctx);
        }

        Object valorRet = ctx.valorPorDefecto(func.getTipoRetorno() != null ? func.getTipoRetorno().getType() : "void");
        try {
            for (Sentencia st : func.getCuerpo()) {
                st.ejecutar(entornoFunc, ctx);
                if (ctx.esCancelado()) break;
            }
        } catch (SenalesControl.SenalReturn ret) {
            valorRet = ret.getValor();
        }

        String tipoRet = func.getTipoRetorno() != null ? func.getTipoRetorno().getType() : "void";
        if (!tipoRet.equalsIgnoreCase("void") && valorRet != null && !TiposHelper.esCompatible(tipoRet, valorRet)) {
            ctx.agregarError("Tipo de retorno incompatible: La función '" + nombre + "' declaró retornar '" + tipoRet + "' pero retornó '" + TiposHelper.inferirTipoNombre(valorRet) + "'.", getLinea(), getColumna());
        }

        return valorRet;
    }

    @Override
    public void aPigLatin(StringBuffer sb) {
        sb.append(org.codexlatinus.utils.PigLatinTranslater.traducir(nombre)).append("(");
        for (int i = 0; i < argumentos.size(); i++) {
            if (i > 0) sb.append(", ");
            argumentos.get(i).aPigLatin(sb);
        }
        sb.append(")");
    }
}
