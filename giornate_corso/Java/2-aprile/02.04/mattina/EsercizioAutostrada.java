import java.util.ArrayList;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

abstract class Veicolo {

    private String targa;
    private double velocita;
    private int numeroAssi;

    public Veicolo(String targa, double velocita, int numeroAssi) {
        setTarga(targa);
        setVelocita(velocita);
        setNumeroAssi(numeroAssi);
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) { // controllo targa
        if (targa != null && !targa.isEmpty()) {
            this.targa = targa;
        }
    }

    public double getVelocita() {
        return velocita;
    }

    public void setVelocita(double velocita) { // controllo velocita
        if (velocita >= 0) {
            this.velocita = velocita;
        }
    }

    public int getNumeroAssi() {
        return numeroAssi;
    }

    public void setNumeroAssi(int numeroAssi) { // controllo numero assi
        if (numeroAssi >= 0) {
            this.numeroAssi = numeroAssi;
        }
    }

    public abstract double calcolaPedaggio(); // metodo astratto

    @Override
    public String toString() {
        return "Targa: " + targa + ", Velocità: " + velocita + ", Assi: " + numeroAssi;
    }
}

class Auto extends Veicolo {

    private int cilindrata;

    public Auto(String targa, double velocita, int numeroAssi, int cilindrata) {
        super(targa, velocita, numeroAssi);
        setCilindrata(cilindrata);
    }

    public int getCilindrata() {
        return cilindrata;
    }

    public void setCilindrata(int cilindrata) { // controllo cilindrata
        if (cilindrata >= 500) {
            this.cilindrata = cilindrata;
        }
    }

    @Override
    public double calcolaPedaggio() { // da rivedere (gpt)
        return 2.0 + (getNumeroAssi() * 0.5);
    }

    @Override
    public String toString() {
        return "AUTO -> " + super.toString() + ", Cilindrata: " + cilindrata;
    }
}

class Camion extends Veicolo {

    private double peso;

    public Camion(String targa, double velocita, int numeroAssi, double peso) {
        super(targa, velocita, numeroAssi);
        setPeso(peso);
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) { // controllo peso
        if (peso > 0) {
            this.peso = peso;
        }
    }

    @Override
    public double calcolaPedaggio() { // gpt rivedere
        return 5.0 + (getNumeroAssi() * 1.5) + (peso / 10000);
    }

    @Override
    public String toString() {
        return "CAMION -> " + super.toString() + ", Peso: " + peso + " kg";
    }
}

class Moto extends Veicolo {

    private int cilindrata;

    public Moto(String targa, double velocita, int numeroAssi, int cilindrata) {
        super(targa, velocita, numeroAssi);
        setCilindrata(cilindrata);
    }

    public int getCilindrata() {
        return cilindrata;
    }

    public void setCilindrata(int cilindrata) { // controllo cilindrata
        if (cilindrata >= 125) {
            this.cilindrata = cilindrata;
        }
    }

    @Override
    public double calcolaPedaggio() { // gpt rivedere
        return 1.0 + (getNumeroAssi() * 0.3);
    }

    @Override
    public String toString() {
        return "MOTO -> " + super.toString() + ", Cilindrata: " + cilindrata;
    }
}

class GestoreVeicoli {
    private ArrayList<Veicolo> veicoli;

    public GestoreVeicoli() { // inizializzo l'arraylist alla creazione di un oggetto gestore
        this.veicoli = new ArrayList<>();
    }

    public void aggiungiVeicolo(Veicolo veicolo) { // metodo per aggiungere oggetti Veicolo o derivati alla lista
        if (cercaPerTarga(veicolo.getTarga()) != null) { // controllo per targhe duplicate
            System.out.println("Targa già esistente");
            return;
        }
        veicoli.add(veicolo);
    }

    public void stampaVeicoli() { // metodo per stampare tutti i veicoli della lista
        for (Veicolo veicolo : veicoli) {
            System.out.println(veicolo);
            System.out.println("Pedaggio: " + veicolo.calcolaPedaggio() + "\n");
        }
    }

    public Veicolo cercaPerTarga(String targa) { // metodo ricerca per targa nell'array
        for (Veicolo veicolo : veicoli) {
            if (veicolo.getTarga().equalsIgnoreCase(targa)) {
                return veicolo;
            }
        }
        return null;
    }

    public ArrayList<Veicolo> getVeicoli() {
        return veicoli;
    }

}

public class EsercizioAutostrada {

