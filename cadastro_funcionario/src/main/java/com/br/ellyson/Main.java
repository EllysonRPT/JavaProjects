package com.br.ellyson;

import javax.swing.JOptionPane;
 
public class Main {

    public static void main(String[] args) {
        FuncionarioController gerenciaFuncionario = new FuncionarioController();
        int operacao = 0;
        do {
            operacao = Integer.parseInt(JOptionPane.showInputDialog("--- \n Gerenciamento de funcionario---"
                    + "\n 1-Adicionar Funcionario "
                    + " \n 2-Listar Funcionario "
                    + "\n  3-Buscar Funcionario "
                    + "\n 4-Remover Funcionario"
                    + "\n 5-Calcular a Média Salario "
                    + " \n 6-Sair "));
            switch (operacao) {
                case 1:
                    gerenciaFuncionario.addFuncionario();
                    break;
                case 2:
                    gerenciaFuncionario.listarTodos();
                    ;
                    break;
                case 3:
                    gerenciaFuncionario.buscarFuncionario();
                    ;
                    break;
                case 4:
                    gerenciaFuncionario.deletarFuncionario();
                    ;
                    break;
                case 5:
                    gerenciaFuncionario.calculoMediaSalario();
                    break;
                case 6:
                    System.out.println("saindo");
                    break;

                default:
                    break;
            }

        } while (operacao != 5);
    }
}
