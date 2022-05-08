package design_pattern.DecoratorPattern;

/**
 * @ClassName: Rectangle
 * @Author: Zuo
 * @Date 2022/5/8
 * @Version 1.0
 */
public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Shape: Rectangle");
    }
}