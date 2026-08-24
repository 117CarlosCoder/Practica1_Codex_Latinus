package org.codexlatinus.ast.expresiones.literales;

import org.codexlatinus.CodexLatinusParser;

public class VisitanteLiterales {

    public Literal visitLiteral(CodexLatinusParser.LiteralContext ctx) {
        if (ctx == null) return null;

        if (ctx.INT_LITERAL() != null) {
            return new Literal("numerus", Integer.parseInt(ctx.INT_LITERAL().getText()));
        }
        if (ctx.DOUBLE_LITERAL() != null) {
            return new Literal("decimalis", Double.parseDouble(ctx.DOUBLE_LITERAL().getText()));
        }
        if (ctx.STRING_LITERAL() != null) {
            String raw = ctx.STRING_LITERAL().getText();
            String s = raw.substring(1, raw.length() - 1);
            s = s.replace("\\n", "\n")
                 .replace("\\t", "\t")
                 .replace("\\r", "\r")
                 .replace("\\\"", "\"")
                 .replace("\\\\", "\\");
            return new Literal("textum", s);
        }
        if (ctx.CHAR_LITERAL() != null) {
            String raw = ctx.CHAR_LITERAL().getText();
            String s = raw.substring(1, raw.length() - 1);
            s = s.replace("\\n", "\n")
                 .replace("\\t", "\t")
                 .replace("\\r", "\r")
                 .replace("\\'", "'")
                 .replace("\\\\", "\\");
            char c = !s.isEmpty() ? s.charAt(0) : '\0';
            return new Literal("littera", c);
        }
        return null;
    }
}
