import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class EsercizioArrayList {

    public static void main(String[] args) {

        ArrayList<String> nomiStudenti = new ArrayList<>();
        String input;
        int numeroNome = 1;

        Scanner scanner = new Scanner(System.in);

        System.out.println(
                "\nInserisci i nomi degli studenti uno alla volta. Scrivere la parola 'fine' per terminare l'inserimenot:");

        while (true) {
            System.out.println("\nNome " + numeroNome + ": ");
            numeroNome++; // incremento numero inserimento
            input = scanner.nextLine();

            if (input.equals("fine")) { // se l'input è 'fine' esco dal ciclo
                break;
            }

            nomiStudenti.add(input); // aggiungo gli input presi nell'arrayList
        }

        Collections.sort(nomiStudenti); // ordinamento dell'array attraverso Collections.sort

        System.out.println("\nSono stati inseriti " + nomiStudenti.size() + " nomi nell'elenco."); // stampo numero
        System.out.println("\nElenco studenti inseriti (in ordine alfabetico): ");
        System.out.println("\n" + nomiStudenti); // stampo i nomi

        System.out.println("\nSi desidera eliminare qualche nome dall'elenco? (digitare 'si' o 'no')");
        input = scanner.nextLine(); // riutilizzo lo scanner

        if (input.equalsIgnoreCase("si")) { // se si

            while (true) {
                System.out.println("\nDigitare il nome da eliminare (oppure 'no' per terminare):"); // chiedo di
                                                                                                    // digitare quale
                                                                                                    // rimuovere
                String nomeEliminare = scanner.nextLine();

                if (nomeEliminare.equalsIgnoreCase("no")) {
                    break; // se l'input è no, esco dal ciclo
                }

                if (nomiStudenti.remove(nomeEliminare)) { // se esiste il nome lo rimuovo
                    System.out.println("Nome rimosso dall'elenco.");
                } else { // se non esiste termino
                    System.out.println("Attenzione! Nome non trovato nell'elenco.");
                }

                System.out.println("Ora l'elenco contiene " + nomiStudenti.size() + " nomi al suo interno."); // stampo
                                                                                                              // nuovo
                                                                                                              // numero
                System.out.println("Elenco studenti inseriti (in ordine alfabetico): ");
                System.out.println("Elenco aggiornato: " + nomiStudenti); // stampo elenco aggiornato
            }

        } else {
            System.out.println("\nNessuna modifica effettuata.");
        }

        System.out.println("\nProgramma terminato.");
        scanner.close();

        /*
         * extra: Gestire l'inserimento in parallelo anche dell'età e del voto int e
         * float e inserire tutti e tre glia rraylist in un'altro arraylsit che li
         * contiene e rende il tutto modificabile
         */

        /*
         * per gestire l'extra: creo altri due arrayList: età e voto ed un terzo array
         * che contenga questi due arraylist più quello dei nomi.
         * apro due nuovi scanner per catturare eta (int) e voto (float).
         * alla richiesta di inserimento del nome procedo con inserimento di eta ed
         * infine voto per dato studente e inserisco ciascuna info nel corrispondente
         * arrayList.
         */
    }
}
