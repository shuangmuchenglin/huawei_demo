package design_pattern.AbstractFactoryPattern;

/**
 * @ClassName: FactoryProducer
 * @Author: Zuo
 * @Date 2022/5/5
 * @Version 1.0
 */
public class FactoryProducer {
    public static AbstractFactory getFactory(String choice){
        if(choice.equalsIgnoreCase("SHAPE")){
            return new ShapeFactory();
        } else if(choice.equalsIgnoreCase("COLOR")){
            return new ColorFactory();
        }
        return null;
    }
}
