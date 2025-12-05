package src.view;

import javax.swing.*;
import java.awt.*;

public class VehiculoVista extends JFrame {

    public JComboBox<String> comboTipo;
    public JTextField txtMarca, txtModelo, txtAnio, txtDescripcion, txtColor;
    public JButton btnAgregar, btnEditar, btnEliminar, btnGuardar;
    public DefaultListModel listaModel;
    public JList listaVehiculos;
    public JTextArea txtDetalles;

    public VehiculoVista() {
        setTitle("Vehículos - P.O.O.");
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelIzq = new JPanel();
        panelIzq.setLayout(new GridBagLayout());
        panelIzq.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;

        comboTipo = new JComboBox<>(new String[]{"Carro", "Moto", "Camion", "Bicicleta"});
        txtMarca = new JTextField();
        txtModelo = new JTextField();
        txtAnio = new JTextField();
        txtDescripcion = new JTextField();
        txtColor = new JTextField();

        int y = 0;
        gbc.gridy = y++; panelIzq.add(new JLabel("Tipo de Vehículo:"), gbc); gbc.gridy = y++; panelIzq.add(comboTipo, gbc);
        gbc.gridy = y++; panelIzq.add(new JLabel("Marca:"), gbc); gbc.gridy = y++; panelIzq.add(txtMarca, gbc);
        gbc.gridy = y++; panelIzq.add(new JLabel("Modelo:"), gbc); gbc.gridy = y++; panelIzq.add(txtModelo, gbc);
        gbc.gridy = y++; panelIzq.add(new JLabel("Año:"), gbc); gbc.gridy = y++; panelIzq.add(txtAnio, gbc);
        gbc.gridy = y++; panelIzq.add(new JLabel("Descripción:"), gbc); gbc.gridy = y++; panelIzq.add(txtDescripcion, gbc);
        gbc.gridy = y++; panelIzq.add(new JLabel("Color:"), gbc); gbc.gridy = y++; panelIzq.add(txtColor, gbc);

        btnAgregar = new JButton("Crear");
        btnEditar = new JButton("Editar");
        btnEliminar = new JButton("Eliminar");
        btnGuardar = new JButton("Guardar");

        JPanel panelBotones = new JPanel(new GridLayout(2,2,5,5));
        panelBotones.add(btnAgregar); panelBotones.add(btnEditar);
        panelBotones.add(btnEliminar); panelBotones.add(btnGuardar);
        gbc.gridy = y++; panelIzq.add(panelBotones, gbc);

        txtDetalles = new JTextArea();
        txtDetalles.setEditable(false);
        txtDetalles.setFont(new Font("Monospaced", Font.PLAIN, 14));
        txtDetalles.setLineWrap(true);
        txtDetalles.setWrapStyleWord(true);
        JScrollPane scrollDetalles = new JScrollPane(txtDetalles);

        listaModel = new DefaultListModel<>();
        listaVehiculos = new JList(listaModel);
        listaVehiculos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollLista = new JScrollPane(listaVehiculos);
        scrollLista.setMinimumSize(new Dimension(200, 0));
        scrollLista.setPreferredSize(new Dimension(200, 0));

        JSplitPane centroDerecha = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollDetalles, scrollLista);
        centroDerecha.setResizeWeight(1.0);
        centroDerecha.setDividerSize(5);

        JSplitPane principal = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelIzq, centroDerecha);
        principal.setResizeWeight(0.0);
        principal.setDividerLocation(250);
        principal.setDividerSize(5);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(principal, BorderLayout.CENTER);

        setVisible(true);
    }
}
