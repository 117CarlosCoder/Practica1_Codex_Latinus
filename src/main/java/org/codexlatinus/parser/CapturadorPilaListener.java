package org.codexlatinus.parser;

import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.codexlatinus.model.PasoPila;

import java.util.ArrayList;
import java.util.List;

public class CapturadorPilaListener implements ParseTreeListener {

    private final Parser parser;
    private final List<PasoPila> pasos = new ArrayList<>();
    private final List<String> pilaSimulada = new ArrayList<>();
    private final List<String> historialLog = new ArrayList<>();
    private int contadorPasos = 1;

    private static final int MAX_PASOS_PILA = 1500; 
    public CapturadorPilaListener(Parser parser) {
        this.parser = parser;
    }

    public List<PasoPila> getPasos() {
        return pasos;
    }

    private void registrarPaso(String operacion) {
        if (pasos.size() >= MAX_PASOS_PILA) {
            if (pasos.size() == MAX_PASOS_PILA) {
                historialLog.add("... [Pila truncada por límite de pasos] ...");
                pasos.add(new PasoPila(contadorPasos++, "Límite alcanzado", pilaSimulada, historialLog));
            }
            return;
        }
        historialLog.add(operacion);
        pasos.add(new PasoPila(contadorPasos++, operacion, pilaSimulada, historialLog));
    }

    @Override
    public void visitTerminal(TerminalNode node) {
        if (pasos.size() > MAX_PASOS_PILA) return;
        String texto = node.getText();
        if (texto != null && !texto.isBlank() && !texto.equals("<EOF>")) {
            pilaSimulada.add(texto);
            registrarPaso("shift " + texto);
        }
    }

    @Override
    public void visitErrorNode(ErrorNode node) {
        if (pasos.size() > MAX_PASOS_PILA) return;
        String texto = node.getText();
        pilaSimulada.add("[Error: " + texto + "]");
        registrarPaso("error " + texto);
    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
        if (pasos.size() > MAX_PASOS_PILA) return;
        int ruleIndex = ctx.getRuleIndex();
        String nombreRegla = (parser != null && ruleIndex >= 0 && ruleIndex < parser.getRuleNames().length)
                ? parser.getRuleNames()[ruleIndex]
                : ctx.getClass().getSimpleName().replace("Context", "");

        int cantHijos = ctx.getChildCount();
        StringBuilder produccion = new StringBuilder(nombreRegla).append(" -> ");

        if (cantHijos > 0) {
            int elementosARetirar = Math.min(cantHijos, pilaSimulada.size());
            List<String> retirados = new ArrayList<>();
            for (int i = 0; i < elementosARetirar; i++) {
                if (!pilaSimulada.isEmpty()) {
                    retirados.add(0, pilaSimulada.remove(pilaSimulada.size() - 1));
                }
            }
            produccion.append(String.join(" ", retirados));
        } else {
            produccion.append("ε");
        }

        pilaSimulada.add(nombreRegla);
        registrarPaso("reduce " + produccion);
    }

    public void finalizarAnalisis() {
        if (pasos.size() <= MAX_PASOS_PILA) {
            registrarPaso("accept");
        }
    }
}
