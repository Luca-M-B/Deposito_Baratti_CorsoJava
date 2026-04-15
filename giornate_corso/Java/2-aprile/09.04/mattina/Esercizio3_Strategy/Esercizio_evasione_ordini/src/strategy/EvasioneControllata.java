package strategy;

public class EvasioneControllata extends StrategiaEvasioneBase {

    @Override
    protected double getMoltiplicatore() {
        return 0.95; // -5%
    }

    @Override
    protected String getMessaggio() {
        return "Ordine evaso con procedura controllata.";
    }
}