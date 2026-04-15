package decorator;

import classi_base.Bevanda;

public class CannellaDecorator extends BevandaDecorator {

    public CannellaDecorator(Bevanda bevanda) {
        super(bevanda);
    }

    @Override
    public String getDescrizione() {
        return getBevanda().getDescrizione() + ", cannella";
    }

    @Override
    public double getPrezzo() {
        return getBevanda().getPrezzo() + 0.20;
    }

}
