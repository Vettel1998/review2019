package BinarySearch;

public class LeetCode81 {
    public static boolean search(int[] nums, int target) {
        if (nums==null||nums.length == 0) return false;
        int low = 0;
        int high = nums.length-1;
        while (low<=high){
            int mid = low+((high-low)>>1);
            if (nums[mid]==target)
                return true;
            else if (nums[mid]<nums[high]){
                if (nums[mid]<target&&target<=nums[high]){
                    low = mid+1;
                }else high = mid-1;
            }else if (nums[mid]>nums[high]){
                if (target>=nums[low]&&nums[mid]>target){
                    high = mid-1;
                }else low = mid+1;
            }else high--;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {3,5,1};
        boolean search = search(a, 3);
        System.out.println(search);
    }
}
