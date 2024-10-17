package com.example.view;

import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import com.example.api.MaquinaApi;
import com.example.controllers.MaquinaController;
import com.example.models.Maquina;

public class MaquinasPanel extends JPanel {
    private MaquinaController maquinaController;
    private JTable maquinasTable;
    private DefaultTableModel tableModel;
    private JButton btnAlterar;
    private JButton btnCadastrarMaquina;
    private JButton btnExcluir;

    public MaquinasPanel() {
        super(new BorderLayout());
        maquinaController = new MaquinaController();

        // Definição do modelo da tabela
        tableModel = new DefaultTableModel(new Object[]{
            "Id", "Código", "Nome", "Modelo", "Fabricante", "Data de Aquisição", "Tempo de Vida Estimado", "Localização", "Detalhes", "Manual"
        }, 0);

        maquinasTable = new JTable(tableModel);
        carregarMaquinas();

        JScrollPane scrollPane = new JScrollPane(maquinasTable);
        this.add(scrollPane, BorderLayout.CENTER);

        JPanel painelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnCadastrarMaquina = new JButton("Cadastrar");
        btnAlterar = new JButton("Alterar");
        btnExcluir = new JButton("Excluir");

        painelInferior.add(btnCadastrarMaquina);
        painelInferior.add(btnAlterar);
        painelInferior.add(btnExcluir);
        this.add(painelInferior, BorderLayout.SOUTH);

        // Action Listeners
        btnCadastrarMaquina.addActionListener(e -> cadastrarMaquina());
        btnAlterar.addActionListener(e -> salvarAlteracoes());
        btnExcluir.addActionListener(e -> excluirMaquina());
    }

    private void carregarMaquinas() {
        tableModel.setRowCount(0);
        List<Maquina> maquinas = maquinaController.readMaquinas();
        for (Maquina maquina : maquinas) {
            tableModel.addRow(new Object[]{
                maquina.getId(),
                maquina.getCodigo(),
                maquina.getNome(),
                maquina.getModelo(),
                maquina.getFabricante(),
                maquina.getDataAquisicao().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                maquina.getTempoVidaEstimado(),
                maquina.getLocalizacao(),
                maquina.getDetalhes(),
                maquina.getManual()
            });
        }
    }

