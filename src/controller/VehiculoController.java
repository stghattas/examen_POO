package src.controller;

import src.model.*;
import src.view.VehiculoVista;

import javax.swing.*;
import java.io.*;
import java.util.*;

public class VehiculoController {

    private final VehiculoVista view;
    private ArrayList<Vehiculo> listaVehiculos;

    public VehiculoController(VehiculoVista view) {
        this.view = view;
        listaVehiculos = new ArrayList<>();
        cargarDesdeArchivo();
        actualizarLista();

        initController();
    }

    private void initController() {
        view.btnAgregar.addActionListener(e -> crearVehiculo());
        view.btnEditar.addActionListener(e -> editarVehiculo());
        view.btnEliminar.addActionListener(e -> eliminarVehiculo());
        view.btnGuardar.addActionListener(e -> guardarEnArchivo());

        view.listaVehiculos.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) cargarDatosEnFormulario();
        });
    }

    private void crearVehiculo() {
        try {
            String tipo = (String) view.comboTipo.getSelectedItem();
            String marca = view.txtMarca.getText();
            String modelo = view.txtModelo.getText();
            int anio = Integer.parseInt(view.txtAnio.getText());
            String descripcion = view.txtDescripcion.getText();
            String color = view.txtColor.getText();

            Vehiculo v = switch (tipo) {
                case "Carro" -> new Carro(marca, modelo, anio, descripcion, color);
                case "Moto" -> new Moto(marca, modelo, anio, descripcion, color);
                case "Camion" -> new Camion(marca, modelo, anio, descripcion, color);
                default -> new Bicicleta(marca, modelo, anio, descripcion, color);
            };

            listaVehiculos.add(v);
            actualizarLista();
            limpiarFormulario();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, "Error: revise los datos ingresados.");
        }
    }

    private void editarVehiculo() {
        int index = view.listaVehiculos.getSelectedIndex();
        if (index < 0) return;

        Vehiculo v = listaVehiculos.get(index);
        v.setMarca(view.txtMarca.getText());
        v.setModelo(view.txtModelo.getText());
        v.setAnio(Integer.parseInt(view.txtAnio.getText()));
        v.setDescripcion(view.txtDescripcion.getText());
        v.setColor(view.txtColor.getText());

        actualizarLista();
        view.txtDetalles.setText(v.getDetalles());
    }

    private void eliminarVehiculo() {
        int index = view.listaVehiculos.getSelectedIndex();
        if (index < 0) return;

        listaVehiculos.remove(index);
        actualizarLista();
        limpiarFormulario();
        view.txtDetalles.setText("");
    }

    private void cargarDatosEnFormulario() {
        int index = view.listaVehiculos.getSelectedIndex();
        if (index < 0) return;

        Vehiculo v = listaVehiculos.get(index);
        view.txtMarca.setText(v.getMarca());
        view.txtModelo.setText(v.getModelo());
        view.txtAnio.setText(String.valueOf(v.getAnio()));
        view.txtDescripcion.setText(v.getDescripcion());
        view.txtColor.setText(v.getColor());
        view.comboTipo.setSelectedItem(v.getTipo());

        view.txtDetalles.setText(v.getDetalles());
    }

    private void limpiarFormulario() {
        view.txtMarca.setText("");
        view.txtModelo.setText("");
        view.txtAnio.setText("");
        view.txtDescripcion.setText("");
        view.txtColor.setText("");
        view.comboTipo.setSelectedIndex(0);
    }

    private void actualizarLista() {
        DefaultListModel<Vehiculo> model = view.listaModel;
        model.removeAllElements();
        for (Vehiculo v : listaVehiculos) {
            model.addElement(v);
        }
    }

    private void guardarEnArchivo() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/Datos/vehiculos.dat"))) {
            oos.writeObject(listaVehiculos);
            JOptionPane.showMessageDialog(view, "Vehículos guardados correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(view, "Error al guardar.");
        }
    }

    private void cargarDesdeArchivo() {
        File archivo = new File("src/Datos/vehiculos.dat");
        if (!archivo.exists()) return;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            listaVehiculos = (ArrayList<Vehiculo>) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            listaVehiculos = new ArrayList<>();
        }
    }
}
