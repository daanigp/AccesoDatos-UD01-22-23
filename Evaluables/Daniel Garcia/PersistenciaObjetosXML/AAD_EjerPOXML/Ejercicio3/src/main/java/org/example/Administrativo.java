package org.example;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;

@XStreamAlias("administrativo")
public class Administrativo extends Persona implements Serializable {
    private int tiempoContrato;

    //Constructor vacío
    public Administrativo() {
    }

    public Administrativo(String clase, String dni, String nombre, String apellido1, String apellido2, String fechaNacimiento, double sueldoBruto) {
        super(clase, dni, nombre, apellido1, apellido2, fechaNacimiento, sueldoBruto);
    }

    //Constructor con parámetros
    public Administrativo(String clase, String dni, String nombre, String apellido1, String apellido2, String fechaNacimiento, double sueldoBruto, int tiempoContrato) {
        super(clase, dni, nombre, apellido1, apellido2, fechaNacimiento, sueldoBruto);
        this.tiempoContrato = tiempoContrato;
    }

    //Getters y setters
    public int getTiempoContrato() {
        return tiempoContrato;
    }

    public void setTiempoContrato(int tiempoContrato) {
        this.tiempoContrato = tiempoContrato;
    }

    @Override
    public String toString() {
        return super.toString() +
                " Administrativo{" +
                "tiempoContrato=" + tiempoContrato +
                '}';
    }
}
