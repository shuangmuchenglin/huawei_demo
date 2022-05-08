package design_pattern.SingletonPattern.Enumeration;

import org.junit.Test;

import static org.junit.Assert.*;

public class MultiThreadTest {

    @Test
    public void test() {
        MultiThread t1 = new MultiThread("Zuo_Sama", 25,50);
        MultiThread t2 = new MultiThread("Shao_Sama", 24,100);
        MultiThread t3 = new MultiThread("Zhou_Sama", 23,150);
        MultiThread t4 = new MultiThread("Chen_Sama", 26,200);
        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();
        new Thread(t4).start();
    }
}