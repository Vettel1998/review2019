package algorithm.sort;

import algorithm.Utils;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] nums){
        quickSort(nums,0,nums.length-1);
    }

    private static void quickSort(int[] nums, int low, int high) {
        if (low>=high) return;
        int i = Utils.partition(nums,low,high);
        quickSort(nums,low,i-1);
        quickSort(nums,i+1,high);
    }


    public static void main(String[] args) {
        int[] nums = {3,2,2,1,4,5,1,2,3,6,2};
        quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }


}
