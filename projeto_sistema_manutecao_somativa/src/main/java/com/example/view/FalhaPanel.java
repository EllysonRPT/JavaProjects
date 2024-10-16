package com.example.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import com.example.controllers.FalhaController;
import com.example.models.Falha;

import java.util.List;

public class FalhaPanel extends JPanel {
    private FalhaController falhaController;
    private JTable falhaTable;
    private DefaultTableModel tableModel;
    private JButton btnCadastrarFalha;
    private JButton btnSalvarAlteracao;

    public FalhaPanel() {
        super(new BorderLayout());
        falhaController = new FalhaController();

        tableModel = new DefaultTableModel(new Object[]{
                "Id", "Máquina Id", "Data", "Problema", "Prioridade", "Operador"
        }, 0);

        falhaTable = new JTable(tableModel);
        List<Falha> falhas = falhaController.readFalhas();
        for (Falha falha : falhas) {
            tableModel.addRow(new Object[]{
                    falha.getId(),
                    falha.getMaquinaId(),
                    falha.getData(),
                    falha.getProblema(),
                    falha.getPrioridade(),
                    falha.getOperador()
            });
        }

        JScrollPane scrollPane = new JScrollPane(falhaTable);
        this.add(scrollPane, BorderLayout.CENTER);
        
        JPanel painelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnCadastrarFalha = new JButton("Cadastrar");
        btnSalvarAlteracao = new JButton("Salvar");
        
        painelInferior.add(btnSalvarAlteracao);
        painelInferior.add(btnCadastrarFalha);
        this.add(painelInferior, BorderLayout.SOUTH);
        
        // Criar ActionListeners
    }
}
