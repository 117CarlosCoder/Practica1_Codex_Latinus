package org.codexlatinus.ast.sentencias.declaraciones;

import org.codexlatinus.ast.expresiones.Expresion;
import org.codexlatinus.ast.sentencias.Sentencia;
import org.codexlatinus.model.ContextoEjecucion;
import org.codexlatinus.model.Entorno;
import org.codexlatinus.model.Simbolo;
import org.codexlatinus.utils.PigLatinTranslater;

public class DeclaracionInstanciaEstructura extends Sentencia {
    private final String nombre;
    private final String tipoEstructura;
    private final Expresion initExpr;

    public DeclaracionInstanciaEstructura(String nombre, String tipoEstructura, Expresion initExpr) {
        this.nombre = nombre;
        this.tipoEstructura = tipoEstructura;
        this.initExpr = initExpr;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipoEstructura() {
        return tipoEstructura;
    }

    public Expresion getInitExpr() {
        return initExpr;
    }

    @Override
    public void ejecutar(Entorno entorno, ContextoEjecucion ctx) {
        if (entorno.existeEnEsteEntorno(nombre)) {
            ctx.agregarError("Variable duplicada: La estructura '" + nombre + "' ya ha sido declarada en este ámbito.", getLinea(), getColumna());
            return;
        }

        Object valor;
        if (initExpr != null) {
            valor = initExpr.evaluar(entorno, ctx);
        } else {
            valor = ctx.crearInstanciaStructPorDefecto(tipoEstructura);
        }

        Simbolo sim = new Simbolo(nombre, tipoEstructura, "Instancia Estructura", entorno.getNombreEntorno(), valor, getLinea(), getColumna());
        ctx.registrarSimbolo(entorno, sim);
    }

    @Override
    public void aPigLatin(StringBuffer sb) {
        sb.append(PigLatinTranslater.traducir("esto")).append(" ");
        sb.append(nombre).append(" : ").append(tipoEstructura);
        if (initExpr != null) {
            sb.append(" = ");
            initExpr.aPigLatin(sb);
        }
        sb.append(";");
    }
}
