import java.util.Scanner;

public class EsercizioGestioneVoti {

    public static double calcolaMedia(int[] voti, int numeroVoti) { // metodo per calcolare la media
        int somma = 0; // parto da 0
        for (int i = 0; i < numeroVoti; i++) { // itero sulla lunghezza dell'array e sommo il valore di ogni indice
            somma += voti[i];
        }
        return (double) somma / numeroVoti; // calcolo matematico della media
    }

    public static int trovaPiuAlto(int[] voti, int numeroVoti) { // metodo per trovare il voto piu alto
        int piuAlto = voti[0];
        for (int i = 1; i < numeroVoti; i++) {
            if (voti[i] > piuAlto) { // itero array e se il valore che trovo è piu alto lo prendo
                piuAlto = voti[i];
            }
        }
        return piuAlto;
    }

    public static int trovaPiuBasso(int[] voti, int numeroVoti) {
        int piuBasso = voti[0];
        for (int i = 1; i < numeroVoti; i++) { // stessa logica del valore piu alto ma con controllo inverso
            if (voti[i] < piuBasso) {
                piuBasso = voti[i];
            }
        }
        return piuBasso;
    }

    public static void verificaPromozione(double media) { // verificare promozione in base al valore della media
        if (media >= 6) {
            System.out.println("Promosso");
        } else {
            System.out.println("Bocciato");
        }
    }

    public static boolean insegnante(String nome, boolean si) {
        boolean check = true;
        if (!nome.equalsIgnoreCase("insegnante")) {
            check = false;
        }

        return check;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Scanner checkInsegnante = new Scanner(System.in);

        System.out.println("Sei un insegnante, uno studente o un genitore?"); // chiedo la propria mansione
        String mansione = checkInsegnante.nextLine();

        boolean accesso = insegnante(mansione, true); // dichiaro e inizializzo una variabile boolean passando
                                                      // direttamente la stringa catturata dallo scanner

        if (accesso) { // se la variabile è true eseguo il codice

            System.out.println("Quanti voti si vogliono inserire?");
            int numeroVoti = input.nextInt(); // prendo input per numero di voti che verranno inseriti

            int[] voti = new int[numeroVoti]; // dichiaro un array con il nuvmero di voti

            for (int i = 0; i < numeroVoti; i++) { // inserisco i voti nell'array
                System.out.print("Voto da inserire: ");
                voti[i] = input.nextInt(); // aggiungo i voti all'indice i per tutta la lunghezza dell'array
            }

            int scelta;

            do { // do per visualizzare il menu
                System.out.println("\n\tMENU");
                System.out.println(
                        "1 - Calcola media\n2 - Mostra voto più alto\n3 - Mostra voto più basso\n4 - Verifica promozione\n5 - Esci");

                System.out.print("Scelta: ");
                scelta = input.nextInt(); // catturo la scelta dell'utente

                switch (scelta) {

                    case 1:
                        double media = calcolaMedia(voti, numeroVoti); // chiamo il metodo per la media e gli passo
                                                                       // l'array
                                                                       // dove ho inserito i voti e il numero dei voti
                                                                       // per
                                                                       // calcolare la media
                        System.out.println("Media: " + media);
                        break;

                    case 2:
                        System.out.println("Voto piu alto: " + trovaPiuAlto(voti, numeroVoti)); // stessa logica della
                                                                                                // media
                        break;

                    case 3:
                        System.out.println("Voto piu basso: " + trovaPiuBasso(voti, numeroVoti)); // stessa logica della
                                                                                                  // media
                        break;

                    case 4:
                        // avrei potuto dichiarare la variabile media fuori da questo switch e
                        // utilizzarla per il case 1 e case 4 indistintamente
                        double mediaCalcolata = calcolaMedia(voti, numeroVoti); // chiamo calcolaMedia
                        verificaPromozione(mediaCalcolata); // passo la media calcolata a verificaPromozione
                        break;

                    case 5:
                        System.out.println("Uscita dal programma");
                        break;

                    default:
                        System.out.println("Scelta non valida");
                }

            } while (scelta != 5); // mostro il menu finche la scelta non è 5

        } else { // se la variabile restituita è false esco senza mostrare il menu
            System.out.println("Impossibile inserire voti.");
        }

        input.close();
        checkInsegnante.close();
    }
}