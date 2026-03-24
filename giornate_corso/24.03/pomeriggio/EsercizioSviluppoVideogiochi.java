import java.util.Scanner;

public class EsercizioSviluppoVideogiochi {

    public static void main(String[] args) {

        Scanner scannerInt = new Scanner(System.in); // creo due scanner
        Scanner scannerString = new Scanner(System.in);
        int scelta; // variabile per scanner

        Team team1 = new Team("Team-A", 10); // creo tre oggetti Team
        Team team2 = new Team("Team-B", 5);
        Team team3 = new Team("Team-C", 25);

        do {
            System.out.println(
                    "\n\tGESTIONALE SOFTWARE HOUSE\n1- Assegna gioco a un Team\n2- Visualizza tutti i Team\n3- Visualizza situazione Team 1Cerca gioco con costo di sviluppo più alto\n4- Modifica stato di un gioco\n5- Crea nuovo Team\n6- Esci");
            System.out.print("Scelta: ");
            scelta = scannerInt.nextInt();

            switch (scelta) {

                case 1:
                    System.out.println("\nA quale team vuoi assegnare un gioco?\n1-" + team1.nome + "\n2-" + team2.nome
                            + "\n3-" + team3.nome);
                    int sceltaTeam = scannerInt.nextInt();

                    System.out.print("\nTitolo gioco: ");
                    String titolo = scannerString.nextLine();
                    System.out.print("\nGenere: ");
                    String genere = scannerString.nextLine();
                    System.out.print("\nCosto sviluppo: ");
                    double costo = scannerInt.nextDouble();
                    System.out.print("\nStato (in sviluppo/in test/pubblicato): ");
                    String stato = scannerString.nextLine();

                    Gioco nuovoGioco = new Gioco(titolo, genere, costo, stato); // creo un oggetto gioco in base ai
                                                                                // parametri inseriti

                    if (sceltaTeam == 1) { // assegno l'oggetto al team corrispondente alla scelta
                        team1.giocoAssegnato = nuovoGioco;
                    } else if (sceltaTeam == 2) {
                        team2.giocoAssegnato = nuovoGioco;
                    } else if (sceltaTeam == 3) {
                        team3.giocoAssegnato = nuovoGioco;
                    } else {
                        System.out.println("Scelta non valida.");
                    }

                    break;

                case 2:

                    team1.mostraInfoTeam();
                    team2.mostraInfoTeam();
                    team3.mostraInfoTeam();

                    break;

                case 3:

                    double maxCosto = 0.0; // inizializzo variabile costo e variabile gioco, in base al check successivo
                                           // andrò a valorizzarle con il costo piu alto e con il nome dle gioco
                                           // relativo
                    String nomeGiocoCaro = "";

                    if (team1.giocoAssegnato != null && team1.giocoAssegnato.costoSviluppo > maxCosto) { // controllo
                                                                                                         // per ogni
                                                                                                         // team che ci
                                                                                                         // sia un
                                                                                                         // oggetto
                                                                                                         // gioco
                                                                                                         // assegnato e
                                                                                                         // confronto il
                                                                                                         // costo di
                                                                                                         // tale oggetto
                                                                                                         // con la
                                                                                                         // variabile,
                                                                                                         // valorizzandola
                                                                                                         // solo se è
                                                                                                         // più alto
                        maxCosto = team1.giocoAssegnato.costoSviluppo;
                        nomeGiocoCaro = team1.giocoAssegnato.titolo;
                    }
                    if (team2.giocoAssegnato != null && team2.giocoAssegnato.costoSviluppo > maxCosto) {
                        maxCosto = team2.giocoAssegnato.costoSviluppo;
                        nomeGiocoCaro = team2.giocoAssegnato.titolo;
                    }
                    if (team3.giocoAssegnato != null && team3.giocoAssegnato.costoSviluppo > maxCosto) {
                        maxCosto = team3.giocoAssegnato.costoSviluppo;
                        nomeGiocoCaro = team3.giocoAssegnato.titolo;
                    }

                    if (maxCosto != 0.0) {
                        System.out.println("\nIl gioco più costoso è: " + nomeGiocoCaro + " con " + maxCosto
                                + " euro di costo di sviluppo.");
                    } else {
                        System.out.println("\nNessun gioco presente nei database");
                    }

                    break;

                case 4:

                    System.out
                            .println("\nDi quale team vuoi modificare lo stato del gioco?\n1-TeamA\n2-TeamB\n3-TeamC");
                    scelta = scannerInt.nextInt();
                    System.out.print("Inserisci nuovo stato: ");
                    String nuovoStato = scannerString.nextLine();

                    if (scelta == 1 && team1.giocoAssegnato != null) { // controllo la scelta e che l'oggetto gioco non
                                                                       // sia ancora null
                        team1.giocoAssegnato.statoProgetto = nuovoStato;
                    } else if (scelta == 2 && team2.giocoAssegnato != null) {
                        team2.giocoAssegnato.statoProgetto = nuovoStato;
                    } else if (scelta == 3 && team3.giocoAssegnato != null) {
                        team3.giocoAssegnato.statoProgetto = nuovoStato;
                    } else {
                        System.out.println("Errore: Team vuoto o scelta errata.");
                    }
                    break;

                case 5:
                    System.out.println("\nDigita il nome del nuovo Team:");
                    String nuovoNome = scannerString.nextLine();
                    System.out.println("\nQuanti sviluppatori lavoreranno al team?");
                    int nuovoNumeroSviluppatori = scannerInt.nextInt();
                    System.out.println("Il nuovo team ha gia un gioco assegnato? (si/no)");
                    String nuovaScelta = scannerString.nextLine();

                    if (nuovaScelta.equalsIgnoreCase("no")) {
                        Team team4 = new Team(nuovoNome, nuovoNumeroSviluppatori);
                    } else if (nuovaScelta.equalsIgnoreCase("si")) { // controllo extra se voglio subito creare un nuovo
                                                                     // gioco
                        Team team4 = new Team(nuovoNome, nuovoNumeroSviluppatori);
                        /*
                         * // QUI CHIEDO TITOLO, GENERE, NUMERO SVILUPPATORI, STATO PER CREARE UN
                         * OGGETTO GIOCO
                         * Gioco nuovoGiocoTeam = new Gioco(titolo, genere, nuovoNumeroSviluppatori,
                         * stato);
                         * team4.giocoAssegnato = nuovoGiocoTeam;
                         */
                    }

                    break;

                case 6:
                    System.out.println("Chiusura programma");
                    break;

            }
        } while (scelta != 6); // con scelta 6 esco dal do while

        scannerInt.close(); // chiudo gli scanner
        scannerString.close();
    }
}

