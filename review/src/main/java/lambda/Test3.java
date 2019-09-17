package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test3 {
    public static void main(String[] args) {
//        IA ia = () -> {};
//        System.out.println(ia.getClass().getInterfaces()[0]);
        List<String> list = Arrays.asList("hello","world","lala");
        List<String> list2 = new ArrayList<>();
        list2 = list.stream().map(String::toUpperCase).collect(Collectors.toList());
        Function<String,String> f1 = String::toUpperCase;
    }
}

interface IA{
        void ma();
}
