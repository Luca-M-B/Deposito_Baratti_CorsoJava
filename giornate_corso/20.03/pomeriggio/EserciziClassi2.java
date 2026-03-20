import java.util.Scanner;

public class EserciziClassi2 {

    public static void main(String[] args) {

        // Veicolo primoVeicolo = new Veicolo("Fiat", "500", 2020, 22350.00);

        Veicolo nuovoVeicolo = new Veicolo(); // creo oggetto a partire dalla classe
        int scelta; // variabile per la scelta del while

        Scanner inputScelta = new Scanner(System.in); // scanner per scelta dal menu
        Scanner inputDati = new Scanner(System.in); // scanner per input dati

        do { // do per mostrare il menu
            System.out.print("\nScegliere un'opzione dal menu");
            System.out.println("\n\tMENU");
            System.out.println(
                    "1 - Inserire dati veicolo\n2 - Visualizza dati veicolo\n3 - Modifica prezzo\n4 - verifica eta veicolo\n5 - Esci\n");
            scelta = inputScelta.nextInt(); // catturo input per la scelta dal menu
            inputScelta.nextLine(); // pulizia scanner

            switch (scelta) { // gestisco tutti i case
                case 1:
                    System.out.println("Inserire la marca del veicolo: ");
                    nuovoVeicolo.marca = inputDati.nextLine(); // assegno valore preso in input
                    System.out.println("Inserire il modello del veicolo: ");
                    nuovoVeicolo.modello = inputDati.nextLine(); // assegno valore preso in input

                    System.out.println("Inserire anno di immatricolazione del veicolo: ");
                    int annoImmatricolazione; // variabile per controllo anno
                    annoImmatricolazione = inputDati.nextInt();
                    if (annoImmatricolazione <= 1900 || annoImmatricolazione >= 2026) { // controllo anno
                        System.out.println("Attenzione! Anno inserito non valido.");
                    } else { // se nel range lo assegno
                        nuovoVeicolo.anno = annoImmatricolazione;
                    }

                    System.out.println("Inserire il prezzo del veicolo: ");
                    double prezzoInserito = 0; // dichiaro e inizializzo variabile per controllo
                    if (prezzoInserito < 0) {
                        System.out.println("Attenzione! Prezzo inserito non valido");
                        break;
                    } else {
                        nuovoVeicolo.prezzo = prezzoInserito; // se prezzo valido assegno il valore alla variabile
                    }
                    break;
                case 2:
                    nuovoVeicolo.mostraDettagli(); // chiamo il metodo mostraDettagli
                    break;
                case 3:
                    System.out.println("Digitare il nuovo prezzo: ");
                    nuovoVeicolo.prezzo = inputDati.nextDouble(); // assegno il nuovo prezzo inserito
                    System.err.println("Prezzo modificato");
                    break;
                case 4:
                    nuovoVeicolo.mostraAnno(); // chiamo il metodo mostraAnno
                    break;
                case 5:
                    System.out.println("Chiusura programma");
                    break;
                default:
                    System.out.println("Opzione non valida");
            }

        } while (scelta != 5); // se la scelta catturata dallo scanner è 7, esco, altrimenti continuo a
                               // mostrare il menu

    }
}

class Veicolo {
    String marca;
    String modello;
    int anno;
    double prezzo;

    Veicolo() { // costruttore vuoto
    }

    Veicolo(String marca, String modello, int anno, double prezzo) { // costruttore completo
        this.marca = marca;
        this.modello = modello;
        this.anno = anno;
        this.prezzo = prezzo;
    }

    void mostraDettagli() { // metodo senza ritorno per stampare tutte le variabili degli oggetti creati
        System.out.println(
                "\nInfo Veicolo:\nMarca | " + marca + "\nModello | " + modello + "\nAnno | " + anno + "\nPrezzo | "
                        + prezzo + " euro");
    }

    void mostraAnno() { // metodo senza ritorno per stampare anno e verificare lo stato degli oggetti
                        // Veicolo creati
        int annoCorrente = 2026; // inizializzo brutalmente la variabile ad un anno x
        int etaVeicolo = annoCorrente - anno; // calcolo l'eta

        System.out.println("\nL'anno di immatricolazione del veicolo è " + anno);

        if (etaVeicolo == 0) { // valuto in base all'età lo stato degli oggetti Veicolo creati
            System.out.println("Il veicolo è nuovo");

        } else if (etaVeicolo < 5) {
            System.out.println("IL veicolo è quasi nuovo");
        } else if (etaVeicolo < 15) {
            System.out.println("Il veicolo è usato");
        } else {
            System.out.println("Il veicolo è vecchio");
        }

    }
}