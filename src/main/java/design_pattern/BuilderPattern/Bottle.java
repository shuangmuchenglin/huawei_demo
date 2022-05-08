package design_pattern.BuilderPattern;

/**
 * @ClassName: Bottle(瓶装)
 * @Author: Zuo
 * @Date 2022/5/8
 * @Version 1.0
 */
public class Bottle implements Packing{
    @Override
    public String pack() {
        return "Bottle";
    }
}
