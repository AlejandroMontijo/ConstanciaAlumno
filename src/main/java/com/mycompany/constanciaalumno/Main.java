package com.mycompany.constanciaalumno;

import com.formdev.flatlaf.FlatLightLaf;
import com.mycompany.constanciaalumno.controlador.ControladorConstancia;
import com.mycompany.constanciaalumno.vista.VentanaConstancia;
import java.awt.Color;
import javax.swing.*;

/**
 * Clase principal que contiene el punto de entrada para la aplicación
 * Constancia de Alumnos.
 * Inicializa el patrón MVC (Modelo-Vista-Controlador).
 * 
 * @author alejandro
 */
public class Main {

    /**
     * Constructor por defecto de la clase Main.
     */
    public Main() {
    }

    /**
     * Método principal de ejecución.
     * Inicia la Interfaz Gráfica (Vista) y su Controlador.
     * 
     * @param args Argumentos de línea de comandos (no se utilizan)
     */
    public static void main(String[] args) {
        // =============== DISEÑO PROFESIONAL =================
        // Usar FlatLaf (Flat Look and Feel) moderno
        try {
            // Configurar propiedades estéticas modernas antes de instanciar la UI
            UIManager.put("Button.arc", 12); // Botones redondeados
            UIManager.put("Component.arc", 12); // Campos de texto redondeados
            UIManager.put("ProgressBar.arc", 12);
            UIManager.put("TabbedPane.showTabSeparators", true);
            UIManager.put("Component.focusWidth", 2); // Ancho del borde al seleccionar
            UIManager.put("ScrollBar.showButtons", false);
            UIManager.put("ScrollBar.width", 12); // Scrollbars delgados tipo Mac/Web

            // Color de acento institucional (Azul ITSON o profesional)
            UIManager.put("Component.accentColor", new Color(0, 102, 204));

            // Instalar el tema Claro Moderno
            FlatLightLaf.setup();

        } catch (Exception ex) {
            System.err.println("No se pudo cargar el diseño profesional. Usando el de por defecto.");
            ex.printStackTrace();
        }

        // =============== INICIALIZACIÓN MVC =================
        SwingUtilities.invokeLater(() -> {
            VentanaConstancia vista = new VentanaConstancia();
            ControladorConstancia controlador = new ControladorConstancia(vista);
            vista.setVisible(true);
        });
    }
}
