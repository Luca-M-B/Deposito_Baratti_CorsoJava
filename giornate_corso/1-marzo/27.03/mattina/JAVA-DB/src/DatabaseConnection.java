import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnection {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/sakila";
        String user = "root";
        String password = "";

        try {
            Connection oggettoConnessione = DriverManager.getConnection(url, user, password);
            System.out.println("Connessione riuscita!");

            Statement stmt = oggettoConnessione.createStatement();
            String query = "select * from actor limit 5";
            ResultSet result = stmt.executeQuery(query);

            while (result.next()) {
                System.out.println("attore" + result.getString(2));
            }

            /*
             * String query = "select * from actor where id = ?";
             * PreparedStatement pStmt = oggettoConnessione.prepareStatement(query);
             * pStmt.setInt(1, 1);
             */

            // System.out.println(result);

            oggettoConnessione.close();
            System.out.println("Configurazione di JDBC è ok!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
