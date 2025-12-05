package src.model;

public class Camion extends Vehiculo {
    public Camion(String marca, String modelo, int anio, String descripcion, String color) {
        super(marca, modelo, anio, descripcion, color);
    }
    public String getTipo() { return "Camion"; }
}
