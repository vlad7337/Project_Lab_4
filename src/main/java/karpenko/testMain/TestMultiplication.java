package karpenko.testMain;

import core.main.Linear;
import karpenko.main.Multiplication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.NumberFormat;

public class TestMultiplication {
    int x = 2;
    Linear func1 = Linear.X, func2 = Linear.X;
    Multiplication func = Multiplication.of(func1, func2);

    @Test
    void testCalculate(){
        double result = func.calculate(x);
        Assertions.assertEquals(4, result);
    }

    @Test
    void testToPrettyString(){
        String result = func.toPrettyString(NumberFormat.getInstance());
        Assertions.assertEquals("(x*x)", result);
    }

    @Test
    void testDerivative(){
        String result = func.derivative().toPrettyString(NumberFormat.getInstance());
        Assertions.assertEquals("((1*x)+(x*1))", result);
    }

    @Test
    void testMultiplicationOf(){
        Object result = Multiplication.of(Linear.X, Linear.X);
        Assertions.assertInstanceOf(Multiplication.class, result);
    }
}
