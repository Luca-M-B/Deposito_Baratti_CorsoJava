package main;

import java.util.Scanner;

import facade.*;

public class App {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        SistemaOrdineFacade sistema = new SistemaOrdineFacade();

        int scelta;

        boolean baseScelta = false; // per verificare che sia stata scelta la base

        do {
            System.out.println("\nMENU");

            if (!baseScelta) {
                System.out.println("1. Seleziona base");
            } else {
                System.out.println("2. Aggiungi extra");
                System.out.println("3. Scegli Spedizione");
                System.out.println("4. Scegli Pagamento");
            }

            System.out.println("5. Riepilogo ordine");
            System.out.println("6. Conferma ordine");
            System.out.println("0. Esci");
            System.out.print("\nScelta: ");

            scelta = scanner.nextInt();

            switch (scelta) {

                case 1:
                    if (!baseScelta) {
                        System.out.println("\n1. Ufficio\n2. Gaming\n\nScelta: ");
                        sistema.creaComputerBase(scanner.nextInt());
                        baseScelta = true;
                    } else {
                        System.out.println("\nConfigurazione base già selezionata.");
                    }
                    break;

                case 2:
                    if (baseScelta) {
                        int sceltaExtra;
                        do {
                            System.out.println("\n1. RAM\n2. SSD\n3. GPU\n4. Raffreddamento\n0. Fine\n\nScelta: ");
                            sceltaExtra = scanner.nextInt();

                            if (sceltaExtra != 0) {
                                sistema.aggiungiExtra(sceltaExtra);
                            }

                        } while (sceltaExtra != 0);
                    } else {
                        System.out.println("\nPrima scegli una configurazione base.");
                    }
                    break;

                case 3:
                    if (baseScelta) {
                        System.out.println("\n1. Standard\n2. Espresso\n3. Ritiro\n\nScelta: ");
                        sistema.scegliSpedizione(scanner.nextInt());
                    } else {
                        System.out.println("\nPrima scegli una configurazione base.");
                    }
                    break;

                case 4:
                    if (baseScelta) {
                        System.out.println("\n1. Carta\n2. PayPal\n3. Bonifico\n\nScelta: ");
                        sistema.scegliPagamento(scanner.nextInt());
                    } else {
                        System.out.println("\nPrima scegli una configurazione base.");
                    }
                    break;

                case 5:
                    sistema.mostraRiepilogo();
                    break;

                case 6:
                    sistema.confermaOrdine();
                    scelta = 0;
                    break;

                case 0:
                    System.out.println("Uscita");
                    break;
            }

        } while (scelta != 0);

        scanner.close();
    }
}