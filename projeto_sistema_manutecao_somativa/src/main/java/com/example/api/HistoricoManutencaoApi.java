package com.example.api;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.example.models.HistoricoManutencao;

public class HistoricoManutencaoApi {
     public static List<HistoricoManutencao> gethistoricoManutencaos() {
        String json = ApiConnection.getData("historicoManutencaos");
        List<HistoricoManutencao> historicoManutencaos = new ArrayList<>();


        if (json != null) {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                HistoricoManutencao historicoManutencao = new HistoricoManutencao(
                    jsonObject.getString("id"),
                    jsonObject.getLong("maquinaId"),
                    LocalDate.parse(jsonObject.getString("data")),
                    jsonObject.getString("tipo"),
                    jsonObject.getString("pecastrocadas"),
                    jsonObject.getLong("tempoDeParada"),
                    jsonObject.getString("tecnicoId"),
                    jsonObject.getString("observacoes")
                );
                historicoManutencaos.add(historicoManutencao);
            }
        }
        return historicoManutencaos;
    }
    public static HistoricoManutencao createHistoricoManutencao(HistoricoManutencao manutencao) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", manutencao.getId());
        jsonObject.put("maquinaId", manutencao.getMaquinaId());
        jsonObject.put("data", manutencao.getData().toString());
        jsonObject.put("tipo", manutencao.getTipo());
        jsonObject.put("pecastrocadas", manutencao.getPecasTrocadas());
        jsonObject.put("tempoDeParada", manutencao.getTempoDeParada());
        jsonObject.put("tecnicoId", manutencao.getTecnicoId());
        jsonObject.put("observacoes", manutencao.getObservacoes());
    
        String jsonResponse = ApiConnection.postData("historicoManutencaos", jsonObject.toString());
        if (jsonResponse != null) {
            // Aqui você pode processar a resposta e retornar o novo histórico, se necessário
            return manutencao; // Ou um novo objeto baseado na resposta
        }
        return null;
    }
    public static HistoricoManutencao updateHistoricoManutencao(HistoricoManutencao manutencao) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", manutencao.getId());
        jsonObject.put("maquinaId", manutencao.getMaquinaId());
        jsonObject.put("data", manutencao.getData().toString());
        jsonObject.put("tipo", manutencao.getTipo());
        jsonObject.put("pecastrocadas", manutencao.getPecasTrocadas());
        jsonObject.put("tempoDeParada", manutencao.getTempoDeParada());
        jsonObject.put("tecnicoId", manutencao.getTecnicoId());
        jsonObject.put("observacoes", manutencao.getObservacoes());
    
        String jsonResponse = ApiConnection.putData("historicoManutencaos/" + manutencao.getId(), jsonObject.toString());
        if (jsonResponse != null) {
            // Aqui você pode processar a resposta e retornar o histórico atualizado, se necessário
            return manutencao; // Ou um novo objeto baseado na resposta
        }
        return null;
    }
    
}
