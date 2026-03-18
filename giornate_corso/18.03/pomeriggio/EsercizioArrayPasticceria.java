import java.util.Scanner;

public class EsercizioArrayPasticceria {

    public static void main(String[] args) {

        Scanner inputString = new Scanner(System.in); // scanner di input per i nomi
        Scanner inputInt = new Scanner(System.in); // scanner di input per le quantita

        int totaleDolci = 0; // totale dolci ordinati
        int numeroDolci; // numero dolci richiesti

        do {
            System.out.println("Quanti dolci diversi si vogliono ordinare? (massimo 10)");
            numeroDolci = inputInt.nextInt();
            if (numeroDolci <= 0 || numeroDolci > 10) {
                System.out.println("Impossibile proseguire. Indicare una quantita tra 1 e 10.");
            }
        } while (numeroDolci <= 0 || numeroDolci > 10);

        String[] nomiDolci = new String[numeroDolci]; // dichiarazione dei due array
        int[] quantitaOrdinata = new int[numeroDolci];

        for (int i = 0; i < numeroDolci; i++) { // raccolgo i nomi dei dolci per il numero precedentemente selezionato
            System.out.println("\nInserire il nome del dolce numero " + (i + 1) + ": ");
            nomiDolci[i] = inputString.nextLine();

            int quantita;

            do {
                System.out.println("\nInserire la quantita desiderata per il dolce " + nomiDolci[i] + ": ");
                quantita = inputInt.nextInt(); // catturo quantita del dolce selezionato
                if (quantita <= 0) { // controllo che la quantita sia positiva e quindi valida
                    System.out.println("\nOperazione fallita. La quantita deve essere superiore a zero.");
                }
            } while (quantita < 0);

            quantitaOrdinata[i] = quantita;

        }

        System.out.println("RIEPILOGO DELL'ORDINE EFFETTUATO");

        for (int i = 0; i < numeroDolci; i++) {
            System.out.println((i + 1) + " - " + nomiDolci[i] + ": " + quantitaOrdinata[i]);
            totaleDolci = totaleDolci + quantitaOrdinata[i];
        }

        System.out.println("Quantita totale dolci ordinati: " + totaleDolci);
    }
}
