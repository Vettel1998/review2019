package juc;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Phone   implements  Runnable{
    public synchronized  void sendSMS() throws Exception{
        System.out.println(Thread.currentThread().getId()+"\t invoke sendSMS()");
        sendEmail();
    }

    public synchronized  void sendEmail() throws Exception{
        System.out.println(Thread.currentThread().getId()+"\t invoke sendEmail()");
    }

    Lock lock = new ReentrantLock();
    @Override
    public void run() {
        get();
    }


    public void get(){
        lock.lock();
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t invoke get()");
            set();
        }finally {
            lock.unlock();
            lock.unlock();
        }
    }

    public void set(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t invoke set()");
        }finally {
            lock.unlock();
        }
    }
}
public class ReenterLockDemo {
    public static void main(String[] args) throws Exception{
        Phone phone = new Phone();
        new Thread(()->{
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"t1").start();


        new Thread(() -> {
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"t2").start();


        try{
            TimeUnit.SECONDS.sleep(2);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        Thread t3 = new Thread(phone);
        Thread t4 = new Thread(phone);

        t3.start();
        t4.start();



    }
}
