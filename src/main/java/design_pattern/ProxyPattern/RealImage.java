package design_pattern.ProxyPattern;

/**
 * @ClassName: RealImage
 * @Author: Zuo
 * @Date 2022/5/8
 * @Version 1.0
 */
public class RealImage implements Image {

    private String fileName;

    public RealImage(String fileName){
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }

    private void loadFromDisk(String fileName){
        System.out.println("Loading " + fileName);
    }
}
