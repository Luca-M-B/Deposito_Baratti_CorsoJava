import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    private static Logger istance; // istanza privata statica della classe

    private Logger() { // costruttore privato

    }

    public static Logger GetIstanza() { // metodo pubblico statico per ottenere l'unica istanza della classe

        if (istance == null) { // se l'istanza non esiste, viene creata
            istance = new Logger();
        }

        return istance; // se esiste restituisce l'unica istanza creabile
    }

    public void ScriviMessaggio(String messaggio) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); // formattazione date time
        String dataOra = LocalDateTime.now().format(formatter);
        System.out.println("[" + dataOra + "] " + messaggio);
    }

}
