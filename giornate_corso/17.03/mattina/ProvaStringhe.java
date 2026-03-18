
import java.util.Arrays;

public class ProvaStringhe {

    public static void main(String[] args) {

        String greeting = "Hello";
        System.out.println(greeting);

        System.out.println("---------------------------------");

        String txt = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        System.out.println("La lunghezza di txt è " + txt.length());

        System.out.println("---------------------------------");

        String txt2 = "Hello World";
        System.out.println(txt2.toUpperCase()); // stampa tutto in maiuscolo
        System.out.println(txt2.toLowerCase()); // stampa tutto in minuscolo

        System.out.println("---------------------------------");

        String txt3 = "Please locate where 'locate' occurs!";
        System.out.println(txt3.indexOf("locate")); // stampa 7 perchè il primo 'locate' inizia all'indice 7

        System.out.println("---------------------------------");

        // concatenazione di stringhe
        String firstName = "Luca";
        String secondName = "Baratti";
        System.out.println(firstName + " " + secondName); // stampa "Luca Baratti"

        String firstName1 = "Luca";
        String secondName2 = "Baratti";
        System.out.println(firstName1.concat(secondName2)); // stampa "LucaBaratti" senza alcuno spazio

        System.out.println("---------------------------------");

        // String testo = "We are the so-called "Vikings" from the north."; ERRORE! Per
        // inserire le virgolette i caratteri sono \' o \" o \\
        String testo = "We are the so-called \"Vikings\" from the north.";
        System.out.println(testo);

        /*
         * altre sequenze di escape sono:
         * \n new line
         * \r carriage return
         * \t tabulazione
         * \b backspace
         * \f from feed
         */
        System.out.println("Prova \n nuova linea");
        System.out.println("Prova \r carriage return");
        System.out.println("Prova \t tabulazione");
        System.out.println("Prova \b back space");
        System.out.println("Prova \f from feed");

        System.out.println("---------------------------------");

        // per splittare una stringa
        String stringhetta = "Ciao come stai?";
        String[] words = stringhetta.split("\\s");
        System.out.println(Arrays.toString(words));

        System.out.println("---------------------------------");
    }
}
