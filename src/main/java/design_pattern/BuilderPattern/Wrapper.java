package design_pattern.BuilderPattern;

/**
 * @ClassName: Wrapper(纸包装)
 * @Author: Zuo
 * @Date 2022/5/8
 * @Version 1.0
 */
public class Wrapper implements Packing{
    @Override
    public String pack() {
        return "Wrapper";
    }
}
