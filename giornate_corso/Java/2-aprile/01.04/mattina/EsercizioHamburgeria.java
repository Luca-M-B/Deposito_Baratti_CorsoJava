import java.util.*;

class Cibo {

    protected String nome;
    protected int quantita;

    public Cibo(String nome, int quantita) {
        this.nome = nome;
        this.quantita = quantita;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantita() {
        return quantita;
    }

    public void prepara() {
        System.out.println("Preparazione cibo: ");
    }

}

class Hamburger extends Cibo {

    public Hamburger(String nome, int quantita) {
        super(nome, quantita);
    }

    @Override
    public void prepara() {
        System.out.println("Preparazione Hamburger: pane, carne, ketchup");
    }
}

class Cheeseburger extends Hamburger {

    public Cheeseburger(int quantita) {
        super("Cheeseburger", quantita);
    }

    @Override
    public void prepara() {
        System.out.println("Preparazione Hamburger: pane, carne, ketchup, formaggio");
    }
}

class VegBurger extends Hamburger {
    public VegBurger(int quantita) {
        super("VegBurger", quantita);
    }

    @Override
    public void prepara() {
        System.out.println("Preparazione VegBurger: pane integrale, burger vegetale, insalata, pomodoro");
    }
}

class DoubleBacon extends Hamburger {
    public DoubleBacon(int quantita) {
        super("DoubleBacon", quantita);
    }

    @Override
    public void prepara() {
        System.out.println("Preparazione DoubleBacon: pane, doppia carne, bacon, cheddar, maionese");
    }
}

class Dessert extends Cibo {

    public Dessert(String nome, int quantita) {
        super(nome, quantita);
    }

    @Override
    public void prepara() {
        System.out.println("Preparazione dessert generico");
    }
}

class Milkshake extends Dessert {

    public Milkshake(int quantita) {
        super("Milkshake", quantita);
    }

    @Override
    public void prepara() {
        System.out.println("Preparazione Milkshake.");
    }
}

class TortaCioccolato extends Dessert {

    public TortaCioccolato(int quantita) {
        super("Torta al Cioccolato", quantita);
    }

    @Override
    public void prepara() {
        System.out.println("Preparazione Torta al Cioccolato.");
    }
}

class Cucina {

    public static void preparaOrdine(Cibo cibo) {
        for (int i = 0; i < cibo.getQuantita(); i++) {
            cibo.prepara();
        }
    }
}

public class EsercizioHamburgeria {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Cibo> ordini = new ArrayList<>();

        int sceltaUtente;
        boolean prepara = false;

        do {
            System.out.println("\n\tMENU HAMBURGERIA");
            System.out.println("1. Cheeseburger");
            System.out.println("2. VegBurger");
            System.out.println("3. DoubleBacon");
            System.out.println("4. Milkshake");
            System.out.println("5. Torta al Cioccolato");
            System.out.println("6. Termina ordine");
            System.out.println("7. Esci");
            System.out.print("Scelta: ");

            sceltaUtente = scanner.nextInt();

            Cibo cibo = null;

            if (sceltaUtente >= 1 && sceltaUtente <= 5) {

                System.out.print("Inserisci quantità: ");
                int quantita = scanner.nextInt();

                switch (sceltaUtente) {
                    case 1:
                        cibo = new Cheeseburger(quantita);
                        break;
                    case 2:
                        cibo = new VegBurger(quantita);
                        break;
                    case 3:
                        cibo = new DoubleBacon(quantita);
                        break;
                    case 4:
                        cibo = new Milkshake(quantita);
                        break;
                    case 5:
                        cibo = new TortaCioccolato(quantita);
                        break;
                }

                ordini.add(cibo);
                System.out.println(cibo.getNome() + " x" + cibo.getQuantita() + " aggiunto all'ordine");

            } else if (sceltaUtente == 6) {
                prepara = true; // valorizzo per permettere la preparazione dopo lo switch
            } else if (sceltaUtente == 7) {
                System.out.println("\nOperazione conclusa");
            } else {
                System.out.println("Scelta non valida");
            }

        } while (sceltaUtente != 6 && sceltaUtente != 7);

        if (prepara) {
            System.out.println("\n\tORDINI PREPARATI");

            for (Cibo ciboPreparato : ordini) {
                Cucina.preparaOrdine(ciboPreparato);
            }
        }

        scanner.close();
    }
}