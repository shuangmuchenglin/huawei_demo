package design_pattern.ObserverPattern;

/**
 * @ClassName: Observer
 * @Author: Zuo
 * @Date 2022/5/8
 * @Version 1.0
 */
public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}