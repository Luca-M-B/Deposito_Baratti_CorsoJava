import java.util.ArrayList;
import java.util.Scanner;

public class EsercizioCalcolatrice {

    public static double somma(double a, double b) {
        return a + b;
    }

    public static double sottrazione(double a, double b) {
        return a - b;
    }

    public static double moltiplicazione(double a, double b) {
        return a * b;
    }

    public static double divisione(double a, double b) {
        if (b == 0) {
            System.out.println("Impossibile dividere per zero");
            // return null;
        }
        return a / b;
    }

    public static double sommaPiuNumeri(ArrayList<Double> numeri) {
        double risultato = 0; // inizializzo variabile risultato
        for (int i = 0; i < numeri.size(); i++) { // ciclo per la lungezza dell'arrayList
            risultato += numeri.get(i); // per ogni indice sommo dato valore alla variabile risultato
        }
        return risultato; // restituisco risultato
    }

    public static double moltiplicazionePiuNumeri(ArrayList<Double> numeri) {
        double risultato = 1; // inizializzo variabile risultato a 1 perchè 0 creerebbe problemi
        for (int i = 0; i < numeri.size(); i++) { // ciclo per la lungezza dell'arrayList
            risultato *= numeri.get(i); // per ogni indice moltiplico dato valore alla variabile risultato
        }

        return risultato; // restituisco risultato
    }

    public static double potenza(double a, double b) { // primo numero come base, secondo come esponente
        return Math.pow(a, b);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); // inizializzazione scanner
        int scelta; // dichiarazione variabile per switch

        ArrayList<Double> numeri = new ArrayList<>(); // arrayList per capire quanti numeri ci passerà l'utente

        System.out.print("Quanti numeri vuoi inserire? ");
        int conteggioNumeri = scanner.nextInt(); // prendo la quantita dei numeri in input

        for (int i = 0; i < conteggioNumeri; i++) { // ciclo per la quantita dei numeri che si desidere inserire
            System.out.print("Inserisci numero " + (i + 1) + ": ");
            numeri.add(scanner.nextDouble()); // aggiungo i numeri all'arrayLis
        }

        /*
         * QUESTO BLOCCO ERA PER LA PRIMA PARTE DELL'ESERCIZIO
         * System.out.println("digitare il primo numero: ");
         * double a = scanner.nextDouble();
         * 
         * System.out.println("digitare il secondo numero: ");
         * double b = scanner.nextDouble();
         */

        do {
            System.out.println("\nScegliere un'operazione da eseguire");
            System.out.println("1 - Somma\n2 - Sottrazione\n3 - Moltiplicazione\n4 - Divisione\n5 - Potenza\n6 - Esci");

            scelta = scanner.nextInt();

            switch (scelta) {

                case 1:
                    // System.out.println("La somma tra i due numeri è: " + somma(a, b));
                    System.out.println("La somma tra i due numeri è: " + sommaPiuNumeri(numeri));
                    break;

                case 2:
                    System.out.println("La differenza tra i due numeri è: " + sottrazione(a, b));
                    break;

                case 3:
                    // System.out.println("Il prodotto tra i due numeri è: " + moltiplicazione(a,
                    // b));
                    System.out.println("Il prodotto tra i due numeri è: " + moltiplicazionePiuNumeri(numeri));
                    break;

                case 4:
                    System.out.println("La divisione tra i due numeri è: " + divisione(a, b));
                    break;

                case 5:
                    System.out.println("Il risultato della potenza è: " + potenza(a, b));
                    break;

                case 6:
                    System.out.println("Chiusura del programma");
                    break;

                default:
                    System.out.println("Scelta non valida");
            }

        } while (scelta != 6); // finche non viene scelto 5 non esco dal programma

        scanner.close();
    }
}
