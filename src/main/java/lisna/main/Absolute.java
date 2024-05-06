package lisna.main;

import banna.main.Multiplication;
import core.main.Composite;
import core.main.Function;

import java.text.NumberFormat;

public class Absolute extends Composite {

    public Absolute(Function term) {
        super(term);
    }

    @Override
    public double calculate(double x) {
        return Math.abs(terms().get(0).calculate(x));
    }

    @Override
    public Function derivative() {
        Function term = terms().get(0);
        return new Multiplication(Sign.of(term), term.derivative());
    }

    @Override
    public String toPrettyString(NumberFormat nf) {
        return "|"+ terms().get(0).toPrettyString(nf) +"|";
    }

    public static Absolute of(Function term){
        return new Absolute(term);
    }

}