class Gioco {
    String titolo;
    String genere;
    double costoSviluppo;
    String statoProgetto;

    Gioco(String titolo, String genere, double costoSviluppo, String statoProgetto) {
        this.titolo = titolo;
        this.genere = genere;
        this.costoSviluppo = costoSviluppo;
        this.statoProgetto = statoProgetto;
    }

    public void stampaDettagli() { // metodo per stampare le info
        System.out.println("Dettagli gioco:\nTitolo: " + titolo + "\nGenere: " + genere +
                "\nCosto sviluppo: " + costoSviluppo + " euro\nStato progetto: " + statoProgetto);
    }
}

class Team {
    String nome;
    int numeroSviluppatori;
    Gioco giocoAssegnato; // ogni team ha un gioco

    Team(String nome, int numeroSviluppatori) {
        this.nome = nome;
        this.numeroSviluppatori = numeroSviluppatori;
        this.giocoAssegnato = null; // inizializzo a null perchè il team potrebbe non avere un gioco
    }

    public void mostraInfoTeam() { // metodo per stampare le info
        System.out.print("Dettagli Team:\nNome: " + nome + "\nNumero sviluppatori: " + numeroSviluppatori
                + "\nGioco assegnato: ");
        if (giocoAssegnato != null) {
            giocoAssegnato.stampaDettagli();
        } else {
            System.out.println("---\t---");
        }
    }
}