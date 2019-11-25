package LinkedList;

/**
 * CS_Notes 2. 链表反转
 * leetcode206. Reverse Linked List (Easy)
 *
 * 迭代/递归
 *
 */
public class CS_Notes_LinkedList02 {
    public ListNode reverseList(ListNode head) {
        if (head == null||head.next==null)
            return head;

        ListNode cur = head;
        ListNode pre = null;
        while (cur!=null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    public ListNode reverseListRecur(ListNode head){
        if(head == null|| head.next == null) return head;
        ListNode next = head.next;
        ListNode newHead = reverseListRecur(next);
        next.next = head;
        head.next = null;
        return newHead;
    }
}
