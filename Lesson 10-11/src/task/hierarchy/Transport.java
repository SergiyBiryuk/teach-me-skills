package task.hierarchy;

public abstract class Transport {

    private static long i = 0;
    private final long id = i++;

    public long getId() { return id; }

    @Override public String toString() { return "{ id = " + id + " }"; }
}
