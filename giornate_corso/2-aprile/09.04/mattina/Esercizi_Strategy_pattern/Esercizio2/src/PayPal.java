public class PayPal implements MetodoPagamento {

    private String numeroConto;

    public PayPal(String email) {
        this.numeroConto = email;
    }

    @Override
    public void paga(double importo) {
        System.out
                .println("Pagamento di euro " + importo + " effettuato con PayPal (numero conto " + numeroConto + ")");
    }

}
