package com.example.controllers;

import java.util.ArrayList;
import java.util.List;

import com.example.api.TecnicoApi;
import com.example.models.Tecnico;
import com.example.models.Tecnico;

public class TecnicoController {
       private List<Tecnico> tecnicos;

    public TecnicoController() {

        tecnicos = new ArrayList<>();

    }

    // LIstar
     public List<Tecnico> readtecnicos() {
        // for (tecnico tecnico : tecnicos) {
        // System.out.println(tecnico.getID() + " - " + tecnico.getNome());
        // }
        tecnicos = TecnicoApi.gettecnicos();
        
        return tecnicos;
    }

    public void addtecnico(Tecnico tecnico) {
        tecnicos.add(tecnico);
    }

    public void updatetecnico(int posicao, Tecnico tecnico) {

        tecnicos.set(posicao, tecnico);
    }

    public void delete(int posicao) {
        tecnicos.remove(posicao);
}
}
