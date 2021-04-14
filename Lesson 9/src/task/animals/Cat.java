package task.animals;

import task.Animal;

public abstract class Cat extends Animal {
    protected Cat(String name) {
        super(name);
    }

    @Override public void voice() {
        System.out.println("Myau-myau");
    }

    @Override public String toString() {
        return super.toString().replace(" }", "; message = I'm Cat " + getClass().getSimpleName() + " }");
    }
}
