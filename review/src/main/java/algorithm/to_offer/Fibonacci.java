package algorithm.to_offer;

public class Fibonacci {
    public static int fib(int target){
        if (target < 2)
            return 1;
        int f0 = 1;
        int f1 = 1;
        int result = 0;
        for (int i = 2; i <=target; i++) {
            result = f0+f1;
            f0 = f1;
            f1 = result;
        }
        return result;
    }
}
