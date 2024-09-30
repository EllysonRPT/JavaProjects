package com.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GerenciamentoVendas {
    private Map<String, List<Produto>> vendasClientes;

    public GerenciamentoVendas() {
        vendasClientes = new HashMap<>();
        // registar vendas -idcliente
    }

    public void venda(String cpf, Produto produto) {
        for (String cpfCliente : vendasClientes.keySet()) {
            if (cpfCliente.equalsIgnoreCase(cpf)) {
                // criando uma listade produtos existente
                List<Produto> produtos = vendasClientes.get(cpfCliente); // lista antiga adicionada a nova
                produtos.add(produto); // acrecenta novo produto a lista noa
                vendasClientes.put(cpf, produtos);// recrincerve a lista
                return;
            }
        }
        List<Produto> produtos = new ArrayList<>();
        produtos.add(produto); // lista antiga adicionada a nova
        vendasClientes.put(cpf, produtos);
    }

    // consultar vendas por clientes
    public void produtosCliente(String cpf) {
        List<Produto> produtos = vendasClientes.getOrDefault(cpf, Collections.emptyList());
        if (produtos.isEmpty()) {
            System.out.println("nenhuma");
        } else {
            System.out.println(produtos.toString());
        }

    }

    // listar vendas acima do determinado valor
    public void produtosAcima(String cpf, double valorMinimo) {
        List<Produto> produtos = vendasClientes.getOrDefault(cpf, Collections.emptyList());
        if (produtos.isEmpty()) {
            System.out.println("nenhuma");
        } else {
            List<Produto> resultado = produtos.stream()
                    .filter(p -> p.getValor() >= valorMinimo)
                    .collect(Collectors.toList());
            if (resultado.isEmpty()) {
                System.out.println("nenhuma compra no valor minimo");
            } else {
                for (Produto produto : resultado) {
                    System.out.println(produto.toString());
                }
            }

        }

    }
}
