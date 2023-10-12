package org.example;

import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Profesor extends Persona implements Serializable {
    private String fechaIncorporacion;
    @XStreamImplicit(itemFieldName = "historial")
    private List<Historial> historiales;
    @XStreamImplicit(itemFieldName = "falta")
    private List<Falta> faltas;

    //Constructor vacío
    public Profesor() {
        this.historiales = new ArrayList<>();
        this.faltas = new ArrayList<>();
    }

    public Profesor(String dni, String nombre, String apellido1, String apellido2, String fechaNacimiento, double sueldoBruto) {
        super(dni, nombre, apellido1, apellido2, fechaNacimiento, sueldoBruto);
        this.historiales = new ArrayList<>();
        this.faltas = new ArrayList<>();
    }

    //Constructor con parámetros
    public Profesor(String dni, String nombre, String apellido1, String apellido2, String fechaNacimiento, double sueldoBruto, String fechaIncorporacion) {
        super(dni, nombre, apellido1, apellido2, fechaNacimiento, sueldoBruto);
        this.fechaIncorporacion = fechaIncorporacion;
        this.historiales = new ArrayList<>();
        this.faltas = new ArrayList<>();
    }

    //Getters y setters
    public String getFechaIncorporacion() {
        return fechaIncorporacion;
    }

    public void setFechaIncorporacion(String fechaIncorporacion) {
        this.fechaIncorporacion = fechaIncorporacion;
    }

    public List<Historial> getHistoriales() {
        return historiales;
    }

    public void setHistoriales(List<Historial> historiales) {
        this.historiales = historiales;
    }

    public List<Falta> getFaltas() {
        return faltas;
    }

    public void setFaltas(List<Falta> faltas) {
        this.faltas = faltas;
    }

    //Método para imprimir
    @Override
    public String toString() {
        return super.toString() +
                " Profesor{" +
                "fechaIncorporacion='" + fechaIncorporacion + '\'' +
                ", historiales=" + historiales +
                ", faltas=" + faltas +
                '}';
    }
}
