package org.codexlatinus.ast.expresiones.operaciones;

import org.codexlatinus.ast.expresiones.Expresion;
import org.codexlatinus.model.ContextoEjecucion;
import org.codexlatinus.model.Entorno;
import org.codexlatinus.model.TiposHelper;

import java.util.Objects;

public class Operacion extends Expresion {
    private final Expresion izquierda;
    private final String operador;
    private final Expresion derecha;

    public Operacion(Expresion izquierda, String operador, Expresion derecha) {
        this.izquierda = izquierda;
        this.operador = operador;
        this.derecha = derecha;
    }

    public Operacion(Expresion izquierda, Expresion derecha, String operador) {
        this.izquierda = izquierda;
        this.derecha = derecha;
        this.operador = operador;
    }

    public Expresion getIzquierda() {
        return izquierda;
    }

    public String getOperador() {
        return operador;
    }

    public Expresion getDerecha() {
        return derecha;
    }

    @Override
    public Object evaluar(Entorno entorno, ContextoEjecucion ctx) {

        if (operador.equals("&&")) {
            Object izq = izquierda != null ? izquierda.evaluar(entorno, ctx) : false;
            if (!TiposHelper.esVerdadero(izq)) return false;
            Object der = derecha != null ? derecha.evaluar(entorno, ctx) : false;
            return TiposHelper.esVerdadero(der);
        }
        if (operador.equals("||")) {
            Object izq = izquierda != null ? izquierda.evaluar(entorno, ctx) : false;
            if (TiposHelper.esVerdadero(izq)) return true;
            Object der = derecha != null ? derecha.evaluar(entorno, ctx) : false;
            return TiposHelper.esVerdadero(der);
        }

        Object izq = izquierda != null ? izquierda.evaluar(entorno, ctx) : null;
        Object der = derecha != null ? derecha.evaluar(entorno, ctx) : null;

        if (operador.equals("+") && (izq instanceof String || der instanceof String)) {
            return TiposHelper.formatearSalida(izq) + TiposHelper.formatearSalida(der);
        }

        if (izq instanceof String || der instanceof String) {
            if (operador.equals("-")) {
                ctx.agregarError("Operación incompatible: textum no admite resta.", getLinea(), getColumna());
                return "";
            }
            if (operador.equals("*") || operador.equals("/") || operador.equals("%")) {
                ctx.agregarError("Operación incompatible: textum solo admite concatenación con '+'.", getLinea(), getColumna());
                return "";
            }
        }

        if ((operador.equals("+") || operador.equals("-") || operador.equals("*") || operador.equals("/") || operador.equals("%"))
                && (izq instanceof Boolean || der instanceof Boolean)) {
            ctx.agregarError("Operación incompatible: No se permite aritmética con tipos booleanos.", getLinea(), getColumna());
            return 0;
        }

        if (operador.equals("<") || operador.equals(">") || operador.equals("<=") || operador.equals(">=")) {
            if (!(izq instanceof Number) || !(der instanceof Number)) {
                ctx.agregarError("Comparación inválida: Los operadores relacionales requieren operandos numéricos.", getLinea(), getColumna());
                return false;
            }
            double l = TiposHelper.aDouble(izq);
            double r = TiposHelper.aDouble(der);
            return switch (operador) {
                case "<" -> l < r;
                case ">" -> l > r;
                case "<=" -> l <= r;
                case ">=" -> l >= r;
                default -> false;
            };
        }

        if (operador.equals("==") || operador.equals("===") || operador.equals("!=") || operador.equals("!==")) {
            boolean iguales = Objects.equals(izq, der);
            if (!iguales && (izq instanceof Number && der instanceof Number)) {
                iguales = Double.compare(TiposHelper.aDouble(izq), TiposHelper.aDouble(der)) == 0;
            }
            return operador.startsWith("==") || operador.equals("=") ? iguales : !iguales;
        }

        if (izq instanceof Double || der instanceof Double) {
            double l = TiposHelper.aDouble(izq);
            double r = TiposHelper.aDouble(der);
            return switch (operador) {
                case "+" -> l + r;
                case "-" -> l - r;
                case "*" -> l * r;
                case "/" -> {
                    if (r == 0.0) {
                        ctx.agregarError("Error Aritmético: División entre cero.", getLinea(), getColumna());
                        yield 0.0;
                    }
                    yield l / r;
                }
                case "%" -> {
                    if (r == 0.0) {
                        ctx.agregarError("Error Aritmético: Módulo entre cero.", getLinea(), getColumna());
                        yield 0.0;
                    }
                    yield l % r;
                }
                default -> 0.0;
            };
        } else {
            int l = TiposHelper.aEntero(izq);
            int r = TiposHelper.aEntero(der);
            return switch (operador) {
                case "+" -> l + r;
                case "-" -> l - r;
                case "*" -> l * r;
                case "/" -> {
                    if (r == 0) {
                        ctx.agregarError("Error Aritmético: División entre cero.", getLinea(), getColumna());
                        yield 0;
                    }
                    yield l / r;
                }
                case "%" -> {
                    if (r == 0) {
                        ctx.agregarError("Error Aritmético: Módulo entre cero.", getLinea(), getColumna());
                        yield 0;
                    }
                    yield l % r;
                }
                default -> 0;
            };
        }
    }

    @Override
    public void aPigLatin(StringBuffer sb) {
        if (izquierda != null) {
            izquierda.aPigLatin(sb);
        }
        sb.append(" ").append(operador).append(" ");
        if (derecha != null) {
            derecha.aPigLatin(sb);
        }
    }
}
