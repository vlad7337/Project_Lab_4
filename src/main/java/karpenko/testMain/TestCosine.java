package karpenko.testMain;

import core.main.Const;
import core.main.Function;
import core.main.Linear;
import karpenko.main.Cosine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;
import java.text.NumberFormat;

public class TestCosine {

    int x = 0;
    Cosine func;

    @BeforeEach
    void setUp(){
        func = Cosine.of(Const.of(x));
    }

    @Test
    void testCalculate(){
        double result = func.calculate(x);
        Assertions.assertEquals(1, result);
    }

    @Test
    void testToPrettyString(){
        int x = 0;
        Cosine func = Cosine.of(Const.of(x));
        String result = func.toPrettyString(NumberFormat.getInstance());
        Assertions.assertEquals(String.format("cos(%s)", x),result);
    }

    @Test
    void testDerivative(){
        int x = 0;
        Cosine func = Cosine.of(Const.of(x));
        String result = func.derivative().toPrettyString(NumberFormat.getInstance());
        Assertions.assertEquals(String.format("(-1*sin(%s)*%s)", x, x), result);
    }
}
