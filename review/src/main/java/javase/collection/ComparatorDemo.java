package javase.collection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ComparatorDemo {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("bc","ab","123");
        list.sort(Comparator.comparingInt(s -> s.charAt(0)));
    }
}
