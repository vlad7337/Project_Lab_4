package karpenko.main;

import banna.main.Multiplication;
import core.main.Composite;
import core.main.Function;

import java.text.NumberFormat;

public class HyperbolicSine extends Composite {

    public HyperbolicSine(Function term) {
        super(term);
    }

    @Override
    public double calculate(double x) {
        return Math.sinh(terms().getFirst().calculate(x));
    }

    @Override
    public Function derivative() {
        Function term = terms().getFirst();
        return Multiplication.of(HyperbolicCosine.of(term), term.derivative());
    }

    @Override
    public String toPrettyString(NumberFormat nf) {
        return String.format("sh(%s)", terms().getFirst().toPrettyString(nf));
    }

    public static HyperbolicSine of(Function term){
        return new HyperbolicSine(term);
    }

}
