package com.example.controllers;

import java.util.ArrayList;
import java.util.List;

import com.example.api.MaquinaApi;
import com.example.models.Maquina;

public class MaquinaController {
    private List<Maquina> maquinas;

    public MaquinaController() {

        maquinas = new ArrayList<>();

    }

    // LIstar
    public List<Maquina> readMaquinas() {
        // for (Maquina maquina : maquinas) {
        // System.out.println(maquina.getID() + " - " + maquina.getNome());
        // }
        maquinas = MaquinaApi.getMaquinas();
        return maquinas;
    }

    public void addMaquina(Maquina maquina) {
        maquinas.add(maquina);
    }

    public void updateMaquina(int posicao, Maquina maquina) {

maquinas.set(posicao, maquina);
    }

    public void delete(int posicao) {
        maquinas.remove(posicao);
}

}