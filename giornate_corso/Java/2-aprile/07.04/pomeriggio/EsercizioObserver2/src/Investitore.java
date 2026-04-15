import java.util.List;

public interface Investitore {

    void notifica(String azione, double valore);

    List<Azione> getPortafoglio();
}