    public static void main(String[] args) {

        Scanner scannerString = new Scanner(System.in);
        Scanner scannerInt = new Scanner(System.in);

        GestoreVeicoli gestore = new GestoreVeicoli();

        int scelta;

        do {
            System.out.println("\n\tMENU");
            System.out.println("1. Crea veicolo");
            System.out.println("2. Pedaggio veicolo (per targa)");
            System.out.println("3. Pedaggio tutti i veicoli");
            System.out.println("4. Info veicolo (per targa)");
            System.out.println("5. Info tutti i veicoli");
            System.out.println("6. Esci");
            System.out.print("Scelta: ");

            scelta = scannerInt.nextInt();

            switch (scelta) {

                case 1:
                    System.out.println("\nScegli il tipo di veicolo: 1-Auto 2-Camion 3-Moto");
                    int tipo = scannerInt.nextInt();

                    System.out.println("\nInserire le informazioni\n");
                    System.out.print("Targa: ");
                    String targa = scannerString.nextLine();

                    System.out.print("Velocità: ");
                    double velocita = scannerInt.nextDouble();

                    System.out.print("Numero assi: ");
                    int assi = scannerInt.nextInt();

                    Veicolo nuovoVeicolo = null;

                    switch (tipo) {
                        case 1:
                            System.out.print("Cilindrata: ");
                            int cilindrataNuovaAuto = scannerInt.nextInt();
                            nuovoVeicolo = new Auto(targa, velocita, assi, cilindrataNuovaAuto);
                            break;

                        case 2:
                            System.out.print("Peso: ");
                            double pesoNuovoCamion = scannerInt.nextDouble();
                            nuovoVeicolo = new Camion(targa, velocita, assi, pesoNuovoCamion);
                            break;

                        case 3:
                            System.out.print("Cilindrata: ");
                            int cilindrataNuovaMoto = scannerInt.nextInt();
                            nuovoVeicolo = new Moto(targa, velocita, assi, cilindrataNuovaMoto);
                            break;

                        default:
                            System.out.println("Tipo non valido");
                    }

                    if (nuovoVeicolo != null) { // mi assicuro che sia stato inizializzato
                        gestore.aggiungiVeicolo(nuovoVeicolo);

                        ConnesioneDatabase.salvaVeicolo(nuovoVeicolo); // per salvare su db

                        System.out.println("Veicolo inserito");
                    }
                    break;

                case 2:
                    System.out.print("Inserisci targa: ");
                    String targaDaCercare = scannerString.nextLine();

                    Veicolo veicoloDaCercare = gestore.cercaPerTarga(targaDaCercare); // chiamo il metodo per cercare la
                                                                                      // targa

                    if (veicoloDaCercare != null) { // se lo trovo calcolo il pedaggio
                        System.out.println("Pedaggio: " + veicoloDaCercare.calcolaPedaggio() + " EURO");
                    } else {
                        System.out.println("Veicolo non trovato");
                    }
                    break;

                case 3:
                    double pedaggioTotale = 0;
                    for (Veicolo veicolo : gestore.getVeicoli()) { // calcolo il pedaggio per tutti i veicoli
                        System.out.println(
                                "\nTarga: " + veicolo.getTarga() + " | " + "Pedaggio: " + veicolo.calcolaPedaggio()
                                        + " EURO");
                        pedaggioTotale = pedaggioTotale + veicolo.calcolaPedaggio();
                    }
                    System.out.println("\nPedaggio totale: " + pedaggioTotale + " EURO");
                    break;

                case 4:
                    System.out.print("Inserisci targa: ");
                    String targaCercaInfo = scannerString.nextLine();

                    Veicolo veicoloCercaInfo = gestore.cercaPerTarga(targaCercaInfo);

                    if (veicoloCercaInfo != null) { // se lo trovo stampo le info chiamando il toString con override
                        System.out.println(veicoloCercaInfo);
                    } else {
                        System.out.println("Veicolo non trovato");
                    }
                    break;

                case 5:
                    for (Veicolo veicolo : gestore.getVeicoli()) { // stampo info tutti i veicoli salvati
                        System.out.println(veicolo);
                    }
                    break;

                case 6:
                    System.out.println("Chiusura programma");
                    break;

                default:
                    System.out.println("Scelta non valida");
            }

        } while (scelta != 6);

        scannerString.close();
        scannerInt.close();
    }
}

class ConnesioneDatabase {

    private static final String URL = "jdbc:mysql://localhost:3306/autostrada";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void salvaVeicolo(Veicolo veicolo) {

        String query = "INSERT INTO veicoli (targa, velocita, assi, tipo) VALUES (?, ?, ?, ?)";

        try (Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, veicolo.getTarga());
            ps.setDouble(2, veicolo.getVelocita());
            ps.setInt(3, veicolo.getNumeroAssi());
            ps.setString(4, veicolo.getClass().getSimpleName()); // ottengo in nome della classe del veicolo per
                                                                 // salvataggio su db

            ps.executeUpdate();

            System.out.println("Veicolo salvato su DB");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

/*
 * CREATE DATABASE autostrada;
 * 
 * CREATE TABLE veicoli ( id INT AUTO_INCREMENT PRIMARY KEY,
 * 
 * targa VARCHAR(20), velocita DOUBLE, assi INT, tipo VARCHAR(20));
 */