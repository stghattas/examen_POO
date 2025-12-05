package src.model;

public class Moto extends Vehiculo {
    public Moto(String marca, String modelo, int anio, String descripcion, String color) {
        super(marca, modelo, anio, descripcion, color);
    }
    public String getTipo() { return "Moto"; }
}
