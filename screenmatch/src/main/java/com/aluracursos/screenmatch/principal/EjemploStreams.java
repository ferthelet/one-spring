package com.aluracursos.screenmatch.principal;

import java.util.List;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class EjemploStreams {
    public void muestraEjemplo() {

        // ejemplo streams 

        List<String> nombres = Arrays.asList("Juan", "Pedro", "Maria", "Jose", "Luis");

        nombres.stream()
        .sorted()
        .limit(4)
        .filter(n -> n.startsWith("J"))
        .map(n -> n.toUpperCase())
        .forEach(System.out::println);
    }

}
