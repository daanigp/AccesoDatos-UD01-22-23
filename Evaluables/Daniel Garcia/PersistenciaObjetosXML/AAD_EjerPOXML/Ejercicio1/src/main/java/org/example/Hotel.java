package org.example;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;

@XStreamAlias("Hotel")
public class Hotel implements Serializable {

    private static final long serialVersionUID = 439729502623497460L;
    private String nombre;
    private String direccion;
    private double precio;

    //Constructor vacío
    public Hotel() {
    }

    //Constructor con parámetros
    public Hotel(String nombre, String direccion, double precio) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.precio = precio;
    }

    //Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    //Método para imprimir por pantalla
    @Override
    public String toString() {
        return "Hotel{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", precio=" + precio +
                '}';
    }
}
