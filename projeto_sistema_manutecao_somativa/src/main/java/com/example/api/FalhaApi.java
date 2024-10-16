package com.example.api;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.example.models.Falha;

public class FalhaApi {
    public static List<Falha> getfalhas() {
        String json = ApiConnection.getData("falhas");
        List<Falha> falhas = new ArrayList<>();

        if (json != null) {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Falha falha = new Falha(
                    jsonObject.getString("id"),
                    jsonObject.getLong("maquinaId"),
                    LocalDate.parse(jsonObject.getString("data")),
                    jsonObject.getString("problema"),
                    jsonObject.getString("prioridade"),
                    jsonObject.getString("operador")
                );
                falhas.add(falha);
            }
        }
        return falhas;
    }
    public static Falha createFalha(Falha falha) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", falha.getId());
        jsonObject.put("maquinaId", falha.getMaquinaId());
        jsonObject.put("data", falha.getData().toString());
        jsonObject.put("problema", falha.getProblema());
        jsonObject.put("prioridade", falha.getPrioridade());
        jsonObject.put("operador", falha.getOperador());
    
        String jsonResponse = ApiConnection.postData("falhas", jsonObject.toString());
        if (jsonResponse != null) {
            // Aqui você pode processar a resposta e retornar a nova falha, se necessário
            return falha; // Ou um novo objeto baseado na resposta
        }
        return null;
    }
    public static Falha updateFalha(Falha falha) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", falha.getId());
        jsonObject.put("maquinaId", falha.getMaquinaId());
        jsonObject.put("data", falha.getData().toString());
        jsonObject.put("problema", falha.getProblema());
        jsonObject.put("prioridade", falha.getPrioridade());
        jsonObject.put("operador", falha.getOperador());
    
        String jsonResponse = ApiConnection.putData("falhas/" + falha.getId(), jsonObject.toString());
        if (jsonResponse != null) {
            // Aqui você pode processar a resposta e retornar a falha atualizada, se necessário
            return falha; // Ou um novo objeto baseado na resposta
        }
        return null;
    }
    
  
}
