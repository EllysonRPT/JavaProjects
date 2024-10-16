package com.example.controllers;

import java.util.ArrayList;
import java.util.List;

import com.example.api.HistoricoManutencaoApi;
import com.example.api.HistoricoManutencaoApi;
import com.example.models.HistoricoManutencao;

public class HistoricoManutencaoController {
     private List<HistoricoManutencao> historicoManutencaos;

    public HistoricoManutencaoController() {

        historicoManutencaos = new ArrayList<>();

    }

    // LIstar
    public List<HistoricoManutencao> readhistoricoManutencaos() {
        // for (historicoManutencao historicoManutencao : historicoManutencaos) {
        // System.out.println(historicoManutencao.getID() + " - " + historicoManutencao.getNome());
        // }
        historicoManutencaos = HistoricoManutencaoApi.gethistoricoManutencaos();
        return historicoManutencaos;
    }

    public void addhistoricoManutencao(HistoricoManutencao historicoManutencao) {
        historicoManutencaos.add(historicoManutencao);
    }

    public void updatehistoricoManutencao(int posicao, HistoricoManutencao historicoManutencao) {

historicoManutencaos.set(posicao, historicoManutencao);
    }

    public void delete(int posicao) {
        historicoManutencaos.remove(posicao);
}
}
