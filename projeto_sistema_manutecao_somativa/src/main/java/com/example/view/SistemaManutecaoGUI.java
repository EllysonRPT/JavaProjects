package com.example.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.*;

import com.example.models.Falha;
import com.example.models.Tecnico;

import java.awt.*;

/**
 * SistemaManutecaoGUI
 */
public class SistemaManutecaoGUI extends JFrame {
    private JTabbedPane tabbedPanel;
    private JPanel painelManutencao;
    private JPanel painelMaquinas;
    private JPanel painelFalhas;
    private JPanel painelTecnicos;

    public SistemaManutecaoGUI() {
        // configuração
        super("SistemaManutecao");
        this.setSize(1000, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        // inicialiazação
        painelMaquinas = new MaquinasPanel();
        painelManutencao = new ManutencaoPanel();
        painelFalhas = new FalhaPanel();
        painelTecnicos = new TecnicoPanel();

        // tabbetPanel

        tabbedPanel = new JTabbedPane();
        tabbedPanel.add("Maquinas", painelMaquinas);
        tabbedPanel.add("Manutencaos", painelManutencao);
        tabbedPanel.add("Falhas", painelFalhas);
        tabbedPanel.add("Tecnicos", painelTecnicos);
        this.add(tabbedPanel, BorderLayout.CENTER);
        
    }
}