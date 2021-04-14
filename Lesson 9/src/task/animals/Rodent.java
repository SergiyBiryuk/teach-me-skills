package task.animals;

import task.Animal;

public abstract class Rodent extends Animal {
    protected Rodent(String name) {
        super(name);
    }

    @Override public void voice() {
        System.out.println("Pi-pi");
    }

    @Override public String toString() {
        return super.toString().replace(" }", "; message = I'm Rodent " + getClass().getSimpleName() + " }");
    }
}
