package lambda.stream;

import java.util.Arrays;
import java.util.List;

public class StreamTest9 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello world","world hello","hello world hello","welcome hello");
        list.stream().flatMap(s-> Arrays.stream(s.split(" "))).distinct().forEach(System.out::println);
    }
}
