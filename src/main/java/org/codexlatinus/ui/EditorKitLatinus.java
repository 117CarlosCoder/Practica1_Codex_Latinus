package org.codexlatinus.ui;

import javax.swing.text.DefaultEditorKit;
import javax.swing.text.Element;
import javax.swing.text.View;
import javax.swing.text.ViewFactory;

public class EditorKitLatinus extends DefaultEditorKit implements ViewFactory {

    @Override
    public ViewFactory getViewFactory() {
        return this;
    }

    @Override
    public View create(Element elem) {
        return new VistaSintaxisLatinus(elem);
    }

    @Override
    public String getContentType() {
        return "text/codex-latinus";
    }
}
