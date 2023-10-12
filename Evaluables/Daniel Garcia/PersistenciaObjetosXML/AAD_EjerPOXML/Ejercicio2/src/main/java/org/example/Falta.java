package org.example;

import java.io.Serializable;

public class Falta implements Serializable {
    private String fecha;
    private String razon;

    //Constructor vacío
    public Falta() {
    }

    //Constructor con parámetros
    public Falta(String fecha, String razon) {
        this.fecha = fecha;
        this.razon = razon;
    }

    //Getters y setters
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }

    //Método para imprimir
    @Override
    public String toString() {
        return "Falta{" +
                "fecha='" + fecha + '\'' +
                ", razon='" + razon + '\'' +
                '}';
    }
}
