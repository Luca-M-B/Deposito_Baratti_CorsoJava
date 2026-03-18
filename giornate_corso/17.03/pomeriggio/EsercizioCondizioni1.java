import java.util.Scanner;

public class EsercizioCondizioni1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserire username: ");
        String username = scanner.nextLine();

        // controllo condizioni dell'esercizio
        if (username == null || username.trim().isEmpty()) {
            System.out.println("Username non valido");
        } else if (username.length() < 5 && username.length() >0) {
            System.out.println("Username troppo corto");
        } else {
            System.out.println("Username valido!");
        }

        scanner.close(); // chiusura scanner

    }
}
