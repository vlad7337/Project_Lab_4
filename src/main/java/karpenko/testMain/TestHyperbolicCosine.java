package karpenko.testMain;

import core.main.Const;
import karpenko.main.Cosine;
import karpenko.main.HyperbolicCosine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.NumberFormat;

public class TestHyperbolicCosine {
    int x = 0;
    HyperbolicCosine func;

    @BeforeEach
    void setUp(){func = HyperbolicCosine.of(Const.of(x));}
    @Test
    void testCalculate(){
        double result = func.calculate(x);
        Assertions.assertEquals(1, result);
    }

    @Test
    void testToPrettyString(){
        String result = func.toPrettyString(NumberFormat.getInstance());
        Assertions.assertEquals(String.format("ch(%s)", x),result);
    }

    @Test
    void testDerivative(){
        String result = func.derivative().toPrettyString(NumberFormat.getInstance());
        Assertions.assertEquals(String.format("(sh(%s)*%s)", x, x), result);
    }
}
