package lisna.testMain;

import core.main.Linear;
import lisna.main.Absolute;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import core.main.Const;

import java.text.NumberFormat;

public class TestAbsolute {
    int x=-5;
    Absolute func=Absolute.of(Const.of(x));
    @Test
    void testCalculate(){
        double res=func.calculate(x);
        Assertions.assertEquals(5, res);
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
        Assertions.assertEquals(String.format("(|%s|*%s)", x,derivativeFunc), result);
    }

    @Test
    void testAbsoluteOf(){
        Object result = Absolute.of(Linear.X);
        Assertions.assertInstanceOf(Absolute.class, result);
    }
}
