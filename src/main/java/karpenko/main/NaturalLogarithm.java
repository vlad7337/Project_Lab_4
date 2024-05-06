package karpenko.main;

import banna.main.Multiplication;
import core.main.Composite;
import core.main.Const;
import core.main.Function;
import lisna.main.Power;

import java.text.NumberFormat;

public class NaturalLogarithm extends Composite {

    public NaturalLogarithm(Function term) {
        super(term);
    }

    @Override
    public double calculate(double x) {
        return Math.log(terms().getFirst().calculate(x));
    }

    @Override
    public Function derivative() {
        Function term = terms().getFirst();
        return new Multiplication(Power.of(term, Const.NEGATIVE_ONE), term.derivative());
    }

    @Override
    public String toPrettyString(NumberFormat nf) {
        return String.format("ln(%s)", terms().getFirst().toPrettyString(nf));
    }

    public static NaturalLogarithm of(Function term){
        return new NaturalLogarithm(term);
    }

}
