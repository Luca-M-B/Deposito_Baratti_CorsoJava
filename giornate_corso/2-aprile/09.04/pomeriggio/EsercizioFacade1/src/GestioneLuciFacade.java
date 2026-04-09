class GestioneLuciFacade {

    private LuceCamera luceCamera;
    private LuceCucina luceCucina;

    public GestioneLuciFacade() {
        this.luceCamera = new LuceCamera();
        this.luceCucina = new LuceCucina();
    }

    public void accendiTutte() {// Metodo semplificato che accende tutte le luci
        System.out.println("Accensione di tutte le luci.");

        luceCamera.accendi();
        luceCucina.accendi();
    }
}