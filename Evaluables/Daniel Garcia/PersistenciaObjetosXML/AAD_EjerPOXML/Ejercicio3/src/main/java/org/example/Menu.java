package org.example;

import java.util.Scanner;

public class Menu {
    private int opcion;

    public int getOpcion() {
        return opcion;
    }

    public void setOpcion(int opcion) {
        this.opcion = opcion;
    }

    public void mostrar() {
        System.out.println("\nMenú:");
        System.out.println("1. Convertir XML a DAT");
        System.out.println("2. Convertir DAT a XML");
        System.out.println("3. Mostrar XML");
        System.out.println("4. Mostrar DAT");
        System.out.println("5. Salir");

    }

    public int leerOpcion() {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
        } while (opcion < 1 || opcion > 5);
        sc.nextLine();
        return opcion;
    }
}
