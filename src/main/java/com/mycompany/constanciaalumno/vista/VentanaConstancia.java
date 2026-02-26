package com.mycompany.constanciaalumno.vista;

import com.mycompany.constanciaalumno.modelo.Alumno;
import com.mycompany.constanciaalumno.modelo.Materia;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.swing.*;

/**
 * Clase que representa la Interfaz Gráfica de Usuario (Vista) para el módulo de
 * constancias.
 * Define la estructura visual y expone sus componentes al Controlador.
 * Implementa el Patrón Observer (IAlumnoObserver) para reaccionar a cambios del
 * Modelo
 * adhiriéndose a los principios GRASP de Bajo Acoplamiento.
 * 
 * @author alejandro
 */
public class VentanaConstancia extends JFrame implements IAlumnoObserver {

    private DefaultListModel<String> modeloLista;

    /**
     * Construye una nueva ventana, inicializa el modelo de la lista
     * y carga los componentes gráficos generados por el diseñador de NetBeans.
     */
    public VentanaConstancia() {
        modeloLista = new DefaultListModel<>();
        initComponents();

        // Mejoras visuales (solo funcionan si FlatLaf está activo)
        txtId.putClientProperty("JTextField.placeholderText", "Ej. 123456...");
        txtId.putClientProperty("JTextField.showClearButton", true);
        listaAlumnos.putClientProperty("JList.showItemSeparators", true);
        scrollInfo.putClientProperty("JScrollPane.smoothScrolling", true);
        scrollLista.putClientProperty("JScrollPane.smoothScrolling", true);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelIzquierdo = new javax.swing.JPanel();
        panelBusqueda = new javax.swing.JPanel();
        lblId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        panelDerecho = new javax.swing.JPanel();
        scrollLista = new javax.swing.JScrollPane();
        listaAlumnos = new javax.swing.JList<>();
        scrollInfo = new javax.swing.JScrollPane();
        txtInfo = new javax.swing.JTextArea();
        panelBoton = new javax.swing.JPanel();
        btnGenerar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Constancia de Alumno Inscrito");
        setPreferredSize(new java.awt.Dimension(850, 550));

        panelIzquierdo.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar Alumno"));
        panelIzquierdo.setPreferredSize(new java.awt.Dimension(250, 429));
        panelIzquierdo.setLayout(new java.awt.BorderLayout());

        panelBusqueda.setLayout(new java.awt.BorderLayout());

        lblId.setText("ID del Alumno:");
        panelBusqueda.add(lblId, java.awt.BorderLayout.NORTH);

        txtId.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        panelBusqueda.add(txtId, java.awt.BorderLayout.CENTER);

        panelIzquierdo.add(panelBusqueda, java.awt.BorderLayout.NORTH);

        getContentPane().add(panelIzquierdo, java.awt.BorderLayout.WEST);

        panelDerecho.setBorder(javax.swing.BorderFactory.createTitledBorder("Resultados"));
        panelDerecho.setLayout(new java.awt.BorderLayout());

        scrollLista.setBorder(javax.swing.BorderFactory.createTitledBorder("Alumnos encontrados"));
        scrollLista.setPreferredSize(new java.awt.Dimension(590, 150));

        listaAlumnos.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        listaAlumnos.setModel(modeloLista);
        listaAlumnos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        scrollLista.setViewportView(listaAlumnos);

        panelDerecho.add(scrollLista, java.awt.BorderLayout.NORTH);

        scrollInfo.setBorder(javax.swing.BorderFactory.createTitledBorder("Información del Alumno"));

        txtInfo.setEditable(false);
        txtInfo.setColumns(20);
        txtInfo.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        txtInfo.setLineWrap(true);
        txtInfo.setRows(5);
        txtInfo.setWrapStyleWord(true);
        scrollInfo.setViewportView(txtInfo);

        panelDerecho.add(scrollInfo, java.awt.BorderLayout.CENTER);

        panelBoton.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        btnGenerar.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        btnGenerar.setText("Generar Constancia");
        btnGenerar.setEnabled(false);
        panelBoton.add(btnGenerar);

        panelDerecho.add(panelBoton, java.awt.BorderLayout.SOUTH);

        getContentPane().add(panelDerecho, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // ==========================================
    // MÉTODOS DE LA INTERFAZ OBSERVER (Reacción pasiva)
    // ==========================================

    @Override
    public void actualizar(com.mycompany.constanciaalumno.modelo.IAlumnoObservable observable) {
        // 1. Dibuja la lista usando el estado extraído
        modeloLista.clear();
        for (Alumno a : observable.getAlumnosFiltrados()) {
            modeloLista.addElement(a.toString());
        }

        // 2. Si no hubo resultados o hay un mensaje de validación, pintar mensaje
        String mensaje = observable.getMensajeBusqueda();
        if (mensaje != null && !mensaje.isEmpty()) {
            txtInfo.setText(mensaje);
            scrollInfo.setBorder(BorderFactory.createTitledBorder("Información del Alumno"));
            btnGenerar.setEnabled(false);
            return;
        }

        // 3. Pintar detalle del alumno seleccionado si lo hay
        Alumno alumno = observable.getAlumnoSeleccionado();
        if (alumno == null) {
            txtInfo.setText("");
            scrollInfo.setBorder(BorderFactory.createTitledBorder("Información del Alumno"));
            btnGenerar.setEnabled(false);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("═══════════════════════════════════════\n");
            sb.append("       DATOS DEL ALUMNO\n");
            sb.append("═══════════════════════════════════════\n\n");
            sb.append("  ID:           ").append(alumno.getId()).append("\n");
            sb.append("  Nombre:       ").append(alumno.getNombreCompleto()).append("\n");
            sb.append("  Carrera:      ").append(alumno.getCarrera()).append("\n");
            sb.append("  Semestre:     ").append(alumno.getSemestre()).append("\n");
            sb.append("  Materias:     ").append(alumno.getCantidadMaterias()).append("\n");
            sb.append("  Créditos:     ").append(alumno.getTotalCreditos()).append("\n\n");

            sb.append("  MATERIAS INSCRITAS:\n");
            sb.append("  ─────────────────────────────────\n");
            for (Materia m : alumno.getMaterias()) {
                sb.append("  • ").append(m.toString()).append("\n");
            }

            txtInfo.setText(sb.toString());
            txtInfo.setCaretPosition(0);
            scrollInfo.setBorder(BorderFactory.createTitledBorder("Datos de Confirmación"));
            btnGenerar.setEnabled(true);
        }
    }

    /**
     * Pinta en el área de texto el formato visual de una constancia oficial.
     * 
     * @param observable El observable que contiene al alumno seleccionado.
     */
    public void renderizarVistaConstancia(com.mycompany.constanciaalumno.modelo.IAlumnoObservable observable) {
        Alumno alumno = observable.getAlumnoSeleccionado();
        if (alumno == null)
            return;

        scrollInfo.setBorder(BorderFactory.createTitledBorder("Constancia Generada"));

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
        sb.append("     ").append(alumno.getNombreCompleto().toUpperCase()).append("\n\n");
        sb.append("  Con número de ID: ").append(alumno.getId()).append("\n\n");
        sb.append("  Se encuentra actualmente inscrito(a) en el programa\n");
        sb.append("  de ").append(alumno.getCarrera()).append(",\n");
        sb.append("  cursando el semestre ").append(alumno.getSemestre());
        sb.append(", con un total de ").append(alumno.getCantidadMaterias());
        sb.append(" materias\n");
        sb.append("  y ").append(alumno.getTotalCreditos()).append(" créditos inscritos.\n\n");

        sb.append("  MATERIAS INSCRITAS EN EL PERIODO ACTUAL:\n");
        sb.append("  ─────────────────────────────────────────\n");
        for (Materia m : alumno.getMaterias()) {
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

        txtInfo.setText(sb.toString());
        txtInfo.setCaretPosition(0);
    }

    /**
     * Obtiene el campo de texto del ID para agregarle eventos o leer su valor.
     * 
     * @return El componente JTextField del ID.
     */
    public JTextField getTxtId() {
        return txtId;
    }

    /**
     * Obtiene la lista gráfica donde se muestran los alumnos filtrados.
     * 
     * @return El componente JList de la interfaz.
     */
    public JList<String> getListaAlumnos() {
        return listaAlumnos;
    }

    /**
     * Obtiene el modelo de datos vinculado a la lista gráfica.
     * 
     * @return El DefaultListModel que alimenta al JList.
     */
    public DefaultListModel<String> getModeloLista() {
        return modeloLista;
    }

    /**
     * Obtiene el área de texto donde se muestra la constancia generada o la
     * información confirmada.
     * 
     * @return El componente JTextArea de la interfaz.
     */
    public JTextArea getTxtInfo() {
        return txtInfo;
    }

    /**
     * Obtiene el botón principal de generación para asociarle sus ActionListeners
     * en el Controlador.
     * 
     * @return El componente JButton de generación.
     */
    public JButton getBtnGenerar() {
        return btnGenerar;
    }

    /**
     * Obtiene el contenedor desplazable del área de información (generalmente para
     * cambiar el título del borde).
     * 
     * @return El JScrollPane que contiene a txtInfo.
     */
    public JScrollPane getScrollInfo() {
        return scrollInfo;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerar;
    private javax.swing.JLabel lblId;
    private javax.swing.JList<String> listaAlumnos;
    private javax.swing.JPanel panelBoton;
    private javax.swing.JPanel panelBusqueda;
    private javax.swing.JPanel panelDerecho;
    private javax.swing.JPanel panelIzquierdo;
    private javax.swing.JScrollPane scrollInfo;
    private javax.swing.JScrollPane scrollLista;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextArea txtInfo;
    // End of variables declaration//GEN-END:variables
}
