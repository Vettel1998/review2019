package Heap;

import java.util.Arrays;
import java.util.PriorityQueue;


/**
 * leetcode703 数据流中的第K大元素
 */
class KthLargest {

    PriorityQueue<Integer> queue;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue<>(k);
        Arrays.stream(nums).forEach(e->queue.add(e));
    }

    public int add(int val) {
        if (queue.size()<k){
            queue.offer(val);
        }else if (queue.peek()<val){
            queue.poll();
            queue.offer(val);
        }

        return queue.peek();

    }
}
