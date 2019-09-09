package juc;

import java.util.Objects;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(6);
        for(int i=1;i<=6;i++){
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t 国,被灭");
                countDownLatch.countDown();
            }, Objects.requireNonNull(CountryEnum.forEach_CountryEnum(i)).getRetMessage()).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t 秦灭六国");

    }
}
