package com.mycompany.constanciaalumno.controlador;

import com.mycompany.constanciaalumno.modelo.DatosAlumnos;
import com.mycompany.constanciaalumno.vista.VentanaConstancia;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * Controlador de la aplicación. Orquesta la interacción entre la Vista (GUI)
 * y el Modelo (DatosAlumnos).
 * Ha sido refactorizado para enviar comandos al Modelo (Sujeto), el cual
 * notificará automáticamente a la Vista (Observer).
 * 
 * @author alejandro
 */
public class ControladorConstancia {

    private VentanaConstancia vista;
    private DatosAlumnos modelo;

    /**
     * Construye e inicializa el controlador.
     * 
     * @param vista La ventana principal de la interfaz de usuario.
     */
    public ControladorConstancia(VentanaConstancia vista) {
        this.vista = vista;
        this.modelo = new DatosAlumnos();

        // Registrar la vista como Observador del modelo
        this.modelo.agregarObservador(vista);

        inicializarEventos();

        // Disparar carga inicial vacía
        this.modelo.filtrarAlumnos("");
    }

    /**
     * Configura los ActionListeners y DocumentListeners de los componentes de la
     * vista.
     */
    private void inicializarEventos() {
        // Evento 1: Búsqueda incremental (escribir en el JTextField)
        vista.getTxtId().getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filtrarAlumnos();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filtrarAlumnos();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filtrarAlumnos();
            }
        });

        // Evento 2: Selección de alumno en la lista
        vista.getListaAlumnos().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int index = vista.getListaAlumnos().getSelectedIndex();
                modelo.seleccionarAlumno(index);
            }
        });

        // Evento 3: Botón Generar Constancia
        vista.getBtnGenerar().addActionListener(e -> {
            vista.renderizarVistaConstancia(modelo.getAlumnoSeleccionado());
        });
    }

    /**
     * Envía la orden al modelo para filtrar la lista basándose en el texto actual.
     */
    private void filtrarAlumnos() {
        String textoBusqueda = vista.getTxtId().getText().trim();
        modelo.filtrarAlumnos(textoBusqueda);
    }
}
