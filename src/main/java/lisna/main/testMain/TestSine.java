package lisna.main.testMain;

import core.main.Linear;
import karpenko.main.Cosine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import lisna.main.main.Sine;
import core.main.Const;

import java.text.NumberFormat;
public class TestSine {

    int x=0;
    Sine func=Sine.of(Const.of(x));
    @Test
    void testCalculate(){
        double res=func.calculate(x);
        Assertions.assertEquals(0, res);
    }

    @Test
    void testToPrettyString(){
        String result = func.toPrettyString(NumberFormat.getInstance());
        Assertions.assertEquals(String.format("sin(%s)", x),result);
    }

    @Test
    void testDerivative(){
        String result = func.derivative().toPrettyString(NumberFormat.getInstance());
        Assertions.assertEquals(String.format("(cos(%s)*%s)", x, x), result);
    }

    @Test
    void testSineOf(){
        Object result = Sine.of(Linear.X);
        Assertions.assertInstanceOf(Sine.class, result);
    }
}
