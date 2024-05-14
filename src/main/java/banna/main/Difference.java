package banna.main;

import core.main.Composite;
import core.main.Function;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.StringJoiner;

public class Difference extends Composite {
    public Difference() {
        super();
    }

    public Difference(Function... terms) {
        super(terms);
    }

    public Difference(ArrayList<Function> terms) {
        super(terms);
    }

    @Override
    public double calculate(double x) {
        double result = terms().get(0).calculate(x);
        for (int i = 1; i < terms().size(); i++) {
            result -= terms().get(i).calculate(x);
        }
        return result;
    }

    @Override
    public Function derivative() {
        ArrayList<Function> derivativeTerms = new ArrayList<>();
        for (Function function : terms()) {
            // Обчислюємо похідну кожного доданку різниці
            derivativeTerms.add(function.derivative());
        }
        // Повертаємо різницю похідних доданків
        return new Difference(derivativeTerms);
    }

    @Override
    public String toPrettyString(NumberFormat nf) {
        final StringJoiner joiner = new StringJoiner("-");
        for (Function function : terms()) {
            joiner.add(function.toPrettyString(nf));
        }
        return String.format("(%s)", joiner.toString());
    }

    public static Difference of(Function... terms) {
        return new Difference(terms);
    }
}