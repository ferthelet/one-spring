package com.aluracursos.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record DatosEpisodios(
    @JsonAlias("Title") String titulo,
    @JsonAlias("Episode") Integer numeroEpisodio,
    @JsonAlias("imdbRating") String evaluacion,
    @JsonAlias("Released") String fechaDeLanzamiento
) {

}
