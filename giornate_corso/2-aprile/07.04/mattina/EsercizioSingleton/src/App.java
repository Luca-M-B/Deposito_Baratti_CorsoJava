public class App {

    public static void main(String[] args) {

        Logger logger1 = Logger.GetIstanza();// accesso al singleton
        logger1.ScriviMessaggio("Inizio"); // chiamo il metodo ScriviMessaggio()

        Logger logger2 = Logger.GetIstanza();// altro accesso al singleton
        logger2.ScriviMessaggio("Prima operazione");

        logger1.ScriviMessaggio("Fine"); // utilizzando logger1 o logger2 avrei lo stesso risultato

        if (logger1 == logger2) { // verifica stessa istanza
            System.out.println("Le due istanze corrispondono");
        } else {
            System.out.println("Le due istanze non corrispondono");
        }
    }
}
