package design_pattern.BuilderPattern;

/**
 * @ClassName: Pepsi(百事可乐)
 * @Author: Zuo
 * @Date 2022/5/8
 * @Version 1.0
 */
public class Pepsi extends Drink {

    @Override
    public float price() {
        return 35.0f;
    }

    @Override
    public String name() {
        return "Pepsi";
    }
}
