package buff.file;

import java.io.BufferedReader;
import java.nio.Buffer;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
public class LeituraArquivo {
    public void exemplo() {
try (BufferedReader br = new BufferedReader(new BufferedReader(new FileReader("dados.txt") ))){
    String linha;
    do {
        linha = br.readLine();
        System.out.println(linha==null?"Fim do Documento":linha);
    } while (linha!=null);
} catch (IOException e) {
e.printStackTrace();
}
    }
}
