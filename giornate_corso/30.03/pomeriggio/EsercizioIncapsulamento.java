import java.util.ArrayList;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

class Studente {
    private String nome;
    private int voto;
    private int id;
    private static int contatore = 1; // per id autoincrementale

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVoto() {
        return voto;
    }

    public void setVoto(int voto) {
        if (voto < 0 || voto > 10) {
            System.out.println("Il voto deve essere compreso tra 0 e 10.");
        } else {
            this.voto = voto;
        }
    }

    public String toString() {
        return "Studente: \nID = " + id + ", Nome = " + nome + ", Voto = " + voto;
    }

    public Studente(String nome, int voto) {
        this.nome = nome;
        setVoto(voto);
        this.id = contatore++; // aumento automaticamente l'id
    }

}

public class EsercizioIncapsulamento {

    public static Studente cercaStudentePerNome(ArrayList<Studente> lista, String nome) { // metodo ricerca studente
        for (Studente s : lista) {
            if (s.getNome().equalsIgnoreCase(nome)) {
                return s;
            }
        }
        return null;
    }

    public static void main(String[] args) {

        Studente studenteUno = new Studente("pippo", 8);

        System.out.println("Nome: " + studenteUno.getNome()); // stampare tramite il metodo get
        System.out.println("Voto: " + studenteUno.getVoto());

        studenteUno.setVoto(9); // modifico il voto tramite set
        System.out.println("Voto: " + studenteUno.getVoto()); // stampo il voto

        studenteUno.setVoto(12); // modifico il voto di un valore non valido
        System.out.println("Voto: " + studenteUno.getVoto()); // stampo il voto

        /*
         * ArrayList<Studente> listaStudenti = new ArrayList<>(); // creo arrayList di
         * studenti
         * 
         * Studente studenteDue = new Studente("franco", 6); // creo studenti
         * Studente studenteTre = new Studente("carlo", 2);
         * Studente studenteQuattro = new Studente("tizio", 5);
         * 
         * listaStudenti.add(studenteUno); // aggiungo studenti all'array
         * listaStudenti.add(studenteDue);
         * listaStudenti.add(studenteTre);
         * listaStudenti.add(studenteQuattro);
         * 
         * System.out.println("\nLista completa studenti:");
         * for (Studente studente : listaStudenti) { // stampo grazie al toString
         * modificato
         * System.out.println(studente);
         * }
         * 
         * Scanner scanner = new Scanner(System.in);
         * System.out.println("Inserire il nome da cercare: ");
         * 
         * String nomeDaCercare = scanner.nextLine();// variabili per il metodo di
         * ricerca
         * Studente trovato = cercaStudentePerNome(listaStudenti, nomeDaCercare);
         * 
         * if (trovato != null) {
         * System.out.println("Trovato: " + trovato);
         * } else {
         * System.out.println("Studente non trovato nella lista");
         * }
         * 
         * scanner.close();
         */

        ArrayList<Studente> listaStudenti = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int scelta;

        do {
            System.out.println("\n\tMENU");
            System.out.println("1. Aggiungi studente");
            System.out.println("2. Visualizza studenti");
            System.out.println("3. Cerca studente");
            System.out.println("4. Esci");
            System.out.print("Scelta: ");

            scelta = scanner.nextInt();
            scanner.nextLine(); // pulizia buffer

            switch (scelta) {

                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Voto: ");
                    int voto = scanner.nextInt();
                    scanner.nextLine();

                    // creazione DIRETTA dentro ArrayList
                    Studente nuovo = new Studente(nome, voto);
                    listaStudenti.add(nuovo);

                    Connessione.salvaStudente(nuovo); // integrazione con database

                    System.out.println("Studente aggiunto.");
                    break;

                case 2:
                    for (Studente s : listaStudenti) {
                        System.out.println(s);
                    }
                    break;

                case 3:
                    System.out.print("Nome da cercare: ");
                    String nomeRicerca = scanner.nextLine();

                    Studente trovato = cercaStudentePerNome(listaStudenti, nomeRicerca);

                    if (trovato != null) {
                        System.out.println("Trovato: " + trovato);
                    } else {
                        System.out.println("Non trovato.");
                    }
                    break;

                case 4:
                    System.out.println("Uscita.");
                    break;

                default:
                    System.out.println("Scelta non valida.");
            }

        } while (scelta != 4);

        scanner.close();

    }

}

/*
 * CREATE DATABASE scuola;
 * CREATE TABLE studenti (
 * id INT AUTO_INCREMENT PRIMARY KEY,
 * nome VARCHAR(50),
 * voto INT
 * );
 */

class Connessione {

    private static final String URL = "jdbc:mysql://localhost:3306/scuola";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void salvaStudente(Studente s) {
        String query = "INSERT INTO studenti(nome, voto) VALUES (?, ?)";

        try (Connection oggettoConnessione = getConnection();
                PreparedStatement ps = oggettoConnessione.prepareStatement(query)) {

            ps.setString(1, s.getNome());
            ps.setInt(2, s.getVoto());

            ps.executeUpdate();
            System.out.println("Studente salvato nel database.");

        } catch (Exception e) {
            System.out.println("Errore connessione DB: " + e.getMessage());
        }
    }
}