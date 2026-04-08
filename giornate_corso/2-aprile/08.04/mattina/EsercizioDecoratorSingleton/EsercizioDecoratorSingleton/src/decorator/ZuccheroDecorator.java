package decorator;

import classi_base.Bevanda;

public class ZuccheroDecorator extends BevandaDecorator {

    public ZuccheroDecorator(Bevanda bevanda) {
        super(bevanda);
    }

    @Override
    public String getDescrizione() {
        return getBevanda().getDescrizione() + ", zucchero";
    }

    @Override
    public double getPrezzo() {
        return getBevanda().getPrezzo() + 0.05;
    }

}
