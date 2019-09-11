package juc;

/*
           volatile/CAS/AtomicInteger/BlockQueue/线程交互
 */

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyResource{
    private volatile boolean FLAG = true;
    private AtomicInteger atomicInteger = new AtomicInteger();
    BlockingQueue<String> blockingQueue = null;

    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    public void stop(){
        this.FLAG = false;
    }
    public void myProd() throws Exception{
        String data = null;
        boolean retValue;
        while (FLAG){
            data = atomicInteger.incrementAndGet()+"";
            retValue = blockingQueue.offer(data,2, TimeUnit.SECONDS);
            if (retValue)
                System.out.println(Thread.currentThread().getName()+"\t 插入队列"+data+"成功");
            else
                System.out.println(Thread.currentThread().getName()+"\t 插入队列"+data+"失败");
            try{ TimeUnit.SECONDS.sleep(1);}catch(InterruptedException e){e.printStackTrace();}

        }
        System.out.println(Thread.currentThread().getName()+"\t 生产结束");
    }


    public void myConsumer() throws Exception{
        String result = null;
        while (FLAG){
            result = blockingQueue.poll(2,TimeUnit.SECONDS);
            if(null == result || result.equalsIgnoreCase("")){
                FLAG =false;
                System.out.println(Thread.currentThread().getName()+"\t 超过两秒没取到 消费退出");
                return;
            }
            System.out.println(Thread.currentThread().getName()+"\t 消费队列"+result+"成功");
        }
    }

}
public class ProConsumer_BlockQueueDemo {
    public static void main(String[] args) {
        MyResource myResource = new MyResource(new ArrayBlockingQueue<>(10));
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t 生产线程启动");
            try {
                myResource.myProd();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"Prod").start();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t 消费线程启动");
            try {
                myResource.myConsumer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"Consumer").start();

        try{ TimeUnit.SECONDS.sleep(5);}catch(InterruptedException e){e.printStackTrace();}

        System.out.println("Stop the world!!");
        myResource.stop();
    }


}
