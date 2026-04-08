package classi_base;

public class Te implements Bevanda {

    @Override
    public String getDescrizione() {
        return "Tè";
    }

    @Override
    public double getPrezzo() {
        return 2.00;
    }

}