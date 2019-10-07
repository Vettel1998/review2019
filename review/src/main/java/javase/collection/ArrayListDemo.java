package javase.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>(){
            {
                add("aaa");
                add("bbb");
                add("ccc");
            }
        };


        char[] chars = {'a','b','c'};
        char[] chars1 = chars.clone();
        String s = Arrays.toString(chars1);
        System.out.println(s);
    }
}
