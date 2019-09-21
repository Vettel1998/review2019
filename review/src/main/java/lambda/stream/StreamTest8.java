package lambda.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest8 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello","world","helloworld");
        //list.stream().filter(s -> s.length()==5).findFirst().ifPresent(System.out::println);
        list.stream().mapToInt(item->{
            int length = item.length();
            System.out.println(item);
            return length;
        }).filter(len -> len==5).findFirst().ifPresent(System.out::println);
    }
}
