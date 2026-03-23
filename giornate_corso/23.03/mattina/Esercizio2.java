import java.util.Scanner;

public class Esercizio2 {

    public static void main(String[] args) {

        Scanner inputNumeri = new Scanner(System.in); // scanner per input dell'utente
        Scanner inputResa = new Scanner(System.in); // scanner per eventuale resa
        int numeroDaIndovinare; // variabile per il numero da indovinare
        int tentativiRimasti = 5; // variabile per tentativi rimanenti al giocatore 2
        boolean indovinato = false; // varibile per check
        boolean resa = false; // variabile per eventuale resa

        System.out.println("\nGiocatore1: inserisci un numero segreto compreso tra 1 e 100: ");
        numeroDaIndovinare = inputNumeri.nextInt(); // catturo e assegno il valore dato in input

        if (numeroDaIndovinare > 0 && numeroDaIndovinare <= 100) { // controllo che il numero inserito sia corretto

            System.out.println("\nGiocatore2: hai 5 tentativi per indovinare il numero segreto");

            while (tentativiRimasti > 0 && !indovinato && !resa) { // controllo che ci siano ancora tentativi e che il
                                                                   // giocatore non abbia nè indovinato nè si sia arreso
                System.out.print("\nTentativo n. " + (6 - tentativiRimasti) + " - digitare un numero o 'mi arrendo': ");

                String inputG2 = inputResa.nextLine(); // catturo input per eventuale resa

                if (inputG2.equalsIgnoreCase("mi arrendo")) { // se viene digitato "mi arrendo"
                    resa = true; // cambio valore alla variabile resa interrompendo il while
                } else {
                    int tentativo = Integer.parseInt(inputG2); // converto la stringa in intero se input diverso da "mi
                                                               // arrendo"
                    tentativiRimasti--; // decremento la variabile per scalare i tentativi effettuati

                    if (tentativo == numeroDaIndovinare) { // controllo se il numero è stato indovinato
                        indovinato = true; // se indovinato, cambio il valore della variabile ed esco dal while
                    } else if (tentativo < numeroDaIndovinare) { // stampo suggerimenti in base al valore inserito
                                                                 // rispetto
                                                                 // al numero da indovinare
                        System.out.println("\nIl numero da indovinare è piu alto");
                    } else {
                        System.out.println("\nIl numero da indovinare è piu basso");
                    }
                }
            }

            if (indovinato) { // prima di uscire dal while stampo informazioni al Giocatore2
                System.out.println("\nComplimenti Giocatore2! Hai indovinaato!");
            } else if (resa) {
                System.out.println("\nTi sei arreso. Il numero da indovinare era: " + numeroDaIndovinare);
            } else {
                System.out.println("\nTentativi esauriti! Il numero da indovinare era: " + numeroDaIndovinare);
            }

        } else { // se il numero inserito non è valido esco
            System.out.println("Il numero inserito è fuori dal range 1-100. Chiusura del programma.");
        }

        inputNumeri.close();// chiudo gli scanner
        inputResa.close();

    }

}
