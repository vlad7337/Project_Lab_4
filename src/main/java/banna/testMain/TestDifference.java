package banna.testMain;

import banna.main.Difference;
import core.main.Const;
import core.main.Linear;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.NumberFormat;

public class TestDifference {
    @Test
    void testCalculate() {
        Difference difference = new Difference(Const.of(10), Const.of(5));
        double result = difference.calculate(0);
        Assertions.assertEquals(5, result);
    }

    @Test
    void testToPrettyString() {
        Difference difference = new Difference(Linear.X, Const.of(2), Const.of(1));
        String result = difference.toPrettyString(NumberFormat.getInstance());
        Assertions.assertEquals("(x-2-1)", result);
    }

    @Test
    void testDerivative() {
        Difference difference = new Difference(Linear.X, Const.of(2), Const.of(1));
        String result = difference.derivative().toPrettyString(NumberFormat.getInstance());
        Assertions.assertEquals("(1-0-0)", result);
    }

    @Test
    void testDifferenceOf() {
        Object result = Difference.of(Linear.X, Const.of(2), Const.of(1));
        Assertions.assertInstanceOf(Difference.class, result);
    }
}
