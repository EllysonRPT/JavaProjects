package buff.file;

import java.io.Reader;

import java.io.BufferedReader;
import java.nio.Buffer;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class Exerciocio4 {
    public Exerciocio4() {
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader("naosei.csv"));
            String linha = br.readLine();
            if (linha != null) {
                String colunas[] = linha.split(",");
                System.out.println("cabeçalho");
                for (String coluna : colunas) {
                    System.out.print(coluna + " ");
                }
            }
            System.out.println("---conteudo---");
            while ((linha = br.readLine()) != null) {
                String colunas[] = linha.split(",");
                for (String coluna : colunas) {
                    System.out.print(coluna + " ");
                }
                System.out.println();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
