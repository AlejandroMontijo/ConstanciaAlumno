package com.mycompany.constanciaalumno;

import com.mycompany.constanciaalumno.controlador.ControladorConstancia;
import com.mycompany.constanciaalumno.vista.VentanaConstancia;
import javax.swing.*;

/**
 * @author alejandro
 */
public class Main {

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
