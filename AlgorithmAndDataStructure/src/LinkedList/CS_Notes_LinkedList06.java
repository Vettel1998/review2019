package LinkedList;

/**
 * CS_Notes_LinkedList06. 交换链表中的相邻结点
 * leetcode24. Swap Nodes in Pairs (Medium)
 */
public class CS_Notes_LinkedList06 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy  = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while (pre.next!=null&&pre.next.next!=null){
            ListNode l1 = pre.next,l2 = pre.next.next;
            ListNode next = l2.next;
            l1.next = next;
            l2.next = l1;
            pre.next = l2;
            pre = l1;
        }

        return dummy.next;
    }


    public ListNode swapPairsRecur(ListNode head){
        if (head==null||head.next == null) return head;
        ListNode next = head.next;
        head.next = swapPairsRecur(next.next);
        next.next = head;
        return next;
    }
}
