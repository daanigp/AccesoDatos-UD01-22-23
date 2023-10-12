package org.example.Ejercicio1;

import java.io.Serializable;

public class Lugar implements Serializable {

    private String ciudad;
    private String pais;

    //Constructor vacío
    public Lugar() {
    }

    //Constructor con parámetros
    public Lugar(String ciudad, String pais) {
        this.ciudad = ciudad;
        this.pais = pais;
    }

    //Getters y setters
    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    ////Método para imprimir por pantalla
    @Override
    public String toString() {
        return "Lugar{" +
                "ciudad='" + ciudad + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }
}
