package lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StringComparator {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("aa","bb","cc");
        list.sort(String::compareTo);
    }
}
