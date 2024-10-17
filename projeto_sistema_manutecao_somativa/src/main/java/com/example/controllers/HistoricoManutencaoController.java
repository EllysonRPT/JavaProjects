package com.example.controllers;

import java.util.ArrayList;
import java.util.List;

import com.example.api.HistoricoManutencaoApi;
import com.example.models.HistoricoManutencao;

public class HistoricoManutencaoController {
    private List<HistoricoManutencao> historicoManutencaos;

    public HistoricoManutencaoController() {
        historicoManutencaos = new ArrayList<>();
    }

    // Listar
    public List<HistoricoManutencao> readHistoricoManutencaos() {
        historicoManutencaos = HistoricoManutencaoApi.gethistoricoManutencaos();
        return historicoManutencaos;
    }

    public void addHistoricoManutencao(HistoricoManutencao manutencao) {
        HistoricoManutencaoApi.createHistoricoManutencao(manutencao);
        historicoManutencaos.add(manutencao);
    }

    public void updateHistoricoManutencao(String id, HistoricoManutencao historicoManutencaoAtualizado) {
        // Encontra a posição do histórico de manutenção a ser atualizado pelo ID
        for (int i = 0; i < historicoManutencaos.size(); i++) {
            if (historicoManutencaos.get(i).getId().equals(id)) {
                historicoManutencaos.set(i, historicoManutencaoAtualizado);
                return; // Saia do método após a atualização
            }
        }
        // Se o ID não for encontrado, pode-se lançar uma exceção ou simplesmente ignorar
        System.out.println("Histórico de manutenção com ID " + id + " não encontrado.");
    }
}
