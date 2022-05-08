package design_pattern.BuilderPattern;

/**
 * @ClassName: VegBurger(蔬菜汉堡)
 * @Author: Zuo
 * @Date 2022/5/8
 * @Version 1.0
 */
public class VegBurger extends Burger {

    @Override
    public float price() {
        return 25.0f;
    }

    @Override
    public String name() {
        return "Veg Burger";
    }
}