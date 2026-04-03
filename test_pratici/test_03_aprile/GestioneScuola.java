import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Persona { // classe astratta da specializzare nelle sotto classi

    private String nome; // attributi privati
    private int eta;

    public Persona(String nome, int eta) { // costruttore
        this.nome = nome;
        this.eta = eta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public abstract void descriviRuolo(); // metodo astratto da implementare nelle sotto classi
}

interface Registrabile { // interfaccia
    void registrazione(); // metodo che ogni classe deve implementare
}

class Studente extends Persona implements Registrabile { // studente estende persona e implementa registrabile

    private String classeFrequentata;
    private List<Integer> voti; // lista voti dello studente

    public Studente(String nome, int eta, String classeFrequentata) {
        super(nome, eta);
        this.classeFrequentata = classeFrequentata;
        this.voti = new ArrayList<>();
    }

    public String getClasseFrequentata() {
        return classeFrequentata;
    }

    public void setClasseFrequentata(String classeFrequentata) {
        this.classeFrequentata = classeFrequentata;
    }

    public void aggiungiVoto(int voto) {
        voti.add(voto);
    }

    public void stampaVoti() {
        System.out.println("Voti dello studente " + getNome() + ": " + voti);
    }

    @Override
    public void descriviRuolo() { // override metodo
        System.out.println("Sono uno studente della classe " + classeFrequentata);
    }

    @Override
    public void registrazione() { // implementazione metodo interfaccia
        System.out.println("Registrazione tramite modulo online");
    }
}

class Docente extends Persona implements Registrabile { // docente estende persona e implementa registrabile

    private String materia;
    private List<Studente> studentiMateria; // lista studenti associati al docente

    public Docente(String nome, int eta, String materia) {
        super(nome, eta);
        this.materia = materia;
        this.studentiMateria = new ArrayList<>();
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public void aggiungiStudente(Studente studente) {
        if (!studentiMateria.contains(studente)) { // controllo per non avere studenti duplicati
            studentiMateria.add(studente);
        }
    }

    public void assegnaVoto(Studente studente, int voto) { // assegna voto solo se lo studente è nella lista del docente
        if (studentiMateria.contains(studente)) {
            studente.aggiungiVoto(voto);
        } else {
            System.out.println("Studente non assegnato a questo docente");
        }
    }

    public void stampaStudenti() { // stampa elenco studenti del docente
        System.out.println("Studenti del docente " + getNome() + ":");
        for (Studente s : studentiMateria) {
            System.out.println("- " + s.getNome());
        }
    }

    @Override
    public void descriviRuolo() {
        System.out.println("Sono un docente di " + materia);
    }

    @Override
    public void registrazione() {
        System.out.println("Registrazione tramite segreteria didattica");
    }
}

class StudenteBase extends Studente { // studente che frequenta solo la scuola

    public StudenteBase(String nome, int eta, String classeFrequentata) {
        super(nome, eta, classeFrequentata);
    }

    @Override
    public void descriviRuolo() {
        System.out.println("Sono uno studente base della classe " + getClasseFrequentata());
    }
}

class StudenteExtra extends Studente { // studente che frequenta almeno un corso extra scolastico

    private List<String> corsiExtra; // lista corsi frequentati

    public StudenteExtra(String nome, int eta, String classeFrequentata) {
        super(nome, eta, classeFrequentata);
        this.corsiExtra = new ArrayList<>();
    }

    public void aggiungiCorso(String corso) {
        corsiExtra.add(corso);
    }

    public void stampaCorsiExtra() {
        System.out.println("Corsi extra: " + corsiExtra);
    }

    @Override
    public void descriviRuolo() {
        System.out.println("Sono uno studente della classe "
                + getClasseFrequentata() + " e frequento anche corsi extra");
    }
}

class DocenteBase extends Docente { // docente che insegna solo a scuola

    public DocenteBase(String nome, int eta, String materia) {
        super(nome, eta, materia);
    }

    @Override
    public void descriviRuolo() {
        System.out.println("Sono un docente base di " + getMateria());
    }
}

class DocenteExtra extends Docente { // docente che insegna almeno in un corso extra scolastico

    private List<String> corsiExtra; // lista corsi extra tenuti

    public DocenteExtra(String nome, int eta, String materia) {
        super(nome, eta, materia);
        this.corsiExtra = new ArrayList<>();
    }

    public void aggiungiCorso(String corso) {
        corsiExtra.add(corso);
    }

    public void stampaCorsiExtra() {
        System.out.println("Corsi extra insegnati: " + corsiExtra);
    }

    @Override
    public void descriviRuolo() {
        System.out.println("Sono un docente che insegna " + getMateria()
                + " ed anche corsi extra");
    }
}

public class GestioneScuola {

    public static void main(String[] args) {

        Scanner scannerString = new Scanner(System.in); // due scanner per i diversi input dell'utente
        Scanner scannerInt = new Scanner(System.in);

        ArrayList<Studente> studenti = new ArrayList<>(); // liste principali di studenti e docenti
        ArrayList<Docente> docenti = new ArrayList<>();

        int scelta;

        do {
            System.out.println("\n\tREGISTRO ELETTRONICO");
            System.out.println("1. Crea Studente");
            System.out.println("2. Crea Docente");
            System.out.println("3. Assegna voto");
            System.out.println("4. Stampa voti");
            System.out.println("5. Esci");

            scelta = scannerInt.nextInt();

            switch (scelta) {

                case 1:
                    System.out.println("Nome studente:");
                    String nomeNuovoStudente = scannerString.nextLine();

                    System.out.println("Età:");
                    int etaNuovoStudente = scannerInt.nextInt();

                    System.out.println("Classe frequentata:");
                    String classeNuovoStudente = scannerString.nextLine();

                    System.out.println("Frequenta corsi extra? (1 = si, 2 = no)");
                    scelta = scannerInt.nextInt();

                    if (scelta == 1) { // se frequenta corsi extra creo StudenteExtra
                        StudenteExtra studExtra = new StudenteExtra(nomeNuovoStudente, etaNuovoStudente,
                                classeNuovoStudente);

                        System.out.println("Quanti corsi extra?");
                        int numeroCorsi = scannerInt.nextInt();

                        for (int i = 0; i < numeroCorsi; i++) { // in base all'input chiedo il nome n volte
                            System.out.println("Nome corso:");
                            String corso = scannerString.nextLine();
                            studExtra.aggiungiCorso(corso);
                        }

                        studenti.add(studExtra); // aggiungo alla lista
                        studExtra.registrazione(); // chiamo il metodo dell'interfaccia

                    } else { // altrimenti StudenteBase
                        StudenteBase studenteBase = new StudenteBase(nomeNuovoStudente, etaNuovoStudente,
                                classeNuovoStudente);
                        studenti.add(studenteBase); // aggiungo alla lista
                        studenteBase.registrazione(); // chiamo il metodo interfaccia
                    }

                    System.out.println("Studente creato con successo");
                    break;

                case 2:
                    System.out.println("Nome docente:");
                    String nomeNuovoDocente = scannerString.nextLine();

                    System.out.println("Età:");
                    int etaNuovoDocente = scannerInt.nextInt();

                    System.out.println("Materia:");
                    String materiaNuovoDocente = scannerString.nextLine();

                    System.out.println("Tiene corsi extra? (1 = sì, 2 = no)");
                    scelta = scannerInt.nextInt();

                    if (scelta == 1) { // se docenteExtra
                        DocenteExtra docenteExtra = new DocenteExtra(nomeNuovoDocente, etaNuovoDocente,
                                materiaNuovoDocente);

                        System.out.println("Quanti corsi extra?");
                        int numeroCorsi = scannerInt.nextInt();

                        for (int i = 0; i < numeroCorsi; i++) { // in base all'input chiedo x volte il nome del corso
                            System.out.println("Nome corso:");
                            String corso = scannerString.nextLine();
                            docenteExtra.aggiungiCorso(corso);
                        }

                        docenti.add(docenteExtra); // aggiungo alla lista
                        docenteExtra.registrazione(); // metodo interfaccia

                    } else { // se DocenteBase
                        DocenteBase docenteBase = new DocenteBase(nomeNuovoDocente, etaNuovoDocente,
                                materiaNuovoDocente);
                        docenti.add(docenteBase); // aggiungo
                        docenteBase.registrazione(); // metodo interfaccia
                    }

                    System.out.println("Docente creato con successo");
                    break;

                case 3:

                    if (docenti.isEmpty() || studenti.isEmpty()) { // mi assicuro che si siano almeno uno studente ed un
                                                                   // docente
                        System.out.println("Servono almeno un docente e uno studente per assegnare voti");
                        return;
                    }

                    System.out.println("Seleziona docente:");
                    for (int i = 0; i < docenti.size(); i++) {
                        System.out.println((i + 1) + " - " + docenti.get(i).getNome());
                    }

                    int indexDocente = scannerInt.nextInt();

                    if (indexDocente < 1 || indexDocente > docenti.size()) { // controllo input se valido
                        System.out.println("Scelta non valida");
                        return;
                    }

                    Docente docente = docenti.get(indexDocente - 1);

                    System.out.println("Seleziona studente:");
                    for (int i = 0; i < studenti.size(); i++) {
                        System.out.println((i + 1) + " - " + studenti.get(i).getNome());
                    }

                    int indexStudente = scannerInt.nextInt();

                    if (indexStudente < 1 || indexStudente > studenti.size()) { // controllo input se valido
                        System.out.println("Scelta non valida");
                        return;
                    }

                    Studente studente = studenti.get(indexStudente - 1);

                    docente.aggiungiStudente(studente); // assegnazione studente al docente

                    System.out.println("Inserisci voto:");
                    int voto = scannerInt.nextInt();

                    docente.assegnaVoto(studente, voto);

                    System.out.println("Voto assegnato");
                    break;

                case 4:

                    if (studenti.isEmpty()) { // mi assicuro ci siano studenti
                        System.out.println("Nessuno studente presente");
                        return;
                    }

                    System.out.println("Seleziona studente:");
                    for (int i = 0; i < studenti.size(); i++) {
                        System.out.println((i + 1) + " - " + studenti.get(i).getNome());
                    }

                    int index = scannerInt.nextInt();

                    if (index < 1 || index > studenti.size()) { // controllo input valido
                        System.out.println("Scelta non valida");
                        return;
                    }

                    studenti.get(index - 1).stampaVoti();
                    break;

                case 5:
                    System.out.println("Chiusura Registro Elettronico");
                    break;

                default:
                    System.out.println("Scelta non valida");
            }

        } while (scelta != 0);

        scannerInt.close();
        scannerString.close();
    }
}