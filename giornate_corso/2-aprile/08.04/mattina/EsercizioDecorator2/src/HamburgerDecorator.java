public abstract class HamburgerDecorator implements Hamburger {

    private Hamburger hamburger; // variabile di riferimento all'oggetto da decorare

    public HamburgerDecorator(Hamburger hamburger) { // costruttore con parametro l'oggetto da decorare
        this.hamburger = hamburger;
    }

    @Override
    public String getDescrizione() { // override metodo per richiamarlo sull'oggetto decorato
        return hamburger.getDescrizione();
    }

    @Override
    public double getPrezzo() {
        return hamburger.getPrezzo();
    }

    public Hamburger getHamburger() { // getter
        return hamburger;
    }

}
