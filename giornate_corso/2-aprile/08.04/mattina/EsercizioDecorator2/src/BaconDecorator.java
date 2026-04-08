public class BaconDecorator extends HamburgerDecorator {

    public BaconDecorator(Hamburger hamburger) {
        super(hamburger);
    }

    @Override
    public String getDescrizione() {
        return getHamburger().getDescrizione() + ", bacon";
    }

    @Override
    public double getPrezzo() {
        return getHamburger().getPrezzo() + 0.80;
    }
}
