package org.codexlatinus.model;
public class RegistroTipo {
    private final int id;
    private final String nombre;
    private final String tipoBase;
    private final String padre;
    private final String dimension;
    private final String minimo;
    private final String maximo;
    private final String ambito;

    public RegistroTipo(int id, String nombre, String tipoBase, String padre, String dimension, String minimo, String maximo) {
        this(id, nombre, tipoBase, padre, dimension, minimo, maximo, "0 (Global)");
    }

    public RegistroTipo(int id, String nombre, String tipoBase, String padre, String dimension, String minimo, String maximo, String ambito) {
        this.id = id;
        this.nombre = nombre != null ? nombre : "";
        this.tipoBase = tipoBase != null ? tipoBase : "";
        this.padre = padre != null ? padre : "";
        this.dimension = dimension != null ? dimension : "";
        this.minimo = minimo != null ? minimo : "";
        this.maximo = maximo != null ? maximo : "";
        this.ambito = ambito != null ? ambito : "0 (Global)";
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipoBase() {
        return tipoBase;
    }

    public String getPadre() {
        return padre;
    }

    public String getDimension() {
        return dimension;
    }

    public String getMinimo() {
        return minimo;
    }

    public String getMaximo() {
        return maximo;
    }

    public String getAmbito() {
        return ambito;
    }

    public Object[] aFilaTabla() {
        return new Object[]{
                id,
                nombre,
                tipoBase,
                padre,
                dimension,
                minimo,
                maximo,
                ambito
        };
    }

    @Override
    public String toString() {
        return String.format("Tipo [ID=%d, Nombre=%s, TipoBase=%s, Padre=%s, Dim=%s, Min=%s, Max=%s, Ambito=%s]",
                id, nombre, tipoBase, padre, dimension, minimo, maximo, ambito);
    }
}
