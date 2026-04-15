package facade;

import computer.*;
import decorator.*;
import strategy.pagamento.*;
import strategy.spedizione.*;

public class SistemaOrdineFacade {

    private Computer computer;
    private StrategiaPagamento pagamento;
    private StrategiaSpedizione spedizione;

    // BASE
    public void creaComputerBase(int scelta) {
        computer = (scelta == 1) ? new ComputerBaseUfficio() : new ComputerBaseGaming();
        System.out.println("Configurazione base selezionata.");
    }

    // EXTRA
    public void aggiungiExtra(int scelta) {
        if (computer == null) {
            System.out.println("Prima devi scegliere una configurazione base.");
            return;
        }

        switch (scelta) {
            case 1:
                computer = new RamExtra(computer);
                break;
            case 2:
                computer = new SsdExtra(computer);
                break;
            case 3:
                computer = new SchedaVideoExtra(computer);
                break;
            case 4:
                computer = new RaffreddamentoExtra(computer);
                break;
        }

        System.out.println("Extra aggiunto.");
    }

    // SPEDIZIONE
    public void scegliSpedizione(int scelta) {
        if (computer == null) {
            System.out.println("Configura prima il computer.");
            return;
        }

        switch (scelta) {
            case 1:
                spedizione = new SpedizioneStandard();
                break;
            case 2:
                spedizione = new SpedizioneEspressa();
                break;
            case 3:
                spedizione = new RitiroNegozio();
                break;
        }

        System.out.println("Spedizione selezionata.");
    }

    // PAGAMENTO
    public void scegliPagamento(int scelta) {
        if (spedizione == null) {
            System.out.println("Prima devi scegliere la spedizione.");
            return;
        }

        switch (scelta) {
            case 1:
                pagamento = new PagamentoCarta();
                break;
            case 2:
                pagamento = new PagamentoPaypal();
                break;
            case 3:
                pagamento = new PagamentoBonifico();
                break;
        }

        System.out.println("Metodo di pagamento selezionato.");
    }

    // RIEPILOGO
    public void mostraRiepilogo() {
        System.out.println("\nRIEPILOGO");

        if (computer == null) {
            System.out.println("Nessuna configurazione.");
            return;
        }

        System.out.println("Configurazione: " + computer.getDescrizione());
        System.out.println("Prezzo: " + computer.getPrezzo() + " euro");

        if (spedizione != null) {
            System.out.println("Spedizione: " + spedizione.getClass().getSimpleName());
        } else {
            System.out.println("Spedizione: Non selezionata");
        }

        if (pagamento != null) {
            System.out.println("Pagamento: " + pagamento.getClass().getSimpleName());
        } else {
            System.out.println("Pagamento: Non selezionato");
        }
    }

    // CONFERMA
    public void confermaOrdine() {
        if (computer == null || spedizione == null || pagamento == null) {
            System.out.println("Completa tutti i passaggi prima di confermare.");
            return;
        }

        System.out.println("\nCONFERMA ORDINE");
        pagamento.eseguiPagamento(computer.getPrezzo());
        spedizione.eseguiSpedizione();

        System.out.println("Ordine completato!");
    }
}