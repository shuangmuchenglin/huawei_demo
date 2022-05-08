import design_pattern.FactoryPattern.CalculatorFactory.Calculator;
import org.junit.Assert;
import org.junit.Test;


public class CalculatorTest {

    @Test
    public void shouldReturn2when1plus1() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Calculator calculator = new Calculator();
        int realVar = calculator.compute(1, 1, "design_pattern.FactoryPattern.CalculatorFactory.Add");
        int expectVar = 2;
        Assert.assertEquals(realVar, expectVar);
    }

    @Test
    public void shouldReturn0when1sub1() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Calculator calculator = new Calculator();
        int realVar = calculator.compute(1, 1, "design_pattern.FactoryPattern.CalculatorFactory.Sub");
        int expectVar = 0;
        Assert.assertEquals(realVar, expectVar);
    }

    @Test
    public void shouldReturn8when4Multi2() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Calculator calculator = new Calculator();
        int realVar = calculator.compute(4, 2, "design_pattern.FactoryPattern.CalculatorFactory.Multi");
        int expectVar = 8;
        Assert.assertEquals(realVar, expectVar);
    }

}