package trash;

import java.util.ArrayList;

public class NullHistory extends ArrayList<String> {

    private static final NullHistory instance = new NullHistory();

    private NullHistory() {}

    public static NullHistory getInstance() { return instance; }

    @Override public String toString() { return "History is Empty."; }
}
