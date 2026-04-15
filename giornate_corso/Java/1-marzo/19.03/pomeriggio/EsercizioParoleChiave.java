public class EsercizioParoleChiave {

    // esercizio 1
    public static double somma(double a, double b) {
        return a + b;
    }

    // esercizio 2
    public static int multiply(int a, int b) {
        return a * b;
    }

    public static double multiply(double a, double b, double c) {
        return a * b * c;
    }

    // esercizio 3
    public static int sommaNaturali(int x) {
        return x + sommaNaturali(x - 1);
    }

    // esercizio 4
    public static void modificaVariabile(int a) { // se viene passato un int
        System.out.println("Valore della variabile: " + a);
        System.out.println("Valore della variabile modificato: " + (a + 100));
    }

    public static void modificaVariabile(float a) { // se viene passato u n double
        System.out.println("Valore della variabile: " + a);
        System.out.println("Valore della variabile modificato: " + (a + 50.50));
    }

    public static void modificaVariabile(String a) { // se viene passata una stringa
        System.out.println("Stringa ricevuta: " + "'" + a + "'");
        System.out.println("Stringa modificata :" + "'" + "MODIFICA\\" + a + "\\MODIFICA" + "'");
    }

    public static void modificaArray(int[] arr) { // se viene passato un array di int
        int i = 0; // inizializzo indice di iterazione

        System.out.println("Stampa prima della modifica: ");
        while (i < arr.length) {
            System.out.print(arr[i] + " \n");
            i++;
        }

        i = 0; // riporto l'indice a 0
        while (i < arr.length) { // scorro tutto l'array
            arr[i] = arr[i] + 10; // incremento ogni valore di 10
            i++;
        }

        i = 0; // riporto l'indice a 0
        System.out.print("\nStampa dopo la modifica: ");
        while (i < arr.length) {
            System.out.print(arr[i] + " \n");
            i++;
        }
    }

    public static void modificaArray(float[] arr) { // se viene passato un array di float
        int i = 0;
        while (i < arr.length) {
            arr[i] = arr[i] + 0.5f; // modifico ogni elemento dell'array di +0.5
            i++;
        }
    }

    public static void modificaArray(String[] arr) { // se viene passato un array di String
        int i = 0;
        while (i < arr.length) {
            arr[i] = arr[i] + " - MODIFICA"; // aggiungo ad ogni stringa iterata una piccola parte
            i++;
        }
    }
}
