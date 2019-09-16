package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Test1 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4);
        list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {

            }
        });
    }
}

