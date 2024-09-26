package com.example;

import java.util.ArrayList;
import java.util.List;

public class ListExemplo {
    private List<String> nomes;

    public ListExemplo() {

        nomes = new ArrayList<>();
    }

    // adicionar
    public void adicionarNome(String nome) {
        nomes.add(nome);
        System.out.println(nomes.indexOf(nome));
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
    public void modificarNomeIndex(int index, String nome) {
        String nomeAnterior = nomes.get(index);
        System.out.println("Nome da Posição: "+index+" alterado para: "+nome);
        nomes.set(index, nome);
    }

//     public void procurar(int index, String nome) {
// nomes.
//     }

}
