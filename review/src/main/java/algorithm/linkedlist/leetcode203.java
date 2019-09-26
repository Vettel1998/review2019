package algorithm.linkedlist;

public class leetcode203 {
    public static ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;
        ListNode dummy = new ListNode(-1);
        ListNode ret = dummy;
        dummy.next = head;
        while (dummy.next!=null){
            if (dummy.next.val == val)
                dummy.next = dummy.next.next;
            else dummy = dummy.next;
        }
        return ret.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
    }
}
