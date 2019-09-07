package algorithm.dp;


//给定一个正整数s, 判断一个数组arr中，是否有一组数字加起来等于s
public class Exercise2 {


    public static boolean rec_sub(int[] arr , int i,int s){
        if(s == 0)
            return true;
        else if( i == 0)
            return arr[0] == s;
        else if( arr[i]>s)
            return rec_sub(arr,i-1,s);
        else
            return rec_sub(arr,i-1,s-arr[i])||rec_sub(arr,i-1,s);
    }
    public static  boolean dp_subSet(int[] arr,int s ){
        boolean[][] subset = new boolean[arr.length][s+1];
        for (int i= 0; i < subset.length; i++) {
            subset[i][0] = true;
        }
        for (int i = 0; i < subset[0].length; i++) {
            subset[0][i] = false;
        }

        subset[0][arr[0]] = true;


        for (int i = 1; i <arr.length; i++) {
            for (int j = 1; j <=s ; j++) {
                if(arr[i]>j)
                    subset[i][s] = subset[i-1][s];
                else
                    subset[i][s] = subset[i-1][s-arr[i]]||subset[i-1][s];
            }
        }

        return subset[arr.length-1][s];
    }
    public static void main(String[] args) {
            int[] arr = {3,34,4,12,5,2};
            System.out.println(rec_sub(arr,arr.length-1,9));
            System.out.println(dp_subSet(arr,9));
    }
}
