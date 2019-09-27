package javase.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        Iterator<String> iterator = list.iterator();
        for (String s: list){
            list.add("cc");
        }
        while (iterator.hasNext()){
            iterator.next();
            iterator.remove();
        }
        System.out.println(iterator.hasNext());
        System.out.println(list);
    }
}
