import java.util.Scanner;

public class EsercizioGestioneNegozi {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); // scanner

        Negozio negozio1 = new Negozio("Ferramenta"); // creo oggetti Negozio
        Negozio negozio2 = new Negozio("Farmacia");
        Negozio negozio3 = new Negozio("Alimentari");
        Negozio negozio4 = new Negozio("Pizzeria");

        int scelta; // dichiaro variabile per gestire la scelta

        do {
            System.out.println(
                    "\n\tMENU\n1 - Inserisci prodotto in un negozio\n2 - Visualizza dati di tutti i negozi\n3 - Cerca negozio con prodotto più costoso\n4 - Modifica quantità prodotto\n5 - Vendi prodotto\n6 - Esci\n");

            scelta = scanner.nextInt();

            switch (scelta) {

                case 1:
                    System.out.println("\nScegliere un negozio:\n1-Ferramenta\n2-Farmacia\n3-Alimentari\n4-Pizzeria");
                    int sceltaNegozio = scanner.nextInt();
                    scanner.nextLine(); // mi assicuro che lo scanner sia pulito

                    System.out.print("\nDigitare il nome del prodotto: ");
                    String nome = scanner.nextLine();

                    System.out.print("\nDigitare il prezzo: ");
                    double prezzo = scanner.nextDouble();

                    System.out.print("\nDigitare la quantità: ");
                    int quantita = scanner.nextInt();

                    Prodotto nuovoProdotto = new Prodotto(nome, prezzo, quantita); // creo oggetto Prodotto con i dati
                                                                                   // raccolti in input

                    if (sceltaNegozio == 1) { // controllo l'input e aggiungo il prodotto al negozio corrispondente
                        negozio1.prodotto = nuovoProdotto;
                    } else if (sceltaNegozio == 2) {
                        negozio2.prodotto = nuovoProdotto;
                    } else if (sceltaNegozio == 3) {
                        negozio3.prodotto = nuovoProdotto;
                    } else if (sceltaNegozio == 4) {
                        negozio4.prodotto = nuovoProdotto;
                    } else {
                        System.out.println("Il negozio scelto non è in elenco");
                    }
                    break;

                case 2:
                    negozio1.riepilogoNegozio(); // richiamo il metodo ad ogni negozio per stamapre le info
                    negozio2.riepilogoNegozio();
                    negozio3.riepilogoNegozio();
                    negozio4.riepilogoNegozio();

                    break;

                case 3:

                    double prezzoMassimo = 0.0; // inizializzo una variabile a zero
                    String nomeNegozioPiuCostoso = "";

                    if (negozio1.prodotto != null) { // check su negozio1, proseguo se negozio1 ha un prodotto
                        prezzoMassimo = negozio1.prodotto.prezzo;
                        nomeNegozioPiuCostoso = negozio1.nome;
                    }

                    if (negozio2.prodotto != null && negozio2.prodotto.prezzo > prezzoMassimo) { // check se esiste un
                                                                                                 // prodotto in negozio2
                                                                                                 // e successivamente se
                                                                                                 // il prezzo è maggiore
                        prezzoMassimo = negozio2.prodotto.prezzo;
                        nomeNegozioPiuCostoso = negozio2.nome;
                    }

                    if (negozio3.prodotto != null && negozio3.prodotto.prezzo > prezzoMassimo) {
                        prezzoMassimo = negozio3.prodotto.prezzo;
                        nomeNegozioPiuCostoso = negozio3.nome;
                    }

                    if (negozio4.prodotto != null && negozio4.prodotto.prezzo > prezzoMassimo) {
                        prezzoMassimo = negozio4.prodotto.prezzo;
                        nomeNegozioPiuCostoso = negozio4.nome;
                    }

                    if (prezzoMassimo != 0.0) {
                        System.out.println("\nIl negozio con il prodotto più costoso è: " + nomeNegozioPiuCostoso);
                        System.out.println("Prezzo del prodotto: " + prezzoMassimo);
                    } else { // se nessun negozio ha un prodotto inserito
                        System.out.println("\nNessun prodotto inserito nei negozi");
                    }

                    break;

                case 4:
                    System.out.println("\nScegliere un negozio:\n1-Ferramenta\n2-Farmacia\n3-Alimentari\n4-Pizzeria");
                    sceltaNegozio = scanner.nextInt();
                    scanner.nextLine(); // mi assicuro che lo scanner sia pulito

                    if (sceltaNegozio == 1) { // controllo l'input per modificare la quantita del prodotto al negozio
                                              // corrispondente
                        System.out.println("\nE' stato scelto il negozio " + negozio1.nome
                                + ".Digitare la nuova quantita del prodotto " + negozio1.prodotto.nome + ":");
                        int nuovaQuantita = scanner.nextInt(); // catturo e assegno la nuova quantità ad una variabile
                        scanner.nextLine();
                        negozio1.prodotto.quantita = nuovaQuantita; // setto il valore
                    } else if (sceltaNegozio == 2) {
                        System.out.println("\nE' stato scelto il negozio " + negozio2.nome
                                + ".Digitare la nuova quantita del prodotto " + negozio2.prodotto.nome + ":");
                        int nuovaQuantita = scanner.nextInt();
                        scanner.nextLine();
                        negozio2.prodotto.quantita = nuovaQuantita;
                    } else if (sceltaNegozio == 3) {
                        System.out.println("\nE' stato scelto il negozio " + negozio3.nome
                                + ".Digitare la nuova quantita del prodotto " + negozio3.prodotto.nome + ":");
                        int nuovaQuantita = scanner.nextInt();
                        scanner.nextLine();
                        negozio3.prodotto.quantita = nuovaQuantita;
                    } else if (sceltaNegozio == 4) {
                        System.out.println("\nE' stato scelto il negozio " + negozio4.nome
                                + ".Digitare la nuova quantita del prodotto " + negozio4.prodotto.nome + ":");
                        int nuovaQuantita = scanner.nextInt();
                        scanner.nextLine();
                        negozio4.prodotto.quantita = nuovaQuantita;
                    } else {
                        System.out.println("Il negozio scelto non è in elenco");
                    }

                    break;

                case 5:
                    System.out.println("\nScegliere un negozio:\n1-Ferramenta\n2-Farmacia\n3-Alimentari\n4-Pizzeria");
                    sceltaNegozio = scanner.nextInt();
                    scanner.nextLine(); // mi assicuro che lo scanner sia pulito

                    if (sceltaNegozio == 1) { // controllo l'input per modificare la quantita del prodotto al negozio
                                              // corrispondente
                        System.out.print(
                                "\nDigitare la quantità da vendere del prodotto " + negozio1.prodotto.nome + ": ");
                        int quantitaVendita = scanner.nextInt(); // inizializzo variabile per la quantita di prodotto da
                                                                 // vendere
                        scanner.nextLine();

                        if (quantitaVendita > negozio1.prodotto.quantita) { // controllo che la quantità digitata sia
                                                                            // valida e diversa da zero
                            System.out.println("\nErrore! La quantità digitata è superiore alla quantià iin negozio");
                        } else if (quantitaVendita < 0) {
                            System.out.println("\nErrore! La quantità digitata da vendere è zero.");
                        } else {
                            negozio1.prodotto.quantita = negozio1.prodotto.quantita - quantitaVendita; // sottrazione
                                                                                                       // semplice
                            System.out
                                    .println("\nOperazione effettuata. Nuova quantita: " + negozio1.prodotto.quantita);
                        }
                    } else if (sceltaNegozio == 2) {
                        System.out.print(
                                "\nDigitare la quantità da vendere del prodotto " + negozio2.prodotto.nome + ": ");
                        int quantitaVendita = scanner.nextInt();
                        scanner.nextLine();

                        if (quantitaVendita > negozio2.prodotto.quantita) {
                            System.out.println("\nErrore! La quantità digitata è superiore alla quantià iin negozio");
                        } else if (quantitaVendita < 0) {
                            System.out.println("\nErrore! La quantità digitata da vendere è zero.");
                        } else {
                            negozio2.prodotto.quantita = negozio2.prodotto.quantita - quantitaVendita;
                            System.out
                                    .println("\nOperazione effettuata. Nuova quantita: " + negozio2.prodotto.quantita);
                        }
                    } else if (sceltaNegozio == 3) {
                        System.out.print(
                                "\nDigitare la quantità da vendere del prodotto " + negozio3.prodotto.nome + ": ");
                        int quantitaVendita = scanner.nextInt();
                        scanner.nextLine();

                        if (quantitaVendita > negozio3.prodotto.quantita) {
                            System.out.println("\nErrore! La quantità digitata è superiore alla quantià iin negozio");
                        } else if (quantitaVendita < 0) {
                            System.out.println("\nErrore! La quantità digitata da vendere è zero.");
                        } else {
                            negozio3.prodotto.quantita = negozio3.prodotto.quantita - quantitaVendita;
                            System.out
                                    .println("\nOperazione effettuata. Nuova quantita: " + negozio3.prodotto.quantita);
                        }
                    } else if (sceltaNegozio == 4) {
                        System.out.print(
                                "\nDigitare la quantità da vendere del prodotto " + negozio4.prodotto.nome + ": ");
                        int quantitaVendita = scanner.nextInt();
                        scanner.nextLine();

                        if (quantitaVendita > negozio4.prodotto.quantita) {
                            System.out.println("\nErrore! La quantità digitata è superiore alla quantià iin negozio");
                        } else if (quantitaVendita < 0) {
                            System.out.println("\nErrore! La quantità digitata da vendere è zero.");
                        } else {
                            negozio4.prodotto.quantita = negozio4.prodotto.quantita - quantitaVendita;
                            System.out
                                    .println("\nOperazione effettuata. Nuova quantita: " + negozio4.prodotto.quantita);
                        }
                    }

                    break;

                case 6:
                    System.out.println("Chiusura del programma");
                    break;

            }

        } while (scelta != 6); // se scelta è 6, esco dal do-while

        scanner.close();

    }

}

class Prodotto {
    String nome;
    double prezzo;
    int quantita;

    Prodotto(String nome, double prezzo, int quantita) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.quantita = quantita;
    }

    public void riepilogoProdotto() {
        System.out.println("Prodotto: " + nome + " | Prezzo: " + prezzo + " | Quantità: " + quantita);
    }
}

class Negozio {

    String nome;
    Prodotto prodotto;

    Negozio(String nome) {
        this.nome = nome;
    }

    public void riepilogoNegozio() {
        System.out.println("\nNegozio: " + nome);
        if (prodotto != null) {
            prodotto.riepilogoProdotto();
        } else {
            System.out.println("Nessun prodotto");
        }
    }
}
