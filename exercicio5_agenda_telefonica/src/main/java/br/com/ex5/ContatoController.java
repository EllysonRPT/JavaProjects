package br.com.ex5;
//controller

public class ContatoController {

    private Contato[] contatos;
    private int contadorContatos;
    //constutor

    public ContatoController(int maxContato) {
        contatos = new Contato[maxContato];
        contadorContatos = 0;
    }

    //metodos -adicionar
    public void addContato(Contato contato) throws AgendaCheiaException {
        if (contadorContatos >= contatos.length) {
            throw new AgendaCheiaException("agenda cheia");
        }
        try {
            contatos[contadorContatos] = contato;
            contadorContatos++;
            System.out.println("contato adicionado");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //listar todos 
    public void listarTodos() {
        if (contadorContatos == 0) {
            System.out.println("agenda vazia");
        } else {
            for (int i = 0; i < contadorContatos; i++) {
                System.out.println(contatos[i].toString());
            }
        }

    }

    //buscar contato pelo nome 
    public Contato buscarContato(String nome) throws ContatoNaoEncontrado {
        for (int i = 0; i < contadorContatos; i++) {
            if (contatos[i].getNome().equalsIgnoreCase(nome)) {
                return contatos[i];
            }
        }
        throw new ContatoNaoEncontrado("Contato não encontrado ");
    }
    //deletar contato

    public void removerContato(String nome) throws ContatoNaoEncontrado {
        boolean encontrado = false;
        for (int i = 0; i < contadorContatos; i++) {
            if (contatos[i].getNome().equalsIgnoreCase(nome)) {
                encontrado = true;
                contatos[i] = contatos[contadorContatos - 1];
                contatos[contadorContatos - 1] = null;
                contadorContatos--;
            }
        }
        if (!encontrado) {
            throw new ContatoNaoEncontrado("Contato nao encontrado");
        }
    }
}
