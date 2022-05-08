package design_pattern.ProxyPattern;

/**
 * @ClassName: ProxyImage
 * @Author: Zuo
 * @Date 2022/5/8
 * @Version 1.0
 */
public class ProxyImage implements Image{

    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if(realImage == null){
            realImage = new RealImage(fileName);
        }
        System.out.println("======>before display, you could do something...");
        realImage.display();
        System.out.println("======>after display, you could do something...");
    }
}