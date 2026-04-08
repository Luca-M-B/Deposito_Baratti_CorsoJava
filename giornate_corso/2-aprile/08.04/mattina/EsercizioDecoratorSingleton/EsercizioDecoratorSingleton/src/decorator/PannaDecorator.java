package decorator;

import classi_base.Bevanda;

public class PannaDecorator extends BevandaDecorator {

    public PannaDecorator(Bevanda bevanda) {
        super(bevanda);
    }

    @Override
    public String getDescrizione() {
        return getBevanda().getDescrizione() + ", panna";
    }

    @Override
    public double getPrezzo() {
        return getBevanda().getPrezzo() + 1.20;
    }

}
