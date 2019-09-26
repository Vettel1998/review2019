package algorithm.linkedlist;

public class leetcode82 {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = head;
        ListNode slow = dummy;
        while (fast!=null){
            if(fast.next == null || fast.val != fast.next.val){
                if (slow.next == fast){
                    slow = fast;
                }else slow.next = fast.next;
            }
            fast = fast.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        deleteDuplicates(head);
    }
}
