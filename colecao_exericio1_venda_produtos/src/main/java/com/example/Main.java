package com.example;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        GerenciamentoVendas gv = new GerenciamentoVendas();
        String operacao = "0";
        Scanner sc = new Scanner(System.in);
        do {
            operacao = JOptionPane.showInputDialog("\n" + //
                    " --Agenda de Contatos --" +
                    "\n --Agenda de Contatos --" +
                    "1.  Adicionar contatos " +
                    "2.  vendas por Clientes " +
                    "3.  produtos Acima do Minimo" +
                    "4.  Sair ");
            switch (operacao) {
                case "1":
                    String cpf = JOptionPane.showInputDialog("INforme o cpf do ciente");
                    String nomeProduto = JOptionPane.showInputDialog("INforme o nome do do ciente");
                    double valorProduto = Double.parseDouble(JOptionPane.showInputDialog("INforme o valor "));
                   Produto produto = new Produto(nomeProduto,valorProduto);
                   gv.venda(cpf, produto);
                    break;
                    case "2":
                    String cpf2 = JOptionPane.showInputDialog("INforme o cpf do ciente");
                gv.produtosCliente(cpf2);
                    break;

                    case "3":
                    String cpf3 = JOptionPane.showInputDialog("INforme o cpf do ciente");
                    double valorMin = Double.parseDouble(JOptionPane.showInputDialog("INforme o valor Minimo "));
                    gv.produtosAcima(cpf3, valorMin);
                    break;


                default:
                System.out.println("Saindo ...");
                    break;
            }
        } while (operacao != "4");
    }
}