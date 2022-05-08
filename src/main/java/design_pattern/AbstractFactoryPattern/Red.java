package design_pattern.AbstractFactoryPattern;

/**
 * @ClassName: Red
 * @Author: Zuo
 * @Date 2022/5/5
 * @Version 1.0
 */
public class Red implements Color {

    @Override
    public void fill() {
        System.out.println("Inside Red::fill() method.");
    }
}
