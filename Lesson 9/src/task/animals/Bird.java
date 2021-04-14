package task.animals;

import task.Animal;

public abstract class Bird extends Animal {
    protected Bird(String name) {
        super(name);
    }

    @Override public void voice() {
        System.out.println("Chik-chirik");
    }

    @Override public String toString() {
        return super.toString().replace(" }", "; message = I'm Bird " + getClass().getSimpleName() + " }");
    }
}
