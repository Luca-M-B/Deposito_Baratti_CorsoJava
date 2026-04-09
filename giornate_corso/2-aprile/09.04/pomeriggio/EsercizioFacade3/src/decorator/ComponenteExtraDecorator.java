package decorator;

import computer.*;

abstract class ComponenteExtraDecorator implements Computer {

    protected Computer computer;

    public ComponenteExtraDecorator(Computer computer) {
        this.computer = computer;
    }

}