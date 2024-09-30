package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysAsListExemplo {
    private String[] nomes = new String[3];// fixo
    private List<String> nomesList;// dinamico

    public ArraysAsListExemplo() {
        nomes = new String[] { "Maria", "Pedro", "João" };
        nomesList = new ArrayList<>(Arrays.asList(nomes));
    }
    // alteraçao do array fixo

    public void adicionarArray(String nome) {
        try {
            int posicao = nomes.length;
            nomes[posicao] = nome;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            for (int i = 0; i < nomes.length; i++) {
                System.out.println(nomes[i]);
            }
          
        }
    }

    // alterar uma lista
    public void adicionarList(String nome) {
        try {
            nomesList.add(nome);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
             System.out.println(nomesList);
          
        }
    }
}
