package br.com.ex5;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ContatoController agenda = new ContatoController(3);
        int operacao = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("\n --Agenda de Contatos --");
            System.out.println("1.  Adicionar contatos ");
            System.out.println("2.  lstar contatos ");
            System.out.println("3.  buscar contato pelo nome ");
            System.out.println("4.  deletar contato pelo nome ");
            System.out.println("5. sair ");
            try {
                operacao = sc.nextInt();
                switch (operacao) {
                    case 1:
                        try {
                            System.out.println("Nome");
                            String nome = sc.next();
                            System.out.println("Endereço");
                            String endereco = sc.next();
                            System.out.println("Email");
                            String email = sc.next();
                            System.out.println("telefone");
                            String telefone = sc.next();
                            Contato contato = new Contato(email, endereco, nome, telefone);
                            agenda.addContato(contato);
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        break;
                    case 2:
                        agenda.listarTodos();
                        break;
                    case 3:
                        try {
                            System.out.println("digite o nome a ser buscado ");
                            String nomeBusca = sc.next();
                            System.out.println(agenda.buscarContato(nomeBusca.toString()));

                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        break;
                    case 4:
                    try {
                        System.out.println("digite o nome a ser deletado ");
                        String nomeDeletar = sc.next();
                        agenda.removerContato(nomeDeletar);
                        System.out.println("contato deletado com sucesso");
                    } catch (Exception e) {
            System.out.println(e);
                     }
                        
                        break;
                    case 5:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("digite um numero valido");
                }
            } catch (Exception e) {
                System.out.println(e);
                System.out.println("digite um numero valido");
                break;

            }
        } while (operacao != 5);
        sc.close();
    }
}
