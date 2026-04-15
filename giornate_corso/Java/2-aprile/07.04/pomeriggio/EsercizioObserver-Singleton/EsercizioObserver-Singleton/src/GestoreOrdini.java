import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

// Classe che gestisce gli ordini ed è il Subject osservato
public class GestoreOrdini implements GestoreNotifiche {

    private ArrayList<Notificatore> osservatori = new ArrayList<>();
    private Ordine ordineCorrente; // ordine da notiifcare

    @Override
    public void aggiungiOsservatore(Notificatore notificatore) {
        osservatori.add(notificatore);
    }

    @Override
    public void rimuoviOsservatore(Notificatore notificatore) {
        osservatori.remove(notificatore);
    }

    @Override
    public void notifica() {
        for (Notificatore notificatore : osservatori) {
            notificatore.update(ordineCorrente);
        }
    }

    // CREATE
    public void salvaOrdine(Ordine ordine) {
        try {
            String query = "INSERT INTO ordini (cliente, prodotto, quantita, stato) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = DBConnection.getInstance()
                    .getConnection()
                    .prepareStatement(query);

            stmt.setString(1, ordine.getCliente());
            stmt.setString(2, ordine.getProdotto());
            stmt.setInt(3, ordine.getQuantita());
            stmt.setString(4, ordine.getStato().name());

            stmt.executeUpdate();

            System.out.println("Ordine inserito correttamente");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // UPDATE stato
    public void aggiornaStato(int id, StatoOrdine nuovoStato) {
        try {
            String query = "UPDATE ordini SET stato = ? WHERE id = ?";
            PreparedStatement stmt = DBConnection.getInstance()
                    .getConnection()
                    .prepareStatement(query);

            stmt.setString(1, nuovoStato.name());
            stmt.setInt(2, id);

            stmt.executeUpdate();

            // Recupero ordine aggiornato
            Ordine ordine = getOrdineById(id);
            ordineCorrente = ordine;

            notifica();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ ALL
    public List<Ordine> getAllOrdini() {
        List<Ordine> lista = new ArrayList<>();

        try {
            String query = "SELECT * FROM ordini";
            Statement stmt = DBConnection.getInstance().getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Ordine o = new Ordine(
                        rs.getInt("id"),
                        rs.getString("cliente"),
                        rs.getString("prodotto"),
                        rs.getInt("quantita"),
                        StatoOrdine.valueOf(rs.getString("stato")));
                lista.add(o);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    // READ BY ID
    public Ordine getOrdineById(int id) {
        try {
            String query = "SELECT * FROM ordini WHERE id = ?";
            PreparedStatement stmt = DBConnection.getInstance()
                    .getConnection()
                    .prepareStatement(query);

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Ordine(
                        rs.getInt("id"),
                        rs.getString("cliente"),
                        rs.getString("prodotto"),
                        rs.getInt("quantita"),
                        StatoOrdine.valueOf(rs.getString("stato")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}