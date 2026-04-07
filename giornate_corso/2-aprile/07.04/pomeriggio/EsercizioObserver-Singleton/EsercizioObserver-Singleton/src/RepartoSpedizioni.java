// Observer per spedizioni
public class RepartoSpedizioni implements Notificatore {

    @Override
    public void update(Ordine ordine) {

        if (ordine.getStato() == StatoOrdine.SPEDITO) {
            System.out.println("Spedizioni: Ordine " + ordine.getId() + " spedito");
        }
    }
}