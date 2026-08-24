package org.codexlatinus.parser;

import org.codexlatinus.model.ErrorCompilador;
import org.codexlatinus.model.Simbolo;
import org.codexlatinus.model.TablaTipos;

import java.util.List;

public class ResultadoCompilacion {
    private final boolean exitoso;
    private final String salidaConsola;
    private final String representacionAst;
    private final List<Simbolo> listaSimbolos;
    private final List<ErrorCompilador> listaErrores;
    private final String codigoPigLatin;
    private final TablaTipos tablaTipos;

    public ResultadoCompilacion(boolean exitoso,
                                String salidaConsola,
                                String representacionAst,
                                List<Simbolo> listaSimbolos,
                                List<ErrorCompilador> listaErrores) {
        this(exitoso, salidaConsola, representacionAst, listaSimbolos, listaErrores, "", new TablaTipos());
    }

    public ResultadoCompilacion(boolean exitoso,
                                String salidaConsola,
                                String representacionAst,
                                List<Simbolo> listaSimbolos,
                                List<ErrorCompilador> listaErrores,
                                String codigoPigLatin) {
        this(exitoso, salidaConsola, representacionAst, listaSimbolos, listaErrores, codigoPigLatin, new TablaTipos());
    }

    public ResultadoCompilacion(boolean exitoso,
                                String salidaConsola,
                                String representacionAst,
                                List<Simbolo> listaSimbolos,
                                List<ErrorCompilador> listaErrores,
                                String codigoPigLatin,
                                TablaTipos tablaTipos) {
        this.exitoso = exitoso;
        this.salidaConsola = salidaConsola;
        this.representacionAst = representacionAst;
        this.listaSimbolos = listaSimbolos;
        this.listaErrores = listaErrores;
        this.codigoPigLatin = codigoPigLatin != null ? codigoPigLatin : "";
        this.tablaTipos = tablaTipos != null ? tablaTipos : new TablaTipos();
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

    public TablaTipos getTablaTipos() {
        return tablaTipos;
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
