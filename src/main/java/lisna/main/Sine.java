package lisna.main;

import banna.main.Multiplication;
import core.main.Composite;
import core.main.Function;
import karpenko.main.Cosine;

import java.text.NumberFormat;


public class Sine extends Composite {

    public Sine(Function term) {
        super(term);
    }

    @Override
    public double calculate(double x) {
        return Math.sin(terms().get(0).calculate(x));
    }

    @Override
    public Function derivative() {
        Function term = terms().get(0);
        return Multiplication.of(Cosine.of(term), term.derivative());
    }

    @Override
    public String toPrettyString(NumberFormat nf) {
        return "sin(" + terms().get(0).toPrettyString(nf) + ")";
    }

    public static Sine of(Function term) {
        return new Sine(term);
    }

}
