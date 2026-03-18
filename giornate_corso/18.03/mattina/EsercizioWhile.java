import java.util.Scanner;

public class EsercizioWhile {

    public static void main(String[] args) {

        String passwordCorretta = "java123";
        int tentativo = 0;
        boolean accessoEffettuato = false; // inizializzazione per uscita ciclo

        Scanner scanner = new Scanner(System.in);

        while (tentativo < 3 && !accessoEffettuato) { // controllo numero tentativi e se l'accesso ès tato effettutato

            System.out.println("Inserire la password");
            String passwordInserita = scanner.nextLine();

            if (passwordInserita.equals(passwordCorretta)) {

                Scanner input = new Scanner(System.in);
                String scelta;

                do {
                    System.out.println("Vuoi accedere al sistema? (s/n)");
                    scelta = input.nextLine();
                } while (!(scelta.equals("s") || scelta.equals("n"))); // controllo input finchè è s o n

                if (scelta.equals("s")) {
                    System.out.println("Accesso effettuato");
                    accessoEffettuato = true; // condizione di uscita
                    input.close();
                    break;
                } else {
                    System.out.println("Accesso annuòòato");
                    accessoEffettuato = true; // condizione di uscita
                    input.close();
                    break;
                }

            } else {
                tentativo++; // aumento numero tentativi
                System.out.println("Password non valida. Tentativi rimanenti: " + (3 - tentativo));
            }
        }

        scanner.close();

    }
}
