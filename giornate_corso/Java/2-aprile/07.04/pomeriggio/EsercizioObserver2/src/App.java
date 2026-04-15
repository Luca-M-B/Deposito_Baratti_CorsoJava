import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        AgenziaBorsa agenzia = new AgenziaBorsa();
        Random random = new Random();

        // Azioni con valore dandom
        ArrayList<Azione> listaAzioni = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            double valoreIniziale = 10 + random.nextDouble() * 100; // range realistico
            Azione a = new Azione("azione" + i, valoreIniziale);
            listaAzioni.add(a);
            agenzia.aggiungiAzione(a);
        }

        // investitori
        ArrayList<Investitore> investitori = new ArrayList<>();

        InvestitorePrivato mario = new InvestitorePrivato("Mario");
        InvestitorePrivato laura = new InvestitorePrivato("Laura");
        InvestitorePrivato giulia = new InvestitorePrivato("Giulia");

        InvestitoreBancario unicredit = new InvestitoreBancario("UniCredit");
        InvestitoreBancario intesa = new InvestitoreBancario("Intesa");

        investitori.add(mario);
        investitori.add(laura);
        investitori.add(giulia);
        investitori.add(unicredit);
        investitori.add(intesa);

        // assegnazione randomica di azioni agli investitori
        for (Investitore inv : investitori) {

            int numeroAzioni = 1 + random.nextInt(5); // ogni investitore ha 1-5 azioni

            Collections.shuffle(listaAzioni);

            for (int i = 0; i < numeroAzioni; i++) {
                Azione a = listaAzioni.get(i);

                if (inv instanceof InvestitorePrivato) {
                    ((InvestitorePrivato) inv).aggiungiAzione(a);
                } else if (inv instanceof InvestitoreBancario) {
                    ((InvestitoreBancario) inv).aggiungiAzione(a);
                }
            }

            agenzia.aggiungiInvestitore(inv);
        }

        // MENU LOOP
        while (true) {

            System.out.println("\n--- MENU BORSA ---");
            System.out.println("Azioni disponibili:");

            for (String nome : agenzia.getNomiAzioni()) {
                System.out.println("- " + nome);
            }

            System.out.println("Inserisci nome azione (oppure 'exit'):");
            String scelta = scanner.nextLine();

            if (scelta.equalsIgnoreCase("exit")) {
                break;
            }

            agenzia.aggiornaValoreAzione(scelta);
        }

        scanner.close();
        System.out.println("Sistema terminato.");

    }

}
