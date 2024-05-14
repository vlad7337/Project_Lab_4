package banna.testMain;

import banna.main.Sum;
import core.main.Const;
import core.main.Linear;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.NumberFormat;

public class TestSum {
    @Test
    void testCalculate() {
        Sum sum = new Sum(Const.of(2), Const.of(3), Const.of(4));
        double result = sum.calculate(0);
        Assertions.assertEquals(9, result);
    }

    @Test
    void testToPrettyString() {
        Sum sum = new Sum(Linear.X, Const.of(2), Const.of(3));
        String result = sum.toPrettyString(NumberFormat.getInstance());
        Assertions.assertEquals("(x+2+3)", result);
    }

    @Test
    void testDerivative() {
        Sum sum = new Sum(Linear.X, Const.of(2), Const.of(3));
        String result = sum.derivative().toPrettyString(NumberFormat.getInstance());
        Assertions.assertEquals("(1+0+0)", result);
    }

    @Test
    void testSumOf() {
        Object result = Sum.of(Linear.X, Const.of(2), Const.of(3));
        Assertions.assertInstanceOf(Sum.class, result);
    }
}
