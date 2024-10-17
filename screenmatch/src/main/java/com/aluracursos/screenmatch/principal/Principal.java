package com.aluracursos.screenmatch.principal;

import java.util.Scanner;

import com.aluracursos.screenmatch.service.ConsumoAPI;

public class Principal {
    private Scanner lector = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private final String API_KEY = "&apikey=4fc7c187";
    private final String URL_BASE = "https://www.omdbapi.com/?t=";
        
    public void muestraElMenu() {
        System.out.println("Bienvenido al Screenmatch");
        System.out.println("Escribe el nombre de la serie que deseas buscar:");
        var nombreSerie = lector.nextLine();

        var json = consumoAPI.obtenerDatos(URL_BASE + nombreSerie.replace(" ", "+") + API_KEY);

        System.out.println(json);

    }

}
