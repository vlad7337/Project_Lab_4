package karpenko.main;

import banna.main.Multiplication;
import lisna.main.*;
import core.main.Composite;
import core.main.Const;
import core.main.Function;

import java.text.NumberFormat;

public class Cosine extends Composite {

    public Cosine(Function term) {
        super(term);
    }

    @Override
    public double calculate(double x) {
        return Math.cos(terms().getFirst().calculate(x));
    }

    @Override
    public Function derivative() {
        Function term = terms().getFirst();
        return new Multiplication(Const.NEGATIVE_ONE, Sine.of(term), term.derivative());
    }

    @Override
    public String toPrettyString(NumberFormat nf) {
        return String.format("cos(%s)", terms().getFirst().toPrettyString(nf));
    }

    public static Cosine of(Function term){
        return new Cosine(term);
    }

}