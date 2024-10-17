package com.aluracursos.screenmatch.principal;

import java.util.Scanner;

import com.aluracursos.screenmatch.service.ConsumoAPI;

public class Principal {
    private Scanner lector = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    
    public void muestraElMenu() {
        System.out.println("Bienvenido al Screenmatch");
        System.out.println("Escribe el nombre de la serie que deseas buscar:");
        var nombreSerie = lector.nextLine();

    }

}
