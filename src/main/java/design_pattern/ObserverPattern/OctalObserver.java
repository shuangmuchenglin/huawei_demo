package design_pattern.ObserverPattern;

/**
 * @ClassName: OctalObserver
 * @Author: Zuo
 * @Date 2022/5/8
 * @Version 1.0
 */
public class OctalObserver extends Observer{

    public OctalObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Octal String: "
                + Integer.toOctalString( subject.getState() ) );
    }
}