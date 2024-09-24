package projeto.exemplo;

import java.util.Scanner;

public class Exercicio3 {

    int a;
    int b;
    int resultado;
    // int operacao;
    int escolha;

    Scanner sc = new Scanner(System.in);

    public double soma(int a, int b) {
        resultado = a + b;
        return resultado;
    }

    public double sub(int a, int b) {
        resultado = a - b;
        return resultado;
    }

    public double multi(int a, int b) {
        resultado = a * b;
        return resultado;
    }

    public double div(int a, int b) {
        try {
            resultado = a / b;
        } catch (Exception e) {
            System.out.println("nao dividiras por 0" );
        }

        return resultado;
    }

    public double raiz(int a) throws Exception {
        if (a < 0) {
            throw new Exception("deve ser maior que zero");
        }
        try {
            
            resultado = (int) Math.sqrt(a);

        } catch (Exception e) {
            // TODO: handle exception
        }

        return resultado;
    }

    public void menu() {
        System.out.println("\n -- Calculadora Avançada ---");
        System.out.println("1. soma");
        System.out.println("2. subtração");
        System.out.println("3. multiplicação");
        System.out.println("4. divisão");
        System.out.println("5. Raiz quadrada");
        System.out.println("6. Sair");

    }

//     public void operacao() {
//         try {
//             int escolha = 0;
//             while (escolha!=6) {
//                 switch (escolha) {
//                     case 1:
//                     System.out.println("Digite um numero");
//                     a =sc.nextInt();
//                     System.out.println("Digite o numero 2");
//                     b =sc.nextInt();
//                     System.out.println("Resultado foi " + soma(a,b));
//                         break;
//                     case 2:
//                     System.out.println("Digite um numero");
//                     a =sc.nextInt();
//                     System.out.println("Digite o numero 2");
//                     b =sc.nextInt();
//                     System.out.println("Resultado foi " + sub(a,b));
//                         break;
//                     case 3:
//                     System.out.println("Digite um numero");
//                     a =sc.nextInt();
//                     System.out.println("Digite o numero 2");
//                     b =sc.nextInt();
//                     System.out.println("Resultado foi " + multi(a, b));
//                         break;
//                     case 4:
//                     System.out.println("Digite um numero");
//                     a =sc.nextInt();
//                     System.out.println("Digite o numero 2");
//                     b =sc.nextInt();
//                     System.out.println("Resultado foi " + div(a, b));
//                         break;
//                     case 5:
//                     System.out.println("Digite um numero");
//                     a =sc.nextInt();
//                     System.out.println("Digite o numero 2");
//                     b =sc.nextInt();
//                     System.out.println("Resultado foi " + raiz(a));
//                         break;
//                     default: 
//                         break;
//                 }
// }
//             }catch (Exception e) {
//             // TODO: handle exception
//         }
//         }
    public void escolhaOperacao() {
        if (escolha >= 1 && escolha >= 5) {
            System.out.println("digite um numero");
            System.out.println("digite outro numero");
        } else if (escolha == 5) {
            System.out.println("digite um numero");

        } else if (escolha == 6) {
            System.out.println("saindo");

        } else {
            System.out.println("digite um numero valido");
        }
    }

    public void calculadora() {
        do {
            menu();
            try {
                escolha = sc.nextInt();
                switch (escolha) {
                    case 1:
                        escolhaOperacao();
                        soma(a, b);
                        break;
                    case 2:
                        escolhaOperacao();
                        sub(a, b);
                        break;
                    case 3:
                        escolhaOperacao();
                        multi(a, b);
                        break;
                    case 4:
                        escolhaOperacao();
                        div(a, b);
                        break;
                    case 5:
                        escolhaOperacao();
                        raiz(a);
                        break;
                    case 6:
                        escolhaOperacao();
                        break;
                    default:
                        escolhaOperacao();

                        break;
                }
            } catch (Exception e) {
               System.out.println(e);
            }
        } while (escolha != 6);
    }
}
