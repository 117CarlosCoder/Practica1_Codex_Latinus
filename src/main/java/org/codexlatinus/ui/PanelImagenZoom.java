package org.codexlatinus.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.image.BufferedImage;

public class PanelImagenZoom extends JPanel {
    private BufferedImage imagen;
    private double escala = 1.0;

    private int origenX = 0;
    private int origenY = 0;
    private Point puntoRaton;

    private JLabel etiquetaEstado;
    private String mensajeEstado = "El gráfico visual del árbol AST (Graphviz) aparecerá aquí tras ejecutar...";

    public PanelImagenZoom() {
        setBackground(Color.WHITE);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        MouseAdapter adaptadorRaton = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                puntoRaton = e.getPoint();
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                if (puntoRaton != null) {
                    int dx = e.getX() - puntoRaton.x;
                    int dy = e.getY() - puntoRaton.y;
                    origenX += dx;
                    origenY += dy;
                    puntoRaton = e.getPoint();
                    repaint();
                }
            }

            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                if (imagen == null) return;
                double factorZoom = e.getWheelRotation() < 0 ? 1.15 : 0.85;
                aplicarZoom(factorZoom);
            }
        };

        addMouseListener(adaptadorRaton);
        addMouseMotionListener(adaptadorRaton);
        addMouseWheelListener(adaptadorRaton);
    }

    public void setMensajeEstado(String mensaje) {
        this.mensajeEstado = mensaje;
        repaint();
    }

    public void setImagen(BufferedImage img) {
        this.imagen = img;
        this.escala = 1.0;
        this.origenX = 0;
        this.origenY = 0;
        actualizarEstado();
        repaint();
    }

    public void setEtiquetaEstado(JLabel etiqueta) {
        this.etiquetaEstado = etiqueta;
        actualizarEstado();
    }

    public BufferedImage getImagen() {
        return imagen;
    }

    public void acercar() {
        aplicarZoom(1.25);
    }

    public void alejar() {
        aplicarZoom(0.8);
    }

    public void restablecerZoom() {
        this.escala = 1.0;
        this.origenX = 0;
        this.origenY = 0;
        actualizarEstado();
        repaint();
    }

    private void aplicarZoom(double factor) {
        double nuevaEscala = escala * factor;
        if (nuevaEscala >= 0.1 && nuevaEscala <= 6.0) {
            escala = nuevaEscala;
            actualizarEstado();
            repaint();
        }
    }

    private void actualizarEstado() {
        if (etiquetaEstado != null) {
            int porcentaje = (int) Math.round(escala * 100);
            etiquetaEstado.setText("Zoom: " + porcentaje + "%");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagen == null) {
            g.setColor(new Color(100, 100, 100));
            g.setFont(new Font("Segoe UI", Font.ITALIC, 14));
            g.drawString(mensajeEstado != null ? mensajeEstado : "El gráfico visual aparecerá aquí...", 25, 35);
            return;
        }

        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int anchoImg = (int) (imagen.getWidth() * escala);
        int altoImg = (int) (imagen.getHeight() * escala);

        int x = origenX + (getWidth() - anchoImg) / 2;
        int y = origenY + (getHeight() - altoImg) / 2;

        g2d.drawImage(imagen, x, y, anchoImg, altoImg, null);
        g2d.dispose();
    }
}
