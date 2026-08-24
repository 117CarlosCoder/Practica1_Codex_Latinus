package org.codexlatinus.model;

import java.util.*;

public class Entorno {
    private final Entorno padre;
    private final String nombreEntorno;
    private final Map<String, Simbolo> simbolos = new LinkedHashMap<>();
    private final List<Simbolo> historialSimbolos = new ArrayList<>();

    public Entorno() {
        this(null, "Global");
    }

    public Entorno(Entorno padre) {
        this(padre, "Bloque Local");
    }

    public Entorno(Entorno padre, String nombreEntorno) {
        this.padre = padre;
        this.nombreEntorno = nombreEntorno;
    }

    public void definir(Simbolo simbolo) {
        simbolos.put(simbolo.getNombre(), simbolo);
        historialSimbolos.add(simbolo);
    }

    public boolean existeEnEsteEntorno(String nombre) {
        return simbolos.containsKey(nombre);
    }

    public void asignar(String nombre, Object valor) {
        if (simbolos.containsKey(nombre)) {
            simbolos.get(nombre).setValor(valor);
            return;
        }
        if (padre != null) {
            padre.asignar(nombre, valor);
            return;
        }
        throw new RuntimeException("Variable '" + nombre + "' no ha sido declarada en el entorno.");
    }

    public Object obtener(String nombre) {
        if (simbolos.containsKey(nombre)) {
            return simbolos.get(nombre).getValor();
        }
        if (padre != null) {
            return padre.obtener(nombre);
        }
        throw new RuntimeException("Variable '" + nombre + "' no encontrada.");
    }

    public Simbolo obtenerSimbolo(String nombre) {
        if (simbolos.containsKey(nombre)) {
            return simbolos.get(nombre);
        }
        if (padre != null) {
            return padre.obtenerSimbolo(nombre);
        }
        return null;
    }

    public String getNombreEntorno() {
        return nombreEntorno;
    }

    public Entorno getPadre() {
        return padre;
    }
}
