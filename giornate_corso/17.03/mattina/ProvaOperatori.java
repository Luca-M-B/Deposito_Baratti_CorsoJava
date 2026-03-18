public class ProvaOperatori {
    public static void main(String[] args) {

        int x = 100 + 50;
        System.out.println(x);
        int somma1 = 100 + 50; // 150 (100+50)
        System.out.println(somma1);
        int somma2 = somma1 + 250; // 400 (150 + 250)
        System.out.println(somma2);
        int somma3 = somma2 + somma2; // 800 (400 + 400);
        System.out.println(somma3);

        System.out.println("--------------------------------");

        // esempi di operatori di assegnazione
        int numero = 10;
        System.out.println(numero); // 10
        numero += 2;
        System.out.println(numero); // 12
        numero -= 5;
        System.out.println(numero); // 7
        numero *= 2;
        System.out.println(numero); // 14
        numero /= 2;
        System.out.println(numero); // 7
        numero++;
        System.out.println(numero); // 8

        System.out.println("--------------------------------");

        int provaIncremento = 10;
        System.out.println(provaIncremento++); // prima stampa poi incrementa
        System.out.println(++provaIncremento); // prima incrementa poi stampa
        System.out.println("--------------------------------");
        System.out.println(provaIncremento--); // prima stampa poi decrementa
        System.out.println(--provaIncremento); // prima decrementa poi stampa

        System.out.println("--------------------------------");

        int numero1 = 5;
        int numero2 = 20;

        // esempio di operatori di confronto
        if (numero1 > numero2) {
            System.out.println(numero1 + " è maggiore di " + numero2);
        } else if (numero1 < numero2) {
            System.out.println(numero1 + " è minore di " + numero2);
        } else if (numero1 == numero2) {
            System.out.println(numero1 + " è uguale a " + numero2);
        }

        System.out.println("--------------------------------");

        // esempi di operatori logici
        System.out.println(numero2 < 10 && numero2 > 5);
        System.out.println(numero2 < 10 || numero2 > 5);
        System.out.println(!(numero2 < 10));

        System.out.println("--------------------------------");

        
    }
}
