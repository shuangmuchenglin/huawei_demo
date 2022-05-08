package design_pattern.BuilderPattern;

/**
 * @ClassName: ChickenRolls(鸡肉卷)
 * @Author: Zuo
 * @Date 2022/5/8
 * @Version 1.0
 */
public class ChickenRolls extends Burger {
    @Override
    public String name() {
        return "Chicken rolls";
    }

    @Override
    public float price() {
        return 24.3f;
    }
}
