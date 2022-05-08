package design_pattern.ObserverPattern;

/**
 * @ClassName: BinaryObserver
 * @Author: Zuo
 * @Date 2022/5/8
 * @Version 1.0
 */
public class BinaryObserver extends Observer{

    public BinaryObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Binary String: "
                + Integer.toBinaryString( subject.getState() ) );
    }
}