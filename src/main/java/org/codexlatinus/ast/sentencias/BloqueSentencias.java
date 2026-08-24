package org.codexlatinus.ast.sentencias;

import org.codexlatinus.ast.ContenedorSentencias;
import org.codexlatinus.model.ContextoEjecucion;
import org.codexlatinus.model.Entorno;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BloqueSentencias extends Sentencia implements ContenedorSentencias {
    private final List<Sentencia> sentencias = new ArrayList<>();

    @Override
    public void agregarSentencia(Sentencia sentencia) {
        sentencias.add(sentencia);
    }

    public List<Sentencia> getSentencias() {
        return Collections.unmodifiableList(sentencias);
    }

    @Override
    public void ejecutar(Entorno entorno, ContextoEjecucion ctx) {
        Entorno entornoBloque = new Entorno(entorno, "Bloque");
        for (Sentencia s : sentencias) {
            if (s != null) {
                s.ejecutar(entornoBloque, ctx);
                if (ctx.esCancelado()) break;
            }
        }
    }

    @Override
    public void aPigLatin(StringBuffer sb) {
        sb.append("{\n");
        for (Sentencia s : sentencias) {
            sb.append("    ");
            s.aPigLatin(sb);
            sb.append("\n");
        }
        sb.append("}");
    }
}
