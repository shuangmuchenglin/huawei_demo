package design_pattern.BuilderPattern;

/**
 * @ClassName: ChickenBurger(鸡肉汉堡)
 * @Author: Zuo
 * @Date 2022/5/8
 * @Version 1.0
 */
public class ChickenBurger extends Burger {

    @Override
    public float price() {
        return 50.5f;
    }

    @Override
    public String name() {
        return "Chicken Burger";
    }
}
