package com.example.controllers;

import java.util.ArrayList;
import java.util.List;

import com.example.api.HistoricoManutencaoApi;
import com.example.models.HistoricoManutencao;
import com.example.models.HistoricoManutencao;

public class HistoricoManutencaoController {
       private List<HistoricoManutencao> historicoManutencaos;

    public HistoricoManutencaoController() {

        historicoManutencaos = new ArrayList<>();

    }

    // LIstar
     public List<HistoricoManutencao> readHistoricoManutencaos() {
        // for (HistoricoManutencao HistoricoManutencao : HistoricoManutencaos) {
        // System.out.println(HistoricoManutencao.getID() + " - " + HistoricoManutencao.getNome());
        // }
        historicoManutencaos = HistoricoManutencaoApi.gethistoricoManutencaos();
        
        return historicoManutencaos;
    }

    public void addHistoricoManutencao(HistoricoManutencao HistoricoManutencao) {
        historicoManutencaos.add(HistoricoManutencao);
    }

    public void updateHistoricoManutencao(int posicao, HistoricoManutencao HistoricoManutencao) {

        historicoManutencaos.set(posicao, HistoricoManutencao);
    }

    public void delete(int posicao) {
        historicoManutencaos.remove(posicao);
}
}
