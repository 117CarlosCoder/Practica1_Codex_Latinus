package org.codexlatinus.ui;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class NumeroLinea extends JPanel implements CaretListener, DocumentListener, PropertyChangeListener {

    private final JTextComponent componenteTexto;
    private final Color colorCaret = new Color(230, 230, 230);
    private final Color colorNormal = new Color(120, 120, 120);
    private final Color colorFondo = new Color(30, 30, 30);
    private final Color colorBorde = new Color(55, 55, 55);

    private int ultimoDigitos = 0;
    private int ultimoAlto = 0;

    public NumeroLinea(JTextComponent componenteTexto) {
        this(componenteTexto, 3);
    }

    public NumeroLinea(JTextComponent componenteTexto, int digitosMinimos) {
        this.componenteTexto = componenteTexto;
        setOpaque(true);
        setBackground(colorFondo);
        setForeground(colorNormal);
        setFont(componenteTexto.getFont());

        Border bordeExterior = new MatteBorder(0, 0, 0, 1, colorBorde);
        Border bordeInterior = new EmptyBorder(0, 8, 0, 8);
        setBorder(new CompoundBorder(bordeExterior, bordeInterior));

        componenteTexto.getDocument().addDocumentListener(this);
        componenteTexto.addCaretListener(this);
        componenteTexto.addPropertyChangeListener("font", this);
        componenteTexto.addPropertyChangeListener("document", this);

        setDigitosMinimos(digitosMinimos);
    }

    public void setDigitosMinimos(int digitosMinimos) {
        this.ultimoDigitos = Math.max(digitosMinimos, 3);
        actualizarTamanoPreferido();
    }

    private void actualizarTamanoPreferido() {
        if (componenteTexto == null || componenteTexto.getDocument() == null) {
            return;
        }

        Element raiz = componenteTexto.getDocument().getDefaultRootElement();
        int totalLineas = raiz.getElementCount();
        int digitos = Math.max(String.valueOf(totalLineas).length(), ultimoDigitos);

        FontMetrics fontMetrics = getFontMetrics(getFont() != null ? getFont() : componenteTexto.getFont());
        int anchoTexto = fontMetrics.charWidth('9') * digitos;
        Insets insets = getInsets();
        int anchoPreferido = insets.left + insets.right + anchoTexto;
        int altoPreferido = Math.max(componenteTexto.getHeight(), componenteTexto.getPreferredSize().height);

        Dimension tamanoActual = getPreferredSize();
        if (tamanoActual.width != anchoPreferido || tamanoActual.height != altoPreferido) {
            ultimoDigitos = digitos;
            ultimoAlto = altoPreferido;
            Dimension nuevoTamano = new Dimension(anchoPreferido, altoPreferido);
            setPreferredSize(nuevoTamano);
            setSize(nuevoTamano);
            revalidate();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g.create();
        try {
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

            Rectangle clip = g2d.getClipBounds();
            if (clip == null) {
                clip = new Rectangle(0, 0, getWidth(), getHeight());
            }

            // 1. Limpieza absoluta del fondo para evitar números fantasma y superposiciones
            g2d.setColor(getBackground());
            g2d.fillRect(clip.x, clip.y, clip.width, clip.height);

            if (componenteTexto == null || componenteTexto.getDocument() == null) {
                return;
            }

            Font fuente = getFont() != null ? getFont() : componenteTexto.getFont();
            g2d.setFont(fuente);
            FontMetrics fontMetrics = g2d.getFontMetrics();

            Insets insets = getInsets();
            int anchoDisponible = getWidth() - insets.left - insets.right;

            Element raiz = componenteTexto.getDocument().getDefaultRootElement();
            int totalElementos = raiz.getElementCount();
            if (totalElementos <= 0) {
                return;
            }

            // 2. Cálculo seguro de líneas visibles
            int inicioOffset = Math.max(0, componenteTexto.viewToModel2D(new Point(0, Math.max(0, clip.y))));
            int finOffset = Math.max(0, componenteTexto.viewToModel2D(new Point(0, clip.y + clip.height)));

            int lineaInicio = Math.min(Math.max(0, raiz.getElementIndex(inicioOffset)), totalElementos - 1);
            int lineaFin = Math.min(Math.max(lineaInicio, raiz.getElementIndex(finOffset)), totalElementos - 1);

            int posCaret = componenteTexto.getCaretPosition();
            int lineaCaret = raiz.getElementIndex(posCaret);

            // 3. Dibujo de cada número de línea en su posición Y exacta
            for (int i = lineaInicio; i <= lineaFin; i++) {
                Element elemLinea = raiz.getElement(i);
                try {
                    Rectangle2D r = componenteTexto.modelToView2D(elemLinea.getStartOffset());
                    if (r == null) {
                        continue;
                    }

                    String textoNumero = String.valueOf(i + 1);
                    int anchoTexto = fontMetrics.stringWidth(textoNumero);
                    int x = insets.left + (anchoDisponible - anchoTexto);
                    int y = (int) Math.round(r.getY()) + fontMetrics.getAscent();

                    if (i == lineaCaret) {
                        g2d.setColor(colorCaret);
                    } else {
                        g2d.setColor(colorNormal);
                    }

                    g2d.drawString(textoNumero, x, y);
                } catch (BadLocationException e) {
                    break;
                }
            }
        } finally {
            g2d.dispose();
        }
    }

    @Override
    public void caretUpdate(CaretEvent e) {
        repaint();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        documentoModificado();
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        documentoModificado();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        documentoModificado();
    }

    private void documentoModificado() {
        SwingUtilities.invokeLater(() -> {
            actualizarTamanoPreferido();
            repaint();
        });
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("font".equals(evt.getPropertyName()) && evt.getNewValue() instanceof Font nuevaFuente) {
            setFont(nuevaFuente);
            actualizarTamanoPreferido();
            repaint();
        } else if ("document".equals(evt.getPropertyName())) {
            if (evt.getOldValue() instanceof Document docViejo) {
                docViejo.removeDocumentListener(this);
            }
            if (evt.getNewValue() instanceof Document docNuevo) {
                docNuevo.addDocumentListener(this);
            }
            actualizarTamanoPreferido();
            repaint();
        }
    }
}
