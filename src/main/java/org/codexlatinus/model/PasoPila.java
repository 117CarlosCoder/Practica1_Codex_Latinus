package org.codexlatinus.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PasoPila {

    private final int numeroPaso;
    private final String operacion;
    private final List<String> elementosPila;
    private final List<String> historialLog;

    public PasoPila(int numeroPaso, String operacion, List<String> elementosPila, List<String> historialLog) {
        this.numeroPaso = numeroPaso;
        this.operacion = operacion;
        this.elementosPila = elementosPila != null ? new ArrayList<>(elementosPila) : Collections.emptyList();
        this.historialLog = historialLog != null ? new ArrayList<>(historialLog) : Collections.emptyList();
    }

    public int getNumeroPaso() {
        return numeroPaso;
    }

    public String getOperacion() {
        return operacion;
    }

    public List<String> getElementosPila() {
        return Collections.unmodifiableList(elementosPila);
    }

    public List<String> getHistorialLog() {
        return Collections.unmodifiableList(historialLog);
    }

    @Override
    public String toString() {
        return "Paso #" + numeroPaso + ": " + operacion + " | Pila: " + elementosPila;
    }
}
