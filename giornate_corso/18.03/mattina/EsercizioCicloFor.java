import java.util.Scanner;

public class EsercizioCicloFor {

    public static void main(String[] args) {

        int numeroVoti = 0;
        int votiValidi = 0;

        Scanner scanner = new Scanner(System.in);

        while (numeroVoti <= 0) { // validazione numero dei voti maggiore di zero
            System.out.println("Quanti voti vuoi inserire?");
            numeroVoti = scanner.nextInt();
            if (numeroVoti <= 0) {
                System.out.println("Inserire un numero intero positivo");
            }
        }

        for (int i = 1; i <= numeroVoti; i++) { // inserimento voti
            // System.out.println("Inserire un numero compreso tra 0 e 30");
            System.out.println("Inserire il voto numero " + i + " (compreso tra 0 e 30): ");
            int voto = scanner.nextInt();

            if (voto < 0 || voto > 30) { // valutazione range voto
                System.out.println("Voto non valido.");
            }

            votiValidi++; // incremento solo se il voto è valido

            if (voto == 30) { // assegnazione giudizio in base al range
                System.out.println("Eccellente");
            } else if (voto >= 24) {
                System.out.println("Buono o Ottimo");
            } else if (voto >= 18) {
                System.out.println("Sufficiente");
            } else {
                System.out.println("Insufficiente");
            }
        }

        System.out.println("Numero di voti inseriti: " + votiValidi); // stampa numero dei voti inseriti correttamente

        scanner.close();
    }
}
