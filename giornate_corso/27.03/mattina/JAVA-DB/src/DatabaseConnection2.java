import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DatabaseConnection2 {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/sakila";
        String user = "root";
        String password = "";

        try {
            Connection oggettoConnessione = DriverManager.getConnection(url, user, password);

            Statement stmt = oggettoConnessione.createStatement();
            String query = "select * from actor limit 5";
            ResultSet result = stmt.executeQuery(query);

            ResultSetMetaData meta = result.getMetaData();
            int numeroColonne = meta.getColumnCount();

            while (result.next()) {
                for (int i = 1; i < numeroColonne; i++) { // stampa tutte le colonne
                    String nomeColonna = meta.getColumnName(i);
                    Object val = result.getObject(i);
                    System.out.print(nomeColonna + ": " + val);
                    if (i < numeroColonne) {
                        System.out.print("|");
                    }
                }
                System.out.println();
            }

            oggettoConnessione.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
