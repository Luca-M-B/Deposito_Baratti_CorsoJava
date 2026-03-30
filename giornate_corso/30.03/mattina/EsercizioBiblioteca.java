import java.util.ArrayList;
import java.util.Scanner;

public class EsercizioBiblioteca {

    public static class Libro {
        String titolo;
        String autore;
        String genere;
        int anno;
        boolean inPrestito;
        long dataPrestito;

        Libro(String titolo, String autore, String genere, int anno) {
            this.titolo = titolo;
            this.autore = autore;
            this.genere = genere;
            this.anno = anno;
            this.inPrestito = false;
        }

        public String toString() { // override tiString per stamapre successivamente
            return "Titolo: " + titolo +
                    " - Autore: " + autore +
                    " - Genere: " + genere +
                    " - Anno: " + anno +
                    " - Prestato: " + (inPrestito ? "SI" : "NO");
        }

    }

    public static class Biblioteca {
        ArrayList<Libro> listaLibri;

        Biblioteca() {
            listaLibri = new ArrayList<>();
        }

        void aggiungiLibro(Libro nuovoLibro) { // metodo per aggiungere libro alla biblioteca
            listaLibri.add(nuovoLibro);
            System.out.println("Libro aggiunto");
        }

        void stampaLibri() { // metodo per stampare i libri in biblioteca
            if (listaLibri.size() == 0) {
                System.out.println("Nessun libro presente");
                return;
            }

            System.out.println("\nElenco libri:"); // se ci sono libri nella lista li stampo con il toString overridato
            for (Libro libro : listaLibri) {
                System.out.println(libro);
            }
            System.out.println();
        }

        void prestaLibro(String titolo, Utente utente) { // metodo per prestare libro

            if (utente.libriPresi.size() >= 3) { // faccio il controllo sul numero di libri presi in prestito
                                                 // dall'utente x
                System.out.println("Limite massimo di 3 libri raggiunto.");
                return;
            } else {
                for (Libro libro : listaLibri) {
                    if (libro.titolo.equalsIgnoreCase(titolo)) {
                        if (!libro.inPrestito) { // verifico se dipsonibile
                            libro.inPrestito = true; // setto variabile a true
                            libro.dataPrestito = System.currentTimeMillis();

                            utente.libriPresi.add(libro);

                            System.out.println("Libro dato in prestito");
                        } else {
                            System.out.println("Libro già in prestito");
                        }
                        return;
                    }
                }
            }
            System.out.println("Libro non trovato");
        }

        void mostraLibriInPrestito() { // metodo per mostrare i libri in prestito attraverso la variabile prestato
                                       // settata a true
            boolean trovato = false;

            for (Libro libro : listaLibri) {
                if (libro.inPrestito) {
                    System.out.println(libro);
                    trovato = true;
                }
            }

            if (!trovato) {
                System.out.println("Nessun libro in prestito");
            }
        }

        void cercaLibro(String parolaDaCercare) {
            boolean trovato = false;

            for (Libro libro : listaLibri) {
                if (libro.titolo.toLowerCase().contains(parolaDaCercare.toLowerCase()) || // se la parola è presente nel
                                                                                          // titolo o nell'autore
                        libro.autore.toLowerCase().contains(parolaDaCercare.toLowerCase())) {

                    System.out.println(libro);
                    trovato = true;
                }
            }

            if (!trovato) {
                System.out.println("Nessun risultato trovato");
            }
        }

        void restituisciLibro(String titolo) {
            for (Libro libro : listaLibri) {
                if (libro.titolo.equalsIgnoreCase(titolo)) {
                    if (libro.inPrestito) {
                        libro.inPrestito = false; // riporto a false la variabile
                        libro.dataPrestito = 0; // variabile da aggiungere per classe libro

                        System.out.println("Libro restituito correttamente");
                    } else {
                        System.out.println("Il libro non era in prestito");
                    }
                    return;
                }
            }
            System.out.println("Libro non trovato");
        }
    }

    public static class Utente {
        String nome;
        ArrayList<Libro> libriPresi;

        Utente(String nome) {
            this.nome = nome;
            this.libriPresi = new ArrayList<>();
        }
    }

    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();

        Utente utente = new Utente("Pippo");

        Scanner scannerString = new Scanner(System.in);
        Scanner scannerInt = new Scanner(System.in);

        int scelta;

        do {
            System.out.println("--- MENU BIBLIOTECA ---");
            System.out.println("1. Aggiungi Libro");
            System.out.println("2. Visualizza Libri");
            System.out.println("3. Presta Libro");
            System.out.println("4. Libri in Prestito");
            System.out.println("5. Cerca Libro");
            System.out.println("6. Restituisci Libro");
            System.out.println("7. Cerca Libro");
            System.out.println("8. Verifica Ritardi");
            System.out.println("9. Esci");
            System.out.print("Scelta: ");

            scelta = scannerInt.nextInt();
            // scannerString.nextLine(); // pulizia buffer

            switch (scelta) {

                case 1:
                    System.out.println("Digitare le informazioni del libro.");
                    System.out.println("Titolo: ");
                    String titolo = scannerString.nextLine();

                    System.out.println("Autore: ");
                    String autore = scannerString.nextLine();

                    System.out.println("Genere: ");
                    String genere = scannerString.nextLine();

                    System.out.println("Anno: ");
                    int anno = scannerInt.nextInt();
                    scannerString.nextLine();

                    biblioteca.aggiungiLibro(new Libro(titolo, autore, genere, anno)); // creo libro direttamente dentro
                                                                                       // l'array
                    break;

                case 2:
                    biblioteca.stampaLibri(); // chiamo il metodo per stamapre
                    break;

                case 3:
                    System.out.print("Titolo libro: ");
                    String titoloPrestito = scannerString.nextLine();
                    biblioteca.prestaLibro(titoloPrestito, utente);
                    break;

                case 4:
                    biblioteca.mostraLibriInPrestito();
                    break;

                case 5:
                    System.out.println("Ricerca (se non si conosce l'informazione lasciare vuotopremendo invio):");

                    System.out.print("Titolo: ");
                    String cercaTitolo = scannerString.nextLine();

                    System.out.print("Autore: ");
                    String cercaAutore = scannerString.nextLine();

                    System.out.print("Genere: ");
                    String cercaGenere = scannerString.nextLine();

                    System.out.print("Anno (0 per ignorare): ");
                    int cercaAnno = scannerInt.nextInt();
                    scannerString.nextLine();

                    biblioteca.cercaLibro(cercaTitolo, cercaAutore, cercaGenere, cercaAnno);
                    break;

                case 6:
                    System.out.print("Titolo da restituire: ");
                    String titoloRestituzione = scannerString.nextLine();
                    biblioteca.restituisciLibro(titoloRestituzione);
                    break;

                case 7:
                    System.out.print("Parola da cercare: ");
                    String keyword = scannerString.nextLine();
                    biblioteca.cercaLibro(keyword);
                    break;

                case 8:
                    biblioteca.verificaRitardi();
                    break;

                case 9:
                    System.out.println("Chiusura programma");
                    break;

                default:
                    System.out.println("Scelta non valida");
            }

        } while (scelta != 9);

        scannerString.close();
        scannerInt.close();
    }

}
