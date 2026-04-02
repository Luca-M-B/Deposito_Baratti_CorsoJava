package fabbrica.produzione;

public class ProdottoB extends Prodotto {

    public ProdottoB() {
        super();
    }

    @Override
    public void usa() {
        System.out.println("Uso specifico di ProdottoA");
    }
}