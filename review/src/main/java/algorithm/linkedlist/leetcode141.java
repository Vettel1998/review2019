package algorithm.linkedlist;


//给定一个链表，判断链表中是否有环
public class leetcode141 {
    public boolean hasCycle(ListNode head) {
        if (head == null||head.next == null)
            return false;
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null&& fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow)
                return true;
        }
        return false;
    }
}
