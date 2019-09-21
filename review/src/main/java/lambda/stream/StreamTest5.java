package lambda.stream;

import java.util.Arrays;
import java.util.List;

public class StreamTest5 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello","world","java");
        list.stream().map(
                item->{
                    String result = item.substring(0,1).toUpperCase()+item.substring(1);
                    System.out.println("test");
                    return result;
                }
        );
    }
}
