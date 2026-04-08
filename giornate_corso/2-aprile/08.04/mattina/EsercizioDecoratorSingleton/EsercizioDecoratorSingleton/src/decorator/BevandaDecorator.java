package decorator;

import classi_base.Bevanda;

public abstract class BevandaDecorator implements Bevanda {

    private Bevanda bevanda;

    public BevandaDecorator(Bevanda bevanda) {
        this.bevanda = bevanda;
    }

    public Bevanda getBevanda() {
        return bevanda;
    }

    @Override
    public String getDescrizione() {
        return bevanda.getDescrizione();
    }

    @Override
    public double getPrezzo() {
        return bevanda.getPrezzo();
    }

}