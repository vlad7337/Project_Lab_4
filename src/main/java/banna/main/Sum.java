package banna.main;

import core.main.Composite;
import core.main.Function;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.StringJoiner;

public class Sum extends Composite {
    public Sum(Function... terms) {
        super(terms);
    }

    public Sum(ArrayList<Function> terms) {
        super(terms);
    }

    @Override
    public double calculate(double x) {
        double result = 0.0;
        for (Function function : terms()) {
            result += function.calculate(x);
        }
        return result;
    }

    @Override
    public Function derivative() {
        ArrayList<Function> derivativeTerms = new ArrayList<>();
        for (Function function : terms()) {
            // Обчислюємо похідну кожного доданку суми
            derivativeTerms.add(function.derivative());
        }
        // Повертаємо суму похідних доданків
        return new Sum(derivativeTerms);
    }

    @Override
    public String toPrettyString(NumberFormat nf) {
        final StringJoiner joiner = new StringJoiner("+");
        for (Function function : terms()) {
            joiner.add(function.toPrettyString(nf));
        }
        return String.format("(%s)", joiner.toString()).replace("+-", "-");
    }

    public static Sum of(Function... terms) {
        return new Sum(terms);
    }
}