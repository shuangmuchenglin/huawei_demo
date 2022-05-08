package design_pattern.FactoryPattern.CalculatorFactory;

/**
 * @ClassName: design_pattern.FactoryMethodPattern.ComputeFactory
 * @Description: 实现Computable接口的工厂类，根据symbol，通过反射返回Computable对象
 * @author: zuo
 * @date: 2022/4/17 14:41
 */
public class ComputeFactory {

    public static Computable getCompute(String symbol) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        return (Computable) Class.forName(symbol).newInstance();
    }
}
