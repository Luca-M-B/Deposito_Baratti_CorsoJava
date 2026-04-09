package decorator;

import computer.*;

public class SchedaVideoExtra extends ComponenteExtraDecorator {

    public SchedaVideoExtra(Computer computer) {
        super(computer);
    }

    public String getDescrizione() {
        return computer.getDescrizione() + ", Scheda Video Extra";
    }

    public double getPrezzo() {
        return computer.getPrezzo() + 700;
    }

}