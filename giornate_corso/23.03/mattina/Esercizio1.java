import java.time.LocalDate;
import java.util.Scanner;

public class Esercizio1 {

    public static void main(String[] args) {

        Scanner scannerString = new Scanner(System.in); // creo scanner per input stringe
        Scanner scannerNumeri = new Scanner(System.in); // scanner per input numerici
        String nome; // dichiaro variabile per nome
        int annoNascita; // dichiaro variabile per anno di nascita
        int giornoSettimana; // dichairo variabile per giorno settimana
        int giorniMancanti; // dichairo variabile per calcolare i giorni mancanti al weekend
        int eta; // variabile per calcolo età

        System.out.println("Inserisci il tuo nome: ");
        nome = scannerString.nextLine(); // assegno valore alla variabile

        System.out.println("\nInserisci il tuo anno di nascita: ");
        annoNascita = scannerNumeri.nextInt();

        System.out.println(
                "\nInserire il giorno della settimana seondo il seguente scema:\n1 = Lunedì\n2 = Martedì\n3 = Mercoledì\n4 = Giovedì\n5 = Venerdì\n6 = Sabato\n7 = Domenica\n");
        giornoSettimana = scannerNumeri.nextInt();

        if (giornoSettimana <= 6) { // condizione se il giorno in input è tra lunedì e sabato
            giorniMancanti = 6 - giornoSettimana;
        } else {// se giorno in input è domenica
            giorniMancanti = 6;
        }

        eta = (LocalDate.now().getYear()) - annoNascita; // calcolo età prendendo anno corrente dal sistema e sottraendo
                                                         // anno nascita inserito dall'utente

        System.out.println("\nIl tuo nome è " + nome + ", hai " + eta + " anni e mancano " + giorniMancanti
                + " giorni al prossimo weekend"); // stampo la richiesta dell'esercizio

        scannerNumeri.close(); // chiudo gli scanner
        scannerString.close();
    }

}
