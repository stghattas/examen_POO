package src.model;

public class Carro extends Vehiculo {
    public Carro(String marca, String modelo, int anio, String descripcion, String color) {
        super(marca, modelo, anio, descripcion, color);
    }
    public String getTipo() { return "Carro"; }
}
