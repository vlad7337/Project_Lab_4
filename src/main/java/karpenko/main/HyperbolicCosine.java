package karpenko.main;

import banna.main.Multiplication;
import core.main.Composite;
import core.main.Function;

import java.text.NumberFormat;

public class HyperbolicCosine extends Composite {

    public HyperbolicCosine(Function term) {
        super(term);
    }

    @Override
    public double calculate(double x) {
        return Math.cosh(terms().getFirst().calculate(x));
    }

    @Override
    public Function derivative() {
        Function term = terms().getFirst();
        return Multiplication.of(HyperbolicSine.of(term), term.derivative());
    }

    @Override
    public String toPrettyString(NumberFormat nf) {
        return String.format("ch(%s)", terms().getFirst().toPrettyString(nf));
    }

    public static HyperbolicCosine of(Function term){
        return new HyperbolicCosine(term);
    }

}