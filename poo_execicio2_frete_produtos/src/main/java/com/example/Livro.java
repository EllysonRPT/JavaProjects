package com.example;

public class Livro extends  Produto implements Transportavel{
    double volume;
    
    public Livro() {
        super();
    }
    
    @Override
    public double calcularPeso() {
        double peso = volume * 1.2;
        return peso;
    }
@Override
    public double calcularFrete() {
       double valorFrete = calcularPeso()*3;
       return valorFrete;
    };    
}
