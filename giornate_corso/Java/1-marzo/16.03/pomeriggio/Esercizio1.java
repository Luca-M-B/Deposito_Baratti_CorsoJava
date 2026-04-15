import java.util.Scanner;

public class Esercizio1 {
    public static void main(String[] args) {

        Scanner prova = new Scanner(System.in); // richiesta inserimento numero
        System.out.println("Inserire un numero: ");

        int numeroInserito = prova.nextInt(); // lettura input utente
        System.out.println("numero inserito: " + numeroInserito);
        if (numeroInserito > 0) {
            System.out.println("il numero inserito è positivo");
        } else if (numeroInserito < 0) {
            System.out.println("il numero inserito è negativo");
        } else {
            System.out.println("il numero inserito è uguale a zero.");
        }
        prova.close();

        System.out.println("-----------------------------------------------------");

        Scanner inserimentoUno = new Scanner(System.in);
        Scanner inserimentoDue = new Scanner(System.in);
        System.out.println("inserire il primo numero: ");
        int primoNumero = inserimentoUno.nextInt();
        System.out.println("inserire il secondo numero: ");
        int secondoNumero = inserimentoDue.nextInt();

        if (primoNumero > secondoNumero) {
            System.out.println("il primo numero è maggiore");
        } else if (secondoNumero > primoNumero) {
            System.out.println("il secondo numero è maggiore");
        } else {
            System.out.println("i numeri sono uguali");
        }
        inserimentoUno.close();
        inserimentoDue.close();

        System.out.println("-----------------------------------------------------");

        System.out.println("Inserire un anno");
        Scanner provaAnno = new Scanner(System.in);
        int annoInserito = provaAnno.nextInt();

        if ((annoInserito / 400 == 0) || (annoInserito / 4 == 0 && annoInserito / 100 != 0)) {
            System.out.println("L'anno " + annoInserito + " è bisestile");
        } else {
            System.out.println("L'anno " + annoInserito + " non è bisestile.");
        }

        provaAnno.close();

        System.out.println("-----------------------------------------------------");

        System.out.println("inserire la propria età: ");
        Scanner inserimentoEta = new Scanner(System.in);
        int etaUtente = inserimentoEta.nextInt();
        if (etaUtente >= 18) {
            System.out.println("sei maggiorenne");
        } else {
            System.err.println("sei minorenne");
        }
        inserimentoEta.close();

        System.out.println("-----------------------------------------------------");
    }

}
