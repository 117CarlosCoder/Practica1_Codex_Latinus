package org.codexlatinus.model;

import java.util.*;

public class TablaTipos {

    public static final String[] COLUMNAS = {
            "ID", "Nombre", "Tipo Base", "Padre", "Dimension", "Minimo", "Maximo", "Ambito"
    };

    private final List<RegistroTipo> registros = new ArrayList<>();
    private final Map<String, Integer> mapaIds = new LinkedHashMap<>();
    private int contadorId = 0;

    public TablaTipos() {
        inicializarTiposBase();
    }

    private void inicializarTiposBase() {
        registrarTipoBase("integer", "numerus");
        registrarTipoBase("boolean", "bool");
        registrarTipoBase("decimalis", null);
        registrarTipoBase("textum", null);
        registrarTipoBase("littera", null);
        registrarTipoBase("void", null);
    }

    private int registrarTipoBase(String nombrePrincipal, String alias) {
        int id = contadorId++;
        RegistroTipo reg = new RegistroTipo(id, nombrePrincipal, "", "", "", "", "", "0 (Global)");
        registros.add(reg);
        mapaIds.put(nombrePrincipal.toLowerCase(), id);
        if (alias != null) {
            mapaIds.put(alias.toLowerCase(), id);
        }
        return id;
    }

    public static String formatearAmbito(String rawAmbito) {
        if (rawAmbito == null || rawAmbito.trim().isEmpty() || rawAmbito.equalsIgnoreCase("Global")) {
            return "0 (Global)";
        }
        if (rawAmbito.equalsIgnoreCase("MAIOR")) {
            return "1 (MAIOR)";
        }
        if (rawAmbito.toLowerCase().contains("funci") || rawAmbito.toLowerCase().contains("munera")) {
            return "2 (" + rawAmbito + ")";
        }
        if (rawAmbito.toLowerCase().contains("iteracion") || rawAmbito.toLowerCase().contains("bloque") || rawAmbito.toLowerCase().contains("ciclo")) {
            return "3 (" + rawAmbito + ")";
        }
        return rawAmbito;
    }

    public Integer obtenerIdTipo(String nombreTipo) {
        if (nombreTipo == null) return null;
        String limpio = nombreTipo.trim().toLowerCase();
        if (limpio.endsWith("[]")) {
            limpio = limpio.substring(0, limpio.length() - 2);
        }
        if (limpio.startsWith("series")) {
            limpio = "series";
        }
        return mapaIds.get(limpio);
    }

    public synchronized RegistroTipo registrarTipo(String nombre, String tipoBase, String padre, String dimension, String minimo, String maximo) {
        return registrarTipo(nombre, tipoBase, padre, dimension, minimo, maximo, "0 (Global)");
    }

    public synchronized RegistroTipo registrarTipo(String nombre, String tipoBase, String padre, String dimension, String minimo, String maximo, String ambito) {
        if (nombre != null && mapaIds.containsKey(nombre.toLowerCase())) {
            int idExistente = mapaIds.get(nombre.toLowerCase());
            for (RegistroTipo r : registros) {
                if (r.getId() == idExistente) return r;
            }
        }

        int nuevoId = contadorId++;
        String ambFormateado = formatearAmbito(ambito);
        RegistroTipo reg = new RegistroTipo(nuevoId, nombre, tipoBase, padre, dimension, minimo, maximo, ambFormateado);
        registros.add(reg);
        if (nombre != null) {
            mapaIds.put(nombre.toLowerCase(), nuevoId);
        }
        return reg;
    }

    public synchronized RegistroTipo registrarTipoArreglo(String nombre, String tipoBaseNombre, int dimension, int min, int max) {
        return registrarTipoArreglo(nombre, tipoBaseNombre, dimension, min, max, "0 (Global)");
    }

