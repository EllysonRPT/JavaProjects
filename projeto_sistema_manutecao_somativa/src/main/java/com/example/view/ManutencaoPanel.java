package com.example.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import com.example.controllers.HistoricoManutencaoController;
import com.example.models.HistoricoManutencao;

public class ManutencaoPanel extends JPanel {
    private HistoricoManutencaoController manutencaoController;
    private JTable manutencaoTable;
    private DefaultTableModel tableModel;

    public ManutencaoPanel() {
        super(new BorderLayout());
        manutencaoController = new HistoricoManutencaoController();

        // Modelo da tabela de manutenção
        tableModel = new DefaultTableModel(new Object[]{
                "Id", "Máquina Id", "Data", "Tipo", "Peças Trocadas", "Tempo de Parada", "Técnico Id", "Observações"
        }, 0);

        // Tabela de manutenção
        manutencaoTable = new JTable(tableModel);
        List<HistoricoManutencao> manutencoes = manutencaoController.readHistoricoManutencaos();
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
        JButton btnCriarManutencao = new JButton("Criar");
        JButton btnAlterarManutencao = new JButton("Alterar");
        JButton btnExportarRelatorio = new JButton("Exportar Relatório"); // Botão para exportar relatório

        painelInferior.add(btnCriarManutencao);
        painelInferior.add(btnAlterarManutencao);
        painelInferior.add(btnExportarRelatorio); // Adiciona o botão de relatório
        this.add(painelInferior, BorderLayout.SOUTH);

        // ActionListener para criar nova manutenção
        btnCriarManutencao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showManutencaoDialog(null);
            }
        });

        // ActionListener para alterar uma manutenção existente
        btnAlterarManutencao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = manutencaoTable.getSelectedRow();
                if (selectedRow >= 0) {
                    HistoricoManutencao manutencaoSelecionada = manutencaoController.readHistoricoManutencaos().get(selectedRow);
                    showManutencaoDialog(manutencaoSelecionada);
                } else {
                    JOptionPane.showMessageDialog(ManutencaoPanel.this, "Selecione uma linha para atualizar.");
                }
            }
        });

        // ActionListener para exportar o relatório em TXT
        btnExportarRelatorio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("relatorio_manutencao.txt"))) {
                    // Adicionar título ao arquivo TXT
                    writer.write("Relatório de Manutenção");
                    writer.newLine();
                    writer.write("=======================");
                    writer.newLine();

                    // Adicionar cabeçalhos
                    for (int i = 0; i < manutencaoTable.getColumnCount(); i++) {
                        writer.write(manutencaoTable.getColumnName(i) + "\t");
                    }
                    writer.newLine();

                    // Adicionar dados da tabela
                    for (int row = 0; row < manutencaoTable.getRowCount(); row++) {
                        for (int col = 0; col < manutencaoTable.getColumnCount(); col++) {
                            writer.write(manutencaoTable.getValueAt(row, col).toString() + "\t");
                        }
                        writer.newLine();
                    }

                    JOptionPane.showMessageDialog(ManutencaoPanel.this, "Relatório gerado com sucesso!");

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(ManutencaoPanel.this, "Erro ao gerar o relatório: " + ex.getMessage());
                }
            }
        });
    }

    // Método para exibir o diálogo de criação/edição de manutenção
    private void showManutencaoDialog(HistoricoManutencao manutencao) {
        JDialog dialog = new JDialog((Frame) null, manutencao == null ? "Criar Manutenção" : "Alterar Manutenção", true);
        dialog.setLayout(new GridLayout(0, 2));
        dialog.setSize(400, 300);

        JTextField txtId = new JTextField();
        JTextField txtMaquinaId = new JTextField();
        JTextField txtData = new JTextField(); // Campo de data
        JTextField txtTipo = new JTextField();
        JTextField txtPecasTrocadas = new JTextField();
        JTextField txtTempoDeParada = new JTextField();
        JTextField txtTecnicoId = new JTextField();
        JTextField txtObservacoes = new JTextField();

        if (manutencao != null) {
            txtId.setText(manutencao.getId());
            txtMaquinaId.setText(String.valueOf(manutencao.getMaquinaId()));
            txtData.setText(DateTimeFormatter.ofPattern("dd-MM-yyyy").format(manutencao.getData()));
            txtTipo.setText(manutencao.getTipo());
            txtPecasTrocadas.setText(manutencao.getPecasTrocadas());
            txtTempoDeParada.setText(String.valueOf(manutencao.getTempoDeParada()));
            txtTecnicoId.setText(manutencao.getTecnicoId());
            txtObservacoes.setText(manutencao.getObservacoes());
        }

        dialog.add(new JLabel("ID:"));
        dialog.add(txtId);
        dialog.add(new JLabel("Máquina ID:"));
        dialog.add(txtMaquinaId);
        dialog.add(new JLabel("Data (DD-MM-YYYY):"));
        dialog.add(txtData);
        dialog.add(new JLabel("Tipo:"));
        dialog.add(txtTipo);
        dialog.add(new JLabel("Peças Trocadas:"));
        dialog.add(txtPecasTrocadas);
        dialog.add(new JLabel("Tempo de Parada:"));
        dialog.add(txtTempoDeParada);
        dialog.add(new JLabel("Técnico ID:"));
        dialog.add(txtTecnicoId);
        dialog.add(new JLabel("Observações:"));
        dialog.add(txtObservacoes);

        JButton btnConfirmar = new JButton(manutencao == null ? "Criar" : "Alterar");
        JButton btnCancelar = new JButton("Cancelar");

        btnConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Facilitar a entrada de data
                    LocalDate data = null;
                    try {
                        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                        data = LocalDate.parse(txtData.getText(), formatterDate);
                    } catch (DateTimeParseException ex) {
                        JOptionPane.showMessageDialog(dialog, "Data inválida. Tente novamente.");
                        return;
                    }

                    if (manutencao == null) {
                        // Criar nova manutenção
                        HistoricoManutencao novaManutencao = new HistoricoManutencao(
                                txtId.getText(),
                                Long.parseLong(txtMaquinaId.getText()),
                                data,
                                txtTipo.getText(),
                                txtPecasTrocadas.getText(),
                                Long.parseLong(txtTempoDeParada.getText()),
                                txtTecnicoId.getText(),
                                txtObservacoes.getText()
                        );

                        manutencaoController.addHistoricoManutencao(novaManutencao);

                        tableModel.addRow(new Object[]{
                                novaManutencao.getId(),
                                novaManutencao.getMaquinaId(),
                                novaManutencao.getData(),
                                novaManutencao.getTipo(),
                                novaManutencao.getPecasTrocadas(),
                                novaManutencao.getTempoDeParada(),
                                novaManutencao.getTecnicoId(),
                                novaManutencao.getObservacoes()
                        });
                    } else {
                        // Atualizar manutenção existente
                        manutencao.setMaquinaId(Long.parseLong(txtMaquinaId.getText()));
                        manutencao.setData(data);
                        manutencao.setTipo(txtTipo.getText());
                        manutencao.setPecasTrocadas(txtPecasTrocadas.getText());
                        manutencao.setTempoDeParada(Long.parseLong(txtTempoDeParada.getText()));
                        manutencao.setTecnicoId(txtTecnicoId.getText());
                        manutencao.setObservacoes(txtObservacoes.getText());

                        manutencaoController.updateHistoricoManutencao(manutencao.getId(),manutencao);

                        int selectedRow = manutencaoTable.getSelectedRow();
                        tableModel.setValueAt(manutencao.getMaquinaId(), selectedRow, 1);
                        tableModel.setValueAt(manutencao.getData(), selectedRow, 2);
                        tableModel.setValueAt(manutencao.getTipo(), selectedRow, 3);
                        tableModel.setValueAt(manutencao.getPecasTrocadas(), selectedRow, 4);
                        tableModel.setValueAt(manutencao.getTempoDeParada(), selectedRow, 5);
                        tableModel.setValueAt(manutencao.getTecnicoId(), selectedRow, 6);
                        tableModel.setValueAt(manutencao.getObservacoes(), selectedRow, 7);
                    }

                    dialog.dispose();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(dialog, "Erro ao salvar manutenção: " + ex.getMessage());
                }
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });

        dialog.add(btnConfirmar);
        dialog.add(btnCancelar);
        dialog.setVisible(true);
    }
}
