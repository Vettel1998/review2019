package juc.geek;

import java.util.concurrent.TimeUnit;

class VolatileExample{
    int x= 0;
    boolean v= false;
    public void writer(){
        x=42;
        v=true;
    }
    public void read(){
        if (v == true){
            System.out.println(Thread.currentThread().getName()+": x = "+x);
        }
    }
}

//传递性规则
public class VolatileDemo2 {

    public static void main(String[] args) throws InterruptedException {
        VolatileExample volatileExample = new VolatileExample();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t come in");
            volatileExample.writer();
        }).start();

        TimeUnit.SECONDS.sleep(3);
        volatileExample.read();
    }
}
