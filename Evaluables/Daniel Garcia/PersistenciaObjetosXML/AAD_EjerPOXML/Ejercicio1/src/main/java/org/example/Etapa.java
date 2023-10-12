package org.example;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.io.Serializable;
import java.util.List;

@XStreamAlias("Etapa")
public class Etapa implements Serializable {

    private static final long serialVersionUID = 5488764001798701613L;
    private Lugar destino;

    private Hotel hotel;
    private int numNoches;
    @XStreamImplicit(itemFieldName = "Puntos_de_Visita")
    private List<String> puntosVista;

    //Constructor vacio
    public Etapa() {
    }

    //Constructor por parámetros
    public Etapa(Lugar destino, Hotel hotel, int numNoches, List<String> puntosVista) {
        this.destino = destino;
        this.hotel = hotel;
        this.numNoches = numNoches;
        this.puntosVista = puntosVista;
    }

    //Getters y setters
    public Lugar getDestino() {
        return destino;
    }

    public void setDestino(Lugar destino) {
        this.destino = destino;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public int getNumNoches() {
        return numNoches;
    }

    public void setNumNoches(int numNoches) {
        this.numNoches = numNoches;
    }

    public List<String> getPuntosVista() {
        return puntosVista;
    }

    public void setPuntosVista(List<String> puntosVista) {
        this.puntosVista = puntosVista;
    }

    //Método para imprimir por pantalla
    @Override
    public String toString() {
        return "Etapa{" +
                "destino=" + destino +
                ", hotel=" + hotel +
                ", numNoches=" + numNoches +
                ", puntosVista=" + puntosVista +
                '}';
    }
}
