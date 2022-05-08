package design_pattern.BridgePattern;

/**
 * @ClassName: GreenCircle
 * @Author: Zuo
 * @Date 2022/5/8
 * @Version 1.0
 */
public class GreenCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: green, radius: "
                + radius +", x: " +x+", "+ y +"]");
    }
}