public class EsempiMatematica {

    public static void main(String[] args) {

        System.out.println(Math.max(5, 10)); // usato per trovare il valore più alto
        System.out.println(Math.min(8, 20)); // usato per trovare il valore piu basso
        System.out.println(Math.sqrt(64)); // restituisce la radice quadrata

        System.out.println("---------------------------------");

        System.out.println(Math.abs(-4.7)); // restituisce il valore assoluto
        System.out.println(Math.random()); // restituisce un valore casuale tra 0.0 e 1.0 (escluso)
        int randomNum = (int) (Math.random() * 101); // un valore random da 0 a 100 (0 incluso, 101 escluso)
        System.out.println(randomNum);

        System.out.println("---------------------------------");

    }

}
