package org.codexlatinus.ui;

import org.codexlatinus.parser.GestorCompilacion;
import org.codexlatinus.parser.ResultadoCompilacion;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Objects;

public class VentanaPrincipal extends JFrame {

    private JTextArea areaEditor;
    private JTextArea areaConsola;
    private JTextArea areaAst;
    private JTextArea areaErrores;
    private JTextArea areaPigLatin;
    private JLabel lblEstado;
    private JProgressBar barraProgreso;
    private JButton btnEjecutar;
    private JButton btnDetener;
    private JComboBox<String> comboEjemplos;
    private JTabbedPane pestanasDerecha;

    private Thread hiloEjecucion;
    private final java.util.concurrent.atomic.AtomicBoolean ejecucionCancelada = new java.util.concurrent.atomic.AtomicBoolean(false);
    private final java.util.concurrent.ConcurrentLinkedQueue<String> colaSalidaConsola = new java.util.concurrent.ConcurrentLinkedQueue<>();
    private javax.swing.Timer timerDrenajeConsola;

    private ResultadoCompilacion ultimoResultado;
    private File archivoActual;
    private static final String CARPETA_EJEMPLOS = "ejemplos";

    public VentanaPrincipal() {
        super("Codex Latinus - Compilador & Intérprete");
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1240, 750);
        setLocationRelativeTo(null);

        timerDrenajeConsola = new javax.swing.Timer(40, e -> drenarConsolaEnEDT());

        JToolBar barraHerramientas = crearBarraHerramientas();
        add(barraHerramientas, BorderLayout.NORTH);

        JSplitPane panelDivision = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        panelDivision.setResizeWeight(0.52);
        panelDivision.setContinuousLayout(true);

        JPanel panelEditor = crearPanelEditor();
        panelDivision.setLeftComponent(panelEditor);

        JPanel panelDerecho = crearPanelDerecho();
        panelDivision.setRightComponent(panelDerecho);

        add(panelDivision, BorderLayout.CENTER);

        JPanel panelEstado = new JPanel(new BorderLayout(10, 0));
        panelEstado.setBorder(BorderFactory.createEmptyBorder(4, 10, 4, 10));
        lblEstado = new JLabel("Listo para ejecutar código Codex Latinus.");
        lblEstado.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        panelEstado.add(lblEstado, BorderLayout.WEST);

        barraProgreso = new JProgressBar();
        barraProgreso.setPreferredSize(new Dimension(150, 14));
        barraProgreso.setVisible(false);
        panelEstado.add(barraProgreso, BorderLayout.EAST);

        add(panelEstado, BorderLayout.SOUTH);

