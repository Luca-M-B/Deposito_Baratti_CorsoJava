public class CartaDiCredito implements MetodoPagamento {

    private String numeroCarta;

    public CartaDiCredito(String numeroCarta) {
        this.numeroCarta = numeroCarta;
    }

    @Override
    public void paga(double importo) {
        System.out.println("Pagamento di euro " + importo + " effettuato con Carta di Credito (" + numeroCarta + ")");
    }

}
