package banna.testMain;

import banna.main.Multiplication;
import core.main.Const;
import core.main.Linear;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.NumberFormat;

public class TestMultiplication {
    @Test
    void testCalculate() {
        Multiplication multiplication = new Multiplication(Const.of(2), Const.of(3), Const.of(4));
        double result = multiplication.calculate(0);
        Assertions.assertEquals(24, result);
    }

    @Test
    void testToPrettyString() {
        Multiplication multiplication = new Multiplication(Linear.X, Const.of(2), Const.of(3));
        String result = multiplication.toPrettyString(NumberFormat.getInstance());
        Assertions.assertEquals("(x*2*3)", result);
    }

    @Test
    void testDerivative() {
        Multiplication multiplication = new Multiplication(Linear.X, Const.of(2), Const.of(3));
        String result = multiplication.derivative().toPrettyString(NumberFormat.getInstance());
        Assertions.assertEquals("((1*2*3)+(x*0*3)+(x*2*0))", result);
    }

    @Test
    void testMultiplicationOf() {
        Object result = Multiplication.of(Linear.X, Const.of(2), Const.of(3));
        Assertions.assertInstanceOf(Multiplication.class, result);
    }
}
