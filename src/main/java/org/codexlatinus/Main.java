package org.codexlatinus;

import com.formdev.flatlaf.FlatDarkLaf;
import org.codexlatinus.ui.VentanaPrincipal;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                FlatDarkLaf.setup();
                UIManager.put("Button.arc", 8);
                UIManager.put("Component.arc", 8);
                UIManager.put("TextComponent.arc", 6);
                UIManager.put("ScrollBar.showButtons", true);
            } catch (Exception e) {
                System.err.println("No se pudo inicializar FlatLaf : " + e.getMessage());
            }

            VentanaPrincipal ventana = new VentanaPrincipal();
            ventana.setVisible(true);
        });
    }
}
