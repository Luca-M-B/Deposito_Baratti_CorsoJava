package decorator;

import computer.*;

public class RamExtra extends ComponenteExtraDecorator {

    public RamExtra(Computer computer) {
        super(computer);
    }

    public String getDescrizione() {
        return computer.getDescrizione() + ", RAM Extra";
    }

    public double getPrezzo() {
        return computer.getPrezzo() + 400;
    }

}