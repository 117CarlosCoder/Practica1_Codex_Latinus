package org.codexlatinus.ast.sentencias.declaraciones;

import org.codexlatinus.ast.expresiones.Expresion;
import org.codexlatinus.ast.sentencias.Sentencia;
import org.codexlatinus.model.ContextoEjecucion;
import org.codexlatinus.model.Entorno;
import org.codexlatinus.model.Simbolo;
import org.codexlatinus.model.TiposHelper;
import org.codexlatinus.utils.PigLatinTranslater;
import org.codexlatinus.utils.Type;

public class Declaracion extends Sentencia {
    private final String id;
    private final Type tipo;
    private final Expresion expresion;

    public Declaracion(String id, Type tipo, Expresion expresion) {
        this.id = id;
        this.tipo = tipo;
        this.expresion = expresion;
    }

    public String getId() {
        return id;
    }

    public Type getTipo() {
        return tipo;
    }

    public Expresion getExpresion() {
        return expresion;
    }

    @Override
    public void ejecutar(Entorno entorno, ContextoEjecucion ctx) {
        String rawTipo = tipo != null ? tipo.getType() : "bool";
        String tipoNormalizado = TiposHelper.normalizarTipo(rawTipo);
        if (entorno.existeEnEsteEntorno(id)) {
            ctx.agregarError("Variable duplicada: La variable '" + id + "' ya ha sido declarada en este ámbito.", getLinea(), getColumna());
            return;
        }

        Object valor;
        if (expresion != null) {
            valor = expresion.evaluar(entorno, ctx);
            if (valor != null && !TiposHelper.esCompatible(tipoNormalizado, valor)) {
                ctx.agregarError("Tipo incompatible: No se puede inicializar la variable '" + id + "' de tipo '" + tipoNormalizado + "' con valor de tipo '" + TiposHelper.inferirTipoNombre(valor) + "'.", getLinea(), getColumna());
            }
        } else if ("verum".equalsIgnoreCase(rawTipo)) {
            valor = true;
            tipoNormalizado = "bool";
        } else if ("falsus".equalsIgnoreCase(rawTipo)) {
            valor = false;
            tipoNormalizado = "bool";
        } else {
            valor = ctx.valorPorDefecto(tipoNormalizado);
        }

        Simbolo sim = new Simbolo(id, tipoNormalizado, "Variable", entorno.getNombreEntorno(), valor, getLinea(), getColumna());
        ctx.registrarSimbolo(entorno, sim);
    }

    @Override
    public void aPigLatin(StringBuffer sb) {
        sb.append(PigLatinTranslater.traducir("esto")).append(" ");
        sb.append(id).append(" : ");
        if (tipo != null) {
            tipo.aPigLatin(sb);
        }
        if (expresion != null) {
            sb.append(" = ");
            expresion.aPigLatin(sb);
        }
        sb.append(";");
    }
}
