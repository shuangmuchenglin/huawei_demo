package design_pattern.PrototypePattern;

/**
 * @ClassName: Square
 * @Author: Zuo
 * @Date 2022/5/8
 * @Version 1.0
 */
public class Square extends Shape {

    public Square(){
        type = "Square";
    }

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}