package decorator;

import computer.*;

public class SsdExtra extends ComponenteExtraDecorator {

    public SsdExtra(Computer computer) {
        super(computer);
    }

    public String getDescrizione() {
        return computer.getDescrizione() + ", SSD Extra";
    }

    public double getPrezzo() {
        return computer.getPrezzo() + 100;
    }

}