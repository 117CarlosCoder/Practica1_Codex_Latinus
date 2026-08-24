package org.codexlatinus.ui;

import org.codexlatinus.model.ErrorCompilador;
import org.codexlatinus.model.Simbolo;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class DialogoTabla extends JDialog {

    public DialogoTabla(Frame propietario, String titulo, String[] columnas, Object[][] datos) {
        super(propietario, titulo, true);
        setSize(780, 480);
        setLocationRelativeTo(propietario);

        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));

        DefaultTableModel modelo = new DefaultTableModel(datos, columnas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JTable tabla = new JTable(modelo);
        tabla.setRowHeight(26);
        tabla.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        tabla.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        tabla.setAutoCreateRowSorter(true);

        DefaultTableCellRenderer renderCentro = new DefaultTableCellRenderer();
        renderCentro.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < tabla.getColumnCount(); i++) {
            if (columnas[i].equalsIgnoreCase("Línea") || columnas[i].equalsIgnoreCase("Columna") || columnas[i].equalsIgnoreCase("Tipo Error")) {
                tabla.getColumnModel().getColumn(i).setCellRenderer(renderCentro);
            }
        }

        JScrollPane scroll = new JScrollPane(tabla);
        panelPrincipal.add(scroll, BorderLayout.CENTER);

        JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel lblTotal = new JLabel("Total de registros: " + datos.length + "  ");
        lblTotal.setFont(new Font("Segoe UI", Font.BOLD, 12));
        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(e -> dispose());
        panelInferior.add(lblTotal);
        panelInferior.add(btnCerrar);

        panelPrincipal.add(panelInferior, BorderLayout.SOUTH);
        setContentPane(panelPrincipal);
    }

    public static void mostrarTablaSimbolos(Frame propietario, List<Simbolo> simbolos) {
        String[] columnas = {
                "ID", "Nombre", "Categoría", "Tipo", "Valor Actual",
                "NumParam", "ListParam", "Dir", "Ámbito", "Línea", "Columna"
        };
        Object[][] datos = new Object[simbolos.size()][columnas.length];

        for (int i = 0; i < simbolos.size(); i++) {
            Simbolo s = simbolos.get(i);
            datos[i][0] = s.getId();
            datos[i][1] = s.getNombre();
            datos[i][2] = s.getCategoria();
            datos[i][3] = s.getTipo();
            datos[i][4] = s.getValorComoTexto();
            datos[i][5] = (s.getCategoria().equalsIgnoreCase("func") || s.getCategoria().equalsIgnoreCase("Función")) ? s.getNumParam() : "-";
            datos[i][6] = s.getListParam();
            datos[i][7] = s.getDir();
            datos[i][8] = s.getEntorno();
            datos[i][9] = s.getLinea();
            datos[i][10] = s.getColumna();
        }

        DialogoTabla dialogo = new DialogoTabla(propietario, "Tabla de Símbolos - Codex Latinus", columnas, datos);
        dialogo.setSize(920, 500);
        dialogo.setLocationRelativeTo(propietario);
        dialogo.setVisible(true);
    }

    public static void mostrarTablaErrores(Frame propietario, List<ErrorCompilador> errores) {
        String[] columnas = {"Tipo Error", "Línea", "Columna", "Descripción del Error"};
        Object[][] datos = new Object[errores.size()][4];

        for (int i = 0; i < errores.size(); i++) {
            ErrorCompilador err = errores.get(i);
            datos[i][0] = err.getTipo().name();
            datos[i][1] = err.getLinea();
            datos[i][2] = err.getColumna();
            datos[i][3] = err.getDescripcion();
        }

        DialogoTabla dialogo = new DialogoTabla(propietario, "Reporte de Errores - Codex Latinus", columnas, datos);
        dialogo.setVisible(true);
    }

    public static void mostrarTablaTipos(Frame propietario, org.codexlatinus.model.TablaTipos tablaTipos) {
        if (tablaTipos == null) {
            tablaTipos = new org.codexlatinus.model.TablaTipos();
        }
        String[] columnas = org.codexlatinus.model.TablaTipos.getColumnas();
        Object[][] datos = tablaTipos.aMatrizDatos();

        DialogoTabla dialogo = new DialogoTabla(propietario, "Tabla de Tipos - Codex Latinus", columnas, datos);
        dialogo.setVisible(true);
    }
}
