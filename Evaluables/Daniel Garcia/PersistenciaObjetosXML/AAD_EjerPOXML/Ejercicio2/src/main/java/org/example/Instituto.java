package org.example;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XStreamAlias("instituto")
public class Instituto implements Serializable {
    private String nombre;
    @XStreamImplicit(itemFieldName = "persona")
    private List<Persona> personas;

    //Constructor vacío
    public Instituto() {
        this.personas = new ArrayList<>();
    }

    //Constructor con parámetros
    public Instituto(String nombre) {
        this.nombre = nombre;
        this.personas = new ArrayList<>();
    }

    //Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    //Método para imprimir
    @Override
    public String toString() {
        return "Instituto{" +
                "nombre='" + nombre + '\'' +
                ", personas=" + personas +
                '}';
    }
}
