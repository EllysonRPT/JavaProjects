package buff.file;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import java.sql.ResultSet;

public class LeituraBD {
    public void exemplo() {
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc://localhost:5432/postgresql",
                    "postgres",
                    "senha");
            // para executar em sql
            Statement smtm = con.createStatement();
            ResultSet rs = smtm.executeQuery("select * from usuarios");
            while (rs.next()) {
                System.out.println("ID "+rs.getInt("id")+
                ", Nome: "+rs.getString("nome")+
                ", IDADE: "+rs.getInt("idade"));
                con.close();
            }
        } catch (Exception e) {
            System.out.println("Fallha na conexao");
        }
    }
}
