package design_pattern.DecoratorPattern;

/**
 * @ClassName: RedShapeDecorator
 * @Author: Zuo
 * @Date 2022/5/8
 * @Version 1.0
 */
public class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }

    private void setRedBorder(Shape decoratedShape){
        System.out.println("Border Color: Red");
    }
}