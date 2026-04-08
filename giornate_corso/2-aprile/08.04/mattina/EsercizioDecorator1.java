interface Messaggio {
    String getContenuto();
}

// classe concreta che implementa interfaccia messaggio
class MessaggioBase implements Messaggio {

    @Override
    public String getContenuto() {
        return "Messaggio da decorare";
    }
}

// decorator che implementa messaggio
class DecoratoreMaiuscolo implements Messaggio {

    private Messaggio messaggio; // oggetto Messaggio privato

    public DecoratoreMaiuscolo(Messaggio messaggio) { // costruttore con oggetto Messaggio come parametro
        this.messaggio = messaggio;
    }

    @Override
    public String getContenuto() {
        return messaggio.getContenuto().toUpperCase();
    }
}

public class EsercizioDecorator1 {

    public static void main(String[] args) {

        MessaggioBase messaggio = new MessaggioBase(); // creo oggetto MessaggioBase dalla classe concreta

        System.out.println(messaggio.getContenuto()); // il messaggio qui ancora non è decorato

        Messaggio messaggioDecorato = new DecoratoreMaiuscolo(messaggio); // passo l'oggetto Messaggio come parametro
                                                                          // per creare l'oggetto decorato dalla classe
                                                                          // DecoratoreMaiuscolo

        System.out.println(messaggioDecorato.getContenuto()); // qui il messaggio è decorato
    }
}