import java.util.Scanner;

public class Sequencia {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numeroum = sc.nextInt();
        int numerodois = sc.nextInt();
        int numerotres = sc.nextInt();
        int numeroquatro = sc.nextInt();
        if (numeroum < numerodois && numerodois < numerotres & numerotres < numeroquatro) {
            System.out.println("POSSIVELMENTE ESTRITAMENTE CRESCENTE");
        } else if (numeroum > numerodois && numerodois > numerotres && numerotres > numeroquatro) {
            System.out.println("POSSIVELMENTE ESTRITAMENTE DECRESCENTE");
        } else {
            System.out.println("FUNCAO NAO ESTRITAMENTE CRES/DECR");
        }
    }

}