package com.aluracursos.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosEpisodio (
    @JsonAlias("Title") String titulo,
    @JsonAlias("Episode") Integer numeroEpisodio,
    @JsonAlias("imdbRating") String evaluacion,
    @JsonAlias("Released") String fechaDeLanzamiento
) {

    // override de toString para que no imprima la referencia de memoria
    @Override
    public String toString() {
        return "DatosEpisodio [titulo=" + titulo + ", numeroEpisodio=" + numeroEpisodio + ", evaluacion=" + evaluacion
                + ", fechaDeLanzamiento=" + fechaDeLanzamiento + "]\n";
    }
}
