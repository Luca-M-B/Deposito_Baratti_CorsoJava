class Persona {
    protected String nome;

    Persona(String nome) {
        this.nome = nome;
    }

    public void Saluta() {
        System.out.println("Ciao, sono " + nome);
    }
}

class Pirata extends Persona {

    Pirata(String nome) {
        super(nome);
    }

    public void Saluta() {
        System.out.println("Ciao, sono " + nome + " e sono un pirata!");
    }
}

class GestorePersona {

    public void faiSalutare(Persona persona) {
        persona.Saluta();
    }
}

public class EsercizioPolimorfismo {

    public static void main(String[] args) {

        Persona persona1 = new Persona("Pippo");
        Persona persona2 = new Persona("Gino");

        persona1.Saluta();
        persona2.Saluta();

        Pirata pirata1 = new Pirata("Barbanera");

        pirata1.Saluta();

        GestorePersona gestore = new GestorePersona();

        gestore.faiSalutare(persona1);
        gestore.faiSalutare(persona2);
        gestore.faiSalutare(pirata1);

    }
}
