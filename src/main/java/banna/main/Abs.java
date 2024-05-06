package banna.main;

import core.main.Composite;
import core.main.Const;
import core.main.Function;
import lisna.main.Power;

import java.text.NumberFormat;

class Abs extends Composite {
    private final Function base;

    public Abs(Function base) {
        super(base);
        this.base = base;
    }

    @Override
    public double calculate(double x) {
        double baseValue = base.calculate(x);
        return Math.abs(baseValue);
    }

    @Override
    public Function derivative() {
        Function baseDerivative = base.derivative();
        // Визначення похідної для функції модуля
        return Multiplication.of(
                Multiplication.of(
                        base,
                        Abs.of(Power.of(base, Const.NEGATIVE_ONE))
                ),
                baseDerivative
        );
    }

    @Override
    public String toPrettyString(NumberFormat nf) {
        return String.format("|%s|", base.toPrettyString(nf));
    }

    public static Abs of(Function base) {
        return new Abs(base);
    }
}