package org.example;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serial;
import java.io.Serializable;

@XStreamAlias("Lugar")
public class Lugar implements Serializable {

    @Serial
    private static final long serialVersionUID = -5031101434865408464L;
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
