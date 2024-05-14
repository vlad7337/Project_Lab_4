package lisna.testMain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import core.main.Linear;
import core.main.Const;
import lisna.main.Sign;

import java.text.NumberFormat;

public class TestSign {

    int x=-3;
    int y=3;
    int z=0;
    @Test
    void testCalculate_neg(){
        Sign func = Sign.of(Const.of(x));
        double res=func.calculate(x);
        Assertions.assertEquals(-1, res);
    }

    @Test
    void testCalculate_pos(){
        Sign func = Sign.of(Const.of(y));
        double res=func.calculate(x);
        Assertions.assertEquals(1, res);
    }

    @Test
    void testCalculate_zero(){
        Sign func = Sign.of(Const.of(z));
        double res=func.calculate(x);
        Assertions.assertEquals(0, res);
    }

    @Test
    void testToPrettyString(){
        Sign func = Sign.of(Const.of(x));
        String result = func.toPrettyString(NumberFormat.getInstance());
        Assertions.assertEquals(String.format("|%s|", x),result);
    }

    @Test
    void testDerivative(){
        Sign func = Sign.of(Const.of(x));
        String result = func.derivative().toPrettyString(NumberFormat.getInstance());
        Assertions.assertEquals("0", result);
    }

    @Test
    void testSignOf(){
        Object result = Sign.of(Linear.X);
        Assertions.assertInstanceOf(Sign.class, result);
    }

}
