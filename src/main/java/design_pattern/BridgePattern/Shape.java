package design_pattern.BridgePattern;

/**
 * @ClassName: Shape
 * @Author: Zuo
 * @Date 2022/5/8
 * @Version 1.0
 */
public abstract class Shape {
    protected DrawAPI drawAPI;
    protected Shape(DrawAPI drawAPI){
        this.drawAPI = drawAPI;
    }
    public abstract void draw();
}