package algorithm.stack;

import java.util.HashMap;
import java.util.Stack;

public class leetcode496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] result = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = nums2.length-1; i >=0 ; i--) {
            while (!stack.empty()&&stack.peek()<=nums2[i])
                stack.pop();
            map.put(nums2[i], stack.empty()?-1:stack.peek());
            stack.push(nums2[i]);
        }
        for (int i = 0; i <nums1.length ; i++) {
            result[i] = map.get(nums1[i]);
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
