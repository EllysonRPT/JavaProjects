package com.example;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {

        List<Curso> cursos;
        String operacao = "0";
        cursos = new ArrayList<>();

        do {
            operacao = JOptionPane.showInputDialog(
                    "\n --Gerenciamento de curso --\n"
                    + "1 - Criar Curso \n"
                    + "2 - Adicionar Professor \n"
                    + "3 - Adicionar Aluno \n"
                    + "4 - Informações do Curso \n"
                    + "5 - Atribuir Nota \n"
                    + "6 - Resultado Final \n"
                    + "7 - Sair \n"
            );

            switch (operacao) {
                case "1":
                    String nomeCurso = JOptionPane.showInputDialog("Insira  o nome do Curso : ");
                    cursos.add(new Curso(nomeCurso));
                    break;

                case "2":
                    String nomeCursoP = JOptionPane.showInputDialog("Insira  o nome do Professor : ");
                    for (Curso curso : cursos) {
                        if (curso.getNomeCurso().equalsIgnoreCase(nomeCursoP)) {
                            String nomeProf = JOptionPane.showInputDialog("Nome : ");
                            String cofProf = JOptionPane.showInputDialog("CPF : ");
                            double salario = Double.parseDouble(JOptionPane.showInputDialog("salario : "));
                            Professor professor = new Professor(nomeProf, cofProf, salario);
                            curso.addProf(professor);

                        }
                    }
                    break;
                case "3":
                    String nomeCursoA = JOptionPane.showInputDialog("Insira  o nome do Aluno: : ");
                    try {
                        boolean encontrado = false;
                        for (Curso curso : cursos) {
                            if (curso.getNomeCurso().equalsIgnoreCase(nomeCursoA)) {
                                encontrado = true;
                                boolean novoAluno = true;
                                do {
                                    String nomeAluno = JOptionPane.showInputDialog("Nome : ");
                                    String alunoCpf = JOptionPane.showInputDialog("CPF : ");
                                    String matricula = JOptionPane.showInputDialog("Matricula : ");
                                    curso.addAluno(new Aluno(nomeAluno, alunoCpf, matricula));
                                    novoAluno = JOptionPane.showInputDialog(
                                            "Inserir Novo Aluno?\n"
                                            + "1 - Sim\n"
                                            + "2 - Não").equals("1") ? true : false;
                                } while (encontrado);
                            }
                        }
                        if (!encontrado) {
                            throw new Exception("curso nao encontrado");
                        }
                    } catch (Exception e) {
                        System.out.println("Curso Nao Encontrado no catch" + e);
                    }
                    break;
                case "4":
                    String nomeCursoI = JOptionPane.showInputDialog("Insira  o nome do Curso: : ");
                    for (Curso curso : cursos) {
                        if (curso.getNomeCurso().equalsIgnoreCase(nomeCursoI)) {
                            curso.infoCurso();
                            continue;
                        }
                    }
                    System.out.println("Curso Não encontrado ");
                    break;
                case "5":
                    String nomeCursoN = JOptionPane.showInputDialog("Insira  o nome do Curso: : ");
                    try {
                        boolean encontrado2 = false;

                        for (Curso curso : cursos) {
                            if (curso.getNomeCurso().equalsIgnoreCase(nomeCursoN)) {
                                curso.atribuirNota();
                                encontrado2 = true;
                            }
                        }
                        if (!encontrado2) {
                            throw new Exception("Curso nao encontrado");
                        }
                    } catch (Exception e) {

                    }

                    break;
                case "6":
                    String nomeCursoR = JOptionPane.showInputDialog("Insira  o nome do Curso: : ");
                    try {
                        boolean encontrado3 = false;

                        for (Curso curso : cursos) {
                            if (curso.getNomeCurso().equalsIgnoreCase(nomeCursoR)) {
                                curso.exibirResultadoFinal();
                                encontrado3 = true;

                            }
                            if (!encontrado3) {
                                throw new Exception("Curso Nao encontrado");
                            }
                        }
                    } catch (Exception e) {
                System.out.println("Curso nao encontrado");
                    }

                    break;
        case "7":
        System.out.println("saindo");
        break;
                    default:
        System.out.println("Digite Algo valido");
            
                    break;
            }  
       
        } while (operacao != "7");
    }
}
