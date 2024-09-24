package com.br.ellyson;
//model

public class Funcionario {

    private String nome;
    private int idade;
    private int salario;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public Funcionario(String nome, int idade, int salario) {
        this.nome = nome;
        this.idade = idade;
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", idade: " + idade + " ,salario: " + salario;
    }

}
