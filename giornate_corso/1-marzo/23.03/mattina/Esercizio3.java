import java.util.Scanner;

public class Esercizio3 {

    public static void main(String[] args) {

        Scanner inputString = new Scanner(System.in); // scanner per input parola
        Scanner inputChiave = new Scanner(System.in); // scanner input chiave
        String alfabeto = "abcdefghijklmnopqrstuvwxyz"; // inizializzo una stringa contenente l'alfabeto
        String parola = "";
        String parolaCriptata = "";
        int chiave;

        System.out.println("Inserire la parola che si desidera criptare: ");
        parola = inputString.nextLine().toLowerCase(); // assegno il valore alla variabile parola e mi assicuro che sia
                                                       // minuscolo

        System.out.println(
                "Inserire la chiave di criptazione (la chiave è un numero intero positivo compresa tra 1 e 26):");
        chiave = inputChiave.nextInt(); // assegno il valore preso in input alla variabile chiave

        /*
         * for (int i = 0; i < parola.length(); i++) { // itero la lunghezza della
         * parola per isolare i singoli caratteri
         * // che la compongono
         * char carattere = parola.charAt(i); // isolo ilc arattere a dato indice
         * 
         * if (carattere >= 'a' && carattere <= 'z') {
         * 
         * int posizione = carattere - 'a'; // in base alla tabella ASCII faccio un
         * confronto numerico dei valori
         * // dei caratteri ed ottengo un valore tra 0 e 25
         * int nuovaPosizione = (posizione + chiave) % 26; // utilizzo il modulo per non
         * rischiare valori fuori
         * // range 0-25
         * carattere = (char) (nuovaPosizione + 'a'); // torno nuovamente alle lettere
         * in base ai valori ottenuti
         * }
         * parolaCriptata = parolaCriptata + carattere; // concateno il carattere alla
         * parola finale
         * }
         */

        for (int i = 0; i < parola.length(); i++) { // ciclo la lunghezza della parola

            char carattere = parola.charAt(i); // assegno valore al carattere in data posizione (indice)
            int posizione = alfabeto.indexOf(carattere); // trovo la posizione di quel carattere nell'alfabeto

            if (posizione >= 0 && posizione <= (alfabeto.length() - 1)) { // se la posizione è tra 0 e 25

                int nuovaPosizione = (posizione + chiave) % 26; // assegno una nuova posizione utilizzando la chiave e
                                                                // ne prendo il modulo
                carattere = alfabeto.charAt(nuovaPosizione); // ora il carattere ha un nuovo valore nella stringa
                                                             // alfabeto
            }

            parolaCriptata = parolaCriptata + carattere;
        }

        System.out.println("Parola criptata: " + parolaCriptata);

        inputString.close();
        inputChiave.close();
    }

}
