package org.example;

public class Main {
    public static void main(String[] args) {

        Menu menu = new Menu();

        int opcion;

        do {
            menu.mostrar();
            opcion = menu.leerOpcion();

            switch (opcion){
                case 1:
                    convertirADAT();
                    break;
                case 2:
                    convertirAXML();
                    break;
                case 3:
                    mostrarXML();
                    break;
                case 4:
                    mostrarDAT();
                    break;
                case 5:
                    System.out.println("FIN DEL PROGRAMA.");
                    break;
            }

        } while (opcion != 5);
    }


}