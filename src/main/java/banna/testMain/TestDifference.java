package banna.testMain;

import banna.main.Difference;
import core.main.Const;
import core.main.Linear;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.NumberFormat;

public class TestDifference {
    int x = 0;
    Difference difference = new Difference(Linear.of(10), Const.of(5));
    @Test
    void testCalculate() {
        double result = difference.calculate(x);
        Assertions.assertEquals(-5, result);
    }

    @Test
    void testToPrettyString() {
        String result = difference.toPrettyString(NumberFormat.getInstance());
        Assertions.assertEquals("(10*x-5)", result);
    }

    @Test
    void testDerivative() {
        String result = difference.derivative().toPrettyString(NumberFormat.getInstance());
        Assertions.assertEquals("(10-0)", result);
    }

    @Test
    void testDifferenceOf() {
        Object result = difference;
        Assertions.assertInstanceOf(Difference.class, result);
    }
}
