package design_pattern.BridgePattern;

/**
 * @ClassName: Circle
 * @Author: Zuo
 * @Date 2022/5/8
 * @Version 1.0
 */
public class Circle extends Shape {
    private int x, y, radius;

    public Circle(int x, int y, int radius, DrawAPI drawAPI) {
        super(drawAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public void draw() {
        drawAPI.drawCircle(radius,x,y);
    }
}