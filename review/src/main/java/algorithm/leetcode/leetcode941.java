package algorithm.leetcode;

public class leetcode941 {
    // too slow
    public boolean validMountainArray(int[] A) {
        if (A.length<3)
            return false;
        boolean flag = false;
        loop:for (int i = 1; i <A.length-1 ; i++) {
            for (int j = 0; j < i; j++) {
                if (A[j]>=A[j+1])
                    continue loop;
            }
            for (int j = i; j <A.length-1 ; j++) {
                if (A[j]<=A[j+1])
                    continue loop;
            }
            flag = true;
            break;
        }
        return flag;
    }

    public boolean validMountainArray2(int[] A) {

        int len = A.length;
        int i = 0;
        while (i+1<len&&A[i]<A[i+1])
            i++;
        if (i==0||i==len-1)
            return false;
        while (i+1<len&&A[i]>A[i+1])
            i++;
        return i==len-1;

    }

}
