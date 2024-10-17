package com.example.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import com.example.controllers.TecnicoController;
import com.example.models.Tecnico;

public class TecnicoPanel extends JPanel {
    private TecnicoController tecnicoController;
    private JTable tecnicoTable;
    private DefaultTableModel tableModel;
    private JButton btnCadastrarTecnico;
    private JButton btnSalvarAlteracao;
    private JButton btnExcluirTecnico;  // Novo botão de exclusão

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
        btnExcluirTecnico = new JButton("Excluir");  // Botão de exclusão adicionado

        painelInferior.add(btnCadastrarTecnico);
        painelInferior.add(btnSalvarAlteracao);
        painelInferior.add(btnExcluirTecnico);  // Botão de exclusão adicionado ao painel
        this.add(painelInferior, BorderLayout.SOUTH);

        // Criar ActionListeners
        btnCadastrarTecnico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showTecnicoDialog(null);
            }
        });

        btnSalvarAlteracao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tecnicoTable.getSelectedRow();
                if (selectedRow >= 0) {
                    Tecnico tecnicoSelecionado = tecnicoController.readTecnicos().get(selectedRow);
                    showTecnicoDialog(tecnicoSelecionado);
                } else {
                    JOptionPane.showMessageDialog(TecnicoPanel.this, "Selecione uma linha para atualizar.");
                }
            }
        });

        // ActionListener para excluir técnico
        btnExcluirTecnico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tecnicoTable.getSelectedRow();
                if (selectedRow >= 0) {
                    int confirm = JOptionPane.showConfirmDialog(
                        TecnicoPanel.this, 
                        "Tem certeza de que deseja excluir este técnico?", 
                        "Confirmação", 
                        JOptionPane.YES_NO_OPTION
                    );

                    if (confirm == JOptionPane.YES_OPTION) {
                        Tecnico tecnicoSelecionado = tecnicoController.readTecnicos().get(selectedRow);
                        tecnicoController.deleteTecnico(tecnicoSelecionado.getId());  // Chama o método de exclusão no controller
                        tableModel.removeRow(selectedRow);  // Remove a linha da tabela
                    }
                } else {
                    JOptionPane.showMessageDialog(TecnicoPanel.this, "Selecione uma linha para excluir.");
                }
            }
        });
    }

    private void showTecnicoDialog(Tecnico tecnico) {
        JDialog dialog = new JDialog((Frame) null, tecnico == null ? "Cadastrar Técnico" : "Alterar Técnico", true);
        dialog.setLayout(new GridLayout(0, 2));
        dialog.setSize(400, 300);

        JTextField txtId = new JTextField();
        JTextField txtNome = new JTextField();
        JTextField txtEspecialidade = new JTextField();
        JTextField txtDisponibilidade = new JTextField();

        if (tecnico != null) {
            txtId.setText(tecnico.getId());
            txtNome.setText(tecnico.getNome());
            txtEspecialidade.setText(tecnico.getEspecialidade());
            txtDisponibilidade.setText(tecnico.getDisponibilidade());
        }

        dialog.add(new JLabel("ID:"));
        dialog.add(txtId);
        dialog.add(new JLabel("Nome:"));
        dialog.add(txtNome);
        dialog.add(new JLabel("Especialidade:"));
        dialog.add(txtEspecialidade);
        dialog.add(new JLabel("Disponibilidade:"));
        dialog.add(txtDisponibilidade);

        JButton btnConfirmar = new JButton(tecnico == null ? "Cadastrar" : "Alterar");
        JButton btnCancelar = new JButton("Cancelar");

        btnConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (tecnico == null) {
                        // Cadastrar novo técnico
                        Tecnico novoTecnico = new Tecnico(
                                txtId.getText(),
                                txtNome.getText(),
                                txtEspecialidade.getText(),
                                txtDisponibilidade.getText()
                        );

                        tecnicoController.addTecnico(novoTecnico);
                        tableModel.addRow(new Object[]{
                                novoTecnico.getId(),
                                novoTecnico.getNome(),
                                novoTecnico.getEspecialidade(),
                                novoTecnico.getDisponibilidade()
                        });
                    } else {
                        // Atualizar técnico existente
                        tecnico.setNome(txtNome.getText());
                        tecnico.setEspecialidade(txtEspecialidade.getText());
                        tecnico.setDisponibilidade(txtDisponibilidade.getText());

                        tecnicoController.updateTecnico(tecnico);

                        // Atualizar a tabela
                        int selectedRow = tecnicoTable.getSelectedRow();
                        tableModel.setValueAt(tecnico.getNome(), selectedRow, 1);
                        tableModel.setValueAt(tecnico.getEspecialidade(), selectedRow, 2);
                        tableModel.setValueAt(tecnico.getDisponibilidade(), selectedRow, 3);
                    }

                    dialog.dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(dialog, "Erro ao salvar dados. Verifique os campos.");
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
