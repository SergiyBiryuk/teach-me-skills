package calc;

import interfaces.HistActions;

import java.util.Collection;
import java.util.List;

public class CalculatorWithHistory extends Calculator implements HistActions {

    private List<String> history = null;

    public List<String> getHistory() { return List.copyOf(history); }

    public void showHistory() {
        for(String str : history)
            System.out.println();
    }


    public void clearHistory() {


    }
}
