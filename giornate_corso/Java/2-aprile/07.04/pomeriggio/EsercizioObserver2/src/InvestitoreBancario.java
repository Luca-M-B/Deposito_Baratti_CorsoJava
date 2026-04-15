import java.util.ArrayList;

public class InvestitoreBancario implements Investitore {

    private String banca;
    private ArrayList<Azione> portafoglio = new ArrayList<>();

    public InvestitoreBancario(String banca) {
        this.banca = banca;
    }

    public void aggiungiAzione(Azione a) {
        portafoglio.add(a);
    }

    @Override
    public void notifica(String azione, double valore) {
        System.out.println("Banca " + banca +
                " - ALERT titolo " + azione +
                ": nuovo valore = " + valore + "euro");
    }

    @Override
    public ArrayList<Azione> getPortafoglio() {
        return portafoglio;
    }
}