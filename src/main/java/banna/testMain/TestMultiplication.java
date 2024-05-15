package banna.testMain;

import banna.main.Multiplication;
import core.main.Const;
import core.main.Linear;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.NumberFormat;

public class TestMultiplication {
    int x = 1;
    Multiplication multiplication = new Multiplication(Linear.of(2), Const.of(3), Const.of(4));

    @Test
    void testCalculate() {
        double result = multiplication.calculate(x);
        Assertions.assertEquals(24, result);
    }

    @Test
    void testToPrettyString() {
        String result = multiplication.toPrettyString(NumberFormat.getInstance());
        Assertions.assertEquals("(2*x*3*4)", result);
    }

    @Test
    void testDerivative() {
        String result = multiplication.derivative().toPrettyString(NumberFormat.getInstance());
        Assertions.assertEquals("((2*3*4))", result);
    }

    @Test
    void testMultiplicationOf() {
        Object result = multiplication;
        Assertions.assertInstanceOf(Multiplication.class, result);
    }
}
