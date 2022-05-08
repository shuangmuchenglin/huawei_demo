package design_pattern.SingletonPattern.Enumeration;

import org.junit.Test;

import java.text.MessageFormat;

public class MultiThreadTest {

    @Test
    public void test() {
        MultiThread t1 = new MultiThread("Zuo_Sama", 25,50);
        System.out.println(MessageFormat.format("name:{1}, age:{2}","Zuo_Sama",25));
        MultiThread t2 = new MultiThread("Shao_Sama", 24,100);
        System.out.println(MessageFormat.format("name:{1}, age:{2}","Shao_Sama",24));
        MultiThread t3 = new MultiThread("Zhou_Sama", 23,150);
        System.out.println(MessageFormat.format("name:{1}, age:{2}","Zhou_Sama",23));
        MultiThread t4 = new MultiThread("Chen_Sama", 26,200);
        System.out.println(MessageFormat.format("name:{1}, age:{2}","Chen_Sama",26));
        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();
        new Thread(t4).start();
    }
}