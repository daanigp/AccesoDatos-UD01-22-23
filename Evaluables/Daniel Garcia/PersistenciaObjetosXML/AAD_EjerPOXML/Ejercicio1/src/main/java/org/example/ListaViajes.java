package org.example;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.ArrayList;
import java.util.List;

@XStreamAlias("viajes")
public class ListaViajes {
    private List<Viaje> listaViajes;

    public ListaViajes() {
        this.listaViajes = new ArrayList<>();
    }

    public void add(Viaje v){
        this.listaViajes.add(v);
    }

    public List<Viaje> getViajes(){
        return listaViajes;
    }
}
