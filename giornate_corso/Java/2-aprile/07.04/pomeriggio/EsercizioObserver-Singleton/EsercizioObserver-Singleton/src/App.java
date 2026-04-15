import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        GestoreOrdini gestore = new GestoreOrdini();

        // Observer
        gestore.aggiungiOsservatore(new RepartoMagazzino());
        gestore.aggiungiOsservatore(new RepartoSpedizioni());
        gestore.aggiungiOsservatore(new SistemaNotifiche());

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("\n\tMENU");
            System.out.println("1. Crea ordine");
            System.out.println("2. Aggiorna stato ordine");
            System.out.println("3. Mostra tutti gli ordini");
            System.out.println("4. Cerca ordine per ID");
            System.out.println("0. Esci");

            int scelta = scanner.nextInt();
            scanner.nextLine(); // pulizia buffer

            switch (scelta) {

                case 1:
                    System.out.print("Nome cliente: ");
                    String cliente = scanner.nextLine();

                    System.out.print("Prodotto: ");
                    String prodotto = scanner.nextLine();

                    System.out.print("Quantità: ");
                    int q = scanner.nextInt();

                    Ordine nuovo = new Ordine(0, cliente, prodotto, q, StatoOrdine.CREATO);
                    gestore.salvaOrdine(nuovo);
                    break;

                case 2:
                    System.out.print("ID ordine: ");
                    int id = scanner.nextInt();

                    System.out.println("1. IN_PREPARAZIONE");
                    System.out.println("2. SPEDITO");
                    System.out.println("3. CONSEGNATO");
                    System.out.println("4. ANNULLATO");

                    int s = scanner.nextInt();

                    StatoOrdine stato = switch (s) {
                        case 1 -> StatoOrdine.IN_PREPARAZIONE;
                        case 2 -> StatoOrdine.SPEDITO;
                        case 3 -> StatoOrdine.CONSEGNATO;
                        case 4 -> StatoOrdine.ANNULLATO;
                        default -> StatoOrdine.CREATO;
                    };

                    gestore.aggiornaStato(id, stato);
                    break;

                case 3:
                    List<Ordine> lista = gestore.getAllOrdini();

                    for (Ordine o : lista) {
                        System.out.println("ID ordine: " + o.getId() + " | " +
                                "Nome cliente: " + o.getCliente() + " | " +
                                "Prodotto: " + o.getProdotto() + " | " +
                                "Quantita: " + o.getQuantita() + " | " +
                                "Stato ordine" + o.getStato());
                    }
                    break;

                case 4:
                    System.out.print("ID: ");
                    int cercaId = scanner.nextInt();

                    Ordine o = gestore.getOrdineById(cercaId);

                    if (o != null) {
                        System.out.println(o.getCliente() + " - " + o.getStato());
                    } else {
                        System.out.println("Ordine non trovato");
                    }
                    break;

                case 0:
                    System.out.println("Chiusura");
                    return;

                default:
                    System.out.println("Scelta non valida");
            }

        }

    }
}
