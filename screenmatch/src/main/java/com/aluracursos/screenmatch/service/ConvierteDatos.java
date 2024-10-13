package com.aluracursos.screenmatch.service;

import com.aluracursos.screenmatch.model.DatosSerie;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvierteDatos implements IConvierteDatos {

    private ObjectMapper om = new ObjectMapper();
    //
    // favorece a una interfaz en case que se necesite Serie o Pelicula
    //
    // public DatosSerie obtenerDatos(String json) {
    //     try {
    //         return om.readValue(json, DatosSerie.class);
    //     } catch (Exception e) {
    //         throw new RuntimeException("Error al convertir JSON a DatosSerie", e);
    //     }
    // }

    @Override
    public <T> T obtenerDatos(String json, Class<T> clase) {
        try {
            return om.readValue(json, clase);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}