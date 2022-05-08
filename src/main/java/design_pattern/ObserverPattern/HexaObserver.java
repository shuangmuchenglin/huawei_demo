package design_pattern.ObserverPattern;

/**
 * @ClassName: HexaObserver
 * @Author: Zuo
 * @Date 2022/5/8
 * @Version 1.0
 */
public class HexaObserver extends Observer{

    public HexaObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Hex String: "
                + Integer.toHexString( subject.getState() ).toUpperCase() );
    }
}