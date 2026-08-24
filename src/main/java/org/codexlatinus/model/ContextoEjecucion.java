package org.codexlatinus.model;

import org.codexlatinus.ast.sentencias.funciones.DeclaracionFuncion;

import java.util.*;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ContextoEjecucion {

    private final StringBuilder salidaConsola = new StringBuilder();
    private final List<ErrorCompilador> erroresSemanticos = new ArrayList<>();
    private final List<Simbolo> tablaSimbolosCompleta = new ArrayList<>();

    private final Map<String, DeclaracionFuncion> funciones = new HashMap<>();
    private final Map<String, Map<String, String>> estructuras = new HashMap<>();

    private Supplier<String> lectorConsola;
    private Consumer<String> escritorConsola;
    private BooleanSupplier verificadorCancelacion;

    public ContextoEjecucion() {}

    public ContextoEjecucion(Supplier<String> lector, Consumer<String> escritor, BooleanSupplier cancelChecker) {
        this.lectorConsola = lector;
        this.escritorConsola = escritor;
        this.verificadorCancelacion = cancelChecker;
    }

    public void setLectorConsola(Supplier<String> lectorConsola) {
        this.lectorConsola = lectorConsola;
    }

    public void setEscritorConsola(Consumer<String> escritorConsola) {
        this.escritorConsola = escritorConsola;
    }

    public void setVerificadorCancelacion(BooleanSupplier verificadorCancelacion) {
        this.verificadorCancelacion = verificadorCancelacion;
    }

    public boolean esCancelado() {
        if (Thread.currentThread().isInterrupted()) {
            return true;
        }
        if (verificadorCancelacion != null && verificadorCancelacion.getAsBoolean()) {
            return true;
        }
        return false;
    }

    public void imprimirConsola(String linea) {
        salidaConsola.append(linea).append("\n");
        if (escritorConsola != null && !esCancelado()) {
            escritorConsola.accept(linea);
        }
    }

    public String leerEntradaConsola() {
        if (lectorConsola != null) {
            try {
                return lectorConsola.get();
            } catch (Exception ignored) {}
        }
        return "";
    }

    public void agregarError(String descripcion, int linea, int columna) {
        erroresSemanticos.add(new ErrorCompilador(ErrorCompilador.TipoError.SEMANTICO, descripcion, linea, columna));
    }

    public void registrarSimbolo(Entorno entorno, Simbolo sim) {
        entorno.definir(sim);
        tablaSimbolosCompleta.add(sim);
    }

    public void registrarFuncion(String nombre, DeclaracionFuncion fn) {
        funciones.put(nombre, fn);
    }

    public DeclaracionFuncion obtenerFuncion(String nombre) {
        return funciones.get(nombre);
    }

    public void registrarEstructura(String nombre, Map<String, String> miembros) {
        estructuras.put(nombre, miembros);
    }

    public Map<String, Object> crearInstanciaStructPorDefecto(String tipo) {
        Map<String, String> blueprint = estructuras.get(tipo);
        if (blueprint == null) return new LinkedHashMap<>();

        Map<String, Object> instancia = new LinkedHashMap<>();
        for (Map.Entry<String, String> entry : blueprint.entrySet()) {
            String mNombre = entry.getKey();
            String mTipo = entry.getValue();
            if (mTipo.endsWith("[]")) {
                instancia.put(mNombre, new Object[0]);
            } else if (estructuras.containsKey(mTipo)) {
                instancia.put(mNombre, crearInstanciaStructPorDefecto(mTipo));
            } else {
                instancia.put(mNombre, valorPorDefecto(mTipo));
            }
        }
        return instancia;
    }

    public Object valorPorDefecto(String tipo) {
        if (tipo == null) return null;
        if (tipo.endsWith("[]")) return new Object[0];
        if (estructuras.containsKey(tipo)) return crearInstanciaStructPorDefecto(tipo);
        return switch (tipo) {
            case "numerus" -> 0;
            case "decimalis" -> 0.0;
            case "textum" -> "";
            case "littera" -> '\0';
            case "bool", "boolean", "verum", "falsus" -> false;
            default -> null;
        };
    }

    public String getSalidaConsola() {
        return salidaConsola.toString();
    }

    public List<ErrorCompilador> getErroresSemanticos() {
        return erroresSemanticos;
    }

    public List<Simbolo> getTablaSimbolosCompleta() {
        return tablaSimbolosCompleta;
    }
}
