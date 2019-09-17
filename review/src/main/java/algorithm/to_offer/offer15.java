package algorithm.to_offer;

import algorithm.to_offer.offer03.ListNode;

public class offer15 {
    public ListNode ReverseList(ListNode head) {
        return getListNode(head);
    }

    static ListNode getListNode(ListNode head) {
        ListNode next = null;
        ListNode pre = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            pre  = head;
            head = next;
        }
        return pre;
    }
}
