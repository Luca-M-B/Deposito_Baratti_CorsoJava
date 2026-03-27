import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DatabaseConnection3 {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/sakila";
        String user = "root";
        String password = "";

        String query = "select * from actor limit ?";

        int nRow = 5;

        try (Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, nRow);
            ResultSet result = pstmt.executeQuery();

            ResultSetMetaData meta = result.getMetaData();
            int numColumns = meta.getColumnCount();

            while (result.next()) {
                for (int i = 1; i < numColumns; i++) {
                    String colName = meta.getColumnName(i);
                    Object val = result.getObject(i);
                    System.out.print(colName + ":" + val);
                    if (i < numColumns) {
                        System.out.print("|");
                    }
                }
                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }

    }
}