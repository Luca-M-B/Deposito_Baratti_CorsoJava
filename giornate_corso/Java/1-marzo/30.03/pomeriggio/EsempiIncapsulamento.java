
class Persona {

    private String nome;

    private int eta;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    private boolean verificaMaggiorenne() { // metodo privato
        return this.eta >= 18;
    }

    public void stampaStatus() { // metodo pubblico che usa il metodo privato
        if (verificaMaggiorenne()) {
            System.out.println(this.nome + " è maggiorenne.");
        } else {
            System.out.println(this.nome + " non è maggiorenne.");
        }
    }
}

public class EsempiIncapsulamento {

    public static void main(String[] args) {

        Persona miaPersona = new Persona();

        miaPersona.setNome("Pippo");

        System.out.println(miaPersona.getNome());

        miaPersona.stampaStatus();
    }
}
