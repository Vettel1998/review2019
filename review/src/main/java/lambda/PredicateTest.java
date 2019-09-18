package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateTest {
    public static void main(String[] args) {
        PredicateTest test = new PredicateTest();
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        System.out.println(test.isEqual("abc").test("abc"));
    }

    public void conditionFilter(List<Integer> list, Predicate<Integer> predicate){
        list.stream().filter(predicate).collect(Collectors.toList());
    }
    public Predicate<String> isEqual(Object obj){
        return Predicate.isEqual(obj);
    }
}
