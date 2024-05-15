package banna.testMain;

import banna.main.Sqrt;
import core.main.Linear;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.NumberFormat;

public class TestSqrt {
    int x = 16;
    Sqrt sqrt = new Sqrt(Linear.of(1));

    @Test
    void testCalculate() {
        double result = sqrt.calculate(x);
        Assertions.assertEquals(4, result);
    }

    @Test
    void testToPrettyString() {
        String result = sqrt.toPrettyString(NumberFormat.getInstance());
        Assertions.assertEquals("sqrt(1*x)", result);
    }

    @Test
    void testDerivative() {
        String result = sqrt.derivative().toPrettyString(NumberFormat.getInstance());
        Assertions.assertEquals("(0,5*(1*x)^(-0,5)*1)", result);
    }

    @Test
    void testSqrtOf() {
        Object result = sqrt;
        Assertions.assertInstanceOf(Sqrt.class, result);
    }
}
