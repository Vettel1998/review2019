package lambda;

import java.util.function.Supplier;

public class SupplierDemo {
    public static void main(String[] args) {
        Supplier<Person> supplier = ()->new Person("xq",22);
        System.out.println(supplier.get().getUsername());
    }
}
