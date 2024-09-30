package com.example;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExemplo {
    List<String> words = Arrays.asList("banana", "uva", "amora", "pera", "laranja", "abacaxi", "uva");

    public void resultadoStream() {
        // começa com a
        // uppercase
        // crie uma nova lista
        // cria um metodo
        List<String> resultado = words.stream()
        .filter(word -> word.startsWith("a"))
        .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(resultado);  
        System.out.println(words);  

    }

}
