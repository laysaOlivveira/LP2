//Laboratório de programação 2 - lab 1
//Laysa Santos Oliveira - 122210585

import java.util.Scanner;

public class Calculadora {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Object operacao = sc.nextLine();
        float resultado;
        if (operacao.equals("+") || operacao.equals("-") || operacao.equals("*") || operacao.equals("/")) {
            float numeroum = sc.nextFloat();
            float numerodois = sc.nextFloat();
            if (operacao.equals("+")) {
                resultado = numeroum + numerodois;
                System.out.println("RESULTADO: " + resultado);
            } else if (operacao.equals("-")) {
                resultado = numeroum - numerodois;
                System.out.println("RESULTADO: " + resultado);
            } else if (operacao.equals("*")) {
                resultado = numeroum * numerodois;
                System.out.println("RESULTADO: " + resultado);
            } else if (operacao.equals("/")) {
                if (numerodois != 0) {
                    resultado = numeroum / numerodois;
                    System.out.println("RESULTADO: " + resultado);
                } else {
                    System.out.println("ERRO");
                }
            }
        } else {
            System.out.println("ENTRADA INVALIDA");

        }

    }
}
