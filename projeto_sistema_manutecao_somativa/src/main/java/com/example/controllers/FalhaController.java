package com.example.controllers;

import java.util.ArrayList;
import java.util.List;

import com.example.api.FalhaApi;
import com.example.models.Falha;

/**
 * FalhaController
 */
public class FalhaController {
    private List<Falha> falhas;

    public FalhaController() {
        falhas = new ArrayList<>();
    }

    // Listar
    public List<Falha> readFalhas() {
        falhas = FalhaApi.getfalhas(); // Obtém a lista de falhas da API
        return falhas;
    }

    public void addFalha(Falha falha) {
        FalhaApi.createFalha(falha); // Adiciona a nova falha usando a API
        falhas.add(falha); // Adiciona a falha à lista local
    }

    public void updateFalha( Falha falha) {
        // Atualiza a falha pelo ID
        FalhaApi.updateFalha( falha); 
        for (int i = 0; i < falhas.size(); i++) {
            if (falhas.get(i).getId().equals(falha.getId())) {
               // Atualiza a falha na API
                falhas.set(i, falha); // Atualiza a falha na lista local
                return; // Saia do método após a atualização
            }
        }
        // Se o ID não for encontrado, pode-se lançar uma exceção ou simplesmente ignorar
        System.out.println("Falha com ID " + falha.getId() + " não encontrada.");
    }
}
