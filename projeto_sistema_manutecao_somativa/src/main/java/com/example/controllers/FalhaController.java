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

    // LIstar
     List<Falha> readfalhas() {
        // for (falha falha : falhas) {
        // System.out.println(falha.getID() + " - " + falha.getNome());
        // }
        falhas = FalhaApi.getfalhas();
        return falhas;
    }

    public void addfalha(Falha falha) {
        falhas.add(falha);
    }

    public void updatefalha(int posicao, Falha falha) {

falhas.set(posicao, falha);
    }

    public void delete(int posicao) {
        falhas.remove(posicao);
}
    
}