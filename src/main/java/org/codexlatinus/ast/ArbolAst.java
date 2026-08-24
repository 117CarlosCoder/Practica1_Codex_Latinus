package org.codexlatinus.ast;

import org.codexlatinus.ast.sentencias.Sentencia;
import org.codexlatinus.ast.sentencias.funciones.DeclaracionFuncion;
import org.codexlatinus.model.ContextoEjecucion;
import org.codexlatinus.model.Entorno;
import org.codexlatinus.model.PasoPila;
import org.codexlatinus.parser.ResultadoCompilacion;
import org.codexlatinus.utils.PigLatinTranslater;

import java.util.ArrayList;
import java.util.Collections;
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

    public ResultadoCompilacion ejecutar(Supplier<String> lector, Consumer<String> escritor, BooleanSupplier cancelChecker, String astString) {
        return ejecutar(lector, escritor, cancelChecker, astString, "", null, Collections.emptyList());
    }

    public ResultadoCompilacion ejecutar(Supplier<String> lector, Consumer<String> escritor, BooleanSupplier cancelChecker, String astString, String codigoDot, java.awt.image.BufferedImage imagenGraphviz) {
        return ejecutar(lector, escritor, cancelChecker, astString, codigoDot, imagenGraphviz, Collections.emptyList());
    }

    public ResultadoCompilacion ejecutar(Supplier<String> lector, Consumer<String> escritor, BooleanSupplier cancelChecker, String astString, String codigoDot, java.awt.image.BufferedImage imagenGraphviz, List<PasoPila> pasosPila) {
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
                sbPigLatin.toString(),
                ctx.getTablaTipos(),
                codigoDot,
                imagenGraphviz,
                pasosPila
        );
    }

    @Override
    public void aPigLatin(StringBuffer sb) {
        if (!declaracionesGlobales.isEmpty()) {
            sb.append(PigLatinTranslater.traducir("VARIABILES>")).append("\n");
            for (Sentencia s : declaracionesGlobales) {
                s.aPigLatin(sb);
                sb.append("\n");
            }
        }

        if (!funciones.isEmpty()) {
            sb.append(PigLatinTranslater.traducir("MUNERA>")).append("\n");
            for (DeclaracionFuncion f : funciones) {
                f.aPigLatin(sb);
                sb.append("\n");
            }
        }

        if (!sentenciasPrincipales.isEmpty()) {
            sb.append(PigLatinTranslater.traducir("MAIOR>")).append("\n");
            for (Sentencia s : sentenciasPrincipales) {
                s.aPigLatin(sb);
                sb.append("\n");
            }
            sb.append(PigLatinTranslater.traducir("FINIS")).append(";\n");
        }
    }
}
