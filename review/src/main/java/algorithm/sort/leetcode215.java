package algorithm.sort;

import algorithm.Utils;

public class leetcode215 {
    public static int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums,k,0,nums.length-1);

    }

    private static int findKthLargest(int[] nums, int k, int low, int high) {

        int i = partition(nums,low,high);
        if (k==i-low+1) return nums[i];
        if (k>i-low+1){
            return findKthLargest(nums,k-i+low-1,i+1,high);
        }else return findKthLargest(nums,k,low,i-1);
    }

    private static int partition(int[] nums , int low,int high){
        int povit = nums[high];
        int i = low;
        for (int j = i; j <high ; j++) {
            if (nums[j]>=povit){
                Utils.swapInt(nums,i,j);
                i++;
            }
        }
        Utils.swapInt(nums,i,high);
        return i;
    }
    private static void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int res = findKthLargest(nums,4);
        System.out.println(res);
    }
}
