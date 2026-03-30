import java.util.ArrayList;
import java.util.Scanner;

public class Esercizio1 {

    public static class BankAccount {

        String accountHolderName;
        double balance;

        BankAccount() {
        }

        BankAccount(String accountHolderName, double initialBalance) { // costruttore parametrico
            this.accountHolderName = accountHolderName;
            this.balance = initialBalance;
        }

        public void deposito(double amount) { // metodo per il deposito
            if (amount > 0) { // se valore maggiore di zero
                balance = balance + amount;
                System.out.println("\nDeposito effettuato. Nuova disponibilità: " + balance);
            } else {
                System.out.println("\nImporto non valido");
            }
        }

        public void prelievo(double amount) { // metodo prelievo
            if (amount > 0 && amount <= balance) { // se la quantità da prelevare è positiva e se è minore uguale a
                                                   // quanto disponibile
                balance = balance - amount;
                System.out.println("\nEffettuato un prelievo di: " + amount + " euro");
            } else {
                System.out.println("\nFondi insufficienti per effettuare il prelievo o importo non valido");
            }
        }

        public void displayBalance() { // per mostrare il saldo
            System.out.println("\nSaldo disponibile: " + balance + " euro");
        }
    }

    static class Account {

        String username;
        String password;
        ArrayList<BankAccount> conti = new ArrayList<>();

        Account(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public void aggiungiConto(BankAccount conto) {
            conti.add(conto);
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<BankAccount> listaContiBancari = new ArrayList<>(); // arraylist per conti bancari

        boolean continua = true; // variabile per while

        while (continua) {

            // Menu
            System.out.println("\n--- MENU BANCA ---");
            System.out.println("1 - Aggiungi conto");
            System.out.println("2 - Deposito");
            System.out.println("3 - Prelievo");
            System.out.println("4 - Mostra saldo");
            System.out.println("5 - Esci");
            System.out.print("Scelta: ");
            int scelta = scanner.nextInt();
            scanner.nextLine(); // pulizia buffer

            switch (scelta) {

                case 1:
                    // nuovo conto
                    System.out.print("Nome intestatario: ");
                    String nomeIntestatario = scanner.nextLine();

                    System.out.print("Saldo iniziale: ");
                    double saldo = scanner.nextDouble();
                    scanner.nextLine();

                    listaContiBancari.add(new BankAccount(nomeIntestatario, saldo)); // creo l'oggetto direttamente
                                                                                     // all'interno dell'arraylist

                    System.out.println("\nCreato e aggiunto nuovo conto bancario");
                    break;

                case 2:
                    // deposito
                    System.out.print("\nDigitare il nome dell'intestatario: ");
                    String nomeDeposito = scanner.nextLine();

                    boolean trovato = false;

                    for (BankAccount conto : listaContiBancari) { // itero tutti i conti nell'arraylist
                        if (conto.accountHolderName.equalsIgnoreCase(nomeDeposito)) { // cerco corrispondenza tramite il
                                                                                      // nome

                            System.out.print("Importo da depositare: ");
                            double importoDeposito = scanner.nextDouble();
                            scanner.nextLine();

                            conto.deposito(importoDeposito); // chiamo il metodo deposito
                            trovato = true; // modifico variabile a true
                            break;
                        } else {
                            System.out.println("\nConto non trovato");
                            break;
                        }
                    }
                    break;

                case 3:
                    // prelievo
                    System.out.print("\nNome intestatario: ");
                    String nomePrelievo = scanner.nextLine();

                    for (BankAccount conto : listaContiBancari) {
                        if (conto.accountHolderName.equalsIgnoreCase(nomePrelievo)) { // cerco conto tramite nome

                            System.out.print("Importo che si desidera prelevare: ");
                            double importoPrelievo = scanner.nextDouble();
                            scanner.nextLine();

                            conto.prelievo(importoPrelievo); // chiamo il metodo prelievo
                        }
                    }
                    break;

                case 4:
                    // saldo
                    System.out.print("\nNome intestatario: ");
                    String nomeSaldo = scanner.nextLine();

                    for (BankAccount conto : listaContiBancari) {
                        if (conto.accountHolderName.equalsIgnoreCase(nomeSaldo)) { // cerco per nome
                            conto.displayBalance(); // chiamo il metodo per mostrare daldo
                        }
                    }
                    break;

                case 5:
                    continua = false;
                    System.out.println("\nUscita dal programma");
                    break;

                default:
                    System.out.println("\nScelta non valida");
            }
        }

        scanner.close();
    }
}