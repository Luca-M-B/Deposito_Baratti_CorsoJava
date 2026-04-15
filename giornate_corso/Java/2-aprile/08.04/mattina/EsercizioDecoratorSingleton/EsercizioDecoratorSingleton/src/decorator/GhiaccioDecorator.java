package decorator;

import classi_base.Bevanda;

public class GhiaccioDecorator extends BevandaDecorator {

    public GhiaccioDecorator(Bevanda bevanda) {
        super(bevanda);
    }

    @Override
    public String getDescrizione() {
        return getBevanda().getDescrizione() + ", ghiaccio";
    }

    @Override
    public double getPrezzo() {
        return getBevanda().getPrezzo() + 0.10;
    }

}
