package org.codexlatinus.ast.sentencias.ciclos;

import org.codexlatinus.ast.ContenedorSentencias;
import org.codexlatinus.ast.expresiones.Expresion;
import org.codexlatinus.ast.sentencias.Sentencia;
import org.codexlatinus.model.ContextoEjecucion;
import org.codexlatinus.model.Entorno;
import org.codexlatinus.model.SenalesControl;
import org.codexlatinus.model.TiposHelper;
import org.codexlatinus.utils.PigLatinTranslater;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BuclePara extends Sentencia implements ContenedorSentencias {
    private final Sentencia inicializacion;
    private final Expresion condicion;
    private final Sentencia actualizacion;
    private final List<Sentencia> cuerpo = new ArrayList<>();

    public BuclePara(Sentencia inicializacion, Expresion condicion, Sentencia actualizacion) {
        this.inicializacion = inicializacion;
        this.condicion = condicion;
        this.actualizacion = actualizacion;
    }

    public Sentencia getInicializacion() {
        return inicializacion;
    }

    public Expresion getCondicion() {
        return condicion;
    }

    public Sentencia getActualizacion() {
        return actualizacion;
    }

    @Override
    public void agregarSentencia(Sentencia sentencia) {
        cuerpo.add(sentencia);
    }

    public List<Sentencia> getCuerpo() {
        return Collections.unmodifiableList(cuerpo);
    }

    @Override
    public void ejecutar(Entorno entorno, ContextoEjecucion ctx) {
        Entorno entornoFor = new Entorno(entorno, "Ciclo per");
        if (inicializacion != null) {
            inicializacion.ejecutar(entornoFor, ctx);
        }

        while (true) {
            if (ctx.esCancelado()) break;

            if (condicion != null) {
                Object cond = condicion.evaluar(entornoFor, ctx);
                if (!(cond instanceof Boolean)) {
                    ctx.agregarError("Corrupción de Flujo: La condición del ciclo 'per' debe ser booleana.", getLinea(), getColumna());
                    break;
                }
                if (!TiposHelper.esVerdadero(cond)) break;
            }

            Entorno entornoIteracion = new Entorno(entornoFor, "Iteracion per");
            try {
                for (Sentencia st : cuerpo) {
                    if (st != null) {
                        st.ejecutar(entornoIteracion, ctx);
                        if (ctx.esCancelado()) break;
                    }
                }
            } catch (SenalesControl.SenalBreak brk) {
                break;
            } catch (SenalesControl.SenalContinue cnt) {
            }

            if (ctx.esCancelado()) break;

            if (actualizacion != null) {
                actualizacion.ejecutar(entornoFor, ctx);
            }
        }
    }

    @Override
    public void aPigLatin(StringBuffer sb) {
        sb.append(PigLatinTranslater.traducir("per")).append(" (");
        if (inicializacion != null) {
            StringBuffer initSb = new StringBuffer();
            inicializacion.aPigLatin(initSb);
            String initStr = initSb.toString().trim();
            if (initStr.endsWith(";")) initStr = initStr.substring(0, initStr.length() - 1);
            sb.append(initStr);
        }
        sb.append("; ");
        if (condicion != null) {
            condicion.aPigLatin(sb);
        }
        sb.append("; ");
        if (actualizacion != null) {
            StringBuffer actSb = new StringBuffer();
            actualizacion.aPigLatin(actSb);
            String actStr = actSb.toString().trim();
            if (actStr.endsWith(";")) actStr = actStr.substring(0, actStr.length() - 1);
            sb.append(actStr);
        }
        sb.append(") {\n");
        for (Sentencia s : cuerpo) {
            sb.append("    ");
            s.aPigLatin(sb);
            sb.append("\n");
        }
        sb.append("} ").append(PigLatinTranslater.traducir("finis")).append(";");
    }
}
