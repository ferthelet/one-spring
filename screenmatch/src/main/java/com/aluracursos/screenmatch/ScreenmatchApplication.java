package com.aluracursos.screenmatch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aluracursos.screenmatch.model.DatosEpisodio;
import com.aluracursos.screenmatch.model.DatosSerie;
import com.aluracursos.screenmatch.model.DatosTemporadas;
import com.aluracursos.screenmatch.principal.Principal;
import com.aluracursos.screenmatch.service.ConsumoAPI;
import com.aluracursos.screenmatch.service.ConvierteDatos;

import java.util.List;
import java.util.ArrayList;

/* Using Spring Initlzr
 * https://start.spring.io/
 * 
 */

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// // System.out.println("Hola Mundo desde Spring");
		// var ConsumoAPI = new ConsumoAPI();
		// var json =
		// ConsumoAPI.obtenerDatos("https://www.omdbapi.com/?t=game+of+thrones&apikey=4fc7c187");
		// // var json =
		// // ConsumoAPI.obtenerDatos("https://coffee.alexflipnote.dev/random.json");
		// // System.out.println(json);
		// ConvierteDatos conversor = new ConvierteDatos();
		// var datos = conversor.obtenerDatos(json, DatosSerie.class);
		// System.out.println(datos);

		// // episodio
		// json =
		// ConsumoAPI.obtenerDatos("https://www.omdbapi.com/?t=game+of+thrones&Season=1&episode=1&apikey=4fc7c187");
		// var episodios = conversor.obtenerDatos(json, DatosEpisodio.class);
		// System.out.println(episodios);

		// temporadas
		// List<DatosTemporadas> temporadas = new ArrayList<>();
		// for (int i = 1; i <= datos.totalDeTemporadas(); i++) {
		// json = ConsumoAPI
		// .obtenerDatos("https://www.omdbapi.com/?t=game+of+thrones&Season=" + i +
		// "&apikey=4fc7c187");
		// temporadas.add(conversor.obtenerDatos(json, DatosTemporadas.class));
		// }
		// temporadas.forEach(System.out::println);
		
		Principal principal = new Principal();
		principal.muestraElMenu();
	}
}
