package org.example;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.ArrayList;
import java.util.List;

@XStreamAlias("institutos")
public class ListaInstitutos {
    private List<Instituto> listaInstitutos;

    public ListaInstitutos(){
        this.listaInstitutos = new ArrayList<>();
    }

    public void add(Instituto i){
        this.listaInstitutos.add(i);
    }

    public List<Instituto> getInstitutos(){
        return listaInstitutos;
    }
}
