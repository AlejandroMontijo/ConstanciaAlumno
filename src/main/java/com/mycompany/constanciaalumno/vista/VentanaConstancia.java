package com.mycompany.constanciaalumno.vista;

import java.awt.*;
import javax.swing.*;

/**
 * Clase que representa la Interfaz Gráfica de Usuario (Vista) para el módulo de
 * constancias.
 * Define la estructura visual y expone sus componentes al Controlador.
 * 
 * @author alejandro
 */
public class VentanaConstancia extends JFrame {

    private DefaultListModel<String> modeloLista;

    /**
     * Construye una nueva ventana, inicializa el modelo de la lista
     * y carga los componentes gráficos generados por el diseñador de NetBeans.
     */
    public VentanaConstancia() {
        modeloLista = new DefaultListModel<>();
        initComponents();
    }

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
