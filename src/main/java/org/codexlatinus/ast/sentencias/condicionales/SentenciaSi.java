package org.codexlatinus.ast.sentencias.condicionales;

import org.codexlatinus.ast.ContenedorSentencias;
import org.codexlatinus.ast.expresiones.Expresion;
import org.codexlatinus.ast.sentencias.Sentencia;
import org.codexlatinus.model.ContextoEjecucion;
import org.codexlatinus.model.Entorno;
import org.codexlatinus.model.TiposHelper;
import org.codexlatinus.utils.PigLatinTranslater;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SentenciaSi extends Sentencia implements ContenedorSentencias {
    private final Expresion condicion;
    private final List<Sentencia> cuerpoSi = new ArrayList<>();
    private final List<RamaSiNoSi> ramasSiNoSi = new ArrayList<>();
    private final List<Sentencia> cuerpoSino = new ArrayList<>();
    private boolean enRamaSino = false;

    public static class RamaSiNoSi {
        private final Expresion condicion;
        private final List<Sentencia> cuerpo;

        public RamaSiNoSi(Expresion condicion, List<Sentencia> cuerpo) {
            this.condicion = condicion;
            this.cuerpo = cuerpo != null ? cuerpo : new ArrayList<>();
        }

        public Expresion getCondicion() {
            return condicion;
        }

        public List<Sentencia> getCuerpo() {
            return Collections.unmodifiableList(cuerpo);
        }
    }

    public SentenciaSi(Expresion condicion) {
        this.condicion = condicion;
    }

    public Expresion getCondicion() {
        return condicion;
    }

    public void setEnRamaSino(boolean enRamaSino) {
        this.enRamaSino = enRamaSino;
    }

    @Override
    public void agregarSentencia(Sentencia sentencia) {
        if (enRamaSino) {
            cuerpoSino.add(sentencia);
        } else {
            cuerpoSi.add(sentencia);
        }
    }

    public void agregarRamaSiNoSi(Expresion condicion, List<Sentencia> cuerpo) {
        ramasSiNoSi.add(new RamaSiNoSi(condicion, cuerpo));
    }

    public void agregarSentenciaSiNo(Sentencia sentencia) {
        cuerpoSino.add(sentencia);
    }

    public List<Sentencia> getCuerpoSi() {
        return Collections.unmodifiableList(cuerpoSi);
    }

    public List<RamaSiNoSi> getRamasSiNoSi() {
        return Collections.unmodifiableList(ramasSiNoSi);
    }

    public List<Sentencia> getCuerpoSino() {
        return Collections.unmodifiableList(cuerpoSino);
    }

    @Override
    public void ejecutar(Entorno entorno, ContextoEjecucion ctx) {
        Object condPrincipal = condicion != null ? condicion.evaluar(entorno, ctx) : false;
        if (!(condPrincipal instanceof Boolean)) {
            ctx.agregarError("Corrupción de Flujo: La condición de la sentencia 'si' debe ser estrictamente de tipo booleano.", getLinea(), getColumna());
            return;
        }
        if (TiposHelper.esVerdadero(condPrincipal)) {
            Entorno entornoSi = new Entorno(entorno, "Bloque si");
            for (Sentencia st : cuerpoSi) {
                if (st != null) {
                    st.ejecutar(entornoSi, ctx);
                    if (ctx.esCancelado()) break;
                }
            }
            return;
        }

        for (RamaSiNoSi rama : ramasSiNoSi) {
            Object condRama = rama.getCondicion() != null ? rama.getCondicion().evaluar(entorno, ctx) : false;
            if (!(condRama instanceof Boolean)) {
                ctx.agregarError("Corrupción de Flujo: La condición de la sentencia 'aliter si' debe ser estrictamente de tipo booleano.", getLinea(), getColumna());
                return;
            }
            if (TiposHelper.esVerdadero(condRama)) {
                Entorno entornoElif = new Entorno(entorno, "Bloque aliter si");
                for (Sentencia st : rama.getCuerpo()) {
                    if (st != null) {
                        st.ejecutar(entornoElif, ctx);
                        if (ctx.esCancelado()) break;
                    }
                }
                return;
            }
        }

        if (!cuerpoSino.isEmpty()) {
            Entorno entornoElse = new Entorno(entorno, "Bloque aliter");
            for (Sentencia st : cuerpoSino) {
                if (st != null) {
                    st.ejecutar(entornoElse, ctx);
                    if (ctx.esCancelado()) break;
                }
            }
        }
    }

    @Override
    public void aPigLatin(StringBuffer sb) {
        sb.append(PigLatinTranslater.traducir("si")).append(" (");
        if (condicion != null) {
            condicion.aPigLatin(sb);
        }
        sb.append(") {\n");
        for (Sentencia s : cuerpoSi) {
            sb.append("    ");
            s.aPigLatin(sb);
            sb.append("\n");
        }
        sb.append("}");

        for (RamaSiNoSi r : ramasSiNoSi) {
            sb.append(" ").append(PigLatinTranslater.traducir("aliter")).append(" ");
            sb.append(PigLatinTranslater.traducir("si")).append(" (");
            if (r.condicion != null) {
                r.condicion.aPigLatin(sb);
            }
            sb.append(") {\n");
            for (Sentencia s : r.cuerpo) {
                sb.append("    ");
                s.aPigLatin(sb);
                sb.append("\n");
            }
            sb.append("}");
        }

        if (!cuerpoSino.isEmpty()) {
            sb.append(" ").append(PigLatinTranslater.traducir("aliter")).append(" {\n");
            for (Sentencia s : cuerpoSino) {
                sb.append("    ");
                s.aPigLatin(sb);
                sb.append("\n");
            }
            sb.append("}");
        }
        sb.append(" ").append(PigLatinTranslater.traducir("finis")).append(";");
    }
}
