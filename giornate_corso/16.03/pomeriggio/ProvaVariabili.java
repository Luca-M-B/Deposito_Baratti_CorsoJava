public class ProvaVariabili {

    public static void main(String[] args) {

        // char - contiene singoli caratteri come 'a' o 'B'.

        // String - è una serie di char quindi contiene del testo come "Ciao".
        // String è l'unico tipo primitivo speciale perché formato da char.
        String provaTesto = "Ciao Mondo";
        System.out.println(provaTesto);

        // int - contiene numeri positivi come '123' o '-123'.
        int provaNumero = 12;
        System.out.println(provaNumero);

        // float - contiene numeri a virgola mobile (decimali) come '19,99' o '-19,99'.

        // boolean - contiene un valore che può essere 'vero' o 'falso'.
        boolean provaBoolean = true;
        System.out.println(provaBoolean);
        boolean provaBool;
        // System.out.println(provaBool) sarebbe sbagliato perché non inizializzato ma
        // solo dichiarato.
        provaBoolean = false;
        System.out.println(provaBoolean);
        provaBool = true;
        System.out.println(provaBool);

        final int provaNumeroCostante = 15;
        // provaNumeroCostante = 20;
        // errore perchè con il final diventa una COSTANTE
        System.out.println(provaNumeroCostante);

        System.out.println("---------------------------");

        String testo = "Prova";
        System.out.println(testo);

        testo = "Mondo";
        System.out.println("Ciao " + testo);
        // questo è un esempio di concatenazione

        String firstPart = "Ciao ";
        String secondPart = "Mondo";
        String fullPart = firstPart + secondPart;
        System.out.println(fullPart);

        System.out.println("---------------");

        int x = 5; // dichiarazione e inizializzazione
        int y = 6;
        System.out.println(x + y);

        int a = 1, b = 3, c = 40; // dichiarazione e inizializzazione di più variabili dello stesso tipo
        System.out.println(a + b + c);

        int e, f, g; // dichiarazione di più variabili dello stesso tipo
        e = f = g = 50; // inizializzazione delle variabili dichiarate precedentemente
        System.out.println(e + f + g);

        String stringaDiProva = "Luca";
        System.out.println(stringaDiProva.charAt(0));

    }

}
