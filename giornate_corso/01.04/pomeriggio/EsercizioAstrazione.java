import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EsercizioAstrazione {

    public static void main(String[] args) {

        ConsegnaManager manager = new ConsegnaManager();

        Scanner scannerInt = new Scanner(System.in);
        Scanner scannerString = new Scanner(System.in);

        int scelta;

        do {
            System.out.println("\n\tMENU");
            System.out.println("1. Aggiungi Furgone");
            System.out.println("2. Aggiungi Drone");
            System.out.println("3. Effettua consegne");
            System.out.println("4. Traccia consegne");
            System.out.println("5. Esci");
            System.out.print("Scelta: ");

            scelta = scannerInt.nextInt();

            switch (scelta) {

                case 1:
                    System.out.print("Inserisci targa: ");
                    String targaFurgone = scannerString.nextLine();

                    System.out.print("Inserisci carico massimo: ");
                    float caricoFurgone = scannerInt.nextFloat();

                    manager.aggiungiVeicolo(new Furgone(targaFurgone, caricoFurgone));
                    System.out.println("Furgone aggiunto.");
                    break;

                case 2:
                    System.out.print("Inserisci codice drone: ");
                    String targaDrone = scannerString.nextLine();

                    System.out.print("Inserisci carico massimo: ");
                    float caricoDrone = scannerInt.nextFloat();

                    manager.aggiungiVeicolo(new Drone(targaDrone, caricoDrone));
                    System.out.println("Drone aggiunto.");
                    break;

                case 3:
                    System.out.print("Inserisci destinazione: ");
                    String destinazione = scannerString.nextLine();

                    System.out.print("Inserisci peso pacco: ");
                    float peso = scannerInt.nextFloat();

                    for (VeicoloConsegna veicolo : manager.getVeicoli()) {
                        veicolo.consegnaPacco(destinazione, peso);
                    }
                    break;

                case 4:
                    System.out.print("Inserisci codice tracking: ");
                    String codice = scannerString.nextLine();

                    for (VeicoloConsegna veicolo : manager.getVeicoli()) {
                        veicolo.tracciaConsegna(codice);
                    }

                    break;

                case 5:
                    System.out.println("Uscita");
                    break;

                default:
                    System.out.println("Scelta non valida");
            }

        } while (scelta != 5);

        scannerInt.close();
        scannerString.close();

    }
}

abstract class VeicoloConsegna implements Tracciabile {

    protected String targa;
    protected float caricoMassimo;

    public VeicoloConsegna(String targa, float caricoMassimo) {
        this.targa = targa;
        this.caricoMassimo = caricoMassimo;
    }

    public abstract void consegnaPacco(String destinazione, float peso);

    public void stampaInfo() {
        System.out.println("Targa: " + targa + ", Carico massimo: " + caricoMassimo);
    }
}

interface Tracciabile {
    void tracciaConsegna(String codiceTracking);
}

class Furgone extends VeicoloConsegna {

    public Furgone(String targa, float caricoMassimo) {
        super(targa, caricoMassimo);
    }

    @Override
    public void consegnaPacco(String destinazione, float peso) {
        if (peso > caricoMassimo) {
            System.out.println("Carico troppo pesante per il furgone.");
            return;
        }
        System.out.println("Furgone " + targa + " sta consegnando su strada verso " + destinazione);
    }

    @Override
    public void tracciaConsegna(String codiceTracking) {
        System.out.println("Tracking furgone: codice " + codiceTracking);
    }
}

class Drone extends VeicoloConsegna {

    public Drone(String targa, float caricoMassimo) {
        super(targa, caricoMassimo);
    }

    @Override
    public void consegnaPacco(String destinazione, float peso) {
        if (peso > caricoMassimo) {
            System.out.println("Carico troppo pesante per il drone.");
            return;
        }
        System.out.println("Drone " + targa + " sta volando verso " + destinazione);
        this.tracciaConsegna(destinazione);
    }

    @Override
    public void tracciaConsegna(String codiceTracking) {
        System.out.println("Tracking drone automatico: codice " + codiceTracking);
    }
}

class ConsegnaManager {

    private List<VeicoloConsegna> veicoli;

    public ConsegnaManager() {
        veicoli = new ArrayList<>();
    }

    public void aggiungiVeicolo(VeicoloConsegna v) {
        veicoli.add(v);
    }

    public List<VeicoloConsegna> getVeicoli() {
        return veicoli;
    }
}