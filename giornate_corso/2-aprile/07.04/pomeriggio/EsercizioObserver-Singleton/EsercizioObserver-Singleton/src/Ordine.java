// Classe che rappresenta un ordine
public class Ordine {

    private int id;
    private String cliente;
    private String prodotto;
    private int quantita;
    private StatoOrdine stato;

    public Ordine(int id, String cliente, String prodotto, int quantita, StatoOrdine stato) {
        this.id = id;
        this.cliente = cliente;
        this.prodotto = prodotto;
        this.quantita = quantita;
        this.stato = stato;
    }

    public int getId() {
        return id;
    }

    public String getCliente() {
        return cliente;
    }

    public String getProdotto() {
        return prodotto;
    }

    public int getQuantita() {
        return quantita;
    }

    public StatoOrdine getStato() {
        return stato;
    }

    public void setStato(StatoOrdine stato) {
        this.stato = stato;
    }
}