public class BaseBurger implements Hamburger {

    @Override
    public String getDescrizione() { // override getDescrizione
        return "Hamburger base";
    }

    @Override
    public double getPrezzo() { // override getPrezzo
        return 4.00;
    }

}
