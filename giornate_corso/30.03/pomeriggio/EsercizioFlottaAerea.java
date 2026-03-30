import java.util.ArrayList;
import java.util.Scanner;
import java.sql.*;

class Aereo {
    private String modello;
    private int numeroPosti;
    private String codice;

    private boolean inVolo; // per l'extra-extra
    private String aeroporto;

    public Aereo(String modello, int numeroPosti, String codice, String aeroporto) {
        this.modello = modello;
        setNumeroPosti(numeroPosti);
        this.codice = codice;
        this.aeroporto = aeroporto;
        this.inVolo = false; // valore di default false
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public int getNumeroPosti() {
        return numeroPosti;
    }

    public void setNumeroPosti(int numeroPosti) {
        if (numeroPosti > 0) {
            this.numeroPosti = numeroPosti;
        } else {
            System.out.println("Errore: numero posti deve essere > 0");
        }
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String toString() {
        int contatore = 0;
        contatore++;
        String stato = "";

        if (inVolo) { // piccolo controllo per lo stato
            stato = "in volo";
        } else {
            stato = "fermo all'aeroporto " + getAeroporto();
        }

        return contatore + " - Modello: " + modello + ", Numero di Posti: " + numeroPosti + ", Codice: " + codice +
                ", Stato: " + stato;
    }

    public boolean isInVolo() {
        return inVolo;
    }

    public String getAeroporto() {
        return aeroporto;
    }

    public void setAeroporto(String aeroporto) {
        if (!inVolo) { // se non è in volo posso settare l'aeroporto
            this.aeroporto = aeroporto;
        } else {
            System.out.println("aereo attualmente in volo");
        }
    }

    public void partire() {
        if (!inVolo) { // verifico non sia in volo
            inVolo = true; // setto variabile su true (in volo)
            aeroporto = null; // non è più in nessun aeroporto
            System.out.println("Aereo partito");
        } else {
            System.out.println("Aereo già in volo");
        }
    }

    public void atterrare(String aeroporto) { // opposto di partire()
        if (inVolo) { // se si trova in volo
            inVolo = false; // setto non in volo
            this.aeroporto = aeroporto; // assegno aeroporto
            System.out.println("Aereo atterrato a " + aeroporto);
        } else { // altrimenti stampo dove si trova
            System.out.println("Aereo è fermo all'aeroporto: " + getAeroporto());
        }
    }
}

class Pilota {
    private String nome;
    private String numeroBrevetto;
    private int oreVolo;

    private boolean inVolo;

    public Pilota(String nome, String numeroBrevetto, int oreVolo) {
        this.nome = nome;
        this.numeroBrevetto = numeroBrevetto;
        setOreVolo(oreVolo);
        this.inVolo = false;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumeroBrevetto() {
        return numeroBrevetto;
    }

    public void setNumeroBrevetto(String numeroBrevetto) {
        this.numeroBrevetto = numeroBrevetto;
    }

    public int getOreVolo() {
        return oreVolo;
    }

    public void setOreVolo(int oreVolo) {
        if (oreVolo > 0) {
            this.oreVolo = oreVolo;
        } else {
            System.out.println("Errore: ore di volo devono essere piu di 0");
        }
    }

    public String toString() {
        int contatore = 0;
        contatore++;
        return contatore + " - Nome: " + nome + ", Numero Brevetto: " + numeroBrevetto + ", Ore di volo: " + oreVolo;
    }

    public boolean isInVolo() {
        return inVolo;
    }

    public void partire() {
        if (!inVolo) {
            inVolo = true;
        } else {
            System.out.println("Pilota già in volo");
        }
    }

    public void atterrare() {
        if (inVolo) {
            inVolo = false;
        }
    }
}

class CompagniaAerea {
    private String nome;
    private ArrayList<Aereo> flotta;
    private ArrayList<Pilota> piloti;

    public CompagniaAerea(String nome) {
        this.nome = nome;
        this.flotta = new ArrayList<>();
        this.piloti = new ArrayList<>();
    }

    public void aggiungiAereo(Aereo a) {
        flotta.add(a);

        try (Connection oggettoConnessione = Connessione.getConnection()) {
            String sql = "INSERT INTO aerei VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = oggettoConnessione.prepareStatement(sql);
            ps.setString(1, a.getCodice()); // setto i parametri su db recuperandoli con i get
            ps.setString(2, a.getModello());
            ps.setInt(3, a.getNumeroPosti());
            ps.setBoolean(4, a.isInVolo());
            ps.setString(5, a.getAeroporto());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void aggiungiPilota(Pilota p) {
        piloti.add(p);

        try (Connection oggettoConnessione = Connessione.getConnection()) {
            String sql = "INSERT INTO piloti VALUES (?, ?, ?, ?)";
            PreparedStatement ps = oggettoConnessione.prepareStatement(sql);
            ps.setString(1, p.getNumeroBrevetto());
            ps.setString(2, p.getNome());
            ps.setInt(3, p.getOreVolo());
            ps.setBoolean(4, p.isInVolo());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void stampaAerei() {
        for (Aereo a : flotta) {
            System.out.println(a);
        }
    }

    public void stampaPiloti() {
        for (Pilota p : piloti) {
            System.out.println(p);
        }
    }

    public Aereo cercaAereo(String codice) {
        for (Aereo a : flotta) {
            if (a.getCodice().equalsIgnoreCase(codice)) {
                return a;
            }
        }
        return null;
    }

    public Pilota cercaPilota(String brevetto) {
        for (Pilota p : piloti) {
            if (p.getNumeroBrevetto().equalsIgnoreCase(brevetto)) {
                return p;
            }
        }
        return null;
    }

    public void farPartire(String codiceAereo, String brevettoPilota) {
        Aereo aereo = cercaAereo(codiceAereo);
        Pilota pilota = cercaPilota(brevettoPilota);

        if (aereo == null) {
            System.out.println("Aereo non trovato");
            return;
        } else if (pilota == null) {
            System.out.println("Pilota non trovato");
        } else if (aereo.isInVolo()) {
            System.out.println("Aereo già in volo");
        } else if (pilota.isInVolo()) {
            System.out.println("Pilota gia in volo");
        } else {
            aereo.partire();
            pilota.partire();

            System.out.println("Decollo effettuato");
        }
    }

    public void farAtterrare(String codiceAereo, String brevettoPilota, String aeroporto) {
        Aereo aereo = cercaAereo(codiceAereo);
        Pilota pilota = cercaPilota(brevettoPilota);

        if (aereo == null || pilota == null) {
            System.out.println("Aereo o pilota non trovato");
            return;
        }

        if (!aereo.isInVolo()) {
            System.out.println("Aereo non in volo");
            return;
        }

        aereo.atterrare(aeroporto);
        pilota.atterrare();

        System.out.println("Atterraggio completato");
    }
}

class Connessione {
    private static final String URL = "jdbc:mysql://localhost:3306/flotta_aerea";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

public class EsercizioFlottaAerea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CompagniaAerea compagnia = new CompagniaAerea("CompagniaAereaProva");

        int scelta;

        do {
            System.out.println("\n\tMENU");
            System.out.println("1. Aggiungi Pilota");
            System.out.println("2. Aggiungi Aereo");
            System.out.println("3. Mostra Piloti");
            System.out.println("4. Mostra Aerei");
            System.out.println("5. Cerca Aereo per codice");
            System.out.println("6. Cerca Pilota per brevetto");
            System.out.println("7. Esci");
            System.out.print("Scelta: ");

            scelta = scanner.nextInt();
            scanner.nextLine(); // pulizia buffer

            switch (scelta) {

                case 1:
                    System.out.print("Nome pilota: ");
                    String nome = scanner.nextLine();

                    System.out.print("Numero brevetto: ");
                    String brevetto = scanner.nextLine();

                    System.out.print("Ore di volo: ");
                    int ore = scanner.nextInt();

                    compagnia.aggiungiPilota(new Pilota(nome, brevetto, ore)); // creo gli oggetti direttamente
                                                                               // nell'arraylist
                    break;

                case 2:
                    System.out.print("Modello aereo: ");
                    String modello = scanner.nextLine();

                    System.out.print("Numero posti: ");
                    int posti = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Codice identificativo: ");
                    String codice = scanner.nextLine();

                    compagnia.aggiungiAereo(new Aereo(modello, posti, codice)); // creo gli oggetti direttamente
                                                                                // nell'arraylist
                    break;

                case 3:
                    compagnia.stampaPiloti(); // chiamo metodo classe
                    break;

                case 4:
                    compagnia.stampaAerei(); // chiamo il metodo
                    break;

                case 5:
                    System.out.print("Inserisci codice aereo: ");
                    String codiceDaCercare = scanner.nextLine();
                    Aereo a = compagnia.cercaAereo(codiceDaCercare);

                    if (a != null) { // se esiste stampo le info con l'override di toString
                        System.out.println(a);
                    } else {
                        System.out.println("Aereo non trovato");
                    }
                    break;

                case 6:
                    System.out.print("Inserisci numero brevetto: ");
                    String brevettoDaCercare = scanner.nextLine();
                    Pilota p = compagnia.cercaPilota(brevettoDaCercare);

                    if (p != null) { // se esiste stampo le info con l'override di toString
                        System.out.println(p);
                    } else {
                        System.out.println("Pilota non trovato");
                    }
                    break;

                case 7:
                    System.out.print("Codice aereo: ");
                    String codiceAereo = scanner.nextLine();

                    System.out.print("Numero brevetto pilota: ");
                    String brevettoPilota = scanner.nextLine();

                    compagnia.farPartire(codiceAereo, brevettoPilota);
                    break;

                case 8:
                    System.out.print("Codice aereo: ");
                    String codiceAereo2 = scanner.nextLine();

                    System.out.print("Numero brevetto pilota: ");
                    String brevettoPilota2 = scanner.nextLine();

                    System.out.print("Aeroporto: ");
                    String aeroporto = scanner.nextLine();

                    compagnia.farAtterrare(codiceAereo2, brevettoPilota2, aeroporto);
                    break;

                case 0:
                    System.out.println("Chiusura del programma");
                    break;

                default:
                    System.out.println("Scelta non valida");
            }

        } while (scelta != 7);

        scanner.close();
    }
}

/*
 * CREATE DATABASE flotta_aerea;
 * 
 * CREATE TABLE aerei (
 * codice VARCHAR(50) PRIMARY KEY,
 * modello VARCHAR(100),
 * numero_posti INT
 * in_volo BOOLEAN;
 * aeroporto VARCHAR(100);
 * );
 * 
 * CREATE TABLE piloti (
 * numero_brevetto VARCHAR(50) PRIMARY KEY,
 * nome VARCHAR(100),
 * ore_volo INT
 * in_volo BOOLEAN;
 * );
 */
