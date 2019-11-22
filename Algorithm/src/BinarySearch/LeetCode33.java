package BinarySearch;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别
 */
public class LeetCode33 {

    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        while (low<=high){
            int mid = low+((high-low)>>1);
            if (nums[mid]==target)
                return mid;
            else if (nums[mid]<nums[high]){
                if (nums[mid]<target&&target<=nums[high]){
                    low = mid+1;
                }else high = mid-1;
            }else {
                if (target>=nums[low]&&nums[mid]>target){
                    high = mid-1;
                }else low = mid+1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] a = {3,5,1};
        int res = search(a,3);
        System.out.println(res);
    }


}
