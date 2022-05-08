package design_pattern.AbstractFactoryPattern;

/**
 * @ClassName: ShapeFactory
 * @Author: Zuo
 * @Date 2022/5/5
 * @Version 1.0
 */
public class ShapeFactory extends AbstractFactory{

    @Override
    public Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }

    @Override
    public Color getColor(String color) {
        return null;
    }
}
