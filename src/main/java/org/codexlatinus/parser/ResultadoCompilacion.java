package org.codexlatinus.parser;

import org.codexlatinus.model.ErrorCompilador;
import org.codexlatinus.model.PasoPila;
import org.codexlatinus.model.Simbolo;
import org.codexlatinus.model.TablaTipos;

import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;
import java.util.Collections;
import java.util.List;

public class ResultadoCompilacion {
    private final boolean exitoso;
    private final String salidaConsola;
    private final String representacionAst;
    private final List<Simbolo> listaSimbolos;
    private final List<ErrorCompilador> listaErrores;
    private final String codigoPigLatin;
    private final TablaTipos tablaTipos;
    private final String codigoDot;
    private final List<PasoPila> pasosPila;
    private BufferedImage imagenGraphviz;

    public ResultadoCompilacion(boolean exitoso,
                                String salidaConsola,
                                String representacionAst,
                                List<Simbolo> listaSimbolos,
                                List<ErrorCompilador> listaErrores) {
        this(exitoso, salidaConsola, representacionAst, listaSimbolos, listaErrores, "", new TablaTipos(), "", null, Collections.emptyList());
    }

    public ResultadoCompilacion(boolean exitoso,
                                String salidaConsola,
                                String representacionAst,
                                List<Simbolo> listaSimbolos,
                                List<ErrorCompilador> listaErrores,
                                String codigoPigLatin) {
        this(exitoso, salidaConsola, representacionAst, listaSimbolos, listaErrores, codigoPigLatin, new TablaTipos(), "", null, Collections.emptyList());
    }

    public ResultadoCompilacion(boolean exitoso,
                                String salidaConsola,
                                String representacionAst,
                                List<Simbolo> listaSimbolos,
                                List<ErrorCompilador> listaErrores,
                                String codigoPigLatin,
                                TablaTipos tablaTipos) {
        this(exitoso, salidaConsola, representacionAst, listaSimbolos, listaErrores, codigoPigLatin, tablaTipos, "", null, Collections.emptyList());
    }

    public ResultadoCompilacion(boolean exitoso,
                                String salidaConsola,
                                String representacionAst,
                                List<Simbolo> listaSimbolos,
                                List<ErrorCompilador> listaErrores,
                                String codigoPigLatin,
                                TablaTipos tablaTipos,
                                String codigoDot,
                                BufferedImage imagenGraphviz) {
        this(exitoso, salidaConsola, representacionAst, listaSimbolos, listaErrores, codigoPigLatin, tablaTipos, codigoDot, imagenGraphviz, Collections.emptyList());
    }

    public ResultadoCompilacion(boolean exitoso,
                                String salidaConsola,
                                String representacionAst,
                                List<Simbolo> listaSimbolos,
                                List<ErrorCompilador> listaErrores,
                                String codigoPigLatin,
                                TablaTipos tablaTipos,
                                String codigoDot,
                                BufferedImage imagenGraphviz,
                                List<PasoPila> pasosPila) {
        this.exitoso = exitoso;
        this.salidaConsola = salidaConsola;
        this.representacionAst = representacionAst;
        this.listaSimbolos = listaSimbolos;
        this.listaErrores = listaErrores;
        this.codigoPigLatin = codigoPigLatin != null ? codigoPigLatin : "";
        this.tablaTipos = tablaTipos != null ? tablaTipos : new TablaTipos();
        this.codigoDot = codigoDot != null ? codigoDot : "";
        this.imagenGraphviz = imagenGraphviz;
        this.pasosPila = pasosPila != null ? pasosPila : Collections.emptyList();
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

    public String getCodigoDot() {
        return codigoDot;
    }

    public List<PasoPila> getPasosPila() {
        return pasosPila;
    }

    public synchronized BufferedImage getImagenGraphviz() {
        if (imagenGraphviz == null && codigoDot != null && !codigoDot.isBlank()) {
            imagenGraphviz = org.codexlatinus.visitor.RenderizadorGraphviz.renderizarDotAImagen(codigoDot);
        }
        return imagenGraphviz;
    }

    public ImageIcon getIconoGraphviz() {
        BufferedImage img = getImagenGraphviz();
        return img != null ? new ImageIcon(img) : null;
    }

    public String getErroresFormateados() {
        if (listaErrores.isEmpty()) {
            return "No se encontraron errores en la compilación.";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-12s | %-6s | %-8s | %s%n", "TIPO", "LÍNEA", "COLUMNA", "DESCRIPCIÓN"));
        sb.append("--------------------------------------------------------------------------------------------------------\n");
        for (ErrorCompilador err : listaErrores) {
            sb.append(String.format("%-12s | %-6d | %-8d | %s%n",
                    err.getTipo(),
                    err.getLinea(),
                    err.getColumna(),
                    err.getDescripcion()));
        }
        return sb.toString();
    }
}
