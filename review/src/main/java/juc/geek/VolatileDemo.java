package juc.geek;


import java.util.concurrent.TimeUnit;

class Mydata{
    volatile int a=0;
    public void setA(int data){
        a = data;
    }

}
public class VolatileDemo {

    public static void main(String[] args) {
         Mydata mydata = new Mydata();
         new Thread(()->{
             System.out.println(Thread.currentThread().getName()+"\t come in");
             try {
                 TimeUnit.SECONDS.sleep(3);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
             mydata.setA(20);
             System.out.println(Thread.currentThread().getName()+"\tupdate data "+mydata.a);
         }).start();

         while (mydata.a == 0){

         }
        System.out.println(Thread.currentThread().getName()+"\t mission over");
    }
}
