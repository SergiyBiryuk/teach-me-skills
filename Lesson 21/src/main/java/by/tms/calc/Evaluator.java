package by.tms.calc;

import javax.naming.OperationNotSupportedException;
import java.util.function.Function;

public class Evaluator {
    public double evaluate(double a, double b, String op) throws OperationNotSupportedException {
        switch(op) {
            case "sum": return Arithmetics.sum(a, b);
            case "sub": return Arithmetics.sub(a, b);
            case "mul": return Arithmetics.mul(a, b);
            case "div": return Arithmetics.div(a, b);
            default: throw new OperationNotSupportedException();
        }
    }
}
