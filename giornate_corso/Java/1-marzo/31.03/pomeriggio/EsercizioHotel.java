import java.util.ArrayList;
import java.util.Scanner;

class Camera {
    private int numero;
    private float prezzo;

    public Camera(int numero, float prezzo) {
        this.numero = numero;
        this.prezzo = prezzo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public void dettagli() { // metodo dettagli base
        System.out.println("Camera numero: " + numero + ", prezzo: " + prezzo);
    }

    public void dettagli(boolean conPrezzo) { // overload senza prezzo
        if (conPrezzo) {
            System.out.println("Camera numero: " + numero + ", prezzo: " + prezzo);
        } else {
            System.out.println("Camera numero: " + numero);
        }
    }
}

class Suite extends Camera {
    private String serviziExtra;

    public Suite(int numero, float prezzo, String serviziExtra) {
        super(numero, prezzo);
        this.serviziExtra = serviziExtra;
    }

    public String getServiziExtra() {
        return serviziExtra;
    }

    public void setServiziExtra(String serviziExtra) {
        this.serviziExtra = serviziExtra;
    }

    @Override
    public void dettagli() {
        System.out.println(
                "Suite numero: " + getNumero() + ", prezzo: " + getPrezzo() + ", servizi extra: " + serviziExtra);
    }
}

class Hotel {
    private String nome;
    private ArrayList<Camera> camere;

    public Hotel(String nome) {
        this.nome = nome;
        this.camere = new ArrayList<>();
    }

    public void aggiungiCamera(Camera camera) { // metodo per aggiungere camera
        camere.add(camera);
    }

    public ArrayList<Camera> getCamere() {
        return camere;
    }

    public static int contaSuite(ArrayList<Camera> lista) { // mtodo statico per contare le suite
        int count = 0;

        for (Camera camera : lista) {
            if (camera.getClass() == Suite.class) {
                count++;
            }
        }

        return count;
    }

