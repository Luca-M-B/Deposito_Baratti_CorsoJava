package decorator;

import classi_base.Bevanda;

public class LatteDecorator extends BevandaDecorator {

    public LatteDecorator(Bevanda bevanda) {
        super(bevanda);
    }

    @Override
    public String getDescrizione() {
        return getBevanda().getDescrizione() + ", latte";
    }

    @Override
    public double getPrezzo() {
        return getBevanda().getPrezzo() + 0.20;
    }

}