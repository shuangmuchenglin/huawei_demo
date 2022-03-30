import org.junit.Assert;
import org.junit.Test;


public class calculatorTest {
    @Test
    public void shouldReturn2when1plus1(){
        Calculator calculator = new Calculator();
        int realVar = calculator.compute(1,1,'+');
        int expectVar = 2;
        Assert.assertEquals(realVar, expectVar);
    }

    @Test
    public void shouldReturn0when1sub1(){
        Calculator calculator = new Calculator();
        int realVar = calculator.compute(1,1,'-');
        int expectVar = 0;
        Assert.assertEquals(realVar, expectVar);
    }


}