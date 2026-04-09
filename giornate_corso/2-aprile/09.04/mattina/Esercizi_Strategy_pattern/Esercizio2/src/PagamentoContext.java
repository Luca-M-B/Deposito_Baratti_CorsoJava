public class PagamentoContext {

    private MetodoPagamento metodoPagamento;

    public void eseguiPagamento(double importo) {
        metodoPagamento.paga(importo);
    }

    public void setMetodoPagamento(MetodoPagamento metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

}
