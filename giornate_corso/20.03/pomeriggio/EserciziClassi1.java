public class EserciziClassi1 {

    public static void main(String[] args) {

        Libro primoLibro = new Libro("Pippo", "Il libro delle barzellette", 10.99f);
        Libro secondoLibro = new Libro("Ignoto", "Diario perduto", 23.00f);

        primoLibro.mostraDettagli();
        secondoLibro.mostraDettagli();

        System.out.println("------------------------------------------------");

        Persona personaUno = new Persona("Luca", 30, "Roma"); // creo attraverso i costruttori due oggetti della classe
                                                              // Persona
        Persona personaDue = new Persona("Pippo", 99, "Nessuna");

        personaUno.mostraDettagli(); // su ciascun oggetto chiamo il metodo mostraDettagli
        personaDue.mostraDettagli();

        System.out.println("------------------------------------------------");

        Calcolatrice calcolatriceUno = new Calcolatrice();
        calcolatriceUno.saluta();
        int risultato; // dichiaro una variabile
        risultato = calcolatriceUno.somma(30, 50); // assegno un valore alla variabile perche il metodo somma
                                                   // restituisce un int. passo anche due parametri di tipo int come
                                                   // richiesto dal metodo stesso
        System.out.println("La somma è: " + risultato);

        System.out.println("------------------------------------------------");
    }
}

class Libro {
    String titolo;
    String autore;
    float prezzo;
    static int codice_numerico_autoincrementante = 0;

    Libro(String titolo, String autore, float prezzo) {
        this.titolo = titolo;
        this.autore = autore;
        this.prezzo = prezzo;
        codice_numerico_autoincrementante++;
    }

    void mostraDettagli() {
        System.out.println("\nInfo Libro\nTitolo: " + titolo + "\nAutore: " + autore + "\nPrezzo: " + prezzo + " euro");
    }

}

class Persona { // creo classe Persona
    String nome; // decido le variabili
    int eta;
    String citta;

    Persona() { // costruttore vuoto
    };

    Persona(String nome, int eta, String citta) { // creo il costruttore con i dati che mi servono per creare oggetti
                                                  // Persona
        this.nome = nome;
        this.eta = eta;
        this.citta = citta;
    }

    void mostraDettagli() { // metodo per stampare le info degli oggetti creati
        System.out.println("\nNome: " + nome + "\neta: " + eta + "\ncitta: " + citta);
    }
}

class Calcolatrice { // classe calcolatrice creata

    int somma(int a, int b) { // metodo con ritorno
        return a + b;
    }

    void saluta() { // metodo senza ritorno -> void
        System.out.println("Ciao");
    }
}