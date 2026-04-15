import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PagamentoContext context = new PagamentoContext();

        System.out.println("Scegli metodo di pagamento:");
        System.out.println("1 = Carta di Credito");
        System.out.println("2 = PayPal");
        System.out.print("Scelta: ");

        int scelta = scanner.nextInt();
        scanner.nextLine();

        switch (scelta) {

            case 1:
                System.out.print("Inserisci numero carta: ");
                String numeroCarta = scanner.nextLine();
                context.setMetodoPagamento(new CartaDiCredito(numeroCarta));
                break;

            case 2:
                System.out.print("Inserisci il numero del conto PayPal: ");
                String numeroConto = scanner.nextLine();
                context.setMetodoPagamento(new PayPal(numeroConto));
                break;

            default:
                System.out.println("Scelta non valida");
                return;
        }

        System.out.print("Inserisci importo: ");
        double importo = scanner.nextDouble();

        context.eseguiPagamento(importo);

    }
}