package com.aluracursos.screenmatch.principal;

import java.util.Scanner;

public class Principal {
    private Scanner lector = new Scanner(System.in);
    
    public void muestraElMenu() {
        System.out.println("Bienvenido al Screenmatch");
        System.out.println("Escribe el nombre de la serie que deseas buscar:");
        var nombreSerie = lector.nextLine();

    }

}
