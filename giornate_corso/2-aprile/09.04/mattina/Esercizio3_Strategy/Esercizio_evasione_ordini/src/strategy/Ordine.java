package strategy;

public class Ordine {

    private int id;
    private static int contatore = 0;
    private String cliente;
    private String prodotto;
    private double prezzo;

    private int priorita;

    private StrategiaEvasione strategia;

    public Ordine(String cliente, String prodotto, double prezzo) {
        this.id = ++contatore;
        this.cliente = cliente;
        this.prodotto = prodotto;
        this.prezzo = prezzo;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public void setStrategia(StrategiaEvasione strategia) {
        this.strategia = strategia;
    }

    // eseguo strategy corrente
    public void evadiOrdine() {
        if (strategia != null) {
            strategia.evadi(this);
        } else {
            System.out.println("Nessuna strategia impostata");
        }
    }

    // stampa dati utente
    public void stampaDettagli() {
        System.out
                .println("ID: " + id + " | Cliente: " + cliente + " | Prodotto: " + prodotto + " | Prezzo: " + prezzo);
    }

    public int getPriorita() {
        return priorita;
    }

    public void setPriorita(int priorita) {
        this.priorita = priorita;
    }

}