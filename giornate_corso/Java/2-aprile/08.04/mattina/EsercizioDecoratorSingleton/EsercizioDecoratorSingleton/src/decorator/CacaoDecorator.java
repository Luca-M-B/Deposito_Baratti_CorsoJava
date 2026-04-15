package decorator;

import classi_base.Bevanda;

public class CacaoDecorator extends BevandaDecorator {

    public CacaoDecorator(Bevanda bevanda) {
        super(bevanda);
    }

    @Override
    public String getDescrizione() {
        return getBevanda().getDescrizione() + ", cacao";
    }

    @Override
    public double getPrezzo() {
        return getBevanda().getPrezzo() + 0.40;
    }

}
