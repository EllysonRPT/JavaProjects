package projeto.exemplo;

import java.util.Scanner;

public class Exercicio1 {

    double[] notas = new double[4];
    double media = 0;
    boolean bonus = false;

//metodos
    public void calculoMedia() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < notas.length; i++) {
            System.out.println("digite a Nota " + (i + 1));
           notas[i]=sc.nextDouble();
            media += notas[i];//acumula 
        }
        media = media / notas.length;
        //verificar bonus
        if (notas[0]>=9 &&notas[1]>=9 &&notas[2]>=9 &&notas[3]>=9) {
          media = (media*1.1>10?media=10:media*1.1);//operador ternario para nao estourar
          // se a media for maioe que dez
        }
        if(media>9){
          bonus = true;
          System.out.println("aluno comtemplado com 10%");
        }
        if (media>=7) {
          System.out.println("Média do aluno é %.2f.  " + media + " Resutado: Aprovado " );
        }
        else if (media>=5) {
          System.out.println("Média do aluno é %.2f. " + media + " Resutado: Recuperação " );
        }else{
          System.out.println("Média do aluno é %.2f. " + media + " Resutado: Reprovado " );
          
        }
        sc.close();
    }

}
