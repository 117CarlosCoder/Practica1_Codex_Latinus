package org.codexlatinus.visitor;

import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

public class VisitanteGraphviz {
    private final StringBuilder dot = new StringBuilder();
    private int contadorNodos = 0;

    public static String generarDot(ParseTree arbol, Parser parser) {
        VisitanteGraphviz visitante = new VisitanteGraphviz();
        return visitante.construirDot(arbol, parser);
    }

    private String construirDot(ParseTree arbol, Parser parser) {
        dot.append("digraph AST {\n");
        dot.append("  graph [rankdir=TB, dpi=120, bgcolor=\"#FFFFFF\"];\n");
        dot.append("  node [fontname=\"Consolas\", fontsize=10, shape=box, style=\"filled,rounded\", margin=\"0.15,0.08\"];\n");
        dot.append("  edge [color=\"#555555\", arrowsize=0.7];\n");

        if (arbol != null) {
            recorrer(arbol, parser);
        }

        dot.append("}\n");
        return dot.toString();
    }

    private static final int MAX_NODOS = 2500;

    private int recorrer(ParseTree nodo, Parser parser) {
        if (contadorNodos >= MAX_NODOS) {
            if (contadorNodos == MAX_NODOS) {
                int id = contadorNodos++;
                dot.append(String.format("  node%d [label=\"... [Árbol truncado: supera %d nodos] ...\", fillcolor=\"#FCE8E6\", fontcolor=\"#C5221F\"];%n", id, MAX_NODOS));
                return id;
            }
            return -1;
        }

        int id = contadorNodos++;
        String etiqueta;
        String colorFondo = "#E8F0FE";
        String colorTexto = "#202124";

        if (nodo instanceof TerminalNode terminal) {
            String texto = terminal.getText();
            if (texto.equals("<EOF>")) {
                etiqueta = "<EOF>";
                colorFondo = "#F1F3F4";
            } else {
                etiqueta = escaparDot(texto);
                colorFondo = "#FEF7E0";
            }
        } else {
            int indiceRegla = obtenerIndiceRegla(nodo);
            if (indiceRegla >= 0 && parser != null && indiceRegla < parser.getRuleNames().length) {
                etiqueta = parser.getRuleNames()[indiceRegla];
            } else {
                etiqueta = nodo.getClass().getSimpleName().replace("Context", "");
            }

            if (etiqueta.equalsIgnoreCase("structDecl")) {
                colorFondo = "#E6F4EA";
            } else if (etiqueta.equalsIgnoreCase("functionDecl") || etiqueta.equalsIgnoreCase("funcDecl")) {
                colorFondo = "#F3E8FD";
            } else if (etiqueta.toLowerCase().contains("stmt") || etiqueta.toLowerCase().contains("sentencia")) {
                colorFondo = "#E8F0FE";
            } else if (etiqueta.toLowerCase().contains("expr")) {
                colorFondo = "#FCE8E6";
            }
        }

        dot.append(String.format("  node%d [label=\"%s\", fillcolor=\"%s\", fontcolor=\"%s\"];%n",
                id, etiqueta, colorFondo, colorTexto));

        for (int i = 0; i < nodo.getChildCount(); i++) {
            ParseTree hijo = nodo.getChild(i);
            int idHijo = recorrer(hijo, parser);
            if (idHijo >= 0) {
                dot.append(String.format("  node%d -> node%d;%n", id, idHijo));
            }
        }

        return id;
    }

    private int obtenerIndiceRegla(ParseTree nodo) {
        try {
            var metodo = nodo.getClass().getMethod("getRuleIndex");
            return (int) metodo.invoke(nodo);
        } catch (Exception e) {
            return -1;
        }
    }

    private String escaparDot(String texto) {
        return texto.replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\r", "");
    }
}
