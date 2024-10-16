package com.example.api;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.example.models.Tecnico;

public class TecnicoApi {
     public static List<Tecnico> gettecnicos() {
        String json = ApiConnection.getData("tecnicos");
        List<Tecnico> tecnicos = new ArrayList<>();


        if (json != null) {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Tecnico tecnico = new Tecnico(
                    jsonObject.getString("id"),
                    jsonObject.getString("nome"),
                    jsonObject.getString("especialidade"),
                    jsonObject.getString("disponibilidade")
                    
                );
                tecnicos.add(tecnico);
            }
        }
        return tecnicos;
    }
    public static Tecnico createTecnico(Tecnico tecnico) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", tecnico.getId());
        jsonObject.put("nome", tecnico.getNome());
        jsonObject.put("especialidade", tecnico.getEspecialidade());
        jsonObject.put("disponibilidade", tecnico.getDisponibilidade());
    
        String jsonResponse = ApiConnection.postData("tecnicos", jsonObject.toString());
        if (jsonResponse != null) {
            // Aqui você pode processar a resposta e retornar o novo técnico, se necessário
            return tecnico; // Ou um novo objeto baseado na resposta
        }
        return null;
    }
    public static Tecnico updateTecnico(Tecnico tecnico) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", tecnico.getId());
        jsonObject.put("nome", tecnico.getNome());
        jsonObject.put("especialidade", tecnico.getEspecialidade());
        jsonObject.put("disponibilidade", tecnico.getDisponibilidade());
    
        String jsonResponse = ApiConnection.putData("tecnicos/" + tecnico.getId(), jsonObject.toString());
        if (jsonResponse != null) {
            // Aqui você pode processar a resposta e retornar o técnico atualizado, se necessário
            return tecnico; // Ou um novo objeto baseado na resposta
        }
        return null;
    }
    
    public static boolean deleteTecnico(String tecnicoId) {
        String jsonResponse = ApiConnection.deleteData("tecnicos/" + tecnicoId);
        return jsonResponse != null; // Retorna verdadeiro se a exclusão foi bem-sucedida
    }
    
}
