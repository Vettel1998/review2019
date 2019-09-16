package algorithm.to_offer;

public class offer10 {

    public int RectCover(int target) {
        if (target <=1)
            return target;
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
