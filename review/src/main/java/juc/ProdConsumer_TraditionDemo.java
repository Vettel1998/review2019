package juc;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareData{
        private int number = 0;
        private Lock lock = new ReentrantLock();
        private Condition condition = lock.newCondition();
        public void inc() throws Exception{
            lock.lock();
            try{
                while (number != 0){
                    //等待不能生产
                    condition.await();
                }
                number++;
                System.out.println(Thread.currentThread().getName()+"\t"+number);
                condition.signalAll();
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                lock.unlock();
            }


        }

        public void dec() throws Exception{
            lock.lock();
            try{
                while (number==0){
                    condition.await();
                }
                number--;
                System.out.println(Thread.currentThread().getName()+"\t"+number);
                condition.signalAll();
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                lock.unlock();
            }
        }
}
public class ProdConsumer_TraditionDemo {
    public static void main(String[] args) {
            ShareData shareData = new ShareData();
            new Thread(()->{
                for (int i = 0; i <5 ; i++) {
                    try {
                        shareData.inc();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            },"A").start();

            new Thread(()->{
                for (int i = 0; i <5 ; i++) {
                    try {
                        shareData.dec();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            },"B").start();
    }
}
