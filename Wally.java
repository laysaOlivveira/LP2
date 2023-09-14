//Laboratório de programação 2 - lab 1
//Laysa Santos Oliveira - 122210585

import java.util.Scanner;

public class Wally {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String[] nomes = sc.nextLine().split(" ");
            if (nomes[0].equals("wally")) {
                break;
            }
            boolean encontraNome = false;
            for (int i = nomes.length - 1; i >= 0; i--) {
                if (nomes[i].length() == 5) {
                    System.out.println(nomes[i]);
                    encontraNome = true;
                    break;
                }
            }
            if (!encontraNome) {
                System.out.println("?");
            }
        }
    }
}