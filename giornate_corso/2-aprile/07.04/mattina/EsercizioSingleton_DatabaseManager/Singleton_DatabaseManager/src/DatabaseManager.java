import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

    private static DatabaseManager instance;

    private static final String URL = "jdbc:mysql://localhost:3306/eserciziosingleton";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private int connectionCount = 0;

    private DatabaseManager() {
    }

    public static DatabaseManager getInstance() {
        if (instance == null) {
            instance = new DatabaseManager();
        }
        return instance;
    }

    public Connection connect() {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            connectionCount++;
            System.out.println("Connessione stabilita. Connessioni attive: " + connectionCount);
        } catch (SQLException e) {
            System.out.println("Errore connessione DB: " + e.getMessage());
        }

        return conn;
    }

    public int getConnectionCount() {
        return connectionCount;
    }
}