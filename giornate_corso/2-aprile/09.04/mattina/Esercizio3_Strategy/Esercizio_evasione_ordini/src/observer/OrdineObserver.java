package observer;

import strategy.EvasioneControllata;
import strategy.EvasioneNormale;
import strategy.EvasionePrioritaria;
import strategy.Ordine;

public class OrdineObserver implements Observer {

    private Ordine ordine;

    public OrdineObserver(Ordine ordine) {
        this.ordine = ordine;
    }

    @Override
    public void aggiorna(String stato) {

        switch (stato) { // cambio strategy in base allo stato

            case "normale":
                ordine.setStrategia(new EvasioneNormale());
                ordine.setPriorita(1); // valorizzo la variabile priorita
                break;

            case "priorita":
                ordine.setStrategia(new EvasionePrioritaria());
                ordine.setPriorita(2);
                break;

            case "controllo":
                ordine.setStrategia(new EvasioneControllata());
                ordine.setPriorita(3);
                break;

            default:
                System.out.println("Stato non riconosciuto");
        }

        System.out.println("Strategia aggiornata per l'ordine.");

        ordine.evadiOrdine(); // evasione automatica ordine
    }
}