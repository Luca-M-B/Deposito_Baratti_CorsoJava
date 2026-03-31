import java.util.ArrayList;
import java.util.Scanner;

public class EsercizioZoo {

    public static void main(String[] args) {

        ArrayList<Animale> listaGatti = new ArrayList<>();
        ArrayList<Animale> listaCani = new ArrayList<>();
        /*
         * listaCani.add(new Cane("Pluto", 5));
         * listaCani.add(new Cane("Fido", 3));
         * listaCani.add(new Cane("Rex", 7));
         * listaCani.add(new Cane("Lucky", 2));
         * listaCani.add(new Cane("Buddy", 4));
         * 
         * listaGatti.add(new Gatto("Micio", 2));
         * listaGatti.add(new Gatto("Felix", 6));
         * listaGatti.add(new Gatto("Luna", 1));
         * 
         * for (Animale c : listaCani) { // ciclo cani
         * System.out.println(c.toString());
         * }
         * 
         * for (Animale g : listaGatti) { // ciclo gatti
         * System.out.println(g.toString());
         * }
         */

        int scelta;

        Scanner scannerString = new Scanner(System.in);
        Scanner scannerInt = new Scanner(System.in);

        do {
            System.out.println("\n--- MENU ZOO ---");
            System.out.println("1. Aggiungi Cane");
            System.out.println("2. Aggiungi Gatto");
            System.out.println("3. Stampa lista Cani");
            System.out.println("4. Stampa lista Gatti");
            System.out.println("5. Stampa lista Zoo");
            System.out.println("6. Esci");
            System.out.print("Scelta: ");

            scelta = scannerInt.nextInt();
            scannerInt.nextLine(); // pulizia buffer

            switch (scelta) {

                case 1:
                    System.out.print("Nome cane: ");
                    String nomeCane = scannerString.nextLine();
                    System.out.print("Età cane: ");
                    int etaCane = scannerInt.nextInt();
                    scannerString.nextLine();

                    listaCani.add(new Cane(nomeCane, etaCane));
                    break;

                case 2:
                    System.out.print("Nome gatto: ");
                    String nomeGatto = scannerString.nextLine();
                    System.out.print("Età gatto: ");
                    int etaGatto = scannerInt.nextInt();
                    scannerString.nextLine();

                    listaGatti.add(new Gatto(nomeGatto, etaGatto));
                    break;

                case 3:
                    System.out.println("\n--- LISTA CANI ---");
                    for (Animale c : listaCani) { // ciclo cani
                        System.out.println(c.toString());
                    }
                    break;

                case 4:
                    System.out.println("\n--- LISTA GATTI ---");
                    for (Animale g : listaGatti) { // ciclo gatti
                        System.out.println(g.toString());
                    }
                    break;

                case 5:
                    System.out.println("\n--- LISTA ZOO ---");
                    for (Animale c : listaCani) { // ciclo cani
                        System.out.println(c.toString());
                    }
                    for (Animale g : listaGatti) { // ciclo gatti
                        System.out.println(g.toString());
                    }
                    break;

                case 6:
                    System.out.println("Uscita.");
                    break;

                default:
                    System.out.println("Scelta non valida.");
            }

        } while (scelta != 6);

        scannerString.close();
        scannerInt.close();

    }

}

class Animale {
    protected String nome;
    protected int eta;

    Animale(String nome, int eta) {
        this.nome = nome;
        this.eta = eta;
    }

    public void faiVerso() {
        System.out.println("Verso generico...");
    }

    public String getVerso() {
        return "Verso generico";
    }

    public String toString() {
        return "Nome: " + nome + ", Eta: " + eta + ", Verso: " + getVerso();
    }
}

class Cane extends Animale {

    public Cane(String nome, int eta) {
        super(nome, eta);
    }

    @Override
    public void faiVerso() {
        System.out.println("Bau");
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public String getVerso() {
        return "Bau";
    }

}

class Gatto extends Animale {

    public Gatto(String nome, int eta) {
        super(nome, eta);
    }

    @Override
    public void faiVerso() {
        System.out.println("Miao");
    }

    public String getVerso() {
        return "Miao";
    }
}