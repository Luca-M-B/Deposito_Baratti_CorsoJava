import java.util.ArrayList;
import java.util.Scanner;

/*ESERCIZIO BASE COMPLETO
ESERCIZIO EXTRA NON COMPLETO */

public class Esercizio2ArrayList {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); // scanner

        ArrayList<String> listaNomi = new ArrayList<>(); // arrayList per i nomi
        boolean continua = true; // variabile per check del ciclo while

        ArrayList<Integer> listaEta = new ArrayList<>(); // array per l'età
        ArrayList<Boolean> listaIscritto = new ArrayList<>(); // array iscritto/non iscritto

        while (continua) { // while finche l'utente non esce

            System.out.println("\n\tMENU"); // stampo menu e scelte
            System.out.println(
                    "\n1 - Aggiungi nome\n2 - Visualizza tutti i nomi\n3 - Cerca nome\n4 - Rimuovi nome\n5 - Esci");

            int scelta = scanner.nextInt(); // leggo la scelta
            scanner.nextLine(); // pulizia scanner

            switch (scelta) { // gestisco la scelta dell'utente

                case 1: // aggiugnere noome
                    System.out.println("Inserire il nome: ");
                    String nome = scanner.nextLine();
                    listaNomi.add(nome); // aggiungo l'inputt all'arrayList

                    System.out.println("Inserire età: ");
                    int eta = scanner.nextInt();
                    listaEta.add(eta);

                    System.out.println("È iscritto? (Digitare 'si' oppure 'no'): ");
                    scanner.nextLine(); // pulizia scanner

                    boolean iscritto; // true di default
                    if (scanner.equals("si")) { // controllo l'input
                        iscritto = true;
                    } else if (scanner.equals("no")) {
                        iscritto = false;
                    } else {
                        System.out.println("Valore non valido, verrà impostato lo stato di 'non iscritto'");
                        iscritto = false;
                    }

                    listaIscritto.add(iscritto); // aggiungo

                    System.out.println("Aggiunto " + nome + " all'elenco");
                    break;

                case 2: // visualizzare elenco
                    if (listaNomi.isEmpty()) { // controllo che la lista non sia vuota
                        System.out.println("La lista è vuota");
                    } else {
                        System.out.println("Lista nomi: ");
                        for (int i = 0; i < listaNomi.size(); i++) { // ciclo e stampo l'intera lista nomi
                            System.out.println("\t " + listaNomi.get(i));
                        }
                    }
                    break;

                case 3: // cercare nell'elenco
                    System.out.println("Digitare il nome da cercare: ");
                    String nomeDaCercare = scanner.nextLine(); // leggo l'input
                    if (listaNomi.contains(nomeDaCercare)) {
                        System.out.println("Il nome è presente in elenco");
                    } else {
                        System.out.println("Attenzione! Nome non trovato");
                    }
                    break;

                case 4: // rimuovere dall'elenco
                    System.out.println("Digitare il nome da rimuovere: ");
                    String nomeDaRimuovere = scanner.nextLine(); // leggo input

                    if (listaNomi.contains(nomeDaRimuovere)) { // controllo esista il nome nell'elenco
                        listaNomi.remove(nomeDaRimuovere); // se esiste lo rimuovo
                        System.out.println("Nome rimosso");
                    } else { // non esiste, interrompo l'azione
                        System.out.println("Impossibile rimuovere: nome non trovato");
                    }
                    break;

                case 5: // terminare
                    continua = false; // cambio valore per terminare il while
                    System.out.println("Uscita in cosro. Arrivederci");
                    break;

                default:
                    System.out.println("Opzione non valida!");
                    break;
            }
        }

        scanner.close();
    }
}
