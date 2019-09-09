package algorithm.leetcode;



//165. Compare Version Numbers

import java.util.Arrays;

public class leetcode165 {

    public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("[.]");
        String[] v2 = version2.split("[.]");

        int loopEnd = v1.length > v2.length ? v1.length : v2.length;
        int val1, val2;

        for (int i = 0; i < loopEnd; i++) {

            if (i < v1.length)
                val1 = Integer.parseInt(v1[i]);
            else
                val1 = 0;

            if (i < v2.length)
                val2 = Integer.parseInt(v2[i]);
            else
                val2 = 0;

            if (val1 > val2)
                return 1;
            else if (val1 < val2)
                return -1;

        }

        return 0;



    }


    public static void main(String[] args) {
        String version1 = "1.000.0", version2 = "1.0.0";
        String[] v1 = version1.split("[.]");
        String[] v2 = version2.split("[.]");

        System.out.println(Arrays.toString(v1));

        //System.out.println(Integer.valueOf("01") == Integer.valueOf("1"));
        System.out.println( compareVersion(version1,version2));


    }
}
