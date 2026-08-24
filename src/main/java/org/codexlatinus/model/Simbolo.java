package org.codexlatinus.model;

import java.util.Arrays;

public class Simbolo {
    private int id;
    private final String nombre;
    private final String tipo;
    private final String categoria;
    private final String entorno;
    private Object valor;
    private int numParam;
    private String listParam;
    private int dir;
    private final int linea;
    private final int columna;

    public Simbolo(String nombre, String tipo, String categoria, String entorno, Object valor, int linea, int columna) {
        this(0, nombre, tipo, categoria, entorno, valor, 0, "-", 0, linea, columna);
    }

    public Simbolo(int id, String nombre, String tipo, String categoria, String entorno, Object valor, int numParam, String listParam, int dir, int linea, int columna) {
        this.id = id;
        this.nombre = nombre != null ? nombre : "";
        this.tipo = tipo != null ? tipo : "";
        this.categoria = categoria != null ? categoria : "";
        this.entorno = entorno != null ? entorno : "Global";
        this.valor = valor;
        this.numParam = numParam;
        this.listParam = listParam != null ? listParam : "-";
        this.dir = dir;
        this.linea = linea;
        this.columna = columna;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getNumParam() {
        return numParam;
    }

    public void setNumParam(int numParam) {
        this.numParam = numParam;
    }

    public String getListParam() {
        return listParam;
    }

    public void setListParam(String listParam) {
        this.listParam = listParam;
    }

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
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
