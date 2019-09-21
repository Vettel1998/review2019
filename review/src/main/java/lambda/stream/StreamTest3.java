package lambda.stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest3 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4);
        list.stream().map(e->e*e).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("--------------");
        Stream<List<Integer>> stream = Stream.of(
                Collections.singletonList(1),Arrays.asList(1,2,3),Arrays.asList(1,3,5));
        stream.flatMap(Collection::stream).map(item->item*item).forEach(System.out::println);
    }
}
