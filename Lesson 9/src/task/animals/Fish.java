package task.animals;

import task.Animal;

import javax.naming.OperationNotSupportedException;

public abstract class Fish extends Animal {
    protected Fish(String name) {
        super(name);
    }

    @Override public void voice() throws OperationNotSupportedException {
        System.err.println(getClass().getSimpleName() + " says \"Fuck you!\"");
        throw new OperationNotSupportedException();
    }

    @Override public String toString() {
        return super.toString().replace(" }", "; message = I'm Fish " + getClass().getSimpleName() + " }");
    }
}
