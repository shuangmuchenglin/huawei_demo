package design_pattern.BuilderPattern;

/**
 * @ClassName: OrangeJuice(橙汁)
 * @Author: Zuo
 * @Date 2022/5/8
 * @Version 1.0
 */
public class OrangeJuice extends Drink{
    @Override
    public String name() {
        return "orange juice";
    }

    @Override
    public float price() {
        return 30.2f;
    }
}
