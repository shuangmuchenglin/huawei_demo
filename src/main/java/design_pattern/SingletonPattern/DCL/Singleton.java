package design_pattern.SingletonPattern.DCL;

/**
 * @ClassName: Singleton
 * @Author: Zuo
 * @Date 2022/5/5
 * @Version 1.0
 */
public class Singleton {
    private volatile static Singleton singleton;
    private Singleton(){}
    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}