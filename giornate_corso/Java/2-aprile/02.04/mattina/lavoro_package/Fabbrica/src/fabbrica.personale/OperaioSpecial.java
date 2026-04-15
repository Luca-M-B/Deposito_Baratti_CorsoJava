package fabbrica.personale;

import fabbrica.produzione.Macchina;

public class OperaioSpecial extends Operaio {

    public OperaioSpecial(String nome) {
        super(nome);
    }

    @Override
    public void lavora(Macchina m) {
        System.out.println("Operaio Special accende la macchina");
        m.accendiSpegni();
    }
}