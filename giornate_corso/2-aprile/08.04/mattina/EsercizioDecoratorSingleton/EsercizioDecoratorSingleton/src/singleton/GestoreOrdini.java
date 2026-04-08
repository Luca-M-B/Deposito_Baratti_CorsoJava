package singleton;

import java.util.ArrayList;

import classi_base.Bevanda;
import observer.Observer;

public class GestoreOrdini { // singleton

    private static GestoreOrdini instance; // istanza unica singleton

    private ArrayList<Bevanda> ordini; // lista di ordini

    private ArrayList<Observer> osservatori; // lista di Observer

    private GestoreOrdini() { // costruttore privato del singleton
        ordini = new ArrayList<>();
        osservatori = new ArrayList<>(); // istanzio liste per gestire anche gli observer
    }

    public static GestoreOrdini getInstance() { // metodo statico per verificare l'unica istanza del singleton
        if (instance == null) {
            instance = new GestoreOrdini();
        }
        return instance;
    }

    public void aggiungiOrdine(Bevanda bevanda) {
        ordini.add(bevanda);

        notificaObserver(bevanda); // alla creazione dell'ordine notifico gli observer
    }

    public void stampaOrdini() {
        System.out.println("\nORDINI");

        for (Bevanda bevanda : ordini) {
            System.out.println(bevanda.getDescrizione() + " - " + bevanda.getPrezzo() + " euro");
        }
    }

    public void aggiungiObserver(Observer observer) {
        osservatori.add(observer);
    }

    private void notificaObserver(Bevanda bevanda) { // metodo per notificare tutti gli osservatori
        for (Observer osservatore : osservatori) {
            osservatore.aggiorna(bevanda);
        }
    }

}
