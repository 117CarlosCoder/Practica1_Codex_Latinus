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

public class BucleHacerMientras extends Sentencia implements ContenedorSentencias {
    private final List<Sentencia> cuerpo = new ArrayList<>();
    private final Expresion condicion;

    public BucleHacerMientras(Expresion condicion) {
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
        return Collections.unmodifiableList(cuerpo);
    }

    @Override
    public void ejecutar(Entorno entorno, ContextoEjecucion ctx) {
        do {
            if (ctx.esCancelado()) break;

            Entorno entornoIteracion = new Entorno(entorno, "Iteracion facere");
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

            Object cond = condicion != null ? condicion.evaluar(entorno, ctx) : false;
            if (!(cond instanceof Boolean)) {
                ctx.agregarError("Corrupción de Flujo: La condición del ciclo 'facere...dum' debe ser booleana.", getLinea(), getColumna());
                break;
            }
            if (!TiposHelper.esVerdadero(cond)) break;
        } while (true);
    }

    @Override
    public void aPigLatin(StringBuffer sb) {
        sb.append(PigLatinTranslater.traducir("facere")).append(" {\n");
        for (Sentencia s : cuerpo) {
            sb.append("    ");
            s.aPigLatin(sb);
            sb.append("\n");
        }
        sb.append("} ").append(PigLatinTranslater.traducir("dum")).append(" (");
        if (condicion != null) {
            condicion.aPigLatin(sb);
        }
        sb.append(");");
    }
}
