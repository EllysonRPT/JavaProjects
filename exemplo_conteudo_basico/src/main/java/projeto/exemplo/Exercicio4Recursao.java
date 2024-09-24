package projeto.exemplo;

import java.util.Scanner;

/**
 * Exercicio4Recursao
 */
public class Exercicio4Recursao {
//atributos

    int numero = -1;
    Scanner sc = new Scanner(System.in);
//metodos 
//calcular  o fatorial - recursao

    public long fatorial(int numero) {
        if (numero == 0 || numero == 1) {
            return 1;
        } else {
            return numero * fatorial(numero - 1);
        }
    }
//fazer operacao

    public void calculadora() throws Exception {
        while (true) {
            System.out.println("digite numeto");
            sc.nextInt();
            if (numero < 0) {
                throw new Exception("numero negativo Erro");
            }
            try {
                long resultado = fatorial(numero);
                System.out.println("O fatorial é " + resultado);
            } catch (Exception e) {
 System.out.println(e);
            }
        }
    }
}
