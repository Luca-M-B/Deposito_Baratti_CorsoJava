class SubsystemA {
    void operationA() {
        System.out.println("Operazione A della classe SubsystemA");
    }
}

class SubsystemB {
    void operationB() {
        System.out.println("Operazione B della classe SubsystemB");
    }
}

class Facade {

    private SubsystemA a = new SubsystemA();
    private SubsystemB b = new SubsystemB();

    public void operazioneUnificata() {
        a.operationA();
        b.operationB();
    }

}

public class EsempioFacade {
    public static void main(String[] args) {

        Facade facade = new Facade();

        facade.operazioneUnificata();
    }
}
