import calc.Calculator;
import calc.CalculatorWithHistory;
import interfaces.ConsumerActions;
import trash.NullHistory;
import util.Writer;
import java.util.List;

public class Consumer implements ConsumerActions {

    private Calculator calculator = new CalculatorWithHistory();

    public void useCalc(String expression) {
        calculator.setExpression(expression);
        calculator.evaluate();
        Writer.writeln("Result = " + calculator.getResult());
    }

    public void watchCalcHistory() {

    }

    public List<String> copyCalcHistory() {
        return NullHistory.getInstance();
    }

    public void clearCalcHistory() {
        ((CalculatorWithHistory)calculator).clearHistory();
    }
}
