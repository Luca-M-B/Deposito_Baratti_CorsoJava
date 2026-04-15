package fabbrica.personale;

import fabbrica.produzione.Macchina;

public class Operaio {
    private String nome;

    public Operaio(String nome) {
        this.nome = nome;
    }

    public void lavora(Macchina m) {
        System.out.println(nome + " accende la macchina");
        m.accendiSpegni();
    }

    public void ferma(Macchina m) {
        System.out.println(nome + " spegne la macchina");
        m.accendiSpegni();
    }
}