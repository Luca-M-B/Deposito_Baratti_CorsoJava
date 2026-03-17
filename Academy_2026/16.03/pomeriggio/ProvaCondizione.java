public class ProvaCondizione {
    public static void main(String[] args) {

        // classico blocco if(condizione)
        if (20 > 18) {
            System.out.println("20 è maggiore di 18");
        }

        int x = 20;
        int y = 15;
        if (x > y) {
            System.out.println("x è maggiore di y");
        }

        // blocco if (condizione) else
        int ora = 20;
        if (ora < 18) {
            System.out.println("buon pomeriggio");
        } else {
            System.out.println("buona sera");
        }

        // blocco if (condizione) else if (condizione) else
        int orario = 22;
        if (orario < 10) {
            System.out.println("buon giorno");
        } else if (orario < 18) {
            System.out.println("buon pomeriggio");
        } else {
            System.out.println("buona sera");
        }
    }
}