    private void cadastrarMaquina() {
        JDialog dialog = new JDialog((Frame) null, "Inserir Máquina", true);
        dialog.setLayout(new GridLayout(11, 2));

        JLabel idLabel = new JLabel("Id:");
        JTextField idField = new JTextField();
        JLabel codigoLabel = new JLabel("Código:");
        JTextField codigoField = new JTextField();
        JLabel nomeLabel = new JLabel("Nome:");
        JTextField nomeField = new JTextField();
        JLabel modeloLabel = new JLabel("Modelo:");
        JTextField modeloField = new JTextField();
        JLabel fabricanteLabel = new JLabel("Fabricante:");
        JTextField fabricanteField = new JTextField();
        JLabel dataAquisicaoLabel = new JLabel("Data de Aquisição (dd-MM-yyyy):");
        JFormattedTextField dataAquisicaoField = createFormattedDateField();
        JLabel tempoVidaLabel = new JLabel("Tempo de Vida Estimado:");
        JTextField tempoVidaField = new JTextField();
        JLabel localizacaoLabel = new JLabel("Localização:");
        JTextField localizacaoField = new JTextField();
        JLabel detalhesLabel = new JLabel("Detalhes:");
        JTextField detalhesField = new JTextField();
        JLabel manualLabel = new JLabel("Manual:");
        JTextField manualField = new JTextField();

        JButton okButton = new JButton("OK");
        JButton cancelarButton = new JButton("Cancelar");

        dialog.add(idLabel);
        dialog.add(idField);
        dialog.add(codigoLabel);
        dialog.add(codigoField);
        dialog.add(nomeLabel);
        dialog.add(nomeField);
        dialog.add(modeloLabel);
        dialog.add(modeloField);
        dialog.add(fabricanteLabel);
        dialog.add(fabricanteField);
        dialog.add(dataAquisicaoLabel);
        dialog.add(dataAquisicaoField);
        dialog.add(tempoVidaLabel);
        dialog.add(tempoVidaField);
        dialog.add(localizacaoLabel);
        dialog.add(localizacaoField);
        dialog.add(detalhesLabel);
        dialog.add(detalhesField);
        dialog.add(manualLabel);
        dialog.add(manualField);
        dialog.add(okButton);
        dialog.add(cancelarButton);

        dialog.pack();
        dialog.setLocationRelativeTo(null);

        cancelarButton.addActionListener(e -> dialog.dispose());

        okButton.addActionListener(e -> {
            try {
                String idText = idField.getText();
                String codigo = codigoField.getText();
                String nome = nomeField.getText();
                String modelo = modeloField.getText();
                String fabricante = fabricanteField.getText();
                String dataAquisicaoText = dataAquisicaoField.getText();
                LocalDate dataAquisicao = LocalDate.parse(dataAquisicaoText, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                int tempoVidaEstimado = Integer.parseInt(tempoVidaField.getText());
                String localizacao = localizacaoField.getText();
                String detalhes = detalhesField.getText();
                String manual = manualField.getText();

                Maquina novaMaquina = new Maquina(idText, codigo, nome, modelo, fabricante, dataAquisicao, tempoVidaEstimado, localizacao, detalhes, manual);

                maquinaController.addMaquina(novaMaquina);
                MaquinaApi.createMaquina(novaMaquina);
                carregarMaquinas();
                dialog.dispose();
            } catch (DateTimeParseException dtpe) {
                JOptionPane.showMessageDialog(dialog, "Data de Aquisição inválida! Formato esperado: dd-MM-yyyy.", "Erro", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(dialog, "Valor inválido para o tempo de vida estimado! Por favor, insira um número.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        dialog.setVisible(true);
    }

    private void salvarAlteracoes() {
        int selectedRow = maquinasTable.getSelectedRow();
        if (selectedRow != -1) {
            JDialog dialog = new JDialog((Frame) null, "Alterar Máquina", true);
            dialog.setLayout(new GridLayout(11, 2));

            String id = tableModel.getValueAt(selectedRow, 0).toString();
            JTextField codigoField = new JTextField(tableModel.getValueAt(selectedRow, 1).toString());
            JTextField nomeField = new JTextField(tableModel.getValueAt(selectedRow, 2).toString());
            JTextField modeloField = new JTextField(tableModel.getValueAt(selectedRow, 3).toString());
            JTextField fabricanteField = new JTextField(tableModel.getValueAt(selectedRow, 4).toString());
            JTextField dataAquisicaoField = new JTextField(tableModel.getValueAt(selectedRow, 5).toString());
            JTextField tempoVidaField = new JTextField(tableModel.getValueAt(selectedRow, 6).toString());
            JTextField localizacaoField = new JTextField(tableModel.getValueAt(selectedRow, 7).toString());
            JTextField detalhesField = new JTextField(tableModel.getValueAt(selectedRow, 8).toString());
            JTextField manualField = new JTextField(tableModel.getValueAt(selectedRow, 9).toString());

            dialog.add(new JLabel("Id:"));
            dialog.add(new JLabel(id));
            dialog.add(new JLabel("Código:"));
            dialog.add(codigoField);
            dialog.add(new JLabel("Nome:"));
            dialog.add(nomeField);
            dialog.add(new JLabel("Modelo:"));
            dialog.add(modeloField);
            dialog.add(new JLabel("Fabricante:"));
            dialog.add(fabricanteField);
            dialog.add(new JLabel("Data de Aquisição (dd-MM-yyyy):"));
            dialog.add(dataAquisicaoField);
            dialog.add(new JLabel("Tempo de Vida Estimado:"));
            dialog.add(tempoVidaField);
            dialog.add(new JLabel("Localização:"));
            dialog.add(localizacaoField);
            dialog.add(new JLabel("Detalhes:"));
            dialog.add(detalhesField);
            dialog.add(new JLabel("Manual:"));
            dialog.add(manualField);

            JButton okButton = new JButton("OK");
            JButton cancelarButton = new JButton("Cancelar");

            dialog.add(okButton);
            dialog.add(cancelarButton);

            dialog.pack();
            dialog.setLocationRelativeTo(null);

            cancelarButton.addActionListener(e -> dialog.dispose());

            okButton.addActionListener(e -> {
                try {
                    String codigo = codigoField.getText();
                    String nome = nomeField.getText();
                    String modelo = modeloField.getText();
                    String fabricante = fabricanteField.getText();
                    String dataAquisicaoText = dataAquisicaoField.getText();
                    LocalDate dataAquisicao = LocalDate.parse(dataAquisicaoText, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                    int tempoVidaEstimado = Integer.parseInt(tempoVidaField.getText());
                    String localizacao = localizacaoField.getText();
                    String detalhes = detalhesField.getText();
                    String manual = manualField.getText();

                    Maquina maquinaAtualizada = new Maquina(id, codigo, nome, modelo, fabricante, dataAquisicao, tempoVidaEstimado, localizacao, detalhes, manual);

                    maquinaController.updateMaquina(selectedRow, maquinaAtualizada);
                    MaquinaApi.updateMaquina(maquinaAtualizada);
                    carregarMaquinas();
                    dialog.dispose();
                } catch (DateTimeParseException dtpe) {
                    JOptionPane.showMessageDialog(dialog, "Data de Aquisição inválida! Formato esperado: dd-MM-yyyy.", "Erro", JOptionPane.ERROR_MESSAGE);
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(dialog, "Valor inválido para o tempo de vida estimado! Por favor, insira um número.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            });

            dialog.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecione uma linha da tabela para alterar.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void excluirMaquina() {
        int selectedRow = maquinasTable.getSelectedRow();
        if (selectedRow != -1) {
            String id = tableModel.getValueAt(selectedRow, 0).toString();
            maquinaController.deleteMaquina(selectedRow);
            MaquinaApi.deleteMaquina(id);
            carregarMaquinas();
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecione uma linha da tabela para excluir.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    private JFormattedTextField createFormattedDateField() {
        JFormattedTextField formattedTextField = null;
        try {
            MaskFormatter maskFormatter = new MaskFormatter("##-##-####");
            maskFormatter.setPlaceholderCharacter('_');
            formattedTextField = new JFormattedTextField(maskFormatter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return formattedTextField;
    }
}
