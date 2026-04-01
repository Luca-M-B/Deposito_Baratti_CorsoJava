import java.util.ArrayList;

class Auto {
    String marca;
    int anno;

    Auto(String marca, int anno) {
        this.marca = marca;
        this.anno = anno;
    }

    public String toString() {
        return "Marca: " + marca + " - anno: " + anno;
        // return "Marca: " + this.marca + " - anno: " + this.anno;
        // utilizzare "this." non è sbagliato ma non è necessario nel toString()
    }
}

public class EsempioOggettiArrayList {

    public static void main(String[] args) {

        ArrayList<Auto> autoList = new ArrayList<>(); // creao arrayList con <Auto> come tipo dell'oggetto (non
                                                      // obbligatorio): questo si dice TIPIZZARE l'arrayList
        autoList.add(new Auto("Tesla", 2023)); // creo gli oggetti già dentro l'arrayList. Il loro nome è l'indice
                                               // all'interno dell'arrayList. Se avrò necessità di questi oggetti fuori
                                               // dall'array list dovrò rinominarli
        autoList.add(new Auto("Ford", 2020));

        for (Auto auto : autoList) {
            System.out.println(auto.marca + " - " + auto.anno);
        }
    }
}
