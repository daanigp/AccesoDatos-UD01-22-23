package org.example;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Viaje implements Serializable {
    private LocalDate fechaSalida;
    private LocalDate fechaLlegada;
    private List<Etapa> estapas;//Porq el profe tiene puesto en el archivo .dat estapas
                                // sería etapas.
    private Lugar salida;

    //Constructor vacio
    public Viaje() {
    }

    //Constructor con parámetros
    public Viaje(LocalDate fechaSalida, LocalDate fechaLlegada, List<Etapa> estapas, Lugar salida) {
        this.fechaSalida = fechaSalida;
        this.fechaLlegada = fechaLlegada;
        this.estapas = estapas;
        this.salida = salida;
    }

    //Getters y setters
    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public LocalDate getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(LocalDate fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public List<Etapa> getEstapas() {
        return estapas;
    }

    public void setEstapas(List<Etapa> etapas) {
        this.estapas = etapas;
    }

    public Lugar getSalida() {
        return salida;
    }

    public void setSalida(Lugar salida) {
        this.salida = salida;
    }

    //Método para imprimir por pantalla
    @Override
    public String toString() {
        return "Viaje{" +
                "fechaSalida=" + fechaSalida +
                ", fechaLlegada=" + fechaLlegada +
                ", etapas=" + estapas +
                ", salida=" + salida +
                '}';
    }
}
