package NSum;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /**
     *
     * leetcode1
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     *
     */
    public int[] twoSum(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }


    /**
     *leetcode167
     * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
     *
     * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
     *
     *
     * 双指针法
     */
    public int[] twoSum2(int[] numbers,int target){
        int i = 0;
        int j = numbers.length-1;
        while (i<j){
            int sum = numbers[i]+numbers[j];
            if (sum == target)
                return new int[]{i,j};
            if (sum>target)
                j--;
            if (sum<target)
                i++;
        }

        return new int[]{-1,-1};
    }

}
