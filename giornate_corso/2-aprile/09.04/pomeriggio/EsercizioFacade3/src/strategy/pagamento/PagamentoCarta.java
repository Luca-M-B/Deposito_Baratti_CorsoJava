package strategy.pagamento;

public class PagamentoCarta implements StrategiaPagamento {

    public void eseguiPagamento(double importo) {
        System.out.println("Pagamento con Carta: " + importo + " euro");
    }

}