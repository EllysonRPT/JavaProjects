package com.example;

public class Eletronico extends Produto {
//atributo

    private double peso;
//construtor

    public Eletronico(String nome, double peso, double preco) {
        super();
        this.peso=peso;
        this.preco=preco;

    }

    public double calcularFrete() {
        return 0;
    }
}
