package Heap;

import java.util.PriorityQueue;

public class leetcode1046 {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(
                (o1, o2) -> o2-o1
        );
        for (int i:stones) {
            queue.offer(i);
        }
        while (queue.size()>1){
            int x  = queue.poll();
            int y = queue.poll();
            if (x!=y){
                queue.offer(x-y);
            }
        }

        return queue.size()>0?queue.peek():0;
    }
}
