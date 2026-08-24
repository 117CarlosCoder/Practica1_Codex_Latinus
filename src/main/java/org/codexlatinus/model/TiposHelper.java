package org.codexlatinus.model;

import java.util.Arrays;
import java.util.Map;

public class TiposHelper {

    public static String normalizarTipo(String tipoRaw) {
        if (tipoRaw == null) return "desconocido";
        String stipo = tipoRaw.trim();
        if (stipo.equals("boolean") || stipo.equals("verum") || stipo.equals("falsus")) return "bool";
        return stipo;
    }

    public static boolean esVerdadero(Object obj) {
        if (obj instanceof Boolean b) return b;
        if (obj instanceof Number n) return n.doubleValue() != 0;
        return obj != null;
    }

    public static int aEntero(Object obj) {
        if (obj instanceof Number n) return n.intValue();
        if (obj instanceof Boolean b) return b ? 1 : 0;
        return 0;
    }

    public static double aDouble(Object obj) {
        if (obj instanceof Number n) return n.doubleValue();
        if (obj instanceof Boolean b) return b ? 1.0 : 0.0;
        return 0.0;
    }

    public static Object valorPorDefecto(String tipo) {
        if (tipo == null) return null;
        String t = normalizarTipo(tipo);
        return switch (t) {
            case "numerus" -> 0;
            case "decimalis" -> 0.0;
            case "textum" -> "";
            case "littera" -> '\0';
            case "bool" -> false;
            default -> null;
        };
    }

    public static String inferirTipoNombre(Object obj) {
        if (obj == null) return "null";
        if (obj instanceof Integer || obj instanceof Long || obj instanceof Short || obj instanceof Byte) return "numerus";
        if (obj instanceof Double || obj instanceof Float) return "decimalis";
        if (obj instanceof String) return "textum";
        if (obj instanceof Character) return "littera";
        if (obj instanceof Boolean) return "bool";
        if (obj instanceof Object[]) return "series";
        if (obj instanceof Map<?, ?>) return "structura";
        return obj.getClass().getSimpleName();
    }

    public static boolean esCompatible(String tipoDeclarado, Object valor) {
        if (valor == null) return true;
        if (tipoDeclarado == null) return true;

        String tipoNormalizado = normalizarTipo(tipoDeclarado);
        if (tipoNormalizado.endsWith("[]") || tipoNormalizado.equals("series")) {
            return valor instanceof Object[];
        }

        return switch (tipoNormalizado) {
            case "numerus" -> valor instanceof Integer || valor instanceof Long || valor instanceof Short || valor instanceof Byte;
            case "decimalis" -> valor instanceof Number;
            case "textum" -> valor instanceof String;
            case "littera" -> valor instanceof Character;
            case "bool" -> valor instanceof Boolean;
            case "void" -> true;
            default -> valor instanceof Map<?, ?>; 
        };
    }

    public static String formatearSalida(Object obj) {
        if (obj == null) return "null";
        if (obj instanceof Boolean b) return b ? "verum" : "falsus";
        if (obj instanceof Object[] arr) return Arrays.deepToString(arr);
        return obj.toString();
    }
}
