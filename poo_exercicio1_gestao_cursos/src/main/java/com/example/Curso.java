package com.example;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Curso {

    //atributos
    private String nomeCurso;
    private List<Aluno> alunos;
    private Professor professor;

    //construtor
    public Curso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
        alunos = new ArrayList<>();
    }
    //metodos 

    public void addProf(Professor professor) {
        this.professor = professor;
    }

    //metoo adicionar aluno
    public void addAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    //infos cursos
    public void infoCurso() {
        System.out.println("Curso" + nomeCurso + "Professor:" + professor.getNome());
        System.out.println("Alunos Matriculado: ");
        for (Aluno aluno : alunos) {
            System.out.println("Aluno: " + aluno.getNome() + "Matricula: " + aluno.getMatricula());
        }
    }

    //Lançar notas 
    public void atribuirNota() {
        if (alunos.size() == 0) {
            System.out.println("nenhum Aluno");
        } else {
            for (Aluno aluno : alunos) {
                double nota = Double.parseDouble(JOptionPane.showInputDialog("Nota do " + aluno.getNome() + " :"));
                aluno.setNota(nota);
            }
        }
    }

    //exibir resultado final
    public void exibirResultadoFinal() {
        for (Aluno aluno : alunos) {
            aluno.avaliarDesenpenho();
            aluno.exibirInfo();
        }
    }
}
