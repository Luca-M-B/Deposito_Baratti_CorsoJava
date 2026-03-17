public class ProvaStringhe {

    public static void main(String[] args) {

        String greeting = "Hello";
        System.out.println(greeting);

        System.out.println("---------------------------------");

        String txt = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        System.out.println("La lunghezza di txt è " + txt.length());

        System.out.println("---------------------------------");

        String txt2 = "Hello World";
        System.out.println(txt2.toUpperCase()); // stampa tutto in maiuscolo
        System.out.println(txt2.toLowerCase()); // stampa tutto in minuscolo

        System.out.println("---------------------------------");

        String txt3 = "Please locate where 'locate' occurs!";
        System.out.println(txt3.indexOf("locate")); // stampa 7 perchè il primo 'locate' inizia all'indice 7

        System.out.println("---------------------------------");

        
    }
}
