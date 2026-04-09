package strategy;

public abstract class StrategiaEvasioneBase implements StrategiaEvasione {

    @Override
    public void evadi(Ordine ordine) {

        // Applico la variazione di prezzo
        double nuovoPrezzo = ordine.getPrezzo() * getMoltiplicatore();
        ordine.setPrezzo(nuovoPrezzo);

        System.out.println(getMessaggio() + " Prezzo aggiornato: " + nuovoPrezzo);
    }

    protected abstract double getMoltiplicatore();

    protected abstract String getMessaggio();
}