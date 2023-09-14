//Laboratório de programação 2 - lab 1
//Laysa Santos Oliveira - 122210585

import java.util.Scanner;

public class Populacao {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String[] numeros = sc.nextLine().split(" ");
        int soma = 0;
        int contador = 0;

        for (int i = 0; i < numeros.length; i++) {
            soma += Integer.parseInt(numeros[i]);
            contador++;
        }

        int media = soma / contador;

        for (int i = 0; i < numeros.length; i++) {
            int elemento = Integer.parseInt(numeros[i]);

            if (elemento > media) {
                System.out.print(elemento + " ");
            }
        }
    }

}
