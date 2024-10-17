package com.example.controllers;

import java.util.List;
import com.example.api.MaquinaApi;
import com.example.models.Maquina;

public class MaquinaController {
    private List<Maquina> maquinas;

    public MaquinaController() {
        maquinas = MaquinaApi.getMaquinas(); // Carrega as máquinas da API no início
    }

    // Listar
    public List<Maquina> readMaquinas() {
        return maquinas;
    }

    public void addMaquina(Maquina maquina) {
        MaquinaApi.createMaquina(maquina); // Chama a API para criar a máquina
        maquinas.add(maquina); // Adiciona à lista local (opcional, dependendo da lógica da aplicação)
    }

    public void updateMaquina(int posicao, Maquina maquina) {
        MaquinaApi.updateMaquina(maquina); // Chama a API para atualizar a máquina
        maquinas.set(posicao, maquina); // Atualiza a lista local
    }
    public void deleteMaquina(int posicao) {
        if (posicao >= 0 && posicao < maquinas.size()) {
            Maquina maquina = maquinas.get(posicao);
            MaquinaApi.deleteMaquina(maquina.getId()); // Chama a API para deletar a máquina
            maquinas.remove(posicao); // Remove da lista local
        }
    }
}
