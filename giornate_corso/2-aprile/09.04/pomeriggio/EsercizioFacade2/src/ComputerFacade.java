public class ComputerFacade {

    private Bios bios;
    private HardDisk hardDisk;
    private SistemaOperativo sistemaOperativo;

    public ComputerFacade() {
        this.bios = new Bios();
        this.hardDisk = new HardDisk();
        this.sistemaOperativo = new SistemaOperativo();
    }

    public void accendiComputer() {
        System.out.println("accensione del computer\n");

        bios.inizializza();
        hardDisk.inizializza();
        sistemaOperativo.inizializza();

        System.out.println("\ninizializzazione terminata");
        System.out.println("inizio caricamento\n");

        bios.carica();
        hardDisk.carica();
        sistemaOperativo.carica();

        System.out.println("\ncaricamento terminato");
        System.out.println("avvio in corso\n");

        bios.avvia();
        hardDisk.avvia();
        sistemaOperativo.avvia();

        System.out.println("accensione computer terminata");

    }
}
