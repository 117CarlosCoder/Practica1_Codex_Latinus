package org.codexlatinus.ui;

import org.codexlatinus.model.Simbolo;

import javax.swing.text.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VistaSintaxisLatinus extends PlainView {

    private static volatile Map<String, Color> tablaColores = new HashMap<>();
    private static volatile List<int[]> comentariosBloque = new ArrayList<>();
    private static volatile boolean coloreadoHabilitado = false;

    private static final Color COLOR_PALABRA_CLAVE = new Color(86, 156, 214); 
    private static final Color COLOR_COMENTARIO    = new Color(106, 153, 85); 
    private static final Color COLOR_TIPO          = new Color(78, 201, 176);  
    private static final Color COLOR_CADENA        = new Color(206, 145, 120); 
    private static final Color COLOR_NUMERO        = new Color(181, 206, 168); 
    private static final Color COLOR_SECCION       = new Color(197, 134, 192); 
    private static final Color COLOR_FUNCION       = new Color(220, 220, 170); 
    private static final Color COLOR_OPERADOR_IO   = new Color(255, 153, 0);   
    private static final Color COLOR_ARREGLO       = new Color(79, 193, 255);  
    private static final Color COLOR_VARIABLE      = new Color(156, 220, 254); 
    private static final Color COLOR_DEFAULT       = new Color(220, 220, 220); 

    private static final Map<String, Color> DICCIONARIO_BASE = new HashMap<>();

    static {
        for (String kw : List.of("esto", "series", "structura", "ratio", "actio", "si", "aliter", 
                                 "aliud", "dum", "facere", "per", "pro", "reddere", "interrumpe", 
                                 "perge", "non", "finis", "verum", "falsus")) {
            DICCIONARIO_BASE.put(kw, COLOR_PALABRA_CLAVE);
        }
        for (String tipo : List.of("numerus", "decimalis", "textum", "littera", "boolean", "bool", "void")) {
            DICCIONARIO_BASE.put(tipo, COLOR_TIPO);
        }
        for (String sec : List.of("variabiles>", "munera>", "maior>", "finis;", "finis", "variabiles[", "variabiles")) {
            DICCIONARIO_BASE.put(sec, COLOR_SECCION);
        }
        DICCIONARIO_BASE.put(">>", COLOR_OPERADOR_IO);
        DICCIONARIO_BASE.put("<<", COLOR_OPERADOR_IO);
    }

    private static final Pattern PATRON_TOKEN = Pattern.compile(
        "//.*|#.*|/\\*.*?\\*/|##.*?##|\"[^\"]*\"|'[^']*'|>>|<<|[a-zA-Z_][a-zA-Z0-9_]*>?|\\]|\\[|\\d+(?:\\.\\d+)?|[{}()\\[\\];,]|."
    );

    public VistaSintaxisLatinus(Element elemento) {
        super(elemento);
    }

    public static void actualizarTablaSimbolos(List<Simbolo> simbolos, String textoCompleto) {
        Map<String, Color> nuevoMapa = new HashMap<>(DICCIONARIO_BASE);
        if (simbolos != null) {
            for (Simbolo simbolo : simbolos) {
                if (simbolo.getNombre() != null) {
                    String cat = simbolo.getCategoria() != null ? simbolo.getCategoria().toLowerCase() : "";
                    Color color = cat.contains("func") ? COLOR_FUNCION :
                                  (cat.contains("struct") || cat.contains("estructura")) ? COLOR_TIPO :
                                  (cat.contains("arreglo") || cat.contains("series")) ? COLOR_ARREGLO : COLOR_VARIABLE;
                    nuevoMapa.put(simbolo.getNombre().toLowerCase(), color);
                }
            }
        }
        tablaColores = nuevoMapa;

        List<int[]> nuevosComentarios = new ArrayList<>();
        if (textoCompleto != null && !textoCompleto.isEmpty()) {
            int indice = 0;
            int longitud = textoCompleto.length();
            while (indice < longitud) {
                if (indice + 1 < longitud && ((textoCompleto.charAt(indice) == '/' && textoCompleto.charAt(indice + 1) == '*') ||
                                              (textoCompleto.charAt(indice) == '#' && textoCompleto.charAt(indice + 1) == '#'))) {
                    String cierre = (textoCompleto.charAt(indice) == '/') ? "*/" : "##";
                    int fin = textoCompleto.indexOf(cierre, indice + 2);
                    if (fin != -1) {
                        nuevosComentarios.add(new int[]{indice, fin + 2});
                        indice = fin + 2;
                    } else {
                        nuevosComentarios.add(new int[]{indice, longitud});
                        break;
                    }
                } else {
                    indice++;
                }
            }
        }
        comentariosBloque = nuevosComentarios;
        coloreadoHabilitado = true;
    }

    public static void deshabilitarColoreado() {
        coloreadoHabilitado = false;
        tablaColores.clear();
        comentariosBloque.clear();
    }

    @Override
    protected float drawUnselectedText(Graphics2D lienzo, float posicionX, float posicionY, int offsetInicioLinea, int offsetFinLinea) throws BadLocationException {
        return dibujarTexto(lienzo, posicionX, posicionY, offsetInicioLinea, offsetFinLinea, false);
    }

    @Override
    protected float drawSelectedText(Graphics2D lienzo, float posicionX, float posicionY, int offsetInicioLinea, int offsetFinLinea) throws BadLocationException {
        return dibujarTexto(lienzo, posicionX, posicionY, offsetInicioLinea, offsetFinLinea, true);
    }

    @Override
    protected int drawUnselectedText(Graphics lienzo, int posicionX, int posicionY, int offsetInicioLinea, int offsetFinLinea) throws BadLocationException {
        return (int) drawUnselectedText((Graphics2D) lienzo, (float) posicionX, (float) posicionY, offsetInicioLinea, offsetFinLinea);
    }

    @Override
    protected int drawSelectedText(Graphics lienzo, int posicionX, int posicionY, int offsetInicioLinea, int offsetFinLinea) throws BadLocationException {
        return (int) drawSelectedText((Graphics2D) lienzo, (float) posicionX, (float) posicionY, offsetInicioLinea, offsetFinLinea);
    }

    private float dibujarTexto(Graphics2D lienzo, float posicionX, float posicionY, int offsetInicioLinea, int offsetFinLinea, boolean estaSeleccionado) throws BadLocationException {
        String textoLinea = getDocument().getText(offsetInicioLinea, offsetFinLinea - offsetInicioLinea);
        if (textoLinea.isEmpty()) return posicionX;

        Font fuenteBase = getContainer() != null ? getContainer().getFont() : new Font("Consolas", Font.PLAIN, 14);
        lienzo.setFont(fuenteBase);

        if (estaSeleccionado || !coloreadoHabilitado) {
            lienzo.setColor(estaSeleccionado ? Color.WHITE : COLOR_DEFAULT);
            return Utilities.drawTabbedText(new Segment(textoLinea.toCharArray(), 0, textoLinea.length()), posicionX, posicionY, lienzo, this, offsetInicioLinea);
        }

        Matcher matcher = PATRON_TOKEN.matcher(textoLinea);
        float posicionXActual = posicionX;

        while (matcher.find()) {
            String token = matcher.group();
            int offsetGlobal = offsetInicioLinea + matcher.start();
            lienzo.setColor(obtenerColorToken(token, offsetGlobal));
            posicionXActual = Utilities.drawTabbedText(new Segment(token.toCharArray(), 0, token.length()), posicionXActual, posicionY, lienzo, this, offsetGlobal);
        }
        return posicionXActual;
    }

    private static boolean estaEnComentarioBloque(int offsetGlobal) {
        for (int[] rango : comentariosBloque) {
            if (offsetGlobal >= rango[0] && offsetGlobal < rango[1]) return true;
        }
        return false;
    }

    private static Color obtenerColorToken(String token, int offsetGlobal) {
        if (estaEnComentarioBloque(offsetGlobal) || token.startsWith("//") || token.startsWith("#") || token.startsWith("/*") || token.startsWith("##")) {
            return COLOR_COMENTARIO;
        }
        if (token.startsWith("\"") || token.startsWith("'")) {
            return COLOR_CADENA;
        }
        if (Character.isDigit(token.charAt(0))) {
            return COLOR_NUMERO;
        }

        Color color = tablaColores.get(token.toLowerCase());
        if (color != null) {
            return color;
        }
        if (Character.isLetter(token.charAt(0)) || token.startsWith("_")) {
            return COLOR_VARIABLE;
        }
        return COLOR_DEFAULT;
    }
}