    public synchronized RegistroTipo registrarTipoArreglo(String nombre, String tipoBaseNombre, int dimension, int min, int max, String ambito) {
        Integer idBase = obtenerIdTipo(tipoBaseNombre);
        String strBase = idBase != null ? String.valueOf(idBase) : (tipoBaseNombre != null ? tipoBaseNombre : "");
        String strDim = dimension > 0 ? String.valueOf(dimension) : "1";
        String strMin = String.valueOf(min);
        String strMax = String.valueOf(max);

        return registrarTipo(nombre, strBase, "", strDim, strMin, strMax, ambito);
    }

    public synchronized RegistroTipo registrarTipoEstructura(String nombre, String padre) {
        return registrarTipo(nombre, "structura", padre != null ? padre : "Global", "-", "-", "-", "0 (Global)");
    }
    
    public synchronized void poblarDesdeSimbolos(List<Simbolo> simbolos, Map<String, Map<String, String>> estructuras) {
        if (estructuras != null) {
            for (String structNombre : estructuras.keySet()) {
                if (!mapaIds.containsKey(structNombre.toLowerCase())) {
                    registrarTipoEstructura(structNombre, "Global");
                }
            }
        }

        if (simbolos != null) {
            for (Simbolo s : simbolos) {
                String nombre = s.getNombre();
                String tipo = s.getTipo();
                String cat = s.getCategoria();
                String entorno = s.getEntorno() != null ? s.getEntorno() : "Global";

                if (nombre == null || tipo == null) continue;

                if (mapaIds.containsKey(nombre.toLowerCase())) continue;

                if (cat != null && (cat.equalsIgnoreCase("Arreglo") || tipo.endsWith("[]") || tipo.equalsIgnoreCase("series"))) {
                    String elemTipo = tipo.replace("[]", "").trim();
                    if (elemTipo.isEmpty() || elemTipo.equalsIgnoreCase("series")) {
                        elemTipo = "numerus";
                    }
                    Integer idBase = obtenerIdTipo(elemTipo);
                    String strBase = idBase != null ? String.valueOf(idBase) : elemTipo;

                    int dim = 1;
                    int min = 0;
                    int max = 0;

                    if (s.getValor() instanceof Object[] arr) {
                        if (arr.length > 0 && arr[0] instanceof Object[] sub) {
                            dim = 2;
                            max = arr.length * sub.length - 1;
                        } else {
                            dim = 1;
                            max = arr.length > 0 ? arr.length - 1 : 0;
                        }
                    }

                    registrarTipo(nombre, strBase, entorno, String.valueOf(dim), String.valueOf(min), String.valueOf(max), entorno);

                } else if (cat != null && cat.toLowerCase().contains("estructura")) {
                    Integer idBase = obtenerIdTipo(tipo);
                    String strBase = idBase != null ? String.valueOf(idBase) : "structura";
                    registrarTipo(nombre, strBase, entorno, "-", "-", "-", entorno);

                } else if (cat != null && cat.toLowerCase().contains("funci")) {
                    Integer idBase = obtenerIdTipo(tipo);
                    String strBase = idBase != null ? String.valueOf(idBase) : tipo;
                    registrarTipo(nombre, strBase, "Global", "-", "-", "-", "0 (Global)");

                } else {
                    Integer idBase = obtenerIdTipo(tipo);
                    String strBase = idBase != null ? String.valueOf(idBase) : tipo;
                    registrarTipo(nombre, strBase, entorno, "-", "-", "-", entorno);
                }
            }
        }
    }

    public List<RegistroTipo> getRegistros() {
        return Collections.unmodifiableList(registros);
    }

    public Object[][] aMatrizDatos() {
        Object[][] datos = new Object[registros.size()][COLUMNAS.length];
        for (int i = 0; i < registros.size(); i++) {
            datos[i] = registros.get(i).aFilaTabla();
        }
        return datos;
    }

    public static String[] getColumnas() {
        return COLUMNAS.clone();
    }
}
