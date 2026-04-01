import java.util.ArrayList;
import java.util.Collections;

public class EsempiArrayList {

    public static void main(String[] args) {

        ArrayList<Integer> numeri = new ArrayList<>();
        numeri.add(10);
        numeri.add(20);
        numeri.add(30);

        System.out.println(numeri);

        System.out.println("------------------------");

        ArrayList<String> nomi = new ArrayList<>(); // dichiarazione
        nomi.add("Alice"); // aggiungo una stringa alla volta in ordine
        nomi.add("Bob");
        nomi.add("Carlo");

        System.err.println("Primo nome dell'array list: " + nomi.get(0)); // stampo in base all'indice
        System.err.println("Nome alla seconda posizione: " + nomi.get(1));
        System.out.println(nomi); // stampo tutto il contenuto

        System.out.println("------------------------");

        /* -----ESERCIZIO----- */

        ArrayList<Integer> numeriEsercizio = new ArrayList<>();

        for (int i = 0; i < 10; i++) { // ciclo for per aggiungere 10 numeri
            numeriEsercizio.add((int) (Math.random() * 100) + 1); // genero 10 numeri casuali
        }

        System.out.println("Lista originale: " + numeriEsercizio); // stampa lista originale

        Collections.sort(numeriEsercizio); // ordinamento della lista

        System.out.println("Lista ordinata: " + numeriEsercizio); // stampo la lista con il nuovo ordinamento

        System.out.println("------------------------");
    }
}