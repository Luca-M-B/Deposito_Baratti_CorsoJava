import java.util.Scanner;

public class EsercizioRecap2 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        float saldo = 1000.00f;
        int scelta = 0;
        boolean continua = true; // inizializzo per avviare il ciclo

        while (continua) { // ciclo da ripete finchè la variabile continua non diventa false
            System.out.println(
                    "\nSelezionare un'operazione: \n1 - Visualizza saldo\n2 - Preleva\n3 - Deposita\n4 - Esci\n");

            scelta = input.nextInt(); // catturo la scelta

            switch (scelta) { // gestisco le scelte
                case 1:
                    System.out.println("\nIl saldo attuale è: " + saldo + " euro.");
                    System.out.println("-------------------------------------");
                    break;

                case 2:
                    System.out.println("\nDigitare importo da prelevare: ");

                    float prelievo = input.nextFloat();

                    if (prelievo < 0) { // controllo che sia positivo
                        break;
                    }

                    if (prelievo > saldo) {
                        System.out.println("\nImpossibile procedere. Saldo insuffiente per l'operazione");
                    } else {
                        saldo = saldo - prelievo;
                        System.out.println("\nOperazine riuscita. Nuovo saldo disponibile: " + saldo);
                    }
                    System.out.println("-------------------------------------");
                    break;

                case 3:
                    System.out.println("\nDigitare l'importo da depositare: ");

                    float deposito = input.nextFloat();

                    if (deposito < 0) {
                        break;
                    }

                    saldo = saldo + deposito;
                    System.out.println("\nOperazione riuscita. Nuovo saldo disponibile: " + saldo);
                    System.out.println("-------------------------------------");
                    break;

                case 4:
                    System.out.println("\nUscita in corso. Arrivederci.");
                    continua = false; // cambio valore per interrompere il while
                    System.out.println("-------------------------------------");
                    break;

                default:
                    System.out.println("\nScelta non valida.\nSelezionare un'opzione valida");
                    System.out.println("-------------------------------------");
                    break;
            }
        }

        // input.close();

    }
}
