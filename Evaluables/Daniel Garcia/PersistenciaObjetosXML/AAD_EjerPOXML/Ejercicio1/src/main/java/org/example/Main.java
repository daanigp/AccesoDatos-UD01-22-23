package org.example;

import com.thoughtworks.xstream.XStream;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static ListaViajes viajess = new ListaViajes();
    public static void main(String[] args) {


        //Crear una clase para la listadeViajes como en el ejemplo
        ListaViajes viajes = new ListaViajes();

        viajes.add(getViaje1());
        viajes.add(getViaje2());


        /*for (Viaje v: viajes.getViajes()){
            System.out.println(v);
            System.out.println("------------------");
        }*/

        leerFicheroBinario();
        System.out.println("***************************************************");
        for (Viaje v: viajess.getViajes()){
            System.out.println(v);
            System.out.println("------------------");
        }



        //generateXML(viajes);

    }

    public static Viaje getViaje1(){

        Lugar l1 = new Lugar("Elche", "Espanya");
        Hotel h1 = new Hotel("Palmeiras", "Calle 34", 200.00);
        List<String> puntosVisita1 = List.of("Martinez Valero", "centro ciudad", "museo MAHE");
        Etapa e1 = new Etapa(l1, h1, 4, puntosVisita1);
        Lugar l2 = new Lugar("Alicante", "Espanya");
        Hotel h2 = new Hotel("Sant alacanti", "Calle 14", 350.00);
        List<String> puntosVisita2 = List.of("Rico Pérez", "centro ciudad");
        Etapa e2 = new Etapa(l2, h2, 4, puntosVisita2);
        List<Etapa> etapas = List.of(e1, e2);
        Lugar lugar = new Lugar("Valencia", "España");
        Viaje v1 = new Viaje(LocalDate.of(2023, 11, 21), LocalDate.of(2023, 11, 22), etapas, lugar);

        return v1;
    }

    public static Viaje getViaje2(){

        Lugar l1 = new Lugar("Barcelona", "Espanya");
        Hotel h1 = new Hotel("san jordis", "Calle 44", 500.00);
        List<String> puntosVisita1 = List.of("Camp nou", "centro ciudad", "Sagrada Familia");
        Etapa e1 = new Etapa(l1, h1, 4, puntosVisita1);
        Lugar l2 = new Lugar("Girona", "Espanya");
        Hotel h2 = new Hotel("girana's Hotel", "Calle 24", 350.00);
        List<String> puntosVisita2 = List.of("Montilivi", "centro ciudad");
        Etapa e2 = new Etapa(l2, h2, 4, puntosVisita2);
        List<Etapa> etapas = List.of(e1, e2);
        Lugar lugar = new Lugar("Reus", "España");
        Viaje v1 = new Viaje(LocalDate.of(2023, 12, 22), LocalDate.of(2023, 12, 23), etapas, lugar);

        return v1;
    }

    public static void leerFicheroBinario(){

        File f = new File("src/main/resources/viajes.dat");

        try{
            FileInputStream lectura = new FileInputStream(f);
            ObjectInputStream objInpStr = new ObjectInputStream(lectura);

            //Viaje v1 = null;
            //ArrayList<Viaje> listaViajes = new ArrayList<>();


            try{
                while (true){
                    System.out.println("A");
                    Viaje v1 = (Viaje) objInpStr.readObject();
                    System.out.println("a");
                    System.out.println(v1);
                    viajess.add(v1);
                }
            } catch (ClassNotFoundException e) {
                System.out.println("Error : " + e.getMessage());
            } catch (EOFException eofe){
                System.out.println("Final de lectura del fichero correctamente.");
            }


        } catch (FileNotFoundException e) {
            System.out.println("Error 2 -> " + e.getMessage());
        } catch (IOException ex) {
            System.out.println("Error -> " + ex.getMessage());
        }
    }

    public static void generateXML(ArrayList<Viaje> viajes){
        XStream xStream = new XStream();


    }
}