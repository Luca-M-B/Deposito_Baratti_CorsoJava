import java.util.Scanner;

public class EsercizioCondizioni2 {

    public static void main(String[] args) {

        // dati corretti (traccia esercizio)
        String usernameCorretto = "admin";
        String pwCorretta = "1234";

        // scanner username
        Scanner scannerUsername = new Scanner(System.in);
        System.out.print("Inserire username: ");
        String username = scannerUsername.nextLine();

        // scanner password
        Scanner scannerPassword = new Scanner(System.in);
        System.out.print("Inserire username: ");
        String password = scannerPassword.nextLine();

        scannerPassword.close();
        scannerUsername.close();

        // controlli per username e password
        if (username.equalsIgnoreCase(usernameCorretto) && password.equals(pwCorretta)) {
            System.out.println("Accesso consentito");
        } else if (!(username.equalsIgnoreCase(usernameCorretto)) && !(password.equals(pwCorretta))) {
            System.out.println("Accesso negato");
        } else {
            System.out.println("Credenziali errate");
        }
    }

}
