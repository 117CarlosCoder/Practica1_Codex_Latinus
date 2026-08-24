package org.codexlatinus.model;

import java.util.Arrays;

public class Simbolo {
    private final String nombre;
    private final String tipo;
    private final String categoria;
    private final String entorno;
    private Object valor;
    private final int linea;
    private final int columna;

    public Simbolo(String nombre, String tipo, String categoria, String entorno, Object valor, int linea, int columna) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.categoria = categoria;
        this.entorno = entorno;
        this.valor = valor;
        this.linea = linea;
        this.columna = columna;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getEntorno() {
        return entorno;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public int getLinea() {
        return linea;
    }

    public int getColumna() {
        return columna;
    }

    public String getValorComoTexto() {
        if (valor == null) return "null";
        if (valor instanceof Object[] arr) {
            return Arrays.deepToString(arr);
        }
        return valor.toString();
    }
}
