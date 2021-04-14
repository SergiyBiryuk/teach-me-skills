package task.animals;

import task.Animal;

public abstract class Dog extends Animal {
    protected Dog(String name) {
        super(name);
    }

    @Override public void voice() {
        System.out.println("Gav-gav");
    }

    @Override public String toString() {
        return super.toString().replace(" }", "; message = I'm Dog " + getClass().getSimpleName() + " }");
    }
}
