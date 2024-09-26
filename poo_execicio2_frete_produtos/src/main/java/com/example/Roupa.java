package com.example;

public class Roupa extends   Produto implements Transportavel{
    private  double volume;

public Roupa(String nome,double preco) {
    super(nome,preco);
    this.volume=volume;
}
   
    @Override
    public double calcularPeso() {
        double peso = volume * 0.7;
        return peso;
    }
@Override
    public double calcularFrete() {
       double valorFrete = calcularPeso()*4;
       return valorFrete;
    };    

}
