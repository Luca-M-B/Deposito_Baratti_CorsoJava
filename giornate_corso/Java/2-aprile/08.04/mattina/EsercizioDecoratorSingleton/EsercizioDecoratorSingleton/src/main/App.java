package main;

import java.util.Scanner;

import classi_base.Bevanda;
import classi_base.Caffe;
import classi_base.CioccolataCalda;
import classi_base.Te;
import decorator.CacaoDecorator;
import decorator.CannellaDecorator;
import decorator.GhiaccioDecorator;
import decorator.LatteDecorator;
import decorator.PannaDecorator;
import decorator.ZuccheroDecorator;
import observer.ObserverContatore;
import singleton.GestoreOrdini;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        GestoreOrdini gestore = GestoreOrdini.getInstance();

        ObserverContatore contaOrdini = new ObserverContatore();
        gestore.aggiungiObserver(contaOrdini); // creo e aggiungo un observer all'oggetto gestore, per contare gli
                                               // ordini

        int scelta;

        do {
            System.out.println("\n\tMENU");
            System.out.println("1. Aggiungi bevanda");
            System.out.println("2. Recap ordine");
            System.out.println("0. Esci");
            System.out.print("Scelta: ");
            scelta = scanner.nextInt();

            switch (scelta) {

                case 1:
                    Bevanda bevanda = null;

                    // Scelta bevanda base
                    System.out.println("\nScegli bevanda base:");
                    System.out.println("1. Caffè");
                    System.out.println("2. Tè");
                    System.out.println("3. Cioccolata calda");
                    int base = scanner.nextInt();

                    switch (base) { // in base alla scelta, creo un oggetto
                        case 1:
                            bevanda = new Caffe();
                            break;
                        case 2:
                            bevanda = new Te();
                            break;
                        case 3:
                            bevanda = new CioccolataCalda();
                            break;
                        default:
                            System.out.println("Scelta non valida");
                            continue;
                    }

                    // Aggiunta extra
                    int extra;
                    do {
                        System.out.println("\nExtra disponibili:");
                        System.out.println("1. Latte");
                        System.out.println("2. Zucchero");
                        System.out.println("3. Cacao");
                        System.out.println("4. Panna");
                        System.out.println("5. Cannella");
                        System.out.println("6. Ghiaccio");
                        System.out.println("0. FINE");
                        extra = scanner.nextInt();

                        switch (extra) { // per ogni extra vado a decorare l'oggetto precedentemente creato
                            case 1:
                                bevanda = new LatteDecorator(bevanda);
                                break;
                            case 2:
                                bevanda = new ZuccheroDecorator(bevanda);
                                break;
                            case 3:
                                bevanda = new CacaoDecorator(bevanda);
                                break;
                            case 4:
                                bevanda = new PannaDecorator(bevanda);
                                break;
                            case 5:
                                bevanda = new CannellaDecorator(bevanda);
                                break;
                            case 6:
                                bevanda = new GhiaccioDecorator(bevanda);
                                break;
                        }

                    } while (extra != 0);

                    System.out.println("\nOrdine aggiunto:");

                    System.out.println(bevanda.getDescrizione() + " - " + bevanda.getPrezzo() + " euro");

                    gestore.aggiungiOrdine(bevanda); // aggiungo l'ordine creato alla lista di GestoreOrdini
                    System.out.println("-------------------------------");
                    break;

                case 2:
                    gestore.stampaOrdini();
                    break;

                case 0:
                    System.out.println("Chiusura");
                    break;

                default:
                    System.out.println("Scelta non valida");
            }

        } while (scelta != 0);

        scanner.close();
    }

}
