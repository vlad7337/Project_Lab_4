package banna.testMain;

import banna.main.Sum;
import core.main.Const;
import core.main.Linear;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.NumberFormat;

public class TestSum {
    int x = 1;
    Sum sum = new Sum(Linear.of(1), Const.of(2), Const.of(3));
    @Test
    void testCalculate() {
        double result = sum.calculate(x);
        Assertions.assertEquals(6, result);
    }

    @Test
    void testToPrettyString() {
        String result = sum.toPrettyString(NumberFormat.getInstance());
        Assertions.assertEquals("(1*x+2+3)", result);
    }

    @Test
    void testDerivative() {
        String result = sum.derivative().toPrettyString(NumberFormat.getInstance());
        Assertions.assertEquals("(1+0+0)", result);
    }

    @Test
    void testSumOf() {
        Object result = sum;
        Assertions.assertInstanceOf(Sum.class, result);
    }
}
