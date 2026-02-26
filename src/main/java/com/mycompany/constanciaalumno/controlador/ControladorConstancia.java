package com.mycompany.constanciaalumno.controlador;

import com.mycompany.constanciaalumno.modelo.Alumno;
import com.mycompany.constanciaalumno.modelo.DatosAlumnos;
import com.mycompany.constanciaalumno.modelo.Materia;
import com.mycompany.constanciaalumno.vista.VentanaConstancia;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import javax.swing.*;
import javax.swing.event.*;

/**
 * Controlador principal del patrón Arquitectónico MVC.
 * Gestiona la interacción entre la Vista (VentanaConstancia) y el Modelo
 * (DatosAlumnos, Alumno, Materia).
 * 
 * @author alejandro
 */
public class ControladorConstancia {

    private VentanaConstancia vista;
    private ArrayList<Alumno> todosLosAlumnos;
    private ArrayList<Alumno> alumnosFiltrados;
    private Alumno alumnoSeleccionado;

    /**
     * Construye y vincula el controlador a una vista específica.
     * Carga los datos iniciales y configura los oyentes de eventos.
     * 
     * @param vista La instancia de VentanaConstancia a gestionar.
     */
    public ControladorConstancia(VentanaConstancia vista) {
        this.vista = vista;
        this.todosLosAlumnos = DatosAlumnos.obtenerAlumnos();
        this.alumnosFiltrados = new ArrayList<>();
        this.alumnoSeleccionado = null;

        configurarEventos();
    }

    private void configurarEventos() {
        // busqueda incremental
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

        // seleccion de alumno
        vista.getListaAlumnos().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting() == false) {
                    int index = vista.getListaAlumnos().getSelectedIndex();
                    if (index >= 0 && index < alumnosFiltrados.size()) {
                        alumnoSeleccionado = alumnosFiltrados.get(index);
                        mostrarDatosAlumno();
                        vista.getBtnGenerar().setEnabled(true);
                    } else {
                        alumnoSeleccionado = null;
                        vista.getBtnGenerar().setEnabled(false);
                    }
                }
            }
        });

        // boton generar constancia
        vista.getBtnGenerar().addActionListener(e -> {
            if (alumnoSeleccionado != null) {
                generarConstancia();
            }
        });
    }

    private void filtrarAlumnos() {
        String texto = vista.getTxtId().getText().trim();
        DefaultListModel<String> modelo = vista.getModeloLista();
        modelo.clear();
        alumnosFiltrados.clear();
        alumnoSeleccionado = null;
        vista.getBtnGenerar().setEnabled(false);
        vista.getTxtInfo().setText("");

        if (texto.isEmpty()) {
            vista.getScrollInfo().setBorder(
                    BorderFactory.createTitledBorder("Información del Alumno"));
            return;
        }

        for (Alumno a : todosLosAlumnos) {
            if (a.getId().contains(texto)) {
                alumnosFiltrados.add(a);
                modelo.addElement(a.toString());
            }
        }

        if (alumnosFiltrados.isEmpty()) {
            vista.getScrollInfo().setBorder(
                    BorderFactory.createTitledBorder("Información del Alumno"));
            vista.getTxtInfo().setText("No se encontraron alumnos con ID que contenga: " + texto);
        }
    }

    private void mostrarDatosAlumno() {
        if (alumnoSeleccionado == null)
            return;

        vista.getScrollInfo().setBorder(
                BorderFactory.createTitledBorder("Datos de Confirmación"));

        StringBuilder sb = new StringBuilder();
        sb.append("═══════════════════════════════════════\n");
        sb.append("       DATOS DEL ALUMNO\n");
        sb.append("═══════════════════════════════════════\n\n");
        sb.append("  ID:           ").append(alumnoSeleccionado.getId()).append("\n");
        sb.append("  Nombre:       ").append(alumnoSeleccionado.getNombreCompleto()).append("\n");
        sb.append("  Carrera:      ").append(alumnoSeleccionado.getCarrera()).append("\n");
        sb.append("  Semestre:     ").append(alumnoSeleccionado.getSemestre()).append("\n");
        sb.append("  Materias:     ").append(alumnoSeleccionado.getCantidadMaterias()).append("\n");
        sb.append("  Créditos:     ").append(alumnoSeleccionado.getTotalCreditos()).append("\n\n");

        sb.append("  MATERIAS INSCRITAS:\n");
        sb.append("  ─────────────────────────────────\n");
        for (Materia m : alumnoSeleccionado.getMaterias()) {
            sb.append("  • ").append(m.toString()).append("\n");
        }

        vista.getTxtInfo().setText(sb.toString());
        vista.getTxtInfo().setCaretPosition(0);
    }

    private void generarConstancia() {
        if (alumnoSeleccionado == null)
            return;

        vista.getScrollInfo().setBorder(
                BorderFactory.createTitledBorder("Constancia Generada"));

        SimpleDateFormat sdf = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy");
        String fecha = sdf.format(new Date());

        Random random = new Random();
        String folio = "CONST-" + (2026) + "-" + String.format("%06d", random.nextInt(999999));

        StringBuilder sb = new StringBuilder();
        sb.append("╔═══════════════════════════════════════════════════╗\n");
        sb.append("║     INSTITUTO TECNOLÓGICO DE SONORA              ║\n");
        sb.append("║     DIRECCIÓN ACADÉMICA                          ║\n");
        sb.append("╚═══════════════════════════════════════════════════╝\n\n");

        sb.append("         CONSTANCIA DE ALUMNO INSCRITO\n");
        sb.append("         ─────────────────────────────\n\n");

        sb.append("  Ciudad Obregón, Sonora, a ").append(fecha).append("\n\n");

        sb.append("  A QUIEN CORRESPONDA:\n\n");

        sb.append("  Por medio de la presente se hace constar que el(la)\n");
        sb.append("  alumno(a):\n\n");

        sb.append("     ").append(alumnoSeleccionado.getNombreCompleto().toUpperCase()).append("\n\n");

        sb.append("  Con número de ID: ").append(alumnoSeleccionado.getId()).append("\n\n");

        sb.append("  Se encuentra actualmente inscrito(a) en el programa\n");
        sb.append("  de ").append(alumnoSeleccionado.getCarrera()).append(",\n");
        sb.append("  cursando el semestre ").append(alumnoSeleccionado.getSemestre());
        sb.append(", con un total de ").append(alumnoSeleccionado.getCantidadMaterias());
        sb.append(" materias\n");
        sb.append("  y ").append(alumnoSeleccionado.getTotalCreditos()).append(" créditos inscritos.\n\n");

        sb.append("  MATERIAS INSCRITAS EN EL PERIODO ACTUAL:\n");
        sb.append("  ─────────────────────────────────────────\n");
        for (Materia m : alumnoSeleccionado.getMaterias()) {
            sb.append("    • ").append(m.getClave()).append("  ")
                    .append(m.getNombre()).append("  (")
                    .append(m.getCreditos()).append(" cr.)\n");
        }

        sb.append("\n  Se extiende la presente para los fines que al\n");
        sb.append("  interesado convengan.\n\n\n");

        sb.append("  ___________________________________________\n");
        sb.append("     Director de Servicios Escolares\n");
        sb.append("     Instituto Tecnológico de Sonora\n\n");

        sb.append("  Folio: ").append(folio).append("\n");

        vista.getTxtInfo().setText(sb.toString());
        vista.getTxtInfo().setCaretPosition(0);
    }
}
