package design_pattern.FactoryPattern.ShapeFactory;

/**
 * @ClassName: Rectangle
 * @Author: Zuo
 * @Date 2022/5/5
 * @Version 1.0
 */
public class Rectangle implements Shape{
    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
