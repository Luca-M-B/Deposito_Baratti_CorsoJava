package fabbrica.produzione;

public class Prodotto {

    private String nome;

    public Prodotto(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void usa() {
        System.out.println("Uso prodotto generico: " + nome);
    }
}