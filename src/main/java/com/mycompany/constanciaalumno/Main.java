package com.mycompany.constanciaalumno;

import com.mycompany.constanciaalumno.controlador.ControladorConstancia;
import com.mycompany.constanciaalumno.vista.VentanaConstancia;
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
        // look and feel del sistema
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // ejecutar en el hilo de swing
        SwingUtilities.invokeLater(() -> {
            VentanaConstancia vista = new VentanaConstancia();
            ControladorConstancia controlador = new ControladorConstancia(vista);
            vista.setVisible(true);
        });
    }
}
