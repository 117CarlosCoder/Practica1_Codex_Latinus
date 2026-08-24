package org.codexlatinus.parser;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.codexlatinus.model.ErrorCompilador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ManejadorErroresANTLR extends BaseErrorListener {
    private final List<ErrorCompilador> listaErrores = new ArrayList<>();
    private final ErrorCompilador.TipoError tipoError;

    public ManejadorErroresANTLR(ErrorCompilador.TipoError tipoError) {
        this.tipoError = tipoError;
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer,
                            Object offendingSymbol,
                            int line,
                            int charPositionInLine,
                            String msg,
                            RecognitionException e) {
        listaErrores.add(new ErrorCompilador(tipoError, msg, line, charPositionInLine + 1));
    }

    public boolean tieneErrores() {
        return !listaErrores.isEmpty();
    }

    public List<ErrorCompilador> getListaErrores() {
        return Collections.unmodifiableList(listaErrores);
    }
}
