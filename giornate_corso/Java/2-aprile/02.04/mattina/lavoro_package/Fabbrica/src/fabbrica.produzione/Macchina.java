package fabbrica.produzione;

public class Macchina {

    private String nome;
    private boolean accesa;

    public Macchina(String nome) {
        this.nome = nome;
        this.accesa = false;
    }

    public void accendiSpegni() {
        if (accesa) {
            accesa = false;
        } else {
            accesa = true;
        }
    }

    public Prodotto creaProdotto(String tipoProdotto) {
        if (accesa) {
            System.out.println(nome + " sta creando un prodotto");
            if (tipo.equalsIgnoreCase("A")) {
            return new ProdottoA();
        } else if (tipo.equalsIgnoreCase("B")) {
            return new ProdottoB();
        } else {
            System.out.println("Tipo prodotto non valido");
            return null;
        } else {
            System.out.println("La macchina è spenta, impossibile creare prodotti");
        } 
    }
    }

    public void stampaStato() {
        if (accesa) {
            System.out.println("Accesa");
        } else {
            System.out.println("Spenta");
        }
    }
}