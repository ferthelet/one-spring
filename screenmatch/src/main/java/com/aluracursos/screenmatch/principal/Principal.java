package com.aluracursos.screenmatch.principal;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import com.aluracursos.screenmatch.model.DatosSerie;
import com.aluracursos.screenmatch.model.DatosTemporadas;
import com.aluracursos.screenmatch.service.ConsumoAPI;
import com.aluracursos.screenmatch.service.ConvierteDatos;

public class Principal {
    private Scanner lector = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private final String API_KEY = "&apikey=4fc7c187";
    private final String URL_BASE = "https://www.omdbapi.com/?t=";
    private ConvierteDatos conversor = new ConvierteDatos();

    public void muestraElMenu() {
        System.out.println("Bienvenido al Screenmatch");
        System.out.println("Escribe el nombre de la serie que deseas buscar:");
        var nombreSerie = lector.nextLine();
        System.out.println(URL_BASE + nombreSerie.replace(" ", "+") + API_KEY);
        var json = consumoAPI.obtenerDatos(URL_BASE + nombreSerie.replace(" ", "+") + API_KEY);
        var datos = conversor.obtenerDatos(json, DatosSerie.class);
        System.out.println(datos);

        // busca datos de las temporadaas
        List<DatosTemporadas> temporadas = new ArrayList<>();
        for (int i = 1; i <= datos.totalDeTemporadas(); i++) {
            json = consumoAPI.obtenerDatos(URL_BASE + nombreSerie.replace(" ", "+") + "&Season=" + i + API_KEY);
            temporadas.add(conversor.obtenerDatos(json, DatosTemporadas.class));
        }
        // temporadas.forEach(System.out::println);

        // mostrar solo titulo de los episodios para la temporadas
        temporadas.forEach(temporada -> temporada.episodios()
                .forEach(episodio -> System.out.println("S: " + temporada.numero() +", E: " + episodio.numeroEpisodio() + ", C: " + episodio.titulo())));

    }

}
