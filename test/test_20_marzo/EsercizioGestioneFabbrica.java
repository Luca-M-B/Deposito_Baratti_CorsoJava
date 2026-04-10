import java.util.ArrayList;
import java.util.Scanner;

public class EsercizioGestioneFabbrica {

    static Scanner scannerNomi = new Scanner(System.in); // scanner per i nomi
    static Scanner scannerQuantita = new Scanner(System.in); // scanner per le quantita

    public static void aggiungiProdotto(ArrayList<String> nomiProd, ArrayList<Integer> quantitaProd) { // metodo per
                                                                                                       // aggiungere
        // un prodotto, parametri
        // richiesti due
        // arrayList separati per
        // nomi e quantita
        System.out.print("Digitare il nome del prodotto da aggiungere: ");
        String nome = scannerNomi.nextLine(); // catturo il nome digitato e lo assegno alla variabile

        System.out.print("Digitare la quantità da aggiungere: ");
        int quanto = scannerQuantita.nextInt(); // catturo la quantita digitata e lo assegno alla variabile

        if (quanto > 0) { // controllo che la quantita sia positiva
            nomiProd.add(nome); // aggiungo nome e quantita ai rispettivi arrayList
            quantitaProd.add(quanto);
            System.out.println("\nIl prodotto " + nome + " è stato aggiunto"); // stampo messaggio
        } else { // se la quantita non è valida
            System.out.println("Attenzione! La quantita deve essere maggiore di zero");
        }

    }

    public static void visualizzaProduzione(ArrayList<String> nomiProd, ArrayList<Integer> quantitaProd) {
        if (nomiProd.size() == 0) { // controllo che l'array non sia vuoto
            System.out.println("Nessun prodotto registrato");
        } else {
            System.out.println("\nProduzione:");
            for (int i = 0; i < nomiProd.size(); i++) { // ciclo l'arrayList e stampo ogni prodotto trovato con relativa
                                                        // quantita attraverso lo stesso indice
                System.out.println(nomiProd.get(i) + " || " + quantitaProd.get(i) + " pezzi");
            }
        }
    }

    public static void cercaProdotto(ArrayList<String> nomiProd, ArrayList<Integer> quantitaProd) {
        System.out.print("Inserisci nome prodotto da cercare: ");
        String nome = scannerNomi.nextLine(); // catturo input nome da cercare

        boolean trovato = false; // imposto un boolean a false

        for (int i = 0; i < nomiProd.size(); i++) { // ciclo l'intero array di nomi
            if (nomiProd.get(i).equalsIgnoreCase(nome)) { // se trovo corrispondenza di nome stampo nome e quantita
                                                          // trovata
                System.out.println(
                        "E' stato trovato il prodotto: " + nomiProd.get(i) + " || quantita: " + quantitaProd.get(i)
                                + " pezzi");
                trovato = true; // modifico il valore della variabile perchè esiste una corrispondenza
            }
        }

        if (!trovato) { // se la variabile rimane a false, stampo messaggio
            System.out.println("Prodotto non trovato");
        }
    }

    public static void modificaQuantita(ArrayList<String> nomiProd, ArrayList<Integer> quantitaProd) {

        System.out.print("Digitare il nome del prodotto che si desidera modificare: ");
        String nome = scannerNomi.nextLine(); // catturo input del prodotto da modificare

        for (int i = 0; i < nomiProd.size(); i++) { // ciclo arrayList dei nomi
            if (nomiProd.get(i).equalsIgnoreCase(nome)) { // se trovo una corrispondenza chiedo la nuova quantità
                System.out.print("Digitare la nuova quantità: ");
                int nuovaQuantita = scannerQuantita.nextInt(); // catturo la nuova quantita

                if (nuovaQuantita <= 0) { // controllo che la nuova quantita sia positiva
                    System.out.println("Attenzione! La quantita deve essere maggiore di zero");
                }

                quantitaProd.set(i, nuovaQuantita); // allo stesso indice dell'array dei nomi modifico la quantita con
                                                    // quella nuova
                System.out.println("Quantità aggiornata");

            }
        }

        System.out.println("Prodotto non trovato");
    }

    public static void rimuoviProdotto(ArrayList<String> nomiProd, ArrayList<Integer> quantitaProd) {
        System.out.print("Nome prodotto da rimuovere: ");
        String nome = scannerNomi.nextLine(); // input per nome da rimuovere

        for (int i = 0; i < nomiProd.size(); i++) { // ciclo per cercare il prodotto
            if (nomiProd.get(i).equalsIgnoreCase(nome)) { // se esiste il prodotto nell'array
                nomiProd.remove(i); // rimuovo sia il prodotto che la sua quantita allo stesso indice ma nei due
                                    // arrayList differenti
                quantitaProd.remove(i);
                System.out.println("Il prodotto è stato rimosso");
                return;
            } else {
                System.out.println("Prodotto non trovato.");
            }
        }

    }

    public static void calcolaTotale(ArrayList<Integer> quantita) {
        int totale = 0; // inizializzo variabile a zero

        for (int i = 0; i < quantita.size(); i++) { // ciclo array delle quantita
            totale += quantita.get(i); // ad ogni indice sommo la quantita trovata alla variabile
        }

        System.out.println("Totale pezzi prodotti: " + totale); // stampo quantita totale
    }

    public static void main(String[] args) {

        ArrayList<String> nomiProdotti = new ArrayList<>(); // arrayList per i nomi dei prodotti
        ArrayList<Integer> quantitaProdotti = new ArrayList<>(); // arrayList per quantita prodotti

        int scelta; // variabile per la scelta del while

        Scanner inputScelta = new Scanner(System.in); // scanner per scelta dal menu

        do { // do per mostrare il menu
            System.out.print("\nScegliere un'opzione dal menu");
            System.out.println("\n\tMENU");
            System.out.println(
                    "1 - Aggiungi prodotto\n2 - Visualizza produzione\n3 - Cerca prodotto\n4 - Modifica quantità\n5 - Rimuovi prodotto\n6 - Calcola totale pezzi\n7 - Esci\n");
            scelta = inputScelta.nextInt(); // catturo input per la scelta dal menu
            inputScelta.nextLine(); // pulizia scanner

            switch (scelta) { // gestisco tutti i case e ad ogni corrispondenza chiamo la funzione esatta
                case 1:
                    aggiungiProdotto(nomiProdotti, quantitaProdotti);
                    break;
                case 2:
                    visualizzaProduzione(nomiProdotti, quantitaProdotti);
                    break;
                case 3:
                    cercaProdotto(nomiProdotti, quantitaProdotti);
                    break;
                case 4:
                    modificaQuantita(nomiProdotti, quantitaProdotti);
                    break;
                case 5:
                    rimuoviProdotto(nomiProdotti, quantitaProdotti);
                    break;
                case 6:
                    calcolaTotale(quantitaProdotti);
                    break;
                case 7:
                    System.out.println("Chiusura programma");
                    break;
                default:
                    System.out.println("Opzione non valida");
            }

        } while (scelta != 7); // se la scelta catturata dallo scanner è 7, esco, altrimenti continuo a
                               // mostrare il menu
    }

}