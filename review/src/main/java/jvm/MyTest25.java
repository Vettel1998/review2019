package jvm;

public class MyTest25 implements Runnable {
    private Thread thread;
    public MyTest25() {
            thread = new Thread(this);
            this.thread.start();
    }

    @Override
    public void run() {
        ClassLoader classLoader = thread.getContextClassLoader();
        System.out.println("Class:"+classLoader.getClass());
        System.out.println("Parent:"+classLoader.getParent().getClass());
    }

    public static void main(String[] args) {
        new MyTest25();
    }
}
