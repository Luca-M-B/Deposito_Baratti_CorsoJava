package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import observer.CentroPriorita;
import observer.OrdineObserver;
import strategy.Ordine;

public class App {

    // Ho voluto modificare lo stato tramire una scelta e quindi ho inizato ad
    // implementare dei controlli che non ho terminato

    public static void main(String[] args) {

        // creo centro priorita
        CentroPriorita centro = new CentroPriorita();

        /*
         * // creo un ordine
         * Ordine ordine = new Ordine(1, "Pippo", "Sedia", 10);
         * 
         * // creo observer e aggiungo
         * OrdineObserver observer = new OrdineObserver(ordine);
         * centro.aggiungiObserver(observer);
         * 
         * // stampo stato iniziale
         * ordine.stampaDettagli();
         * 
         * // cambi di stato e chiamo il metodo per evadere l'ordine dopo aver impostato
         * il
         * // nuovo stato
         * System.out.println("\nstato: NORMALE");
         * centro.setStato("normale");
         * ordine.evadiOrdine();
         * 
         * System.out.println("\nstato: PRIORITA");
         * centro.setStato("priorita");
         * ordine.evadiOrdine();
         * 
         * System.out.println("\nstato: CONTROLLO");
         * centro.setStato("controllo");
         * ordine.evadiOrdine();
         */

        ArrayList<Ordine> ordini = new ArrayList<>();

        // Creazione e aggiunta ordini
        ordini.add(new Ordine("Mario Rossi", "Laptop", 1000));
        ordini.add(new Ordine("Luigi Bianchi", "Telefono", 500));
        ordini.add(new Ordine("Anna Verdi", "Tablet", 300));
        ordini.add(new Ordine("Giulia Neri", "Monitor", 250));
        ordini.add(new Ordine("Paolo Gialli", "Stampante", 180));
        ordini.add(new Ordine("Francesca Blu", "Mouse", 40));
        ordini.add(new Ordine("Marco Rosa", "Tastiera", 70));
        ordini.add(new Ordine("Luca Viola", "Smartwatch", 220));

        // creo un observer per ogni ordine
        for (Ordine ordine : ordini) {
            centro.aggiungiObserver(new OrdineObserver(ordine));
        }

        // ordinamento per priorità
        Collections.sort(ordini, new Comparator<Ordine>() {
            @Override
            public int compare(Ordine o1, Ordine o2) {
                return Integer.compare(o2.getPriorita(), o1.getPriorita());
            }
        });

        System.out.println("\nORDINI PER PRIORITA");

        for (Ordine ordine : ordini) {
            ordine.stampaDettagli();
        }

        centro.setStato("normale");
        /*
         * // esempi di cambi stati
         * centro.setStato("priorita");
         * centro.setStato("controllo");
         */
    }
}
