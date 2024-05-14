package banna.testMain;

import banna.main.Sqrt;
import core.main.Const;
import core.main.Linear;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.NumberFormat;

public class TestSqrt {
    @Test
    void testCalculate() {
        Sqrt sqrt = new Sqrt(Const.of(16));
        double result = sqrt.calculate(0);
        Assertions.assertEquals(4, result);
    }

    @Test
    void testToPrettyString() {
        Sqrt sqrt = new Sqrt(Linear.X);
        String result = sqrt.toPrettyString(NumberFormat.getInstance());
        Assertions.assertEquals("sqrt(x)", result);
    }

    @Test
    void testDerivative() {
        Sqrt sqrt = new Sqrt(Linear.X);
        String result = sqrt.derivative().toPrettyString(NumberFormat.getInstance());
        Assertions.assertEquals("(0.5*(x^(-0.5))*1)", result);
    }

    @Test
    void testSqrtOf() {
        Object result = Sqrt.of(Linear.X);
        Assertions.assertInstanceOf(Sqrt.class, result);
    }
}
