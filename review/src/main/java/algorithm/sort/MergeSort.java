package algorithm.sort;

import algorithm.Utils;

import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int[] nums){
        mergeSort(nums,0,nums.length-1);
    }
    private static void mergeSort(int[] nums,int low,int high){
        if (low>=high) return;
        int mid = low + (high-low)/2;           //int mid = (low+high)/2   low+high可能会溢出
        mergeSort(nums,low,mid);
        mergeSort(nums,mid+1,high);
        Utils.merge(nums,low,mid,high);
    }

    public static void main(String[] args) {
        int[] nums={3,2,1,1,6,5,4,2,3,1};
        mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
