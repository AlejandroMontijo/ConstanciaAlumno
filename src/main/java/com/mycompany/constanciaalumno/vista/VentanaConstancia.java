package com.mycompany.constanciaalumno.vista;

import java.awt.*;
import javax.swing.*;

/**
 * @author alejandro
 */
public class VentanaConstancia extends JFrame {

    private JTextField txtId;
    private JList<String> listaAlumnos;
    private DefaultListModel<String> modeloLista;
    private JTextArea txtInfo;
    private JButton btnGenerar;
    private JScrollPane scrollLista;
    private JScrollPane scrollInfo;

    public VentanaConstancia() {
        modeloLista = new DefaultListModel<>();
        initComponents();
    }

    private void initComponents() {
        setTitle("Constancia de Alumno Inscrito");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(850, 550);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // panel izquierdo - busqueda por id
        JPanel panelIzquierdo = new JPanel();
        panelIzquierdo.setLayout(new BorderLayout(5, 5));
        panelIzquierdo.setBorder(BorderFactory.createTitledBorder("Buscar Alumno"));
        panelIzquierdo.setPreferredSize(new Dimension(250, 0));

        JLabel lblId = new JLabel("ID del Alumno:");
        txtId = new JTextField();
        txtId.setFont(new Font("Monospaced", Font.PLAIN, 14));

        JPanel panelBusqueda = new JPanel(new BorderLayout(5, 5));
        panelBusqueda.add(lblId, BorderLayout.NORTH);
        panelBusqueda.add(txtId, BorderLayout.CENTER);

        panelIzquierdo.add(panelBusqueda, BorderLayout.NORTH);

        // panel derecho - resultados y constancia
        JPanel panelDerecho = new JPanel();
        panelDerecho.setLayout(new BorderLayout(5, 5));
        panelDerecho.setBorder(BorderFactory.createTitledBorder("Resultados"));

        // lista de alumnos
        listaAlumnos = new JList<>(modeloLista);
        listaAlumnos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaAlumnos.setFont(new Font("SansSerif", Font.PLAIN, 13));
        scrollLista = new JScrollPane(listaAlumnos);
        scrollLista.setPreferredSize(new Dimension(0, 150));
        scrollLista.setBorder(BorderFactory.createTitledBorder("Alumnos encontrados"));

        // area de informacion
        txtInfo = new JTextArea();
        txtInfo.setEditable(false);
        txtInfo.setFont(new Font("Monospaced", Font.PLAIN, 12));
        txtInfo.setLineWrap(true);
        txtInfo.setWrapStyleWord(true);
        scrollInfo = new JScrollPane(txtInfo);
        scrollInfo.setBorder(BorderFactory.createTitledBorder("Información del Alumno"));

        // boton generar
        btnGenerar = new JButton("Generar Constancia");
        btnGenerar.setEnabled(false);
        btnGenerar.setFont(new Font("SansSerif", Font.BOLD, 13));

        JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelBoton.add(btnGenerar);

        panelDerecho.add(scrollLista, BorderLayout.NORTH);
        panelDerecho.add(scrollInfo, BorderLayout.CENTER);
        panelDerecho.add(panelBoton, BorderLayout.SOUTH);

        add(panelIzquierdo, BorderLayout.WEST);
        add(panelDerecho, BorderLayout.CENTER);

        ((JPanel) getContentPane()).setBorder(
                BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }

    // getters para que el controlador acceda a los componentes
    public JTextField getTxtId() {
        return txtId;
    }

    public JList<String> getListaAlumnos() {
        return listaAlumnos;
    }

    public DefaultListModel<String> getModeloLista() {
        return modeloLista;
    }

    public JTextArea getTxtInfo() {
        return txtInfo;
    }

    public JButton getBtnGenerar() {
        return btnGenerar;
    }

    public JScrollPane getScrollInfo() {
        return scrollInfo;
    }
}
