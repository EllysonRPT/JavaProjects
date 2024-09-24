package br.com.ex5;

public class Contato {
//model

    //atributos 
    private String nome;
    private String email;
    private String endereco;
    private String telefone;

    //construtor
    public Contato(String email, String endereco, String nome, String telefone) {
        this.email = email;
        this.endereco = endereco;
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

 @Override
    public String toString() {
 return "Nome:"+nome +",telefone:"+telefone;
    }
}
