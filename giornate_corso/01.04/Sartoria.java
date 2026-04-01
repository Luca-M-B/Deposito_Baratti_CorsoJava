import java.util.ArrayList;
import java.util.Scanner;

/*
avrei voluto utilizzare degli enumeratori per poter stabilire le taglie in modo da 
non avere taglie S, s, o 44 ma unificandole tutte, almeno per ogni classe se non 
addirittura generalizzando il tutto.
Utilizzando una classe Utente che sceglie e compra abiti, avrei anche inserito la possibilità 
di avere uno sconto nel caso fossero stati acquistati abiti completi o almeno tre elementi.
*/

class CapiPrincipali extends Capo {
    private String codice;
    private String nome;
    private String tessuto;
    private String colore;
    private String taglia;
    private double prezzo;

    public CapiPrincipali(String nome, String tessuto, String colore, String taglia, double prezzo) { // costruttore
        setNome(nome);
        setTessuto(tessuto);
        setColore(colore);
        setTaglia(taglia);
        setPrezzo(prezzo);
    }

    protected void setCodice(String codice) {
        this.codice = codice;
    }

    public void setNome(String nome) { // controllo nome
        if (nome == null || nome.isEmpty()) {
            System.out.println("Nome non valido");
        }
        this.nome = nome;
    }

    public void setTessuto(String tessuto) {
        this.tessuto = tessuto;
    }

    public void setColore(String colore) { // controllo colore
        if (colore == null || colore.isEmpty()) {
            System.out.println("Colore non valido");
        }
        this.colore = colore;
    }

    public void setTaglia(String taglia) { // controllo taglia
        if (taglia == null || taglia.isEmpty()) {
            System.out.println("Taglia non valida");
        }
        this.taglia = taglia;
    }

    public void setPrezzo(double prezzo) { // controllo prezzo
        if (prezzo <= 0) {
            System.out.println("Prezzo non valido");
        }
        this.prezzo = prezzo;
    }

    public void mostraDettagli() {
        System.out.println("Codice: " + codice + ", Nome: " + nome + ", Tessuto: " + tessuto +
                ", Colore: " + colore + ", Taglia: " + taglia + ", Prezzo: " + prezzo);
    }
}

class CapiSecondari extends Capo {
    private String codice;
    private String nome;
    private String materiale;
    private String colore;
    private double prezzo;

    public CapiSecondari(String nome, String materiale, String colore, double prezzo) {
        setNome(nome);
        setMateriale(materiale);
        setColore(colore);
        setPrezzo(prezzo);
    }

    protected void setCodice(String codice) {
        this.codice = codice;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            System.out.println("Nome non valido");
        }
        this.nome = nome;
    }

    public void setMateriale(String materiale) {
        this.materiale = materiale;
    }

    public void setColore(String colore) {
        if (colore == null || colore.isEmpty()) {
            System.out.println("Colore non valido");
        }
        this.colore = colore;
    }

    public void setPrezzo(double prezzo) {
        if (prezzo <= 0) {
            System.out.println("Prezzo non valido");
        }
        this.prezzo = prezzo;
    }

    public void mostraDettagli() {
        System.out.println("Codice: " + codice + ", Nome: " + nome +
                ", Materiale: " + materiale + ", Colore: " + colore + ", Prezzo: " + prezzo);
    }
}

class Camicia extends CapiPrincipali {
    private static int contatore = 0; // per codici univoci
    private String tipoColletto;
    private String tipoPolsino;

    public Camicia(String nome, String tessuto, String colore, String taglia, double prezzo,
            String tipoColletto, String tipoPolsino) {

        super(nome, tessuto, colore, taglia, prezzo);

        String codice = String.format("CAM00AA%02d", ++contatore); // per non avere codici ripetuti e per un eventuale
                                                                   // ricerca per tipologia (oltre che per classe di
                                                                   // derivazione)
        setCodice(codice);

        if (tipoColletto == null || tipoColletto.isEmpty() ||
                tipoPolsino == null || tipoPolsino.isEmpty()) {
            System.out.println("Caratteristiche camicia non valide");
        }

        this.tipoColletto = tipoColletto;
        this.tipoPolsino = tipoPolsino;
    }

    public void mostraDettagli() {
        super.mostraDettagli();
        System.out.println("Colletto: " + tipoColletto + ", Polsino: " + tipoPolsino);
    }
}

class Giacca extends CapiPrincipali {
    private static int contatore = 0;
    private int numeroBottoni;

    public Giacca(String nome, String tessuto, String colore, String taglia, double prezzo,
            int numeroBottoni) {

        super(nome, tessuto, colore, taglia, prezzo);

        String codice = String.format("GIA00AA%02d", ++contatore);
        setCodice(codice);

        if (numeroBottoni <= 0) {
            System.out.println("Numero bottoni non valido");
        }

        this.numeroBottoni = numeroBottoni;
    }

    public void mostraDettagli() {
        super.mostraDettagli();
        System.out.println("Bottoni: " + numeroBottoni);
    }
}

class Pantalone extends CapiPrincipali {
    private static int contatore = 0;
    private String tipoTaglio;

