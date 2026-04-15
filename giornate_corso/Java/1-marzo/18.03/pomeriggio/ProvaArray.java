public class ProvaArray {

    public static void main(String[] args) {

        /*
         * // dichiarazione e inizializzazione array
         * int[] numeri = new int[5]; // dichiarazione
         * 
         * int[] valori = { 1, 2, 3, 4, 5 }; // inizializzazione diretta
         */

        int[] numeri = { 10, 20, 30, 40, 50 };

        System.out.println("Primo numero dell'array: " + numeri[0]);

        System.out.println("---------------------------------");

        int[] nuoviNumeri = new int[5]; // dichiarazione array

        for (int i = 0; i < nuoviNumeri.length; i++) { // riempimento dinamico dell'array
            nuoviNumeri[i] = i + 1;
        }

        System.out.println("Elementi dell'array: ");
        for (int i = 0; i < nuoviNumeri.length; i++) {
            System.err.println(nuoviNumeri[i] + " ");
        }

        System.out.println("---------------------------------");

        int[][] matrice = new int[3][3]; // dichiarazione array multidimensionale (2 dimensioni/matrice)

        int[][] matricePredefinita = { // inizializzazione array due dimensioni
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
    }
}
