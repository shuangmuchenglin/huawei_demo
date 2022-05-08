package design_pattern.PrototypePattern;

/**
 * @ClassName: Circle
 * @Author: Zuo
 * @Date 2022/5/8
 * @Version 1.0
 */
public class Circle extends Shape {

    public Circle(){
        type = "Circle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
