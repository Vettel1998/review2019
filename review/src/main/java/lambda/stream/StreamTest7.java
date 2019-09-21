package lambda.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class StreamTest7 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i <5000000 ; i++) {
            list.add(UUID.randomUUID().toString());
        }
        long startTime = System.nanoTime();
        list.parallelStream().sorted().count();
        long endTime = System.nanoTime();
        long mills = TimeUnit.NANOSECONDS.toMillis(endTime-startTime);
        System.out.println(mills);
    }
}
