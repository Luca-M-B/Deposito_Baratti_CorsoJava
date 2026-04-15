public class EsempiEreditarieta {

}

class Vehicle {
    protected String brand = "Ford";

    public void honk() {
        System.out.println("Tuut, tuut!!");
    }
}

class Car extends Vehicle {
    private String modelName = "fiat";

    public static void main(String[] args) {

        Car miaMacchina = new Car();
        miaMacchina.honk();
        System.out.println(miaMacchina.brand + " " + miaMacchina.modelName);
    }
}