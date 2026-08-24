package org.codexlatinus.ast;

import org.codexlatinus.ast.sentencias.Sentencia;
import org.codexlatinus.ast.sentencias.funciones.DeclaracionFuncion;
import org.codexlatinus.model.ContextoEjecucion;
import org.codexlatinus.model.Entorno;
import org.codexlatinus.parser.ResultadoCompilacion;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ArbolAst implements NodoAst, ContenedorSentencias {

    private final List<Sentencia> declaracionesGlobales = new ArrayList<>();
    private final List<DeclaracionFuncion> funciones = new ArrayList<>();
    private final List<Sentencia> sentenciasPrincipales = new ArrayList<>();

    public void agregarDeclaracionGlobal(Sentencia s) {
        declaracionesGlobales.add(s);
    }

    public void agregarFuncion(DeclaracionFuncion f) {
        funciones.add(f);
    }

    public void agregarSentenciaPrincipal(Sentencia s) {
        sentenciasPrincipales.add(s);
    }

    @Override
    public void agregarSentencia(Sentencia sentencia) {
        sentenciasPrincipales.add(sentencia);
    }

    public List<Sentencia> getDeclaracionesGlobales() {
        return declaracionesGlobales;
    }

    public List<DeclaracionFuncion> getFunciones() {
        return funciones;
    }

    public List<Sentencia> getSentenciasPrincipales() {
        return sentenciasPrincipales;
    }

    public ResultadoCompilacion ejecutar(Supplier<String> lector,Consumer<String> escritor,BooleanSupplier cancelChecker,String astString) {
        ContextoEjecucion ctx = new ContextoEjecucion(lector, escritor, cancelChecker);
        Entorno entornoGlobal = new Entorno(null, "Global");

        for (Sentencia g : declaracionesGlobales) {
            if (g != null) {
                g.ejecutar(entornoGlobal, ctx);
                if (ctx.esCancelado()) break;
            }
        }

        for (DeclaracionFuncion fn : funciones) {
            if (fn != null) {
                fn.ejecutar(entornoGlobal, ctx);
                if (ctx.esCancelado()) break;
            }
        }

        Entorno entornoMaior = new Entorno(entornoGlobal, "MAIOR");
        for (Sentencia s : sentenciasPrincipales) {
            if (s != null) {
                s.ejecutar(entornoMaior, ctx);
                if (ctx.esCancelado()) break;
            }
        }

        boolean exitoso = ctx.getErroresSemanticos().isEmpty();

        StringBuffer sbPigLatin = new StringBuffer();
        aPigLatin(sbPigLatin);

        return new ResultadoCompilacion(
                exitoso,
                ctx.getSalidaConsola(),
                astString != null ? astString : "()",
                ctx.getTablaSimbolosCompleta(),
                ctx.getErroresSemanticos(),
                sbPigLatin.toString()
        );
    }

    @Override
    public void aPigLatin(StringBuffer sb) {
        if (!declaracionesGlobales.isEmpty()) {
            sb.append("VARIABILES>\n");
            for (Sentencia s : declaracionesGlobales) {
                s.aPigLatin(sb);
                sb.append("\n");
            }
        }

        if (!funciones.isEmpty()) {
            sb.append("MUNERA>\n");
            for (DeclaracionFuncion f : funciones) {
                f.aPigLatin(sb);
                sb.append("\n");
            }
        }

        if (!sentenciasPrincipales.isEmpty()) {
            sb.append("MAIOR>\n");
            for (Sentencia s : sentenciasPrincipales) {
                s.aPigLatin(sb);
                sb.append("\n");
            }
            sb.append("FINIS;\n");
        }
    }
}
