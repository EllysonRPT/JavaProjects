package buff.file;

import java.net.*;

import java.io.BufferedReader;
import java.nio.Buffer;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;

public class LeituraAPI {
    public void exemplo() {
        try {
            URL url = new URL("https://api.github.com/users/Diogotb");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            int status = con.getResponseCode();
            if (status != 200) {
                throw new Exception("Eroo de Conexão");
            }
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String linha;
            StringBuffer coteudo = new StringBuffer();
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
