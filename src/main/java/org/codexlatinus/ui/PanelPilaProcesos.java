package org.codexlatinus.ui;

import org.codexlatinus.model.PasoPila;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.List;

public class PanelPilaProcesos extends JPanel {

    private List<PasoPila> listaPasos = new ArrayList<>();
    private int indicePasoActual = -1;

    private final JLabel lblTituloPaso;
    private final JLabel lblOperacionActual;
    private final JButton btnInicio;
    private final JButton btnAnterior;
    private final JButton btnSiguiente;
    private final JButton btnFin;
    private final JButton btnAutoPlay;
    private final JSlider sliderPasos;

    private final LienzoPila lienzoPila;
    private final JTextArea areaLog;
    private final JScrollPane scrollLog;

    private Timer timerAutoPlay;

    public PanelPilaProcesos() {
        setLayout(new BorderLayout(10, 10));
        setBackground(new Color(30, 30, 30));
        setBorder(new EmptyBorder(10, 10, 10, 10));

        JPanel panelControles = new JPanel(new BorderLayout(10, 5));
        panelControles.setBackground(new Color(37, 37, 38));
        panelControles.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(60, 60, 60), 1),
                new EmptyBorder(8, 12, 8, 12)
        ));

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 0));
        panelBotones.setOpaque(false);

        btnInicio = crearBoton("Inicio", "Ir al primer paso");
        btnAnterior = crearBoton("Anterior", "Retroceder un paso");
        btnSiguiente = crearBoton("Siguiente", "Avanzar un paso");
        btnFin = crearBoton("Fin", "Ir al último paso");
        btnAutoPlay = crearBoton("Reproducir", "Reproducción automática paso a paso");

        panelBotones.add(btnInicio);
        panelBotones.add(btnAnterior);
        panelBotones.add(btnSiguiente);
        panelBotones.add(btnFin);
        panelBotones.add(new JSeparator(SwingConstants.VERTICAL));
        panelBotones.add(btnAutoPlay);

        JPanel panelEtiquetas = new JPanel(new GridLayout(2, 1, 2, 2));
        panelEtiquetas.setOpaque(false);
        lblTituloPaso = new JLabel("Paso: 0 / 0", SwingConstants.RIGHT);
        lblTituloPaso.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblTituloPaso.setForeground(new Color(220, 220, 220));

        lblOperacionActual = new JLabel("Acción: Ninguna", SwingConstants.RIGHT);
        lblOperacionActual.setFont(new Font("Consolas", Font.BOLD, 13));
        lblOperacionActual.setForeground(new Color(86, 156, 214));

        panelEtiquetas.add(lblTituloPaso);
        panelEtiquetas.add(lblOperacionActual);

        sliderPasos = new JSlider(0, 0, 0);
        sliderPasos.setOpaque(false);
        sliderPasos.setEnabled(false);
        sliderPasos.addChangeListener(e -> {
            if (sliderPasos.getValueIsAdjusting() || !sliderPasos.isEnabled()) return;
            int valor = sliderPasos.getValue();
            if (valor >= 0 && valor < listaPasos.size() && valor != indicePasoActual) {
                mostrarPaso(valor);
            }
        });

        panelControles.add(panelBotones, BorderLayout.WEST);
        panelControles.add(panelEtiquetas, BorderLayout.EAST);
        panelControles.add(sliderPasos, BorderLayout.SOUTH);

        add(panelControles, BorderLayout.NORTH);

        // --- PANEL CENTRAL: PILA GRÁFICA (IZQ) Y LOG (DER) ---
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setDividerLocation(380);
        splitPane.setResizeWeight(0.45);
        splitPane.setBorder(null);
        splitPane.setOpaque(false);

        // 1. Visor gráfico de la Pila
        lienzoPila = new LienzoPila();
        JScrollPane scrollPila = new JScrollPane(lienzoPila);
        scrollPila.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(70, 70, 70)),
                "Gráfica de la Pila (Bottom-Up)",
                0, 0,
                new Font("Segoe UI", Font.BOLD, 12),
                new Color(200, 200, 200)
        ));
        scrollPila.getViewport().setBackground(new Color(24, 24, 24));

        // 2. Log de Operaciones (Estilo consola negra del PDF)
        areaLog = new JTextArea();
        areaLog.setEditable(false);
        areaLog.setFont(new Font("Consolas", Font.PLAIN, 13));
        areaLog.setBackground(new Color(13, 17, 23));
        areaLog.setForeground(new Color(240, 246, 252));
        areaLog.setMargin(new Insets(10, 10, 10, 10));

        scrollLog = new JScrollPane(areaLog);
        scrollLog.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(70, 70, 70)),
                "LOG de Operaciones Sintácticas",
                0, 0,
                new Font("Segoe UI", Font.BOLD, 12),
                new Color(200, 200, 200)
        ));

        splitPane.setLeftComponent(scrollPila);
        splitPane.setRightComponent(scrollLog);

        add(splitPane, BorderLayout.CENTER);

        // --- EVENTOS DE BOTONES ---
        btnInicio.addActionListener(e -> mostrarPaso(0));
        btnAnterior.addActionListener(e -> {
            if (indicePasoActual > 0) mostrarPaso(indicePasoActual - 1);
        });
        btnSiguiente.addActionListener(e -> {
            if (indicePasoActual + 1 < listaPasos.size()) mostrarPaso(indicePasoActual + 1);
        });
        btnFin.addActionListener(e -> {
            if (!listaPasos.isEmpty()) mostrarPaso(listaPasos.size() - 1);
        });

        configurarAutoPlay();
        actualizarEstadoBotones();
    }

    private JButton crearBoton(String texto, String tooltip) {
        JButton btn = new JButton(texto);
        btn.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        btn.setToolTipText(tooltip);
        btn.setFocusPainted(false);
        btn.setBackground(new Color(45, 45, 48));
        btn.setForeground(Color.WHITE);
        btn.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(70, 70, 70), 1),
                new EmptyBorder(5, 10, 5, 10)
        ));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btn.setBackground(new Color(62, 62, 66));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btn.setBackground(new Color(45, 45, 48));
            }
        });
        return btn;
    }

    private void configurarAutoPlay() {
        timerAutoPlay = new Timer(350, e -> {
            if (indicePasoActual + 1 < listaPasos.size()) {
                mostrarPaso(indicePasoActual + 1);
            } else {
                detenerAutoPlay();
            }
        });

        btnAutoPlay.addActionListener(e -> {
            if (timerAutoPlay.isRunning()) {
                detenerAutoPlay();
            } else {
                iniciarAutoPlay();
            }
        });
    }

    private void iniciarAutoPlay() {
        if (listaPasos.isEmpty()) return;
        if (indicePasoActual >= listaPasos.size() - 1) {
            mostrarPaso(0);
        }
        btnAutoPlay.setText("Pausar");
        btnAutoPlay.setBackground(new Color(200, 100, 0));
        timerAutoPlay.start();
    }

    private void detenerAutoPlay() {
        timerAutoPlay.stop();
        btnAutoPlay.setText("Reproducir");
        btnAutoPlay.setBackground(new Color(45, 45, 48));
    }

    public void cargarPasos(List<PasoPila> pasos) {
        detenerAutoPlay();
        this.listaPasos = pasos != null ? new ArrayList<>(pasos) : new ArrayList<>();
        if (!listaPasos.isEmpty()) {
            sliderPasos.setEnabled(true);
            sliderPasos.setMinimum(0);
            sliderPasos.setMaximum(listaPasos.size() - 1);
            sliderPasos.setValue(0);
            mostrarPaso(0);
        } else {
            sliderPasos.setEnabled(false);
            sliderPasos.setMinimum(0);
            sliderPasos.setMaximum(0);
            sliderPasos.setValue(0);
            indicePasoActual = -1;
            lblTituloPaso.setText("Paso: 0 / 0");
            lblOperacionActual.setText("Acción: Ninguna");
            areaLog.setText("No hay pasos sintácticos registrados.");
            lienzoPila.setElementos(List.of(), "");
            actualizarEstadoBotones();
        }
    }

    public void mostrarPaso(int indice) {
        if (indice < 0 || indice >= listaPasos.size()) return;
        this.indicePasoActual = indice;
        PasoPila paso = listaPasos.get(indice);

        lblTituloPaso.setText("Paso: " + (indice + 1) + " / " + listaPasos.size());
        lblOperacionActual.setText("Acción: " + paso.getOperacion());
        sliderPasos.setValue(indice);

        // Actualizar pila gráfica
        lienzoPila.setElementos(paso.getElementosPila(), paso.getOperacion());

        // Actualizar Log
        StringBuilder sbLog = new StringBuilder();
        List<String> log = paso.getHistorialLog();
        for (int i = 0; i < log.size(); i++) {
            if (i == log.size() - 1) {
                sbLog.append("> ").append(log.get(i)).append("\n");
            } else {
                sbLog.append("  ").append(log.get(i)).append("\n");
            }
        }
        areaLog.setText(sbLog.toString());
        areaLog.setCaretPosition(areaLog.getDocument().getLength());

        actualizarEstadoBotones();
    }

    private void actualizarEstadoBotones() {
        boolean hayPasos = !listaPasos.isEmpty();
        btnInicio.setEnabled(hayPasos && indicePasoActual > 0);
        btnAnterior.setEnabled(hayPasos && indicePasoActual > 0);
        btnSiguiente.setEnabled(hayPasos && indicePasoActual < listaPasos.size() - 1);
        btnFin.setEnabled(hayPasos && indicePasoActual < listaPasos.size() - 1);
        btnAutoPlay.setEnabled(hayPasos);
    }

    // --- LIENZO 2D PARA DIBUJAR LOS BLOQUES DE LA PILA ---
    private static class LienzoPila extends JPanel {
        private List<String> elementos = new ArrayList<>();
        private String ultimaOperacion = "";

        public LienzoPila() {
            setBackground(new Color(24, 24, 24));
        }

        public void setElementos(List<String> elementos, String operacion) {
            this.elementos = elementos != null ? new ArrayList<>(elementos) : new ArrayList<>();
            this.ultimaOperacion = operacion != null ? operacion : "";
            int altoRequerido = Math.max(400, (this.elementos.size() + 2) * 44 + 60);
            setPreferredSize(new Dimension(340, altoRequerido));
            revalidate();
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

            int anchoPanel = getWidth();
            int altoPanel = getHeight();

            int anchoBloque = Math.min(260, anchoPanel - 60);
            int altoBloque = 36;
            int xCentro = (anchoPanel - anchoBloque) / 2;

            if (elementos.isEmpty()) {
                g2.setColor(new Color(254, 237, 199)); // Fondo beige claro de referencia
                RoundRectangle2D rectVacio = new RoundRectangle2D.Float(xCentro, altoPanel - 80, anchoBloque, 45, 16, 16);
                g2.fill(rectVacio);
                g2.setColor(new Color(220, 180, 100));
                g2.setStroke(new BasicStroke(1.5f));
                g2.draw(rectVacio);

                g2.setColor(new Color(40, 40, 40));
                g2.setFont(new Font("Segoe UI", Font.BOLD, 13));
                FontMetrics fm = g2.getFontMetrics();
                String texto = "Pila Vacía";
                g2.drawString(texto, xCentro + (anchoBloque - fm.stringWidth(texto)) / 2, altoPanel - 53);
                g2.dispose();
                return;
            }

            int yActual = altoPanel - 50;

            // Dibujar los elementos de abajo hacia arriba (Bottom-Up)
            for (int i = 0; i < elementos.size(); i++) {
                String elem = elementos.get(i);
                boolean esTope = (i == elementos.size() - 1);

                // Colores acordes a la referencia del PDF
                Color colorFondo;
                Color colorBorde;
                Color colorTexto = new Color(32, 33, 36);

                if (elem.equals("(") || elem.equals(")") || elem.equals("+") || elem.equals("-") || elem.equals("*") || elem.equals("/")) {
                    colorFondo = new Color(255, 204, 204); // Rojo/Rosa pastel para operadores
                    colorBorde = new Color(230, 140, 140);
                } else if (Character.isUpperCase(elem.charAt(0)) || elem.contains("Decl") || elem.contains("stmt") || elem.contains("program")) {
                    colorFondo = new Color(210, 235, 255); // Azul/Cyan pastel para No Terminales (E, T, F, ...)
                    colorBorde = new Color(140, 180, 230);
                } else {
                    colorFondo = new Color(254, 237, 199); // Amarillo pastel para terminales
                    colorBorde = new Color(220, 190, 120);
                }

                if (esTope) {
                    colorBorde = new Color(255, 180, 0); // Borde dorado destacado en el tope
                }

                RoundRectangle2D rect = new RoundRectangle2D.Float(xCentro, yActual - altoBloque, anchoBloque, altoBloque, 12, 12);
                g2.setColor(colorFondo);
                g2.fill(rect);

                g2.setColor(colorBorde);
                g2.setStroke(new BasicStroke(esTope ? 2.5f : 1.2f));
                g2.draw(rect);

                // Texto del bloque
                g2.setColor(colorTexto);
                g2.setFont(new Font("Consolas", Font.BOLD, 14));
                FontMetrics fm = g2.getFontMetrics();
                String textoRecortado = elem;
                if (fm.stringWidth(textoRecortado) > anchoBloque - 16) {
                    while (textoRecortado.length() > 3 && fm.stringWidth(textoRecortado + "...") > anchoBloque - 16) {
                        textoRecortado = textoRecortado.substring(0, textoRecortado.length() - 1);
                    }
                    textoRecortado += "...";
                }
                g2.drawString(textoRecortado, xCentro + (anchoBloque - fm.stringWidth(textoRecortado)) / 2, yActual - altoBloque + 23);

                // Indicador de "TOPE" en el elemento superior
                if (esTope) {
                    g2.setColor(new Color(255, 180, 0));
                    g2.setFont(new Font("Segoe UI", Font.BOLD, 10));
                    g2.drawString("[TOPE]", xCentro + anchoBloque + 8, yActual - altoBloque + 22);
                }

                yActual -= (altoBloque + 8);
            }

            g2.dispose();
        }
    }
}
