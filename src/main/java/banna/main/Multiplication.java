package banna.main;

import core.main.Composite;
import core.main.Const;
import core.main.Function;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.StringJoiner;

public class Multiplication extends Composite {
    public Multiplication() {
        super();
    }

    public Multiplication(Function... terms) {
        super(terms);
    }

    public Multiplication(ArrayList<Function> terms) {
        super(terms);
    }

    @Override
    public double calculate(double x) {
        double result = 1.0;
        for (Function function : terms()) {
            result *= function.calculate(x);
        }
        return result;
    }

    @Override
    public Function derivative() {
        ArrayList<Function> derivativeTerms = new ArrayList<>();
        for (int i = 0; i < terms().size(); i++) {
            ArrayList<Function> multipliedTerms = new ArrayList<>(terms());
            Function currentTerm = multipliedTerms.remove(i);
            Function currentTermDerivative = currentTerm.derivative();
            // Перевірка, чи додаємо похідну до множення
            if (!(currentTermDerivative instanceof Const) || ((Const) currentTermDerivative).calculate(0) != 0) {
                multipliedTerms.add(i, currentTermDerivative);
                derivativeTerms.add(new Multiplication(multipliedTerms));
            }
        }
        // Повертаємо суму доданків з похідними
        return new Sum(derivativeTerms);
    }


    @Override
    public String toPrettyString(NumberFormat nf) {
        final StringJoiner joiner = new StringJoiner("*");
        for (Function function : terms()) {
            joiner.add(function.toPrettyString(nf));
        }
        return String.format("(%s)", joiner.toString());
    }

    public static Multiplication of(Function... terms) {
        return new Multiplication(terms);
    }
}
