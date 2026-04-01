public class ProvaOggetti {

    /*
     * class NomeClasse {
     * tipoDato nomeAttributo; // variabili o attributi
     * }
     * 
     * tipoRitorno nomeMetodo() { // metodi o funzioni
     * // codice
     * }
     */

    // NomeClasse nomeOggetto = new NomeClasse();

    static class Auto {
        String marca;
        int anno;
        double prezzo;

        void mostraInfo() {
            System.out.println(marca + " - " + anno + " - euro" + prezzo);
        }
    }

    public static void main(String[] args) {

        Auto miaAuto = new Auto(); // creazione oggetto con nome miaAuto e classe Auto
        miaAuto.marca = "Tesla"; // qui assegno i valori
        miaAuto.anno = 2023;
        miaAuto.prezzo = 59999.99;

        miaAuto.mostraInfo(); // chiamo il metodo mostraInfo. Questo metodo ha una stampa che mostra i
                              // parametri degli oggetti che vengono istanziati

        System.out.println("--------------------------------------------------------------------------");

        Studente nuovoStudente = new Studente("Luca");
        System.out.println(nuovoStudente);
    }

}

class Studente {
    String nome; // variabile di istanza
    static int totaleStudenti = 0; // variabile statica: ogni volta che viene creato un oggetto Studente aumenta di
                                   // 1.

    Studente(String nome) { // questo è il costruttore che richiede una stringa per creare un oggetto
                            // Studente altrimenti non è possibile creare oggetti da questa classe
        this.nome = nome;
        totaleStudenti++; // incremento per ogni nuovo oggetto creato a partire da questa classe
    }
}