package com.example;

import java.awt.event.*;

import javax.swing.*;

/**
 * AdvancedActionListener
 */
public class AdvancedActionListener implements ActionListener {
    private double valorAtual;
    JPanel calcSimples = new CalculadoraSimple();

    @Override
    public void actionPerformed(ActionEvent e) {

        String comando = e.getActionCommand();
        String  operador;
        if (comando.matches("\\d")) {
calcSimples.setDisplaySimples(calcSimples.getDisplay()+comando);
        }else if (comando.matches("[+\\-*/]")){
            valorAtual = Double.parseDouble(displaySimples.getText());
            operador = comando;
            displaySimples.setText("");
        }else if (comando.equals("<")) {

            //swit case operador
             

        }
    }

}