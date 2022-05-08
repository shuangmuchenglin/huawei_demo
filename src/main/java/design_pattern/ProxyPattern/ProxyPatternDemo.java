package design_pattern.ProxyPattern;

/**
 * @ClassName: ProxyPatternDemo
 * @Author: Zuo
 * @Date 2022/5/8
 * @Version 1.0
 */
public class ProxyPatternDemo {

    public static void main(String[] args) {
        //原始调用
        Image image1 = new RealImage("test.jpg");
        image1.display();
        //通过代理调用
        System.out.println("---------------------------------------------");
        Image image = new ProxyImage("test_10mb.jpg");
        // 图像将从磁盘加载
        image.display();
        // 图像不需要从磁盘加载
        System.out.println("---------------------------------------------");
        image.display();
    }
}
