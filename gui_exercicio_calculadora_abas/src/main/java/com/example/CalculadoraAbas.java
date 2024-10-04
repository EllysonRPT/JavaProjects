package com.example;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


public class CalculadoraAbas extends JFrame {
    //atributos


    //construct
public CalculadoraAbas() {
    super("Calculadora abas");
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setSize(300, 200);

    //ADICONAR COMPONENT
    JTabbedPane abas = new JTabbedPane();
    JPanel calcSimples = new CalculadoraSimple();
    abas.addTab("Simples", calcSimples);

    JPanel calcAvancada = new CalculadoraAvancada();
    abas.addTab("Avançada", calcAvancada);

    this.add(abas);
    this.setVisible(true);
}
}
