package Heap;

import LinkedList.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 */
public class Leetcode23 {


    // 最小堆
    public  ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode res = dummy;
        PriorityQueue<ListNode> queue = new PriorityQueue<>((Comparator.comparingInt(o -> o.val)));
        for (ListNode list : lists) {
            if (list != null) queue.offer(list);
        }
        while (!queue.isEmpty()) {
            ListNode poll = queue.poll();
            if (poll.next != null) queue.offer(poll.next);
            res.next = poll;
            res = res.next;
        }


        return dummy.next;
    }


    /*
        分治归并思想
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        if(lists.length == 0) return null;
        return solve(lists, 0, lists.length-1);
    }

    private ListNode solve(ListNode[] arr, int left, int right){
        if(left == right) return arr[left];

        int mid = (left + right) >> 1;
        ListNode lNode = solve(arr, left, mid);
        ListNode rNode = solve(arr, mid+1, right);

        return merge(lNode, rNode);
    }

    private ListNode merge(ListNode node1, ListNode node2){
        if(node1 == null) return node2;
        if(node2 == null) return node1;

        if(node1.val < node2.val){
            node1.next = merge(node1.next, node2);
            return node1;
        }else{
            node2.next = merge(node1, node2.next);
            return node2;
        }
    }



}
