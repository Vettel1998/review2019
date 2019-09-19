package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode989 {

    public static List<Integer> addToArrayForm(int[] A, int K) {
        String kList = new StringBuilder(K+"").reverse().toString();
        StringBuilder sb = new StringBuilder();
        for (int num:A){
            sb.append(num);
        }
        String aList = sb.reverse().toString();
        StringBuilder sb2 = new StringBuilder();
        int tmp = Math.max(kList.length(),aList.length());
        int count = 0;
        for (int i=0;i<tmp;i++){
            char a = '0';
            char k = '0';
            if (i<aList.length()) a = aList.charAt(i);
            if (i<kList.length()) k = kList.charAt(i);
            int sum = (a-'0')+(k-'0')+count;
            if (sum>=10){
                sum-=10;
                count = 1;
            }else count=0;
            sb2.append(sum);
        }
        if (count ==1)
            sb2.append(count);
        String result = sb2.reverse().toString();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <result.length() ; i++) {
            res.add(result.charAt(i)-'0');
        }
        return res;

    }

    public static void main(String[] args) {
        int[] A = {2,1,5};
        addToArrayForm(A,806);
        for (int i:addToArrayForm(A,806)){
            System.out.print(i);
        }

    }
}
