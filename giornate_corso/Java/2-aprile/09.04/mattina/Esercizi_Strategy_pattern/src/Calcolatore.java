public class Calcolatore {

    private Operazione operazione;

    public Calcolatore(Operazione operazione) {
        this.operazione = operazione;
    }

    public int calcola(int a, int b) {
        return operazione.esegui(a, b);
    }

    public void setOperazione(Operazione operazione) {
        this.operazione = operazione;
    }

    /*
     * SVOLGIMENTO CON UN ENUMERATORE
     * private TipoOperazione tipoOperazione;
     * 
     * public Calcolatore(TipoOperazione tipoOperazione) {
     * this.tipoOperazione = tipoOperazione;
     * }
     * 
     * public void setTipoOperazione(TipoOperazione tipoOperazione) {
     * this.tipoOperazione = tipoOperazione;
     * }
     * 
     * public int calcola(int a, int b) {
     * switch(tipoOperazione) {
     * case SOMMA:
     * return a + b;
     * case PRODOTTO:
     * return a * b;
     * }
     * }
     */
}
