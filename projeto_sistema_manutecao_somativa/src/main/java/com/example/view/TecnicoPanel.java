package com.example.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import com.example.controllers.TecnicoController;
import com.example.models.Tecnico;

import java.util.List;

public class TecnicoPanel extends JPanel {
    private TecnicoController tecnicoController;
    private JTable tecnicoTable;
    private DefaultTableModel tableModel;
    private JButton btnCadastrarTecnico;
    private JButton btnSalvarAlteracao;

    public TecnicoPanel() {
        super(new BorderLayout());
        tecnicoController = new TecnicoController();

        tableModel = new DefaultTableModel(new Object[]{
                "Id", "Nome", "Especialidade", "Disponibilidade"
        }, 0);

        tecnicoTable = new JTable(tableModel);
        List<Tecnico> tecnicos = tecnicoController.readTecnicos();
        for (Tecnico tecnico : tecnicos) {
            tableModel.addRow(new Object[]{
                    tecnico.getId(),
                    tecnico.getNome(),
                    tecnico.getEspecialidade(),
                    tecnico.getDisponibilidade()
            });
        }

        JScrollPane scrollPane = new JScrollPane(tecnicoTable);
        this.add(scrollPane, BorderLayout.CENTER);
        
        JPanel painelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnCadastrarTecnico = new JButton("Cadastrar");
        btnSalvarAlteracao = new JButton("Salvar");
        
        painelInferior.add(btnSalvarAlteracao);
        painelInferior.add(btnCadastrarTecnico);
        this.add(painelInferior, BorderLayout.SOUTH);
        
        // Criar ActionListeners
    }
}
