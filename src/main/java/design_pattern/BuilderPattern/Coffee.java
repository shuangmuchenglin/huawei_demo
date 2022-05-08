package design_pattern.BuilderPattern;

/**
 * @ClassName: Coffee(咖啡)
 * @Author: Zuo
 * @Date 2022/5/8
 * @Version 1.0
 */
public class Coffee extends Drink{
    @Override
    public String name() {
        return "coffee";
    }

    @Override
    public float price() {
        return 18.3f;
    }
}
