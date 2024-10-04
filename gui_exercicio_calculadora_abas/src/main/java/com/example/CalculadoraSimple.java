package com.example;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculadoraSimple extends JPanel {
    JTextField displaySimples;
    String[] botoes = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "+", "=" };

    public CalculadoraSimple() {
        super(new BorderLayout());
        displaySimples = new JTextField("0");
        displaySimples.setHorizontalAlignment(JTextField.RIGHT);
        displaySimples.setEditable(false);
        this.add(displaySimples, BorderLayout.NORTH);
            //crir painel dendtro do painel
            
    JPanel painelBotoes = new JPanel(new GridLayout(4,4,3,3));
    for (String textBotoes : botoes) {
        JButton botao = new JButton(textBotoes);
//adicionar açao
        painelBotoes.add(botao);
    }
    this.add(painelBotoes, BorderLayout.CENTER);
    }

}
