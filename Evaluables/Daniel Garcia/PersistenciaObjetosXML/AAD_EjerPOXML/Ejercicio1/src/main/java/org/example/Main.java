package org.example;

import com.thoughtworks.xstream.XStream;

import java.io.*;

public class Main {
    static ListaViajes viajes = new ListaViajes();
    public static void main(String[] args) {


        //Crear una clase para la listadeViajes como en el ejemplo
        leerFicheroBinario();

        try {
            generateXML();
        } catch (FileNotFoundException ex){
            System.out.println("Error generar XML -> " + ex.getMessage());
        }

        System.out.println("\nFichero de XML generado correctamente.");

    }

    public static void leerFicheroBinario(){

        File f = new File("src/main/resources/viajes.dat");

        try{
            FileInputStream lectura = new FileInputStream(f);
            ObjectInputStream objInpStr = new ObjectInputStream(lectura);

            try{
                while (true){
                    Viaje v1 = (Viaje) objInpStr.readObject();
                    viajes.add(v1);
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

    public static void generateXML() throws FileNotFoundException {
        XStream xStream = new XStream();

        xStream.processAnnotations(Etapa.class);
        xStream.processAnnotations(Hotel.class);
        xStream.processAnnotations(ListaViajes.class);
        xStream.processAnnotations(Lugar.class);
        xStream.processAnnotations(Viaje.class);

        xStream.addImplicitCollection(ListaViajes.class, "listaViajes");
        xStream.addImplicitCollection(Viaje.class, "estapas");
        xStream.addImplicitCollection(Etapa.class, "puntosVista");

        xStream.toXML(viajes, new FileOutputStream("src/main/resources/viajes.xml"));


    }
}