package juc;

public class SingletonDemo {
    private static volatile SingletonDemo ourInstance  = null;

    public static SingletonDemo getInstance() {
        if(ourInstance == null)
            synchronized (SingletonDemo.class){
                if (ourInstance == null)
                    ourInstance = new SingletonDemo();

            }
        return ourInstance;
    }

    private SingletonDemo() {
        System.out.println(Thread.currentThread().getName()+"\t 我是构造方法SingletonDemo()");
    }

    public static void main(String[] args) {
//        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
//        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
        for(int i=0;i<10;i++){
            new Thread(SingletonDemo::getInstance,String.valueOf(i)).start();
        }
    }
}
