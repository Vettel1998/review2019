package javase.collection;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo {
    public static void main(String[] args) {
        Map<String,Integer> map = new LinkedHashMap<>();
        map.put("c",100);
        map.put("a",200);
        map.put("b",200);
        map.put("c",400);
        map.put("a",20);
        map.forEach((k,v)-> System.out.println(k+","+v));
        Map<String,Integer> map1 = new HashMap<>();
        map1.put("a",100);
        map1.put("c",200);
        map1.put("b",10);
        map1.forEach((k,v)-> System.out.println(k+","+v));
    }
}
