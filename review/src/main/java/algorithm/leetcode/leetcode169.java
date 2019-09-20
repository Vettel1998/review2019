package algorithm.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class leetcode169 {

    // too slow
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            if (map.containsKey(num))
                map.put(num,map.get(num)+1);
            else map.put(num,1);
        }
        return map.keySet().stream().filter(e->map.get(e)>nums.length/2).collect(Collectors.toList()).get(0);

    }

    // 排序
    public int majority2(int[] nums){
        int length = nums.length;
        Arrays.sort(nums);
        return nums[length/2];

    }

    // Boyer-Moore算法
    public int majority3(int[] nums){
        int n = nums.length,count=0,cdd=0;
        for(int i=0;i<n;i++){
            if(count==0) cdd=nums[i];
            if (nums[i] == cdd) {
                count++;
            } else {
                count--;
            }
            //用到count是统计相同的数字，当数字与candidate不同时，count--也就是相消了

        }
        return cdd;

    }


}
