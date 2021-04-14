package calc;

import interfaces.CalcActions;

public class Calculator extends Arithmetic implements CalcActions {

    private String expression = null;
    private double result = 0;

    public void setExpression(String exp) {
        expression = exp;
    }
    public double getResult() {
        return result;
    }

    public void evaluate() {

    }
}
