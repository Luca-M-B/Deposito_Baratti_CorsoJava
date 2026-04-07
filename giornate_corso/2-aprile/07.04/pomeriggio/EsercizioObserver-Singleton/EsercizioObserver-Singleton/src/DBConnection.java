import java.sql.Connection;
import java.sql.DriverManager;

// Classe Singleton per gestire la connessione al database
public class DBConnection {

    // Istanza unica della classe (Singleton)
    private static DBConnection instance;

    // Oggetto Connection JDBC
    private Connection connection;

    // Credenziali DB (modifica in base al tuo ambiente)
    private final String URL = "jdbc:mysql://localhost:3306/magazzino";
    private final String USER = "root";
    private final String PASSWORD = "";

    // Costruttore PRIVATO per impedire istanze esterne
    private DBConnection() {
        try {
            // Carica il driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Crea connessione
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Connessione al DB avvenuta!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Metodo pubblico per ottenere l'unica istanza
    public static DBConnection getInstance() {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }

    // Metodo per ottenere la connessione
    public Connection getConnection() {
        return connection;
    }
}