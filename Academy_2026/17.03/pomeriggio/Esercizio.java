import java.util.Random;
import java.util.Scanner;

public class Esercizio {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); // scanner per input
        Random random = new Random(); // per generare errore successivamente

        int scelta = 0; // scelta dal menu principale
        int totaleCalcoli = 0; // conteggio di quante operazioni sono state eseguite

        while (scelta != 2) { // finche non si decide di uscire, il ciclo continua
            System.out.println("\n1. Inizia Calcolo\n2. Esci e stampa riepilogo");
            System.out.print("Scelta: ");
            scelta = scanner.nextInt();

            switch (scelta) {
                case 1:
                    // chiedo in input i due numeri
                    System.out.print("Inserire il primo numero: ");
                    double n1 = scanner.nextDouble();
                    System.out.print("Inserire il secondo numero: ");
                    double n2 = scanner.nextDouble();

                    System.out.println("Quale operazione eseguire?");
                    System.out.println("1) Somma  2) Sottrazione  3) Moltiplicazione  4) Divisione");
                    int operazione = scanner.nextInt();

                    double risultatoCorretto = 0;

                    // scelta operazione
                    switch (operazione) {
                        case 1:
                            risultatoCorretto = n1 + n2;
                            break;
                        case 2:
                            risultatoCorretto = n1 - n2;
                            break;
                        case 3:
                            risultatoCorretto = n1 * n2;
                            break;
                        case 4:
                            risultatoCorretto = n1 / n2;
                            break;
                        default:
                            System.out.println("è stata scelta un'opzione non disponibile");
                            continue; // Salta il resto e torna al menu
                    }

                    // creo errore random
                    double risultatoErrato = risultatoCorretto + (random.nextInt(20) - 10);

                    System.out.println("Risultato Corretto: " + risultatoCorretto);
                    System.out.println("Risultato Errato: " + risultatoErrato);

                    totaleCalcoli++;
                    break;

                case 2:
                    System.out.println("Chiusura programma...");
                    break;

                default:
                    System.out.println("Opzione menu non valida.");
                    break;
            }
        }

        System.out.println("------------------------------------------");
        System.out.println("Sessione terminata. Calcoli eseguiti: " + totaleCalcoli);
        scanner.close();

    }
}
