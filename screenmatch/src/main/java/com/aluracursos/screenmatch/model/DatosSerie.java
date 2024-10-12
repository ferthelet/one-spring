package com.aluracursos.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record DatosSerie(
    // @JsonProperty() sirve para leer el nombre de la propiedad en el JSON y asignarlo al atributo de la clase
    // @JsonAlias() sirve para leer solamente
    @JsonAlias("Title") String titulo,
    @JsonAlias ("totalSeasons") Integer totalDeTemporadas,
    @JsonAlias("imdbRating") String evaluacion) {


}
