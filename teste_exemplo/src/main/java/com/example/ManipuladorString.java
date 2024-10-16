package com.example;

public class ManipuladorString {

    // Método que inverte a string
    public String invertString(String original) {
        if (original == null) {
            throw new IllegalArgumentException("A string não pode ser nula.");
        }
        return new StringBuilder(original).reverse().toString();
    }

    // Método que conta as vogais na string
    public int contarVogais(String texto) {
        if (texto == null) {
            throw new IllegalArgumentException("A string não pode ser nula.");
        }
        int count = 0;
        for (char c : texto.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }

    // Método que conta as palavras na string
    public int contarPalavras(String texto) {
        if (texto == null) {
            throw new IllegalArgumentException("A string não pode ser nula.");
        }
        String[] palavras = texto.trim().split("\\s+");
        return palavras.length == 1 && palavras[0].isEmpty() ? 0 : palavras.length;
    }
}
