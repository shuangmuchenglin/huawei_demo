/**
 * @ClassName: Calculator
 * @Description: Calculator类实现
 * @author: zuo
 * @date: 2022/4/17 14:31
 */
public class Calculator {
    public int compute(int num1, int num2, String symbol) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Computable computable = ComputeFactory.getCompute(symbol);
        return computable.compute(num1, num2);
    }
}
