package juc;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;




class Mydata{
    volatile int num = 0;

    AtomicInteger atomicInteger = new AtomicInteger();
    public void setNum(){
        this.num = 60;
    }

    public  void inc(){
        num++;
    }


    public void addAtomic(){
        atomicInteger.getAndIncrement();
    }


}
/*
    1.验证volatile的可见性
        1.1 num变量之前没有添加volatile关键字
        1.2 添加了volatile解决的可见性

    2.验证volatile不保证原子性
        2.1 num++ 在多线程下是线程不安全的
        2.2 如何解决原子性
            * synchronized
            * AtomicInteger


 */
public class VolatileDemo {
    public static void main(String[] args) {
        //visibilityByVolatile();
        Mydata mydata = new Mydata();
        for(int i=0;i<20;i++){
            new Thread(()->{
                for (int j = 0; j <1000 ; j++) {
                    mydata.inc();
                    mydata.addAtomic();
                }
            },String.valueOf(i)).start();
        }

        //等待20个线程完成，取得num的值
        while(Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+"\t int type final num value :"+mydata.num);
        System.out.println(Thread.currentThread().getName()+"\t AtomicInteger type final num value :"+mydata.atomicInteger);
    }

    //volatile可以保证可见性，及时通知其他线程主物理内存的值已经被修改
    public static void visibilityByVolatile() {
        Mydata mydata = new Mydata();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\tcome in");
            //暂停一会线程
            try {
                TimeUnit.SECONDS.sleep(3);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            mydata.setNum();
            System.out.println(Thread.currentThread().getName()+"\tupdate number value:"+mydata.num);
        },"AAA").start();

        while(mydata.num == 0){

        }

        System.out.println(Thread.currentThread().getName()+"\tmission over");
    }
}
