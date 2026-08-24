package org.codexlatinus.model;

public class ErrorCompilador {
    public enum TipoError {
        LEXICO,
        SINTACTICO,
        SEMANTICO
    }

    private final TipoError tipo;
    private final String descripcion;
    private final int linea;
    private final int columna;

    public ErrorCompilador(TipoError tipo, String descripcion, int linea, int columna) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.linea = linea;
        this.columna = columna;
    }

    public TipoError getTipo() {
        return tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getLinea() {
        return linea;
    }

    public int getColumna() {
        return columna;
    }

    @Override
    public String toString() {
        return String.format("[%s] Línea %d:%d -> %s", tipo, linea, columna, descripcion);
    }
}
