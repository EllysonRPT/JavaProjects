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
        btnAlterar = new JButton("Alterar"); // Renomeado

        painelInferior.add(btnCadastrarMaquina);
        painelInferior.add(btnAlterar); // Adicionado botão "Alterar"
        this.add(painelInferior, BorderLayout.SOUTH);

        // Action Listeners
        btnCadastrarMaquina.addActionListener(e -> cadastrarMaquina());
        btnAlterar.addActionListener(e -> salvarAlteracoes());
    }

    private void carregarMaquinas() {
        tableModel.setRowCount(0); // Limpa a tabela antes de carregar
        List<Maquina> maquinas = maquinaController.readMaquinas();
        for (Maquina maquina : maquinas) {
            tableModel.addRow(new Object[]{
                maquina.getId(),
                maquina.getCodigo(),
                maquina.getNome(),
                maquina.getModelo(),
                maquina.getFabricante(),
                maquina.getDataAquisicao().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), // Formatação da data
                maquina.getTempoVidaEstimado(),
                maquina.getLocalizacao(),
                maquina.getDetalhes(),
                maquina.getManual()
            });
        }
    }

    private void cadastrarMaquina() {
        // Exibe o JDialog para inserir os dados
        JDialog dialog = new JDialog((Frame) null, "Inserir Máquina", true);
        dialog.setLayout(new GridLayout(11, 2)); // Aumentado para 11 linhas

        // Criar campos de texto e rótulos
        JLabel idLabel = new JLabel("Id:");
        JTextField idField = new JTextField(); // Novo campo para ID
        JLabel codigoLabel = new JLabel("Código:");
        JTextField codigoField = new JTextField();
        JLabel nomeLabel = new JLabel("Nome:");
        JTextField nomeField = new JTextField();
        JLabel modeloLabel = new JLabel("Modelo:");
        JTextField modeloField = new JTextField();
        JLabel fabricanteLabel = new JLabel("Fabricante:");
        JTextField fabricanteField = new JTextField();
        JLabel dataAquisicaoLabel = new JLabel("Data de Aquisição (dd-MM-yyyy):");
        JFormattedTextField dataAquisicaoField = createFormattedDateField(); // Campo formatado para a data
        JLabel tempoVidaLabel = new JLabel("Tempo de Vida Estimado:");
        JTextField tempoVidaField = new JTextField();
        JLabel localizacaoLabel = new JLabel("Localização:");
        JTextField localizacaoField = new JTextField();
        JLabel detalhesLabel = new JLabel("Detalhes:");
        JTextField detalhesField = new JTextField();
        JLabel manualLabel = new JLabel("Manual:");
        JTextField manualField = new JTextField();

        // Botões de ação
        JButton okButton = new JButton("OK");
        JButton cancelarButton = new JButton("Cancelar");

        // Adicionar componentes ao diálogo
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

        // Ação do botão "Cancelar"
        cancelarButton.addActionListener(e -> dialog.dispose());

        // Ação do botão "OK"
        okButton.addActionListener(e -> {
            try {
                // Coletar dados dos campos
                String idText = idField.getText(); // Obter ID
                String codigo = codigoField.getText();
                String nome = nomeField.getText();
                String modelo = modeloField.getText();
                String fabricante = fabricanteField.getText();
                String dataAquisicaoText = dataAquisicaoField.getText();
                
                // Converter a data usando o formato dd-MM-yyyy
                LocalDate dataAquisicao = LocalDate.parse(dataAquisicaoText, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                
                int tempoVidaEstimado = Integer.parseInt(tempoVidaField.getText());
                String localizacao = localizacaoField.getText();
                String detalhes = detalhesField.getText();
                String manual = manualField.getText();

                // Criar uma nova máquina com os dados coletados
                Maquina novaMaquina = new Maquina(
                    idText, codigo, nome, modelo, fabricante, dataAquisicao, tempoVidaEstimado, localizacao, detalhes, manual
                );

                // Adicionar a máquina ao controlador
                maquinaController.addMaquina(novaMaquina);
                MaquinaApi.createMaquina(novaMaquina);

                // Recarregar a tabela
                carregarMaquinas();

                // Fechar o diálogo
                dialog.dispose();
            } catch (DateTimeParseException dtpe) {
                JOptionPane.showMessageDialog(dialog, "Data de Aquisição inválida! Formato esperado: dd-MM-yyyy.", "Erro", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(dialog, "Valor inválido para o tempo de vida estimado! Por favor, insira um número.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        dialog.setVisible(true);
    }

    // Método para criar um JFormattedTextField para entrada de data
    private JFormattedTextField createFormattedDateField() {
        try {
            MaskFormatter dateFormatter = new MaskFormatter("##-##-####");
            dateFormatter.setPlaceholderCharacter('_');
            return new JFormattedTextField(dateFormatter);
        } catch (Exception e) {
            e.printStackTrace();
            return new JFormattedTextField();
        }
    }

    private void salvarAlteracoes() {
        int selectedRow = maquinasTable.getSelectedRow();
        if (selectedRow != -1) {
            // Exibe o JDialog para editar os dados
            JDialog dialog = new JDialog((Frame) null, "Atualizar Máquina", true);
            dialog.setLayout(new GridLayout(11, 2)); // Aumentado para 11 linhas

            // Obter a máquina selecionada
            Maquina maquinaSelecionada = maquinaController.readMaquinas().get(selectedRow);

            // Criar campos de texto e rótulos
            JLabel idLabel = new JLabel("Id:");
            JTextField idField = new JTextField(maquinaSelecionada.getId()); // Pré-preencher ID
            idField.setEditable(false); // Não permite edição do ID
            JLabel codigoLabel = new JLabel("Código:");
            JTextField codigoField = new JTextField(maquinaSelecionada.getCodigo());
            JLabel nomeLabel = new JLabel("Nome:");
            JTextField nomeField = new JTextField(maquinaSelecionada.getNome());
            JLabel modeloLabel = new JLabel("Modelo:");
            JTextField modeloField = new JTextField(maquinaSelecionada.getModelo());
            JLabel fabricanteLabel = new JLabel("Fabricante:");
            JTextField fabricanteField = new JTextField(maquinaSelecionada.getFabricante());
            JLabel dataAquisicaoLabel = new JLabel("Data de Aquisição (dd-MM-yyyy):");
            JFormattedTextField dataAquisicaoField = createFormattedDateField(); // Campo formatado para a data
            dataAquisicaoField.setText(maquinaSelecionada.getDataAquisicao().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))); // Pré-preencher a data
            JLabel tempoVidaLabel = new JLabel("Tempo de Vida Estimado:");
            JTextField tempoVidaField = new JTextField(String.valueOf(maquinaSelecionada.getTempoVidaEstimado()));
            JLabel localizacaoLabel = new JLabel("Localização:");
            JTextField localizacaoField = new JTextField(maquinaSelecionada.getLocalizacao());
            JLabel detalhesLabel = new JLabel("Detalhes:");
            JTextField detalhesField = new JTextField(maquinaSelecionada.getDetalhes());
            JLabel manualLabel = new JLabel("Manual:");
            JTextField manualField = new JTextField(maquinaSelecionada.getManual());

            // Botões de ação
            JButton okButton = new JButton("OK");
            JButton cancelarButton = new JButton("Cancelar");

            // Adicionar componentes ao diálogo
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

            // Ação do botão "Cancelar"
            cancelarButton.addActionListener(e -> dialog.dispose());

            // Ação do botão "OK"
            okButton.addActionListener(e -> {
                try {
                    // Coletar dados dos campos
                    String idText = idField.getText(); // Obter ID
                    String codigo = codigoField.getText();
                    String nome = nomeField.getText();
                    String modelo = modeloField.getText();
                    String fabricante = fabricanteField.getText();
                    String dataAquisicaoText = dataAquisicaoField.getText();
                    
                    // Converter a data usando o formato dd-MM-yyyy
                    LocalDate dataAquisicao = LocalDate.parse(dataAquisicaoText, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                    
                    int tempoVidaEstimado = Integer.parseInt(tempoVidaField.getText());
                    String localizacao = localizacaoField.getText();
                    String detalhes = detalhesField.getText();
                    String manual = manualField.getText();

                    // Criar uma nova máquina com os dados coletados
                    Maquina maquinaAtualizada = new Maquina(
                        idText, codigo, nome, modelo, fabricante, dataAquisicao, tempoVidaEstimado, localizacao, detalhes, manual
                    );

                    // Atualizar a máquina no controlador
                    maquinaController.updateMaquina(selectedRow, maquinaSelecionada);
                    MaquinaApi.updateMaquina(maquinaAtualizada);

                    // Recarregar a tabela
                    carregarMaquinas();

                    // Fechar o diálogo
                    dialog.dispose();
                } catch (DateTimeParseException dtpe) {
                    JOptionPane.showMessageDialog(dialog, "Data de Aquisição inválida! Formato esperado: dd-MM-yyyy.", "Erro", JOptionPane.ERROR_MESSAGE);
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(dialog, "Valor inválido para o tempo de vida estimado! Por favor, insira um número.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            });

            dialog.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma máquina para alterar.", "Erro", JOptionPane.WARNING_MESSAGE);
        }
    }
}
