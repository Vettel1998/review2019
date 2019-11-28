package LinkedList;


/**
 * CS_Notes_LinkedList05. 删除链表的倒数第 n 个节点
 * leetcode19. Remove Nth Node From End of List (Medium)
 */
public class CS_Notes_LinkedList05 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i <n; i++) {
            fast = fast.next;
        }

        if (fast ==null) return head.next;

        while (fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