    public Pantalone(String nome, String tessuto, String colore, String taglia, double prezzo,
            String tipoTaglio) {

        super(nome, tessuto, colore, taglia, prezzo);

        String codice = String.format("PAN00AA%02d", ++contatore);
        setCodice(codice);

        if (tipoTaglio == null || tipoTaglio.isEmpty()) {
            System.out.println("Tipo taglio non valido");
        }

        this.tipoTaglio = tipoTaglio;
    }

    public void mostraDettagli() {
        super.mostraDettagli();
        System.out.println("Taglio: " + tipoTaglio);
    }
}

class Gilet extends CapiPrincipali {
    private static int contatore = 0;
    private boolean reverPresente;

    public Gilet(String nome, String tessuto, String colore, String taglia, double prezzo,
            boolean reverPresente) {

        super(nome, tessuto, colore, taglia, prezzo);

        String codice = String.format("GIL00AA%02d", ++contatore);
        setCodice(codice);

        this.reverPresente = reverPresente;
    }

    public void mostraDettagli() {
        super.mostraDettagli();

        if (reverPresente) {
            System.out.println("Rever: Presente");
        } else {
            System.out.println("Rever: Assente");
        }
    }
}

class Cravatta extends CapiSecondari {
    private static int contatore = 0;
    private double larghezza;

    public Cravatta(String nome, String materiale, String colore, double prezzo, double larghezza) {

        super(nome, materiale, colore, prezzo);

        String codice = String.format("CRA00AA%02d", ++contatore);
        setCodice(codice);

        if (larghezza <= 0) {
            System.out.println("Larghezza non valida");
        }

        this.larghezza = larghezza;
    }

    public void mostraDettagli() {
        super.mostraDettagli();
        System.out.println("Larghezza: " + larghezza);
    }
}

class Papillon extends CapiSecondari {
    private static int contatore = 0;
    private String tipoChiusura;

    public Papillon(String nome, String materiale, String colore, double prezzo, String tipoChiusura) {

        super(nome, materiale, colore, prezzo);

        String codice = String.format("PAP00AA%02d", ++contatore);
        setCodice(codice);

        if (tipoChiusura == null || tipoChiusura.isEmpty()) {
            System.out.println("Chiusura non valida");
        }

        this.tipoChiusura = tipoChiusura;
    }

    public void mostraDettagli() {
        super.mostraDettagli();
        System.out.println("Chiusura: " + tipoChiusura);
    }
}

class Pochette extends CapiSecondari {
    private static int contatore = 0;
    private String piega;

    public Pochette(String nome, String materiale, String colore, double prezzo, String piega) {

        super(nome, materiale, colore, prezzo);

        String codice = String.format("POC00AA%02d", ++contatore);
        setCodice(codice);

        if (piega == null || piega.isEmpty()) {
            System.out.println("Piega non valida");
        }

        this.piega = piega;
    }

    public void mostraDettagli() {
        super.mostraDettagli();
        System.out.println("Piega: " + piega);
    }
}

class GestioneSartoria {

    private ArrayList<Capo> capi;

    public GestioneSartoria() { // nel costruttore inizializzo una lista
        capi = new ArrayList<>();
    }

    public void aggiungiCapo(Capo capo) {
        if (capo != null) {
            capi.add(capo);
        } else {
            System.out.println("Nessun capo da aggiungere");
        }
    }

    public void mostraTutto() { // per mostrare tutti id ettagli dei capi salvati
        System.out.println("\n\tELENCO COMPLETO CAPI");

        if (capi.isEmpty()) {
            System.out.println("Nessun capo presente");
            return;
        }

        for (Capo capo : capi) {
            capo.mostraDettagli();
            System.out.println();
        }
    }
}

class Capo { // classe per gestire tutte le restanti classi
    private String codice;
    private String nome;
    private String colore;
    private double prezzo;

    protected void setCodice(String codice) {
        this.codice = codice;
    }

    public void mostraDettagli() {
        System.out.println("Codice: " + codice + ", Nome: " + nome + ", Colore: " + colore + ", Prezzo: " + prezzo);
    }
}

