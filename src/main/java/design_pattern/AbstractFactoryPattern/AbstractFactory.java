package design_pattern.AbstractFactoryPattern;

/**
 * @ClassName: AbstractFactory
 * @Author: Zuo
 * @Date 2022/5/5
 * @Version 1.0
 */
public abstract class AbstractFactory {
    public abstract Color getColor(String color);
    public abstract Shape getShape(String shape);
}