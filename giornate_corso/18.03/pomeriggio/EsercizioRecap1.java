import java.util.Scanner;

public class EsercizioRecap1 {

    public static void main(String[] args) {

        double credito = 10.00d; // credito iniziale
        int scelta; // scelta dell'utente
        double costoProdotto = 0; // costo prodotto

        do { // menu che si ripete finche non viene scelta l'opzione 5 (uscita) o termina il
             // credito
            System.out.println("\nCredito disponibile: " + credito);
            System.out.println(
                    "\nSelezionare il prodotto:\n1) Caffe 1.50 euro\n2) Cappuccino 2.00 euro\n3) Te 1.00 euro\n4) Acqua 0.50 euro\n5) Uscire\n");

            Scanner scanner = new Scanner(System.in);
            scelta = scanner.nextInt();// catturo la scelta

            switch (scelta) { // selezione prodotti
                case 1:
                    costoProdotto = 1.50;
                    break;
                case 2:
                    costoProdotto = 2.00;
                    break;
                case 3:
                    costoProdotto = 1.00;
                    break;
                case 4:
                    costoProdotto = 0.50;
                    break;
                case 5:
                    System.out.println("Termine operazione.");
                    break;
                default:
                    System.out.println("Scelta non valida");
                    break;
            }

            if (scelta > 0 && scelta < 5) { // se la scelta corrisponde ad un prodotto
                if (credito >= costoProdotto) { // verifico disponibilita credito
                    credito = credito - costoProdotto;
                    System.out.println("\nProdotto erogato.");
                    // System.out.println("Credito residuo: " + credito);
                } else {
                    System.out.println("Credito non suffiente.");
                }
            }

            // scanner.close();

        } while (scelta != 5 && credito > 0); // se c'è credito residuo e se non viene scelta opzione 5, ripeto il ciclo

    }
}