package org.codexlatinus.ast.sentencias.io;

import org.codexlatinus.ast.expresiones.acceso.AccesoVariable;
import org.codexlatinus.ast.sentencias.Sentencia;
import org.codexlatinus.model.ContextoEjecucion;
import org.codexlatinus.model.Entorno;
import org.codexlatinus.utils.PigLatinTranslater;

public class SentenciaLectura extends Sentencia {
    private final AccesoVariable target;
    private final String identificador;

    public SentenciaLectura(AccesoVariable target) {
        this.target = target;
        this.identificador = target != null ? target.getIdentificador() : null;
    }

    public SentenciaLectura(String identificador) {
        this.target = null;
        this.identificador = identificador;
    }

    public AccesoVariable getTarget() {
        return target;
    }

    public String getIdentificador() {
        return identificador;
    }

    @Override
    public void ejecutar(Entorno entorno, ContextoEjecucion ctx) {
        String input = ctx.leerEntradaConsola();
        if (input == null || input.trim().isEmpty()) {
            return;
        }

        AccesoVariable lval = target;
        if (lval == null && identificador != null) {
            lval = new AccesoVariable(identificador);
        }
        if (lval == null) return;

        Object valActual = lval.evaluar(entorno, ctx);
        Object valorConvertido = convertirEntrada(input, valActual);
        lval.asignar(entorno, ctx, valorConvertido);
    }

    private Object convertirEntrada(String input, Object tipoReferencia) {
        if (input == null) return tipoReferencia;
        if (tipoReferencia instanceof Integer) {
            try { return Integer.parseInt(input.trim()); } catch (Exception e) { return 0; }
        }
        if (tipoReferencia instanceof Double) {
            try { return Double.parseDouble(input.trim()); } catch (Exception e) { return 0.0; }
        }
        if (tipoReferencia instanceof Boolean) {
            return input.trim().equalsIgnoreCase("verum") || input.trim().equalsIgnoreCase("true");
        }
        if (tipoReferencia instanceof Character) {
            return input.isEmpty() ? '\0' : input.charAt(0);
        }
        return input;
    }

    @Override
    public void aPigLatin(StringBuffer sb) {
        if (target != null) {
            target.aPigLatin(sb);
            sb.append(" ");
        } else if (identificador != null) {
            sb.append(PigLatinTranslater.traducir(identificador)).append(" ");
        }
        sb.append(PigLatinTranslater.traducir("<<")).append(";");
    }
}
