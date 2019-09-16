package algorithm.to_offer;

public class offer12 {
    public double Power(double base, int exponent) {
        if (base == 0)
            return 0.0;
        double result = 1;
        if(exponent<0){
            for (int i = 0; i < -exponent; i++) result /= base;
        }
        else {
            for (int i = 0; i <exponent ; i++) {
                result*=base;
            }
        }

        return result;
    }


}
