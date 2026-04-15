package fabbrica.produzione;

public class ProdottoA extends Prodotto {

    public ProdottoA() {
        super();
    }

    @Override
    public void usa() {
        System.out.println("Uso specifico di ProdottoA");
    }
}