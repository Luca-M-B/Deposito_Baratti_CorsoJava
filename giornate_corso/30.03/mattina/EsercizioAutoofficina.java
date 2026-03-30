import java.util.ArrayList;
import java.util.Scanner;

public class EsercizioAutoofficina {

    public static class Auto {
        String targa;
        String modello;

        Auto(String targa, String modello) {
            this.targa = targa;
            this.modello = modello;
        }

        public String toString() {
            return "Targa: " + targa + " - Modello: " + modello;
        }
    }

    public static class Officina {
        ArrayList<Auto> listaAuto;

        Officina() {
            listaAuto = new ArrayList<>();
        }

        void aggiungiAuto(Auto a) {
            listaAuto.add(a);
            System.out.println("Auto aggiunta!");
        }

        void stampaAuto() {
            if (listaAuto.size() == 0) {
                System.out.println("Nessuna auto presente.");
                return;
            } else {
                System.out.println("Elenco auto:");
                for (int i = 0; i < listaAuto.size(); i++) {
                    System.out.println(i + " - " + listaAuto.get(i));
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {

        Officina officina = new Officina();

        Scanner scannerString = new Scanner(System.in);
        Scanner scannerInt = new Scanner(System.in);

        int scelta;

        do {
            System.out.println("\n\tMENU OFFICINA");
            System.out.println("1. Aggiungi Auto");
            System.out.println("2. Visualizza Auto");
            System.out.println("3. Esci");
            System.out.print("Scelta: ");

            scelta = scannerInt.nextInt();
            //scannerString.nextLine();

            switch (scelta) {

                case 1:
                    System.out.println("Inserisci targa: ");
                    String targa = scannerString.nextLine();

                    System.out.println("Inserisci modello: ");
                    String modello = scannerString.nextLine();

                    Auto nuovaAuto = new Auto(targa, modello);
                    officina.aggiungiAuto(nuovaAuto);
                    break;

                case 2:
                    officina.stampaAuto();
                    break;

                case 3:
                    System.out.println("Uscita dal programma.");
                    break;

                default:
                    System.out.println("Scelta non valida.");
            }

        } while (scelta != 3);

        scannerString.close();
        scannerInt.close();
    }
}