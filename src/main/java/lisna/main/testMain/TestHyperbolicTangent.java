package lisna.main.testMain;

import core.main.Linear;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import core.main.Const;
import lisna.main.main.HyperbolicTangent;

import java.text.NumberFormat;
public class TestHyperbolicTangent {

    int x=90;
    HyperbolicTangent func=HyperbolicTangent.of(Const.of(x));
    @Test
    void testCalculate(){
        double res=func.calculate(x);
        Assertions.assertEquals(1, res);
    }

    @Test
    void testToPrettyString(){
        String result = func.toPrettyString(NumberFormat.getInstance());
        Assertions.assertEquals(String.format("th(%s)", x),result);
    }

    @Test
    void testDerivative(){
        String result = func.derivative().toPrettyString(NumberFormat.getInstance());
        Assertions.assertEquals(String.format("(1+(-1*(th(%s))^(2)))", x), result);
    }

    @Test
    void testHyperbolicTangentOf(){
        Object result = HyperbolicTangent.of(Linear.X);
        Assertions.assertInstanceOf(HyperbolicTangent.class, result);
    }
}
