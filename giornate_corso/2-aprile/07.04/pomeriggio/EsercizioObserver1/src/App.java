public class App {

    public static void main(String[] args) {

        StazioneMeteo stazione = new StazioneMeteo();

        DisplayConsole console = new DisplayConsole();
        DisplayConsole console2 = new DisplayConsole();
        DisplayMobile mobile = new DisplayMobile();
        DisplayMobile mobile2 = new DisplayMobile();

        stazione.aggiungiDisplay(console);
        stazione.aggiungiDisplay(console2);
        stazione.aggiungiDisplay(mobile);
        stazione.aggiungiDisplay(mobile2);

        stazione.setTemperatura(15); // tutti i display ricevono il cambio di temperatura

        // stazione.rimuoviDisplay(console); // metodo per rimuovere un diplay

    }

}
