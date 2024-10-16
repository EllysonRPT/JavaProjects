package com.example.api;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.models.HistoricoManutencao;

public class HistoricoManutencaoApi {
    public static List<HistoricoManutencao> gethistoricoManutencaos() {
        String json = ApiConnection.getData("historicoManutencao");
        List<HistoricoManutencao> historicoManutencaos = new ArrayList<>();

        if (json != null) {
            try {
                JSONArray jsonArray = new JSONArray(json);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    HistoricoManutencao historicoManutencao = new HistoricoManutencao(
                        jsonObject.getString("id"),
                        jsonObject.getLong("maquinaId"),
                        LocalDate.parse(jsonObject.getString("data")),
                        jsonObject.getString("tipo"),
                        jsonObject.getString("pecasTrocadas"),
                        jsonObject.getLong("tempoDeParada"),
                        jsonObject.getString("tecnicoId"),
                        jsonObject.getString("observacoes")
                    );
                    historicoManutencaos.add(historicoManutencao);
                }
            } catch (JSONException e) {
                System.err.println("Erro ao fazer parsing do JSON: " + e.getMessage());
            }
        } else {
            System.err.println("Resposta nula do servidor ao tentar obter histórico de manutenção.");
        }

        return historicoManutencaos;
    }

    public static HistoricoManutencao createHistoricoManutencao(HistoricoManutencao manutencao) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", manutencao.getId());
        jsonObject.put("maquinaId", manutencao.getMaquinaId());
        jsonObject.put("data", manutencao.getData().toString());
        jsonObject.put("tipo", manutencao.getTipo());
        jsonObject.put("pecasTrocadas", manutencao.getPecasTrocadas());
        jsonObject.put("tempoDeParada", manutencao.getTempoDeParada());
        jsonObject.put("tecnicoId", manutencao.getTecnicoId());
        jsonObject.put("observacoes", manutencao.getObservacoes());

        String jsonResponse = ApiConnection.postData("historicoManutencao", jsonObject.toString());
        if (jsonResponse != null) {
            return manutencao; // Aqui você pode processar a resposta e retornar o novo histórico, se necessário
        } else {
            System.err.println("Erro ao criar histórico de manutenção: resposta nula do servidor.");
        }
        return null;
    }

    public static HistoricoManutencao updateHistoricoManutencao(HistoricoManutencao manutencao) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", manutencao.getId());
        jsonObject.put("maquinaId", manutencao.getMaquinaId());
        jsonObject.put("data", manutencao.getData().toString());
        jsonObject.put("tipo", manutencao.getTipo());
        jsonObject.put("pecasTrocadas", manutencao.getPecasTrocadas());
        jsonObject.put("tempoDeParada", manutencao.getTempoDeParada());
        jsonObject.put("tecnicoId", manutencao.getTecnicoId());
        jsonObject.put("observacoes", manutencao.getObservacoes());

        String jsonResponse = ApiConnection.putData("historicoManutencao/" + manutencao.getId(), jsonObject.toString());
        if (jsonResponse != null) {
            return manutencao; // Aqui você pode processar a resposta e retornar o histórico atualizado, se necessário
        } else {
            System.err.println("Erro ao atualizar histórico de manutenção: resposta nula do servidor.");
        }
        return null;
    }
}
