package com.aluracursos.screenmatch.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosTemporadas(
    @JsonAlias("Season") Integer numero,
    @JsonAlias("Episodes") List<DatosEpisodio> episodios
) {

    // override de toString para que no imprima la referencia de memoria
    @Override
    public String toString() {
        return "DatosTemporadas [numero=" + numero + ", episodios=" + episodios + "]\n";
    }

}
