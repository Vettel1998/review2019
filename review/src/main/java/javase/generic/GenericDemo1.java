package javase.generic;

import java.util.*;

public class GenericDemo1 {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Double> list2 = Arrays.asList(1.0,2.0,3.0);
        m(list1);
        m(list2);
        System.out.println(list1.getClass());
        System.out.println(list2.getClass());

        Map<String,Integer> map = new HashMap<>();
        map.put("111",111);
        map.put("222",222);
        map.entrySet().forEach(e-> System.out.println(e.getKey()+e.getValue()));

    }

    public static void m(List<? extends Number> list){
        list.forEach(System.out::println);
    }
    public static void m(List<? super String> list,int i){

    }
}
