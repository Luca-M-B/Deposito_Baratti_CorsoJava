import java.util.Scanner;

public class ProvaSwitch {
    public static void main(String[] args) {
        /*
         * int giorno = 4;
         * switch (giorno) {
         * case 1:
         * System.out.println("lunedì");
         * break;
         * case 2:
         * System.out.println("martedì");
         * break;
         * case 3:
         * System.out.println("mercoledì");
         * break;
         * case 4:
         * System.out.println("giovedì");
         * break;
         * case 5:
         * System.out.println("venerdì");
         * break;
         * case 6:
         * System.out.println("sabato");
         * break;
         * case 7:
         * System.out.println("domenica");
         * break;
         * 
         * }
         */

        System.out.println("Inserire nell'ordine il Nome, il Cognome e la Password.");

        Scanner nome = new Scanner(System.in);
        String nomeUtente = nome.nextLine();

        Scanner cognome = new Scanner(System.in);
        String cognomeUtente = cognome.nextLine();

        Scanner password = new Scanner(System.in);
        String pwUtente = password.nextLine();

        System.out.println("\nQuale informazione vuoi cambiare?");
        System.out.println("1) Nome");
        System.out.println("2) Cognome");
        System.out.println("3) Password");
        System.out.println("4) Nessuna delle precedenti");

        Scanner inputScelta = new Scanner(System.in);
        String scelta = inputScelta.nextLine();

        switch (scelta) {

            case "1":
                System.out.println("Inserisci il nuovo Nome:");
                Scanner nuovoNome = new Scanner(System.in);
                nomeUtente = nuovoNome.nextLine();
                break;

            case "2":
                System.out.println("Inserisci il nuovo Cognome:");
                Scanner nuovoCognome = new Scanner(System.in);
                cognomeUtente = nuovoCognome.nextLine();
                break;

            case "3":
                System.out.println("Inserisci la nuova Password:");
                Scanner nuovaPassword = new Scanner(System.in);
                pwUtente = nuovaPassword.nextLine();
                break;

            case "4":
                System.out.println("Nessuna modifica effettuata.");
                break;

            default:
                System.out.println("Opzione non valida.");
                break;
        }

        nome.close();
        cognome.close();
        password.close();
        inputScelta.close();

        System.out.println("\nDati finali:");
        System.out.println("Nome: " + nomeUtente);
        System.out.println("Cognome: " + cognomeUtente);
        System.out.println("Password: " + pwUtente);
    }
}
