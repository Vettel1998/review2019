package algorithm.leetcode;

import algorithm.to_offer.offer03.ListNode;

public class leetcode234 {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        ListNode next = null;
        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }

        if (fast!=null)
            slow = slow.next;
        while (slow!=null){
            if (slow.val!=pre.val)
                return false;
            slow = slow.next;
            pre = pre.next;
        }
        return true;
    }
}
