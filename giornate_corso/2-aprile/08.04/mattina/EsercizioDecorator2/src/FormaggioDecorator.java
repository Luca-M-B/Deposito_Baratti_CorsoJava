public class FormaggioDecorator extends HamburgerDecorator { // classe concreta

    public FormaggioDecorator(Hamburger hamburger) { // il costruttore riceve l'oggetto Hamburger da decorare
        super(hamburger);
    }

    @Override
    public String getDescrizione() { // aggiungo la descrizione di questa classe a quella dell'oggetto da decorare
        return getHamburger().getDescrizione() + ", formaggio";
    }

    @Override
    public double getPrezzo() { // aggiungo "0.50" al prezzo dell'oggetto base
        return getHamburger().getPrezzo() + 0.50;
    }
}
