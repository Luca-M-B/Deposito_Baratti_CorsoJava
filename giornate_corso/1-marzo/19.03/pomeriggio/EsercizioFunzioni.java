public class EsercizioFunzioni {

    public static long calcoloFattoriale(int a) { // return long per non aver problemi
        if (a == 0 || a == 1) { // se il parametro passato è 0 o 1 restituisco il risultato 1
            return 1;
        } else {
            return a * calcoloFattoriale(a - 1); // richiamo lo stesso metodo
        }
    }

    public static void calcoloFattoriale(String a) {
        System.out.println("Inserisci un numero valido.");
    }

    public static void main(String[] args) {

        calcoloFattoriale("5"); // chiamo il metodo passando una stringa

        System.out.println("Il fattoriale è: " + calcoloFattoriale(8)); // chiamo il metodo passando un numero
    }

}
