// Observer per il reparto magazzino
public class RepartoMagazzino implements Notificatore {

    @Override
    public void update(Ordine ordine) {

        // Reagisce solo a specifici stati
        if (ordine.getStato() == StatoOrdine.IN_PREPARAZIONE) {
            System.out.println("Magazzino: Preparare l'ordine " + ordine.getId());
        }

        if (ordine.getStato() == StatoOrdine.ANNULLATO) {
            System.out.println("Magazzino: Ordine " + ordine.getId() + " annullato");
        }
    }
}