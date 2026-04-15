public class App {

    public static void main(String[] args) throws Exception {

        Operazione addizione = new Addizione();
        Operazione moltiplicazione = new Moltiplicazione();

        Calcolatore calcolatore = new Calcolatore(moltiplicazione);

        System.out.println("Prodotto = " + calcolatore.calcola(10, 5));

        calcolatore.setOperazione(addizione);

        System.out.println("Somma = " + calcolatore.calcola(10, 5));

    }
}
