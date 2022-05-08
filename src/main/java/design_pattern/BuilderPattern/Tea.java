package design_pattern.BuilderPattern;

/**
 * @ClassName: Tea(茶)
 * @Author: Zuo
 * @Date 2022/5/8
 * @Version 1.0
 */
public class Tea extends Drink{
    @Override
    public String name() {
        return "tea";
    }

    @Override
    public float price() {
        return 15.2f;
    }
}
