package org.example;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XStreamAlias("historial")
public class Historial implements Serializable {

    private String nombreInstituto;
    private String anyoAcademico;
    @XStreamImplicit(itemFieldName = "asignatura")
    private List<String> asignaturas;

    //Constructor vacío
    public Historial() {
        this.asignaturas = new ArrayList<>();
    }

    //Constructor con parámetros
    public Historial(String nombreInstituto, String anyoAcademico) {
        this.nombreInstituto = nombreInstituto;
        this.anyoAcademico = anyoAcademico;
        this.asignaturas = new ArrayList<>();
    }

    //Getters y setters
    public String getNombre() {
        return nombreInstituto;
    }

    public void setNombre(String nombre) {
        this.nombreInstituto = nombre;
    }

    public String getAnyoAcademico() {
        return anyoAcademico;
    }

    public void setAnyoAcademico(String anyoAcademico) {
        this.anyoAcademico = anyoAcademico;
    }

    public List<String> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(List<String> asignaturas) {
        this.asignaturas = asignaturas;
    }

    //Método para imprimir
    @Override
    public String toString() {
        return "Historial{" +
                "nombre='" + nombreInstituto + '\'' +
                ", anyoAcademico='" + anyoAcademico + '\'' +
                ", asignaturas=" + asignaturas +
                '}';
    }
}
