package org.codexlatinus.utils;

import org.codexlatinus.ast.NodoAst;

public class Type implements NodoAst {
    private final String type;

    public Type(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public boolean isVoid() {
        return "void".equalsIgnoreCase(type);
    }

    @Override
    public void aPigLatin(StringBuffer sb) {
        sb.append(PigLatinTranslater.convertKeyword(type));
    }
}
