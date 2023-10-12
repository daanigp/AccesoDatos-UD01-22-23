package org.example;

import com.thoughtworks.xstream.XStream;

import java.io.*;

public class Main {
    public static void main(String[] args) {

        Menu menu = new Menu();

        int opcion;

        do {
            menu.mostrar();
            opcion = menu.leerOpcion();
            try {
                switch (opcion) {
                    case 1:
                        convertirADAT();
                        break;
                    case 2:
                        convertirAXML();
                        break;
                    case 3:
                        ListaInstitutos listaInstitutos = mostrarXML();
                        System.out.println("Listado de institutos mediante archivo XML: ");
                        System.out.println("-----------------------");
                        mostrarListaInstitutos(listaInstitutos);
                        break;
                    case 4:
                        mostrarDAT();
                        break;
                    case 5:
                        System.out.println("FIN DEL PROGRAMA.");
                        break;
                }
            } catch(FileNotFoundException fne){
                System.out.println("Error de lectura de fichero XML -> " + fne.getMessage());
            }

        } while (opcion != 5);
    }

    public static void convertirADAT(){

        File f = new File("src/main/resources/institutos.dat");
        try {
            if (!f.exists()){
                f.createNewFile();
            }
            FileOutputStream escritura = new FileOutputStream(f);
            ObjectOutputStream objectOut = new ObjectOutputStream(escritura);

            ListaInstitutos listaInstitutos = mostrarXML();

            for (Instituto i: listaInstitutos.getInstitutos()){
                objectOut.writeObject((Instituto) i);
            }

            objectOut.close();

            System.out.println("Archivo XML convertido a DAT correctamente.");
        } catch(FileNotFoundException fnfe){
            System.out.println("Error fichero no encontrado -> " + fnfe.getMessage());
        } catch (IOException ioe){
            System.out.println("Error escritura en el fichero -> " + ioe.getMessage());
        }
    }

    public static void convertirAXML(){
        File f = new File("src/main/resources/institutos.dat");
        ListaInstitutos listaInstitutos = new ListaInstitutos();

        try {
            FileInputStream lectura = new FileInputStream(f);
            ObjectInputStream objectIn = new ObjectInputStream(lectura);

            Instituto i = null;

            try {
                while (true){
                    i = (Instituto) objectIn.readObject();
                    listaInstitutos.add(i);
                }
            } catch (ClassNotFoundException cnfe){
                System.out.println("No se encuentra la clase -> " + cnfe.getMessage());
            } catch (EOFException eofe){
                generarXML(listaInstitutos);
                System.out.println("Archivo DAT convertido a XML correctamente.");
            }

        } catch (FileNotFoundException fnfe){
            System.out.println("Error fichero no encontrado -> " + fnfe.getMessage());
        } catch (IOException ioe){
            System.out.println("Error escritura en el fichero -> " + ioe.getMessage());
        }
    }

    public static ListaInstitutos mostrarXML() throws FileNotFoundException {
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

        xStream.allowTypes(new Class[]{
                org.example.Instituto.class,
                org.example.ListaInstitutos.class,
                org.example.Persona.class,
                org.example.Profesor.class,
                org.example.Administrativo.class,
                org.example.Falta.class,
                org.example.Historial.class
        });

        ListaInstitutos listaInstitutos = (ListaInstitutos) xStream.fromXML(new FileInputStream("src/main/resources/instituto.xml"));

        return listaInstitutos;

    }

    public static  void mostrarDAT(){

        File f = new File("src/main/resources/institutos.dat");
        ListaInstitutos listaInstitutos = new ListaInstitutos();

        try {
            FileInputStream lectura = new FileInputStream(f);
            ObjectInputStream objectIn = new ObjectInputStream(lectura);

            Instituto i = null;

            try {
                while (true){
                    i = (Instituto) objectIn.readObject();
                    listaInstitutos.add(i);
                }
            } catch (ClassNotFoundException cnfe){
                System.out.println("No se encuentra la clase -> " + cnfe.getMessage());
            } catch (EOFException eofe){
                System.out.println("Listado de institutos mediante archivo DAT: ");
                System.out.println("-----------------------");
                mostrarListaInstitutos(listaInstitutos);
            }

        } catch (FileNotFoundException fnfe){
            System.out.println("Error fichero no encontrado -> " + fnfe.getMessage());
        } catch (IOException ioe){
            System.out.println("Error escritura en el fichero -> " + ioe.getMessage());
        }
    }

    public static void mostrarListaInstitutos(ListaInstitutos lI){
        for (Instituto i: lI.getInstitutos()){
            System.out.println(i);
            System.out.println();
        }
    }

    public static void generarXML(ListaInstitutos li) throws FileNotFoundException {
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

        xStream.toXML(li, new FileOutputStream(("src/main/resources/ejemplo1.xml")));
    }
}