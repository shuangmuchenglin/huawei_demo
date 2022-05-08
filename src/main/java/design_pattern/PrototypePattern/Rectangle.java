package design_pattern.PrototypePattern;

/**
 * @ClassName: Rectangle
 * @Author: Zuo
 * @Date 2022/5/8
 * @Version 1.0
 */
public class Rectangle extends Shape {

    public Rectangle(){
        type = "Rectangle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}