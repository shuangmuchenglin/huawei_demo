package design_pattern.BuilderPattern;

/**
 * @ClassName: Drink(饮料类)
 * @Author: Zuo
 * @Date 2022/5/8
 * @Version 1.0
 */
public abstract class Drink implements Item{
    @Override
    public abstract String name();

    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();
}
