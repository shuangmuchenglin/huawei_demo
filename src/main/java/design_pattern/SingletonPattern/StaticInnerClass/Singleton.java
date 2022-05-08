package design_pattern.SingletonPattern.StaticInnerClass;

/**
 * @ClassName: Singleton
 * @Author: Zuo
 * @Date 2022/5/5
 * @Version 1.0
 */
public class Singleton {
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }
    private Singleton (){}
    public static final Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}