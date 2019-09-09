package juc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class Mycache{
    private volatile Map<String,Object> map = new HashMap<>();
    private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();



    public void put(String key,Object value){
        rwLock.writeLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"\t 正在写入："+key);
            try{ TimeUnit.SECONDS.sleep(1);}catch(InterruptedException e){e.printStackTrace();}
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"\t 写入完成");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            rwLock.writeLock().unlock();
        }


    }


    public void get(String key){
        rwLock.readLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"\t 正在读取："+key);
            try{ TimeUnit.SECONDS.sleep(1);}catch(InterruptedException e){e.printStackTrace();}
            Object obj = map.get(key);
            System.out.println(Thread.currentThread().getName()+"\t 读取完成");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            rwLock.readLock().unlock();
        }

    }
}
/**
 * @author vettelx
 *
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        Mycache mycache = new Mycache();
            for(int i=0;i<5;i++){
                final int temp = i;
                new Thread(()->{
                    mycache.put(temp+"",temp+"");
                },String.valueOf(i)).start();
            }


            for(int i=0;i<5;i++){
                final int temp = i;
                new Thread(()->{
                    mycache.get(temp+"");
                },String.valueOf(i)).start();
            }
    }
}
