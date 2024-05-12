package core.testMain;

import core.main.Linear;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.NumberFormat;

public class TestLinear {
    int x = 1, coefficient = 2;

    Linear func = Linear.of(coefficient);

    @Test
    void testCalculate(){
        double result = func.calculate(x);
        Assertions.assertEquals(2, result);
    }

    @Test
    void testToPrettyString(){
        String result = func.toPrettyString(NumberFormat.getInstance());
        Assertions.assertEquals(String.format("%s*x", coefficient), result);
    }

    @Test
    void testDerivative(){
        String result = func.derivative().toPrettyString(NumberFormat.getInstance());
        Assertions.assertEquals(String.format("%s", coefficient), result);
    }
}
