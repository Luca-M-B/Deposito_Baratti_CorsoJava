package observer;

import java.util.ArrayList;

public class CentroPriorita {

    private ArrayList<Observer> observers = new ArrayList<>();

    private String stato;

    public void aggiungiObserver(Observer observer) {
        observers.add(observer);
    }

    public void rimuoviObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notificaObservers(int idOrdine, String stato) {
        for (Observer observer : observers) {
            observer.aggiorna(stato);
        }
    }

    // cambiare stato
    public void setStato(int idOrdine, String stato) {
        System.out.println("Cambio stato ordine " + idOrdine + " -> " + stato);
        notificaObservers(idOrdine, stato); // notifica
    }

    /*
     * public void cambiaStato(String stato) {
     * setStato(stato);
     * }
     */

}