import java.util.Scanner;

public class EsempioIterazioni {

    public static void main(String[] args) {

        int i = 1; // inizializzazione della variabile

        while (i <= 5) {
            i++; // incremento variabile
            System.out.println(i);
        }

        System.out.println("-----------------------------");

        Scanner scanner = new Scanner(System.in);

        boolean continua = true; // variabile di controllo

        while (continua) {

            System.out.println("Inserisci un numero (0 per uscire): ");
            int numero = scanner.nextInt();

            if (numero == 0) {
                continua = false; // rompe il ciclo
            } else {
                System.out.println("Hai inserito: " + numero);
            }
        }

        System.out.println("Programma termianto.");

        System.out.println("-----------------------------");

        Scanner input = new Scanner(System.in);
        int numero;

        do { // blocco eseguito sempre, almeno una volta
            System.out.println("Inserisci un numero (0 per uscire): ");
            numero = input.nextInt();
        } while (numero != 0); // controllo per decidere se ripetere o meno il codice nel "do"

        System.out.println("Hai inserito 0. Programma terminato");

        System.out.println("-----------------------------");

        
        
        
        
        
        
        scanner.close();
        input.close();

    }
}
