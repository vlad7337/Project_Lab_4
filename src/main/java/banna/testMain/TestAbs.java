package banna.testMain;

import banna.main.Abs;
import core.main.Linear;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.text.NumberFormat;

public class TestAbs {
    int x=-10;
    Abs abs=Abs.of(Linear.of(1));

    @Test
    void testCalculate(){
        double res=abs.calculate(x);
        Assertions.assertEquals(10, res);
    }

    @Test
    void testToPrettyString(){
        String result = abs.toPrettyString(NumberFormat.getInstance());
        Assertions.assertEquals("|1*x|",result);
    }

    @Test
    void testDerivative(){
        String result = abs.derivative().toPrettyString(NumberFormat.getInstance());
        Assertions.assertEquals("((1*x*|(1*x)^(-1)|)*1)", result);
    }

    @Test
    void testAbsoluteOf(){
        Object result = Abs.of(Linear.X);
        Assertions.assertInstanceOf(Abs.class, result);
    }
}
