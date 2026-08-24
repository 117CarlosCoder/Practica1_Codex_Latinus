package org.codexlatinus.visitor;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

public class RenderizadorGraphviz {

    private static String rutaDotEjecutable = null;

    private static String encontrarEjecutableDot() {
        if (rutaDotEjecutable != null) return rutaDotEjecutable;

        String[] posiblesRutas = {
                "C:\\Program Files (x86)\\Graphviz\\bin\\dot.exe",
                "C:\\Program Files\\Graphviz\\bin\\dot.exe",
                "dot"
        };

        for (String ruta : posiblesRutas) {
            if (!ruta.equals("dot")) {
                File f = new File(ruta);
                if (f.exists() && f.canExecute()) {
                    rutaDotEjecutable = ruta;
                    return rutaDotEjecutable;
                }
            }
        }
        rutaDotEjecutable = "dot";
        return rutaDotEjecutable;
    }

    public static BufferedImage renderizarDotAImagen(String codigoDot) {
        if (codigoDot == null || codigoDot.isBlank()) {
            return null;
        }

        try {
            String dotCmd = encontrarEjecutableDot();
            ProcessBuilder pb = new ProcessBuilder(dotCmd, "-Tpng");
            pb.redirectError(ProcessBuilder.Redirect.DISCARD);
            Process proceso = pb.start();

            try (OutputStream os = proceso.getOutputStream()) {
                os.write(codigoDot.getBytes(StandardCharsets.UTF_8));
                os.flush();
            }

            byte[] bytesImagen;
            try (InputStream is = proceso.getInputStream()) {
                bytesImagen = is.readAllBytes();
            }

            boolean terminado = proceso.waitFor(2500, TimeUnit.MILLISECONDS);
            if (!terminado) {
                proceso.destroyForcibly();
                return null;
            }

            if (proceso.exitValue() == 0 && bytesImagen.length > 0) {
                return ImageIO.read(new ByteArrayInputStream(bytesImagen));
            }
        } catch (Exception e) {
            System.err.println("No se pudo renderizar la imagen con Graphviz (dot): " + e.getMessage());
        }
        return null;
    }

    public static ImageIcon renderizarDotAIcono(String codigoDot) {
        BufferedImage img = renderizarDotAImagen(codigoDot);
        return img != null ? new ImageIcon(img) : null;
    }
}