public class Sartoria {
    public static void main(String[] args) {

        Scanner scannerMenu = new Scanner(System.in);
        Scanner scannerInput = new Scanner(System.in);

        GestioneSartoria gestione = new GestioneSartoria(); // creando l'oggetto GestioneSartoria automaticamente
                                                            // inizializzo anche la sua ArrayList

        int scelta;

        do {
            System.out.println("\n\tMENU SARTORIA");
            System.out.println("1. Aggiungi Camicia");
            System.out.println("2. Aggiungi Giacca");
            System.out.println("3. Aggiungi Pantalone");
            System.out.println("4. Aggiungi Gilet");
            System.out.println("5. Aggiungi Cravatta");
            System.out.println("6. Aggiungi Papillon");
            System.out.println("7. Aggiungi Pochette");
            System.out.println("8. Mostra riepilogo");
            System.out.println("9. Esci");
            System.out.println("\nScelta: ");

            scelta = scannerMenu.nextInt();

            switch (scelta) {

                case 1: {
                    System.out.print("\nNome: ");
                    String nome = scannerInput.nextLine();

                    System.out.print("Tessuto: ");
                    String tessuto = scannerInput.nextLine();

                    System.out.print("Colore: ");
                    String colore = scannerInput.nextLine();

                    System.out.print("Taglia: ");
                    String taglia = scannerInput.nextLine();

                    System.out.print("Prezzo: ");
                    double prezzo = scannerInput.nextDouble();
                    scannerInput.nextLine();

                    System.out.print("Tipo colletto: ");
                    String colletto = scannerInput.nextLine();

                    System.out.print("Tipo polsino: ");
                    String polsino = scannerInput.nextLine();

                    gestione.aggiungiCapo(new Camicia(nome, tessuto, colore, taglia, prezzo, colletto, polsino));
                    break;
                }

                case 2: {
                    System.out.print("\nNome: ");
                    String nome = scannerInput.nextLine();

                    System.out.print("Tessuto: ");
                    String tessuto = scannerInput.nextLine();

                    System.out.print("Colore: ");
                    String colore = scannerInput.nextLine();

                    System.out.print("Taglia: ");
                    String taglia = scannerInput.nextLine();

                    System.out.print("Prezzo: ");
                    double prezzo = scannerInput.nextDouble();

                    System.out.print("Numero bottoni: ");
                    int bottoni = scannerInput.nextInt();
                    scannerInput.nextLine();

                    gestione.aggiungiCapo(new Giacca(nome, tessuto, colore, taglia, prezzo, bottoni));
                    break;
                }

                case 3: {
                    System.out.print("\nNome: ");
                    String nome = scannerInput.nextLine();

                    System.out.print("Tessuto: ");
                    String tessuto = scannerInput.nextLine();

                    System.out.print("Colore: ");
                    String colore = scannerInput.nextLine();

                    System.out.print("Taglia: ");
                    String taglia = scannerInput.nextLine();

                    System.out.print("Prezzo: ");
                    double prezzo = scannerInput.nextDouble();
                    scannerInput.nextLine();

                    System.out.print("Tipo taglio: ");
                    String taglio = scannerInput.nextLine();

                    gestione.aggiungiCapo(new Pantalone(nome, tessuto, colore, taglia, prezzo, taglio));
                    break;
                }

                case 4: {
                    System.out.print("\nNome: ");
                    String nome = scannerInput.nextLine();

                    System.out.print("Tessuto: ");
                    String tessuto = scannerInput.nextLine();

                    System.out.print("Colore: ");
                    String colore = scannerInput.nextLine();

                    System.out.print("Taglia: ");
                    String taglia = scannerInput.nextLine();

                    System.out.print("Prezzo: ");
                    double prezzo = scannerInput.nextDouble();

                    System.out.print("Rever presente (true/false): ");
                    boolean rever = scannerInput.nextBoolean();
                    scannerInput.nextLine();

                    gestione.aggiungiCapo(new Gilet(nome, tessuto, colore, taglia, prezzo, rever));
                    break;
                }

                case 5: {
                    System.out.print("\nNome: ");
                    String nome = scannerInput.nextLine();

                    System.out.print("Materiale: ");
                    String materiale = scannerInput.nextLine();

                    System.out.print("Colore: ");
                    String colore = scannerInput.nextLine();

                    System.out.print("Prezzo: ");
                    double prezzo = scannerInput.nextDouble();

                    System.out.print("Larghezza: ");
                    double larghezza = scannerInput.nextDouble();
                    scannerInput.nextLine();

                    gestione.aggiungiCapo(new Cravatta(nome, materiale, colore, prezzo, larghezza));
                    break;
                }

                case 6: {
                    System.out.print("\nNome: ");
                    String nome = scannerInput.nextLine();

                    System.out.print("Materiale: ");
                    String materiale = scannerInput.nextLine();

                    System.out.print("Colore: ");
                    String colore = scannerInput.nextLine();

                    System.out.print("Prezzo: ");
                    double prezzo = scannerInput.nextDouble();
                    scannerInput.nextLine();

                    System.out.print("Tipo chiusura: ");
                    String chiusura = scannerInput.nextLine();

                    gestione.aggiungiCapo(new Papillon(nome, materiale, colore, prezzo, chiusura));
                    break;
                }

                case 7: {
                    System.out.print("\nNome: ");
                    String nome = scannerInput.nextLine();

                    System.out.print("Materiale: ");
                    String materiale = scannerInput.nextLine();

                    System.out.print("Colore: ");
                    String colore = scannerInput.nextLine();

                    System.out.print("Prezzo: ");
                    double prezzo = scannerInput.nextDouble();
                    scannerInput.nextLine();

                    System.out.print("Tipo piega: ");
                    String piega = scannerInput.nextLine();

                    gestione.aggiungiCapo(new Pochette(nome, materiale, colore, prezzo, piega));
                    break;
                }

                case 8:
                    gestione.mostraTutto();
                    break;

                case 9:
                    System.out.println("Chiusura  programma");
                    break;

                default:
                    System.out.println("Scelta non valida");
            }

        } while (scelta != 9);

        scannerMenu.close();
        scannerInput.close();
    }
}