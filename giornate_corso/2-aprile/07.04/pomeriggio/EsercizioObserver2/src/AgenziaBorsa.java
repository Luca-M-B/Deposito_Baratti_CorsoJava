import java.util.*;

public class AgenziaBorsa {

    private List<Investitore> investitori = new ArrayList<>();
    private Map<String, Azione> azioni = new HashMap<>();
    private Random random = new Random();

    public void aggiungiInvestitore(Investitore i) {
        investitori.add(i);
    }

    public void aggiungiAzione(Azione a) {
        azioni.put(a.getNome(), a);
    }

    public Set<String> getNomiAzioni() {
        return azioni.keySet();
    }

    public void aggiornaValoreAzione(String nome) {

        Azione azione = azioni.get(nome);
        if (azione == null) {
            System.out.println("Azione non trovata.");
            return;
        }

        double vecchioValore = azione.getValore();

        // variazione percentuale [-0.5%, +0.5%]
        double percentuale = (random.nextDouble() - 0.5) / 100;
        double nuovoValore = vecchioValore * (1 + percentuale);

        azione.setValore(nuovoValore);

        System.out.printf("\nVariazione %s: %.2f → %.2f (%.4f%%)%n",
                nome, vecchioValore, nuovoValore, percentuale * 100);

        notificaInvestitori(azione);
    }

    private void notificaInvestitori(Azione azione) {

        for (Investitore i : investitori) {

            boolean possiede = i.getPortafoglio().stream()
                    .anyMatch(a -> a.getNome().equals(azione.getNome()));

            if (possiede) {
                i.notifica(azione.getNome(), azione.getValore());
            }
        }
    }

}