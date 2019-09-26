package algorithm.linkedlist;

public class leetcode142 {

    public ListNode detectCycle(ListNode head) {
        if (head == null)
            return null;
        ListNode intersec = getIntersec(head);
        if (intersec == null)
            return null;
        ListNode ptr1 = head;
        ListNode ptr2 = intersec;
        while (ptr1!=ptr2){
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return ptr1;
    }

    private ListNode getIntersec(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow)
                return fast;

        }
        return null;
    }
}
