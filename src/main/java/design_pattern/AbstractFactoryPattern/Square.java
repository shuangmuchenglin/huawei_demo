package design_pattern.AbstractFactoryPattern;

/**
 * @ClassName: Square
 * @Author: Zuo
 * @Date 2022/5/5
 * @Version 1.0
 */
public class Square implements Shape{
    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
