package strategy.pagamento;

public class PagamentoBonifico implements StrategiaPagamento {

    public void eseguiPagamento(double importo) {
        System.out.println("Pagamento con Bonifico: " + importo + " euro");
    }

}