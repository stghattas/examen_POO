package src.model;

import java.io.*;

public abstract class Vehiculo implements Serializable {
    private String marca;
    private String modelo;
    private int anio;
    private String descripcion;
    private String color;

    public Vehiculo(String marca, String modelo, int anio, String descripcion, String color) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.descripcion = descripcion;
        this.color = color;
    }

    public abstract String getTipo();

    @Override
    public String toString() {
        return getTipo() + " - " + marca + " " + modelo;
    }

    public String getDetalles() {
        return "El '" + modelo + "' es un " + getTipo() + " de la marca " + marca +  " de color " + color +
               " Fue lanzado al publico en el Año: " + anio + ".\n\n" +
               "Descripcion:\n" + descripcion;
    }

    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public int getAnio() { return anio; }
    public String getDescripcion() { return descripcion; }
    public String getColor() { return color; }

    public void setMarca(String marca) { this.marca = marca; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public void setAnio(int anio) { this.anio = anio; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setColor(String color) { this.color = color; }
}
