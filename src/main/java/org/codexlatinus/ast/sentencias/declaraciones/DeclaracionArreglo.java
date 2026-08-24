package org.codexlatinus.ast.sentencias.declaraciones;

import org.codexlatinus.ast.expresiones.Expresion;
import org.codexlatinus.ast.sentencias.Sentencia;
import org.codexlatinus.model.ContextoEjecucion;
import org.codexlatinus.model.Entorno;
import org.codexlatinus.model.Simbolo;
import org.codexlatinus.model.TiposHelper;
import org.codexlatinus.utils.PigLatinTranslater;
import org.codexlatinus.utils.Type;

public class DeclaracionArreglo extends Sentencia {
    private final String id;
    private final Expresion tamanoExpr;
    private final Type tipo;
    private final Expresion initExpr;

    public DeclaracionArreglo(String id, Expresion tamanoExpr, Type tipo, Expresion initExpr) {
        this.id = id;
        this.tamanoExpr = tamanoExpr;
        this.tipo = tipo;
        this.initExpr = initExpr;
    }

    public String getId() {
        return id;
    }

    public Expresion getTamanoExpr() {
        return tamanoExpr;
    }

    public Type getTipo() {
        return tipo;
    }

    public Expresion getInitExpr() {
        return initExpr;
    }

    @Override
    public void ejecutar(Entorno entorno, ContextoEjecucion ctx) {
        String elemTipo = tipo != null ? TiposHelper.normalizarTipo(tipo.getType()) : "bool";
        String t = elemTipo + "[]";
        if (entorno.existeEnEsteEntorno(id)) {
            ctx.agregarError("Variable duplicada: El arreglo '" + id + "' ya ha sido declarado en este ámbito.", getLinea(), getColumna());
            return;
        }

        Object valor;
        if (initExpr != null) {
            valor = initExpr.evaluar(entorno, ctx);
        } else if (tamanoExpr != null) {
            int tam = TiposHelper.aEntero(tamanoExpr.evaluar(entorno, ctx));
            Object[] arr = new Object[Math.max(0, tam)];
            Object def = ctx.valorPorDefecto(elemTipo);
            for (int i = 0; i < arr.length; i++) {
                arr[i] = def;
            }
            valor = arr;
        } else {
            valor = new Object[0];
        }

        Simbolo sim = new Simbolo(id, t, "Arreglo", entorno.getNombreEntorno(), valor, getLinea(), getColumna());
        ctx.registrarSimbolo(entorno, sim);
    }

    @Override
    public void aPigLatin(StringBuffer sb) {
        sb.append(PigLatinTranslater.traducir("series")).append(" ");
        sb.append(PigLatinTranslater.traducir(id));
        if (tamanoExpr != null) {
            sb.append("[");
            tamanoExpr.aPigLatin(sb);
            sb.append("]");
        }
        sb.append(" : ");
        if (tipo != null) {
            tipo.aPigLatin(sb);
        }
        if (initExpr != null) {
            sb.append(" ");
            initExpr.aPigLatin(sb);
        }
        sb.append(";");
    }
}
