package lambda.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest2 {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("hello","world","java");
        String[] strings = stream.toArray(String[]::new);

        List<String> stringList = stream.collect(Collectors.toList());

        stringList = stream.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }
}
