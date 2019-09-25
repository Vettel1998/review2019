package javase;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("111",111);
        map.forEach((k,v)-> System.out.println(k+","+v));
        Iterator<String> stringIterator = map.keySet().iterator();
        while (stringIterator.hasNext()){
            String s = stringIterator.next();
            System.out.println(s+","+map.get(s));
        }
    }
}
