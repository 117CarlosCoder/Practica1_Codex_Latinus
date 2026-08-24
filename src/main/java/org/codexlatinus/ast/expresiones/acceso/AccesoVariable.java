package org.codexlatinus.ast.expresiones.acceso;

import org.codexlatinus.ast.expresiones.Expresion;
import org.codexlatinus.model.ContextoEjecucion;
import org.codexlatinus.model.Entorno;
import org.codexlatinus.model.TiposHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class AccesoVariable extends Expresion {
    private final String identificador;
    private final List<AccesoHijo> accesosHijos = new ArrayList<>();

    public static class AccesoHijo {
        private final boolean esIndice;
        private final Expresion indice;
        private final String campo;

        public AccesoHijo(Expresion indice) {
            this.esIndice = true;
            this.indice = indice;
            this.campo = null;
        }

        public AccesoHijo(String campo) {
            this.esIndice = false;
            this.indice = null;
            this.campo = campo;
        }

        public boolean isEsIndice() {
            return esIndice;
        }

        public Expresion getIndice() {
            return indice;
        }

        public String getCampo() {
            return campo;
        }
    }

    public AccesoVariable(String identificador) {
        this.identificador = identificador;
    }

    public AccesoVariable(String identificador, Expresion indice, AccesoVariable child) {
        this.identificador = identificador;
        if (indice != null) {
            this.agregarIndice(indice);
        }
        if (child != null) {
            this.agregarCampo(child.getIdentificador());
            for (AccesoHijo h : child.getAccesosHijos()) {
                this.accesosHijos.add(h);
            }
        }
    }

    public void agregarIndice(Expresion indice) {
        accesosHijos.add(new AccesoHijo(indice));
    }

    public void agregarCampo(String campo) {
        accesosHijos.add(new AccesoHijo(campo));
    }

    public String getIdentificador() {
        return identificador;
    }

    public List<AccesoHijo> getAccesosHijos() {
        return Collections.unmodifiableList(accesosHijos);
    }

    @Override
    public Object evaluar(Entorno entorno, ContextoEjecucion ctx) {
        Object actual = null;
        try {
            actual = entorno.obtener(identificador);
        } catch (Exception e) {
            ctx.agregarError("Variable no encontrada: '" + identificador + "'.", getLinea(), getColumna());
            return null;
        }

        for (AccesoHijo hijo : accesosHijos) {
            if (hijo.esIndice) {
                int idx = TiposHelper.aEntero(hijo.indice.evaluar(entorno, ctx));
                if (actual instanceof Object[] arr) {
                    if (idx >= 0 && idx < arr.length) {
                        actual = arr[idx];
                    } else {
                        ctx.agregarError("Índice fuera de límites: " + idx, getLinea(), getColumna());
                        return null;
                    }
                } else {
                    ctx.agregarError("El objeto no es un arreglo indexable: " + identificador, getLinea(), getColumna());
                    return null;
                }
            } else {
                if (actual instanceof Map<?, ?> map) {
                    Map<String, Object> sMap = (Map<String, Object>) map;
                    if (!sMap.containsKey(hijo.campo)) {
                        ctx.agregarError("Atributo '" + hijo.campo + "' no existe en la estructura '" + identificador + "'.", getLinea(), getColumna());
                        return null;
                    }
                    actual = sMap.get(hijo.campo);
                } else {
                    ctx.agregarError("El objeto no es una estructura con campos: " + identificador, getLinea(), getColumna());
                    return null;
                }
            }
        }
        return actual;
    }

    public void asignar(Entorno entorno, ContextoEjecucion ctx, Object nuevoValor) {
        if (accesosHijos.isEmpty()) {
            try {
                entorno.asignar(identificador, nuevoValor);
            } catch (Exception e) {
                ctx.agregarError("Variable no declarada: '" + identificador + "'.", getLinea(), getColumna());
            }
            return;
        }

        Object actual = null;
        try {
            actual = entorno.obtener(identificador);
        } catch (Exception e) {
            ctx.agregarError("Variable no encontrada: '" + identificador + "'.", getLinea(), getColumna());
            return;
        }

        for (int i = 0; i < accesosHijos.size() - 1; i++) {
            AccesoHijo hijo = accesosHijos.get(i);
            if (hijo.esIndice) {
                int idx = TiposHelper.aEntero(hijo.indice.evaluar(entorno, ctx));
                if (actual instanceof Object[] arr && idx >= 0 && idx < arr.length) {
                    actual = arr[idx];
                } else {
                    ctx.agregarError("Índice fuera de límites: " + idx, getLinea(), getColumna());
                    return;
                }
            } else {
                if (actual instanceof Map<?, ?> map) {
                    if (!map.containsKey(hijo.campo)) {
                        ctx.agregarError("Atributo '" + hijo.campo + "' no existe en la estructura.", getLinea(), getColumna());
                        return;
                    }
                    actual = ((Map<String, Object>) map).get(hijo.campo);
                } else {
                    ctx.agregarError("Acceso inválido a campo: " + hijo.campo, getLinea(), getColumna());
                    return;
                }
            }
        }

        AccesoHijo ultimo = accesosHijos.get(accesosHijos.size() - 1);
        if (ultimo.esIndice) {
            int idx = TiposHelper.aEntero(ultimo.indice.evaluar(entorno, ctx));
            if (actual instanceof Object[] arr && idx >= 0 && idx < arr.length) {
                arr[idx] = nuevoValor;
            } else {
                ctx.agregarError("Índice fuera de límites: " + idx, getLinea(), getColumna());
            }
        } else {
            if (actual instanceof Map<?, ?> map) {
                if (!map.containsKey(ultimo.campo)) {
                    ctx.agregarError("Atributo '" + ultimo.campo + "' no existe en la estructura.", getLinea(), getColumna());
                } else {
                    ((Map<String, Object>) map).put(ultimo.campo, nuevoValor);
                }
            } else {
                ctx.agregarError("Acceso inválido a campo: " + ultimo.campo, getLinea(), getColumna());
            }
        }
    }

    @Override
    public void aPigLatin(StringBuffer sb) {
        sb.append(identificador);
        for (AccesoHijo h : accesosHijos) {
            if (h.esIndice) {
                sb.append("[");
                if (h.indice != null) {
                    h.indice.aPigLatin(sb);
                }
                sb.append("]");
            } else {
                sb.append(".").append(h.campo);
            }
        }
    }
}
