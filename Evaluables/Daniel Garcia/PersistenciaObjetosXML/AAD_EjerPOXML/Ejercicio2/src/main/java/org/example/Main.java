package org.example;

import com.thoughtworks.xstream.XStream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static ListaInstitutos listaInstitutos = new ListaInstitutos();
    public static void main(String[] args) {

       // listaInstitutos.add(getInstituto1());
       // listaInstitutos.add(getInstituto2());

        try {
            //generateXML();
            readXML();

            System.out.println("Listado de institutos: ");
            System.out.println("-----------------------");
            for(Instituto i: listaInstitutos.getInstitutos()){
                System.out.println(i);
                System.out.println();
            }

            escrituraFicheroDAT();

        } catch (FileNotFoundException ex){
            System.out.println("Error de lectura de fichero XML -> " + ex.getMessage());
        }


    }
    public static Instituto getInstituto1(){
        List<String> asig = List.of("Inf", "Ing");
        List<String> asig2 = List.of("Inf", "Ing");
        Historial h1 = new Historial("LA hoya", "22-23");
        Historial h2 = new Historial("Erche", "21-22");
        h1.setAsignaturas(asig);
        h2.setAsignaturas(asig2);
        List<Historial> hists = List.of(h1, h2);

        Falta f1 = new Falta("12-05-2022", "amigdalitis");
        Falta f2 = new Falta("15-10-2023", "cita médica");
        List<Falta> falts = List.of(f1, f2);

        Profesor p1 = new Profesor("profesor", "12345678M", "Dani", "Garcia", "Pascual", "2002-12-27", 3000.2, "2021-05-23");
        p1.setHistoriales(hists);
        p1.setFaltas(falts);

        Administrativo p2 = new Administrativo("administrativo", "12345678M", "Laura", "Coves", "Coves", "2002-12-27", 3000.2, 3);
        List<Persona> pers = List.of(p1, p2);

        Instituto in = new Instituto("IES LA TORRETA");
        in.setPersonas(pers);

        return in;
    }

    public static Instituto getInstituto2(){
        List<String> asig = List.of("Inf", "Ing");
        List<String> asig2 = List.of("Inf", "Ing");
        Historial h1 = new Historial("Alicante", "22-23");
        Historial h2 = new Historial("Madrid", "21-22");
        h1.setAsignaturas(asig);
        h2.setAsignaturas(asig2);
        List<Historial> hists = List.of(h1, h2);

        Falta f1 = new Falta("12-05-2022", "amigdalitis");
        Falta f2 = new Falta("15-10-2023", "cita médica");
        List<Falta> falts = List.of(f1, f2);

        Profesor p1 = new Profesor("profesor", "12345678M", "Juan", "Perez", "Perez", "2002-12-27", 3000.2, "2021-02-12");
        p1.setHistoriales(hists);
        p1.setFaltas(falts);

        Administrativo p2 = new Administrativo("administrativo", "12345678M", "Sofia", "Rodriguez", "Martinez", "2002-12-27", 3000.2, 3);
        List<Persona> pers = List.of(p1, p2);

        Instituto in = new Instituto("IES MACIA ABELA");
        in.setPersonas(pers);

        return in;
    }

    public static void generateXML() throws FileNotFoundException {
        XStream xStream = new XStream();

        xStream.processAnnotations(Instituto.class);
        xStream.processAnnotations(Persona.class);
        xStream.processAnnotations(Profesor.class);
        xStream.processAnnotations(Administrativo.class);
        xStream.processAnnotations(Falta.class);
        xStream.processAnnotations(Historial.class);
        xStream.processAnnotations(ListaInstitutos.class);


        xStream.addImplicitCollection(ListaInstitutos.class, "listaInstitutos");
        xStream.addImplicitCollection(Instituto.class, "personas");
        xStream.addImplicitCollection(Profesor.class, "historiales");
        xStream.addImplicitCollection(Profesor.class, "faltas");

        xStream.toXML(listaInstitutos, new FileOutputStream(("src/main/resources/ejemplo1.xml")));
    }

    public static void readXML() throws FileNotFoundException {
        XStream xStream = new XStream();

        xStream.processAnnotations(Instituto.class);
        xStream.processAnnotations(Persona.class);
        xStream.processAnnotations(Profesor.class);
        xStream.processAnnotations(Administrativo.class);
        xStream.processAnnotations(Falta.class);
        xStream.processAnnotations(Historial.class);
        xStream.processAnnotations(ListaInstitutos.class);

        System.out.println("A");

        xStream.addImplicitCollection(ListaInstitutos.class, "listaInstitutos");

        xStream.addImplicitCollection(Instituto.class, "personas");
        xStream.addImplicitCollection(Profesor.class, "historiales");
        xStream.addImplicitCollection(Profesor.class, "faltas");

        System.out.println("B");

        xStream.allowTypes(new Class[]{
                org.example.Instituto.class,
                org.example.ListaInstitutos.class,
                org.example.Persona.class,
                org.example.Profesor.class,
                org.example.Administrativo.class,
                org.example.Falta.class,
                org.example.Historial.class
        });

        System.out.println("C");

        listaInstitutos = (ListaInstitutos) xStream.fromXML(new FileInputStream("src/main/resources/instituto.xml"));

        System.out.println("D");

    }

    public static void escrituraFicheroDAT(){
        File f = new File("src/main/resources/institutos.dat");
        try {
            if (!f.exists()){
                f.createNewFile();
            }
            FileOutputStream escritura = new FileOutputStream(f);
            ObjectOutputStream objectOut = new ObjectOutputStream(escritura);

            for (Instituto i: listaInstitutos.getInstitutos()){
                objectOut.writeObject((Instituto) i);
            }

            objectOut.close();

        } catch(FileNotFoundException fnfe){
            System.out.println("Error fichero no encontrado -> " + fnfe.getMessage());
        } catch (IOException ioe){
            System.out.println("Error escritura en el fichero -> " + ioe.getMessage());
        }
    }
}