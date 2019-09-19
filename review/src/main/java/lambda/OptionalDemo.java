package lambda;

import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        Optional<String> optional = Optional.of("hello");
        optional.ifPresent(System.out::println);
    }
}
