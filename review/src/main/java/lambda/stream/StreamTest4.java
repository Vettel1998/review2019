package lambda.stream;

import java.util.IntSummaryStatistics;
import java.util.UUID;
import java.util.stream.Stream;

public class StreamTest4 {
    public static void main(String[] args) {
        Stream<String> stream = Stream.generate(()->UUID.randomUUID().toString());
        stream.findFirst().ifPresent(System.out::println);
        Stream<Integer> stream1 = Stream.iterate(1,item->item+2).limit(10);
        //System.out.println(stream1.filter(i->i>2).mapToInt(i->i*2).skip(2).limit(2).sum());

        IntSummaryStatistics summaryStatistics = stream1.filter(i->i>2).mapToInt(i->i*2).skip(2).limit(2).summaryStatistics();
    }
}
