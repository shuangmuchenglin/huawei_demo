package design_pattern.SingletonPattern.Enumeration;

/**
 * @ClassName: Singleton
 * @Author: Zuo
 * @Date 2022/5/5
 * @Version 1.0
 */
public enum Singleton {

    INSTANCE;
    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Singleton{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class MultiThread implements Runnable {
    String name;
    int age;
    int delay;

    public MultiThread(String name, int age, int delay) {
        this.name = name;
        this.age = age;
        this.delay = delay;
    }


    @Override
    public void run() {
        try {
            Thread.sleep(delay);
            Singleton.INSTANCE.setName(name);
            Singleton.INSTANCE.setAge(age);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Singleton.INSTANCE.toString());
        System.out.println(System.identityHashCode(Singleton.INSTANCE));
    }
}

class Test {
    public static void main(String[] args) {
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