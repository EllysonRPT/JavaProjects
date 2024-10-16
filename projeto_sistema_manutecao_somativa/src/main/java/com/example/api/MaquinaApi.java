package com.example.api;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import org.*;
import org.json.JSONArray;
import org.json.JSONObject;

import com.example.models.Maquina;

public class MaquinaApi {
    

    public static List<Maquina> getMaquinas() {
        String json = ApiConnection.getData("maquinas");
        List<Maquina> maquinas = new ArrayList<>();


        if (json != null) {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Maquina maquina = new Maquina(
                    jsonObject.getString("id"),
                    jsonObject.getString("codigo"),
                    jsonObject.getString("nome"),
                    jsonObject.getString("modelo"),
                    jsonObject.getString("fabricante"),
                  LocalDate.parse(jsonObject.getString("dataAquisicao")),
                    jsonObject.getLong("tempoVidaEstimado"),
                    jsonObject.getString("localizacao"),
                    jsonObject.getString("detalhes"),
                    jsonObject.getString("manual")
                );
                maquinas.add(maquina);
            }
        }
        return maquinas;
    }
    public static Maquina createMaquina(Maquina maquina) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", maquina.getId());
        jsonObject.put("codigo", maquina.getCodigo());
        jsonObject.put("nome", maquina.getNome());
        jsonObject.put("modelo", maquina.getModelo());
        jsonObject.put("fabricante", maquina.getFabricante());
        jsonObject.put("dataAquisicao", maquina.getDataAquisicao().toString());
        jsonObject.put("tempoVidaEstimado", maquina.getTempoVidaEstimado());
        jsonObject.put("localizacao", maquina.getLocalizacao());
        jsonObject.put("detalhes", maquina.getDetalhes());
        jsonObject.put("manual", maquina.getManual());
    
        String jsonResponse = ApiConnection.postData("maquinas", jsonObject.toString());
        if (jsonResponse != null) {
            // Aqui você pode processar a resposta e retornar a nova máquina, se necessário
            return maquina; // Ou um novo objeto baseado na resposta
        }
        return null;
    }
    public static Maquina updateMaquina(Maquina maquina) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", maquina.getId());
        jsonObject.put("codigo", maquina.getCodigo());
        jsonObject.put("nome", maquina.getNome());
        jsonObject.put("modelo", maquina.getModelo());
        jsonObject.put("fabricante", maquina.getFabricante());
        jsonObject.put("dataAquisicao", maquina.getDataAquisicao().toString());
        jsonObject.put("tempoVidaEstimado", maquina.getTempoVidaEstimado());
        jsonObject.put("localizacao", maquina.getLocalizacao());
        jsonObject.put("detalhes", maquina.getDetalhes());
        jsonObject.put("manual", maquina.getManual());
    
        String jsonResponse = ApiConnection.putData("maquinas/" + maquina.getId(), jsonObject.toString());
        if (jsonResponse != null) {
            // Aqui você pode processar a resposta e retornar a máquina atualizada, se necessário
            return maquina; // Ou um novo objeto baseado na resposta
        }
        return null;
    }
    

}
