package com.example.controllers;

import java.util.ArrayList;
import java.util.List;

import com.example.api.TecnicoApi;
import com.example.models.Tecnico;

public class TecnicoController {
    private List<Tecnico> tecnicos;

    public TecnicoController() {
        tecnicos = new ArrayList<>();
    }

    // Listar
    public List<Tecnico> readTecnicos() {
        tecnicos = TecnicoApi.getTecnicos(); // Obtém a lista de técnicos da API
        return tecnicos;
    }

    // Adicionar técnico
    public void addTecnico(Tecnico tecnico) {
        TecnicoApi.createTecnico(tecnico); // Adiciona o técnico usando a API
        tecnicos.add(tecnico); // Adiciona o técnico à lista local
    }

    // Atualizar técnico
    public void updateTecnico(Tecnico tecnico) {
        // Atualiza o técnico pelo ID
        TecnicoApi.updateTecnico(tecnico); 
        for (int i = 0; i < tecnicos.size(); i++) {
            if (tecnicos.get(i).getId().equals(tecnico.getId())) {
                // Atualiza o técnico na API
                tecnicos.set(i, tecnico); // Atualiza o técnico na lista local
                return; // Saia do método após a atualização
            }
        }
        // Se o ID não for encontrado, pode-se lançar uma exceção ou simplesmente ignorar
        System.out.println("Técnico com ID " + tecnico.getId() + " não encontrado.");
    }
    
    // Remover técnico
    public void deleteTecnico(String tecnicoId) {
        TecnicoApi.deleteTecnico(tecnicoId); // Remove o técnico da API
        tecnicos.removeIf(tecnico -> tecnico.getId().equals(tecnicoId)); // Remove da lista local
    }
}
