package src;

import src.controller.VehiculoController;
import src.view.VehiculoVista;

public class Main {
    public static void main(String[] args) {
        VehiculoVista view = new VehiculoVista();
        new VehiculoController(view);
    }
}
