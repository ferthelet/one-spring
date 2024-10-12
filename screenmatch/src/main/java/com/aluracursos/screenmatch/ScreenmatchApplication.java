package com.aluracursos.screenmatch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.aluracursos.screenmatch.service.ConsumoAPI;

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
		// System.out.println("Hola Mundo desde Spring");
		var ConsumoAPI = new ConsumoAPI();
		// var json = ConsumoAPI.obtenerDatos("https://www.omdbapi.com/?t=game+of+thrones&apikey=4fc7c187");
		var json = ConsumoAPI.obtenerDatos("https://coffee.alexflipnote.dev/random.json");
		System.out.println(json);
	}
}
