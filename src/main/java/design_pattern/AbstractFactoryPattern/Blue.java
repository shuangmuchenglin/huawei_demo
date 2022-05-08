package design_pattern.AbstractFactoryPattern;

/**
 * @ClassName: Blue
 * @Author: Zuo
 * @Date 2022/5/5
 * @Version 1.0
 */
public class Blue implements Color {

    @Override
    public void fill() {
        System.out.println("Inside Blue::fill() method.");
    }
}