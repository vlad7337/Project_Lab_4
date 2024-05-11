package karpenko.testMain;

import core.main.Const;
import karpenko.main.NaturalLogarithm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.NumberFormat;

public class TestNaturalLogarithm {
    int x = 1;

    NaturalLogarithm func;

    @BeforeEach
    void setUp(){func = NaturalLogarithm.of(Const.of(x));}

    @Test
    void testCalculate(){
        double result = func.calculate(x);
        Assertions.assertEquals(0, result);
    }

    @Test
    void testToPrettyString(){
        String result = func.toPrettyString(NumberFormat.getInstance());
        Assertions.assertEquals(String.format("ln(%s)", x), result);
    }

    @Test
    void testDerivative(){
        String result = func.derivative().toPrettyString(NumberFormat.getInstance());
        String derivativeFunc = Const.of(x).derivative().toPrettyString(NumberFormat.getInstance());
        Assertions.assertEquals(String.format("((%s)^(-1)*%s)", x, derivativeFunc), result);
    }

}
