package lisna.main;

import banna.main.Multiplication;
import core.main.Composite;
import core.main.Const;
import core.main.Function;

import java.text.NumberFormat;

public class CubeRoot extends Composite {

    public CubeRoot(Function term) {
        super (term);
    }

    @Override
    public double calculate(double x) {
        return Math.cbrt(terms().get(0).calculate(x));
    }

    @Override
    public Function derivative() {
        Function term = terms().get(0);
        return Multiplication.of(Const.of(1.0/3.0), (Power.of(CubeRoot.of(term),Const.of(-2.0)) ),term.derivative());
    }

    @Override
    public String toPrettyString(NumberFormat nf) {
        return "∛(" + terms().get(0).toPrettyString(nf) + ")";
    }

    public static CubeRoot of(Function term) {
        return new CubeRoot(term);
    }
}