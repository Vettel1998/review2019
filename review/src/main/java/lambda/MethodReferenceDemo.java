package lambda;

import java.util.Arrays;
import java.util.List;

public class MethodReferenceDemo {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello","world","aaa");
        list.forEach(System.out::println);
    }
}
