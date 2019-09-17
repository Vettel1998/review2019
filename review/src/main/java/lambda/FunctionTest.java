package lambda;

import java.util.function.Function;

public class FunctionTest {
    public static void main(String[] args) {
        FunctionTest functionTest = new FunctionTest();
        functionTest.compute(1,e->e*2);
    }
    public int compute(int a, Function<Integer,Integer> function){
        int result = function.apply(a);
        return result;
    }
}
