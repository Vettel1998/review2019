package lambda.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest1 {
    public static void main(String[] args) {
        Stream stream = Stream.of("world","hello","jdk");
        String[] arr = {"hello","world","test"};
        Stream stream1 = Arrays.stream(arr);

        IntStream.of(1,2,3,4).forEach(System.out::println);
        System.out.println("----------");
        IntStream.range(3,8).forEach(System.out::println);
        IntStream.rangeClosed(3,8).forEach(System.out::println);

        List<Integer> list = Arrays.asList(1,2,3,4,5);
        System.out.println(list.stream().map(e->e*2).reduce(0,Integer::sum));
    }
}
