package org.codexlatinus.model;

public enum TipoDato {
    BOOLEAN(1, "boolean"),
    LITTERA(2, "littera"),
    NUMERUS(3, "numerus"),
    DECIMALIS(4, "decimalis"),
    TEXTUM(5, "textum"),
    VOID(0, "void"),
    STRUCT(0, "structura"),
    ARRAY(0, "series"),
    DESCONOCIDO(-1, "desconocido");

    private final int jerarquia;
    private final String nombre;

    TipoDato(int jerarquia, String nombre) {
        this.jerarquia = jerarquia;
        this.nombre = nombre;
    }

    public int getJerarquia() {
        return jerarquia;
    }

    public String getNombre() {
        return nombre;
    }

    public static TipoDato desdeCadena(String str) {
        if (str == null) return DESCONOCIDO;
        String s = str.trim().toLowerCase();
        return switch (s) {
            case "numerus", "int", "integer" -> NUMERUS;
            case "decimalis", "double", "float" -> DECIMALIS;
            case "textum", "string" -> TEXTUM;
            case "littera", "char" -> LITTERA;
            case "boolean", "verum", "falsus", "bool" -> BOOLEAN;
            case "void" -> VOID;
            default -> {
                if (s.endsWith("[]")) yield ARRAY;
                yield STRUCT;
            }
        };
    }

    public static TipoDato inferirTipo(Object valor) {
        if (valor == null) return DESCONOCIDO;
        if (valor instanceof Integer || valor instanceof Long || valor instanceof Short || valor instanceof Byte) return NUMERUS;
        if (valor instanceof Double || valor instanceof Float) return DECIMALIS;
        if (valor instanceof String) return TEXTUM;
        if (valor instanceof Character) return LITTERA;
        if (valor instanceof Boolean) return BOOLEAN;
        if (valor.getClass().isArray() || valor instanceof Object[]) return ARRAY;
        return STRUCT;
    }

    public static TipoDato resolverOperacionBinaria(TipoDato t1, TipoDato t2, String operador) {
        if (operador.equals("+") && (t1 == TEXTUM || t2 == TEXTUM)) {
            return TEXTUM;
        }

        if (operador.equals("+") || operador.equals("-") || operador.equals("*") || operador.equals("/") || operador.equals("%")) {
            if (t1 == TEXTUM || t2 == TEXTUM) {
                return DESCONOCIDO;
            }
            if (t1.getJerarquia() >= t2.getJerarquia()) {
                return t1;
            } else {
                return t2;
            }
        }

        if (operador.equals("==") || operador.equals("===") || operador.equals("!=") ||
            operador.equals("<") || operador.equals(">") || operador.equals("<=") || operador.equals(">=") ||
            operador.equals("&&") || operador.equals("||") || operador.equals("non") || operador.equals("!")) {
            return BOOLEAN;
        }

        return DESCONOCIDO;
    }
}
