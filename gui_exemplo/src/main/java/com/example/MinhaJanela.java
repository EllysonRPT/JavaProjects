package com.example;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MinhaJanela extends JFrame {
    public MinhaJanela() {
        super("SUPERMAN");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(400, 300);
//criando um painel(container generico)
        JPanel painel = new JPanel();
        this.add(painel);
      
    //adicionando botao
    JButton botao = new JButton("Clique aqui");
        painel.add(painel);
        //acao ao botao
        botao.addActionListener(e -> System.out.println("O botão foi simplificado!"));
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
          JOptionPane.showMessageDialog(null,"botao clicado");
            }
        });
        this.setVisible(true);
    }
    //adicionar um evento

}
