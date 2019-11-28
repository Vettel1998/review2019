package NSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    /**
     *
     * leetcode 15
     *例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
     *
     * 满足要求的三元组集合为：
     * [
     *   [-1, 0, 1],
     *   [-1, -1, 2]
     * ]
     *
     */
    public static List<List<Integer>> threeSum(int[] nums,int target){
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i]>target/3) break;
            if (i>0&&nums[i]==nums[i-1]) continue;
            int j = i+1;
            int k = nums.length-1;
            while (j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if (sum >target){
                    while (j<k&&nums[k]==nums[--k]);
                }else if (sum<target){
                    while (j<k&&nums[j]==nums[++j]);
                }else {
                    res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    while (j<k&&nums[j]==nums[++j]);
                    while (j<k&&nums[k]==nums[--k]);
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {1,-1,-1,0};
        List<List<Integer>> lists = threeSum(nums, 0);
        lists.forEach(e->{
            e.forEach(item->System.out.print(item+" "));
            System.out.println();
        });
    }
}
