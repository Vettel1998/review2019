package Heap;

import java.util.PriorityQueue;

/**
 * leetcode 295. 数据流的中位数
 */
public class MedianFinder {
    private PriorityQueue<Integer> maxHeap ;
    private PriorityQueue<Integer> minHeap;
    /** initialize your data structure here. */
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((o1,o2)->o2-o1);
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        maxHeap.add(num);
        minHeap.add(maxHeap.remove());
        if (minHeap.size() > maxHeap.size())
            maxHeap.add(minHeap.remove());
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size())
            return (maxHeap.element() + minHeap.element()) / 2.0;
        else
            return maxHeap.element();
    }
}
