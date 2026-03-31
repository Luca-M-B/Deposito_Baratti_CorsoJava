import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;;

class Astronauta {
    protected String nome;
    protected String email;
    protected float creditoOssigeno;

    public Astronauta(String nome, String email) {
        this.nome = nome;
        this.email = email;
        generaOssigeno();
    }

    public void generaOssigeno() {
        Random random = new Random();
        creditoOssigeno = 200 + random.nextFloat() * 50;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Email: " + email + ", Credito Ossigeno: " + creditoOssigeno;
    }

}

class StazioneSpaziale {
    ArrayList<String> esperimenti = new ArrayList<>();
    ArrayList<Integer> valutazioni = new ArrayList<>();

    public void aggiungiEsperimento(String esperimento) {
        esperimenti.add(esperimento);
    }

    public void aggiungiValutazione(int valutazione) {
        valutazioni.add(valutazione);
    }

    public void stampaEsperimenti() {
        for (String esperimento : esperimenti) {
            System.out.println("- " + esperimento);
        }
    }

    public void stampaValutazioni() {
        for (int valutazione : valutazioni) {
            System.out.println("- " + valutazione);
        }
    }
}

class Scienziato extends Astronauta {
    protected int azioni = 0;

    public Scienziato(String nome, String email) {
        super(nome, email);
    }

    public void aggiungiEsperimento(StazioneSpaziale stazione, String esperimento) {
        stazione.aggiungiEsperimento(esperimento);
        azioni++; // incremento per tenere il conto
    }

    public boolean isCapo() {
        return azioni >= 3; // controllo per verificare che sia diventato capo
    }
}

class ScienziatoCapo extends Scienziato {
    public ScienziatoCapo(String nome, String email) {
        super(nome, email);
    }

    public void stampaTuttiEsperimenti(StazioneSpaziale stazione) {
        System.out.println("Esperimenti");
        stazione.stampaEsperimenti();
    }
}

class Ispettore extends Astronauta {
    protected int azioni = 0;

    public Ispettore(String nome, String email) {
        super(nome, email);
    }

    public void aggiungiValutazione(StazioneSpaziale stazione, int valutazione) {
        stazione.aggiungiValutazione(valutazione);
        azioni++;
    }

    public boolean isEsperto() {
        return azioni >= 3;
    }
}

class IspettoreEsperto extends Ispettore {
    public IspettoreEsperto(String nome, String email) {
        super(nome, email);
    }

    public void stampaTutteValutazioni(StazioneSpaziale stazione) {
        System.out.println("Valutazioni");
        stazione.stampaValutazioni();
    }
}

public class EsercizioSpazio {

    public static void main(String[] args) {

        Scanner scannerString = new Scanner(System.in);
        Scanner scannerInt = new Scanner(System.in);

        int scelta;

        // Astronauta astronauta = null;
        Scienziato scienziato = null; // oggetto necessario per le operazioni successive
        Ispettore ispettore = null;

        StazioneSpaziale stazione = new StazioneSpaziale();

        do {
            System.out.println("\n\tMENU");
            System.out.println("1. Crea Astronauta");
            System.out.println("2. Visualizza dati");
            System.out.println("3. Login (rigenera ossigeno)");
            System.out.println("4. Interagire");
            System.out.println("5. Esci");

            scelta = scannerInt.nextInt();

            switch (scelta) {

                case 1:

                    System.out.print("Nome: ");
                    String nome = scannerString.nextLine();

                    System.out.print("Email: ");
                    String email = scannerString.nextLine();

                    System.out.print("Pianeta preferito (Marte, Giove, Venere, Saturno, Nettuno, Plutone): ");
                    String pianeta = scannerString.nextLine();

                    if (pianeta.equalsIgnoreCase("Marte") || pianeta.equalsIgnoreCase("Giove") ||
                            pianeta.equalsIgnoreCase("Venere")) {
                        scienziato = new Scienziato(nome, email);
                        ispettore = null; // reset
                    } else {
                        ispettore = new Ispettore(nome, email);
                        scienziato = null; // reset
                    }

                    break;

                case 2:

                    // controllo sse è stato creato uno Scienziato o un Ispettore
                    if (scienziato != null) {
                        System.out.println(scienziato); // stampa dati dello scienziato
                        // scienziato.toString();
                    } else if (ispettore != null) {
                        System.out.println(ispettore); // stampa dati dell’ispettore
                        // ispettore.toString();
                    } else {
                        System.out.println("Nessun astronauta creato.");
                    }

                    break;

                case 3:

                    if (scienziato != null) { // per ricaricare ossigeno effettuo login
                        scienziato.generaOssigeno();
                        System.out.println("Login effettuato (Scienziato)");
                    } else if (ispettore != null) {
                        ispettore.generaOssigeno();
                        System.out.println("Login effettuato (Ispettore)");
                    } else {
                        System.out.println("Nessun astronauta creato.");
                    }
                    break;

                case 4:

                    // caso Scienziato
                    if (scienziato != null) {

                        System.out.print("Inserisci esperimento: ");
                        String esperimento = scannerString.nextLine();

                        scienziato.aggiungiEsperimento(stazione, esperimento);

                        // promozione automatica alla terza azione
                        if (scienziato.isCapo()) {

                            ScienziatoCapo nuovo = new ScienziatoCapo(scienziato.nome, scienziato.email);
                            nuovo.azioni = scienziato.azioni;

                            scienziato = nuovo;

                            System.out.println("Promosso a Scienziato Capo!");

                            nuovo.stampaTuttiEsperimenti(stazione);
                        }
                    }

                    // caso Ispettore
                    else if (ispettore != null) {

                        System.out.print("Inserisci valutazione (1-5): ");
                        int valutazione = scannerInt.nextInt();

                        ispettore.aggiungiValutazione(stazione, valutazione);

                        // promozione automatica alla terza azione
                        if (ispettore.isEsperto()) {

                            IspettoreEsperto nuovo = new IspettoreEsperto(ispettore.nome, ispettore.email);
                            nuovo.azioni = ispettore.azioni;

                            ispettore = nuovo;

                            System.out.println("Promosso a Ispettore Esperto!");

                            // uso metodo classe capo
                            nuovo.stampaTutteValutazioni(stazione);
                        }
                    }

                    else {
                        System.out.println("E' necessario creare un astronauta.");
                    }

                    break;

                case 5:
                    System.out.println("Uscita.");
                    break;

                default:
                    System.out.println("Scelta non valida.");
            }

        } while (scelta != 5);

        scannerInt.close();
        scannerString.close();
    }
}