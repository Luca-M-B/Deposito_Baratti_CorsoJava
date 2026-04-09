package decorator;

import computer.*;

public class RaffreddamentoExtra extends ComponenteExtraDecorator {

    public RaffreddamentoExtra(Computer computer) {
        super(computer);
    }

    public String getDescrizione() {
        return computer.getDescrizione() + ", Raffreddamento Extra";
    }

    public double getPrezzo() {
        return computer.getPrezzo() + 240;
    }

}