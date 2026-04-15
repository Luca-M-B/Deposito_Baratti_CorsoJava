package strategy;

public class EvasionePrioritaria extends StrategiaEvasioneBase {

    @Override
    protected double getMoltiplicatore() {
        return 1.15; // +15%
    }

    @Override
    protected String getMessaggio() {
        return "Ordine evaso con procedura prioritaria.";
    }
}