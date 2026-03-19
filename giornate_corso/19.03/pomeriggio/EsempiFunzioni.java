public class EsempiFunzioni {

    static void /* tipo di ritorno */ saluta(/* parametri */) {
        System.out.println("Ciao!"); // corpo del metodo
    } // eventuale return se non è void

    static int somma(int a, int b) {
        return a + b;
    }

    static void mostra(int numero) {
        System.out.println("Numero: " + numero);
    }

    static void mostra(String testo) {
        System.out.println("Testo: " + testo);
    }

    // RICORSIONE: un metodo che chiama se stesso
    public static long calcoloFattoriale(int a) {
        if (a == 0 || a == 1) {
            return 1;
        } else {
            return a * calcoloFattoriale(a - 1);
        }
    }

    static void modifica(int[] arr) { // metodo che accetta un array
        arr[0] = 99; // questa modifica sarà visibile all'esterno
    }

    public static void main(String[] args) {
        saluta(); // chiamata del metodo

        System.out.println(somma(10, 20)); // chiamo il metodo dento una stampa e gli passo due parametri

        mostra(10); // chiamo mostra(int)
        mostra("Ciaooooooo"); // chiamo mostra(String)

        int[] numeri = { 1, 2, 3, 4 };
        modifica(numeri); // passaggio per riferimento, NON per valore!
        System.out.println(numeri[0]); // stampa 99
    }
}
