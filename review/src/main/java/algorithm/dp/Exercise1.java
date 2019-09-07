package algorithm.dp;

import java.util.Arrays;


// 在一个数组arr中，找出一组不相邻的数字，使得最后的和最大。
public class Exercise1 {
    public int rec_opt(int[] arr ,int i){
        if(i==0)
            return arr[0];
        else if(i == 1)
            return Math.max(arr[0],arr[1]);
        else
            return Math.max(rec_opt(arr,i-2)+arr[i],rec_opt(arr,i-1));
    }


    public  int[] dp_opt(int[] arr){
        int[] opt = new int[arr.length];
        opt[0] = arr[0];
        opt[1] = Math.max(opt[0],opt[1]);
        for (int j = 2; j <arr.length ; j++) {
            opt[j] = Math.max(opt[j-2]+arr[j],opt[j-1]);
        }
        return opt;
    }
    public static void main(String[] args) {
        Exercise1 exercise1 = new Exercise1();
        int[] arr = {4,1,1,9,1};
        System.out.println(exercise1.rec_opt(arr,4));
        System.out.println(Arrays.toString(exercise1.dp_opt(arr)));
    }
}
