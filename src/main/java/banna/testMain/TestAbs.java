package banna.testMain;

import banna.main.Abs;
import core.main.Const;
import core.main.Linear;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.text.NumberFormat;

public class TestAbs {
    int x=-10;
    Abs func=Abs.of(Const.of(x));

    @Test
    void testCalculate(){
        double res=func.calculate(x);
        Assertions.assertEquals(10, res);
    }

    @Test
    void testToPrettyString(){
        String result = func.toPrettyString(NumberFormat.getInstance());
        Assertions.assertEquals(String.format("|%s|", x),result);
    }

    @Test
    void testDerivative(){
        String result = func.derivative().toPrettyString(NumberFormat.getInstance());
        String derivativeFunc = Const.of(x).derivative().toPrettyString(NumberFormat.getInstance());
        Assertions.assertEquals(String.format("((-10*|(-10)^(-1)|)*0)"), result);
    }

    @Test
    void testAbsoluteOf(){
        Object result = Abs.of(Linear.X);
        Assertions.assertInstanceOf(Abs.class, result);
    }
}
