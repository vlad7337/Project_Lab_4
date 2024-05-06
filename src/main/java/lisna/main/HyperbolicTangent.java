package lisna.main;

import banna.main.Multiplication;
import banna.main.Sum;
import core.main.Composite;
import core.main.Const;
import core.main.Function;

import java.text.NumberFormat;

public class HyperbolicTangent extends Composite {

    public HyperbolicTangent(Function term) {
        super(term);
    }

    @Override
    public double calculate(double x) {
        return Math.tanh(terms().get(0).calculate(x));
    }

    @Override
    public Function derivative() {
        Function term = terms().get(0);
        return new Sum(Const.of(1), Multiplication.of(Const.of(-1),Power.of(HyperbolicTangent.of(term),Const.of(2))));
    }

    @Override
    public String toPrettyString(NumberFormat nf) {
        return "th(" + terms().get(0).toPrettyString(nf) + ")";
    }

    public static HyperbolicTangent of(Function term){
        return new HyperbolicTangent(term);
    }

}
