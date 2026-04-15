public class EsempioSingleton {

    private static EsempioSingleton istance; // istanza privata statica della classe

    private EsempioSingleton() { // costruttore privato per impedire l'istanziazione diretta
    }

    public static EsempioSingleton getIstance() { // metodo pubblico statico per ottenere l'unica istanza della classe

        if (istance == null) { // se l'istanza non esiste, viene creata
            istance = new EsempioSingleton();
        }

        return istance; // se esiste restituisce l'unica istanza creabile
    }

    public void doSomething() { // metodo di esempio che può essere chiaato sull'istanza
        System.out.println("Singleton: doSomething() called");
    }

}
