package algorithm.to_offer;

import java.util.Objects;

public class offer11 {
    public int NumberOf1(int n) {
        int result = 0 ;
        for (int i = 0; i <32 ; i++) {
            if((n>>i& 1 ) != 0 )
                result++;
        }
        return result;
    }


}



