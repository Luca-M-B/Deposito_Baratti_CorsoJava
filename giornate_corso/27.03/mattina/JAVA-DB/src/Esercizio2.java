import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

public class Esercizio2 {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/sakila";
        String user = "root";
        String password = "";

        String query = "select film.title, film.description, film.release_year " + // query con filtro su titolo
                "from film " +
                "where title like ?";

        Scanner scanner = new Scanner(System.in); // scanner input utente

        System.out.print("Inserire una parola da cercare nei titoli dei film: ");
        String input = scanner.nextLine();

        try (Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement pstmt = conn.prepareStatement(query)) { // connessione db

            pstmt.setString(1, "%" + input + "%"); // stringa per cercare input utente su db

            ResultSet result = pstmt.executeQuery(); // ottengo tabella risultati
            ResultSetMetaData meta = result.getMetaData(); // recupero metadati dal resultset
            int numeroColonne = meta.getColumnCount(); // numero colonne restituite dalla query

            while (result.next()) { // iterazione su tutti i risuktati ottenuti, quando finiscono i record esce dal
                                    // while

                for (int i = 1; i <= numeroColonne; i++) { // ciclo sulle colonne
                    String nomeColonna = meta.getColumnName(i); // recupero i valori
                    Object val = result.getObject(i); // attribuisco i valori a object generico

                    System.out.print(nomeColonna + ":" + val); // stmapo risultato

                    if (i < numeroColonne) { // stampo separatore tra le colonne
                        System.out.print(" | ");
                    }
                }
                System.out.println();
            }

        } catch (SQLException e) { // gestisco eccezioni sql
            e.printStackTrace();
        }

        scanner.close(); // chiusura scanner

    }
}