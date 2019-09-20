package javase;

import java.math.BigDecimal;

public class BigDecimalDemo {
    public static void main(String[] args) {
        BigDecimal big1 = new BigDecimal(2.1+"");
        BigDecimal big2 = new BigDecimal(1.93+"");
        big1.subtract(big2);
        System.out.println(big1.subtract(big2));
    }
}
