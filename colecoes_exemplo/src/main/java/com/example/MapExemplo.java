package com.example;

import java.util.HashMap;
import java.util.Map;

public class MapExemplo {
    private Map<String, Integer> nomeIdade;

    public MapExemplo() {
        nomeIdade = new HashMap<>();
    }
    public void adicinarIdade(String nome, int Idade){
        nomeIdade.put(nome, Idade);

    }
    public void listarNomesIdade() {
        for (String nome : nomeIdade.keySet()) {
            System.out.println("Nome: " + nome + ", Idade: " + nomeIdade.get(nome));
        }
    }
    public void update(String key,int value){
 
        nomeIdade.replace(key,value);
    }
}
