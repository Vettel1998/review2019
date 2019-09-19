package lambda;

import java.util.function.BinaryOperator;

public class BinaryOperatorDemo {
    public static void main(String[] args) {
        BinaryOperatorDemo demo = new BinaryOperatorDemo();
        demo.compute(1,2, Integer::sum);
    }
    public int compute(int a,int b,BinaryOperator<Integer> binaryOperator){
        return binaryOperator.apply(a,b);
    }

}
