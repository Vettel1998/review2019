package javase.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("C","C++","C#","PHP","Python",null);
        //list.stream().filter(e->e!=null&&e.charAt(0)=='C').collect(Collectors.toList()).forEach(System.out::println);
        list.stream().filter(e->e!=null&&e.startsWith("C")).forEach(System.out::println);
    }
}
