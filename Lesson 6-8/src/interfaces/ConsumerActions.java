package interfaces;

import calc.Calculator;
import trash.NullHistory;

import java.util.List;

public interface ConsumerActions {
    void useCalc(String expression);
    void watchCalcHistory();
    void clearCalcHistory();
    List<String> copyCalcHistory();
}
