public class App {
    public static void main(String[] args) throws Exception {

        Hamburger baseBurger = new BaseBurger(); // oggetto di base da decorare

        baseBurger = new FormaggioDecorator(baseBurger); // decoro con formaggio
        baseBurger = new BaconDecorator(baseBurger); // decoro con bacon

        System.out.println("Descrizione: " + baseBurger.getDescrizione());
        System.out.println("Costo finale: " + baseBurger.getPrezzo());

    }
}
