package algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode350 {
    //给定两个数组，编写一个函数来计算它们的交集。
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (int num:nums1){
            if (map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else map.put(num,1);
        }
        for (int num:nums2){
            if (map.containsKey(num)){
                int tmp = map.get(num);
                if (num == 1) map.remove(num);
                else map.put(num,tmp-1);
                res.add(num);
            }
        }
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }
}
