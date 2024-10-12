package com.aluracursos.screenmatch.service;

import com.aluracursos.screenmatch.model.DatosSerie;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvierteDatos {
    private ObjectMapper om = new ObjectMapper();
    public DatosSerie obtenerDatos(String json) {
        try {
            return om.readValue(json, DatosSerie.class);
        } catch (Exception e) {
            throw new RuntimeException("Error al convertir JSON a DatosSerie", e);
        }
    }
}
