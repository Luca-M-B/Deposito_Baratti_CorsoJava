import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        DatabaseManager db = DatabaseManager.getInstance();

        // Verifica Singleton
        DatabaseManager db2 = DatabaseManager.getInstance();
        System.out.println("Stessa istanza? " + (db == db2));

        boolean continua = true;

        while (continua) {

            System.out.println("\nSei un utente registrato?");
            System.out.println("1 = SI | 2 = NO");
            System.out.print("Scelta: ");

            int scelta = scanner.nextInt();
            scanner.nextLine();

            if (scelta == 2) {
                System.out.print("Username: ");
                String user = scanner.nextLine();

                System.out.print("Password: ");
                String pw = scanner.nextLine();

                Connection conn = db.connect();

                try {
                    String sql = "INSERT INTO utenti(username, password) VALUES(?, ?)";
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ps.setString(1, user);
                    ps.setString(2, pw);
                    ps.executeUpdate();

                    System.out.println("Utente registrato.");
                    conn.close();

                } catch (SQLException e) {
                    System.out.println("Errore INSERT: " + e.getMessage());
                }
            }

            boolean sessioneAperta = true;

            while (sessioneAperta) {

                System.out.println("\n1. Crea dato");
                System.out.println("2. Modifica dato");
                System.out.println("3. Esci");

                int operazione = scanner.nextInt();
                scanner.nextLine();

                switch (operazione) {

                    case 1:
                        creaDato(db);
                        break;

                    case 2:
                        modificaDato(db);
                        break;

                    case 3:
                        sessioneAperta = false;
                        System.out.println("Totale connessioni: " + db.getConnectionCount());
                        break;
                }
            }

            System.out.println("\nVuoi uscire?");
            System.out.println("1 = SI | 2 = NO");
            System.out.print("Scelta: ");

            if (scanner.nextInt() == 1) {
                continua = false;
            }
        }

        scanner.close();
    }

    private static void creaDato(DatabaseManager db) {

        System.out.print("Inserisci dato: ");
        String dato = scanner.nextLine();

        Connection conn = db.connect();

        if (conn == null)
            return;

        try {
            String sql = "INSERT INTO dati(valore) VALUES(?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, dato);
            ps.executeUpdate();

            System.out.println("Dato salvato.");
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void modificaDato(DatabaseManager db) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("ID dato da modificare: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nuovo valore: ");
        String valore = scanner.nextLine();

        Connection conn = db.connect();

        try {
            String sql = "UPDATE dati SET valore=? WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, valore);
            ps.setInt(2, id);
            ps.executeUpdate();

            System.out.println("Dato aggiornato.");
            conn.close();

        } catch (SQLException e) {
            System.out.println("Errore: " + e.getMessage());
        }

        scanner.close();
    }
}