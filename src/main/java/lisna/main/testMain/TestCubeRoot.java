package lisna.main.testMain;

import core.main.Linear;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import core.main.Const;
import lisna.main.main.CubeRoot;

import java.text.NumberFormat;

public class TestCubeRoot {

    int x=8;
    CubeRoot func=CubeRoot.of(Const.of(x));
    @Test
    void testCalculate(){
        double res=func.calculate(x);
        Assertions.assertEquals(2, res);
    }

    @Test
    void testToPrettyString(){
        String result = func.toPrettyString(NumberFormat.getInstance());
        Assertions.assertEquals(String.format("∛(%s)", x),result);
    }

    @Test
    void testDerivative(){
        String result = func.derivative().toPrettyString(NumberFormat.getInstance());
        String derivativeFunc = Const.of(x).derivative().toPrettyString(NumberFormat.getInstance());
        Assertions.assertEquals(String.format("(0,333*(∛(%s))^(-2)*%s)", x,derivativeFunc), result);
    }

    @Test
    void testCubeRootOf(){
        Object result = CubeRoot.of(Linear.X);
        Assertions.assertInstanceOf(CubeRoot.class, result);
    }
}
