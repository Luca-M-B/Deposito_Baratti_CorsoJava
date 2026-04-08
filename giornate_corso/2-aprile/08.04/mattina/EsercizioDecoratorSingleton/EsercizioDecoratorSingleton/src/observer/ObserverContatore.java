package observer;

import classi_base.Bevanda;

public class ObserverContatore implements Observer {

    private int contatore = 0;

    @Override
    public void aggiorna(Bevanda bevanda) {
        contatore++;
        System.out.println("Bevande totali: " + contatore);
    }
}
