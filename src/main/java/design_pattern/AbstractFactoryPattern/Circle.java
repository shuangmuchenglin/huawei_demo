package design_pattern.AbstractFactoryPattern;

/**
 * @ClassName: Circle
 * @Author: Zuo
 * @Date 2022/5/5
 * @Version 1.0
 */
public class Circle implements Shape{
    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
