package karpenko.testMain;

import core.main.Const;
import karpenko.main.HyperbolicCosine;
import karpenko.main.HyperbolicSine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.NumberFormat;

public class TestHyperbolicSine {
    int x = 0;
    HyperbolicSine func;

    @BeforeEach
    void setUp(){func = HyperbolicSine.of(Const.of(x));}
    @Test
    void testCalculate(){
        double result = func.calculate(x);
        Assertions.assertEquals(0, result);
    }

    @Test
    void testToPrettyString(){
        String result = func.toPrettyString(NumberFormat.getInstance());
        Assertions.assertEquals(String.format("sh(%s)", x),result);
    }

    @Test
    void testDerivative(){
        String result = func.derivative().toPrettyString(NumberFormat.getInstance());
        Assertions.assertEquals(String.format("(ch(%s)*%s)", x, x), result);
    }
}