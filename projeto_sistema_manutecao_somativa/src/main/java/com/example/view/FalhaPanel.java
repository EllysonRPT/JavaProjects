package com.example.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import com.example.controllers.FalhaController;
import com.example.models.Falha;

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

        painelInferior.add(btnCadastrarFalha);
        painelInferior.add(btnSalvarAlteracao);
        this.add(painelInferior, BorderLayout.SOUTH);

        // Criar ActionListeners
        btnCadastrarFalha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showFalhaDialog(null);
            }
        });

        btnSalvarAlteracao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = falhaTable.getSelectedRow();
                if (selectedRow >= 0) {
                    Falha falhaSelecionada = falhaController.readFalhas().get(selectedRow);
                    showFalhaDialog(falhaSelecionada);
                } else {
                    JOptionPane.showMessageDialog(FalhaPanel.this, "Selecione uma linha para atualizar.");
                }
            }
        });
    }

    private void showFalhaDialog(Falha falha) {
        JDialog dialog = new JDialog((Frame) null, falha == null ? "Cadastrar Falha" : "Alterar Falha", true);
        dialog.setLayout(new GridLayout(0, 2));
        dialog.setSize(400, 300);

        JTextField txtId = new JTextField();
        JTextField txtMaquinaId = new JTextField();
        JFormattedTextField txtData = new JFormattedTextField(); // Usar JFormattedTextField para data
        JTextField txtProblema = new JTextField();
        JTextField txtPrioridade = new JTextField();
        JTextField txtOperador = new JTextField();

        if (falha != null) {
            txtId.setText(falha.getId());
            txtMaquinaId.setText(String.valueOf(falha.getMaquinaId()));
            txtData.setText(DateTimeFormatter.ofPattern("dd-MM-yyyy").format(falha.getData()));
            txtProblema.setText(falha.getProblema());
            txtPrioridade.setText(falha.getPrioridade());
            txtOperador.setText(falha.getOperador());
        }

        dialog.add(new JLabel("ID:"));
        dialog.add(txtId);
        dialog.add(new JLabel("Máquina ID:"));
        dialog.add(txtMaquinaId);
        dialog.add(new JLabel("Data (DD-MM-YYYY):"));
        dialog.add(txtData);
        dialog.add(new JLabel("Problema:"));
        dialog.add(txtProblema);
        dialog.add(new JLabel("Prioridade:"));
        dialog.add(txtPrioridade);
        dialog.add(new JLabel("Operador:"));
        dialog.add(txtOperador);

        JButton btnConfirmar = new JButton(falha == null ? "Cadastrar" : "Alterar");
        JButton btnCancelar = new JButton("Cancelar");

        btnConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    LocalDate data = null;
                    try {
                        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                        data = LocalDate.parse(txtData.getText(), formatterDate);
                    } catch (DateTimeParseException ex) {
                        JOptionPane.showMessageDialog(dialog, "Data inválida. Tente novamente.");
                        return;
                    }

                    if (falha == null) {
                        // Cadastrar nova falha
                        Falha falha = new Falha(
                                txtId.getText(),
                                Long.parseLong(txtMaquinaId.getText()),
                                data,
                                txtProblema.getText(),
                                txtPrioridade.getText(),
                                txtOperador.getText()
                        );

                        falhaController.addFalha(falha);
                        
                        tableModel.addRow(new Object[]{
                                falha.getId(),
                                falha.getMaquinaId(),
                                falha.getData(),
                                falha.getProblema(),
                                falha.getPrioridade(),
                                falha.getOperador()
                        });
                    } else {
                        // Atualizar falha existente
                        falha.setMaquinaId(Long.parseLong(txtMaquinaId.getText()));
                        falha.setData(data);
                        falha.setProblema(txtProblema.getText());
                        falha.setPrioridade(txtPrioridade.getText());
                        falha.setOperador(txtOperador.getText());

                        falhaController.updateFalha(falha);
                        
                        // Atualizar a tabela
                        int selectedRow = falhaTable.getSelectedRow();
                        tableModel.setValueAt(falha.getMaquinaId(), selectedRow, 1);
                        tableModel.setValueAt(falha.getData(), selectedRow, 2);
                        tableModel.setValueAt(falha.getProblema(), selectedRow, 3);
                        tableModel.setValueAt(falha.getPrioridade(), selectedRow, 4);
                        tableModel.setValueAt(falha.getOperador(), selectedRow, 5);
                    }

                    dialog.dispose();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(dialog, "Erro ao converter números. Verifique os campos numéricos.");
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
