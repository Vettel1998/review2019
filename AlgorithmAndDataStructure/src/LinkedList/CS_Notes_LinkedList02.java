package LinkedList;

/**
 * CS_Notes 2. 链表反转
 * leetcode206. Reverse Linked List (Easy)
 *
 * 迭代/递归
 *
 */
public class CS_Notes_LinkedList02 {

    //三指针法
    public ListNode reverseList(ListNode head) {
        if (head == null||head.next==null)
            return head;

        ListNode cur = head;
        ListNode pre = null;
        ListNode next = null;
        while (cur!=null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }


    //递归
    public ListNode reverseListRecur(ListNode head){
       if(head == null||head.next == null) return  head;
        ListNode next = head.next;
        ListNode newHead = reverseListRecur(next);
        next.next = head;
        head.next = null;
        return newHead;
    }

    //头插法
    public ListNode reverseList2(ListNode head) {
        ListNode newHead = new ListNode(-1);
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead.next;
            newHead.next = head;
            head = next;
        }
        return newHead.next;
    }
}
