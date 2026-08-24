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

public class BucleMientras extends Sentencia implements ContenedorSentencias {
    private final Expresion condicion;
    private final List<Sentencia> cuerpo = new ArrayList<>();

    public BucleMientras(Expresion condicion) {
        this.condicion = condicion;
    }

    public Expresion getCondicion() {
        return condicion;
    }

    @Override
    public void agregarSentencia(Sentencia sentencia) {
        cuerpo.add(sentencia);
    }

    public List<Sentencia> getCuerpo() {
        return cuerpo;
    }

    @Override
    public void ejecutar(Entorno entorno, ContextoEjecucion ctx) {
        while (true) {
            if (ctx.esCancelado()) break;

            Object cond = condicion != null ? condicion.evaluar(entorno, ctx) : false;
            if (!(cond instanceof Boolean)) {
                ctx.agregarError("Corrupción de Flujo: La condición del ciclo 'dum' debe ser estrictamente de tipo booleano.", getLinea(), getColumna());
                break;
            }
            if (!TiposHelper.esVerdadero(cond)) break;

            Entorno entornoIteracion = new Entorno(entorno, "Iteracion dum");
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
        }
    }

    @Override
    public void aPigLatin(StringBuffer sb) {
        sb.append(PigLatinTranslater.traducir("dum")).append(" (");
        if (condicion != null) {
            condicion.aPigLatin(sb);
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
