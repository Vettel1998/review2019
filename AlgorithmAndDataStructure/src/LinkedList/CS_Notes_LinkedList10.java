package LinkedList;

/**
 * CS_Notes_LinkedList10. 链表元素按奇偶聚集
 * Leetcode328. Odd Even Linked List (Medium)
 */
public class CS_Notes_LinkedList10 {
    public ListNode oddEvenList(ListNode head) {
        if (head==null||head.next==null) return head;
        ListNode odd = head;
        ListNode evenHead = head.next;
        ListNode even = head.next;
        while (even!=null&&even.next!=null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

}
