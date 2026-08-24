package org.codexlatinus.parser;

import org.codexlatinus.model.ErrorCompilador;
import org.codexlatinus.model.Simbolo;

import java.util.List;

public class ResultadoCompilacion {
    private final boolean exitoso;
    private final String salidaConsola;
    private final String representacionAst;
    private final List<Simbolo> listaSimbolos;
    private final List<ErrorCompilador> listaErrores;
    private final String codigoPigLatin;

    public ResultadoCompilacion(boolean exitoso,
                                String salidaConsola,
                                String representacionAst,
                                List<Simbolo> listaSimbolos,
                                List<ErrorCompilador> listaErrores) {
        this(exitoso, salidaConsola, representacionAst, listaSimbolos, listaErrores, "");
    }

    public ResultadoCompilacion(boolean exitoso,
                                String salidaConsola,
                                String representacionAst,
                                List<Simbolo> listaSimbolos,
                                List<ErrorCompilador> listaErrores,
                                String codigoPigLatin) {
        this.exitoso = exitoso;
        this.salidaConsola = salidaConsola;
        this.representacionAst = representacionAst;
        this.listaSimbolos = listaSimbolos;
        this.listaErrores = listaErrores;
        this.codigoPigLatin = codigoPigLatin != null ? codigoPigLatin : "";
    }

    public boolean esExitoso() {
        return exitoso;
    }

    public String getSalidaConsola() {
        return salidaConsola;
    }

    public String getRepresentacionAst() {
        return representacionAst;
    }

    public List<Simbolo> getListaSimbolos() {
        return listaSimbolos;
    }

    public List<ErrorCompilador> getListaErrores() {
        return listaErrores;
    }

    public String getCodigoPigLatin() {
        return codigoPigLatin;
    }

    public String getErroresFormateados() {
        if (listaErrores.isEmpty()) {
            return "No se encontraron errores en el análisis.";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("=== REPORTE DE ERRORES (").append(listaErrores.size()).append(") ===\n");
        for (ErrorCompilador err : listaErrores) {
            sb.append(err.toString()).append("\n");
        }
        return sb.toString();
    }
}
