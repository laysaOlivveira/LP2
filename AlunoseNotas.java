//Laboratório de programação 2 - lab 1
//Laysa Santos Oliveira - 122210585

import java.util.Scanner;

public class AlunoseNotas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int maior = 0;
        int menor = 1000;
        int soma = 0;
        int acima = 0;
        int abaixo = 0;
        int numeroNotas = 0;
        while (true) {
            String informacoes = sc.nextLine();
            if (informacoes.equals("-")) {
                break;
            }
            String[] dados = informacoes.split(" ");
            int nota = Integer.parseInt(dados[1]);
            if (nota > maior) {
                maior = nota;
            }
            if (nota < menor) {
                menor = nota;
            }
            soma += nota;
            numeroNotas++;
            if (nota >= 700) {
                acima++;
            } else {
                abaixo++;
            }
        }
        float media = soma / numeroNotas;
        System.out.println("maior: " + maior);
        System.out.println("menor: " + menor);
        System.out.printf("media: %.0f\n", media);
        System.out.println("acima: " + acima);
        System.out.println("abaixo: " + abaixo);
    }
}