import java.util.Scanner;

public class EsempioCicloFor {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserire un numero: ");
        int numero = scanner.nextInt();

        System.out.println("Tabellina del " + numero + ": ");

        for (int i = 1; i <= 10; i++) {
            System.out.println(numero + " x " + i + " = " + (numero * i));
        }

        scanner.close();
    }
}
