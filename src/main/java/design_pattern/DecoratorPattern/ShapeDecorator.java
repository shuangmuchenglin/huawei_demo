package design_pattern.DecoratorPattern;

/**
 * @ClassName: ShapeDecorator
 * @Author: Zuo
 * @Date 2022/5/8
 * @Version 1.0
 */
public abstract class ShapeDecorator implements Shape {
    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape){
        this.decoratedShape = decoratedShape;
    }

    public void draw(){
        decoratedShape.draw();
    }
}