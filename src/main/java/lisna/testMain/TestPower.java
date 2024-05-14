package lisna.testMain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import core.main.Linear;
import core.main.Const;
import lisna.main.Power;

import java.text.NumberFormat;

public class TestPower {

    int x=2;
    int y=3;
    Power func = Power.of(Const.of(x),Const.of(y));
    @Test
    void testCalculate_(){
        double res=func.calculate(x);
        Assertions.assertEquals(8, res);
    }

    @Test
    void testToPrettyString(){
        String result = func.toPrettyString(NumberFormat.getInstance());
        Assertions.assertEquals(String.format("(%s)^(%s)", x,y),result);
    }

    @Test
    void testDerivative() {
        String result = func.derivative().toPrettyString(NumberFormat.getInstance());
        String derivativeFunc = Const.of(x).derivative().toPrettyString(NumberFormat.getInstance());
        Assertions.assertEquals(String.format("(%s*(%s)^((%s-1))*%s)",y,x,y,derivativeFunc), result);
    }

    @Test
    void testPowerOf(){
        Object result = Power.of(Linear.X,Linear.X);
        Assertions.assertInstanceOf(Power.class, result);
    }
}
