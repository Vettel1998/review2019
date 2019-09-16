package lambda;

@FunctionalInterface
public interface MyInterface {
    void test();
    String toString();
    int hashCode();
}


class A implements MyInterface{

    @Override
    public void test() {

    }
}