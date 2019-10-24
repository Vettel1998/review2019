package algorithm.sort;

import java.util.Arrays;

public class CountingSort {

    public static void countingSort(int[] nums,int n ){
        if (n<=1) return;
        int max = nums[0];
        for (int i = 0; i <n ; i++) {
            if (nums[i]>max)
                max = nums[i];
        }

        int[] count = new int[max+1];
        for (int i = 0; i <n ; i++) {
            count[nums[i]]++;
        }
        for (int i = 1; i <=max; i++) {
            count[i]+=count[i-1];
        }

        int[] tmp = new int[nums.length];
        for (int i = nums.length-1; i >=0 ; i--) {
            int index = count[nums[i]]-1;
            tmp[index] = nums[i];
            count[nums[i]]--;
        }

        for (int i = 0; i <n ; i++) {
            nums[i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = {3,1,2,7,5,2,4,6,1};
        countingSort(nums,nums.length);
        System.out.println(Arrays.toString(nums));
    }
}
