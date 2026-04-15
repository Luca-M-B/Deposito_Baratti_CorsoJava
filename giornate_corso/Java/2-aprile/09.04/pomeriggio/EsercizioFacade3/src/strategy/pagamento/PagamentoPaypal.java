package strategy.pagamento;

public class PagamentoPaypal implements StrategiaPagamento {

    public void eseguiPagamento(double importo) {
        System.out.println("Pagamento con PayPal: " + importo + " euro");
    }

}