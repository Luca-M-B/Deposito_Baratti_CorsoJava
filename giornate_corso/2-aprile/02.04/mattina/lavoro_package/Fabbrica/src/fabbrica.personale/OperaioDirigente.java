package fabbrica.personale;

import fabbrica.produzione.Macchina;

public class OperaioDirigente extends Operaio {

    public OperaioDirigente(String nome) {
        super(nome);
    }

    public void controlla(Macchina m) {
        m.stampaStato();
    }
}