package com.example;

import java.util.HashSet;
import java.util.Set;

public class SetExemplo {
    private Set<String> nomes;

    public SetExemplo() {
        nomes = new HashSet<>();
    }

    // adicionar
    public void adicionarNome(String nome) {
        nomes.add(nome);
        System.out.println(nomes.hashCode());
    }

    // listar
    public void listarNome() {
        for (String nome : nomes) {
            System.out.println(nome);
        }
    }

    // deletar
    public void deleteNome(String nome) {
        nomes.remove(nome);
        System.out.println("Nome deletado");
    }

    // atualizar
    public void modificarNome(String nome ,String nomeNovo) {
         nomes.remove(nome);
         nomes.add(nomeNovo);
        System.out.println( nome + " alterado para: " + nomeNovo);
        
    }
}
