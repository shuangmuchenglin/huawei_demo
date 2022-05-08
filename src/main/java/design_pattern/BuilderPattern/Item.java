package design_pattern.BuilderPattern;

/**
 * @InterfaceName: Item(食物接口)
 * @Author: Zuo
 * @Date 2022/5/8
 * @Version 1.0
 */
public interface Item {
    public String name();
    public Packing packing();
    public float price();
}