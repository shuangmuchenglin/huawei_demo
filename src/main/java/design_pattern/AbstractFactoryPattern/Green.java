package design_pattern.AbstractFactoryPattern;

/**
 * @ClassName: Green
 * @Author: Zuo
 * @Date 2022/5/5
 * @Version 1.0
 */
public class Green implements Color {

    @Override
    public void fill() {
        System.out.println("Inside Green::fill() method.");
    }
}
