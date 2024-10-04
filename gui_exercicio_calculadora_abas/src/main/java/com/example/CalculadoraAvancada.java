package com.example;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculadoraAvancada extends JPanel {
    JTextField displaySimples;
    String[] botoes = {
            "^", "sqrt", "log", "!",
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "+", "=" };

    public CalculadoraAvancada() {
        super(new BorderLayout());
        displaySimples = new JTextField("0");
        displaySimples.setHorizontalAlignment(JTextField.RIGHT);
        displaySimples.setEditable(false);
        this.add(displaySimples, BorderLayout.NORTH);
            //crir painel dendtro do painel
    JPanel painelBotoes = new JPanel(new GridLayout(5,4,3,3));
    for (String textBotoes : botoes) {
        JButton botao = new JButton(textBotoes);
//adicionar açao
        painelBotoes.add(botao);
    }
    this.add(painelBotoes, BorderLayout.CENTER);
    }

}
