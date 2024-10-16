package com.example.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import com.example.controllers.ManutencaoController;
import com.example.models.HistoricoManutencao;

import java.util.List;

public class ManutencaoPanel extends JPanel {
    private ManutencaoController manutencaoController;
    private JTable manutencaoTable;
    private DefaultTableModel tableModel;
    private JButton btnCadastrarManutencao;
    private JButton btnSalvarAlteracao;

    public ManutencaoPanel() {
        super(new BorderLayout());
        manutencaoController = new ManutencaoController();

        tableModel = new DefaultTableModel(new Object[]{
                "Id", "Máquina Id", "Data", "Tipo", "Pecas Trocadas", "Tempo de Parada", "Técnico Id", "Observações"
        }, 0);

        manutencaoTable = new JTable(tableModel);
        List<HistoricoManutencao> manutencoes = manutencaoController.readManutencoes();
        for (HistoricoManutencao manutencao : manutencoes) {
            tableModel.addRow(new Object[]{
                    manutencao.getId(),
                    manutencao.getMaquinaId(),
                    manutencao.getData(),
                    manutencao.getTipo(),
                    manutencao.getPecasTrocadas(),
                    manutencao.getTempoDeParada(),
                    manutencao.getTecnicoId(),
                    manutencao.getObservacoes()
            });
        }

        JScrollPane scrollPane = new JScrollPane(manutencaoTable);
        this.add(scrollPane, BorderLayout.CENTER);
        
        JPanel painelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnCadastrarManutencao = new JButton("Cadastrar");
        btnSalvarAlteracao = new JButton("Salvar");
        
        painelInferior.add(btnSalvarAlteracao);
        painelInferior.add(btnCadastrarManutencao);
        this.add(painelInferior, BorderLayout.SOUTH);
        
        // Criar ActionListeners
    }
}
