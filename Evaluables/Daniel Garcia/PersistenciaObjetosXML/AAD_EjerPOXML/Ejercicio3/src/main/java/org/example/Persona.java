package org.example;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

import java.io.Serializable;

@XStreamAlias("persona")
public class Persona implements Serializable {

    @XStreamAlias("class")
    @XStreamAsAttribute
    private String clase;
    private String dni;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String fechaNacimiento;
    private double sueldoBruto;

    //Constructor vacío
    public Persona() {
    }

    //Cosntructor con parámetros
    public Persona(String clase, String dni, String nombre, String apellido1, String apellido2, String fechaNacimiento, double sueldoBruto) {
        this.clase = clase;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fechaNacimiento = fechaNacimiento;
        this.sueldoBruto = sueldoBruto;
    }

    //Getters y setters
    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public double getSueldoBruto() {
        return sueldoBruto;
    }

    public void setSueldoBruto(double sueldoBruto) {
        this.sueldoBruto = sueldoBruto;
    }

    //Método para imprimir
    @Override
    public String toString() {
        return "Persona{" +
                "clase='" + clase + '\'' +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido1='" + apellido1 + '\'' +
                ", apellido2='" + apellido2 + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", sueldoBruto=" + sueldoBruto +
                '}';
    }
}
