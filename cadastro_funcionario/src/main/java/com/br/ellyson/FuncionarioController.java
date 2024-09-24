package com.br.ellyson;
//controller

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class FuncionarioController {

    private List<Funcionario> funcionarios = new ArrayList<>();

    // private Funcionario [] funcionarios;
    FuncionarioController() {

        funcionarios = new ArrayList<>();
    }

    public void addFuncionario() {
        String nome = JOptionPane.showInputDialog("Digite o Nome do Funcionario");
        int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade"));
        double salario = Double.parseDouble(JOptionPane.showInputDialog("Digite o salario"));
        Funcionario funcionario = new Funcionario(nome, idade, idade);
        funcionarios.add(funcionario);  // Use o método add() para adicionar à ArrayList

    }

    public void removerContato() {

    }

    public void listarTodos() {

        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario.toString());

        }
    }

    public void buscarFuncionario() {
        String nome = JOptionPane.showInputDialog("Digite o Nome do Funcionario a ser procurado");

        try {
            boolean encontrado = false;
            for (Funcionario funcionario : funcionarios) {
                if (funcionario.getNome().equalsIgnoreCase(nome)) {
                    System.out.println(funcionario.toString());
                    encontrado = true;
                }

            }
            if (!encontrado) {
                throw new Exception("Funcionario não Encontrado");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //deletar
    public void deletarFuncionario() {
        String nome = JOptionPane.showInputDialog("Digite o Nome do Funcionario a ser Deletado");

        try {
            boolean encontrado = false;
            for (Funcionario funcionario : funcionarios) {
                if (funcionario.getNome().equalsIgnoreCase(nome)) {
                    funcionarios.remove(funcionario);
                    encontrado = true;
                    System.out.println("funcionario removido");
                    break;
                }

            }
            if (!encontrado) {
                throw new Exception("Funcionario não Encontrado");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //calculo de media salarial
    public void calculoMediaSalario() {
        double mediaSalarios = 0;
//se for vazia
        if (funcionarios.size() == 0) {
            System.out.println("lista vazia");
        } else {
            for (Funcionario funcionario : funcionarios) {
                mediaSalarios += funcionario.getSalario();
            }
        }
        mediaSalarios /= funcionarios.size();
        System.out.println("Media de salarios é " + mediaSalarios);
    }

}
