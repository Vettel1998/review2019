package algorithm.sort;


import algorithm.Utils;

import java.util.Arrays;

/*
给定一个数组arr，和一个数num，
请把小于num的数放在数组的左边，等于num的数放在数组的中间，大于num的数放在数组的右边。
要求额外空间复杂度O(1)，时间复杂度O(N)
 */
public class DutchFlagProblem {
    public static void arrange(int[] nums,int target){
        int p1 =-1;
        int p2 = nums.length;
        for (int i=0;i!=p2;){
            if (nums[i]<target){
                Utils.swapInt(nums,i++,++p1);
            }else if (nums[i]>target){
                Utils.swapInt(nums,--p2,i);
            }else {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,6,5,4,3,1,2};
        arrange(nums,3);
        System.out.println(Arrays.toString(nums));
    }
}
