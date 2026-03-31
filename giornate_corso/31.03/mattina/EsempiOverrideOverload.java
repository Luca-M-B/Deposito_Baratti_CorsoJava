public class EsempiOverrideOverload {
    public static void main(String[] args) {

        Studente s1 = new Studente("Pippo", 22);
        System.out.println(s1); // chiama automaticamente il toString

        // -----------------------------------------------

        Calcolatrice calc1 = new Calcolatrice();

        System.out.println(calc1.somma(1, 4));
        System.out.println(calc1.somma(1, 4, 8));
        System.out.println(calc1.somma(1, 4, 8, 2));

    }
}

class Studente {
    private String nome;
    private int eta;

    public Studente(String nome, int eta) {
        this.nome = nome;
        this.eta = eta;
    }

    @Override
    public String toString() {
        return "Studente: " + nome + ", Eta: " + eta;
    }

}

class Calcolatrice {

    public int somma(int a, int b) {
        return a + b;
    }

    public int somma(int a, int b, int c) {
        return a + b + c;
    }

    public int somma(int a, int b, int c, int d) {
        return a + b + c + d;
    }
}