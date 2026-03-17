public class ProvaCasting {
    public static void main(String[] args) {

        int myInt = 9;
        double myDouble = myInt; // casting automatico da int a double detto coercizione

        System.out.println(myInt); // stampa 9
        System.out.println(myDouble); // stampa 9.0

        System.out.println("--------------------------------");

        double numeroDouble = 9.78d;
        int numeroIntero = (int) numeroDouble; // casting manuale da double a int detto casting attivo

        System.out.println(numeroDouble); // stampa 9.78
        System.out.println(numeroIntero); // stampa 9

        System.out.println("----------------------------------");

        /*
         * double provaStringa = 95;
         * String miaParola = (String) provaStringa; // errore anche perché disalloca
         * memoria!
         * System.out.println(miaParola);
         */

    }
}
