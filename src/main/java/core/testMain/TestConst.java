package core.testMain;

import core.main.Const;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.NumberFormat;

public class TestConst {

    int x = 1;

    Const func = Const.of(x);

    @Test
    void testCalculate(){
        double result = func.calculate(x);
        Assertions.assertEquals(x, result);
    }

    @Test
    void testToPrettyString(){
        String result = func.toPrettyString(NumberFormat.getInstance());
        Assertions.assertEquals(String.format("%s", x), result);
    }

    @Test
    void testDerivative(){
        String result = func.derivative().toPrettyString(NumberFormat.getInstance());
        Assertions.assertEquals("0", result);
    }

    @Test
    void testIntValue(){
        Object result = Const.of(x).intValue();
        Assertions.assertInstanceOf(Integer.class, result);
    }

    @Test
    void testLongValue(){
        Object result = Const.of(x).longValue();
        Assertions.assertInstanceOf(Long.class, result);
    }

    @Test
    void testFloatValue(){
        Object result = Const.of(x).floatValue();
        Assertions.assertInstanceOf(Float.class, result);
    }

    @Test
    void testDoubleValue(){
        Object result = Const.of(x).doubleValue();
        Assertions.assertInstanceOf(Double.class, result);
    }
}
