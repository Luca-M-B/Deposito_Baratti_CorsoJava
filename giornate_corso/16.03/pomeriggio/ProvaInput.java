import java.util.Scanner; // import della classe Scanner di java

public class ProvaInput {
    public static void main(String[] args) {
        Scanner mioOggetto = new Scanner(System.in); // creazione oggetto Scanner
        System.out.println("Inserire username");

        String nomeUtente = mioOggetto.nextLine(); // lettura input utente
        System.out.println("Username inserito: " + nomeUtente); // output
        mioOggetto.close();
    }
}
