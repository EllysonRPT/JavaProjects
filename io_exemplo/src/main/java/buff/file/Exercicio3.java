package buff.file;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class Exercicio3 {
    
    public void exemplo() {
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres", // Corrigido o URL do JDBC
                    "postgres",
                    "postgres");
            
            Statement smtm = con.createStatement();
            
            // Exibir nome e preço de cada produto
            ResultSet rs = smtm.executeQuery("SELECT * FROM produtos");
            System.out.println("Lista de produtos:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                                   ", Nome: " + rs.getString("nome") +
                                   ", Preço: " + rs.getBigDecimal("preco"));
            }
            
            // Produto mais caro
            ResultSet rsCaro = smtm.executeQuery("SELECT * FROM produtos ORDER BY preco DESC LIMIT 1");
            if (rsCaro.next()) {
                System.out.println("Produto mais caro: " +
                                   "ID: " + rsCaro.getInt("id") +
                                   ", Nome: " + rsCaro.getString("nome") +
                                   ", Preço: " + rsCaro.getBigDecimal("preco"));
            }
            
            // Produto mais barato
            ResultSet rsBarato = smtm.executeQuery("SELECT * FROM produtos ORDER BY preco ASC LIMIT 1");
            if (rsBarato.next()) {
                System.out.println("Produto mais barato: " +
                                   "ID: " + rsBarato.getInt("id") +
                                   ", Nome: " + rsBarato.getString("nome") +
                                   ", Preço: " + rsBarato.getBigDecimal("preco"));
            }
            
            // Média de preços
            ResultSet rsMedia = smtm.executeQuery("SELECT AVG(preco) AS media_preco FROM produtos");
            if (rsMedia.next()) {
                System.out.println("Média de preços dos produtos: " + rsMedia.getBigDecimal("media_preco"));
            }
            
            // Fechar a conexão
            con.close();
        } catch (Exception e) {
            System.out.println("Falha na conexão: " + e.getMessage());
        }
    }
}
