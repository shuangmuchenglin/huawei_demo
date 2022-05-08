package design_pattern.BuilderPattern;

/**
 * @ClassName: CokeCola(可口可乐)
 * @Author: Zuo
 * @Date 2022/5/8
 * @Version 1.0
 */
public class CokeCola extends Drink {

    @Override
    public float price() {
        return 30.0f;
    }

    @Override
    public String name() {
        return "CokeCola";
    }
}