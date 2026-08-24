package org.codexlatinus.ast.expresiones;

import org.codexlatinus.ast.NodoAst;
import org.codexlatinus.model.ContextoEjecucion;
import org.codexlatinus.model.Entorno;


public abstract class Expresion implements NodoAst {
    protected int linea = 1;
    protected int columna = 1;

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public void setPosicion(int linea, int columna) {
        this.linea = linea;
        this.columna = columna;
    }

    public abstract Object evaluar(Entorno entorno, ContextoEjecucion ctx);
}
