package task;

import task.interfaces.Action;

import javax.naming.OperationNotSupportedException;

public abstract class Animal implements Action {

    private String name;
    private static long i = 0;
    private final long id = i++;

    protected Animal(String name) {
        this.name = name;
    }

    public long getId() { return id; }

    public abstract void voice() throws OperationNotSupportedException;

    @Override public String toString() {
        return "{ id = " + id + "; name = " + name + " }";
    }
}