        refrescarListaEjemplos();
        cargarEjemploSeleccionado();
    }

    private JToolBar crearBarraHerramientas() {
        JToolBar toolBar = new JToolBar();
        toolBar.setFloatable(false);
        toolBar.setBorder(BorderFactory.createEmptyBorder(6, 8, 6, 8));

        btnEjecutar = new JButton("Ejecutar");
        btnEjecutar.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnEjecutar.setBackground(new Color(38, 120, 60));
        btnEjecutar.setForeground(Color.WHITE);
        btnEjecutar.setToolTipText("Ejecuta el código en segundo plano");
        btnEjecutar.addActionListener(e -> ejecutarCodigo());

        btnDetener = new JButton("Detener");
        btnDetener.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnDetener.setBackground(new Color(175, 45, 45));
        btnDetener.setForeground(Color.WHITE);
        btnDetener.setEnabled(false);
        btnDetener.setToolTipText("Detiene inmediatamente la ejecución en segundo plano");
        btnDetener.addActionListener(e -> detenerEjecucion());

        JButton btnAbrir = new JButton("Abrir");
        btnAbrir.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        btnAbrir.addActionListener(e -> abrirArchivo());

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        btnGuardar.setToolTipText("Guardar cambios en el archivo actual");
        btnGuardar.addActionListener(e -> guardarArchivo());

        JButton btnGuardarComo = new JButton("Guardar Como");
        btnGuardarComo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        btnGuardarComo.setToolTipText("Elegir ubicación y nombre para guardar el archivo");
        btnGuardarComo.addActionListener(e -> guardarArchivoComo());

        JButton btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        btnLimpiar.addActionListener(e -> {
            areaEditor.setText("");
            areaConsola.setText("");
            areaAst.setText("");
            areaErrores.setText("");
            areaPigLatin.setText("");
            archivoActual = null;
            lblEstado.setText("Editor limpio.");
        });

        JButton btnTraducir = new JButton("Traducir");
        btnTraducir.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        btnTraducir.setToolTipText("Traducir el código actual de Codex Latinus a Pig Latin");
        btnTraducir.addActionListener(e -> traducirCodigo());

        JLabel lblEjemplos = new JLabel(" Suite: ");
        lblEjemplos.setFont(new Font("Segoe UI", Font.BOLD, 12));

        comboEjemplos = new JComboBox<>();
        comboEjemplos.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        comboEjemplos.setPreferredSize(new Dimension(250, 28));
        comboEjemplos.setToolTipText("Selecciona un archivo de la suite unificada de ejemplos y pruebas");
        comboEjemplos.addActionListener(e -> {
            if (comboEjemplos.getSelectedItem() != null) {
                cargarEjemploSeleccionado();
            }
        });

        JButton btnProbarEjemplo = new JButton("Probar");
        btnProbarEjemplo.setToolTipText("Carga el archivo seleccionado y lo ejecuta de inmediato");
        btnProbarEjemplo.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnProbarEjemplo.setBackground(new Color(45, 95, 175));
        btnProbarEjemplo.setForeground(Color.WHITE);
        btnProbarEjemplo.addActionListener(e -> {
            cargarEjemploSeleccionado();
            ejecutarCodigo();
        });

        JButton btnRecargarLista = new JButton("Recargar");
        btnRecargarLista.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        btnRecargarLista.setToolTipText("Recargar la lista de archivos de la carpeta 'ejemplos'");
        btnRecargarLista.addActionListener(e -> refrescarListaEjemplos());

        JButton btnAbrirCarpeta = new JButton("Carpeta");
        btnAbrirCarpeta.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        btnAbrirCarpeta.setToolTipText("Abrir la carpeta 'ejemplos' en el Explorador de Archivos para agregar nuevos archivos");
        btnAbrirCarpeta.addActionListener(e -> abrirCarpetaEjemplos());

        JButton btnExportarPig = new JButton("Exportar .pig");
        btnExportarPig.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        btnExportarPig.setToolTipText("Guardar la traducción actual en un archivo con extensión .pig");
        btnExportarPig.addActionListener(e -> exportarPigLatin());

        JButton btnSimbolos = new JButton("Símbolos");
        btnSimbolos.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        btnSimbolos.addActionListener(e -> verTablaSimbolos());

        JButton btnErrores = new JButton("Errores");
        btnErrores.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        btnErrores.addActionListener(e -> verTablaErrores());

        toolBar.add(btnEjecutar);
        toolBar.add(btnDetener);
        toolBar.addSeparator(new Dimension(8, 0));
        toolBar.add(btnAbrir);
        toolBar.add(btnGuardar);
        toolBar.add(btnGuardarComo);
        toolBar.add(btnLimpiar);
        toolBar.add(btnTraducir);
        toolBar.add(btnExportarPig);
        toolBar.addSeparator(new Dimension(10, 0));
        toolBar.add(lblEjemplos);
        toolBar.add(comboEjemplos);
        toolBar.add(btnProbarEjemplo);
        toolBar.add(btnRecargarLista);
        toolBar.add(btnAbrirCarpeta);
        toolBar.add(Box.createHorizontalGlue());
        toolBar.add(btnSimbolos);
        toolBar.add(btnErrores);

        return toolBar;
    }

    private JPanel crearPanelEditor() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Editor de Código Fuente (.lat)"));

        areaEditor = new JTextArea();
        areaEditor.setFont(new Font("Consolas", Font.PLAIN, 14));
        areaEditor.setTabSize(4);
        areaEditor.setMargin(new Insets(6, 6, 6, 6));

        JScrollPane scrollEditor = new JScrollPane(areaEditor);
        NumeroLinea lineas = new NumeroLinea(areaEditor);
        scrollEditor.setRowHeaderView(lineas);

        panel.add(scrollEditor, BorderLayout.CENTER);
        return panel;
    }

    private JPanel crearPanelDerecho() {
        JPanel panel = new JPanel(new BorderLayout());
        pestanasDerecha = new JTabbedPane();

        // Pestaña 1: Consola
        areaConsola = new JTextArea();
        areaConsola.setEditable(false);
        areaConsola.setBackground(new Color(15, 15, 15));
        areaConsola.setForeground(new Color(74, 246, 38));
        areaConsola.setCaretColor(new Color(74, 246, 38));
        areaConsola.setFont(new Font("Consolas", Font.BOLD, 14));
        areaConsola.setMargin(new Insets(8, 10, 8, 10));
        JScrollPane scrollConsola = new JScrollPane(areaConsola);
        pestanasDerecha.addTab("🖥 Consola de Salida", scrollConsola);

        // Pestaña 2: AST
        areaAst = new JTextArea();
        areaAst.setEditable(false);
        areaAst.setFont(new Font("Consolas", Font.PLAIN, 12));
        areaAst.setMargin(new Insets(6, 8, 6, 8));
        JScrollPane scrollAst = new JScrollPane(areaAst);
        pestanasDerecha.addTab("Árbol Sintáctico (AST)", scrollAst);

        // Pestaña 3: Errores
        areaErrores = new JTextArea();
        areaErrores.setEditable(false);
        areaErrores.setFont(new Font("Consolas", Font.PLAIN, 13));
        areaErrores.setForeground(new Color(255, 90, 90));
        JScrollPane scrollErrores = new JScrollPane(areaErrores);
        pestanasDerecha.addTab("Consola de Errores", scrollErrores);

        // Pestaña 4: Traducción Pig Latin
        areaPigLatin = new JTextArea();
        areaPigLatin.setEditable(false);
        areaPigLatin.setFont(new Font("Consolas", Font.PLAIN, 13));
        areaPigLatin.setBackground(new Color(24, 24, 30));
        areaPigLatin.setForeground(new Color(220, 180, 255));
        areaPigLatin.setCaretColor(new Color(220, 180, 255));
        areaPigLatin.setMargin(new Insets(8, 10, 8, 10));
        JScrollPane scrollPigLatin = new JScrollPane(areaPigLatin);
        pestanasDerecha.addTab("Traducción (Pig Latin)", scrollPigLatin);

        panel.add(pestanasDerecha, BorderLayout.CENTER);
        return panel;
    }

    public void refrescarListaEjemplos() {
        File dir = new File(CARPETA_EJEMPLOS);
        if (!dir.exists() || !dir.isDirectory()) {
            dir.mkdirs();
        }

        File[] archivos = dir.listFiles((d, name) -> name.toLowerCase().endsWith(".lat") || name.toLowerCase().endsWith(".txt"));
        comboEjemplos.removeAllItems();

        if (archivos != null && archivos.length > 0) {
            Arrays.sort(archivos, (f1, f2) -> f1.getName().compareToIgnoreCase(f2.getName()));
            for (File f : archivos) {
                comboEjemplos.addItem(f.getName());
            }
            lblEstado.setText(String.format("📁 Suite cargada: %d archivo(s) disponibles en 'ejemplos/'.", archivos.length));
        } else {
            comboEjemplos.addItem("(Sin archivos en 'ejemplos')");
        }
    }

    private void cargarEjemploSeleccionado() {
        String seleccionado = (String) comboEjemplos.getSelectedItem();
        if (seleccionado == null || seleccionado.startsWith("(")) return;

        File archivo = new File(CARPETA_EJEMPLOS, seleccionado);
        if (archivo.exists() && archivo.isFile()) {
            try {
                String contenido = Files.readString(archivo.toPath());
                areaEditor.setText(contenido);
                areaEditor.setCaretPosition(0);
                archivoActual = archivo;
                lblEstado.setText("📄 Archivo cargado en editor: " + archivo.getName());
            } catch (IOException ex) {
                lblEstado.setText("⚠️ Error al leer archivo: " + ex.getMessage());
            }
        }
    }

    private void abrirCarpetaEjemplos() {
        File dir = new File(CARPETA_EJEMPLOS);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(dir);
            } else {
                JOptionPane.showMessageDialog(this, "Ruta de la carpeta: " + dir.getAbsolutePath(), "Carpeta de Ejemplos", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "No se pudo abrir el explorador: " + ex.getMessage(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void drenarConsolaEnEDT() {
        if (colaSalidaConsola.isEmpty()) return;

        StringBuilder sb = new StringBuilder();
        int lineasDrenadas = 0;
        String linea;
        while ((linea = colaSalidaConsola.poll()) != null && lineasDrenadas < 500) {
            sb.append(linea).append("\n");
            lineasDrenadas++;
        }

        if (sb.length() > 0) {
            areaConsola.append(sb.toString());
            areaConsola.setCaretPosition(areaConsola.getDocument().getLength());
        }
    }

    private void detenerEjecucion() {
        ejecucionCancelada.set(true);
        if (hiloEjecucion != null && hiloEjecucion.isAlive()) {
            hiloEjecucion.interrupt();
        }
        if (timerDrenajeConsola != null) {
            timerDrenajeConsola.stop();
        }
        drenarConsolaEnEDT();

        btnDetener.setEnabled(false);
        btnEjecutar.setEnabled(true);
        barraProgreso.setIndeterminate(false);
        barraProgreso.setVisible(false);
        lblEstado.setText("🛑 Ejecución cancelada por el usuario.");
        areaConsola.append("\n[Ejecución interrumpida de inmediato por el usuario]\n");
        areaConsola.setCaretPosition(areaConsola.getDocument().getLength());
    }

    private void ejecutarCodigo() {
        String codigo = areaEditor.getText();
        if (codigo.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El editor está vacío. Ingresa código para ejecutar.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        areaConsola.setText("");
        areaAst.setText("");
        areaErrores.setText("");
        colaSalidaConsola.clear();
        pestanasDerecha.setSelectedIndex(0);

        ejecucionCancelada.set(false);
        btnEjecutar.setEnabled(false);
        btnDetener.setEnabled(true);
        barraProgreso.setVisible(true);
        barraProgreso.setIndeterminate(true);
        lblEstado.setText("Ejecutando en tiempo real...");

        timerDrenajeConsola.start();

        hiloEjecucion = new Thread(() -> {
            long tInicio = System.currentTimeMillis();
            ResultadoCompilacion resultado = GestorCompilacion.ejecutar(
                    codigo,
                    null,
                    linea -> {
                        if (!ejecucionCancelada.get()) {
                            colaSalidaConsola.offer(linea);
                        }
                    },
                    ejecucionCancelada::get
            );
            long duracionMs = System.currentTimeMillis() - tInicio;

            SwingUtilities.invokeLater(() -> finalizarEjecucionEnEDT(resultado, duracionMs));
        }, "Hilo-Compilacion-Latinus");

        hiloEjecucion.start();
    }

    private void finalizarEjecucionEnEDT(ResultadoCompilacion resultado, long duracionMs) {
        if (timerDrenajeConsola != null) {
            timerDrenajeConsola.stop();
        }

        btnEjecutar.setEnabled(true);
        btnDetener.setEnabled(false);
        barraProgreso.setIndeterminate(false);
        barraProgreso.setVisible(false);

        if (ejecucionCancelada.get()) {
            lblEstado.setText("🛑 Ejecución detenida.");
            return;
        }

        this.ultimoResultado = resultado;

        // Asignar el 100% de la salida completa y consistente del resultado
        areaConsola.setText(resultado.getSalidaConsola());
        areaConsola.setCaretPosition(areaConsola.getDocument().getLength());

        areaAst.setText(resultado.getRepresentacionAst());
        areaErrores.setText(resultado.getErroresFormateados());
        areaPigLatin.setText(resultado.getCodigoPigLatin());

        if (resultado.esExitoso()) {
            pestanasDerecha.setSelectedIndex(0); // Consola
            lblEstado.setText(String.format("✅ Ejecución finalizada en %.2f s. Símbolos generados: %d",
                    duracionMs / 1000.0, resultado.getListaSimbolos().size()));
        } else {
            pestanasDerecha.setSelectedIndex(2); // Errores
            lblEstado.setText(String.format("⚠️ Se encontraron %d errores (tiempo: %.2f s).",
                    resultado.getListaErrores().size(), duracionMs / 1000.0));
        }
    }

    private void traducirCodigo() {
        String codigo = areaEditor.getText();
        if (codigo.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El editor está vacío. Ingresa código para traducir.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        String traduccion = GestorCompilacion.traducirAPigLatin(codigo);
        areaPigLatin.setText(traduccion);
        pestanasDerecha.setSelectedIndex(3); // Pestaña Traducción (Pig Latin)
        lblEstado.setText("Traducción a Pig Latin generada con éxito.");
    }

    private void verTablaSimbolos() {
        if (ultimoResultado != null) {
            DialogoTabla.mostrarTablaSimbolos(this, ultimoResultado.getListaSimbolos());
        } else {
            JOptionPane.showMessageDialog(this, "Primero ejecuta el código para generar la tabla de símbolos.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void verTablaErrores() {
        if (ultimoResultado != null) {
            DialogoTabla.mostrarTablaErrores(this, ultimoResultado.getListaErrores());
        } else {
            JOptionPane.showMessageDialog(this, "Primero ejecuta el código para analizar posibles errores.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void exportarPigLatin() {
        String traduccion = areaPigLatin.getText();
        if (traduccion == null || traduccion.trim().isEmpty()) {
            traducirCodigo();
            traduccion = areaPigLatin.getText();
        }
        if (traduccion == null || traduccion.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay código traducido para exportar.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        JFileChooser chooser = new JFileChooser(new File(CARPETA_EJEMPLOS));
        chooser.setDialogTitle("Exportar Traducción Pig Latin (.pig)");
        chooser.setFileFilter(new FileNameExtensionFilter("Archivos Pig Latin (*.pig)", "pig"));
        String defaultName = archivoActual != null ? archivoActual.getName().replaceAll("\\.[^.]+$", "") + ".pig" : "traduccion.pig";
        chooser.setSelectedFile(new File(defaultName));

        int res = chooser.showSaveDialog(this);
        if (res == JFileChooser.APPROVE_OPTION) {
            File archivoPig = chooser.getSelectedFile();
            if (!archivoPig.getName().toLowerCase().endsWith(".pig")) {
                archivoPig = new File(archivoPig.getParentFile(), archivoPig.getName() + ".pig");
            }
            try {
                Files.writeString(archivoPig.toPath(), traduccion);
                lblEstado.setText("Traducción exportada exitosamente: " + archivoPig.getName());
                JOptionPane.showMessageDialog(this, "Archivo Pig Latin guardado con éxito:\n" + archivoPig.getAbsolutePath(), "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error al exportar archivo: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void abrirArchivo() {
        JFileChooser chooser = new JFileChooser(new File(CARPETA_EJEMPLOS));
        chooser.setDialogTitle("Abrir Archivo Codex Latinus");
        chooser.setFileFilter(new FileNameExtensionFilter("Archivos Codex Latinus (*.lat, *.txt)", "lat", "txt"));
        int res = chooser.showOpenDialog(this);
        if (res == JFileChooser.APPROVE_OPTION) {
            archivoActual = chooser.getSelectedFile();
            try {
                String contenido = Files.readString(archivoActual.toPath());
                areaEditor.setText(contenido);
                lblEstado.setText("Archivo cargado: " + archivoActual.getName());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error al abrir archivo: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void guardarArchivo() {
        if (archivoActual == null) {
            guardarArchivoComo();
            return;
        }

        try (FileWriter writer = new FileWriter(archivoActual)) {
            writer.write(areaEditor.getText());
            lblEstado.setText("Archivo guardado: " + archivoActual.getName());
            JOptionPane.showMessageDialog(this, "Archivo guardado exitosamente en:\n" + archivoActual.getAbsolutePath(), "Guardado", JOptionPane.INFORMATION_MESSAGE);
            refrescarListaEjemplos();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar archivo: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void guardarArchivoComo() {
        File directorioBase = (archivoActual != null && archivoActual.getParentFile() != null)
                ? archivoActual.getParentFile()
                : new File(CARPETA_EJEMPLOS);

        JFileChooser chooser = new JFileChooser(directorioBase);
        chooser.setDialogTitle("Guardar Archivo Como...");
        chooser.setFileFilter(new FileNameExtensionFilter("Archivos Codex Latinus (*.lat, *.txt)", "lat", "txt"));

        String nombreInicial = archivoActual != null ? archivoActual.getName() : "mi_programa.lat";
        chooser.setSelectedFile(new File(nombreInicial));

        int res = chooser.showSaveDialog(this);
        if (res == JFileChooser.APPROVE_OPTION) {
            File destino = chooser.getSelectedFile();
            if (!destino.getName().toLowerCase().endsWith(".lat") && !destino.getName().toLowerCase().endsWith(".txt")) {
                destino = new File(destino.getAbsolutePath() + ".lat");
            }

            if (destino.exists()) {
                int confirm = JOptionPane.showConfirmDialog(
                        this,
                        "El archivo '" + destino.getName() + "' ya existe en esta ubicación.\n¿Deseas reemplazarlo?",
                        "Confirmar Sobrescritura",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE
                );
                if (confirm != JOptionPane.YES_OPTION) {
                    return;
                }
            }

            try (FileWriter writer = new FileWriter(destino)) {
                writer.write(areaEditor.getText());
                archivoActual = destino;
                lblEstado.setText("Archivo guardado: " + archivoActual.getAbsolutePath());
                JOptionPane.showMessageDialog(this, "Archivo guardado exitosamente en:\n" + destino.getAbsolutePath(), "Guardado", JOptionPane.INFORMATION_MESSAGE);
                refrescarListaEjemplos();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error al guardar archivo: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
