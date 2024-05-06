package banna.main;

import core.main.Composite;
import core.main.Const;
import core.main.Function;
import lisna.main.Power;

import java.text.NumberFormat;

class Sqrt extends Composite {
    private final Function base;

    public Sqrt(Function base) {
        super(base);
        this.base = base;
    }

    @Override
    public double calculate(double x) {
        double baseValue = base.calculate(x);
        return Math.sqrt(baseValue);
    }

    @Override
    public Function derivative() {
        // Визначення похідної для функції кореня
        return Multiplication.of(
                Const.of(0.5),
                Power.of(base, Const.of(-0.5)),
                base.derivative()
        );
    }

    @Override
    public String toPrettyString(NumberFormat nf) {
        return String.format("sqrt(%s)", base.toPrettyString(nf));
    }

    public static Sqrt of(Function base) {
        return new Sqrt(base);
    }
}