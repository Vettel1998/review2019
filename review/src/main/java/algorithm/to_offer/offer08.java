package algorithm.to_offer;

public class offer08 {
    public int JumpFloor(int target) {
     if ( target <= 1)
         return 1;

     return JumpFloor(target-1)+JumpFloor(target-2);
    }


    public int JumpFLoor_rec(int target){
        return Fibonacci.fib(target);
    }


}

