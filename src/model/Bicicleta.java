package src.model;

public class Bicicleta extends Vehiculo {
    public Bicicleta(String marca, String modelo, int anio, String descripcion, String color) {
        super(marca, modelo, anio, descripcion, color);
    }
    public String getTipo() { return "Bicicleta"; }
}
