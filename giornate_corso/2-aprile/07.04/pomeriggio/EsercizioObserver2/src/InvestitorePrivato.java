import java.util.ArrayList;

public class InvestitorePrivato implements Investitore {

    private String nome;
    private ArrayList<Azione> portafoglio = new ArrayList<>();

    public InvestitorePrivato(String nome) {
        this.nome = nome;
    }

    public void aggiungiAzione(Azione a) {
        portafoglio.add(a);
    }

    @Override
    public void notifica(String azione, double valore) {
        System.out.println("Privato " + nome +
                " - Aggiornamento: " + azione + " = " + valore + "euro");
    }

    @Override
    public ArrayList<Azione> getPortafoglio() {
        return portafoglio;
    }
}