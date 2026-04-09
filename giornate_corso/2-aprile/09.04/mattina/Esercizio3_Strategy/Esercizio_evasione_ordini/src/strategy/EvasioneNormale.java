package strategy;

public class EvasioneNormale extends StrategiaEvasioneBase {

    @Override
    protected double getMoltiplicatore() {
        return 1.05; // +5%
    }

    @Override
    protected String getMessaggio() {
        return "Ordine evaso con procedura normale.";
    }
}