    public String getNome() {
        return nome;
    }
}

public class EsercizioHotel {
    public static void main(String[] args) {

        /*
         * Hotel hotel = new Hotel("Hotel Luca");
         * 
         * Camera camera1 = new Camera(1, 150);
         * Camera camera2 = new Camera(2, 150);
         * Camera camera3 = new Camera(3, 180);
         * Camera camera4 = new Camera(4, 120);
         * Camera camera5 = new Camera(5, 120);
         * 
         * Suite suite1 = new Suite(1, 500, "solarium");
         * Suite suite2 = new Suite(1, 600, "idromassaggio privato");
         * Suite suite3 = new Suite(1, 800, "idromassaggio privato + sauna");
         * 
         * hotel.aggiungiCamera(camera1);
         * hotel.aggiungiCamera(camera2);
         * hotel.aggiungiCamera(camera3);
         * hotel.aggiungiCamera(camera4);
         * hotel.aggiungiCamera(camera5);
         * hotel.aggiungiCamera(suite1);
         * hotel.aggiungiCamera(suite2);
         * hotel.aggiungiCamera(suite3);
         * 
         * System.out.println("\nDettagli camere: \n");
         * 
         * camera1.dettagli();
         * camera1.dettagli(true);
         * 
         * camera2.dettagli();
         * camera2.dettagli(true);
         * 
         * suite1.dettagli();
         * suite2.dettagli(true); // usa il metodo dettagli(con prezzo) di camera perchè
         * non overridato
         * 
         * int conteggioSuite = hotel.contaSuite(hotel.getCamere());
         * System.out.println("\nNumero totale di suite: " + conteggioSuite);
         */

        Scanner scannerString = new Scanner(System.in);
        Scanner scannerInt = new Scanner(System.in);

        ArrayList<Hotel> listaHotel = new ArrayList<>();
        int scelta;

        do {
            System.out.println("\n\tMENU PRINCIPALE");
            System.out.println("1. Visualizza hotel");
            System.out.println("2. Crea nuovo hotel");
            System.out.println("3. Accedi a un hotel");
            System.out.println("4. Esci");

            scelta = scannerInt.nextInt();

            switch (scelta) {

                case 1:
                    if (listaHotel.isEmpty()) { // se lista vuota
                        System.out.println("Nessun hotel presente.");
                    } else { // se lista non vuota, chiamo il metodo getNome() di hotel per stampare tutti
                             // gli hotel presenti
                        for (Hotel hotel : listaHotel) {
                            System.out.println("- " + hotel.getNome());
                        }
                    }
                    break;

                case 2:
                    System.out.print("Nome hotel: ");
                    String nomeHotel = scannerString.nextLine();

                    listaHotel.add(new Hotel(nomeHotel));
                    System.out.println("Hotel creato e aggiunto alla lista");
                    break;

                case 3:
                    System.out.print("Inserisci nome hotel: ");
                    String cerca = scannerString.nextLine();

                    Hotel hotelTrovato = null; // oggetto null

                    for (Hotel hotel : listaHotel) { // ciclo tutta la lista e se trovo una corrispondenza
                        if (hotel.getNome().equalsIgnoreCase(cerca)) {
                            hotelTrovato = hotel; // assegno tale corrispondenza all'oggetto inizializzato null
                            break;
                        }
                    }

                    if (hotelTrovato == null) { // se non trovo
                        System.out.println("Hotel non trovato");
                    } else { // se trovo l'hotel e valorizzo la variabile e apro un nuovo menu

                        int sceltaHotel;

                        do {
                            System.out.println("\n\tMENU HOTEL '" + hotelTrovato.getNome().toUpperCase() + "'");
                            System.out.println("1. Mostra camere");
                            System.out.println("2. Mostra suite");
                            System.out.println("3. Aggiungi camera");
                            System.out.println("4. Aggiungi suite");
                            System.out.println("5. Torna indietro");
                            System.out.print("Scelta: ");

                            sceltaHotel = scannerInt.nextInt();

                            switch (sceltaHotel) {

                                case 1:
                                    for (Camera camera : hotelTrovato.getCamere()) { // cerco oggetti della classe
                                                                                     // CAmera
                                        if (camera.getClass() == Camera.class) {
                                            camera.dettagli();
                                        }
                                    }
                                    break;

                                case 2:
                                    for (Camera camera : hotelTrovato.getCamere()) { // cerco oggetti classe Suite
                                        if (camera.getClass() == Suite.class) {
                                            camera.dettagli();
                                        }
                                    }
                                    break;

                                case 3:
                                    System.out.print("Numero camera: ");
                                    int numeroCamera = scannerInt.nextInt();

                                    System.out.print("Prezzo: ");
                                    float prezzoCamera = scannerInt.nextFloat();

                                    hotelTrovato.aggiungiCamera(new Camera(numeroCamera, prezzoCamera));
                                    System.out.println("Camera aggiunta.");
                                    break;

                                case 4:
                                    System.out.print("Numero suite: ");
                                    int numeroSuite = scannerInt.nextInt();

                                    System.out.print("Prezzo: ");
                                    float prezzoSuite = scannerInt.nextFloat();
                                    scannerInt.nextLine();

                                    System.out.print("Servizi extra: ");
                                    String servizi = scannerString.nextLine();

                                    hotelTrovato.aggiungiCamera(new Suite(numeroSuite, prezzoSuite, servizi));
                                    System.out.println("Suite aggiunta.");
                                    break;

                                case 5:
                                    System.out.println("Ritorno al menu principale");
                                    break;

                                default:
                                    System.out.println("Scelta non valida");
                            }

                        } while (sceltaHotel != 5);
                        break;
                    }

                case 4:
                    System.out.println("Uscita");
                    break;

                default:
                    System.out.println("Scelta non valida");
            }

        } while (scelta != 4);

        scannerInt.close();
        scannerString.close();
    }
}

/*
 * public static void gestisciHotel(Scanner scanner, Hotel hotel) {
 * 
 * int scelta;
 * 
 * do {
 * System.out.println("\n\tMENU HOTEL " + hotel.getNome().toUpperCase());
 * System.out.println("1. Mostra camere");
 * System.out.println("2. Mostra suite");
 * System.out.println("3. Aggiungi camera");
 * System.out.println("4. Aggiungi suite");
 * System.out.println("5. Torna indietro");
 * 
 * scelta = scanner.nextInt();
 * scanner.nextLine();
 * 
 * switch (scelta) {
 * 
 * case 1:
 * for (Camera camera : hotel.getCamere()) {
 * if (camera.getClass() == Camera.class) { // cicl per trovare oggetti della
 * classe Camera
 * camera.dettagli(); // se ne trovo uso dettagli()
 * }
 * }
 * break;
 * 
 * case 2:
 * for (Camera camera : hotel.getCamere()) { // ciclo per trovare oggetti della
 * classe Suite
 * if (camera.getClass() == Suite.class) {
 * camera.dettagli();
 * }
 * }
 * break;
 * 
 * case 3:
 * System.out.print("Numero camera: ");
 * int numeroCamera = scanner.nextInt();
 * 
 * System.out.print("Prezzo: ");
 * float prezzoCamera = scanner.nextFloat();
 * 
 * hotel.aggiungiCamera(new Camera(numeroCamera, prezzoCamera)); // creo e
 * aggiungo la camera alla
 * // lsita dell'hotel
 * System.out.println("Camera aggiunta.");
 * break;
 * 
 * case 4:
 * System.out.print("Numero suite: ");
 * int numeroSuite = scanner.nextInt();
 * 
 * System.out.print("Prezzo: ");
 * float prezzoSuite = scanner.nextFloat();
 * scanner.nextLine();
 * 
 * System.out.print("Servizi extra: ");
 * String servizi = scanner.nextLine();
 * 
 * hotel.aggiungiCamera(new Suite(numeroSuite, prezzoSuite, servizi)); // creo e
 * aggiungo suite alla
 * // lista hotel
 * System.out.println("Suite aggiunta.");
 * break;
 * 
 * case 5:
 * System.out.println("\nRitorno al menu principale\n");
 * break;
 * 
 * default:
 * System.out.println("Scelta non valida.");
 * }
 * 
 * } while (scelta != 5);
 * 
 * }
 * 
 * }
 */