package com.example.view;
import java.util.*;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import com.example.controllers.MaquinaController;
import com.example.models.Maquina;

public class MaquinasPanel  extends JPanel{
    
private MaquinaController  maquinaController;
private JTable maquinasTable;
private DefaultTableModel tableModel;
private JButton btnSalvarAlteracao;
private JButton btnCadastrarMaquina;

public MaquinasPanel() {
   super(new BorderLayout());
   maquinaController = new MaquinaController();

tableModel = new DefaultTableModel(new Object[]{
   "Id", "Nome", "Fabricante", "Modelo","Detalhes", "Localização", "Tempo de Vida Estimado"
},0);

maquinasTable = new JTable(tableModel);

   List<Maquina> maquinas= maquinaController.readMaquinas();
   for (Maquina maquina : maquinas) {
      tableModel.addRow(new Object[]{
         maquina.getId(),
         maquina.getNome(),
         maquina.getFabricante(),
         maquina.getModelo(),
         maquina.getDetalhes(),
         maquina.getLocalizacao(),
         maquina.getTempoVidaEstimado()
      });
   }

   JScrollPane scrollPane = new JScrollPane(maquinasTable);
   this.add(scrollPane, BorderLayout.CENTER);
   JPanel painelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER));
   btnCadastrarMaquina = new JButton("Cadastrar");
   btnSalvarAlteracao = new JButton("Salvar");
   //separar depois
   painelInferior.add(btnSalvarAlteracao);
   painelInferior.add(btnCadastrarMaquina);
   this.add(painelInferior, BorderLayout.SOUTH);

   //criar as ActionListener
   
}
}
