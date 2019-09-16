package algorithm.to_offer;

public class offer09 {

    // f(n) = 2f(n-1)

    public int JumpFloorII(int target) {
        int result = 1;
        for (int i = 2; i <=target ; i++) {
            result*=2;
        }

        return result;
    }
}
