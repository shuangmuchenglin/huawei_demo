package design_pattern.BuilderPattern;

/**
 * @ClassName: Burger(汉堡类)
 * @Author: Zuo
 * @Date 2022/5/8
 * @Version 1.0
 */
public abstract class Burger implements Item{
    @Override
    public abstract String name();

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}
