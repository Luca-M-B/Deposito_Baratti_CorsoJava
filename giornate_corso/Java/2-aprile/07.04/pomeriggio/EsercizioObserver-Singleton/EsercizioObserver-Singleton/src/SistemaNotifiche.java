// Observer per notifiche cliente
public class SistemaNotifiche implements Notificatore {

    @Override
    public void update(Ordine ordine) {

        System.out.println("Notifica cliente "
                + ordine.getCliente()
                + ": stato aggiornato a "
                + ordine.getStato());
    }
}