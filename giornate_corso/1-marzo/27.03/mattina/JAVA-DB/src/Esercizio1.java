import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Esercizio1 {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/sakila";
        String user = "root";
        String password = "";

        // da rental join su inventory e poi join su film per ottenre i piu nolegiati,
        // li raggruppo per titolo di film e ordino dal piu noleggiato con limit 10
        String query = "select film.title, count(*) as noleggi_totali " +
                "from rental " +
                "join inventory on rental.inventory_id = inventory.inventory_id " +
                "join film on inventory.film_id = film.film_id " +
                "group by film.title " +
                "order by noleggi_totali desc " +
                "limit ?";

        int numeroRighe = 10;

        try (Connection oggettoConnessione = DriverManager.getConnection(url, user, password);
                PreparedStatement pstmt = oggettoConnessione.prepareStatement(query)) {

            pstmt.setInt(1, numeroRighe); // imposto il parametro "limit ?" della query
            ResultSet result = pstmt.executeQuery(); // ottengo tabella risultati
            ResultSetMetaData meta = result.getMetaData(); // recupero metadati dal resultset
            int numeroColonne = meta.getColumnCount(); // numero colonne restituite dalla query

            while (result.next()) { // itero tutte le righe del risultato
                for (int i = 1; i <= numeroColonne; i++) {
                    String nomeColonna = meta.getColumnName(i); // nome colonna
                    Object val = result.getObject(i); // valori della colonna (object perchè non conosco il tipo dei
                                                      // dati)
                    System.out.print(nomeColonna + ":" + val); // stampo nome colonna: valore
                    if (i < numeroColonne) { // stampo separatore tra colonne
                        System.out.print(" | ");
                    }
                }
                System.out.println();
            }

        } catch (SQLException e) { // gestisco errori sql
            e.printStackTrace();
        }
    }
}
