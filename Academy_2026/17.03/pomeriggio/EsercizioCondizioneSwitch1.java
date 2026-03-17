import java.util.Scanner;

public class EsercizioCondizioneSwitch1 {

    public static void main(String[] args) {
        System.out.println(
                "Scegliere un'opzione digitando il numero di riferimento\n1) Visualizza profilo\n2) Modifica nome\n3) Logout");

        Scanner scanner = new Scanner(System.in);
        int scelta = scanner.nextInt();

        String nomeUtente = ""; // nome di default

        // menu di scelta e gestione dei casi
        switch (scelta) {
            case 1:
                System.out.println("Profilo utente visualizzato");
                break; // commentare per avere consequenzialità
            case 2:
                System.out.println("Inserire un nuovo nome");
                Scanner scannerNome = new Scanner(System.in);
                nomeUtente = scannerNome.nextLine();
                System.err.println("Nome aggiornato in: " + nomeUtente);
                break; // commentare per avere consequenzialità
            case 3:
                System.out.println("Logout effettuato");
                break;
            default:
                System.out.println("Scelta non valida");
                break;
        }

        scanner.close();
    }
}
