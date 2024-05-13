package karpenko.testMain;

import core.main.Const;
import core.main.Linear;
import karpenko.main.Tangent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.NumberFormat;

public class TestTangent {

    int x = 0;

    Tangent func = Tangent.of(Const.of(x));

    @Test
    void testCalculate(){
        double result = func.calculate(x);
        Assertions.assertEquals(0, result);
    }

    @Test
    void testToPrettyString(){
        String result = func.toPrettyString(NumberFormat.getInstance());
        Assertions.assertEquals(String.format("tg(%s)", x), result);
    }

    @Test
    void testDerivative(){
        String result = func.derivative().toPrettyString(NumberFormat.getInstance());
        Assertions.assertEquals(String.format("((cos(%s))^(-2)*%s)", x, x), result);
    }

    @Test
    void testTangentOf(){
        Object result = Tangent.of(Linear.X);
        Assertions.assertInstanceOf(Tangent.class, result);
    }
}
