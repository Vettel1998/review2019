package juc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class ContainerNotSafeDemo {
    public static void main(String[] args) {
//        List<String> list = Arrays.asList("a","b","c","d");
//        list.forEach(System.out::println);

        List<String> list = new ArrayList<>();

        List<String> list1 = Collections.synchronizedList(new ArrayList<>());

        List<String> list2 = new CopyOnWriteArrayList<>();


        for(int i=0;i<10;i++){
            new Thread(()->{
                list2.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list2);
            },String.valueOf(i)).start();
        }
    }
}
