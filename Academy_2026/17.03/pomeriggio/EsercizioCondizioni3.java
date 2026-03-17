import java.util.Scanner;

public class EsercizioCondizioni3 {
    public static void main(String[] args) {

        // scanner importo spesa
        Scanner scannerImporto = new Scanner(System.in);
        System.out.println("Inserire totale spesa:");
        double totaleSpesa = scannerImporto.nextDouble();

        // scanner codice sconto
        Scanner scannerSconto = new Scanner(System.in);
        System.out.println("Inserire codice sconto:");
        String codiceSconto = scannerSconto.nextLine();

        // controllicondice sconto e calcolo nuovo totale spesa
        if (codiceSconto.equals("SCONTO10")) {
            System.out.println("Totale spesa: " + totaleSpesa * (1 - 0.10));
        } else if (codiceSconto.equals("SCONTO20")) {
            System.out.println("Totale spesa: " + totaleSpesa * (1 - 0.20));
        } else if (codiceSconto.equals("VIP")) {
            System.out.println("Totale spesa: " + totaleSpesa * (1 - 0.30));
        } else {
            System.out.println("Codice sconto non valido. Totale spesa: " + totaleSpesa);
        }

        // chiusura scanner
        scannerImporto.close();
        scannerSconto.close();
    }

}
