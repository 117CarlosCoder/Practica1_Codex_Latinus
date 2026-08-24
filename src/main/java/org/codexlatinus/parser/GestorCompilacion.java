package org.codexlatinus.parser;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.codexlatinus.CodexLatinusLexer;
import org.codexlatinus.CodexLatinusParser;
import org.codexlatinus.ast.ArbolAst;
import org.codexlatinus.ast.VisitanteCodexLatinusAst;
import org.codexlatinus.model.ErrorCompilador;
import org.codexlatinus.model.PasoPila;

import java.util.ArrayList;
import java.util.List;

public class GestorCompilacion {

    public static ResultadoCompilacion ejecutar(String codigoFuente) {
        return ejecutar(codigoFuente, null, null, null);
    }

    public static ResultadoCompilacion ejecutar(String codigoFuente, java.util.function.Supplier<String> lectorConsola) {
        return ejecutar(codigoFuente, lectorConsola, null, null);
    }

    public static ResultadoCompilacion ejecutar(String codigoFuente,
                                                java.util.function.Supplier<String> lectorConsola,
                                                java.util.function.Consumer<String> escritorConsola) {
        return ejecutar(codigoFuente, lectorConsola, escritorConsola, null);
    }

    public static ResultadoCompilacion ejecutar(String codigoFuente,
                                                java.util.function.Supplier<String> lectorConsola,
                                                java.util.function.Consumer<String> escritorConsola,
                                                java.util.function.BooleanSupplier verificadorCancelacion) {
        List<ErrorCompilador> erroresTotales = new ArrayList<>();

        CodexLatinusLexer lexer = new CodexLatinusLexer(CharStreams.fromString(codigoFuente != null ? codigoFuente : ""));
        ManejadorErroresANTLR errorLexicoListener = new ManejadorErroresANTLR(ErrorCompilador.TipoError.LEXICO);
        lexer.removeErrorListeners();
        lexer.addErrorListener(errorLexicoListener);

        CommonTokenStream tokenStream = new CommonTokenStream(lexer);

        ManejadorErroresANTLR errorSintacticoListener = new ManejadorErroresANTLR(ErrorCompilador.TipoError.SINTACTICO);
        CodexLatinusParser parser = new CodexLatinusParser(tokenStream);
        parser.removeErrorListeners();
        parser.addErrorListener(errorSintacticoListener);

        CodexLatinusParser.ProgramContext tree = parser.program();

        erroresTotales.addAll(errorLexicoListener.getListaErrores());
        erroresTotales.addAll(errorSintacticoListener.getListaErrores());

        String astString = tree.toStringTree(parser);
        String codigoDot = org.codexlatinus.visitor.VisitanteGraphviz.generarDot(tree, parser);

        CapturadorPilaListener capturadorPila = new CapturadorPilaListener(parser);
        ParseTreeWalker.DEFAULT.walk(capturadorPila, tree);
        capturadorPila.finalizarAnalisis();
        List<PasoPila> pasosPila = capturadorPila.getPasos();

        if (!erroresTotales.isEmpty()) {
            return new ResultadoCompilacion(
                    false,
                    "== ERROR: No se puede ejecutar el programa debido a errores en la fase de análisis. ==",
                    astString,
                    List.of(),
                    erroresTotales,
                    "",
                    new org.codexlatinus.model.TablaTipos(),
                    codigoDot,
                    null,
                    pasosPila
            );
        }

        VisitanteCodexLatinusAst builder = new VisitanteCodexLatinusAst();
        ArbolAst ast = builder.visitProgram(tree);
        try {
            return ast.ejecutar(lectorConsola, escritorConsola, verificadorCancelacion, astString, codigoDot, null, pasosPila);
        } catch (Exception e) {
            erroresTotales.add(new ErrorCompilador(ErrorCompilador.TipoError.SEMANTICO, "Excepción en tiempo de ejecución: " + e.getMessage(), 1, 1));
            return new ResultadoCompilacion(
                    false,
                    "== ERROR: Excepción durante la ejecución del AST: " + e.getMessage(),
                    astString,
                    List.of(),
                    erroresTotales,
                    "",
                    new org.codexlatinus.model.TablaTipos(),
                    codigoDot,
                    null,
                    pasosPila
            );
        }
    }

    public static String traducirAPigLatin(String codigoFuente) {
        if (codigoFuente == null || codigoFuente.trim().isEmpty()) {
            return "";
        }
        try {
            CodexLatinusLexer lexer = new CodexLatinusLexer(CharStreams.fromString(codigoFuente));
            lexer.removeErrorListeners();
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            CodexLatinusParser parser = new CodexLatinusParser(tokens);
            parser.removeErrorListeners();
            CodexLatinusParser.ProgramContext tree = parser.program();

            VisitanteCodexLatinusAst builder = new VisitanteCodexLatinusAst();
            ArbolAst ast = builder.visitProgram(tree);
            StringBuffer sb = new StringBuffer();
            ast.aPigLatin(sb);
            return sb.toString();
        } catch (Exception e) {
            return "Error al traducir a Pig Latin: " + e.getMessage();
        }
    }
}
